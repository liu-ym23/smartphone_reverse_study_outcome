package x84;

import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f562906a = 0;

    static {
    }

    public static double a(f r110, f r111) {
        Intrinsics.checkNotNullParameter(r110, "point1");
        Intrinsics.checkNotNullParameter(r111, "point2");
        Map<String, Double> r100 = b.f562902a;
        double r101 = b.a(r110.f562908a);
        double r102 = b.a(r111.f562908a);
        double r103 = b.a(r110.f562909b);
        double r112 = b.a(r111.f562909b);
        double r104 = r102 - r101;
        return b.b(Math.atan2(Math.sin(r104) * Math.cos(r112), (Math.cos(r103) * Math.sin(r112)) - ((Math.sin(r103) * Math.cos(r112)) * Math.cos(r104))));
    }

    public static double c(f r100, f r110, String r111) {
        Intrinsics.checkNotNullParameter(r100, "point1");
        Intrinsics.checkNotNullParameter(r110, "point2");
        Intrinsics.checkNotNullParameter(r111, "units");
        Map<String, Double> r101 = b.f562902a;
        double r102 = 2;
        double r103 = Math.pow(Math.sin(b.a(r110.f562909b - r100.f562909b) / r102), r102) + ((Math.pow(Math.sin(b.a(r110.f562908a - r100.f562908a) / r102), r102) * Math.cos(b.a(r100.f562909b))) * Math.cos(b.a(r110.f562909b)));
        double r104 = r102 * Math.atan2(Math.sqrt(r103), Math.sqrt(((double) 1) - r103));
        Intrinsics.checkNotNullParameter(r111, "units");
        Double r105 = b.f562902a.get(r111);
        if (r105 == null) goto L7;
        return r104 * r105.doubleValue();
    L7:
        throw new IllegalArgumentException("Invalid unit: ".concat(r111));
    }

    public static f b(f r110, double r111, double r112, String r210) {
        Intrinsics.checkNotNullParameter(r110, "point");
        Intrinsics.checkNotNullParameter(r210, "units");
        Map<String, Double> r100 = b.f562902a;
        double r101 = b.a(r110.f562908a);
        double r102 = b.a(r110.f562909b);
        double r103 = b.a(r112);
        Intrinsics.checkNotNullParameter(r210, "units");
        Double r104 = b.f562902a.get(r210);
        if (r104 == null) goto L7;
        double r105 = r111 / r104.doubleValue();
        double r106 = Math.asin((Math.sin(r102) * Math.cos(r105)) + ((Math.cos(r102) * Math.sin(r105)) * Math.cos(r103)));
        return new f(b.b(r101 + Math.atan2((Math.sin(r103) * Math.sin(r105)) * Math.cos(r102), Math.cos(r105) - (Math.sin(r102) * Math.sin(r106)))), b.b(r106));
    L7:
        throw new IllegalArgumentException("Invalid unit: ".concat(r210));
    }
}
