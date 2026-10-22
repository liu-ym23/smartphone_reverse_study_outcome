package com.bytedance.bmmt.video;

import android.opengl.GLES20;
import com.bytedance.bmmt.base.Logging;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;

/* JADX INFO: loaded from: classes8.dex */
public class GlUtil {
    private GlUtil() {
    }

    public static void checkNoGLES2Error(String r100) {
        int r101 = GLES20.glGetError();
        if (r101 == 0) goto L9;
        Logging.e("checkNoGLES2Error", r100 + "error: " + r101);
        if (r101 != 1285) goto L8;
        return;
    L8:
        throw new RuntimeException(r100 + ": GLES20 error: " + r101);
    }

    public static void clearGLES2Error(String r100) {
        int r101 = GLES20.glGetError();
        if (r101 == 0) goto L6;
        Logging.w("clearGLES2Error", r100 + "clear opengl error: " + r101);
        return;
    }

    public static FloatBuffer createFloatBuffer(float[] r100) {
        ByteBuffer r101 = ByteBuffer.allocateDirect(r100.length * 4);
        r101.order(ByteOrder.nativeOrder());
        FloatBuffer r102 = r101.asFloatBuffer();
        r102.put(r100);
        r102.position(0);
        return r102;
    }

    public static int generateTexture(int r100) {
        int[] r101 = new int[1];
        GLES20.glGenTextures(1, r101, 0);
        int r102 = r101[0];
        GLES20.glBindTexture(r100, r102);
        GLES20.glTexParameterf(r100, 10241, 9729.0f);
        GLES20.glTexParameterf(r100, 10240, 9729.0f);
        GLES20.glTexParameterf(r100, 10242, 33071.0f);
        GLES20.glTexParameterf(r100, 10243, 33071.0f);
        checkNoGLES2Error("generateTexture");
        return r102;
    }
}
