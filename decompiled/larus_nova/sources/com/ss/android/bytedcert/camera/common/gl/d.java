package com.ss.android.bytedcert.camera.common.gl;

import android.opengl.GLES20;
import com.ss.android.cert.manager.utils.CertLog;

/* JADX INFO: loaded from: classes34.dex */
public final class d {
    public static int a() {
        int[] r100 = new int[1];
        GLES20.glGenTextures(1, r100, 0);
        GLES20.glBindTexture(36197, r100[0]);
        GLES20.glTexParameterf(36197, 10241, 9729.0f);
        GLES20.glTexParameterf(36197, 10240, 9729.0f);
        GLES20.glTexParameteri(36197, 10242, 33071);
        GLES20.glTexParameteri(36197, 10243, 33071);
        return r100[0];
    }

    public static int b(String r100, int r101) {
        int[] r102 = new int[1];
        int r103 = GLES20.glCreateShader(r101);
        GLES20.glShaderSource(r103, r100);
        GLES20.glCompileShader(r103);
        GLES20.glGetShaderiv(r103, 35713, r102, 0);
        if (r102[0] != 0) goto L6;
        CertLog.e("Load Shader Failed", "Compilation\n" + GLES20.glGetShaderInfoLog(r103));
        return 0;
    L6:
        return r103;
    }
}
