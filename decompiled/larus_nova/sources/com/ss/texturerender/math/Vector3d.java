package com.ss.texturerender.math;

import androidx.camera.video.AudioStats;
import java.util.Locale;

/* JADX INFO: loaded from: classes40.dex */
public class Vector3d {

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public double f457024x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public double f457025y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public double f457026z;

    public double length() {
        double r100 = this.f457024x;
        double r101 = this.f457025y;
        double r102 = (r100 * r100) + (r101 * r101);
        double r103 = this.f457026z;
        return Math.sqrt(r102 + (r103 * r103));
    }

    public void setZero() {
        this.f457026z = AudioStats.AUDIO_AMPLITUDE_NONE;
        this.f457025y = AudioStats.AUDIO_AMPLITUDE_NONE;
        this.f457024x = AudioStats.AUDIO_AMPLITUDE_NONE;
    }

    public boolean normalize() {
        double r100 = length();
        if (r100 == AudioStats.AUDIO_AMPLITUDE_NONE) goto L6;
        scale(1.0d / r100);
        return true;
    L6:
        return false;
    }

    public String toString() {
        return String.format(Locale.getDefault(), "%+5f %+05f %+05f", new Object[]{Double.valueOf(this.f457024x), Double.valueOf(this.f457025y), Double.valueOf(this.f457026z)});
    }

    public Vector3d() {
    }

    public Vector3d(float[] r210) {
        double r100 = r210[0];
        float r101 = r210[4];
        float r102 = r210[8];
        double r103 = r210[1];
        double r104 = r210[5];
        double r105 = r210[9];
        double r110 = r210[2];
        double r111 = r210[6];
        double r106 = r210[10];
        double r107 = Math.sqrt((r100 * r100) + (r103 * r103));
        if (r107 >= 1.0E-6d) goto L5;
        boolean r112 = true;
    L6:
        if (r112 == true) goto L8;
        this.f457024x = Math.atan2(r111, r106);
        this.f457025y = Math.atan2(-r110, r107);
        this.f457026z = Math.atan2(r103, r100);
    L9:
        this.f457024x = (this.f457024x * 180.0d) / 3.141592653589793d;
        this.f457025y = (this.f457025y * 180.0d) / 3.141592653589793d;
        this.f457026z = (this.f457026z * 180.0d) / 3.141592653589793d;
        return;
    L8:
        this.f457024x = Math.atan2(-r105, r104);
        this.f457025y = Math.atan2(-r110, r107);
        this.f457026z = AudioStats.AUDIO_AMPLITUDE_NONE;
        goto L9
    L5:
        r112 = false;
        goto L6
    }

    public static int largestAbsComponent(Vector3d r100) {
        double r101 = Math.abs(r100.f457024x);
        double r102 = Math.abs(r100.f457025y);
        double r103 = Math.abs(r100.f457026z);
        if (r101 <= r102) goto L8;
        if (r101 <= r103) goto L11;
        return 0;
    L11:
        return 2;
    L8:
        if (r102 <= r103) goto L13;
        return 1;
    L13:
        return 2;
    }

    public Vector3d devide(double r100) {
        this.f457024x /= r100;
        this.f457025y /= r100;
        this.f457026z /= r100;
        return this;
    }

    public boolean sameValues(Vector3d r100) {
        if (this.f457024x == r100.f457024x) goto L5;
    L9:
        return false;
    L5:
        if (this.f457025y != r100.f457025y) goto L9;
        if (this.f457026z != r100.f457026z) goto L9;
        return true;
    }

    public Vector3d scale(double r100) {
        this.f457024x *= r100;
        this.f457025y *= r100;
        this.f457026z *= r100;
        return this;
    }

    public void set(Vector3d r100) {
        this.f457024x = r100.f457024x;
        this.f457025y = r100.f457025y;
        this.f457026z = r100.f457026z;
    }

    public Vector3d sub(Vector3d r110) {
        return new Vector3d(this.f457024x - r110.f457024x, this.f457025y - r110.f457025y, this.f457026z - r110.f457026z);
    }

    public Vector3d(Vector3d r100) {
        this.f457024x = r100.f457024x;
        this.f457025y = r100.f457025y;
        this.f457026z = r100.f457026z;
    }

    public static Vector3d add(Vector3d r100, Vector3d r101) {
        return new Vector3d(r100.f457024x + r101.f457024x, r100.f457025y + r101.f457025y, r100.f457026z + r101.f457026z);
    }

    public static Vector3d cross(Vector3d r110, Vector3d r111) {
        double r100 = r110.f457025y;
        double r101 = r111.f457026z;
        double r102 = r110.f457026z;
        double r112 = r111.f457025y;
        double r103 = (r100 * r101) - (r102 * r112);
        double r113 = r111.f457024x;
        double r114 = r110.f457024x;
        return new Vector3d(r103, (r102 * r113) - (r101 * r114), (r114 * r112) - (r100 * r113));
    }

    public static double dot(Vector3d r100, Vector3d r101) {
        return ((r100.f457024x * r101.f457024x) + (r100.f457025y * r101.f457025y)) + (r100.f457026z * r101.f457026z);
    }

    public static void ortho(Vector3d r100, Vector3d r101) {
        int r102 = largestAbsComponent(r100) - 1;
        if (r102 >= 0) goto L5;
        r102 = 2;
    L5:
        r101.setZero();
        r101.setComponent(r102, 1.0d);
        cross(r100, r101, r101);
        r101.normalize();
    }

    public static Vector3d scale(Vector3d r100, double r101) {
        return new Vector3d(r100.f457024x * r101, r100.f457025y * r101, r100.f457026z * r101);
    }

    public void setComponent(int r100, double r101) {
        if (r100 != 0) goto L5;
        this.f457024x = r101;
        return;
    L5:
        if (r100 != 1) goto L7;
        this.f457025y = r101;
        return;
    L7:
        this.f457026z = r101;
    }

    public Vector3d(double r100, double r101, double r102) {
        set(r100, r101, r102);
    }

    public static void add(Vector3d r110, Vector3d r111, Vector3d r112) {
        r112.set(r110.f457024x + r111.f457024x, r110.f457025y + r111.f457025y, r110.f457026z + r111.f457026z);
    }

    public static void cross(Vector3d r210, Vector3d r211, Vector3d r212) {
        double r100 = r210.f457025y;
        double r101 = r211.f457026z;
        double r102 = r210.f457026z;
        double r110 = r211.f457025y;
        double r111 = (r100 * r101) - (r102 * r110);
        double r103 = r211.f457024x;
        double r104 = r210.f457024x;
        r212.set(r111, (r102 * r103) - (r101 * r104), (r104 * r110) - (r100 * r103));
    }

    public static void sub(Vector3d r110, Vector3d r111, Vector3d r112) {
        r112.set(r110.f457024x - r111.f457024x, r110.f457025y - r111.f457025y, r110.f457026z - r111.f457026z);
    }

    public void set(double r100, double r101, double r102) {
        this.f457024x = r100;
        this.f457025y = r101;
        this.f457026z = r102;
    }
}
