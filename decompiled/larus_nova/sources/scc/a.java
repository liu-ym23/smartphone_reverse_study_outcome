package scc;

import android.app.Application;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import com.bumptech.glide.util.LruCache;
import com.larksuite.component.universe_design.dimension.UDDimension;
import com.larksuite.component.universe_design.icon.UDIconUtils;
import com.larksuite.framework.utils.UIUtils;
import com.larus.nova.R;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.utils.LarkContext;
import com.ss.android.lark.utils.UIHelper;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes38.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Application f541411a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final float f541412b = 0.0f;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final float f541413c = 0.0f;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final float f541414d = 0.0f;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final float f541415e = 0.0f;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final float f541416f = 0.0f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final float f541417g = 0.0f;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final float f541418h = 0.0f;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final float f541419i = 0.0f;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final LruCache<String, Bitmap> f541420j = null;

    static {
        Application r100 = LarkContext.getApplication();
        f541411a = r100;
        f541412b = new UDDimension.Dp(4).toPixels(r100);
        f541413c = new UDDimension.Dp(2).toPixels(r100);
        f541414d = new UDDimension.Dp(1).toPixels(r100);
        f541415e = new UDDimension.Dp(4).toPixels(r100);
        f541416f = new UDDimension.Dp(12).toPixels(r100);
        f541417g = new UDDimension.Dp(3).toPixels(r100);
        f541418h = new UDDimension.b(10).toPixels(r100);
        f541419i = new UDDimension.Dp(6).toPixels(r100);
        f541420j = new LruCache(10);
    }

    @JvmStatic
    public static final Bitmap b(Bitmap r100, String r110, int r111) {
        Intrinsics.checkNotNullParameter(r100, "srcBitmap");
        Intrinsics.checkNotNullParameter(r110, "duration");
        return c(r100, d(Integer.valueOf(R.drawable.ud_icon_video_filled), Integer.valueOf(R.color.static_white), r110, 0, 0, false, false, 120), r111);
    }

    @JvmStatic
    public static final Bitmap c(Bitmap r100, Bitmap r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, "background");
        if (r101 != null) goto L5;
        return r100;
    L5:
        int r103 = r100.getWidth();
        int r104 = r100.getHeight();
        Bitmap r105 = Bitmap.createBitmap(r103, r104, Bitmap.Config.ARGB_8888);     // Catch: OutOfMemoryError -> L16
        Canvas r106 = new Canvas(r105);
        r106.drawBitmap(r100, 0.0f, 0.0f, null);
        if (r102 == 0) goto L13;
        if (r102 == 1) goto L11;
        int r107 = r103 - r101.getWidth();
        float r108 = f541419i;
        int r109 = r107 - ((int) r108);
        int r110 = r101.getHeight();
    L12:
        int r111 = (r104 - r110) - ((int) r108);
    L14:
        r106.drawBitmap(r101, r109, r111, null);
        return r105;
    L11:
        r108 = f541419i;
        r109 = (int) r108;
        r110 = r101.getHeight();
        goto L12
    L13:
        r109 = (r103 - r101.getWidth()) >> 1;
        r111 = (r104 - r101.getHeight()) >> 1;
    L16:
        Log.e("MarkBitmapFactory", "combine create bitmap oom");
        return r100;
    }

    @JvmStatic
    public static final Bitmap a(Bitmap r100, String r110, int r111, int r112) {
        Intrinsics.checkNotNullParameter(r100, "srcBitmap");
        Intrinsics.checkNotNullParameter(r110, "markText");
        Bitmap r113 = d(null, Integer.valueOf(R.color.static_white), r110, r111, r112, false, false, 96);
        if (r113 != null) goto L7;
        return null;
    L7:
        return c(r100, r113, 2);
    }

    public static Bitmap d(Integer r110, Integer r111, String r112, int r210, int r211, boolean r212, boolean r213, int r214) {
        int r100 = -1;
        if ((r214 & 8) == 0) goto L5;
        int r101 = -1;
    L7:
        if ((r214 & 16) != 0) goto L11;
        r100 = r211;
    L11:
        if ((r214 & 32) == 0) goto L13;
        boolean r102 = true;
    L14:
        int r103 = 0;
        if ((r214 & 64) == 0) goto L17;
        boolean r104 = false;
    L18:
        Intrinsics.checkNotNullParameter(r112, "text");
        StringBuilder r105 = new StringBuilder();
        if (r110 == null) goto L21;
        int r106 = r110.intValue();
    L22:
        r105.append(r106);
        r105.append(" + ");
        if (r111 == null) goto L25;
        r103 = r111.intValue();
    L25:
        r105.append(r103);
        r105.append(" + ");
        r105.append(r112);
        r105.append(" + ");
        r105.append(r102);
        r105.append(" + ");
        r105.append(r104);
        String r107 = r105.toString();
        LruCache<String, Bitmap> r108 = f541420j;
        Bitmap r109 = r108.get(r107);
        if (r109 != null) goto L55;
        if (r110 == null) goto L32;
        if (r111 == null) goto L31;
        Application r113 = f541411a;
        Drawable r114 = UDIconUtils.getIconDrawable(r113, r110.intValue(), UIUtils.getColor(r113, r111.intValue()), new UDDimension.a(f541416f));
    L33:
        Paint r115 = new Paint();
        r115.setAntiAlias(true);
        r115.setTextSize(f541418h);
        float r116 = f541412b;
        float r117 = f541414d;
        float r118 = r116 + r117;
        float r119 = f541413c + r117;
        float r120 = r115.measureText(r112);
        Paint.FontMetricsInt r121 = r115.getFontMetricsInt();
        int r122 = r121.descent - r121.ascent;
        if (r114 == null) goto L36;
        float r123 = (((2 * r118) + r120) + f541416f) + f541417g;
    L37:
        if (r114 == null) goto L39;
        float r124 = r119 * 2;
        float r125 = RangesKt.coerceAtLeast(r122, (int) f541416f);
    L40:
        float r126 = r124 + r125;
        if (acc.a.c(r101, r100, r123) == true) goto L43;
        return null;
    L43:
        Bitmap r127 = Bitmap.createBitmap((int) r123, (int) r126, Bitmap.Config.ARGB_8888);
        Canvas r128 = new Canvas(r127);
        if (r102 == false) goto L46;
        r128.save();
        r115.setColor(UIHelper.getColor(R.color.static_white_40));
        r115.setStyle(Paint.Style.STROKE);
        r115.setStrokeWidth(r117);
        RectF r129 = new RectF(r117, r117, r123 - r117, r126 - r117);
        float r130 = f541415e;
        r128.drawRoundRect(r129, r130, r130, r115);
        r115.setColor(UIHelper.getColor(R.color.static_black_60));
        r115.setStyle(Paint.Style.FILL);
        r128.drawRoundRect(r129, r130, r130, r115);
        r128.restore();
    L46:
        if (r114 == null) goto L49;
        float r131 = f541416f;
        float r132 = (r126 - r131) / 2;
        r114.setBounds(new Rect((int) r118, (int) r132, (int) (r118 + r131), (int) (r132 + r131)));
        r114.draw(r128);
    L49:
        r115.setColor(UIHelper.getColor(R.color.static_white));
        if (r104 == false) goto L52;
        r115.setShadowLayer(4.0f, 0.0f, 0.0f, 1073741824);
    L52:
        r128.drawText(r112, (r123 - r118) - r120, ((r126 / 2.0f) + (r122 / 2.0f)) - r121.descent, r115);
        r108.put(r107, r127);
        return r127;
    L39:
        r124 = r119 * 2;
        r125 = r122;
        goto L40
    L36:
        r123 = (2 * r118) + r120;
        goto L37
    L31:
        r114 = UDIconUtils.getIconDrawable(f541411a, r110.intValue(), new UDDimension.a(f541416f));
        goto L33
    L32:
        r114 = null;
        goto L33
    L55:
        return r109;
    L21:
        r106 = 0;
        goto L22
    L17:
        r104 = r213;
        goto L18
    L13:
        r102 = r212;
        goto L14
    L5:
        r101 = r210;
        goto L7
    }
}
