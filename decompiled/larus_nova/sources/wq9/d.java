package wq9;

/* JADX INFO: loaded from: classes31.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f560766a = 0;

    static {
    }

    public static boolean b(double r100, double r101) {
        if (r101 >= 72.004d) goto L5;
    L13:
        return true;
    L5:
        if (r101 > 137.8347d) goto L13;
        if (r100 < 0.8293d) goto L13;
        if (r100 > 55.8271d) goto L13;
        return false;
    }

    public static a a(double r110, double r210) {
        if (b(r110, r210) == false) goto L5;
        a r100 = new a(r110, r210);
    L6:
        double r101 = 2;
        return new a((r110 * r101) - r100.f560759a, (r210 * r101) - r100.f560760b);
    L5:
        double r102 = r210 - 105.0d;
        double r103 = r110 - 35.0d;
        double r104 = c(r102, r103);
        double r105 = d(r102, r103);
        double r111 = (r110 / 180.0d) * 3.141592653589793d;
        double r112 = Math.sin(r111);
        double r113 = ((double) 1) - ((0.006693421622965943d * r112) * r112);
        double r114 = Math.sqrt(r113);
        r100 = new a(r110 + ((r104 * 180.0d) / ((6335552.717000426d / (r113 * r114)) * 3.141592653589793d)), ((r105 * 180.0d) / (((6378245.0d / r114) * Math.cos(r111)) * 3.141592653589793d)) + r210);
        goto L6
    }

    public static double c(double r110, double r111) {
        double r100 = r110 * 2.0d;
        double r101 = ((((((-100.0d) + r100) + (r111 * 3.0d)) + ((r111 * 0.2d) * r111)) + ((0.1d * r110) * r111)) + (Math.sqrt(Math.abs(r110)) * 0.2d)) + ((((Math.sin((6.0d * r110) * 3.141592653589793d) * 20.0d) + (Math.sin(r100 * 3.141592653589793d) * 20.0d)) * 2.0d) / 3.0d);
        double r102 = r111 * 3.141592653589793d;
        return (r101 + ((((Math.sin(r102) * 20.0d) + (Math.sin((r111 / 3.0d) * 3.141592653589793d) * 40.0d)) * 2.0d) / 3.0d)) + ((((Math.sin((r111 / 12.0d) * 3.141592653589793d) * 160.0d) + (((double) 320) * Math.sin(r102 / 30.0d))) * 2.0d) / 3.0d);
    }

    public static double d(double r110, double r111) {
        double r100 = r110 * 0.1d;
        return (((((((r110 + 300.0d) + (r111 * 2.0d)) + (r100 * r110)) + (r100 * r111)) + (Math.sqrt(Math.abs(r110)) * 0.1d)) + ((((Math.sin((6.0d * r110) * 3.141592653589793d) * 20.0d) + (Math.sin((r110 * 2.0d) * 3.141592653589793d) * 20.0d)) * 2.0d) / 3.0d)) + ((((Math.sin(r110 * 3.141592653589793d) * 20.0d) + (Math.sin((r110 / 3.0d) * 3.141592653589793d) * 40.0d)) * 2.0d) / 3.0d)) + ((((Math.sin((r110 / 12.0d) * 3.141592653589793d) * 150.0d) + (Math.sin((r110 / 30.0d) * 3.141592653589793d) * 300.0d)) * 2.0d) / 3.0d);
    }

    public static a e(double r110, double r111) {
        if (b(r110, r111) == false) goto L6;
        return null;
    L6:
        double r100 = r111 - 105.0d;
        double r101 = r110 - 35.0d;
        double r102 = c(r100, r101);
        double r103 = d(r100, r101);
        double r104 = (r110 / 180.0d) * 3.141592653589793d;
        double r112 = Math.sin(r104);
        double r113 = ((double) 1) - ((0.006693421622965943d * r112) * r112);
        double r114 = Math.sqrt(r113);
        double r105 = (r103 * 180.0d) / (((6378245.0d / r114) * Math.cos(r104)) * 3.141592653589793d);
        return new a(r110 + ((r102 * 180.0d) / ((6335552.717000426d / (r113 * r114)) * 3.141592653589793d)), r111 + r105);
    }
}
