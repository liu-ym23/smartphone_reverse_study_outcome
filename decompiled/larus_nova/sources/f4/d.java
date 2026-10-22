package f4;

/* JADX INFO: loaded from: classes43.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f475445a = 0;

    static {
    }

    public static a a(double r410, double r411) {
        if (r411 >= 72.004d) goto L5;
    L13:
        boolean r100 = true;
    L14:
        if (r100 == false) goto L16;
        a r101 = new a(r410, r411);
    L17:
        double r102 = 2;
        return new a((r410 * r102) - r101.f475432a, (r411 * r102) - r101.f475433b);
    L16:
        double r103 = r411 - 105.0d;
        double r104 = r410 - 35.0d;
        double r110 = r103 * 2.0d;
        double r210 = r103 * 0.1d;
        double r211 = r210 * r104;
        double r111 = (((((-100.0d) + r110) + (r104 * 3.0d)) + ((r104 * 0.2d) * r104)) + r211) + (Math.sqrt(Math.abs(r103)) * 0.2d);
        double r112 = (6.0d * r103) * 3.141592653589793d;
        double r113 = r110 * 3.141592653589793d;
        double r212 = r104 * 3.141592653589793d;
        double r114 = ((r111 + ((((Math.sin(r112) * 20.0d) + (Math.sin(r113) * 20.0d)) * 2.0d) / 3.0d)) + ((((Math.sin(r212) * 20.0d) + (Math.sin((r104 / 3.0d) * 3.141592653589793d) * 40.0d)) * 2.0d) / 3.0d)) + ((((Math.sin((r104 / 12.0d) * 3.141592653589793d) * 160.0d) + (((double) 320) * Math.sin(r212 / 30.0d))) * 2.0d) / 3.0d);
        double r310 = (((((((r103 + 300.0d) + (r104 * 2.0d)) + (r210 * r103)) + r211) + (Math.sqrt(Math.abs(r103)) * 0.1d)) + ((((Math.sin(r112) * 20.0d) + (Math.sin(r113) * 20.0d)) * 2.0d) / 3.0d)) + ((((Math.sin(r103 * 3.141592653589793d) * 20.0d) + (Math.sin((r103 / 3.0d) * 3.141592653589793d) * 40.0d)) * 2.0d) / 3.0d)) + ((((Math.sin((r103 / 12.0d) * 3.141592653589793d) * 150.0d) + (Math.sin((r103 / 30.0d) * 3.141592653589793d) * 300.0d)) * 2.0d) / 3.0d);
        double r105 = (r410 / 180.0d) * 3.141592653589793d;
        double r106 = Math.sin(r105);
        double r115 = ((double) 1) - ((0.006693421622965943d * r106) * r106);
        double r107 = Math.sqrt(r115);
        r101 = new a(r410 + ((r114 * 180.0d) / ((6335552.717000426d / (r115 * r107)) * 3.141592653589793d)), r411 + ((r310 * 180.0d) / (((6378245.0d / r107) * Math.cos(r105)) * 3.141592653589793d)));
        goto L17
    L5:
        if (r411 > 137.8347d) goto L13;
        if (r410 < 0.8293d) goto L13;
        if (r410 > 55.8271d) goto L13;
        r100 = false;
        goto L14
    }
}
