package com.obric.common.oea.foundation.effect;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
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
public class GL3ShaderViewFog extends GLSurfaceView implements Choreographer.FrameCallback {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ int f396410b = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public a f396411a;

    public static class a implements GLSurfaceView.Renderer {
        public Bitmap A;
        public int B;
        public int C;
        public int D;
        public int E;
        public int F;
        public int G;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f396412a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f396413b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f396414c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f396415d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public int f396416e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public int f396417f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public int f396418g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public int f396419h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public int f396420i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public int f396421j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public int f396422k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public int f396423l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public float f396424m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public float f396425n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public float f396426o;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        public int f396427p;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        public int f396428q;

        /* JADX INFO: renamed from: r, reason: collision with root package name */
        public int f396429r;

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        public int f396430s;

        /* JADX INFO: renamed from: t, reason: collision with root package name */
        public int f396431t;

        /* JADX INFO: renamed from: u, reason: collision with root package name */
        public final c f396432u;

        /* JADX INFO: renamed from: v, reason: collision with root package name */
        public final c f396433v;

        /* JADX INFO: renamed from: w, reason: collision with root package name */
        public final c f396434w;

        /* JADX INFO: renamed from: x, reason: collision with root package name */
        public int f396435x;

        /* JADX INFO: renamed from: y, reason: collision with root package name */
        public final float[] f396436y;

        /* JADX INFO: renamed from: z, reason: collision with root package name */
        public final FloatBuffer f396437z;

        public a(Context r100) {
            this.f396424m = -1.0f;
            this.f396425n = -1.0f;
            this.f396426o = -1.0f;
            this.f396427p = 0;
            this.f396428q = 0;
            this.f396429r = 0;
            this.f396430s = 0;
            this.f396431t = 0;
            this.f396432u = new c(1.0f);
            this.f396433v = new c(0.8f);
            this.f396434w = new c(0.5f);
            this.f396435x = -3618616;
            float[] r101 = {-1.0f, 1.0f, -1.0f, -1.0f, 1.0f, -1.0f, 1.0f, 1.0f};
            this.f396436y = r101;
            this.B = 0;
            this.F = 0;
            this.G = 0;
            FloatBuffer r102 = ByteBuffer.allocateDirect(32).order(ByteOrder.nativeOrder()).asFloatBuffer().put(r101);
            this.f396437z = r102;
            r102.position(0);
        }

        public static void a(String r100) {
            int r101 = GLES30.glGetError();
            if (r101 != 0) goto L5;
            return;
        L5:
            int r102 = GL3ShaderViewFog.f396410b;
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
            int r105 = GL3ShaderViewFog.f396410b;
            GLES30.glGetProgramInfoLog(r103);
            GLES30.glDeleteProgram(r103);
            return 0;
        L14:
            return r103;
        }

        @Override // android.opengl.GLSurfaceView.Renderer
        public final void onDrawFrame(GL10 r210) {
            if (this.f396428q != this.f396429r) goto L7;
            if (this.f396430s != this.f396431t) goto L7;
        L16:
            long r100 = System.currentTimeMillis();
            GLES30.glClearColor(0.0f, 0.0f, 0.0f, 0.0f);
            GLES30.glClear(16384);
            GLES30.glUseProgram(this.f396412a);
            GLES30.glUniform1f(this.f396418g, (r100 % 1000000) / 1000.0f);
            int r101 = this.f396428q;
            if (r101 == this.f396429r) goto L19;
        L20:
            this.f396429r = r101;
            int r102 = this.f396430s;
            this.f396431t = r102;
            GLES30.glUniform2f(this.f396416e, r101, r102);
        L21:
            float r103 = this.f396432u.f472896a;
            if (r103 == this.f396424m) goto L24;
            this.f396424m = r103;
            GLES30.glUniform1f(this.f396419h, r103);
        L24:
            float r104 = this.f396433v.f472896a;
            if (r104 == this.f396425n) goto L27;
            this.f396425n = r104;
            GLES30.glUniform1f(this.f396420i, r104);
        L27:
            float r105 = this.f396434w.f472896a;
            if (r105 == this.f396426o) goto L30;
            this.f396426o = r105;
            GLES30.glUniform1f(this.f396421j, r105);
        L30:
            int r106 = this.f396435x;
            if (r106 == this.f396427p) goto L33;
            this.f396427p = r106;
            GLES30.glUniform3f(this.f396417f, Color.red(r106) / 255.0f, Color.green(this.f396427p) / 255.0f, Color.blue(this.f396427p) / 255.0f);
        L33:
            GLES30.glActiveTexture(33984);
            GLES30.glBindTexture(3553, this.f396422k);
            GLES30.glUniform1i(this.f396414c, 0);
            GLES30.glActiveTexture(33985);
            GLES30.glBindTexture(3553, this.G);
            GLES30.glUniform1i(this.f396415d, 1);
            GLES30.glBindVertexArray(this.f396423l);
            GLES30.glDrawArrays(6, 0, 4);
            GLES30.glBindVertexArray(0);
            return;
        L19:
            if (this.f396430s == this.f396431t) goto L21;
        L7:
            if (this.B != 0) goto L9;
            int r107 = b("#version 300 es\nprecision mediump float;\nuniform vec2 u_resolution;\nuniform sampler2D u_background;\nout vec4 fragColor;\nvec3 blendOverlay(in vec3 base, in vec3 blend) {\n    return mix(2.0 * base * blend, 1.0 - 2.0 * (1.0 - base) * (1.0 - blend), step(0.5, base));\n}\nvec3 dim(in vec3 baseColor) {\n    vec3 overlayColor = vec3(0.0);\n    vec3 overlayResult = blendOverlay(baseColor, overlayColor);\n    float overlayAlpha = 0.3;\n    return mix(baseColor, overlayResult, overlayAlpha);\n}\nvoid main() {\n    vec2 texUV = gl_FragCoord.xy / u_resolution;\n    texUV.y = 1.0 - texUV.y;\n    vec4 baseColor = texture(u_background, texUV);\n    fragColor = vec4(dim(baseColor.rgb), baseColor.a);\n}\n");
            this.B = r107;
            this.C = GLES30.glGetAttribLocation(r107, "vPosition");
            a("glGetAttribLocation");
            this.D = GLES30.glGetUniformLocation(this.B, "u_background");
            a("glGetAttribLocation");
            this.E = GLES30.glGetUniformLocation(this.B, "u_resolution");
            a("glGetUniformLocation");
        L9:
            GLES30.glUseProgram(this.B);
            if (this.F != 0) goto L12;
            int[] r108 = new int[1];
            GLES30.glGenFramebuffers(1, r108, 0);
            this.F = r108[0];
        L12:
            GLES30.glBindFramebuffer(36160, this.F);
            if (this.G != 0) goto L15;
            int[] r109 = new int[1];
            GLES30.glGenTextures(1, r109, 0);
            this.G = r109[0];
        L15:
            GLES30.glBindTexture(3553, this.G);
            GLES30.glTexImage2D(3553, 0, 6408, this.f396428q, this.f396430s, 0, 6408, 5121, null);
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
            GLES30.glUniform2f(this.E, this.f396428q, this.f396430s);
            GLES30.glActiveTexture(33984);
            GLES30.glBindTexture(3553, this.f396422k);
            GLES30.glUniform1i(this.D, 0);
            GLES30.glEnableVertexAttribArray(this.C);
            GLES30.glVertexAttribPointer(this.C, 2, 5126, false, 0, this.f396437z);
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
            int r104 = GL3ShaderViewFog.f396410b;
            GLES30.glGetShaderInfoLog(r102);
            GLES30.glDeleteShader(r102);
            return 0;
        L9:
            return r102;
        L8:
            return r102;
        }

        @Override // android.opengl.GLSurfaceView.Renderer
        public final void onSurfaceCreated(GL10 r100, EGLConfig r110) {
            int r101 = b("#version 300 es\nprecision highp float;\n#define PI 3.141592653589793\nuniform vec2 u_resolution;\nuniform float u_time;\nuniform sampler2D u_background;\nuniform sampler2D u_prepass;\nuniform float u_alpha;\nuniform float u_intensity;\nuniform float u_speed;\nuniform vec3 u_color;\nconst float LOD             = 9.0;\nconst int FBM_OCTAVES       = 4;\nconst float DUST_GRID_SIZE  = 80.0;\nconst float DUST_SIZE       = 2.0;\nconst vec2 SHIFT            = vec2(0.07, -0.03);\nout vec4 fragColor;\nfloat random(in vec2 uv) {\n    return fract(sin(dot(uv, vec2(12.9898, 78.233))) * 43758.5453123);\n}\nvec2 hash(in vec2 p) {\n    return fract(sin(vec2(dot(p, vec2(127.1, 311.7)),\n            dot(p, vec2(269.5, 183.3))))\n            * 43758.5453123);\n}\nfloat noise(in vec2 uv) {\n    vec2 i = floor(uv);\n    vec2 f = fract(uv);\n    float a = random(i);\n    float b = random(i + vec2(1.0, 0.0));\n    float c = random(i + vec2(0.0, 1.0));\n    float d = random(i + vec2(1.0, 1.0));\n    vec2 u = f * f * (3.0 - 2.0 * f);\n    return mix(a, b, u.x) +\n            (c - a) * u.y * (1.0 - u.x) +\n            (d - b) * u.x * u.y;\n}\nfloat fbm(in vec2 uv) {\n    float value = 0.0;\n    float amplitude = 0.5;\n    vec2 shiftUV = vec2(100.0);\n    mat2 rot = mat2(cos(0.5), sin(0.5),\n            -sin(0.5), cos(0.5));\n    for (int i = 0; i < FBM_OCTAVES; i++) {\n        value += amplitude * noise(uv);\n        uv = uv * rot * 2.0 + shiftUV;\n        amplitude *= 0.5;\n    }\n    return value;\n}\nfloat computeFog(in vec2 uv, in float t) {\n    uv += t * SHIFT;\n    vec2 q;\n    q.x = fbm(uv + 0.1 * t);\n    q.y = fbm(uv + 1.0);\n    vec2 r;\n    r.x = fbm(uv + q + vec2(1.7, 9.2) + 0.15 * t);\n    r.y = fbm(uv + q + vec2(8.3, 2.8) + 0.126 * t);\n    float f = fbm(uv + r) * u_intensity;\n    float end = mix(1.0, 0.5, u_intensity);\n    return smoothstep(0.0, end, f);\n}\nfloat computeDust(in float t) {\n    vec2 coord = gl_FragCoord.xy + u_resolution.y * t * SHIFT * 4.0;\n    float gridSize = mix(DUST_GRID_SIZE * 2.0, DUST_GRID_SIZE, u_intensity);\n    vec2 cellPos = floor(coord / gridSize);\n    vec2 randOffset = hash(cellPos);\n    vec2 drift = vec2(sin(t + randOffset.x * 6.28318),\n            cos(t + randOffset.y * 6.28318)) * gridSize;\n    vec2 dustCenter = (cellPos + randOffset) * gridSize + drift;\n    float d = length(coord - dustCenter);\n    float particle = 1.0 - smoothstep(0.0, DUST_SIZE, d);\n    float brightness = mix(0.5, 1.0, randOffset.y);\n    return particle * brightness;\n}\nvoid main() {\n    vec2 uv = (gl_FragCoord.xy - 0.5 * u_resolution) / u_resolution.y;\n    float t = u_time * u_speed;\n    // 计算雾效果与尘埃\n    float fogEffect  = computeFog(uv, t);\n    float dustEffect = computeDust(t);\n    vec2 texUV = gl_FragCoord.xy / u_resolution;\n    vec3 baseColor = texture(u_background, texUV).rgb;\n    vec3 prepassColor = textureLod(u_prepass, texUV, LOD).rgb;\n    // 将雾与尘埃和指定颜色混合\n    vec3 effectColor = mix(prepassColor, (fogEffect + dustEffect) * u_color, fogEffect);\n    vec3 finalColor  = mix(baseColor, effectColor, u_alpha);\n    fragColor = vec4(finalColor, 1.0);\n}\n");
            this.f396412a = r101;
            if (r101 != 0) goto L5;
            return;
        L5:
            this.f396413b = GLES30.glGetAttribLocation(r101, "vPosition");
            a("glGetAttribLocation");
            this.f396414c = GLES30.glGetUniformLocation(this.f396412a, "u_background");
            a("glGetAttribLocation");
            this.f396415d = GLES30.glGetUniformLocation(this.f396412a, "u_prepass");
            a("glGetAttribLocation");
            this.f396416e = GLES30.glGetUniformLocation(this.f396412a, "u_resolution");
            a("glGetUniformLocation");
            this.f396417f = GLES30.glGetUniformLocation(this.f396412a, "u_color");
            a("glGetUniformLocation");
            this.f396418g = GLES30.glGetUniformLocation(this.f396412a, "u_time");
            a("glGetUniformLocation");
            this.f396419h = GLES30.glGetUniformLocation(this.f396412a, "u_alpha");
            a("glGetUniformLocation");
            this.f396420i = GLES30.glGetUniformLocation(this.f396412a, "u_intensity");
            a("glGetUniformLocation");
            this.f396421j = GLES30.glGetUniformLocation(this.f396412a, "u_speed");
            a("glGetUniformLocation");
            GLES30.glUseProgram(this.f396412a);
            Bitmap r102 = this.A;
            int[] r103 = new int[1];
            GLES30.glGenTextures(1, r103, 0);
            int r104 = r103[0];
            if (r104 == 0) goto L8;
            GLES30.glBindTexture(3553, r104);
            GLES30.glTexParameteri(3553, 10242, 33071);
            GLES30.glTexParameteri(3553, 10243, 33071);
            GLES30.glTexParameteri(3553, 10241, 9729);
            GLES30.glTexParameteri(3553, 10240, 9729);
            GLUtils.texImage2D(3553, 0, r102, 0);
            GLES30.glBindTexture(3553, 0);
            r102.recycle();
        L8:
            this.f396422k = r103[0];
            int[] r105 = new int[1];
            GLES30.glGenVertexArrays(1, r105, 0);
            int r106 = r105[0];
            this.f396423l = r106;
            GLES30.glBindVertexArray(r106);
            int[] r107 = new int[1];
            GLES30.glGenBuffers(1, r107, 0);
            GLES30.glBindBuffer(34962, r107[0]);
            GLES30.glBufferData(34962, this.f396436y.length * 4, this.f396437z, 35044);
            GLES30.glEnableVertexAttribArray(this.f396413b);
            GLES30.glVertexAttribPointer(this.f396413b, 2, 5126, false, 0, 0);
            GLES30.glBindBuffer(34962, 0);
            GLES30.glBindVertexArray(0);
            GLES30.glUseProgram(0);
        }

        @Override // android.opengl.GLSurfaceView.Renderer
        public final void onSurfaceChanged(GL10 r100, int r101, int r102) {
            this.f396428q = r101;
            this.f396430s = r102;
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

    public GL3ShaderViewFog(Context r100) {
        super(r100, null);
    }

    @Override // android.view.Choreographer.FrameCallback
    public final void doFrame(long r100) {
        requestRender();
        Choreographer.getInstance().postFrameCallback(this);
    }

    public void setBackgroundImage(Bitmap r100) {
        this.f396411a.A = r100;
    }

    public void setShaderAlpha(float r100) {
        this.f396411a.f396432u.f472896a = r100;
    }

    public void setShaderColor(int r100) {
        this.f396411a.f396435x = r100;
    }

    public void setShaderIntensity(float r100) {
        this.f396411a.f396433v.f472896a = r100;
    }

    public void setShaderSpeed(float r100) {
        this.f396411a.f396434w.f472896a = r100;
    }

    public GL3ShaderViewFog(Context r100, AttributeSet r101) {
        super(r100, r101);
        getHolder().setFormat(1);
        setZOrderOnTop(true);
        setEGLContextClientVersion(3);
        setEGLConfigChooser(8, 8, 8, 0, 0, 0);
        a r102 = new a(getContext());
        this.f396411a = r102;
        setRenderer(r102);
        setRenderMode(0);
        setPreserveEGLContextOnPause(true);
    }
}
