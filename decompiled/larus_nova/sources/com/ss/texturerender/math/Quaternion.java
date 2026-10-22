package com.ss.texturerender.math;

import androidx.camera.video.AudioStats;
import java.util.Locale;

/* JADX INFO: loaded from: classes40.dex */
public class Quaternion {

    /* JADX INFO: renamed from: x0, reason: collision with root package name */
    private double f457020x0;

    /* JADX INFO: renamed from: x1, reason: collision with root package name */
    private double f457021x1;

    /* JADX INFO: renamed from: x2, reason: collision with root package name */
    private double f457022x2;

    /* JADX INFO: renamed from: x3, reason: collision with root package name */
    private double f457023x3;

    public Quaternion conjugate() {
        return new Quaternion(-this.f457020x0, -this.f457021x1, -this.f457022x2, this.f457023x3);
    }

    public double getAngle() {
        if (new Vector3d(this.f457020x0, this.f457021x1, this.f457022x2).length() != AudioStats.AUDIO_AMPLITUDE_NONE) goto L5;
        return AudioStats.AUDIO_AMPLITUDE_NONE;
    L5:
        return Math.acos(this.f457023x3) * 2.0d;
    }

    public Vector3d getAxis() {
        Vector3d r100 = new Vector3d(this.f457020x0, this.f457021x1, this.f457022x2);
        if (r100.normalize() == true) goto L5;
        r100.set(1.0d, AudioStats.AUDIO_AMPLITUDE_NONE, AudioStats.AUDIO_AMPLITUDE_NONE);
    L5:
        return r100;
    }

    public Quaternion inverse() {
        double r100 = this.f457020x0;
        double r101 = this.f457021x1;
        double r102 = (r100 * r100) + (r101 * r101);
        double r103 = this.f457022x2;
        double r104 = r102 + (r103 * r103);
        double r105 = this.f457023x3;
        double r106 = r104 + (r105 * r105);
        return new Quaternion((-r100) / r106, (-r101) / r106, (-r103) / r106, r105 / r106);
    }

    public double norm() {
        double r100 = this.f457020x0;
        double r101 = this.f457021x1;
        double r102 = (r100 * r100) + (r101 * r101);
        double r103 = this.f457022x2;
        double r104 = r102 + (r103 * r103);
        double r105 = this.f457023x3;
        return Math.sqrt(r104 + (r105 * r105));
    }

    public Quaternion() {
        this.f457022x2 = AudioStats.AUDIO_AMPLITUDE_NONE;
        this.f457021x1 = AudioStats.AUDIO_AMPLITUDE_NONE;
        this.f457020x0 = AudioStats.AUDIO_AMPLITUDE_NONE;
        this.f457023x3 = 1.0d;
    }

    public boolean normalize() {
        double r100 = norm();
        if (r100 != AudioStats.AUDIO_AMPLITUDE_NONE) goto L6;
        return false;
    L6:
        this.f457020x0 /= r100;
        this.f457021x1 /= r100;
        this.f457022x2 /= r100;
        this.f457023x3 /= r100;
        return true;
    }

    public String toString() {
        return String.format(Locale.getDefault(), "%.5f i + %.5f j + %.5f k + %.5f", new Object[]{Double.valueOf(this.f457020x0), Double.valueOf(this.f457021x1), Double.valueOf(this.f457022x2), Double.valueOf(this.f457023x3)});
    }

    public double getX0() {
        return this.f457020x0;
    }

    public double getX1() {
        return this.f457021x1;
    }

    public double getX2() {
        return this.f457022x2;
    }

    public double getX3() {
        return this.f457023x3;
    }

    public Quaternion(float[] r310) {
        double r100 = r310[0];
        double r101 = r310[4];
        double r102 = r310[8];
        double r103 = r310[1];
        double r110 = r310[5];
        double r111 = r310[9];
        double r104 = r310[2];
        double r105 = r310[6];
        double r106 = r310[10];
        double r210 = (r100 + r110) + r106;
        if (r210 <= AudioStats.AUDIO_AMPLITUDE_NONE) goto L6;
        double r107 = Math.sqrt(r210 + 1.0d) * 2.0d;
        double r108 = (r105 - r111) / r107;
        double r109 = (r102 - r104) / r107;
        double r112 = (r103 - r101) / r107;
        double r113 = 0.25d * r107;
    L20:
        this.f457020x0 = r108;
        this.f457021x1 = r109;
        this.f457022x2 = r112;
        this.f457023x3 = r113;
        normalize();
        return;
    L6:
        if (r100 <= r110) goto L8;
        boolean r114 = true;
    L10:
        if (r100 <= r106) goto L12;
        boolean r115 = true;
    L14:
        if ((r114 & r115) == false) goto L17;
        double r116 = Math.sqrt(((r100 + 1.0d) - r110) - r106) * 2.0d;
        double r117 = (r105 - r111) / r116;
        double r118 = r116 * 0.25d;
        double r119 = (r101 + r103) / r116;
        double r120 = (r102 + r104) / r116;
        r109 = r119;
        r108 = r118;
        r112 = r120;
        r113 = r117;
        goto L20
    L17:
        if (r110 <= r106) goto L19;
        double r121 = Math.sqrt(((r110 + 1.0d) - r100) - r106) * 2.0d;
        double r122 = (r101 + r103) / r121;
        double r123 = r121 * 0.25d;
        double r124 = (r111 + r105) / r121;
        r113 = (r102 - r104) / r121;
        r109 = r123;
        r112 = r124;
        r108 = r122;
        goto L20
    L19:
        double r125 = Math.sqrt(((r106 + 1.0d) - r100) - r110) * 2.0d;
        double r126 = (r103 - r101) / r125;
        double r127 = (r102 + r104) / r125;
        double r128 = (r111 + r105) / r125;
        double r129 = r125 * 0.25d;
        r113 = r126;
        r112 = r129;
        r108 = r127;
        r109 = r128;
        goto L20
    L12:
        r115 = false;
        goto L14
    L8:
        r114 = false;
        goto L10
    }

    public Quaternion divides(Quaternion r100) {
        return times(r100.inverse());
    }

    public Quaternion times(Quaternion r310) {
        double r100 = r310.f457023x3;
        double r101 = this.f457020x0;
        double r102 = r310.f457020x0;
        double r110 = this.f457023x3;
        double r103 = (r100 * r101) + (r102 * r110);
        double r111 = r310.f457022x2;
        double r112 = this.f457021x1;
        double r104 = r103 + (r111 * r112);
        double r105 = r310.f457021x1;
        double r113 = this.f457022x2;
        return new Quaternion(r104 - (r105 * r113), (((r100 * r112) + (r105 * r110)) + (r102 * r113)) - (r111 * r101), (((r100 * r113) + (r111 * r110)) + (r105 * r101)) - (r102 * r112), (((r100 * r110) - (r102 * r101)) - (r105 * r112)) - (r113 * r111));
    }

    public static Vector3d applyToVector(Vector3d r100, Quaternion r101) {
        Vector3d r102 = new Vector3d(r101.getX0(), r101.getX1(), r101.getX2());
        Vector3d r103 = Vector3d.cross(r102, r100).scale(2.0d);
        return Vector3d.add(Vector3d.add(r100, Vector3d.scale(r103, r101.getX3())), Vector3d.cross(r102, r103));
    }

    public static Quaternion fromAxisAndAngle(Vector3d r110, double r111) {
        if (r110.normalize() == false) goto L5;
        double r112 = r111 / 2.0d;
        double r100 = Math.sin(r112);
        return new Quaternion(r110.f457024x * r100, r110.f457025y * r100, r110.f457026z * r100, Math.cos(r112));
    L5:
        return new Quaternion();
    }

    public static Quaternion rotateInto(Vector3d r110, Vector3d r111) {
        double r100 = Math.sqrt(Vector3d.dot(r110, r110) * Vector3d.dot(r111, r111));
        double r101 = Vector3d.dot(r110, r111) + r100;
        if (r101 < (r100 * 9.9999998245167E-14d)) goto L5;
        Vector3d r112 = Vector3d.cross(r110, r111);
    L10:
        double r102 = r112.f457024x;
        double r103 = r112.f457025y;
        double r104 = r112.f457026z;
        return new Quaternion(r102, r103, r104, r101);
    L5:
        if (Math.abs(r110.f457024x) <= Math.abs(r110.f457026z)) goto L7;
        r112 = new Vector3d(-r110.f457025y, r110.f457024x, AudioStats.AUDIO_AMPLITUDE_NONE);
    L8:
        r101 = AudioStats.AUDIO_AMPLITUDE_NONE;
        goto L10
    L7:
        r112 = new Vector3d(AudioStats.AUDIO_AMPLITUDE_NONE, -r110.f457026z, r110.f457025y);
        goto L8
    }

    public Quaternion(double r100, double r101, double r102, double r103) {
        this.f457020x0 = r100;
        this.f457021x1 = r101;
        this.f457022x2 = r102;
        this.f457023x3 = r103;
        normalize();
    }
}
