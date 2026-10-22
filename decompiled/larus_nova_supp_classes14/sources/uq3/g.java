package uq3;

import android.graphics.Color;
import com.bytedance.android.ec.core.monitor.ECExceptionMonitor;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import kotlin.Triple;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class g {
    public static final float[] a(String r11) {
        Intrinsics.checkNotNullParameter(r11, "hex");
        float r2 = CastIntegerProtector.parseInt(r11.substring(1, 3), 16) / 255.0f;
        float r6 = CastIntegerProtector.parseInt(r11.substring(3, 5), 16) / 255.0f;
        float r12 = CastIntegerProtector.parseInt(r11.substring(5, 7), 16) / 255.0f;
        float r3 = RangesKt.coerceAtLeast(Math.max(r2, r6), r12);
        float r4 = RangesKt.coerceAtMost(Math.min(r2, r6), r12);
        float r5 = 0.0f;
        if (r3 > r4) goto L6;
    L4:
        float r7 = 0.0f;
    L20:
        float r13 = r3 + r4;
        float r8 = r13 / 2.0f;
        if (r3 == r4) goto L28;
        if (r8 >= 0.5f) goto L26;
        r5 = (r3 - r4) / r13;
        goto L28
    L26:
        r5 = (r3 - r4) / ((2.0f - r3) - r4);
    L28:
        return new float[]{r7, r5, r8};
    L6:
        if (r3 == r2) goto L8;
    L10:
        if (r3 != r2) goto L15;
        if (r6 >= r12) goto L15;
        r7 = (((r6 - r12) * 60.0f) / (r3 - r4)) + 360.0f;
    L15:
        if (r3 != r6) goto L18;
        r7 = (((r12 - r2) * 60.0f) / (r3 - r4)) + 120.0f;
        goto L20
    L18:
        if (r3 != r12) goto L4;
        r7 = (((r2 - r6) * 60.0f) / (r3 - r4)) + 240.0f;
        goto L20
    L8:
        if (r6 < r12) goto L10;
        r7 = ((r6 - r12) * 60.0f) / (r3 - r4);
        goto L20
    }

    public static final int b(float[] r6) {
        Intrinsics.checkNotNullParameter(r6, "hsl");
        float r0 = r6[0];
        float r2 = r6[1];
        float r7 = r6[2];
        float r1 = 1;
        float r3 = 2;
        float r4 = (r1 - Math.abs((r3 * r7) - r1)) * r2;
        float r5 = 60;
        float r8 = (r1 - Math.abs(((r0 / r5) % r3) - r1)) * r4;
        float r9 = r7 - (r4 / r3);
        Float r10 = Float.valueOf(0.0f);
        if (r0 >= r5) goto L6;
        Triple r11 = new Triple(Float.valueOf(r4), Float.valueOf(r8), r10);
    L18:
        float r12 = 255;
        return Color.argb(255, (int) ((((Number) r11.component1()).floatValue() + r9) * r12), (int) ((((Number) r11.component2()).floatValue() + r9) * r12), (int) ((((Number) r11.component3()).floatValue() + r9) * r12));
    L6:
        if (r0 >= 120) goto L9;
        r11 = new Triple(Float.valueOf(r8), Float.valueOf(r4), r10);
        goto L18
    L9:
        if (r0 >= 180) goto L12;
        r11 = new Triple(r10, Float.valueOf(r4), Float.valueOf(r8));
        goto L18
    L12:
        if (r0 >= 240) goto L15;
        r11 = new Triple(r10, Float.valueOf(r8), Float.valueOf(r4));
        goto L18
    L15:
        if (r0 >= 300) goto L17;
        r11 = new Triple(Float.valueOf(r8), r10, Float.valueOf(r4));
        goto L18
    L17:
        r11 = new Triple(Float.valueOf(r4), r10, Float.valueOf(r8));
        goto L18
    }

    public static final int c(String r10) {
        if (r10 != null) goto L36;
        return -10328982;
    L36:
        float[] r11 = a(r10);     // Catch: Exception -> L33
        float r1 = r11[0];     // Catch: Exception -> L33
        float r4 = 100;
        float r3 = r11[1] * r4;     // Catch: Exception -> L33
        float r12 = r11[2] * r4;     // Catch: Exception -> L33
        float r6 = 80;
        if (r12 < r6) goto L10;
        r12 = r12 - 70;     // Catch: Exception -> L33
        if (r3 < 10) goto L31;
        r3 = 10.0f;
    L31:
        return b(new float[]{r1, r3 / r4, r12 / r4});
    L10:
        float r7 = 70;
        if (r12 >= r7) goto L13;
    L15:
        float r8 = 60;
        if (r12 >= r8) goto L18;
    L20:
        float r9 = 40;
        if (r12 >= r9) goto L23;
    L26:
        float r13 = 20;
        if (r12 < r13) goto L31;
        if (r12 >= r9) goto L31;
    L30:
        r12 = r12 - r13;     // Catch: Exception -> L33
        goto L31
    L23:
        if (r12 >= r8) goto L26;
        int r14 = 30;
    L25:
        r13 = r14;
        goto L30
    L18:
        if (r12 >= r7) goto L20;
        r14 = 50;
        goto L25
    L13:
        if (r12 >= r6) goto L15;
        r13 = 60;
    L33:
        e = move-exception;
        dm.a.a("Window_transBgColor").i(e.toString());
        ECExceptionMonitor.e(e);
        return -15329245;
    }
}
