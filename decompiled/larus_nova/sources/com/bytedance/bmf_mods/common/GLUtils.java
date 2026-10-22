package com.bytedance.bmf_mods.common;

import android.opengl.GLES20;

/* JADX INFO: loaded from: classes44.dex */
public class GLUtils {
    public GLUtils() {
    }

    public static int createFbo() {
        int[] r100 = new int[1];
        GLES20.glGenFramebuffers(1, r100, 0);
        checkGLError("GLUtils: createFbo");
        return r100[0];
    }

    public static boolean checkGLError(String r100) {
        int r101 = GLES20.glGetError();
        if (r101 == 0) goto L6;
        Logging.d(" " + r100 + " : " + android.opengl.GLUtils.getEGLErrorString(r101));
        return true;
    L6:
        return false;
    }

    public static void deleteFbo(int r100) {
        if (r100 <= 0) goto L5;
        GLES20.glDeleteFramebuffers(1, new int[r100], 0);
        return;
    }

    public static void deleteTexture(int r100) {
        if (r100 <= 0) goto L5;
        GLES20.glDeleteTextures(1, new int[r100], 0);
        return;
    }

    public static int genTexture(int r100) {
        int[] r101 = new int[1];
        GLES20.glGenTextures(1, r101, 0);
        checkGLError("GLUtils: glGenTextures");
        int r102 = r101[0];
        if (r102 == 0) goto L6;
        GLES20.glBindTexture(r100, r102);
        GLES20.glTexParameteri(r100, 10242, 33071);
        GLES20.glTexParameteri(r100, 10243, 33071);
        GLES20.glTexParameteri(r100, 10241, 9729);
        GLES20.glTexParameteri(r100, 10240, 9729);
    L6:
        return r101[0];
    }

    public static String texTargetToString(int r100) {
        if (r100 != 36197) goto L7;
        return "texture_oes";
    L7:
        if (r100 != 3553) goto L11;
        return "texture_2d";
    L11:
        return Integer.toString(r100);
    }
}
