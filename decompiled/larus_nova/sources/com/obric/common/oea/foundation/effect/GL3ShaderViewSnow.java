package com.obric.common.oea.foundation.effect;

import android.content.Context;
import android.graphics.Bitmap;
import android.opengl.GLES30;
import android.opengl.GLSurfaceView;
import android.opengl.GLUtils;
import android.util.AttributeSet;
import android.view.Choreographer;
import eja.c;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

/* JADX INFO: loaded from: classes33.dex */
public class GL3ShaderViewSnow extends GLSurfaceView implements Choreographer.FrameCallback {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ int f396532b = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public a f396533a;

    public static class a implements GLSurfaceView.Renderer {
        public Bitmap A;
        public int B;
        public int C;
        public int D;
        public int E;
        public int F;
        public int G;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f396534a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f396535b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f396536c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f396537d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public int f396538e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public int f396539f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public int f396540g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public int f396541h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public int f396542i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public int f396543j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public int f396544k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public int f396545l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public int f396546m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public float f396547n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public float f396548o;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        public float f396549p;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        public int f396550q;

        /* JADX INFO: renamed from: r, reason: collision with root package name */
        public int f396551r;

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        public int f396552s;

        /* JADX INFO: renamed from: t, reason: collision with root package name */
        public int f396553t;

        /* JADX INFO: renamed from: u, reason: collision with root package name */
        public final c f396554u;

        /* JADX INFO: renamed from: v, reason: collision with root package name */
        public final c f396555v;

        /* JADX INFO: renamed from: w, reason: collision with root package name */
        public final c f396556w;

        /* JADX INFO: renamed from: x, reason: collision with root package name */
        public final float[] f396557x;

        /* JADX INFO: renamed from: y, reason: collision with root package name */
        public final FloatBuffer f396558y;

        /* JADX INFO: renamed from: z, reason: collision with root package name */
        public Bitmap f396559z;

        public a(Context r100) {
            this.f396547n = -1.0f;
            this.f396548o = -1.0f;
            this.f396549p = -1.0f;
            this.f396550q = 0;
            this.f396551r = 0;
            this.f396552s = 0;
            this.f396553t = 0;
            this.f396554u = new c(1.0f);
            this.f396555v = new c(0.5f);
            this.f396556w = new c(1.0f);
            float[] r101 = {-1.0f, 1.0f, -1.0f, -1.0f, 1.0f, -1.0f, 1.0f, 1.0f};
            this.f396557x = r101;
            this.B = 0;
            this.F = 0;
            this.G = 0;
            FloatBuffer r102 = ByteBuffer.allocateDirect(r101.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer().put(r101);
            this.f396558y = r102;
            r102.position(0);
        }

        public static void a(String r100) {
            int r101 = GLES30.glGetError();
            if (r101 != 0) goto L5;
            return;
        L5:
            int r102 = GL3ShaderViewSnow.f396532b;
            throw new RuntimeException(r100 + ": glError " + r101);
        }

        public static int b(String r100) {
            int r101 = c(35633, "#version 300 es\nin vec4 vPosition;\nvoid main() {\n  gl_Position = vPosition;\n}\n");
            if (r101 != 0) goto L5;
            return 0;
        L5:
            int r102 = c(35632, r100);
            if (r102 != 0) goto L8;
            return 0;
        L8:
            int r103 = GLES30.glCreateProgram();
            if (r103 == 0) goto L14;
            GLES30.glAttachShader(r103, r101);
            a("glAttachShader");
            GLES30.glAttachShader(r103, r102);
            a("glAttachShader");
            GLES30.glLinkProgram(r103);
            int[] r104 = new int[1];
            GLES30.glGetProgramiv(r103, 35714, r104, 0);
            if (r104[0] == 1) goto L14;
            int r105 = GL3ShaderViewSnow.f396532b;
            GLES30.glGetProgramInfoLog(r103);
            GLES30.glDeleteProgram(r103);
            return 0;
        L14:
            return r103;
        }

        public static int d(Bitmap r100) {
            int[] r101 = new int[1];
            GLES30.glGenTextures(1, r101, 0);
            int r102 = r101[0];
            if (r102 == 0) goto L6;
            GLES30.glBindTexture(3553, r102);
            GLES30.glTexParameteri(3553, 10242, 33071);
            GLES30.glTexParameteri(3553, 10243, 33071);
            GLES30.glTexParameteri(3553, 10241, 9729);
            GLES30.glTexParameteri(3553, 10240, 9729);
            GLUtils.texImage2D(3553, 0, r100, 0);
            GLES30.glBindTexture(3553, 0);
            r100.recycle();
        L6:
            return r101[0];
        }

        @Override // android.opengl.GLSurfaceView.Renderer
        public final void onDrawFrame(GL10 r210) {
            if (this.f396550q != this.f396551r) goto L7;
            if (this.f396552s != this.f396553t) goto L7;
        L16:
            long r100 = System.currentTimeMillis();
            GLES30.glClearColor(0.0f, 0.0f, 0.0f, 0.0f);
            GLES30.glClear(16384);
            GLES30.glUseProgram(this.f396534a);
            GLES30.glUniform1f(this.f396540g, (r100 % 1000000) / 1000.0f);
            int r101 = this.f396550q;
            if (r101 == this.f396551r) goto L19;
        L20:
            this.f396551r = r101;
            int r102 = this.f396552s;
            this.f396553t = r102;
            GLES30.glUniform2f(this.f396539f, r101, r102);
        L21:
            float r103 = this.f396554u.f472896a;
            if (r103 == this.f396547n) goto L24;
            this.f396547n = r103;
            GLES30.glUniform1f(this.f396541h, r103);
        L24:
            float r104 = this.f396555v.f472896a;
            if (r104 == this.f396548o) goto L27;
            this.f396548o = r104;
            GLES30.glUniform1f(this.f396542i, r104);
        L27:
            float r105 = this.f396556w.f472896a;
            if (r105 == this.f396549p) goto L30;
            this.f396549p = r105;
            GLES30.glUniform1f(this.f396543j, r105);
        L30:
            GLES30.glActiveTexture(33984);
            GLES30.glBindTexture(3553, this.f396544k);
            GLES30.glUniform1i(this.f396536c, 0);
            GLES30.glActiveTexture(33985);
            GLES30.glBindTexture(3553, this.G);
            GLES30.glUniform1i(this.f396537d, 1);
            GLES30.glActiveTexture(33986);
            GLES30.glBindTexture(3553, this.f396545l);
            GLES30.glUniform1i(this.f396538e, 2);
            GLES30.glBindVertexArray(this.f396546m);
            GLES30.glDrawArrays(6, 0, 4);
            GLES30.glBindVertexArray(0);
            return;
        L19:
            if (this.f396552s == this.f396553t) goto L21;
        L7:
            if (this.B != 0) goto L9;
            int r106 = b("#version 300 es\nprecision mediump float;\nuniform vec2 u_resolution;\nuniform sampler2D u_background;\nout vec4 fragColor;\nvec3 blendOverlay(in vec3 base, in vec3 blend) {\n    return mix(2.0 * base * blend, 1.0 - 2.0 * (1.0 - base) * (1.0 - blend), step(0.5, base));\n}\nvec3 dim(in vec3 baseColor) {\n    vec3 overlayColor = vec3(0.0);\n    vec3 overlayResult = blendOverlay(baseColor, overlayColor);\n    float overlayAlpha = 0.3;\n    return mix(baseColor, overlayResult, overlayAlpha);\n}\nvoid main() {\n    vec2 texUV = gl_FragCoord.xy / u_resolution;\n    texUV.y = 1.0 - texUV.y;\n    vec4 baseColor = texture(u_background, texUV);\n    fragColor = vec4(dim(baseColor.rgb), baseColor.a);\n}\n");
            this.B = r106;
            this.C = GLES30.glGetAttribLocation(r106, "vPosition");
            a("glGetAttribLocation");
            this.D = GLES30.glGetUniformLocation(this.B, "u_background");
            a("glGetAttribLocation");
            this.E = GLES30.glGetUniformLocation(this.B, "u_resolution");
            a("glGetUniformLocation");
        L9:
            GLES30.glUseProgram(this.B);
            if (this.F != 0) goto L12;
            int[] r107 = new int[1];
            GLES30.glGenFramebuffers(1, r107, 0);
            this.F = r107[0];
        L12:
            GLES30.glBindFramebuffer(36160, this.F);
            if (this.G != 0) goto L15;
            int[] r108 = new int[1];
            GLES30.glGenTextures(1, r108, 0);
            this.G = r108[0];
        L15:
            GLES30.glBindTexture(3553, this.G);
            GLES30.glTexImage2D(3553, 0, 6408, this.f396550q, this.f396552s, 0, 6408, 5121, null);
            GLES30.glTexParameteri(3553, 10241, 9987);
            GLES30.glTexParameteri(3553, 10240, 9729);
            GLES30.glTexParameteri(3553, 10242, 33071);
            GLES30.glTexParameteri(3553, 10243, 33071);
            GLES30.glFramebufferTexture2D(36160, 36064, 3553, this.G, 0);
            GLES30.glBindFramebuffer(36160, 0);
            GLES30.glUseProgram(0);
            GLES30.glBindFramebuffer(36160, this.F);
            GLES30.glClearColor(0.0f, 0.0f, 0.0f, 0.0f);
            GLES30.glClear(16384);
            GLES30.glUseProgram(this.B);
            GLES30.glUniform2f(this.E, this.f396550q, this.f396552s);
            GLES30.glActiveTexture(33984);
            GLES30.glBindTexture(3553, this.f396544k);
            GLES30.glUniform1i(this.D, 0);
            GLES30.glEnableVertexAttribArray(this.C);
            GLES30.glVertexAttribPointer(this.C, 2, 5126, false, 0, this.f396558y);
            GLES30.glDrawArrays(6, 0, 4);
            GLES30.glBindTexture(3553, this.G);
            GLES30.glGenerateMipmap(3553);
            GLES30.glBindTexture(3553, 0);
            GLES30.glBindFramebuffer(36160, 0);
            goto L16
        }

        public static int c(int r100, String r101) {
            int r102 = GLES30.glCreateShader(r100);
            if (r102 == 0) goto L8;
            GLES30.glShaderSource(r102, r101);
            GLES30.glCompileShader(r102);
            int[] r103 = new int[1];
            GLES30.glGetShaderiv(r102, 35713, r103, 0);
            if (r103[0] != 0) goto L9;
            int r104 = GL3ShaderViewSnow.f396532b;
            GLES30.glGetShaderInfoLog(r102);
            GLES30.glDeleteShader(r102);
            return 0;
        L9:
            return r102;
        L8:
            return r102;
        }

        @Override // android.opengl.GLSurfaceView.Renderer
        public final void onSurfaceCreated(GL10 r100, EGLConfig r101) {
            int r102 = b("#version 300 es\nprecision highp float;\n#define clamp01(x) clamp(x, 0.0, 1.0)\nuniform vec2 u_resolution;\nuniform float u_time;\nuniform sampler2D u_background;\nuniform sampler2D u_prepass;\nuniform sampler2D u_frostTex;\nuniform float u_alpha;\nuniform float u_intensity;\nuniform float u_speed;\nconst float LOD         = 9.0;\nconst float SNOW_LAYERS = 30.0;\nconst float SNOW_DEPTH  = 0.5;\nconst float SNOW_WIDTH  = 0.5;\nconst vec3 FROST_COLOR  = vec3(0.82, 0.89, 0.96);\nconst vec2 SHIFT        = vec2(0.07, -0.03);\nout vec4 fragColor;\nvec3 blendNormal(in vec3 baseColor, in vec3 blendColor, in float opacity) {\n    return mix(baseColor, blendColor, opacity);\n}\nfloat random(in vec2 uv) {\n    return fract(sin(dot(uv, vec2(12.9898, 78.233))) * 43758.5453123);\n}\nconst mat3 randomMat = mat3(13.323122, 23.5112, 21.71123,\n        21.1212, 28.7312, 11.9312,\n        21.8112, 14.7212, 61.3934);\nfloat generateSnowLayer(in vec2 uv, in float t, float layer, float width) {\n    float depth = layer * SNOW_DEPTH;\n    vec2 q = uv * (1.0 + depth);\n    q += vec2(q.y * width * (fract(layer * 7.238917) - 0.5),\n            t / (1.0 + depth * 0.03));\n    vec3 n = vec3(floor(q), 31.189 + layer);\n    vec3 m = floor(n) / 1e5 + fract(n);\n    vec3 mp = (31415.9 + m) / fract(randomMat * m);\n    vec3 r = fract(mp);\n    vec2 s = abs(fract(q) - 0.5 + 0.9 * r.xy - 0.45) +\n            0.01 * abs(2.0 * fract(10.0 * q.yx) - 1.0);\n    float d = 0.6 * (s.x + s.y) + max(s.x, s.y) - 0.01;\n    float edge = 0.005 + 0.05 * min(0.5 * abs(layer - 5.0), 1.0);\n    return smoothstep(edge, -edge, d) * r.x / (1.0 + 0.02 * depth);\n}\nfloat computeSnow(in vec2 uv, in float t) {\n    uv += t * SHIFT;\n    float snow = 0.0;\n    float layers = mix(0.0, SNOW_LAYERS, u_intensity);\n    float width  = mix(0.0, SNOW_WIDTH, u_intensity);\n    for (float i = 0.0; i < layers; i++) {\n        snow += generateSnowLayer(uv, t, i, width);\n    }\n    return clamp01(snow);\n}\nvec2 frostEffect(in vec2 uv) {\n    vec4 frostTex = texture(u_frostTex, uv);\n    vec2 offset = vec2(random(uv + frostTex.r * 0.05),\n            random(uv + frostTex.b * 0.05));\n    float distToCenter = distance(uv, vec2(0.5));\n    float frostiness   = mix(1.0, 0.5, u_intensity);\n    float vignette     = pow(1.0 - smoothstep(frostiness, 0.0, distToCenter), 2.0);\n    offset *= 0.025 * vignette + frostTex.rg * vignette * u_intensity * 4.0;\n    return clamp(offset, vec2(0.0), vec2(1.0));\n}\nvoid main() {\n    vec2 uv = (gl_FragCoord.xy - 0.5 * u_resolution) / u_resolution.y;\n    float t = u_time * u_speed;\n    vec2 texUV = gl_FragCoord.xy / u_resolution;\n    vec3 baseColor    = texture(u_background, texUV).rgb;\n    vec3 prepassColor = textureLod(u_prepass, texUV, LOD).rgb;\n    vec2 frostOffset  = frostEffect(texUV);\n    float snowEffect  = computeSnow(uv + frostOffset * 0.3, t);\n    vec3 effectColor = prepassColor + snowEffect;\n    effectColor = blendNormal(effectColor, FROST_COLOR, frostOffset.x);\n    vec3 finalColor = mix(baseColor, effectColor, u_alpha);\n    fragColor = vec4(finalColor, 1.0);\n}\n");
            this.f396534a = r102;
            if (r102 != 0) goto L5;
            return;
        L5:
            this.f396535b = GLES30.glGetAttribLocation(r102, "vPosition");
            a("glGetAttribLocation");
            this.f396536c = GLES30.glGetUniformLocation(this.f396534a, "u_background");
            a("glGetAttribLocation");
            this.f396537d = GLES30.glGetUniformLocation(this.f396534a, "u_prepass");
            a("glGetAttribLocation");
            this.f396538e = GLES30.glGetUniformLocation(this.f396534a, "u_frostTex");
            a("glGetAttribLocation");
            this.f396539f = GLES30.glGetUniformLocation(this.f396534a, "u_resolution");
            a("glGetUniformLocation");
            this.f396540g = GLES30.glGetUniformLocation(this.f396534a, "u_time");
            a("glGetUniformLocation");
            this.f396541h = GLES30.glGetUniformLocation(this.f396534a, "u_alpha");
            a("glGetUniformLocation");
            this.f396542i = GLES30.glGetUniformLocation(this.f396534a, "u_intensity");
            a("glGetUniformLocation");
            this.f396543j = GLES30.glGetUniformLocation(this.f396534a, "u_speed");
            a("glGetUniformLocation");
            GLES30.glUseProgram(this.f396534a);
            this.f396544k = d(this.f396559z);
            this.f396545l = d(this.A);
            int[] r103 = new int[1];
            GLES30.glGenVertexArrays(1, r103, 0);
            int r104 = r103[0];
            this.f396546m = r104;
            GLES30.glBindVertexArray(r104);
            int[] r105 = new int[1];
            GLES30.glGenBuffers(1, r105, 0);
            GLES30.glBindBuffer(34962, r105[0]);
            GLES30.glBufferData(34962, this.f396557x.length * 4, this.f396558y, 35044);
            GLES30.glEnableVertexAttribArray(this.f396535b);
            GLES30.glVertexAttribPointer(this.f396535b, 2, 5126, false, 0, 0);
            GLES30.glBindBuffer(34962, 0);
            GLES30.glBindVertexArray(0);
            GLES30.glUseProgram(0);
        }

        @Override // android.opengl.GLSurfaceView.Renderer
        public final void onSurfaceChanged(GL10 r100, int r101, int r102) {
            this.f396550q = r101;
            this.f396552s = r102;
            GLES30.glViewport(0, 0, r101, r102);
        }
    }

    @Override // android.opengl.GLSurfaceView
    public final void onPause() {
        Choreographer.getInstance().removeFrameCallback(this);
        super.onPause();
    }

    @Override // android.opengl.GLSurfaceView
    public final void onResume() {
        super.onResume();
        Choreographer.getInstance().postFrameCallback(this);
    }

    public GL3ShaderViewSnow(Context r100) {
        super(r100, null);
    }

    @Override // android.view.Choreographer.FrameCallback
    public final void doFrame(long r100) {
        requestRender();
        Choreographer.getInstance().postFrameCallback(this);
    }

    public void setBackgroundImage(Bitmap r100) {
        this.f396533a.f396559z = r100;
    }

    public void setFrostImage(Bitmap r100) {
        this.f396533a.A = r100;
    }

    public void setShaderAlpha(float r100) {
        this.f396533a.f396554u.f472896a = r100;
    }

    public void setShaderIntensity(float r100) {
        this.f396533a.f396555v.f472896a = r100;
    }

    public void setShaderSpeed(float r100) {
        this.f396533a.f396556w.f472896a = r100;
    }

    public GL3ShaderViewSnow(Context r100, AttributeSet r101) {
        super(r100, r101);
        getHolder().setFormat(1);
        setZOrderOnTop(true);
        setEGLContextClientVersion(3);
        setEGLConfigChooser(8, 8, 8, 0, 0, 0);
        a r102 = new a(getContext());
        this.f396533a = r102;
        setRenderer(r102);
        setRenderMode(0);
        setPreserveEGLContextOnPause(true);
    }
}
