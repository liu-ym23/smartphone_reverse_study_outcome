package com.ss.android.bytedcert.camera.common.gl;

import android.opengl.GLES20;
import com.ss.android.cert.manager.utils.CertLog;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;

/* JADX INFO: loaded from: classes34.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f407288a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f407289b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f407290c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f407291d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f407292e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f407293f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f407294g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public float f407295h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final FloatBuffer f407296i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final FloatBuffer f407297j;

    public b() {
        this.f407295h = 1.0f;
        this.f407296i = ByteBuffer.allocateDirect(32).order(ByteOrder.nativeOrder()).asFloatBuffer();
        FloatBuffer r100 = ByteBuffer.allocateDirect(32).order(ByteOrder.nativeOrder()).asFloatBuffer();
        this.f407297j = r100;
        r100.clear();
        r100.put(new float[]{0.0f, 1.0f, 1.0f, 1.0f, 0.0f, 0.0f, 1.0f, 0.0f});
        r100.position(0);
    }

    public static void a(String r100) {
    L2:
        int r101 = GLES20.glGetError();
        if (r101 == 0) goto L5;
        CertLog.e("GLRendererHelper", r100 + ": glError 0x" + Integer.toHexString(r101));
        goto L2
    }

    public static int b(int r100, String r101) {
        int r102 = GLES20.glCreateShader(r100);
        if (r102 != 0) goto L5;
        return 0;
    L5:
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
    }
}
