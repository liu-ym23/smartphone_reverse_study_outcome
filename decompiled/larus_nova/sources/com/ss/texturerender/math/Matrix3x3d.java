package com.ss.texturerender.math;

import androidx.camera.video.AudioStats;

/* JADX INFO: loaded from: classes40.dex */
public class Matrix3x3d {

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public double[] f457019m;

    public double determinant() {
        return ((get(0, 0) * ((get(1, 1) * get(2, 2)) - (get(2, 1) * get(1, 2)))) - (get(0, 1) * ((get(1, 0) * get(2, 2)) - (get(1, 2) * get(2, 0))))) + (get(0, 2) * ((get(1, 0) * get(2, 1)) - (get(1, 1) * get(2, 0))));
    }

    public double maxNorm() {
        double r100 = Math.abs(this.f457019m[0]);
        int r101 = 1;
    L3:
        double[] r102 = this.f457019m;
        if (r101 >= r102.length) goto L6;
        r100 = Math.max(r100, Math.abs(r102[r101]));
        r101 = r101 + 1;
        goto L3
    L6:
        return r100;
    }

    public Matrix3x3d setIdentity() {
        double[] r100 = this.f457019m;
        r100[7] = 0.0d;
        r100[6] = 0.0d;
        r100[5] = 0.0d;
        r100[3] = 0.0d;
        r100[2] = 0.0d;
        r100[1] = 0.0d;
        r100[8] = 1.0d;
        r100[4] = 1.0d;
        r100[0] = 1.0d;
        return this;
    }

    public void setZero() {
        double[] r100 = this.f457019m;
        r100[8] = 0.0d;
        r100[7] = 0.0d;
        r100[6] = 0.0d;
        r100[5] = 0.0d;
        r100[4] = 0.0d;
        r100[3] = 0.0d;
        r100[2] = 0.0d;
        r100[1] = 0.0d;
        r100[0] = 0.0d;
    }

    public double toEulerPitch() {
        return Math.asin(-this.f457019m[5]);
    }

    public double toEulerRoll() {
        double[] r100 = this.f457019m;
        return Math.atan2(r100[3], r100[4]);
    }

    public double toEulerYaw() {
        double[] r100 = this.f457019m;
        return Math.atan2(r100[2], r100[8]);
    }

    public Matrix3x3d transpose() {
        Matrix3x3d r100 = new Matrix3x3d();
        double[] r101 = this.f457019m;
        double r102 = r101[1];
        double r103 = r101[2];
        double r104 = r101[5];
        double[] r110 = r100.f457019m;
        r110[0] = r101[0];
        r110[1] = r101[3];
        r110[2] = r101[6];
        r110[3] = r102;
        r110[4] = r101[4];
        r110[5] = r101[7];
        r110[6] = r103;
        r110[7] = r104;
        r110[8] = r101[8];
        return r100;
    }

    public Matrix3x3d() {
        this.f457019m = new double[9];
    }

    public Matrix3x3d(Matrix3x3d r100) {
        this.f457019m = new double[]{r5[0], r5[1], r5[2], r5[3], r5[4], r5[5], r5[6], r5[7], r5[8]};
        double[] r101 = r100.f457019m;
    }

    public static Matrix3x3d rotationMatrix3x3(Quaternion r410) {
        double r100 = r410.getX0() * r410.getX0();
        double r101 = r410.getX1() * r410.getX1();
        double r102 = r410.getX2() * r410.getX2();
        double r103 = r410.getX3() * r410.getX3();
        double r104 = r410.getX0() * r410.getX1();
        double r110 = r410.getX0() * r410.getX2();
        double r111 = r410.getX1() * r410.getX2();
        double r112 = r410.getX0() * r410.getX3();
        double r113 = r410.getX1() * r410.getX3();
        double r105 = r104 * 2.0d;
        double r114 = (r410.getX2() * r410.getX3()) * 2.0d;
        double r115 = r110 * 2.0d;
        double r116 = r113 * 2.0d;
        double r106 = -r100;
        double r117 = r111 * 2.0d;
        double r118 = r112 * 2.0d;
        return new Matrix3x3d(((r100 - r101) - r102) + r103, r105 - r114, r115 + r116, r105 + r114, ((r106 + r101) - r102) + r103, r117 - r118, r115 - r116, r117 + r118, ((r106 - r101) + r102) + r103);
    }

    public boolean invert(Matrix3x3d r310) {
        double r100 = determinant();
        if (r100 != AudioStats.AUDIO_AMPLITUDE_NONE) goto L5;
        return false;
    L5:
        double r101 = 1.0d / r100;
        double[] r102 = this.f457019m;
        double r103 = r102[4];
        double r104 = r102[8];
        double r110 = r102[7];
        double r111 = r102[5];
        double r112 = ((r103 * r104) - (r110 * r111)) * r101;
        double r311 = r102[1];
        double r210 = r102[2];
        double r113 = (-((r311 * r104) - (r210 * r110))) * r101;
        double r211 = ((r311 * r111) - (r210 * r103)) * r101;
        double r105 = r102[3];
        double r312 = r102[6];
        double r212 = (-((r105 * r104) - (r111 * r312))) * r101;
        double r106 = r102[0];
        r310.set(r112, r113, r211, r212, ((r104 * r106) - (r210 * r312)) * r101, (-((r111 * r106) - (r210 * r105))) * r101, ((r105 * r110) - (r312 * r103)) * r101, (-((r110 * r106) - (r312 * r311))) * r101, ((r106 * r103) - (r105 * r311)) * r101);
        return true;
    }

    public void minusEquals(Matrix3x3d r100) {
        double[] r101 = this.f457019m;
        double r102 = r101[0];
        double[] r103 = r100.f457019m;
        r101[0] = r102 - r103[0];
        r101[1] = r101[1] - r103[1];
        r101[2] = r101[2] - r103[2];
        r101[3] = r101[3] - r103[3];
        r101[4] = r101[4] - r103[4];
        r101[5] = r101[5] - r103[5];
        r101[6] = r101[6] - r103[6];
        r101[7] = r101[7] - r103[7];
        r101[8] = r101[8] - r103[8];
    }

    public Matrix3x3d mult(double r100) {
        Matrix3x3d r101 = new Matrix3x3d();
        int r102 = 0;
    L4:
        if (r102 >= 9) goto L6;
        r101.f457019m[r102] = this.f457019m[r102] * r100;
        r102 = r102 + 1;
        goto L4
    L6:
        return r101;
    }

    public void plusEquals(Matrix3x3d r100) {
        double[] r101 = this.f457019m;
        double r102 = r101[0];
        double[] r103 = r100.f457019m;
        r101[0] = r102 + r103[0];
        r101[1] = r101[1] + r103[1];
        r101[2] = r101[2] + r103[2];
        r101[3] = r101[3] + r103[3];
        r101[4] = r101[4] + r103[4];
        r101[5] = r101[5] + r103[5];
        r101[6] = r101[6] + r103[6];
        r101[7] = r101[7] + r103[7];
        r101[8] = r101[8] + r103[8];
    }

    public void scale(double r100) {
        double[] r101 = this.f457019m;
        r101[0] = r101[0] * r100;
        r101[1] = r101[1] * r100;
        r101[2] = r101[2] * r100;
        r101[3] = r101[3] * r100;
        r101[4] = r101[4] * r100;
        r101[5] = r101[5] * r100;
        r101[6] = r101[6] * r100;
        r101[7] = r101[7] * r100;
        r101[8] = r101[8] * r100;
    }

    public void set(Matrix3x3d r100) {
        double[] r101 = this.f457019m;
        double[] r102 = r100.f457019m;
        r101[0] = r102[0];
        r101[1] = r102[1];
        r101[2] = r102[2];
        r101[3] = r102[3];
        r101[4] = r102[4];
        r101[5] = r102[5];
        r101[6] = r102[6];
        r101[7] = r102[7];
        r101[8] = r102[8];
    }

    public void setSameDiagonal(double r100) {
        double[] r101 = this.f457019m;
        r101[8] = r100;
        r101[4] = r100;
        r101[0] = r100;
    }

    public static void matrixToColumnArray(Matrix3x3d r100, float[] r101) {
        r101[0] = (float) r100.get(0, 0);
        r101[4] = (float) r100.get(0, 1);
        r101[8] = (float) r100.get(0, 2);
        r101[1] = (float) r100.get(1, 0);
        r101[5] = (float) r100.get(1, 1);
        r101[9] = (float) r100.get(1, 2);
        r101[2] = (float) r100.get(2, 0);
        r101[6] = (float) r100.get(2, 1);
        r101[10] = (float) r100.get(2, 2);
        r101[11] = 0.0f;
        r101[7] = 0.0f;
        r101[3] = 0.0f;
        r101[14] = 0.0f;
        r101[13] = 0.0f;
        r101[12] = 0.0f;
        r101[15] = 1.0f;
    }

    public static Matrix3x3d mult(Matrix3x3d r410, Matrix3x3d r411) {
        double[] r110 = r410.f457019m;
        double r100 = r110[0];
        double[] r101 = r411.f457019m;
        double r111 = r101[0];
        double r102 = r110[1];
        double r112 = r101[3];
        double r210 = r110[2];
        double r211 = r101[6];
        double r103 = ((r100 * r111) + (r102 * r112)) + (r210 * r211);
        double r212 = r101[1];
        double r213 = r101[4];
        double r214 = r101[7];
        double r104 = ((r100 * r212) + (r102 * r213)) + (r210 * r214);
        double r310 = r101[2];
        double r311 = r101[5];
        double r312 = r101[8];
        double r105 = ((r100 * r310) + (r102 * r311)) + (r210 * r312);
        double r215 = r110[3];
        double r313 = r110[4];
        double r113 = r110[5];
        double r106 = ((r215 * r111) + (r313 * r112)) + (r113 * r211);
        double r107 = ((r215 * r212) + (r313 * r213)) + (r113 * r214);
        double r114 = ((r215 * r310) + (r313 * r311)) + (r113 * r312);
        double r216 = r110[6];
        double r314 = r110[7];
        double r115 = r110[8];
        return new Matrix3x3d(r103, r104, r105, r106, r107, r114, ((r111 * r216) + (r112 * r314)) + (r211 * r115), ((r212 * r216) + (r213 * r314)) + (r214 * r115), ((r216 * r310) + (r314 * r311)) + (r115 * r312));
    }

    public double get(int r100, int r101) {
        return this.f457019m[(r100 * 3) + r101];
    }

    public void getColumn(int r100, Vector3d r101) {
        double[] r102 = this.f457019m;
        r101.f457024x = r102[r100];
        r101.f457025y = r102[r100 + 3];
        r101.f457026z = r102[r100 + 6];
    }

    public void setColumn(int r100, Vector3d r101) {
        double[] r102 = this.f457019m;
        r102[r100] = r101.f457024x;
        r102[r100 + 3] = r101.f457025y;
        r102[r100 + 6] = r101.f457026z;
    }

    public static void add(Matrix3x3d r100, Matrix3x3d r101, Matrix3x3d r102) {
        double[] r103 = r102.f457019m;
        double[] r104 = r100.f457019m;
        double r105 = r104[0];
        double[] r106 = r101.f457019m;
        r103[0] = r105 + r106[0];
        r103[1] = r104[1] + r106[1];
        r103[2] = r104[2] + r106[2];
        r103[3] = r104[3] + r106[3];
        r103[4] = r104[4] + r106[4];
        r103[5] = r104[5] + r106[5];
        r103[6] = r104[6] + r106[6];
        r103[7] = r104[7] + r106[7];
        r103[8] = r104[8] + r106[8];
    }

    public static void mult(Matrix3x3d r410, Matrix3x3d r411, Matrix3x3d r412) {
        double[] r110 = r410.f457019m;
        double r100 = r110[0];
        double[] r101 = r411.f457019m;
        double r111 = r101[0];
        double r102 = r110[1];
        double r112 = r101[3];
        double r113 = r110[2];
        double r210 = r101[6];
        double r103 = ((r100 * r111) + (r102 * r112)) + (r113 * r210);
        double r211 = r101[1];
        double r212 = r101[4];
        double r213 = r101[7];
        double r104 = ((r100 * r211) + (r102 * r212)) + (r113 * r213);
        double r310 = r101[2];
        double r311 = r101[5];
        double r312 = r101[8];
        double r105 = ((r100 * r310) + (r102 * r311)) + (r113 * r312);
        double r114 = r110[3];
        double r313 = r110[4];
        double r115 = r110[5];
        double r106 = ((r114 * r111) + (r313 * r112)) + (r115 * r210);
        double r107 = ((r114 * r211) + (r313 * r212)) + (r115 * r213);
        double r116 = ((r114 * r310) + (r313 * r311)) + (r115 * r312);
        double r117 = r110[6];
        double r314 = r110[7];
        double r315 = r110[8];
        r412.set(r103, r104, r105, r106, r107, r116, ((r111 * r117) + (r112 * r314)) + (r210 * r315), ((r211 * r117) + (r212 * r314)) + (r213 * r315), ((r117 * r310) + (r314 * r311)) + (r315 * r312));
    }

    public void set(int r100, int r101, double r102) {
        this.f457019m[(r100 * 3) + r101] = r102;
    }

    public static void mult(Matrix3x3d r110, Vector3d r111, Vector3d r112) {
        double[] r113 = r110.f457019m;
        double r100 = r113[0];
        double r101 = r111.f457024x;
        double r102 = r113[1];
        double r103 = r111.f457025y;
        double r104 = (r100 * r101) + (r102 * r103);
        double r105 = r113[2];
        double r106 = r111.f457026z;
        double r107 = r104 + (r105 * r106);
        double r108 = ((r113[3] * r101) + (r113[4] * r103)) + (r113[5] * r106);
        double r114 = ((r113[6] * r101) + (r113[7] * r103)) + (r113[8] * r106);
        r112.f457024x = r107;
        r112.f457025y = r108;
        r112.f457026z = r114;
    }

    public Matrix3x3d(double r100, double r101, double r102, double r110, double r111, double r112, double r113, double r114, double r210) {
        this.f457019m = new double[]{r100, r101, r102, r110, r111, r112, r113, r114, r210};
    }

    public void set(double r100, double r101, double r102, double r110, double r111, double r112, double r113, double r114, double r210) {
        double[] r103 = this.f457019m;
        r103[0] = r100;
        r103[1] = r101;
        r103[2] = r102;
        r103[3] = r110;
        r103[4] = r111;
        r103[5] = r112;
        r103[6] = r113;
        r103[7] = r114;
        r103[8] = r210;
    }
}
