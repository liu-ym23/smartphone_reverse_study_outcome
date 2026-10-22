package n4a;

import android.content.Context;
import androidx.camera.video.AudioStats;
import com.amap.api.location.DPoint;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: loaded from: classes32.dex */
public final class e4 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final List<DPoint> f517258a = null;

    static {
        f517258a = new ArrayList(Arrays.asList(new DPoint[]{new DPoint(23.379947d, 119.757001d), new DPoint(24.983296d, 120.474496d), new DPoint(25.518722d, 121.359866d), new DPoint(25.41329d, 122.443582d), new DPoint(24.862708d, 122.288354d), new DPoint(24.461292d, 122.188319d), new DPoint(21.584761d, 120.968923d), new DPoint(21.830837d, 120.654445d)}));
    }

    public static double a(double r100, double r101) {
        return (Math.cos(r101 / 100000.0d) * (r100 / 18000.0d)) + (Math.sin(r100 / 100000.0d) * (r101 / 9000.0d));
    }

    public static double d(double r100, double r101) {
        return (Math.sin(r101 / 100000.0d) * (r100 / 18000.0d)) + (Math.cos(r100 / 100000.0d) * (r101 / 9000.0d));
    }

    public static double f(double r100) {
        return new BigDecimal(r100).setScale(8, 4).doubleValue();
    }

    public static DPoint c(DPoint r100) {
        if (r100 != null) goto L14;
    L13:
        return r100;
    L14:
    L11:
        th = move-exception;
        c4.g(th, "OffsetUtil", "b2G");
        goto L13
    L4:
        if (c4.h(r100.getLatitude(), r100.getLongitude()) == false) goto L8;
        return g(r100);
    L8:
        if (c4.j(new DPoint(r100.getLatitude(), r100.getLongitude()), f517258a) == false) goto L15;
        DPoint r101 = g(r100);     // Catch: Throwable -> L11
        return h(r101.getLatitude(), r101.getLongitude());
    L15:
        return r100;
    }

    public static DPoint g(DPoint r210) {
        double r100 = 0.006401062d;
        double r101 = 0.0060424805d;
        DPoint r102 = null;
        int r103 = 0;
    L4:
        if (r103 >= 2) goto L6;
        double r104 = r210.getLongitude();
        double r105 = r210.getLatitude();
        r102 = new DPoint();
        double r106 = r104 - r100;
        double r107 = r105 - r101;
        DPoint r110 = new DPoint();
        double r111 = (r106 * 3000.0d) * 0.017453292519943295d;
        double r112 = (3000.0d * r107) * 0.017453292519943295d;
        double r211 = (r106 * r106) + (r107 * r107);
        double r113 = (Math.cos((Math.cos(r111) * 3.0E-6d) + Math.atan2(r107, r106)) * ((Math.sin(r112) * 2.0E-5d) + Math.sqrt(r211))) + 0.0065d;
        double r114 = (Math.sin((Math.cos(r111) * 3.0E-6d) + Math.atan2(r107, r106)) * ((Math.sin(r112) * 2.0E-5d) + Math.sqrt(r211))) + 0.006d;
        r110.setLongitude(f(r113));
        r110.setLatitude(f(r114));
        r102.setLongitude(f((r106 + r104) - r110.getLongitude()));
        r102.setLatitude(f((r105 + r107) - r110.getLatitude()));
        r100 = r210.getLongitude() - r102.getLongitude();
        r101 = r210.getLatitude() - r102.getLatitude();
        r103 = r103 + 1;
        goto L4
    L6:
        return r102;
    }

    public static DPoint b(Context r100, DPoint r101) {
        if (r100 != null) goto L12;
        return null;
    L12:
    L9:
        th = move-exception;
        c4.g(th, "OffsetUtil", "cover part2");
        return r101;
    L6:
        if (c4.h(r101.getLatitude(), r101.getLongitude()) == false) goto L14;
        double[] r102 = k4.b(r101.getLongitude(), r101.getLatitude());     // Catch: Throwable -> L9
        return new DPoint(r102[1], r102[0]);
    L14:
        return r101;
    }

    public static DPoint e(Context r110, DPoint r111) {
    L14:
        th = move-exception;
        c4.g(th, "OffsetUtil", "marbar2G");
        return r111;
    L3:
        if (c4.h(r111.getLatitude(), r111.getLongitude()) == true) goto L5;
        return r111;
    L5:
        double r100 = ((long) (r111.getLongitude() * 100000.0d)) % 36000000;     // Catch: Throwable -> L14
        double r101 = ((long) (r111.getLatitude() * 100000.0d)) % 36000000;     // Catch: Throwable -> L14
        double r102 = (int) ((-a(r100, r101)) + r100);     // Catch: Throwable -> L14
        double r103 = (int) ((-d(r100, r101)) + r101);     // Catch: Throwable -> L14
        double r104 = (-a(r102, r103)) + r100;     // Catch: Throwable -> L14
        int r112 = -1;
        if (r100 <= AudioStats.AUDIO_AMPLITUDE_NONE) goto L8;
        int r105 = 1;
    L9:
        double r106 = (int) (r104 + ((double) r105));     // Catch: Throwable -> L14
        double r107 = (-d(r106, r103)) + r101;     // Catch: Throwable -> L14
        if (r101 <= AudioStats.AUDIO_AMPLITUDE_NONE) goto L12;
        r112 = 1;
    L12:
        return b(r110, new DPoint(((double) ((int) (r107 + ((double) r112)))) / 100000.0d, r106 / 100000.0d));
    L8:
        r105 = -1;
        goto L9
    }

    public static DPoint h(double r310, double r311) {
        double r100 = r311 - 105.0d;
        double r101 = r310 - 35.0d;
        double r102 = r100 * 2.0d;
        double r110 = r100 * 0.1d;
        double r111 = r110 * r101;
        double r103 = (((((-100.0d) + r102) + (r101 * 3.0d)) + ((r101 * 0.2d) * r101)) + r111) + (Math.sqrt(Math.abs(r100)) * 0.2d);
        double r112 = (6.0d * r100) * 3.141592653589793d;
        double r104 = r102 * 3.141592653589793d;
        double r105 = r103 + ((((Math.sin(r112) * 20.0d) + (Math.sin(r104) * 20.0d)) * 2.0d) / 3.0d);
        double r210 = r101 * 3.141592653589793d;
        double r106 = (r105 + ((((Math.sin(r210) * 20.0d) + (Math.sin((r101 / 3.0d) * 3.141592653589793d) * 40.0d)) * 2.0d) / 3.0d)) + ((((Math.sin((r101 / 12.0d) * 3.141592653589793d) * 160.0d) + (Math.sin(r210 / 30.0d) * 320.0d)) * 2.0d) / 3.0d);
        double r211 = (((((((r100 + 300.0d) + (r101 * 2.0d)) + (r110 * r100)) + r111) + (Math.sqrt(Math.abs(r100)) * 0.1d)) + ((((Math.sin(r112) * 20.0d) + (Math.sin(r104) * 20.0d)) * 2.0d) / 3.0d)) + ((((Math.sin(r100 * 3.141592653589793d) * 20.0d) + (Math.sin((r100 / 3.0d) * 3.141592653589793d) * 40.0d)) * 2.0d) / 3.0d)) + ((((Math.sin((r100 / 12.0d) * 3.141592653589793d) * 150.0d) + (Math.sin((r100 / 30.0d) * 3.141592653589793d) * 300.0d)) * 2.0d) / 3.0d);
        double r107 = (r310 / 180.0d) * 3.141592653589793d;
        double r108 = Math.sin(r107);
        double r109 = 1.0d - ((0.006693421622965943d * r108) * r108);
        double r113 = Math.sqrt(r109);
        double r212 = (r211 * 180.0d) / (((6378245.0d / r113) * Math.cos(r107)) * 3.141592653589793d);
        DPoint r114 = new DPoint(r310 + ((r106 * 180.0d) / ((6335552.717000426d / (r109 * r113)) * 3.141592653589793d)), r311 + r212);
        double r115 = (r311 * 2.0d) - r114.getLongitude();
        return new DPoint((r310 * 2.0d) - r114.getLatitude(), r115);
    }
}
