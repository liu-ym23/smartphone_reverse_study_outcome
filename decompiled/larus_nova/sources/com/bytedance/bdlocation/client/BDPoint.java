package com.bytedance.bdlocation.client;

import androidx.camera.video.AudioStats;

/* JADX INFO: loaded from: classes10.dex */
public class BDPoint {
    private String coordinateSystem;
    private double latitude;
    private double longitude;
    private String provider;

    public BDPoint() {
        this("Android");
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

    public BDPoint(String r100) {
        this.longitude = AudioStats.AUDIO_AMPLITUDE_NONE;
        this.latitude = AudioStats.AUDIO_AMPLITUDE_NONE;
        this.provider = r100;
    }

    public boolean equals(Object r100) {
        if ((r100 instanceof BDPoint) == true) goto L5;
        return false;
    L5:
        BDPoint r101 = (BDPoint) r100;
        if (this.latitude == r101.latitude) goto L9;
        return false;
    L9:
        if (this.longitude != r101.longitude) goto L12;
        return true;
    L12:
        return false;
    }

    public void setCoordinateSystem(String r100) {
        this.coordinateSystem = r100;
    }

    public void setLatitude(double r100) {
        if (r100 <= 90.0d) goto L6;
        r100 = 90.0d;
    L6:
        if (r100 >= (-90.0d)) goto L8;
        r100 = -90.0d;
    L8:
        this.latitude = r100;
    }

    public void setLongitude(double r100) {
        if (r100 <= 180.0d) goto L6;
        r100 = 180.0d;
    L6:
        if (r100 >= (-180.0d)) goto L8;
        r100 = -180.0d;
    L8:
        this.longitude = r100;
    }

    public void setProvider(String r100) {
        this.provider = r100;
    }

    public BDPoint(double r100, double r101) {
        this(r100, r101, "none");
    }

    public BDPoint(double r100, double r101, String r102) {
        this.longitude = AudioStats.AUDIO_AMPLITUDE_NONE;
        this.latitude = AudioStats.AUDIO_AMPLITUDE_NONE;
        if (r101 <= 180.0d) goto L6;
        r101 = 180.0d;
    L6:
        if (r101 >= (-180.0d)) goto L9;
        r101 = -180.0d;
    L9:
        if (r100 <= 90.0d) goto L12;
        r100 = 90.0d;
    L12:
        if (r100 >= (-90.0d)) goto L14;
        r100 = -90.0d;
    L14:
        this.longitude = r101;
        this.latitude = r100;
        this.provider = r102;
    }

    public BDPoint(double r100, double r101, String r102, String r103) {
        this(r100, r101, r102);
        this.coordinateSystem = r103;
    }
}
