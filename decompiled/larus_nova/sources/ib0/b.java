package ib0;

import android.opengl.GLES20;

/* JADX INFO: loaded from: classes45.dex */
public final class b extends a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public float f488986a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public float f488987b;

    @Override // ib0.a, ib0.d
    public final String a() {
        return "precision mediump float;\nvarying vec2 vTextureCoord;\nuniform float uAlpha;\nuniform sampler2D uTextureSampler;\n  uniform highp float left;\n  uniform highp float top;\n  uniform highp float right;\n  uniform highp float bottom;\nvoid main() {\nif( vTextureCoord.x > left &&  vTextureCoord.x < right &&  vTextureCoord.y > top &&  vTextureCoord.y < bottom) { gl_FragColor = texture2D(uTextureSampler, vTextureCoord);\n} else { gl_FragColor = vec4(0, 0, 0, 0);\n}}\n";
    }

    public b() {
        this.f488986a = 0.0f;
        this.f488987b = 1.0f;
    }

    @Override // ib0.a, ib0.d
    public final void c(fb0.a r100) {
        float r101 = r100.c() / r100.f476205e;
        this.f488987b *= r101;
        this.f488986a *= r101;
    }

    @Override // ib0.a, ib0.d
    public final void e(int r100) {
        GLES20.glUniform1f(GLES20.glGetUniformLocation(r100, "left"), this.f488986a);
        GLES20.glUniform1f(GLES20.glGetUniformLocation(r100, "top"), 0.0f);
        GLES20.glUniform1f(GLES20.glGetUniformLocation(r100, "right"), this.f488987b);
        GLES20.glUniform1f(GLES20.glGetUniformLocation(r100, "bottom"), 1.0f);
    }
}
