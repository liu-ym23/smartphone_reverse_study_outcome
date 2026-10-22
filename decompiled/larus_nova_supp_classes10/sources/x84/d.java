package x84;

import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class d {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static double a(f r10, f r11) {
        Intrinsics.checkNotNullParameter(r10, "point1");
        Intrinsics.checkNotNullParameter(r11, "point2");
        Map<String, Double> r0 = b.a;
        double r1 = b.a(r10.a);
        double r2 = b.a(r11.a);
        double r4 = b.a(r10.b);
        double r12 = b.a(r11.b);
        double r3 = r2 - r1;
        return b.b(Math.atan2(Math.sin(r3) * Math.cos(r12), (Math.cos(r4) * Math.sin(r12)) - ((Math.sin(r4) * Math.cos(r12)) * Math.cos(r3))));
    }

    public static double c(f r9, f r10, String r11) {
        Intrinsics.checkNotNullParameter(r9, "point1");
        Intrinsics.checkNotNullParameter(r10, "point2");
        Intrinsics.checkNotNullParameter(r11, "units");
        Map<String, Double> r1 = b.a;
        double r7 = 2;
        double r2 = Math.pow(Math.sin(b.a(r10.b - r9.b) / r7), r7) + ((Math.pow(Math.sin(b.a(r10.a - r9.a) / r7), r7) * Math.cos(b.a(r9.b))) * Math.cos(b.a(r10.b)));
        double r8 = r7 * Math.atan2(Math.sqrt(r2), Math.sqrt(((double) 1) - r2));
        Intrinsics.checkNotNullParameter(r11, "units");
        Double r12 = b.a.get(r11);
        if (r12 == null) goto L7;
        return r8 * r12.doubleValue();
    L7:
        throw new IllegalArgumentException("Invalid unit: ".concat(r11));
    }

    public static f b(f r15, double r16, double r18, String r20) {
        Intrinsics.checkNotNullParameter(r15, "point");
        Intrinsics.checkNotNullParameter(r20, "units");
        Map<String, Double> r3 = b.a;
        double r4 = b.a(r15.a);
        double r5 = b.a(r15.b);
        double r7 = b.a(r18);
        Intrinsics.checkNotNullParameter(r20, "units");
        Double r0 = b.a.get(r20);
        if (r0 == null) goto L7;
        double r1 = r16 / r0.doubleValue();
        double r9 = Math.asin((Math.sin(r5) * Math.cos(r1)) + ((Math.cos(r5) * Math.sin(r1)) * Math.cos(r7)));
        return new f(b.b(r4 + Math.atan2((Math.sin(r7) * Math.sin(r1)) * Math.cos(r5), Math.cos(r1) - (Math.sin(r5) * Math.sin(r9)))), b.b(r9));
    L7:
        throw new IllegalArgumentException("Invalid unit: ".concat(r20));
    }
}
