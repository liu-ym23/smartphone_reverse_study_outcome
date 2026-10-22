package com.bytedance.ee.bear.contract.imageviewer.bean;

import android.graphics.Matrix;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.RectF;
import androidx.core.graphics.PathParser;
import java.util.Arrays;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes16.dex */
public final class a {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final RectF f217077g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final float[] f217078h = null;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final Path f217079i = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final float f217080a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final float f217081b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f217082c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final float[] f217083d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final float[] f217084e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Path f217085f;

    /* JADX INFO: renamed from: com.bytedance.ee.bear.contract.imageviewer.bean.a$a, reason: collision with other inner class name */
    public static final class C3094a {
        public static void a(ImageData.Image r100) {
            Intrinsics.checkNotNullParameter(r100, "image");
            ImageData.Image.TransformerInfo r101 = r100.getTransformerInfo();
            if (r101 != null) goto L5;
            return;
        L5:
            float[] r102 = r100.getCrop();
            boolean r103 = true;
            if (r102 != null) goto L8;
        L10:
            float[] r104 = a.f217078h;
            float[] r105 = Arrays.copyOf(r104, r104.length);
        L11:
            String r106 = r101.clipPath;
            if (r106 == null) goto L14;
            String r107 = StringsKt.trim(r106).toString();
        L15:
            if (r107 != null) goto L17;
            r107 = "";
        L17:
            float r108 = r101.scaleX;
            if (r108 != 0.0f) goto L20;
            boolean r109 = true;
        L21:
            float r110 = 1.0f;
            if (r109 == false) goto L24;
            float r111 = 1.0f;
        L25:
            float r112 = r101.scaleY;
            if (r112 == 0.0f) goto L29;
            r103 = false;
        L29:
            if (r103 == true) goto L32;
            r110 = Math.abs(r112);
        L32:
            float r113 = Math.max(r111, r110);
            r100.setLocalTransformerInfo(new a(r111 / r113, r110 / r113, r107, r105));
            return;
        L24:
            r111 = Math.abs(r108);
            goto L25
        L20:
            r109 = false;
            goto L21
        L14:
            r107 = null;
            goto L15
        L8:
            if (r102.length < 4) goto L10;
            r105 = new float[]{r102[0], r102[1], r102[2], r102[3]};
            goto L11
        }
    }

    public static float a(float r100) {
        if (r100 >= 0.0f) goto L6;
        return 0.0f;
    L6:
        if (r100 <= 1.0f) goto L10;
        return 1.0f;
    L10:
        return r100;
    }

    static {
        RectF r100 = new RectF(0.0f, 0.0f, 100.0f, 100.0f);
        f217077g = r100;
        f217078h = new float[]{0.0f, 0.0f, 1.0f, 1.0f};
        Path r101 = new Path();
        r101.addRect(r100, Path.Direction.CW);
        f217079i = r101;
    }

    public final float[] b() {
        float[] r100 = this.f217084e;
        if (r100 != null) goto L5;
    L7:
        r100 = this.f217083d;
        if (r100.length >= 4) goto L12;
        r100 = f217078h;
    L12:
        return new float[]{r100[0], r100[1], r100[2], r100[3]};
    L5:
        if (r100.length < 4) goto L7;
        goto L7
    }

    public final ImageData.Image.a c(float[] r110, boolean r111) {
        ImageData.Image.a r100 = new ImageData.Image.a();
        if (r110 != null) goto L5;
    L53:
        tt5.a.k("LocalTransformerInfo", "toTransformedSpaceAreaPercent() invalid areaPercent");
        return r100;
    L5:
        if (r110.length < 4) goto L53;
        float[] r101 = b();
        boolean r102 = false;
        float r103 = Math.max(Math.min(r110[0], r110[2]), Math.min(r101[0], r101[2]));
        float r104 = Math.max(Math.min(r110[1], r110[3]), Math.min(r101[1], r101[3]));
        float r112 = Math.min(Math.max(r110[0], r110[2]), Math.max(r101[0], r101[2]));
        float r105 = Math.min(Math.max(r110[1], r110[3]), Math.max(r101[1], r101[3]));
        if (r103 <= r112) goto L10;
    L13:
        float[] r113 = {r103, r104, r103, r104};
    L14:
        float r106 = r101[0];
        float r107 = r101[1];
        float r108 = r101[2];
        float r109 = r101[3];
        Float r114 = Float.valueOf(r108 - r106);
        if (r114.floatValue() != 0.0f) goto L17;
        boolean r115 = true;
    L18:
        Float r116 = null;
        if ((!r115) == true) goto L22;
        r114 = null;
    L22:
        float r117 = 1.0f;
        if (r114 == null) goto L25;
        float r118 = r114.floatValue();
    L26:
        Float r119 = Float.valueOf(r109 - r107);
        if (r119.floatValue() != 0.0f) goto L29;
        boolean r120 = true;
    L31:
        if ((!r120) == false) goto L33;
        r116 = r119;
    L33:
        if (r116 == null) goto L35;
        float r121 = r116.floatValue();
    L36:
        float r122 = (r113[0] - r106) / r118;
        float r123 = (r113[2] - r106) / r118;
        float[] r124 = {r122, (r113[1] - r107) / r121, r123, (r113[3] - r107) / r121};
        r100.f217070a = a(Math.min(r122, r123));
        r100.f217071b = a(Math.min(r124[1], r124[3]));
        r100.f217072c = a(Math.max(r124[0], r124[2]));
        r100.f217073d = a(Math.max(r124[1], r124[3]));
        float r125 = this.f217080a;
        if (r125 != 0.0f) goto L39;
        boolean r126 = true;
    L40:
        if (r126 == false) goto L42;
        r125 = 1.0f;
    L42:
        float r127 = this.f217081b;
        if (r127 != 0.0f) goto L45;
        r102 = true;
    L45:
        if (r102 == true) goto L48;
        r117 = r127;
    L48:
        ImageData.Image.a r128 = new ImageData.Image.a();
        r128.f217070a = a(((r100.f217070a - 0.5f) * r125) + 0.5f);
        r128.f217071b = a(((r100.f217071b - 0.5f) * r117) + 0.5f);
        r128.f217072c = a(((r100.f217072c - 0.5f) * r125) + 0.5f);
        r128.f217073d = a(((r100.f217073d - 0.5f) * r117) + 0.5f);
        if (r111 == true) goto L52;
        return r100;
    L52:
        return r128;
    L39:
        r126 = false;
        goto L40
    L35:
        r121 = 1.0f;
        goto L36
    L29:
        r120 = false;
        goto L31
    L25:
        r118 = 1.0f;
        goto L26
    L17:
        r115 = false;
        goto L18
    L10:
        if (r104 > r105) goto L13;
        r113 = new float[]{r103, r104, r112, r105};
        goto L14
    }

    public a(float r210, float r211, String r212, float[] r213) {
        this.f217080a = r210;
        this.f217081b = r211;
        this.f217082c = r212;
        this.f217083d = r213;
        if (Math.abs(r210 - 1.0f) <= 1.0E-4f) goto L5;
    L8:
        boolean r100 = true;
    L9:
        tt5.a.h("LocalTransformerInfo", "init clipPath: " + r212 + ", scaleX: " + r210 + ", scaleY: " + r211 + ", needScale: " + r100);
        float[] r101 = null;
        if (StringsKt.isBlank(r212) == false) goto L91;
        tt5.a.d("LocalTransformerInfo", "parseClipPathSafely() clipPath is empty, skip parsing");
    L16:
        Path r102 = null;
    L17:
        if (r102 != null) goto L19;
        tt5.a.k("LocalTransformerInfo", "create clipPath failed, clipPath: " + this.f217082c);
    L19:
        if (r102 == null) goto L86;
        int r103 = vw4.a.f557426a;
        Intrinsics.checkNotNullParameter(r102, "path");
        PathMeasure r104 = new PathMeasure(r102, false);
        float[] r105 = new float[2];
        float r106 = Float.NEGATIVE_INFINITY;
        float r110 = Float.NEGATIVE_INFINITY;
        float r111 = Float.POSITIVE_INFINITY;
        float r112 = Float.POSITIVE_INFINITY;
    L21:
        float r113 = r104.getLength();
        if (r113 <= 0.0f) goto L52;
        float r107 = 0.0f;
    L25:
        if (r107 > r113) goto L39;
        r104.getPosTan(r107, r105, null);
        float r114 = r105[0];
        float r115 = r105[1];
        if (r114 >= r111) goto L30;
        r111 = r114;
    L30:
        if (r114 <= r106) goto L33;
        r106 = r114;
    L33:
        if (r115 >= r112) goto L36;
        r112 = r115;
    L36:
        if (r115 <= r110) goto L38;
        r110 = r115;
    L38:
        r107 = r107 + 0.5f;
        goto L25
    L39:
        r104.getPosTan(r113, r105, null);
        float r108 = r105[0];
        float r116 = r105[1];
        if (r108 >= r111) goto L43;
        r111 = r108;
    L43:
        if (r108 <= r106) goto L46;
        r106 = r108;
    L46:
        if (r116 >= r112) goto L49;
        r112 = r116;
    L49:
        if (r116 <= r110) goto L52;
        r110 = r116;
    L52:
        if (r104.nextContour() == true) goto L21;
        if (r111 != Float.POSITIVE_INFINITY) goto L56;
        boolean r109 = true;
    L57:
        if (r109 == false) goto L59;
        RectF r117 = new RectF();
    L61:
        if (r117.isEmpty() == true) goto L86;
        tt5.a.h("LocalTransformerInfo", "create clipPath success, rawBounds: " + r117);
        RectF r118 = new RectF(RangesKt.coerceIn(r117.left, 0.0f, 100.0f), RangesKt.coerceIn(r117.top, 0.0f, 100.0f), RangesKt.coerceIn(r117.right, 0.0f, 100.0f), RangesKt.coerceIn(r117.bottom, 0.0f, 100.0f));
        if (r118.width() <= 0.0f) goto L86;
        if (r118.height() <= 0.0f) goto L86;
        float[] r119 = {r118.left / 100.0f, r118.top / 100.0f, r118.right / 100.0f, r118.bottom / 100.0f};
        float[] r120 = this.f217083d;
        if (r120.length < 4) goto L75;
        float r121 = a(r120[0]);
        float r122 = a(r120[1]);
        float r123 = a(r120[2]);
        float r124 = a(r120[3]);
        float r125 = r123 - r121;
        float r126 = r124 - r122;
        if (r125 > 0.0f) goto L71;
    L74:
        char r127 = 0;
        float[] r128 = {r121, r122, r123, r124};
    L76:
        RectF r129 = new RectF(r128[r127] * 100.0f, r128[1] * 100.0f, r128[2] * 100.0f, r128[3] * 100.0f);
        Matrix r130 = new Matrix();
        r130.setRectToRect(r129, f217077g, Matrix.ScaleToFit.FILL);
        Path r131 = new Path();
        r102.transform(r130, r131);
        Path r132 = new Path();     // Catch: Throwable -> L82
        if (r132.op(r131, f217079i, Path.Op.INTERSECT) == true) goto L84;
        tt5.a.k("LocalTransformerInfo", "clipPathToTargetBox() path op failed, fallback to transformed path");     // Catch: Throwable -> L82
        r132 = new Path(r131);     // Catch: Throwable -> L82
    L84:
        Path r133 = r132;
        r101 = r128;
    L87:
        this.f217084e = r101;
        this.f217085f = r133;
        return;
    L82:
        th = move-exception;
        tt5.a.e("LocalTransformerInfo", "clipPathToTargetBox() path op error, fallback to transformed path", th, false);
        r132 = new Path(r131);
        goto L84
    L71:
        if (r126 <= 0.0f) goto L74;
        r128 = new float[]{a((a(Math.min(r119[0], r119[2])) * r125) + r121), a((a(Math.min(r119[1], r119[3])) * r126) + r122), a(r121 + (r125 * a(Math.max(r119[0], r119[2])))), a(r122 + (r126 * a(Math.max(r119[1], r119[3]))))};
        r127 = 0;
        goto L76
    L75:
        r127 = 0;
        float[] r134 = f217078h;
        r128 = Arrays.copyOf(r134, r134.length);
        goto L76
    L59:
        r117 = new RectF(r111, r112, r106, r110);
        goto L61
    L56:
        r109 = false;
    L86:
        r133 = null;
        goto L87
    L91:
        r102 = PathParser.createPathFromPathData(r212);     // Catch: Exception -> L14
    L14:
        e = move-exception;
        tt5.a.e("LocalTransformerInfo", "parseClipPathSafely() create clipPath failed, clipPath: ".concat(r212), e, false);
        goto L16
    L5:
        if (Math.abs(r211 - 1.0f) > 1.0E-4f) goto L8;
        r100 = false;
        goto L9
    }
}
