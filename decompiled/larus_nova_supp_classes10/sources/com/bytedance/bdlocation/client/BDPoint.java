package com.bytedance.bdlocation.client;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public class BDPoint {
    private String coordinateSystem;
    private double latitude;
    private double longitude;
    private String provider;

    public BDPoint() {
        this(LocationInfoConst.SYSTEM);
    }

    public int hashCode() {
        return Double.valueOf((this.latitude + this.longitude) * 1000000.0d).intValue();
    }

    public String toString() {
        return "BDPoint{provider='" + this.provider + "', longitude=" + this.longitude + ", latitude=" + this.latitude + ", coordinateSystem=" + this.coordinateSystem + '}';
    }

    public String getCoordinateSystem() {
        return this.coordinateSystem;
    }

    public double getLatitude() {
        return this.latitude;
    }

    public double getLongitude() {
        return this.longitude;
    }

    public String getProvider() {
        return this.provider;
    }

    public BDPoint(String r3) {
        this.longitude = 0.0d;
        this.latitude = 0.0d;
        this.provider = r3;
    }

    public boolean equals(Object r7) {
        if ((r7 instanceof BDPoint) == true) goto L5;
        return false;
    L5:
        BDPoint r8 = (BDPoint) r7;
        if (this.latitude == r8.latitude) goto L9;
        return false;
    L9:
        if (this.longitude != r8.longitude) goto L12;
        return true;
    L12:
        return false;
    }

    public void setCoordinateSystem(String r1) {
        this.coordinateSystem = r1;
    }

    public void setLatitude(double r4) {
        if (r4 <= 90.0d) goto L6;
        r4 = 90.0d;
    L6:
        if (r4 >= (-90.0d)) goto L8;
        r4 = -90.0d;
    L8:
        this.latitude = r4;
    }

    public void setLongitude(double r4) {
        if (r4 <= 180.0d) goto L6;
        r4 = 180.0d;
    L6:
        if (r4 >= (-180.0d)) goto L8;
        r4 = -180.0d;
    L8:
        this.longitude = r4;
    }

    public void setProvider(String r1) {
        this.provider = r1;
    }

    public BDPoint(double r7, double r9) {
        this(r7, r9, "none");
    }

    public BDPoint(double r4, double r6, String r8) {
        this.longitude = 0.0d;
        this.latitude = 0.0d;
        if (r6 <= 180.0d) goto L6;
        r6 = 180.0d;
    L6:
        if (r6 >= (-180.0d)) goto L9;
        r6 = -180.0d;
    L9:
        if (r4 <= 90.0d) goto L12;
        r4 = 90.0d;
    L12:
        if (r4 >= (-90.0d)) goto L14;
        r4 = -90.0d;
    L14:
        this.longitude = r6;
        this.latitude = r4;
        this.provider = r8;
    }

    public BDPoint(double r1, double r3, String r5, String r6) {
        this(r1, r3, r5);
        this.coordinateSystem = r6;
    }
}
