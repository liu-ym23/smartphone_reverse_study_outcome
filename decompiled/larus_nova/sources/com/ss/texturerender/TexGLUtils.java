package com.ss.texturerender;

import android.opengl.GLES20;
import android.opengl.GLUtils;

/* JADX INFO: loaded from: classes40.dex */
public class TexGLUtils {
    private static final String LOG_TAG = "GLUtils";

    public TexGLUtils() {
    }

    public static int createFbo() {
        int[] r100 = new int[1];
        GLES20.glGenFramebuffers(1, r100, 0);
        checkGLError(-1, "createFbo");
        return r100[0];
    }

    public static void deleteFbo(int r100) {
        if (r100 <= 0) goto L5;
        GLES20.glDeleteFramebuffers(1, new int[]{r100}, 0);
        return;
    }

    public static void deleteTexture(int r100) {
        if (r100 <= 0) goto L5;
        GLES20.glDeleteTextures(1, new int[]{r100}, 0);
        return;
    }

    public static int genTexture(int r100) {
        int[] r101 = new int[1];
        GLES20.glGenTextures(1, r101, 0);
        checkGLError(-1, "glGenTextures");
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

    public static int checkGLError(int r100, String r101) {
        int r102 = GLES20.glGetError();
        if (r102 == 0) goto L5;
        TextureRenderLog.e(r100, "GLUtils", r101 + ": gl error = " + GLUtils.getEGLErrorString(r102));
    L5:
        return r102;
    }

    public static int genTexture(int r100, int r101) {
        int[] r102 = new int[1];
        GLES20.glGenTextures(1, r102, 0);
        checkGLError(-1, "glGenTextures");
        int r103 = r102[0];
        if (r103 == 0) goto L6;
        GLES20.glBindTexture(r100, r103);
        GLES20.glTexParameteri(r100, 10242, 33071);
        GLES20.glTexParameteri(r100, 10243, 33071);
        GLES20.glTexParameteri(r100, 10241, r101);
        GLES20.glTexParameteri(r100, 10240, r101);
    L6:
        return r102[0];
    }
}
