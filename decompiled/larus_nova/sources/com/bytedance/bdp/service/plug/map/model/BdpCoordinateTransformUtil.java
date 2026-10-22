package com.bytedance.bdp.service.plug.map.model;

/* JADX INFO: loaded from: classes11.dex */
public class BdpCoordinateTransformUtil {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static double f201543a = 6378245.0d;

    /* JADX INFO: renamed from: ee, reason: collision with root package name */
    static double f201544ee = 0.006693421622965943d;

    /* JADX INFO: renamed from: pi, reason: collision with root package name */
    static double f201545pi = 3.141592653589793d;
    static double x_pi = 52.35987755982988d;

    public BdpCoordinateTransformUtil() {
    }

    public static boolean isValidLatLng(double r100, double r101) {
        if (r100 >= (-90.0d)) goto L5;
    L14:
        return false;
    L5:
        if (r100 > 90.0d) goto L14;
        if (r101 < (-180.0d)) goto L14;
        if (r101 > 180.0d) goto L14;
        return true;
    }

    public static boolean outOfChina(double r100, double r101) {
        if (r100 >= 72.004d) goto L5;
    L14:
        return true;
    L5:
        if (r100 > 137.8347d) goto L14;
        if (r101 < 0.8293d) goto L14;
        if (r101 > 55.8271d) goto L14;
        return false;
    }

    public static double[] bd09togcj02(double r100, double r101) {
        double r102 = r100 - 0.0065d;
        double r103 = r101 - 0.006d;
        double r104 = Math.sqrt((r102 * r102) + (r103 * r103)) - (Math.sin(x_pi * r103) * 2.0E-5d);
        double r105 = Math.atan2(r103, r102) - (Math.cos(r102 * x_pi) * 3.0E-6d);
        return new double[]{Math.cos(r105) * r104, r104 * Math.sin(r105)};
    }

    public static double[] bd09towgs84(double r100, double r101) {
        double[] r102 = bd09togcj02(r100, r101);
        return gcj02towgs84(r102[0], r102[1]);
    }

    public static double[] gcj02tobd09(double r100, double r101) {
        double r102 = Math.sqrt((r100 * r100) + (r101 * r101)) + (Math.sin(x_pi * r101) * 2.0E-5d);
        double r103 = Math.atan2(r101, r100) + (Math.cos(r100 * x_pi) * 3.0E-6d);
        return new double[]{(Math.cos(r103) * r102) + 0.0065d, (r102 * Math.sin(r103)) + 0.006d};
    }

    public static double[] gcj02towgs84(double r210, double r211) {
        if (outOfChina(r210, r211) == true) goto L5;
        double r100 = r210 - 105.0d;
        double r101 = r211 - 35.0d;
        double r102 = transformlat(r100, r101);
        double r103 = transformlng(r100, r101);
        double r110 = (r211 / 180.0d) * f201545pi;
        double r111 = Math.sin(r110);
        double r112 = 1.0d - ((f201544ee * r111) * r111);
        double r113 = Math.sqrt(r112);
        double r114 = f201543a;
        double r104 = (r102 * 180.0d) / ((((1.0d - f201544ee) * r114) / (r112 * r113)) * f201545pi);
        double r105 = (r103 * 180.0d) / (((r114 / r113) * Math.cos(r110)) * f201545pi);
        return new double[]{(r210 * 2.0d) - (r210 + r105), (r211 * 2.0d) - (r211 + r104)};
    L5:
        return new double[]{r210, r211};
    }

    public static double transformlat(double r110, double r111) {
        double r100 = r110 * 2.0d;
        return ((((((((-100.0d) + r100) + (r111 * 3.0d)) + ((r111 * 0.2d) * r111)) + ((0.1d * r110) * r111)) + (Math.sqrt(Math.abs(r110)) * 0.2d)) + ((((Math.sin((r110 * 6.0d) * f201545pi) * 20.0d) + (Math.sin(r100 * f201545pi) * 20.0d)) * 2.0d) / 3.0d)) + ((((Math.sin(f201545pi * r111) * 20.0d) + (Math.sin((r111 / 3.0d) * f201545pi) * 40.0d)) * 2.0d) / 3.0d)) + ((((Math.sin((r111 / 12.0d) * f201545pi) * 160.0d) + (Math.sin((r111 * f201545pi) / 30.0d) * 320.0d)) * 2.0d) / 3.0d);
    }

    public static double transformlng(double r110, double r111) {
        double r100 = r110 * 0.1d;
        return (((((((r110 + 300.0d) + (r111 * 2.0d)) + (r100 * r110)) + (r100 * r111)) + (Math.sqrt(Math.abs(r110)) * 0.1d)) + ((((Math.sin((6.0d * r110) * f201545pi) * 20.0d) + (Math.sin((r110 * 2.0d) * f201545pi) * 20.0d)) * 2.0d) / 3.0d)) + ((((Math.sin(f201545pi * r110) * 20.0d) + (Math.sin((r110 / 3.0d) * f201545pi) * 40.0d)) * 2.0d) / 3.0d)) + ((((Math.sin((r110 / 12.0d) * f201545pi) * 150.0d) + (Math.sin((r110 / 30.0d) * f201545pi) * 300.0d)) * 2.0d) / 3.0d);
    }

    public static double[] wgs84tobd09(double r100, double r101) {
        double[] r102 = wgs84togcj02(r100, r101);
        return gcj02tobd09(r102[0], r102[1]);
    }

    public static double[] wgs84togcj02(double r210, double r211) {
        if (outOfChina(r210, r211) == true) goto L5;
        double r100 = r210 - 105.0d;
        double r101 = r211 - 35.0d;
        double r102 = transformlat(r100, r101);
        double r103 = transformlng(r100, r101);
        double r110 = (r211 / 180.0d) * f201545pi;
        double r111 = Math.sin(r110);
        double r112 = 1.0d - ((f201544ee * r111) * r111);
        double r113 = Math.sqrt(r112);
        double r114 = f201543a;
        double r104 = (r102 * 180.0d) / ((((1.0d - f201544ee) * r114) / (r112 * r113)) * f201545pi);
        return new double[]{r210 + ((r103 * 180.0d) / (((r114 / r113) * Math.cos(r110)) * f201545pi)), r211 + r104};
    L5:
        return new double[]{r210, r211};
    }
}
