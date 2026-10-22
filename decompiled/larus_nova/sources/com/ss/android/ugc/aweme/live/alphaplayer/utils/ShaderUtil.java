package com.ss.android.ugc.aweme.live.alphaplayer.utils;

import android.content.res.Resources;
import android.opengl.GLES20;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;

/* JADX INFO: loaded from: classes40.dex */
public class ShaderUtil {
    public static void a() {
    L3:
        if (GLES20.glGetError() != 0) goto L3;
    }

    public static int b(String r100, String r101) {
        int r102 = d(35633, r100);
        if (r102 != 0) goto L5;
        return 0;
    L5:
        int r103 = d(35632, r101);
        if (r103 != 0) goto L8;
        return 0;
    L8:
        int r104 = GLES20.glCreateProgram();
        if (r104 == 0) goto L14;
        GLES20.glAttachShader(r104, r102);
        a();
        GLES20.glAttachShader(r104, r103);
        a();
        GLES20.glLinkProgram(r104);
        int[] r105 = new int[1];
        GLES20.glGetProgramiv(r104, 35714, r105, 0);
        if (r105[0] == 1) goto L14;
        GLES20.glGetProgramInfoLog(r104);
        GLES20.glDeleteProgram(r104);
        return 0;
    L14:
        return r104;
    }

    public static String c(String r100, Resources r101) {
        InputStream r102 = r101.getAssets().open(r100);     // Catch: Exception -> L11
        ByteArrayOutputStream r103 = new ByteArrayOutputStream();     // Catch: Exception -> L11
    L3:
        int r104 = r102.read();     // Catch: Exception -> L11
        if (r104 == (-1)) goto L6;
        r103.write(r104);     // Catch: Exception -> L11
        goto L3
    L6:
        byte[] r105 = r103.toByteArray();     // Catch: Exception -> L11
        r103.close();     // Catch: Exception -> L11
        r102.close();     // Catch: Exception -> L11
        String r106 = new String(r105, "UTF-8");     // Catch: Exception -> L11
        return r106.replaceAll("\\r\\n", "\n");
    L9:
        Exception e100 = e;
    L13:
        e100.printStackTrace();
        return r106;
    L11:
        e = move-exception;
        e100 = e;
        r106 = null;
        goto L13
    }

    public static int d(int r100, String r101) {
        int r102 = GLES20.glCreateShader(r100);
        if (r102 == 0) goto L8;
        GLES20.glShaderSource(r102, r101);
        GLES20.glCompileShader(r102);
        int[] r103 = new int[1];
        GLES20.glGetShaderiv(r102, 35713, r103, 0);
        if (r103[0] != 0) goto L9;
        GLES20.glGetShaderInfoLog(r102);
        GLES20.glDeleteShader(r102);
        return 0;
    L9:
        return r102;
    L8:
        return r102;
    }
}
