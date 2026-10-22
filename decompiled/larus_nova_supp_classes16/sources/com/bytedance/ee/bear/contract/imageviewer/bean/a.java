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

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class a {
    public static final RectF g = null;
    public static final float[] h = null;
    public static final Path i = null;
    public final float a;
    public final float b;
    public final String c;
    public final float[] d;
    public final float[] e;
    public final Path f;

    /* JADX INFO: renamed from: com.bytedance.ee.bear.contract.imageviewer.bean.a$a, reason: collision with other inner class name */
    public static final class C0038a {
        public static void a(ImageData.Image r9) {
            Intrinsics.checkNotNullParameter(r9, "image");
            ImageData.Image.TransformerInfo r0 = r9.getTransformerInfo();
            if (r0 != null) goto L5;
            return;
        L5:
            float[] r1 = r9.getCrop();
            boolean r2 = true;
            if (r1 != null) goto L8;
        L10:
            float[] r3 = a.h;
            float[] r4 = Arrays.copyOf(r3, r3.length);
        L11:
            String r5 = r0.clipPath;
            if (r5 == null) goto L14;
            String r6 = StringsKt.trim(r5).toString();
        L15:
            if (r6 != null) goto L17;
            r6 = "";
        L17:
            float r7 = r0.scaleX;
            if (r7 != 0.0f) goto L20;
            boolean r8 = true;
        L21:
            float r10 = 1.0f;
            if (r8 == false) goto L24;
            float r11 = 1.0f;
        L25:
            float r12 = r0.scaleY;
            if (r12 == 0.0f) goto L29;
            r2 = false;
        L29:
            if (r2 == true) goto L32;
            r10 = Math.abs(r12);
        L32:
            float r13 = Math.max(r11, r10);
            r9.setLocalTransformerInfo(new a(r11 / r13, r10 / r13, r6, r4));
            return;
        L24:
            r11 = Math.abs(r7);
            goto L25
        L20:
            r8 = false;
            goto L21
        L14:
            r6 = null;
            goto L15
        L8:
            if (r1.length < 4) goto L10;
            r4 = new float[]{r1[0], r1[1], r1[2], r1[3]};
            goto L11
        }
    }

    public static float a(float r2) {
        if (r2 >= 0.0f) goto L6;
        return 0.0f;
    L6:
        if (r2 <= 1.0f) goto L10;
        return 1.0f;
    L10:
        return r2;
    }

    static {
        RectF r0 = new RectF(0.0f, 0.0f, 100.0f, 100.0f);
        g = r0;
        h = new float[]{0.0f, 0.0f, 1.0f, 1.0f};
        Path r1 = new Path();
        r1.addRect(r0, Path.Direction.CW);
        i = r1;
    }

    public final float[] b() {
        float[] r0 = this.e;
        if (r0 != null) goto L5;
    L7:
        r0 = this.d;
        if (r0.length >= 4) goto L12;
        r0 = h;
    L12:
        return new float[]{r0[0], r0[1], r0[2], r0[3]};
    L5:
        if (r0.length < 4) goto L7;
        goto L7
    }

    public final ImageData.Image.a c(float[] r17, boolean r18) {
        ImageData.Image.a r2 = new ImageData.Image.a();
        if (r17 != null) goto L5;
    L53:
        tt5.a.k("LocalTransformerInfo", "toTransformedSpaceAreaPercent() invalid areaPercent");
        return r2;
    L5:
        if (r17.length < 4) goto L53;
        float[] r3 = b();
        boolean r5 = false;
        float r6 = Math.max(Math.min(r17[0], r17[2]), Math.min(r3[0], r3[2]));
        float r9 = Math.max(Math.min(r17[1], r17[3]), Math.min(r3[1], r3[3]));
        float r11 = Math.min(Math.max(r17[0], r17[2]), Math.max(r3[0], r3[2]));
        float r1 = Math.min(Math.max(r17[1], r17[3]), Math.max(r3[1], r3[3]));
        if (r6 <= r11) goto L10;
    L13:
        float[] r12 = {r6, r9, r6, r9};
    L14:
        float r4 = r3[0];
        float r7 = r3[1];
        float r10 = r3[2];
        float r8 = r3[3];
        Float r13 = Float.valueOf(r10 - r4);
        if (r13.floatValue() != 0.0f) goto L17;
        boolean r14 = true;
    L18:
        Float r16 = null;
        if ((!r14) == true) goto L22;
        r13 = null;
    L22:
        float r19 = 1.0f;
        if (r13 == null) goto L25;
        float r20 = r13.floatValue();
    L26:
        Float r21 = Float.valueOf(r8 - r7);
        if (r21.floatValue() != 0.0f) goto L29;
        boolean r110 = true;
    L31:
        if ((!r110) == false) goto L33;
        r16 = r21;
    L33:
        if (r16 == null) goto L35;
        float r22 = r16.floatValue();
    L36:
        float r111 = (r12[0] - r4) / r20;
        float r112 = (r12[2] - r4) / r20;
        float[] r23 = {r111, (r12[1] - r7) / r22, r112, (r12[3] - r7) / r22};
        r2.a = a(Math.min(r111, r112));
        r2.b = a(Math.min(r23[1], r23[3]));
        r2.c = a(Math.max(r23[0], r23[2]));
        r2.d = a(Math.max(r23[1], r23[3]));
        float r24 = this.a;
        if (r24 != 0.0f) goto L39;
        boolean r26 = true;
    L40:
        if (r26 == false) goto L42;
        r24 = 1.0f;
    L42:
        float r27 = this.b;
        if (r27 != 0.0f) goto L45;
        r5 = true;
    L45:
        if (r5 == true) goto L48;
        r19 = r27;
    L48:
        ImageData.Image.a r28 = new ImageData.Image.a();
        r28.a = a(((r2.a - 0.5f) * r24) + 0.5f);
        r28.b = a(((r2.b - 0.5f) * r19) + 0.5f);
        r28.c = a(((r2.c - 0.5f) * r24) + 0.5f);
        r28.d = a(((r2.d - 0.5f) * r19) + 0.5f);
        if (r18 == true) goto L52;
        return r2;
    L52:
        return r28;
    L39:
        r26 = false;
        goto L40
    L35:
        r22 = 1.0f;
        goto L36
    L29:
        r110 = false;
        goto L31
    L25:
        r20 = 1.0f;
        goto L26
    L17:
        r14 = false;
        goto L18
    L10:
        if (r9 > r1) goto L13;
        r12 = new float[]{r6, r9, r11, r1};
        goto L14
    }

    public a(float r20, float r21, String r22, float[] r23) {
        this.a = r20;
        this.b = r21;
        this.c = r22;
        this.d = r23;
        if (Math.abs(r20 - 1.0f) <= 1.0E-4f) goto L5;
    L8:
        boolean r4 = true;
    L9:
        tt5.a.h("LocalTransformerInfo", "init clipPath: " + r22 + ", scaleX: " + r20 + ", scaleY: " + r21 + ", needScale: " + r4);
        float[] r5 = null;
        if (StringsKt.isBlank(r22) == false) goto L91;
        tt5.a.d("LocalTransformerInfo", "parseClipPathSafely() clipPath is empty, skip parsing");
    L16:
        Path r0 = null;
    L17:
        if (r0 != null) goto L19;
        tt5.a.k("LocalTransformerInfo", "create clipPath failed, clipPath: " + this.c);
    L19:
        if (r0 == null) goto L86;
        int r3 = vw4.a.a;
        Intrinsics.checkNotNullParameter(r0, "path");
        PathMeasure r6 = new PathMeasure(r0, false);
        float[] r8 = new float[2];
        float r9 = Float.NEGATIVE_INFINITY;
        float r11 = Float.NEGATIVE_INFINITY;
        float r12 = Float.POSITIVE_INFINITY;
        float r13 = Float.POSITIVE_INFINITY;
    L21:
        float r14 = r6.getLength();
        if (r14 <= 0.0f) goto L52;
        float r7 = 0.0f;
    L25:
        if (r7 > r14) goto L39;
        r6.getPosTan(r7, r8, null);
        float r16 = r8[0];
        float r17 = r8[1];
        if (r16 >= r12) goto L30;
        r12 = r16;
    L30:
        if (r16 <= r9) goto L33;
        r9 = r16;
    L33:
        if (r17 >= r13) goto L36;
        r13 = r17;
    L36:
        if (r17 <= r11) goto L38;
        r11 = r17;
    L38:
        r7 = r7 + 0.5f;
        goto L25
    L39:
        r6.getPosTan(r14, r8, null);
        float r10 = r8[0];
        float r18 = r8[1];
        if (r10 >= r12) goto L43;
        r12 = r10;
    L43:
        if (r10 <= r9) goto L46;
        r9 = r10;
    L46:
        if (r18 >= r13) goto L49;
        r13 = r18;
    L49:
        if (r18 <= r11) goto L52;
        r11 = r18;
    L52:
        if (r6.nextContour() == true) goto L21;
        if (r12 != Float.POSITIVE_INFINITY) goto L56;
        boolean r19 = true;
    L57:
        if (r19 == false) goto L59;
        RectF r24 = new RectF();
    L61:
        if (r24.isEmpty() == true) goto L86;
        tt5.a.h("LocalTransformerInfo", "create clipPath success, rawBounds: " + r24);
        RectF r26 = new RectF(RangesKt.coerceIn(r24.left, 0.0f, 100.0f), RangesKt.coerceIn(r24.top, 0.0f, 100.0f), RangesKt.coerceIn(r24.right, 0.0f, 100.0f), RangesKt.coerceIn(r24.bottom, 0.0f, 100.0f));
        if (r26.width() <= 0.0f) goto L86;
        if (r26.height() <= 0.0f) goto L86;
        float[] r27 = {r26.left / 100.0f, r26.top / 100.0f, r26.right / 100.0f, r26.bottom / 100.0f};
        float[] r28 = this.d;
        if (r28.length < 4) goto L75;
        float r110 = a(r28[0]);
        float r111 = a(r28[1]);
        float r112 = a(r28[2]);
        float r29 = a(r28[3]);
        float r113 = r112 - r110;
        float r114 = r29 - r111;
        if (r113 > 0.0f) goto L71;
    L74:
        char r30 = 0;
        float[] r31 = {r110, r111, r112, r29};
    L76:
        RectF r32 = new RectF(r31[r30] * 100.0f, r31[1] * 100.0f, r31[2] * 100.0f, r31[3] * 100.0f);
        Matrix r33 = new Matrix();
        r33.setRectToRect(r32, g, Matrix.ScaleToFit.FILL);
        Path r34 = new Path();
        r0.transform(r33, r34);
        Path r1 = new Path();     // Catch: Throwable -> L82
        if (r1.op(r34, i, Path.Op.INTERSECT) == true) goto L84;
        tt5.a.k("LocalTransformerInfo", "clipPathToTargetBox() path op failed, fallback to transformed path");     // Catch: Throwable -> L82
        r1 = new Path(r34);     // Catch: Throwable -> L82
    L84:
        Path r2 = r1;
        r5 = r31;
    L87:
        this.e = r5;
        this.f = r2;
        return;
    L82:
        th = move-exception;
        tt5.a.e("LocalTransformerInfo", "clipPathToTargetBox() path op error, fallback to transformed path", th, false);
        r1 = new Path(r34);
        goto L84
    L71:
        if (r114 <= 0.0f) goto L74;
        r31 = new float[]{a((a(Math.min(r27[0], r27[2])) * r113) + r110), a((a(Math.min(r27[1], r27[3])) * r114) + r111), a(r110 + (r113 * a(Math.max(r27[0], r27[2])))), a(r111 + (r114 * a(Math.max(r27[1], r27[3]))))};
        r30 = 0;
        goto L76
    L75:
        r30 = 0;
        float[] r36 = h;
        r31 = Arrays.copyOf(r36, r36.length);
        goto L76
    L59:
        r24 = new RectF(r12, r13, r9, r11);
        goto L61
    L56:
        r19 = false;
    L86:
        r2 = null;
        goto L87
    L91:
        r0 = PathParser.createPathFromPathData(r22);     // Catch: Exception -> L14
    L14:
        e = move-exception;
        tt5.a.e("LocalTransformerInfo", "parseClipPathSafely() create clipPath failed, clipPath: ".concat(r22), e, false);
        goto L16
    L5:
        if (Math.abs(r21 - 1.0f) > 1.0E-4f) goto L8;
        r4 = false;
        goto L9
    }
}
