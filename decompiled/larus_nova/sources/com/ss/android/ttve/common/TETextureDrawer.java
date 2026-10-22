package com.ss.android.ttve.common;

import android.opengl.GLES20;
import com.ss.android.vesdk.VELogUtil;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;

/* JADX INFO: loaded from: classes38.dex */
public class TETextureDrawer {
    public static final int DRAW_FUNCTION = 5;
    protected static final String m_fsh = "precision mediump float;\nvarying vec2 texCoord;\nuniform sampler2D inputImageTexture;\nvoid main()\n{\n   gl_FragColor = texture2D(inputImageTexture, texCoord);\n}";
    protected static final String m_vsh = "attribute vec2 vPosition;\nvarying vec2 texCoord;\nuniform mat2 rotation;\nuniform vec2 flipScale;\nvoid main()\n{\n   gl_Position = vec4(vPosition, 0.0, 1.0);\n   texCoord = flipScale * (vPosition / 2.0 * rotation) + 0.5;\n}";
    public static final float[] vertices = null;
    private int mFlipScaleLoc;
    protected c mProgram;
    private int mRotLoc;
    private int mVertBuffer;

    static {
        vertices = new float[]{-1.0f, -1.0f, 1.0f, -1.0f, -1.0f, 1.0f, 1.0f, 1.0f};
    }

    public static TETextureDrawer create() {
        TETextureDrawer r100 = new TETextureDrawer();
        if (r100.init(m_vsh, m_fsh) == true) goto L6;
        VELogUtil.e("TETextureDrawer", "TETextureDrawer create failed!");
        r100.release();
        return null;
    L6:
        return r100;
    }

    public void release() {
        c r100 = this.mProgram;
        if (r100 == null) goto L8;
        int r101 = r100.f449841a;
        if (r101 == 0) goto L7;
        GLES20.glDeleteProgram(r101);
        r100.f449841a = 0;
    L7:
        this.mProgram = null;
    L8:
        int r102 = this.mVertBuffer;
        if (r102 == 0) goto L12;
        GLES20.glDeleteBuffers(1, new int[]{r102}, 0);
        this.mVertBuffer = 0;
        return;
    }

    public void bindVertexBuffer() {
        GLES20.glBindBuffer(34962, this.mVertBuffer);
    }

    public TETextureDrawer() {
    }

    public void drawTexture(int r100) {
        drawTexture(r100, 3553);
    }

    public void setRotation(float r100) {
        double r101 = r100;
        float r102 = (float) Math.cos(r101);
        float r103 = (float) Math.sin(r101);
        this.mProgram.a();
        GLES20.glUniformMatrix2fv(this.mRotLoc, 1, false, new float[]{r102, r103, -r103, r102}, 0);
    }

    public void drawTexture(int r100, int r101) {
        GLES20.glActiveTexture(33984);
        GLES20.glBindTexture(r101, r100);
        GLES20.glBindBuffer(34962, this.mVertBuffer);
        GLES20.glEnableVertexAttribArray(0);
        GLES20.glVertexAttribPointer(0, 2, 5126, false, 0, 0);
        this.mProgram.a();
        GLES20.glDrawArrays(5, 0, 4);
    }

    public boolean init(String r100, String r101) {
        c r102 = new c();
        this.mProgram = r102;
        if (r102.c(r100, r101) == true) goto L9;
        c r103 = this.mProgram;
        int r104 = r103.f449841a;
        if (r104 == 0) goto L7;
        GLES20.glDeleteProgram(r104);
        r103.f449841a = 0;
    L7:
        this.mProgram = null;
        return false;
    L9:
        this.mProgram.a();
        this.mRotLoc = this.mProgram.b("rotation");
        this.mFlipScaleLoc = this.mProgram.b("flipScale");
        GLES20.glBindAttribLocation(this.mProgram.f449841a, 0, "vPosition");
        int[] r105 = new int[1];
        GLES20.glGenBuffers(1, r105, 0);
        int r106 = r105[0];
        this.mVertBuffer = r106;
        GLES20.glBindBuffer(34962, r106);
        float[] r107 = vertices;
        FloatBuffer r108 = ByteBuffer.allocateDirect(r107.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
        r108.put(r107).position(0);
        GLES20.glBufferData(34962, 32, r108, 35044);
        setRotation(0.0f);
        setFlipScale(1.0f, 1.0f);
        VELogUtil.i("TETextureDrawer", "init: success.");
        return true;
    }

    public void setFlipScale(float r100, float r101) {
        this.mProgram.a();
        GLES20.glUniform2f(this.mFlipScaleLoc, 1.0f / r100, 1.0f / r101);
    }
}
