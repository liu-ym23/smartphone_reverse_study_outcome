package com.obric.common.oea.foundation.effect;

import android.content.Context;
import android.graphics.Bitmap;
import android.opengl.GLES30;
import android.opengl.GLSurfaceView;
import android.opengl.GLUtils;
import android.util.AttributeSet;
import android.view.Choreographer;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

/* JADX INFO: loaded from: classes33.dex */
public class GL3ShaderViewKawaseBlur extends GLSurfaceView implements Choreographer.FrameCallback {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public a f396438a;

    public class a implements GLSurfaceView.Renderer {
        public int A;
        public int B;
        public int C;
        public int D;
        public int E;
        public int F;
        public int G;
        public int H;
        public float H0;
        public int I;

        /* JADX INFO: renamed from: J, reason: collision with root package name */
        public int f396439J;
        public int K;
        public int L;
        public float L0;
        public int M;
        public int N;
        public final float[] O;
        public final FloatBuffer P;
        public Bitmap Q;
        public Bitmap R;
        public int S;
        public int T;
        public int U;
        public int V;
        public int W;
        public int X;
        public int Y;
        public int Z;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f396440a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f396441b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f396442c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f396443d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public int f396444e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public int f396445f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public int f396446g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public int f396447h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public int f396448i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public int f396449j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public int f396450k;

        /* JADX INFO: renamed from: k0, reason: collision with root package name */
        public int f396451k0;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public int f396452l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public int f396453m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public int f396454n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public int f396455o;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        public int f396456p;

        /* JADX INFO: renamed from: p0, reason: collision with root package name */
        public int f396457p0;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        public int f396458q;

        /* JADX INFO: renamed from: r, reason: collision with root package name */
        public int f396459r;

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        public int f396460s;

        /* JADX INFO: renamed from: t, reason: collision with root package name */
        public int f396461t;

        /* JADX INFO: renamed from: u, reason: collision with root package name */
        public int f396462u;

        /* JADX INFO: renamed from: v, reason: collision with root package name */
        public int f396463v;

        /* JADX INFO: renamed from: w, reason: collision with root package name */
        public int f396464w;

        /* JADX INFO: renamed from: x, reason: collision with root package name */
        public int f396465x;

        /* JADX INFO: renamed from: y, reason: collision with root package name */
        public int f396466y;

        /* JADX INFO: renamed from: z, reason: collision with root package name */
        public int f396467z;

        public a() {
            this.A = 0;
            this.B = 0;
            this.C = 0;
            this.D = 0;
            this.E = 0;
            this.F = 0;
            float[] r100 = {-1.0f, 1.0f, -1.0f, -1.0f, 1.0f, -1.0f, 1.0f, 1.0f};
            this.O = r100;
            this.S = 0;
            this.T = 0;
            this.U = 0;
            this.V = 0;
            this.W = 0;
            this.X = 0;
            this.Y = 0;
            this.Z = 0;
            this.f396451k0 = 0;
            this.f396457p0 = 0;
            this.H0 = 0.0f;
            this.L0 = 0.0f;
            FloatBuffer r101 = ByteBuffer.allocateDirect(32).order(ByteOrder.nativeOrder()).asFloatBuffer().put(r100);
            this.P = r101;
            r101.position(0);
        }

        public static void a(String r100) {
            int r101 = GLES30.glGetError();
            if (r101 != 0) goto L6;
            return;
        L6:
            throw new RuntimeException(r100 + ": glError " + r101);
        }

        public static int c(String r100) {
            int r101 = d(35633, "#version 300 es\nin vec4 vPosition;\nvoid main() {\n  gl_Position = vPosition;\n}\n");
            if (r101 != 0) goto L5;
            return 0;
        L5:
            int r102 = d(35632, r100);
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
            GLES30.glGetProgramInfoLog(r103);
            GLES30.glDeleteProgram(r103);
            return 0;
        L14:
            return r103;
        }

        @Override // android.opengl.GLSurfaceView.Renderer
        public final void onDrawFrame(GL10 r210) {
            int r100 = this.C;
            if (r100 == 0) goto L43;
            int r101 = this.E;
            if (r101 != 0) goto L8;
            return;
        L8:
            if (r100 == this.D) goto L10;
        L13:
            boolean r102 = true;
        L15:
            if (this.R == this.Q) goto L23;
            int r103 = this.A;
            if (r103 == 0) goto L19;
            GLES30.glDeleteTextures(1, new int[]{r103}, 0);
        L19:
            Bitmap r104 = this.R;
            int[] r105 = new int[1];
            GLES30.glGenTextures(1, r105, 0);
            int r106 = r105[0];
            if (r106 == 0) goto L22;
            GLES30.glBindTexture(3553, r106);
            GLUtils.texImage2D(3553, 0, r104, 0);
            GLES30.glTexParameteri(3553, 10241, 9729);
            GLES30.glTexParameteri(3553, 10240, 9729);
            GLES30.glTexParameteri(3553, 10242, 33071);
            GLES30.glTexParameteri(3553, 10243, 33071);
            GLES30.glBindTexture(3553, 0);
        L22:
            this.A = r105[0];
            r102 = true;
        L23:
            if (r102 == false) goto L28;
            k(this.A, this.S);
            if (this.B != 0) goto L27;
            int r107 = this.G;
            int r108 = this.H;
            int[] r109 = new int[1];
            GLES30.glGenTextures(1, r109, 0);
            GLES30.glBindTexture(3553, r109[0]);
            GLES30.glTexImage2D(3553, 0, 6408, r107, r108, 0, 6408, 5121, null);
            GLES30.glTexParameteri(3553, 10241, 9729);
            GLES30.glTexParameteri(3553, 10240, 9729);
            GLES30.glTexParameteri(3553, 10242, 33071);
            GLES30.glTexParameteri(3553, 10243, 33071);
            GLES30.glBindTexture(3553, 0);
            this.B = r109[0];
        L27:
            GLES30.glBindFramebuffer(36160, this.S);
            GLES30.glBindTexture(3553, this.B);
            GLES30.glCopyTexSubImage2D(3553, 0, 0, 0, 0, 0, this.G, this.H);
            GLES30.glBindFramebuffer(36160, 0);
            GLES30.glBindTexture(3553, 0);
        L28:
            float r110 = this.H0;
            if (r110 < 150.0f) goto L32;
            float r111 = r110 / 120.0f;
            g(this.B, this.W, r111, this.I, this.f396439J);
            g(this.X, this.Y, r111, this.K, this.L);
            g(this.Z, this.f396451k0, r111, this.M, this.N);
            i(this.f396457p0, this.Y, r111, this.K, this.L);
            i(this.Z, this.W, r111, this.I, this.f396439J);
            i(this.X, this.S, r111, this.G, this.H);
            k(this.T, 0);
        L41:
            this.D = this.C;
            this.F = this.E;
            this.Q = this.R;
            return;
        L32:
            if (r110 < 120.0f) goto L35;
            float r112 = r110 / 120.0f;
            g(this.B, this.W, r112, this.I, this.f396439J);
            g(this.X, this.Y, r112, this.K, this.L);
            g(this.Z, this.f396451k0, r112, this.M, this.N);
            i(this.f396457p0, this.Y, r112, this.K, this.L);
            i(this.Z, this.W, r112, this.I, this.f396439J);
            i(this.X, this.U, r112, this.G, this.H);
            float r113 = this.H0 / 30.0f;
            g(this.B, this.W, r113, this.I, this.f396439J);
            i(this.X, this.S, r113, this.G, this.H);
            g(this.T, this.W, r113, this.I, this.f396439J);
            i(this.X, this.S, r113, this.G, this.H);
            g(this.T, this.W, r113, this.I, this.f396439J);
            i(this.X, this.S, r113, this.G, this.H);
            j(this.T, this.V, 1.0f - ((150.0f - this.H0) / 30.0f), false);
            goto L41
        L35:
            if (r110 < 30.0f) goto L38;
            float r114 = r110 / 30.0f;
            g(this.B, this.W, r114, this.I, this.f396439J);
            i(this.X, this.S, r114, this.G, this.H);
            g(this.T, this.W, r114, this.I, this.f396439J);
            i(this.X, this.S, r114, this.G, this.H);
            g(this.T, this.W, r114, this.I, this.f396439J);
            i(this.X, this.S, r114, this.G, this.H);
            k(this.T, 0);
            goto L41
        L38:
            if (r110 < 15.0f) goto L40;
            float r115 = r110 / 15.0f;
            g(this.B, this.S, r115, this.G, this.H);
            i(this.T, this.U, r115, this.G, this.H);
            g(this.V, this.S, r115, this.G, this.H);
            i(this.T, this.U, r115, this.G, this.H);
            g(this.V, this.S, r115, this.G, this.H);
            i(this.T, this.U, r115, this.G, this.H);
            float r116 = this.H0 / 30.0f;
            g(this.B, this.W, r116, this.I, this.f396439J);
            i(this.X, this.S, r116, this.G, this.H);
            g(this.T, this.W, r116, this.I, this.f396439J);
            i(this.X, this.S, r116, this.G, this.H);
            g(this.T, this.W, r116, this.I, this.f396439J);
            i(this.X, this.S, r116, this.G, this.H);
            j(this.V, this.T, 1.0f - ((30.0f - this.H0) / 15.0f), false);
            goto L41
        L40:
            g(this.B, this.S, 1.0f, this.G, this.H);
            i(this.T, this.U, 1.0f, this.G, this.H);
            g(this.V, this.S, 1.0f, this.G, this.H);
            i(this.T, this.U, 1.0f, this.G, this.H);
            g(this.V, this.S, 1.0f, this.G, this.H);
            i(this.T, this.U, 1.0f, this.G, this.H);
            j(this.A, this.V, this.H0 / 15.0f, true);
            goto L41
        L10:
            if (r101 != this.F) goto L13;
            r102 = false;
            goto L15
        }

        public static int[] b(int r110, int r111) {
            int[] r100 = new int[1];
            GLES30.glGenFramebuffers(1, r100, 0);
            GLES30.glBindFramebuffer(36160, r100[0]);
            int[] r101 = new int[1];
            GLES30.glGenTextures(1, r101, 0);
            GLES30.glBindTexture(3553, r101[0]);
            GLES30.glTexImage2D(3553, 0, 6408, r110, r111, 0, 6408, 5121, null);
            GLES30.glTexParameteri(3553, 10242, 33071);
            GLES30.glTexParameteri(3553, 10243, 33071);
            GLES30.glTexParameteri(3553, 10241, 9729);
            GLES30.glTexParameteri(3553, 10240, 9729);
            GLES30.glFramebufferTexture2D(36160, 36064, 3553, r101[0], 0);
            GLES30.glBindFramebuffer(36160, 0);
            return new int[]{r100[0], r101[0]};
        }

        public static int d(int r100, String r101) {
            int r102 = GLES30.glCreateShader(r100);
            if (r102 == 0) goto L8;
            GLES30.glShaderSource(r102, r101);
            GLES30.glCompileShader(r102);
            int[] r103 = new int[1];
            GLES30.glGetShaderiv(r102, 35713, r103, 0);
            if (r103[0] != 0) goto L9;
            GLES30.glGetShaderInfoLog(r102);
            GLES30.glDeleteShader(r102);
            return 0;
        L9:
            return r102;
        L8:
            return r102;
        }

        public final int[] e(int r110, int r111) {
            GLES30.glUseProgram(r110);
            int[] r100 = new int[1];
            GLES30.glGenVertexArrays(1, r100, 0);
            int r101 = r100[0];
            GLES30.glBindVertexArray(r101);
            int[] r102 = new int[1];
            GLES30.glGenBuffers(1, r102, 0);
            int r103 = r102[0];
            GLES30.glBindBuffer(34962, r103);
            GLES30.glBufferData(34962, this.O.length * 4, this.P, 35044);
            GLES30.glEnableVertexAttribArray(r111);
            GLES30.glVertexAttribPointer(r111, 2, 5126, false, 0, 0);
            GLES30.glBindBuffer(34962, 0);
            GLES30.glBindVertexArray(0);
            GLES30.glUseProgram(0);
            return new int[]{r101, r103};
        }

        public final void k(int r100, int r101) {
            if (r101 == 0) goto L5;
            GLES30.glViewport(0, 0, this.G, this.H);
            GLES30.glBindFramebuffer(36160, r101);
        L6:
            GLES30.glClearColor(0.0f, 0.0f, 0.0f, 0.0f);
            GLES30.glClear(16384);
            GLES30.glUseProgram(this.f396440a);
            if (r101 == 0) goto L9;
            GLES30.glUniform2f(this.f396443d, this.G, this.H);
            GLES30.glUniform1i(this.f396444e, 1);
        L10:
            GLES30.glActiveTexture(33984);
            GLES30.glBindTexture(3553, r100);
            GLES30.glUniform1i(this.f396442c, 0);
            GLES30.glBindVertexArray(this.f396445f);
            GLES30.glDrawArrays(6, 0, 4);
            GLES30.glBindVertexArray(0);
            GLES30.glBindTexture(3553, 0);
            if (r101 == 0) goto L14;
            GLES30.glBindFramebuffer(36160, 0);
            return;
        L14:
            return;
        L9:
            GLES30.glUniform2f(this.f396443d, this.C, this.E);
            GLES30.glUniform1i(this.f396444e, 0);
            goto L10
        L5:
            GLES30.glViewport(0, 0, this.C, this.E);
            goto L6
        }

        @Override // android.opengl.GLSurfaceView.Renderer
        public final void onSurfaceCreated(GL10 r100, EGLConfig r110) {
            int r101 = c("#version 300 es\nprecision highp float;\nuniform vec2 u_resolution;\nuniform sampler2D u_background;\nuniform int u_revert;\nout vec4 fragColor;\nvoid main() {\n    vec2 texUV = gl_FragCoord.xy / u_resolution;\n    texUV.y = u_revert > 0 ? 1.0 - texUV.y : texUV.y;\n    fragColor = texture(u_background, texUV);\n}\n");
            this.f396440a = r101;
            this.f396441b = GLES30.glGetAttribLocation(r101, "vPosition");
            a("glGetAttribLocation");
            this.f396442c = GLES30.glGetUniformLocation(this.f396440a, "u_background");
            a("glGetAttribLocation");
            this.f396443d = GLES30.glGetUniformLocation(this.f396440a, "u_resolution");
            a("glGetUniformLocation");
            this.f396444e = GLES30.glGetUniformLocation(this.f396440a, "u_revert");
            a("glGetUniformLocation");
            this.f396445f = e(this.f396440a, this.f396441b)[0];
            int r102 = c("#version 300 es\nprecision mediump float;\nuniform vec2 u_resolution;\nuniform sampler2D u_background;\nuniform float u_blurOffset;\nout vec4 fragColor;\nvoid main() {\n    vec2 uv = gl_FragCoord.xy / u_resolution;\n    vec2 halfPixel = 0.5 / u_resolution;\n    fragColor = texture(u_background, uv) * 0.5;\n    fragColor += texture(u_background, uv - halfPixel * u_blurOffset) * 0.125;\n    fragColor += texture(u_background, uv + halfPixel * u_blurOffset) * 0.125;\n    fragColor += texture(u_background, uv + vec2(halfPixel.x, -halfPixel.y) * u_blurOffset) * 0.125;\n    fragColor += texture(u_background, uv - vec2(halfPixel.x, -halfPixel.y) * u_blurOffset) * 0.125;\n}\n");
            this.f396446g = r102;
            this.f396447h = GLES30.glGetAttribLocation(r102, "vPosition");
            a("glGetAttribLocation");
            this.f396448i = GLES30.glGetUniformLocation(this.f396446g, "u_background");
            a("glGetAttribLocation");
            this.f396449j = GLES30.glGetUniformLocation(this.f396446g, "u_resolution");
            a("glGetUniformLocation");
            this.f396450k = GLES30.glGetUniformLocation(this.f396446g, "u_blurOffset");
            a("glGetUniformLocation");
            this.f396452l = e(this.f396446g, this.f396447h)[0];
            int r103 = c("#version 300 es\nprecision mediump float;\nuniform vec2 u_resolution;\nuniform sampler2D u_background;\nuniform float u_blurOffset;\nout vec4 fragColor;\nvoid main() {\n    vec2 uv = gl_FragCoord.xy / u_resolution;\n    vec2 halfPixel = 0.5 / u_resolution;\n    fragColor =  texture(u_background, uv + vec2(-halfPixel.x * 2.0, 0.0) * u_blurOffset);\n    fragColor += texture(u_background, uv + vec2(-halfPixel.x, halfPixel.y) * u_blurOffset) * 2.0;\n    fragColor += texture(u_background, uv + vec2(0.0, halfPixel.y * 2.0) * u_blurOffset);\n    fragColor += texture(u_background, uv + vec2(halfPixel.x, halfPixel.y) * u_blurOffset) * 2.0;\n    fragColor += texture(u_background, uv + vec2(halfPixel.x * 2.0, 0.0) * u_blurOffset);\n    fragColor += texture(u_background, uv + vec2(halfPixel.x, -halfPixel.y) * u_blurOffset) * 2.0;\n    fragColor += texture(u_background, uv + vec2(0.0, -halfPixel.y * 2.0) * u_blurOffset);\n    fragColor += texture(u_background, uv + vec2(-halfPixel.x, -halfPixel.y) * u_blurOffset) * 2.0;\n    fragColor /=  12.0;\n}\n");
            this.f396453m = r103;
            this.f396454n = GLES30.glGetAttribLocation(r103, "vPosition");
            a("glGetAttribLocation");
            this.f396455o = GLES30.glGetUniformLocation(this.f396453m, "u_background");
            a("glGetAttribLocation");
            this.f396456p = GLES30.glGetUniformLocation(this.f396453m, "u_resolution");
            a("glGetUniformLocation");
            this.f396458q = GLES30.glGetUniformLocation(this.f396453m, "u_blurOffset");
            a("glGetUniformLocation");
            this.f396459r = e(this.f396453m, this.f396454n)[0];
            int r104 = c("#version 300 es\nprecision highp float;\nuniform vec2 u_resolution;\nuniform sampler2D u_background;\nuniform sampler2D u_foreground;\nuniform int u_revert;\nuniform float u_alpha;\nout vec4 fragColor;\nvoid main() {\n    vec2 texUV = gl_FragCoord.xy / u_resolution;\n    vec4 colorB = texture(u_foreground, texUV);\n    texUV.y = u_revert > 0 ? 1.0 - texUV.y : texUV.y;\n    vec4 colorA = texture(u_background, texUV);\n    fragColor = mix(colorA, colorB, u_alpha);\n}\n");
            this.f396460s = r104;
            this.f396461t = GLES30.glGetAttribLocation(r104, "vPosition");
            a("glGetAttribLocation");
            this.f396462u = GLES30.glGetUniformLocation(this.f396460s, "u_background");
            a("glGetAttribLocation");
            this.f396463v = GLES30.glGetUniformLocation(this.f396460s, "u_foreground");
            a("glGetAttribLocation");
            this.f396464w = GLES30.glGetUniformLocation(this.f396460s, "u_resolution");
            a("glGetUniformLocation");
            this.f396465x = GLES30.glGetUniformLocation(this.f396460s, "u_revert");
            a("glGetUniformLocation");
            this.f396466y = GLES30.glGetUniformLocation(this.f396460s, "u_alpha");
            a("glGetUniformLocation");
            this.f396467z = e(this.f396460s, this.f396461t)[0];
        }

        @Override // android.opengl.GLSurfaceView.Renderer
        public final void onSurfaceChanged(GL10 r100, int r101, int r102) {
            this.C = r101;
            this.E = r102;
            if (r101 == 0) goto L43;
            if (r102 != 0) goto L7;
            return;
        L7:
            if (r101 == this.D) goto L9;
        L11:
            int r103 = this.S;
            if (r103 == 0) goto L14;
            GLES30.glDeleteFramebuffers(1, new int[]{r103}, 0);
        L14:
            int r104 = this.T;
            if (r104 == 0) goto L17;
            GLES30.glDeleteTextures(1, new int[]{r104}, 0);
        L17:
            int r105 = this.U;
            if (r105 == 0) goto L20;
            GLES30.glDeleteFramebuffers(1, new int[]{r105}, 0);
        L20:
            int r106 = this.V;
            if (r106 == 0) goto L23;
            GLES30.glDeleteTextures(1, new int[]{r106}, 0);
        L23:
            int r107 = this.W;
            if (r107 == 0) goto L26;
            GLES30.glDeleteFramebuffers(1, new int[]{r107}, 0);
        L26:
            int r108 = this.X;
            if (r108 == 0) goto L29;
            GLES30.glDeleteTextures(1, new int[]{r108}, 0);
        L29:
            int r109 = this.Y;
            if (r109 == 0) goto L32;
            GLES30.glDeleteFramebuffers(1, new int[]{r109}, 0);
        L32:
            int r110 = this.Z;
            if (r110 == 0) goto L35;
            GLES30.glDeleteTextures(1, new int[]{r110}, 0);
        L35:
            int r111 = this.f396451k0;
            if (r111 == 0) goto L38;
            GLES30.glDeleteFramebuffers(1, new int[]{r111}, 0);
        L38:
            int r112 = this.f396457p0;
            if (r112 == 0) goto L41;
            GLES30.glDeleteTextures(1, new int[]{r112}, 0);
        L41:
            int r113 = this.C / 4;
            this.G = r113;
            int r114 = this.E / 4;
            this.H = r114;
            int[] r115 = b(r113, r114);
            this.S = r115[0];
            this.T = r115[1];
            int[] r116 = b(this.G, this.H);
            this.U = r116[0];
            this.V = r116[1];
            this.I = (int) Math.ceil(this.G / 2.0f);
            int r117 = (int) Math.ceil(this.H / 2.0f);
            this.f396439J = r117;
            int[] r118 = b(this.I, r117);
            this.W = r118[0];
            this.X = r118[1];
            this.K = (int) Math.ceil(this.I / 2.0f);
            int r119 = (int) Math.ceil(this.f396439J / 2.0f);
            this.L = r119;
            int[] r120 = b(this.K, r119);
            this.Y = r120[0];
            this.Z = r120[1];
            this.M = (int) Math.ceil(this.K / 2.0f);
            int r121 = (int) Math.ceil(this.L / 2.0f);
            this.N = r121;
            int[] r122 = b(this.M, r121);
            this.f396451k0 = r122[0];
            this.f396457p0 = r122[1];
            return;
        L9:
            if (r102 != this.F) goto L11;
            return;
        }

        public final void j(int r100, int r101, float r102, boolean r103) {
            GLES30.glViewport(0, 0, this.C, this.E);
            GLES30.glClearColor(0.0f, 0.0f, 0.0f, 0.0f);
            GLES30.glClear(16384);
            GLES30.glUseProgram(this.f396460s);
            GLES30.glUniform2f(this.f396464w, this.C, this.E);
            GLES30.glUniform1i(this.f396465x, r103 ? 1 : 0);
            GLES30.glUniform1f(this.f396466y, r102);
            GLES30.glActiveTexture(33984);
            GLES30.glBindTexture(3553, r100);
            GLES30.glUniform1i(this.f396462u, 0);
            GLES30.glActiveTexture(33985);
            GLES30.glBindTexture(3553, r101);
            GLES30.glUniform1i(this.f396463v, 1);
            GLES30.glBindVertexArray(this.f396467z);
            GLES30.glDrawArrays(6, 0, 4);
            GLES30.glBindVertexArray(0);
        }

        public final void g(int r100, int r101, float r102, int r103, int r104) {
            GLES30.glViewport(0, 0, r103, r104);
            GLES30.glBindFramebuffer(36160, r101);
            GLES30.glClearColor(0.0f, 0.0f, 0.0f, 0.0f);
            GLES30.glClear(16384);
            GLES30.glUseProgram(this.f396446g);
            GLES30.glUniform2f(this.f396449j, r103, r104);
            GLES30.glUniform1f(this.f396450k, r102);
            GLES30.glActiveTexture(33984);
            GLES30.glBindTexture(3553, r100);
            GLES30.glUniform1i(this.f396448i, 0);
            GLES30.glBindVertexArray(this.f396452l);
            GLES30.glDrawArrays(6, 0, 4);
            GLES30.glBindVertexArray(0);
            if (r101 == 0) goto L6;
            GLES30.glBindFramebuffer(36160, 0);
            return;
        }

        public final void i(int r100, int r101, float r102, int r103, int r104) {
            GLES30.glViewport(0, 0, r103, r104);
            GLES30.glBindFramebuffer(36160, r101);
            GLES30.glClearColor(0.0f, 0.0f, 0.0f, 0.0f);
            GLES30.glClear(16384);
            GLES30.glUseProgram(this.f396453m);
            GLES30.glUniform2f(this.f396456p, r103, r104);
            GLES30.glUniform1f(this.f396458q, r102);
            GLES30.glActiveTexture(33984);
            GLES30.glBindTexture(3553, r100);
            GLES30.glUniform1i(this.f396455o, 0);
            GLES30.glBindVertexArray(this.f396459r);
            GLES30.glDrawArrays(6, 0, 4);
            GLES30.glBindVertexArray(0);
            GLES30.glBindFramebuffer(36160, 0);
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

    public GL3ShaderViewKawaseBlur(Context r100) {
        super(r100, null);
    }

    @Override // android.view.Choreographer.FrameCallback
    public final void doFrame(long r100) {
        requestRender();
        Choreographer.getInstance().postFrameCallback(this);
    }

    public void setBackgroundImage(Bitmap r100) {
        this.f396438a.R = r100;
    }

    public void setBlurRadius(float r100) {
        a r101 = this.f396438a;
        if (r101.L0 == r100) goto L6;
        r101.L0 = r100;
        r101.H0 = r100 * 10.0f;
        return;
    }

    public GL3ShaderViewKawaseBlur(Context r100, AttributeSet r101) {
        super(r100, r101);
        getHolder().setFormat(1);
        setZOrderOnTop(true);
        setEGLContextClientVersion(3);
        setEGLConfigChooser(8, 8, 8, 0, 0, 0);
        a r102 = new a();
        this.f396438a = r102;
        setRenderer(r102);
        setRenderMode(0);
        setPreserveEGLContextOnPause(true);
    }
}
