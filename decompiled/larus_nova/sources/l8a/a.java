package l8a;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import com.alibaba.gaiax.template.GXTemplateKey;
import com.bytedance.mt.protector.impl.string2number.CastFloatProtector;
import com.facebook.cache.common.CacheKey;
import com.facebook.cache.common.SimpleCacheKey;
import com.facebook.common.references.CloseableReference;
import com.facebook.drawee.drawable.ScalingUtils;
import com.facebook.imagepipeline.bitmaps.PlatformBitmapFactory;
import com.facebook.imagepipeline.request.BasePostprocessor;
import com.lynx.tasm.base.LLog;
import com.lynx.tasm.ui.image.o;
import com.lynx.tasm.utils.i;
import u7a.k;
import u7a.m;

/* JADX INFO: loaded from: classes32.dex */
public class a extends BasePostprocessor {
    private Bitmap.Config mBitmapConfig;
    private float[] mBorderRadii;
    private SimpleCacheKey mCacheKey;
    private String[] mCapInsets;
    private float mCapInsetsScale;
    private int mHeight;
    private int mPaddingBottom;
    private int mPaddingLeft;
    private int mPaddingRight;
    private int mPaddingTop;
    private ScalingUtils.ScaleType mScaleType;
    private int mWidth;

    private void adjustPaddings() {
        int r100 = this.mPaddingLeft;
        int r101 = this.mPaddingRight;
        int r102 = r100 + r101;
        int r103 = this.mWidth;
        if (r102 <= r103) goto L6;
        if (r103 <= 0) goto L6;
        float r104 = r103 / (r100 + r101);
        this.mPaddingLeft = (int) (r100 * r104);
        this.mPaddingRight = (int) (r101 * r104);
    L6:
        int r105 = this.mPaddingTop;
        int r106 = this.mPaddingBottom;
        int r107 = r105 + r106;
        int r108 = this.mHeight;
        if (r107 <= r108) goto L11;
        if (r108 <= 0) goto L12;
        float r109 = r108 / (r105 + r106);
        this.mPaddingTop = (int) (r105 * r109);
        this.mPaddingBottom = (int) (r106 * r109);
        return;
    L12:
        return;
    }

    @Override // com.facebook.imagepipeline.request.BasePostprocessor, com.facebook.imagepipeline.request.Postprocessor
    public CacheKey getPostprocessorCacheKey() {
        return this.mCacheKey;
    }

    private float ceil(float r100) {
        return (float) Math.ceil(r100);
    }

    private static String[] getCapInsetsArr(String r100) {
        if (r100 != null) goto L5;
        return null;
    L5:
        if (r100.equalsIgnoreCase("") == true) goto L41;
        String[] r101 = r100.split(" ");
        if (r101.length > 4) goto L39;
        int r102 = 0;
        boolean r103 = true;
    L11:
        if (r102 >= Math.min(r101.length, 4)) goto L30;
        if (r101[r102].endsWith(GXTemplateKey.GAIAX_PX) == true) goto L18;
        if (r101[r102].endsWith(GXTemplateKey.GAIAX_PE) == true) goto L18;
    L16:
        r103 = false;
    L29:
        r102 = r102 + 1;
    L18:
        if (r101[r102].endsWith(GXTemplateKey.GAIAX_PX) == false) goto L24;
        if (r101[r102].length() <= 2) goto L16;
        String r104 = r101[r102];
        r103 = r104.substring(0, r104.length() - 2).matches("[+]?[0-9]*\\.?[0-9]+");
        goto L29
    L24:
        if (r101[r102].endsWith(GXTemplateKey.GAIAX_PE) == false) goto L29;
        if (r101[r102].length() <= 1) goto L16;
        String r105 = r101[r102];
        r103 = r105.substring(0, r105.length() - 1).matches("[+]?[0-9]*\\.?[0-9]+");
        goto L29
    L30:
        if (r103 == true) goto L32;
        return null;
    L32:
        return r101;
    L39:
        return null;
    L41:
        return null;
    }

    private static float getCapInsetsScale(String r100) {
        if (r100 != null) goto L5;
        return 1.0f;
    L5:
        if (r100.equalsIgnoreCase("") == true) goto L15;
        return CastFloatProtector.parseFloat(r100);
    L9:
        th = move-exception;
        LLog.w("BaseRoundedCornerPostprocessor", "initCapInsetsScale error " + th.getMessage());
        return 1.0f;
    L15:
        return 1.0f;
    }

    private static m.b getScaleType(ScalingUtils.ScaleType r100) {
        m.f r101 = m.b.f549123a;
        if (r100 != ScalingUtils.ScaleType.FIT_XY) goto L6;
        return r101;
    L6:
        if (r100 != ScalingUtils.ScaleType.FIT_CENTER) goto L9;
        return m.b.f549124b;
    L9:
        if (r100 != ScalingUtils.ScaleType.CENTER_CROP) goto L12;
        return m.b.f549126d;
    L12:
        if (r100 == ScalingUtils.ScaleType.CENTER) goto L14;
        return r101;
    L14:
        return m.b.f549125c;
    }

    private void initCapInsets(String r100) {
        this.mCapInsets = getCapInsetsArr(r100);
    }

    private void initCapInsetsScale(String r100) {
        this.mCapInsetsScale = getCapInsetsScale(r100);
    }

    @Override // com.facebook.imagepipeline.request.BasePostprocessor, com.facebook.imagepipeline.request.Postprocessor
    public CloseableReference<Bitmap> process(Bitmap r100, PlatformBitmapFactory r101) {
        Bitmap.Config r102 = this.mBitmapConfig;
        if (r102 != null) goto L37;
        r102 = r100.getConfig();
    L37:
        int r103 = this.mWidth;     // Catch: Throwable -> L23
        int r104 = this.mHeight;     // Catch: Throwable -> L23
        if (r102 != null) goto L11;
        r102 = BasePostprocessor.FALLBACK_BITMAP_CONFIGURATION;     // Catch: Throwable -> L23
    L11:
        CloseableReference<Bitmap> r105 = r101.createBitmapInternal(r103, r104, r102);     // Catch: Throwable -> L23
    L21:
        th = th;
    L33:
        LLog.e("BaseRoundedCornerPostprocessor", "process image error " + th.getMessage());     // Catch: Throwable -> L29
        if (r105 == null) goto L28;
        CloseableReference.closeSafely(r105);
    L28:
        return null;
    L29:
        th = move-exception;
        if (r105 == null) goto L32;
        CloseableReference.closeSafely(r105);
    L32:
        throw th;
    L14:
        if (this.mCapInsets != null) goto L16;
        LLog.i("Lynx Image Processor", "process image from Fresco without cap-insets");     // Catch: Throwable -> L21
        transform(r105.get(), r100);     // Catch: Throwable -> L21
    L17:
        CloseableReference<Bitmap> r106 = CloseableReference.cloneOrNull(r105);     // Catch: Throwable -> L21
        if (r105 == null) goto L20;
        CloseableReference.closeSafely(r105);
    L20:
        return r106;
    L16:
        LLog.i("Lynx Image Processor", "process image from Fresco with cap-insets");     // Catch: Throwable -> L21
        transformWithCapInsets(r105.get(), r100);     // Catch: Throwable -> L21
    L23:
        th = th;
        r105 = null;
        goto L33
    }

    public void transform(Bitmap r210, Bitmap r211) {
        int r100 = this.mWidth;
        if (r100 == 0) goto L36;
        int r101 = this.mHeight;
        if (r101 == 0) goto L37;
        Canvas r102 = getInitCanvas(r210, r100, r101);
        Matrix r110 = new Matrix();
        Paint r103 = new Paint(1);
        int r104 = this.mPaddingLeft;
        float r105 = r104;
        int r106 = this.mPaddingTop;
        float r107 = r106;
        float r108 = (r100 - r104) - this.mPaddingRight;
        float r109 = (r101 - r106) - this.mPaddingBottom;
        float r111 = r211.getWidth();
        float r112 = r211.getHeight();
        Matrix r113 = o.a(this.mScaleType).getTransform(r110, new Rect(this.mPaddingLeft, this.mPaddingTop, r100 - this.mPaddingRight, r101 - this.mPaddingBottom), (int) r111, (int) r112, 0.0f, 0.0f);
        ScalingUtils.ScaleType r114 = this.mScaleType;
        if (r114 != ScalingUtils.ScaleType.FIT_CENTER) goto L15;
        float r115 = r108 / r111;
        float r116 = r109 / r112;
        if (r115 <= r116) goto L12;
        float r117 = r111 * r116;
        r105 = r105 + ((r108 - r117) / 2.0f);
        r108 = r117;
    L13:
        float r118 = r108;
        float r119 = r105;
        float r120 = r109;
    L17:
        float r121 = r107;
        boolean r122 = true;
        boolean r123 = true;
    L19:
        r103.setFilterBitmap(r123);
        RectF r124 = new RectF(Math.min(this.mPaddingLeft, r100), Math.min(this.mPaddingTop, r101), r100 - this.mPaddingRight, r101 - this.mPaddingBottom);
        float r125 = r124.right;
        float r126 = r124.left;
        if (r125 >= r126) goto L22;
        r124.right = r126;
    L22:
        float r127 = r124.bottom;
        float r128 = r124.top;
        if (r127 >= r128) goto L25;
        r124.bottom = r128;
    L25:
        Path r129 = new Path();
        float[] r130 = this.mBorderRadii;
        if (r130 != null) goto L28;
    L30:
        r129.addRect(r124, Path.Direction.CW);
    L31:
        r102.drawPath(r129, r103);
        r103.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
        r102.drawBitmap(r211, r113, r103);
        if (r122 == true) goto L34;
        return;
    L34:
        r103.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
        float r131 = r100;
        r102.drawRect(0.0f, 0.0f, r131, ceil(r121), r103);
        float r132 = r120 + r121;
        r102.drawRect(0.0f, (int) r132, r131, r101, r103);
        float r133 = (int) r121;
        r102.drawRect(0.0f, r133, ceil(r119), ceil(r132), r103);
        r102.drawRect((int) (r119 + r118), r133, r131, ceil(r132), r103);
        return;
    L28:
        if (r130.length != 8) goto L30;
        r129.addRoundRect(r124, new float[]{Math.max(r130[0] - this.mPaddingLeft, 0.0f), Math.max(this.mBorderRadii[1] - this.mPaddingTop, 0.0f), Math.max(this.mBorderRadii[2] - this.mPaddingRight, 0.0f), Math.max(this.mBorderRadii[3] - this.mPaddingTop, 0.0f), Math.max(this.mBorderRadii[4] - this.mPaddingRight, 0.0f), Math.max(this.mBorderRadii[5] - this.mPaddingBottom, 0.0f), Math.max(this.mBorderRadii[6] - this.mPaddingLeft, 0.0f), Math.max(this.mBorderRadii[7] - this.mPaddingBottom, 0.0f)}, Path.Direction.CW);
        goto L31
    L12:
        float r134 = r112 * r115;
        r107 = r107 + ((r109 - r134) / 2.0f);
        r109 = r134;
        goto L13
    L15:
        if (r114 != ScalingUtils.ScaleType.CENTER) goto L18;
        float r135 = i.b(1.0f, 0.0f);
        float r136 = r111 * r135;
        float r137 = r135 * r112;
        float r138 = Math.round((r108 - r136) * 0.5f);
        r107 = Math.round((r109 - r137) * 0.5f);
        r118 = r136;
        r119 = r138;
        r120 = r137;
        goto L17
    L18:
        r122 = false;
        r123 = true;
        r118 = 0.0f;
        r119 = 0.0f;
        r120 = 0.0f;
        r121 = 0.0f;
        goto L19
    L37:
        return;
    }

    public void transformWithCapInsets(Bitmap r310, Bitmap r311) {
        int r100 = this.mWidth;
        if (r100 == 0) goto L24;
        int r101 = this.mHeight;
        if (r101 == 0) goto L25;
        Canvas r102 = getInitCanvas(r310, r100, r101);
        r102.clipRect(this.mPaddingLeft, this.mPaddingTop, r100 - this.mPaddingRight, r101 - this.mPaddingBottom);
        r102.drawARGB(0, 0, 0, 0);
        Paint r103 = new Paint(1);
        int r104 = this.mPaddingLeft;
        float r105 = r104;
        int r110 = this.mPaddingTop;
        float r111 = r110;
        float r106 = (r100 - r104) - this.mPaddingRight;
        float r107 = (r101 - r110) - this.mPaddingBottom;
        float r108 = r311.getWidth();
        float r112 = r311.getHeight();
        int r113 = (int) r108;
        int r114 = (int) r112;
        float[] r115 = getFloatCapInsetsArr(this.mCapInsets, r113, r114);
        float r116 = r115[3];
        float r109 = this.mCapInsetsScale;
        Rect r117 = new Rect(0, 0, (int) (r116 * r109), (int) (r109 * r115[0]));
        Rect r118 = new Rect(r117.right, r117.top, (int) (r108 - (r115[1] * this.mCapInsetsScale)), r117.bottom);
        Rect r119 = new Rect(r118.right, r117.top, r113, r117.bottom);
        Rect r120 = new Rect(r117.left, r117.bottom, r117.right, (int) (r112 - (r115[2] * this.mCapInsetsScale)));
        Rect r121 = new Rect(r120.right, r120.top, r118.right, r120.bottom);
        Rect r122 = new Rect(r121.right, r120.top, r119.right, r120.bottom);
        Rect r123 = new Rect(r120.left, r120.bottom, r120.right, r114);
        Rect r124 = new Rect(r123.right, r123.top, r121.right, r123.bottom);
        Rect r125 = new Rect(r124.right, r123.top, r122.right, r123.bottom);
        Rect r126 = new Rect();
        Rect r127 = new Rect();
        Rect r128 = new Rect();
        Rect r129 = new Rect();
        Rect r130 = new Rect();
        Rect r131 = new Rect();
        Rect r132 = new Rect();
        Rect r133 = new Rect();
        Rect r134 = new Rect();
        float r312 = r106 / r108;
        float r313 = r107 / r112;
        ScalingUtils.ScaleType r135 = this.mScaleType;
        if (r135 != ScalingUtils.ScaleType.FIT_CENTER) goto L15;
        if (r312 <= r313) goto L12;
    L11:
        float r136 = r108 * r313;
        r105 = r105 + ((r106 - r136) / 2.0f);
        r106 = r136;
    L22:
        int r137 = (int) r105;
        r126.left = r137;
        int r138 = (int) r111;
        r126.top = r138;
        r126.right = (int) (i.b(r115[3], 0.0f) + r105);
        r126.bottom = (int) (i.b(r115[0], 0.0f) + r111);
        r127.left = r126.right;
        r127.top = r126.top;
        int r139 = (int) ((r105 + r106) - i.b(r115[1], 0.0f));
        r127.right = r139;
        r127.bottom = r126.bottom;
        r128.left = r139;
        r128.top = r126.top;
        r128.right = r137 + ((int) r106);
        r128.bottom = r126.bottom;
        r129.left = r126.left;
        r129.top = r126.bottom;
        r129.right = r126.right;
        int r140 = (int) ((r111 + r107) - ((int) i.b(r115[2], 0.0f)));
        r129.bottom = r140;
        r130.left = r129.right;
        r130.top = r129.top;
        int r141 = r127.right;
        r130.right = r141;
        r130.bottom = r140;
        r131.left = r141;
        r131.top = r128.bottom;
        r131.right = r128.right;
        r131.bottom = r129.bottom;
        r132.left = r126.left;
        r132.top = r129.bottom;
        int r142 = r129.right;
        r132.right = r142;
        int r143 = r138 + ((int) r107);
        r132.bottom = r143;
        r133.left = r142;
        r133.top = r130.bottom;
        int r144 = r130.right;
        r133.right = r144;
        r133.bottom = r143;
        r134.left = r144;
        r134.top = r131.bottom;
        r134.right = r131.right;
        r134.bottom = r143;
        r102.drawBitmap(r311, r117, r126, r103);
        r102.drawBitmap(r311, r118, r127, r103);
        r102.drawBitmap(r311, r119, r128, r103);
        r102.drawBitmap(r311, r120, r129, r103);
        r102.drawBitmap(r311, r121, r130, r103);
        r102.drawBitmap(r311, r122, r131, r103);
        r102.drawBitmap(r311, r123, r132, r103);
        r102.drawBitmap(r311, r124, r133, r103);
        r102.drawBitmap(r311, r125, r134, r103);
        return;
    L12:
        float r145 = r112 * r312;
        r111 = r111 + ((r107 - r145) / 2.0f);
    L13:
        r107 = r145;
        goto L22
    L15:
        if (r135 != ScalingUtils.ScaleType.CENTER_CROP) goto L20;
        if (r312 <= r313) goto L11;
    L20:
        if (r135 != ScalingUtils.ScaleType.CENTER) goto L22;
        float r146 = i.b(1.0f, 0.0f);
        float r147 = r108 * r146;
        r145 = r112 * r146;
        r105 = Math.round((r106 - r147) * 0.5f);
        r111 = Math.round((r107 - r145) * 0.5f);
        r106 = r147;
        goto L13
    L25:
        return;
    }

    private static float[] getFloatCapInsetsArr(String[] r100, int r101, int r102) {
        if (r100 != null) goto L4;
        return null;
    L4:
        if (r100.length > 4) goto L28;
        float[] r103 = {0.0f, 0.0f, 0.0f, 0.0f};
        int r104 = 0;
    L8:
        if (r104 >= r100.length) goto L20;
        if (r100[r104].endsWith(GXTemplateKey.GAIAX_PX) == false) goto L13;
        String r105 = r100[r104];
        r103[r104] = CastFloatProtector.parseFloat(r105.substring(0, r105.length() - 2));
    L19:
        r104 = r104 + 1;
        goto L8
    L13:
        if (r100[r104].endsWith(GXTemplateKey.GAIAX_PE) == false) goto L19;
        if (r104 == 0) goto L18;
        if (r104 == 2) goto L18;
        String r106 = r100[r104];
        r103[r104] = CastFloatProtector.parseFloat(r106.substring(0, r106.length() - 2)) * r101;
    L18:
        String r107 = r100[r104];
        r103[r104] = CastFloatProtector.parseFloat(r107.substring(0, r107.length() - 2)) * r102;
        goto L19
    L20:
        return r103;
    L28:
        return null;
    }

    private Canvas getInitCanvas(Bitmap r100, int r101, int r102) {
        Canvas r103 = new Canvas(r100);
        r103.clipRect(this.mPaddingLeft, this.mPaddingTop, r101 - this.mPaddingRight, r102 - this.mPaddingBottom);
        r103.drawARGB(0, 0, 0, 0);
        return r103;
    }

    public void updateCacheKey(String r100, float[] r101, ScalingUtils.ScaleType r102, boolean r103) {
        StringBuilder r104 = new StringBuilder("");
        if (r103 == true) goto L5;
        r104.append(r100);
    L5:
        r104.append(r102);
        if (r101 == null) goto L10;
        int r105 = r101.length;
        int r106 = 0;
    L8:
        if (r106 >= r105) goto L10;
        r104.append(r101[r106]);
        r106 = r106 + 1;
    L10:
        r104.append(this.mPaddingBottom);
        r104.append(this.mPaddingTop);
        r104.append(this.mPaddingLeft);
        r104.append(this.mPaddingRight);
        r104.append(this.mScaleType);
        String[] r107 = this.mCapInsets;
        if (r107 == null) goto L13;
        r104.append(r107);
        r104.append(this.mCapInsetsScale);
    L13:
        r104.append(this.mBitmapConfig);
        this.mCacheKey = new SimpleCacheKey(r104.toString());
    }

    public static Matrix getMatrix(int r100, int r101, int r102, int r103, ScalingUtils.ScaleType r104) {
        return k.e(r100, r101, r102, r103, getScaleType(r104));
    }

    public static boolean customDraw(int r110, int r111, int r112, int r113, ScalingUtils.ScaleType r114, String r115, String r116, Canvas r117, Bitmap r118) {
        return k.a(r110, r111, r112, r113, getScaleType(r114), r115, r116, r117, r118, 255);
    }

    public a(String r110, int r111, int r112, int r113, int r114, int r210, int r211, float[] r212, ScalingUtils.ScaleType r213, String r214, String r215, Bitmap.Config r216) {
        this(r110, r111, r112, r113, r114, r210, r211, r212, r213, r214, r215, r216, false);
    }

    public a(String r100, int r101, int r102, int r103, int r104, int r105, int r106, float[] r107, ScalingUtils.ScaleType r110, String r111, String r112, Bitmap.Config r113, boolean r114) {
        this.mBitmapConfig = null;
        this.mScaleType = r110;
        this.mWidth = r101;
        this.mHeight = r102;
        this.mPaddingLeft = r103;
        this.mPaddingTop = r104;
        this.mPaddingRight = r105;
        this.mPaddingBottom = r106;
        this.mBorderRadii = r107;
        initCapInsets(r111);
        initCapInsetsScale(r112);
        this.mBitmapConfig = r113;
        updateCacheKey(r100, r107, r110, r114);
        adjustPaddings();
    }
}
