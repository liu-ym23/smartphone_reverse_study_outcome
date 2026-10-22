package m8a;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapRegionDecoder;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.Shader;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import com.bytedance.mt.protector.impl.UriProtector;
import com.facebook.binaryresource.FileBinaryResource;
import com.facebook.cache.common.CacheKey;
import com.facebook.cache.common.SimpleCacheKey;
import com.facebook.common.memory.PooledByteBufferInputStream;
import com.facebook.common.references.CloseableReference;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.drawable.ScalingUtils;
import com.facebook.imagepipeline.core.ImagePipeline;
import com.facebook.imagepipeline.image.CloseableImage;
import com.facebook.imagepipeline.image.CloseableStaticBitmap;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.imagepipeline.request.ImageRequestBuilder;
import com.lynx.tasm.base.LLog;
import com.lynx.tasm.ui.image.n;
import com.lynx.tasm.utils.DisplayMetricsHolder;
import com.ss.android.ugc.bytex.pthread.base.PThreadExecutorsUtils;
import com.ss.android.ugc.bytex.thread_rename.base.DefaultThreadFactory;
import java.io.IOException;
import java.io.InputStream;
import java.util.LinkedList;

/* JADX INFO: loaded from: classes32.dex */
public final class d {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final int f512500f = 0;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final int f512501g = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final b f512502a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public c f512503b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Handler f512504c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f512505d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f512506e;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f512507a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final float f512508b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final float f512509c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final boolean f512510d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final ScalingUtils.ScaleType f512511e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final String f512512f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final Point f512513g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final String f512514h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public final String f512515i;

        public a(int r100, float r101, float r102, boolean r103, ScalingUtils.ScaleType r104, String r105, Point r106, String r107, String r108) {
            this.f512507a = r100;
            this.f512508b = r101;
            this.f512509c = r102;
            this.f512510d = r103;
            this.f512511e = r104;
            this.f512512f = r105;
            this.f512513g = new Point(r106.x, r106.y);
            this.f512514h = r107;
            this.f512515i = r108;
        }
    }

    public interface b {
        void onImageLoadFailed(String r100);

        void onImageLoadSuccess(c r100);
    }

    public static class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f512516a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public Rect f512517b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public Rect f512518c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public Bitmap f512519d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public boolean f512520e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final a f512521f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public CloseableReference<CloseableImage> f512522g;

        public final void a() {
            Bitmap r100 = this.f512519d;
            if (r100 != null) goto L5;
        L9:
            CloseableReference<CloseableImage> r101 = this.f512522g;
            if (r101 == null) goto L13;
            r101.close();
            return;
        L13:
            return;
        L5:
            if (r100.isRecycled() == true) goto L9;
            if (this.f512520e == true) goto L9;
            this.f512519d.recycle();
            this.f512519d = null;
            goto L9
        }

        public c(a r100) {
            this.f512516a = 1;
            this.f512517b = null;
            this.f512518c = null;
            this.f512519d = null;
            this.f512520e = true;
            this.f512522g = null;
            this.f512521f = r100;
        }
    }

    static {
        f512500f = Math.min(3379, 3379);
        f512501g = Math.min(3379, 3379);
    }

    public final void f() {
        c r100 = this.f512503b;
        if (r100 == null) goto L5;
        r100.a();
    L5:
        this.f512503b = null;
    }

    public static void d(PooledByteBufferInputStream r100) {
        if (r100 == null) goto L10;
        r100.close();     // Catch: IOException -> L5
        return;
    L5:
        e = move-exception;
        e.printStackTrace();
        return;
    }

    public static Point l(Canvas r100) {
        return new Point(Math.min(r100.getMaximumBitmapWidth(), f512500f), Math.min(r100.getMaximumBitmapHeight(), f512501g));
    }

    public final void o(c r100) {
        if (r100 == null) goto L24;
        Bitmap r101 = r100.f512519d;
        if (r101 != null) goto L6;
        return;
    L6:
        if (r101.isRecycled() == false) goto L9;
        return;
    L9:
        if (r100.f512521f.f512507a == this.f512505d) goto L12;
        r100.a();
        return;
    L12:
        c r102 = this.f512503b;
        if (r102 == null) goto L20;
        Bitmap r103 = r102.f512519d;
        if (r103 == null) goto L20;
        if (r103.getWidth() < r100.f512519d.getWidth()) goto L19;
        return;
    L19:
        if (this.f512503b.f512519d.getHeight() < r100.f512519d.getHeight()) goto L20;
        return;
    L20:
        f();
        this.f512503b = r100;
        b r104 = this.f512502a;
        if (r104 == null) goto L28;
        r104.onImageLoadSuccess(r100);
        return;
    L28:
        return;
    }

    public d(b r100, int r101) {
        this.f512506e = false;
        this.f512502a = r100;
        this.f512504c = new Handler(Looper.getMainLooper());
        this.f512505d = r101;
    }

    public static c b(d r100, a r101) {
        r100.getClass();
        if (r101 != null) goto L5;
        return null;
    L5:
        if (TextUtils.isEmpty(r101.f512512f) == true) goto L35;
        FileBinaryResource r102 = (FileBinaryResource) Fresco.getImagePipelineFactory().getMainFileCache().getResource(new SimpleCacheKey(r101.f512512f));
        if (r102 == null) goto L14;
        if (r102.getFile() == null) goto L14;
        String r103 = null;
    L20:
        if (r103 == null) goto L30;
    L22:
        BitmapRegionDecoder r104 = BitmapRegionDecoder.newInstance(r103, false);     // Catch: Throwable -> L27
        BitmapFactory.Options r105 = new BitmapFactory.Options();     // Catch: Throwable -> L27
        c r106 = r100.m(r101, r104.getWidth(), r104.getHeight());     // Catch: Throwable -> L27
        if (r106 == null) goto L25;
        r105.inSampleSize = r106.f512516a;     // Catch: Throwable -> L27
        r105.inPreferredConfig = Bitmap.Config.ARGB_8888;     // Catch: Throwable -> L27
        r106.f512519d = r104.decodeRegion(r106.f512517b, r105);     // Catch: Throwable -> L27
        r106.f512520e = false;     // Catch: Throwable -> L27
    L25:
        r104.recycle();     // Catch: Throwable -> L27
        return r106;
    L27:
        th = move-exception;
        th.printStackTrace();
        return null;
    L30:
        r103 = r102.getFile().getPath();     // Catch: Throwable -> L27
    L14:
        if (r100.f512506e == false) goto L33;
        int r107 = r101.f512512f.indexOf("://");
        String r108 = r101.f512512f;
        if (r107 <= 0) goto L18;
        int r109 = r107 + 3;
    L19:
        r103 = r108.substring(r109);
        goto L20
    L18:
        r109 = 0;
        goto L19
    L33:
        return null;
    L35:
        return null;
    }

    public final void k(Canvas r100, c r101) {
        if (r101 == null) goto L18;
        Bitmap r102 = r101.f512519d;
        if (r102 != null) goto L6;
        return;
    L6:
        if (r102.isRecycled() == true) goto L22;
        Paint r103 = new Paint();
        r103.setAntiAlias(true);
        r103.setFilterBitmap(true);
        a r104 = r101.f512521f;
        if (r104.f512511e == ScalingUtils.ScaleType.FIT_CENTER) goto L11;
    L13:
        Matrix r105 = new Matrix();
        Rect r106 = this.f512503b.f512518c;
        r105.preTranslate(r106.left, r106.top);
        c r107 = this.f512503b;
        if (r107.f512520e == false) goto L16;
        Rect r108 = r107.f512518c;
        float r109 = (r108.right - r108.left) * 1.0f;
        Rect r110 = r107.f512517b;
        r105.postScale(r109 / (r110.right - r110.left), ((r108.bottom - r108.top) * 1.0f) / (r110.bottom - r110.top));
        r100.drawBitmap(this.f512503b.f512519d, r105, r103);
        return;
    L16:
        Rect r111 = r107.f512518c;
        float r112 = ((r111.right - r111.left) * 1.0f) / r107.f512519d.getWidth();
        c r113 = this.f512503b;
        Rect r114 = r113.f512518c;
        r105.postScale(r112, ((r114.bottom - r114.top) * 1.0f) / r113.f512519d.getHeight());
        r100.drawBitmap(this.f512503b.f512519d, r105, r103);
        return;
    L11:
        if (r104.f512510d == false) goto L13;
        Bitmap r115 = this.f512503b.f512519d;
        Shader.TileMode r116 = Shader.TileMode.REPEAT;
        BitmapShader r117 = new BitmapShader(r115, r116, r116);
        Matrix r118 = new Matrix();
        float r119 = Math.min((r100.getWidth() * 1.0f) / this.f512503b.f512519d.getWidth(), (r100.getHeight() * 1.0f) / this.f512503b.f512519d.getHeight());
        r118.postScale(r119, r119);
        r117.setLocalMatrix(r118);
        r103.setShader(r117);
        r100.drawRect(new Rect(0, 0, r100.getWidth(), r100.getHeight()), r103);
        return;
    L22:
        return;
    }

    public static c a(d r100, Context r101, a r102) {
        r100.getClass();
        InputStream r103 = r101.getAssets().open(r102.f512512f.substring(9));     // Catch: Throwable -> L8
        BitmapRegionDecoder r104 = BitmapRegionDecoder.newInstance(r103, false);     // Catch: Throwable -> L8
        BitmapFactory.Options r105 = new BitmapFactory.Options();     // Catch: Throwable -> L8
        c r106 = r100.m(r102, r104.getWidth(), r104.getHeight());     // Catch: Throwable -> L8
        if (r106 == null) goto L6;
        r105.inSampleSize = r106.f512516a;     // Catch: Throwable -> L8
        r105.inPreferredConfig = Bitmap.Config.ARGB_8888;     // Catch: Throwable -> L8
        r106.f512519d = r104.decodeRegion(r106.f512517b, r105);     // Catch: Throwable -> L8
        r106.f512520e = false;     // Catch: Throwable -> L8
    L6:
        r104.recycle();     // Catch: Throwable -> L8
        r103.close();     // Catch: Throwable -> L8
        return r106;
    L8:
        th = move-exception;
        LLog.e("LynxImageHelper", "loadBitmapFromAssetSync error: " + th.getMessage());
        return null;
    }

    public static void c(d r100, Context r101, a r102) {
        r100.getClass();
        if (r102 != null) goto L5;
        return;
    L5:
        if (TextUtils.isEmpty(r102.f512512f) == true) goto L10;
        LLog.d("LynxImageHelper", "loadBitmapFromRemote");
        Uri r103 = UriProtector.parse(r102.f512512f);
        ImagePipeline r104 = Fresco.getImagePipeline();
        ImageRequestBuilder r105 = ImageRequestBuilder.newBuilderWithSource(r103);
        e.a(r105);
        r104.fetchEncodedImage(r105.build(), r101).subscribe(new m8a.c(r100, r102), PThreadExecutorsUtils.newSingleThreadExecutor(new DefaultThreadFactory("BigImageDrawingHelper")));
        return;
    }

    public final c m(a r100, float r110, float r111) {
        if (r110 != 0.0f) goto L5;
        return null;
    L5:
        if (r111 == 0.0f) goto L43;
        float r101 = r100.f512508b;
        if (r101 == 0.0f) goto L44;
        float r102 = r100.f512509c;
        if (r102 == 0.0f) goto L45;
        c r103 = new c(r100);
        ScalingUtils.ScaleType r104 = r100.f512511e;
        if (r104 != ScalingUtils.ScaleType.CENTER) goto L23;
        r103.f512517b = new Rect();
        Rect r105 = new Rect();
        r103.f512518c = r105;
        float r106 = r100.f512508b;
        if (r110 > r106) goto L16;
        Rect r107 = r103.f512517b;
        r107.left = 0;
        r107.right = (int) r110;
        r105.left = (int) ((r106 - r110) / 2.0f);
        r105.right = (int) ((r106 + r110) / 2.0f);
    L17:
        float r112 = r100.f512509c;
        if (r111 > r112) goto L20;
        Rect r108 = r103.f512517b;
        r108.top = 0;
        r108.bottom = (int) r111;
        r105.top = (int) ((r112 - r111) / 2.0f);
        r105.bottom = (int) ((r112 + r111) / 2.0f);
    L21:
        Rect r113 = r103.f512517b;
        float r114 = r113.right - r113.left;
        float r115 = r113.bottom - r113.top;
        r103.f512516a = e(r100.f512513g, r114, r115, r114, r115);
    L38:
        if (this.f512506e == false) goto L40;
        r103.f512516a = 1;
    L40:
        return r103;
    L20:
        Rect r109 = r103.f512517b;
        float r116 = (r111 - r112) / 2.0f;
        r109.top = (int) r116;
        r109.bottom = (int) (r111 - r116);
        r105.top = 0;
        r105.bottom = (int) r112;
        goto L21
    L16:
        Rect r117 = r103.f512517b;
        float r118 = (r110 - r106) / 2.0f;
        r117.left = (int) r118;
        r117.right = (int) (r110 - r118);
        r105.left = 0;
        r105.right = (int) r106;
        goto L17
    L23:
        if (r104 != ScalingUtils.ScaleType.FIT_CENTER) goto L30;
        float r119 = r101 / r110;
        float r120 = r102 / r111;
        Rect r121 = new Rect();
        r103.f512517b = r121;
        r121.top = 0;
        r121.bottom = (int) r111;
        r121.left = 0;
        r121.right = (int) r110;
        Rect r122 = new Rect();
        r103.f512518c = r122;
        if (r119 > r120) goto L27;
        float r123 = r119 * r111;
        r122.left = 0;
        r122.right = (int) r100.f512508b;
        float r124 = r100.f512509c;
        r122.top = (int) ((r124 - r123) / 2.0f);
        r122.bottom = (int) ((r124 + r123) / 2.0f);
    L28:
        r103.f512516a = e(r100.f512513g, r122.right - r122.left, r122.bottom - r122.top, r110, r111);
        goto L38
    L27:
        float r125 = r120 * r110;
        r122.top = 0;
        r122.bottom = (int) r100.f512509c;
        float r126 = r100.f512508b;
        r122.left = (int) ((r126 - r125) / 2.0f);
        r122.right = (int) ((r126 + r125) / 2.0f);
        goto L28
    L30:
        if (r104 != ScalingUtils.ScaleType.CENTER_CROP) goto L36;
        float r127 = r101 / r110;
        float r128 = r102 / r111;
        Rect r129 = new Rect();
        r103.f512518c = r129;
        r129.top = 0;
        r129.bottom = (int) r100.f512509c;
        r129.left = 0;
        r129.right = (int) r100.f512508b;
        Rect r130 = new Rect();
        r103.f512517b = r130;
        if (r127 < r128) goto L34;
        float r131 = r100.f512509c / r127;
        r130.left = 0;
        r130.right = (int) r110;
        r130.top = (int) ((r111 - r131) / 2.0f);
        r130.bottom = (int) ((r111 + r131) / 2.0f);
    L35:
        r103.f512516a = e(r100.f512513g, r100.f512508b, r100.f512509c, r130.right - r130.left, r130.bottom - r130.top);
        goto L38
    L34:
        float r132 = r100.f512508b / r128;
        r130.left = (int) ((r110 - r132) / 2.0f);
        r130.right = (int) ((r132 + r110) / 2.0f);
        r130.top = 0;
        r130.bottom = (int) r111;
        goto L35
    L36:
        r103.f512517b = new Rect(0, 0, (int) r110, (int) r111);
        r103.f512518c = new Rect(0, 0, (int) r100.f512508b, (int) r100.f512509c);
        r103.f512516a = e(r100.f512513g, r100.f512508b, r100.f512509c, r110, r111);
        goto L38
    L45:
        return null;
    L44:
        return null;
    L43:
        return null;
    }

    public final void n(Context r210, ImageRequest r211, a r212) {
        if (r212 != null) goto L5;
    L33:
        if (r211 == null) goto L59;
        CacheKey r100 = Fresco.getImagePipeline().getCacheKeyFactory().getBitmapCacheKey(r211, null);     // Catch: Throwable -> L47
        if (Fresco.getImagePipeline().getBitmapMemoryCache().get(r100) == null) goto L54;
        CloseableReference<CloseableImage> r101 = Fresco.getImagePipeline().getBitmapMemoryCache().get(r100).clone();     // Catch: Throwable -> L47
        if (r101 != null) goto L40;
        return;
    L40:
        if (r101.get() != null) goto L42;
        return;
    L42:
        if ((r101.get() instanceof CloseableStaticBitmap) == false) goto L57;
        Bitmap r102 = ((CloseableStaticBitmap) r101.get()).getUnderlyingBitmap();     // Catch: Throwable -> L47
        c r103 = m(r212, r102.getWidth(), r102.getHeight());     // Catch: Throwable -> L47
        if (r103 == null) goto L58;
        r103.f512522g = r101;     // Catch: Throwable -> L47
        r103.f512519d = r102;     // Catch: Throwable -> L47
        o(r103);     // Catch: Throwable -> L47
        return;
    L58:
        return;
    L57:
        return;
    L54:
        return;
    L47:
        th = move-exception;
        LLog.e("BigImageDrawingHelper", "loadBitmapFromMemory failed: " + th.toString());
        return;
    L59:
        return;
    L5:
        if (TextUtils.isEmpty(r212.f512512f) == true) goto L33;
        if (TextUtils.isEmpty(r212.f512512f) == true) goto L10;
        String r110 = String.copyValueOf(r212.f512512f.toCharArray());
    L11:
        a r104 = new a(r212.f512507a, r212.f512508b, r212.f512509c, r212.f512510d, r212.f512511e, r110, r212.f512513g, r212.f512514h, r212.f512515i);
        if (n.f384021g == null) goto L14;
    L23:
        n r111 = n.f384021g;
        m8a.b r112 = new m8a.b(this, r104, r210, r211, r212);
        r111.getClass();
        if (Looper.getMainLooper() != Looper.myLooper()) goto L33;
        Handler r105 = r111.f384025f;
        if (r105 == null) goto L29;
        r105.post(r112);
        goto L33
    L29:
        if (r111.f384023d != null) goto L31;
        r111.f384023d = new LinkedList();
    L31:
        ((LinkedList) r111.f384023d).add(r112);
        goto L33
    L14:
        monitor-enter(n.class);
    L20:
        th = move-exception;
        throw th;
    L16:
        if (n.f384021g != null) goto L18;
        n.f384021g = new n();     // Catch: Throwable -> L20
    L18:
        monitor-exit(n.class);     // Catch: Throwable -> L20
        goto L23
    L10:
        r110 = null;
        goto L11
    }

    public final boolean g(Context r100, Canvas r101, ImageRequest r102, a r110) {
        return h(r100, r101, r102, r110, DisplayMetricsHolder.getRealScreenDisplayMetrics(r100));
    }

    public final boolean i(Context r110, Canvas r111, ImageRequest r112, a r113) {
        this.f512506e = true;
        c r100 = this.f512503b;
        if (r100 != null) goto L5;
    L8:
        f();
        n(r110, r112, r113);
    L9:
        c r114 = this.f512503b;
        if (r114 == null) goto L16;
        Bitmap r115 = r114.f512519d;
        if (r115 == null) goto L18;
        l8a.a.customDraw((int) r113.f512508b, (int) r113.f512509c, r115.getWidth(), this.f512503b.f512519d.getHeight(), r113.f512511e, r113.f512514h, r113.f512515i, r111, this.f512503b.f512519d);
        return true;
    L18:
        return false;
    L16:
        return false;
    L5:
        if (r100.f512519d == null) goto L8;
        if (r100.f512521f.f512507a == r113.f512507a) goto L9;
        goto L8
    }

    public final void j(Context r100, Canvas r101, ImageRequest r102, a r103) {
        this.f512506e = true;
        c r104 = this.f512503b;
        if (r104 != null) goto L5;
    L10:
        f();
        n(r100, r102, r103);
        k(r101, this.f512503b);
        return;
    L5:
        if (r104.f512519d == null) goto L10;
        if (r104.f512521f.f512507a != r103.f512507a) goto L10;
        k(r101, r104);
    }

    public static int e(Point r100, float r101, float r102, float r103, float r104) {
        if (r104 != 0.0f) goto L5;
        return 32;
    L5:
        if (r103 == 0.0f) goto L30;
        float r105 = Math.min(Math.min(r101 / r103, r102 / r104), Math.min(r100.x / r103, r100.y / r104));
        int r106 = (int) (r103 * r105);
        int r107 = (int) (r105 * r104);
        if (r106 == 0) goto L29;
        if (r107 == 0) goto L31;
        float r108 = r107;
        int r109 = 1;
        if (r104 <= r108) goto L14;
    L17:
        int r110 = Math.round(r104 / r108);
        int r111 = Math.round(r103 / r106);
        if (r110 < r111) goto L21;
        r110 = r111;
    L21:
        int r112 = r109 * 2;
        if (r112 > r110) goto L24;
        r109 = r112;
        goto L21
    L24:
        return r109;
    L14:
        if (r103 > r106) goto L17;
        r110 = 1;
        goto L21
    L31:
        return 32;
    L29:
        return 32;
    L30:
        return 32;
    }

    public final boolean h(Context r100, Canvas r101, ImageRequest r102, a r103, DisplayMetrics r104) {
        if (r104 == null) goto L23;
        if (r103 == null) goto L23;
        if (r103.f512508b <= (r104.widthPixels * 3)) goto L8;
    L12:
        this.f512506e = false;
        LLog.d("LynxImageHelper", "drawBigImage: w:" + r103.f512508b + ", h:" + r103.f512509c);
        c r105 = this.f512503b;
        if (r105 != null) goto L15;
    L20:
        f();
        n(r100, r102, r103);
        k(r101, this.f512503b);
        return true;
    L15:
        if (r105.f512519d == null) goto L20;
        if (r105.f512521f.f512507a != r103.f512507a) goto L20;
        k(r101, r105);
        return true;
    L8:
        if (r103.f512509c > r104.heightPixels) goto L12;
        if (r103.f512510d == true) goto L12;
    L23:
        return false;
    }
}
