package com.ss.android.ttve.common;

import android.graphics.RectF;
import android.opengl.GLES20;
import android.opengl.Matrix;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;

/* JADX INFO: loaded from: classes38.dex */
public final class d {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final float[] f449845h = null;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final float[] f449846i = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public c f449847a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int[] f449848b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public FloatBuffer f449849c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public FloatBuffer f449850d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f449851e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public RectF f449852f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f449853g;

    static {
        f449845h = new float[]{-1.0f, 1.0f, -1.0f, -1.0f, 1.0f, 1.0f, 1.0f, -1.0f};
        f449846i = new float[]{0.0f, 1.0f, 0.0f, 0.0f, 1.0f, 1.0f, 1.0f, 0.0f};
    }

    public final void c() {
        c r100 = this.f449847a;
        int r101 = r100.f449841a;
        if (r101 == 0) goto L5;
        GLES20.glDeleteProgram(r101);
        r100.f449841a = 0;
    L5:
        int[] r102 = this.f449848b;
        if (r102 == null) goto L8;
        GLES20.glDeleteBuffers(r102.length, r102, 0);
        this.f449848b = null;
    L8:
        this.f449847a = null;
        this.f449849c = null;
        this.f449850d = null;
    }

    public d() {
        this.f449853g = Integer.MAX_VALUE;
    }

    public static FloatBuffer a(float[] r100) {
        FloatBuffer r101 = ByteBuffer.allocateDirect(r100.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
        r101.put(r100, 0, r100.length).position(0);
        return r101;
    }

    public final void b(int r110) {
        this.f449847a.a();
        GLES20.glActiveTexture(33984);
        GLES20.glBindTexture(36197, r110);
        GLES20.glBindBuffer(34962, this.f449848b[0]);
        GLES20.glEnableVertexAttribArray(0);
        GLES20.glVertexAttribPointer(0, 2, 5126, false, 0, 0);
        GLES20.glBindBuffer(34962, this.f449848b[1]);
        GLES20.glEnableVertexAttribArray(1);
        GLES20.glVertexAttribPointer(1, 2, 5126, false, 0, 0);
        GLES20.glDrawArrays(5, 0, 4);
    }

    public final void e(RectF r100) {
        if (r100 == null) goto L10;
        RectF r101 = this.f449852f;
        if (r101 != null) goto L6;
    L8:
        this.f449852f = r100;
        float[] r102 = f449846i;
        float r103 = r100.left;
        r102[0] = r103;
        float r104 = 1.0f - r100.top;
        r102[1] = r104;
        r102[2] = r103;
        float r105 = 1.0f - r100.bottom;
        r102[3] = r105;
        float r106 = r100.right;
        r102[4] = r106;
        r102[5] = r104;
        r102[6] = r106;
        r102[7] = r105;
        this.f449850d = a(r102);
        this.f449847a.a();
        GLES20.glBindBuffer(34962, this.f449848b[1]);
        this.f449850d.position(0);
        GLES20.glBufferSubData(34962, 0, 32, this.f449850d);
        return;
    L6:
        if (r100.equals(r101) == false) goto L8;
        return;
    }

    public final void d(int r310, boolean r311, int r312, int r313, int r314, int r315) {
        this.f449847a.a();
        if (r312 <= 0) goto L34;
        if (r313 <= 0) goto L34;
        if (r314 <= 0) goto L34;
        if (r315 <= 0) goto L34;
        if (this.f449853g != r310) goto L11;
        return;
    L11:
        this.f449853g = r310;
        float[] r100 = new float[16];
        Matrix.setIdentityM(r100, 0);
        Matrix.rotateM(r100, 0, r310, 0.0f, 0.0f, 1.0f);
        if (r311 == false) goto L15;
        Matrix.rotateM(r100, 0, 180.0f, 1.0f, 0.0f, 0.0f);
    L15:
        if (Math.abs(r310) != 90) goto L17;
    L20:
        float r110 = r313;
    L22:
        if (Math.abs(r310) != 90) goto L24;
    L27:
        float r101 = r312;
    L28:
        float r111 = r314;
        float r112 = r111 / r110;
        float r113 = r315;
        float r102 = r113 / r101;
        if (r112 > r102) goto L32;
        r112 = r102;
    L32:
        Matrix.scaleM(r100, 0, (r312 / 2.0f) * r112, (r313 / 2.0f) * r112, 1.0f);
        float[] r103 = new float[16];
        Matrix.setIdentityM(r103, 0);
        Matrix.setLookAtM(r103, 0, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f);
        float[] r104 = new float[16];
        Matrix.setIdentityM(r104, 0);
        Matrix.orthoM(r104, 0, (-r314) / 2.0f, r111 / 2.0f, (-r315) / 2.0f, r113 / 2.0f, -2.0f, 2.0f);
        float[] r105 = new float[16];
        Matrix.setIdentityM(r105, 0);
        Matrix.multiplyMM(r105, 0, r103, 0, r100, 0);
        float[] r106 = new float[16];
        Matrix.setIdentityM(r106, 0);
        Matrix.multiplyMM(r106, 0, r104, 0, r105, 0);
        GLES20.glUniformMatrix4fv(this.f449851e, 1, false, r106, 0);
        return;
    L24:
        if (Math.abs(r310) == 270) goto L27;
        r101 = r313;
        goto L28
    L17:
        if (Math.abs(r310) == 270) goto L20;
        r110 = r312;
    L34:
        float[] r107 = new float[16];
        Matrix.setIdentityM(r107, 0);
        GLES20.glUniformMatrix4fv(this.f449851e, 1, false, r107, 0);
    }
}
