package uk6;

import android.opengl.GLES20;

/* JADX INFO: loaded from: classes19.dex */
public final class a {
    static {
    }

    public static int a(int r100) {
        int r101 = GLES20.glCreateShader(r100);
        if (r101 == 0) goto L8;
        GLES20.glShaderSource(r101, null);
        GLES20.glCompileShader(r101);
        int[] r102 = new int[1];
        GLES20.glGetShaderiv(r101, 35713, r102, 0);
        if (r102[0] != 0) goto L9;
        GLES20.glDeleteShader(r101);
        return 0;
    L9:
        return r101;
    L8:
        return r101;
    }
}
