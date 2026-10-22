package com.bytedance.live.zdanmaku.render.gles;

import android.opengl.GLES20;
import com.bytedance.live.artist.render.e;

/* JADX INFO: loaded from: classes19.dex */
public abstract class a extends e {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f255892c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f255893d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f255894e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f255895f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f255896g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f255897h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f255898i;

    /* JADX INFO: renamed from: com.bytedance.live.zdanmaku.render.gles.a$a, reason: collision with other inner class name */
    public static final class C3635a {
    }

    static {
    }

    @Override // com.bytedance.live.artist.render.e
    public final void e() {
        if (this.f255898i == false) goto L5;
        return;
    L5:
        this.f255896g = uk6.a.a(35633);
        int r100 = uk6.a.a(35632);
        int r101 = this.f255896g;
        int r102 = GLES20.glCreateProgram();
        if (r102 == 0) goto L10;
        GLES20.glAttachShader(r102, r101);
        GLES20.glAttachShader(r102, r100);
        GLES20.glLinkProgram(r102);
        int[] r103 = new int[1];
        GLES20.glGetProgramiv(r102, 35714, r103, 0);
        if (r103[0] == 1) goto L10;
        GLES20.glDeleteProgram(r102);
        r102 = 0;
    L10:
        this.f255895f = r102;
        this.f255893d = GLES20.glGetAttribLocation(r102, "vPosition");
        this.f255892c = GLES20.glGetAttribLocation(this.f255895f, "vCoord");
        this.f255897h = GLES20.glGetUniformLocation(this.f255895f, "vMatrix");
        this.f255894e = GLES20.glGetUniformLocation(this.f255895f, "vTexture");
        this.f255898i = true;
    }

    @Override // com.bytedance.live.artist.render.e
    public final void f() {
        GLES20.glUseProgram(this.f255895f);
        GLES20.glUniformMatrix4fv(this.f255897h, 1, false, null, 0);
        GLES20.glActiveTexture(33984);
        GLES20.glBindTexture(3553, 0);
        GLES20.glUniform1i(this.f255894e, 0);
        GLES20.glEnableVertexAttribArray(this.f255893d);
        GLES20.glVertexAttribPointer(this.f255893d, 2, 5126, false, 0, null);
        GLES20.glEnableVertexAttribArray(this.f255892c);
        GLES20.glVertexAttribPointer(this.f255892c, 2, 5126, false, 0, null);
        GLES20.glDrawArrays(5, 0, 4);
        GLES20.glDisableVertexAttribArray(this.f255893d);
        GLES20.glDisableVertexAttribArray(this.f255892c);
    }
}
