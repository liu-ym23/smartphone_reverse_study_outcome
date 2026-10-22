package uq3;

import android.graphics.Color;
import com.bytedance.android.ec.core.monitor.ECExceptionMonitor;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import kotlin.Triple;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes14.dex */
public final class g {
    public static final float[] a(String r110) {
        Intrinsics.checkNotNullParameter(r110, "hex");
        float r100 = CastIntegerProtector.parseInt(r110.substring(1, 3), 16) / 255.0f;
        float r101 = CastIntegerProtector.parseInt(r110.substring(3, 5), 16) / 255.0f;
        float r111 = CastIntegerProtector.parseInt(r110.substring(5, 7), 16) / 255.0f;
        float r102 = RangesKt.coerceAtLeast(Math.max(r100, r101), r111);
        float r103 = RangesKt.coerceAtMost(Math.min(r100, r101), r111);
        float r104 = 0.0f;
        if (r102 > r103) goto L6;
    L4:
        float r105 = 0.0f;
    L20:
        float r112 = r102 + r103;
        float r106 = r112 / 2.0f;
        if (r102 == r103) goto L28;
        if (r106 >= 0.5f) goto L26;
        r104 = (r102 - r103) / r112;
        goto L28
    L26:
        r104 = (r102 - r103) / ((2.0f - r102) - r103);
    L28:
        return new float[]{r105, r104, r106};
    L6:
        if (r102 == r100) goto L8;
    L10:
        if (r102 != r100) goto L15;
        if (r101 >= r111) goto L15;
        r105 = (((r101 - r111) * 60.0f) / (r102 - r103)) + 360.0f;
    L15:
        if (r102 != r101) goto L18;
        r105 = (((r111 - r100) * 60.0f) / (r102 - r103)) + 120.0f;
        goto L20
    L18:
        if (r102 != r111) goto L4;
        r105 = (((r100 - r101) * 60.0f) / (r102 - r103)) + 240.0f;
        goto L20
    L8:
        if (r101 < r111) goto L10;
        r105 = ((r101 - r111) * 60.0f) / (r102 - r103);
        goto L20
    }

    public static final int b(float[] r100) {
        Intrinsics.checkNotNullParameter(r100, "hsl");
        float r101 = r100[0];
        float r102 = r100[1];
        float r103 = r100[2];
        float r104 = 1;
        float r105 = 2;
        float r106 = (r104 - Math.abs((r105 * r103) - r104)) * r102;
        float r107 = 60;
        float r108 = (r104 - Math.abs(((r101 / r107) % r105) - r104)) * r106;
        float r109 = r103 - (r106 / r105);
        Float r110 = Float.valueOf(0.0f);
        if (r101 >= r107) goto L6;
        Triple r111 = new Triple(Float.valueOf(r106), Float.valueOf(r108), r110);
    L18:
        float r112 = 255;
        return Color.argb(255, (int) ((((Number) r111.component1()).floatValue() + r109) * r112), (int) ((((Number) r111.component2()).floatValue() + r109) * r112), (int) ((((Number) r111.component3()).floatValue() + r109) * r112));
    L6:
        if (r101 >= 120) goto L9;
        r111 = new Triple(Float.valueOf(r108), Float.valueOf(r106), r110);
        goto L18
    L9:
        if (r101 >= 180) goto L12;
        r111 = new Triple(r110, Float.valueOf(r106), Float.valueOf(r108));
        goto L18
    L12:
        if (r101 >= 240) goto L15;
        r111 = new Triple(r110, Float.valueOf(r108), Float.valueOf(r106));
        goto L18
    L15:
        if (r101 >= 300) goto L17;
        r111 = new Triple(Float.valueOf(r108), r110, Float.valueOf(r106));
        goto L18
    L17:
        r111 = new Triple(Float.valueOf(r106), r110, Float.valueOf(r108));
        goto L18
    }

    public static final int c(String r110) {
        if (r110 != null) goto L36;
        return -10328982;
    L36:
        float[] r111 = a(r110);     // Catch: Exception -> L33
        float r100 = r111[0];     // Catch: Exception -> L33
        float r101 = 100;
        float r102 = r111[1] * r101;     // Catch: Exception -> L33
        float r112 = r111[2] * r101;     // Catch: Exception -> L33
        float r103 = 80;
        if (r112 < r103) goto L10;
        r112 = r112 - 70;     // Catch: Exception -> L33
        if (r102 < 10) goto L31;
        r102 = 10.0f;
    L31:
        return b(new float[]{r100, r102 / r101, r112 / r101});
    L10:
        float r104 = 70;
        if (r112 >= r104) goto L13;
    L15:
        float r105 = 60;
        if (r112 >= r105) goto L18;
    L20:
        float r106 = 40;
        if (r112 >= r106) goto L23;
    L26:
        float r107 = 20;
        if (r112 < r107) goto L31;
        if (r112 >= r106) goto L31;
    L30:
        r112 = r112 - r107;     // Catch: Exception -> L33
        goto L31
    L23:
        if (r112 >= r105) goto L26;
        int r108 = 30;
    L25:
        r107 = r108;
        goto L30
    L18:
        if (r112 >= r104) goto L20;
        r108 = 50;
        goto L25
    L13:
        if (r112 >= r103) goto L15;
        r107 = 60;
    L33:
        e = move-exception;
        dm.a.a("Window_transBgColor").i(e.toString());
        ECExceptionMonitor.e(e);
        return -15329245;
    }
}
