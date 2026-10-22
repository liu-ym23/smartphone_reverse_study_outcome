package x84;

import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;

/* JADX INFO: loaded from: classes10.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Map<String, Double> f562902a = null;

    public static double a(double r100) {
        return ((r100 % 360.0d) * 3.141592653589793d) / 180.0d;
    }

    public static double b(double r100) {
        return ((r100 % 6.283185307179586d) * 180.0d) / 3.141592653589793d;
    }

    static {
        Double r100 = Double.valueOf(6373000.0d);
        Double r101 = Double.valueOf(6.373E8d);
        Double r102 = Double.valueOf(6373.0d);
        f562902a = MapsKt.mapOf(new Pair[]{TuplesKt.to("miles", Double.valueOf(3960.0d)), TuplesKt.to("nauticalmiles", Double.valueOf(3441.145d)), TuplesKt.to("degrees", Double.valueOf(57.2957795d)), TuplesKt.to("radians", Double.valueOf(1.0d)), TuplesKt.to("inches", Double.valueOf(2.509056E8d)), TuplesKt.to("yards", Double.valueOf(6969600.0d)), TuplesKt.to("meters", r100), TuplesKt.to("metres", r100), TuplesKt.to("centimeters", r101), TuplesKt.to("centimetres", r101), TuplesKt.to("kilometers", r102), TuplesKt.to("kilometres", r102), TuplesKt.to("feet", Double.valueOf(2.090879265E7d))});
    }
}
