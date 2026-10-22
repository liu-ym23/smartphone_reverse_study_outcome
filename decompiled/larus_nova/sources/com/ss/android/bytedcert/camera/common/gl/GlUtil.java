package com.ss.android.bytedcert.camera.common.gl;

import android.opengl.GLES20;

/* JADX INFO: loaded from: classes34.dex */
public final class GlUtil {

    public static class GlException extends RuntimeException {
        public GlException(String r100) {
            super(r100);
        }
    }

    public static void a(String r100) {
        int r101 = GLES20.glGetError();
        if (r101 != 0) goto L6;
        return;
    L6:
        throw new GlException(r100 + ": glError 0x" + Integer.toHexString(r101));
    }

    public static void b(int r110, int r111, int[] r112) {
        GLES20.glGenTextures(1, r112, 0);
        GLES20.glBindTexture(3553, r112[0]);
        GLES20.glTexParameterf(3553, 10240, 9729.0f);
        GLES20.glTexParameterf(3553, 10241, 9729.0f);
        GLES20.glTexParameterf(3553, 10242, 33071.0f);
        GLES20.glTexParameterf(3553, 10243, 33071.0f);
        GLES20.glTexImage2D(3553, 0, 6408, r110, r111, 0, 6408, 5121, null);
        int r113 = r112[0];
    }
}
