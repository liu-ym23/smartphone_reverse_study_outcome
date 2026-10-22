package w84;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class c {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static double c(double r2) {
        return (r2 * 3.141592653589793d) / 180.0d;
    }

    public static double a(com.bytedance.bdnavigationsdk.pojo.a r10, com.bytedance.bdnavigationsdk.pojo.a r11) {
        Intrinsics.checkNotNullParameter(r10, "from");
        Intrinsics.checkNotNullParameter(r11, "to");
        double r0 = c(r10.a);
        double r2 = c(r10.b);
        double r4 = c(r11.a);
        double r12 = c(r11.b) - r2;
        return (((Math.atan2(Math.sin(r12) * Math.cos(r4), (Math.cos(r0) * Math.sin(r4)) - ((Math.sin(r0) * Math.cos(r4)) * Math.cos(r12))) * 180.0d) / 3.141592653589793d) + 360.0d) % 360.0d;
    }

    public static double b(com.bytedance.bdnavigationsdk.pojo.a r8, com.bytedance.bdnavigationsdk.pojo.a r9) {
        Intrinsics.checkNotNullParameter(r8, "from");
        Intrinsics.checkNotNullParameter(r9, "to");
        double r0 = c(r8.a);
        double r2 = c(r8.b);
        double r4 = c(r9.a);
        double r10 = c(r9.b) - r2;
        double r3 = 2;
        double r6 = Math.pow(Math.sin((r4 - r0) / r3), r3) + ((Math.cos(r0) * Math.cos(r4)) * Math.pow(Math.sin(r10 / r3), r3));
        return (r3 * Math.atan2(Math.sqrt(r6), Math.sqrt(((double) 1) - r6))) * 6378137.0d;
    }
}
