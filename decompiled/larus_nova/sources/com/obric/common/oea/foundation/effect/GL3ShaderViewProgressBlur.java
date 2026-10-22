package com.obric.common.oea.foundation.effect;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Rect;
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
public class GL3ShaderViewProgressBlur extends GLSurfaceView implements Choreographer.FrameCallback {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public a f396468a;

    public class a implements GLSurfaceView.Renderer {
        public int A;
        public int B;
        public int C;
        public int D;
        public int E;
        public int F;
        public int G;
        public int H;
        public int H0;
        public int I;

        /* JADX INFO: renamed from: J, reason: collision with root package name */
        public int f396469J;
        public int K;
        public int L;
        public int L0;
        public int M;
        public int N;
        public int O;
        public int P;
        public int P0;
        public int Q;
        public int R;
        public final float[] S;
        public final FloatBuffer T;
        public Bitmap U;
        public Bitmap V;
        public int V0;
        public int W;
        public int X;
        public int Y;
        public int Z;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f396470a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f396471b;

        /* JADX INFO: renamed from: b1, reason: collision with root package name */
        public int f396472b1;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f396473c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f396474d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public int f396475e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public int f396476f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public int f396477g;

        /* JADX INFO: renamed from: g1, reason: collision with root package name */
        public int f396478g1;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public int f396479h;

        /* JADX INFO: renamed from: h1, reason: collision with root package name */
        public float f396480h1;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public int f396481i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public int f396482j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public int f396483k;

        /* JADX INFO: renamed from: k0, reason: collision with root package name */
        public int f396484k0;

        /* JADX INFO: renamed from: k1, reason: collision with root package name */
        public int f396485k1;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public int f396486l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public int f396487m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public int f396488n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public int f396489o;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        public int f396490p;

        /* JADX INFO: renamed from: p0, reason: collision with root package name */
        public int f396491p0;

        /* JADX INFO: renamed from: p1, reason: collision with root package name */
        public final Rect f396492p1;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        public int f396493q;

        /* JADX INFO: renamed from: r, reason: collision with root package name */
        public int f396494r;

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        public int f396495s;

        /* JADX INFO: renamed from: t, reason: collision with root package name */
        public int f396496t;

        /* JADX INFO: renamed from: u, reason: collision with root package name */
        public int f396497u;

        /* JADX INFO: renamed from: v, reason: collision with root package name */
        public int f396498v;

        /* JADX INFO: renamed from: v1, reason: collision with root package name */
        public final Rect f396499v1;

        /* JADX INFO: renamed from: w, reason: collision with root package name */
        public int f396500w;

        /* JADX INFO: renamed from: x, reason: collision with root package name */
        public int f396501x;

        /* JADX INFO: renamed from: y, reason: collision with root package name */
        public int f396502y;

        /* JADX INFO: renamed from: z, reason: collision with root package name */
        public int f396503z;

        public final void g() {
            int r100 = this.Y;
            if (r100 == 0) goto L5;
            GLES30.glDeleteFramebuffers(1, new int[]{r100}, 0);
        L5:
            int r101 = this.Z;
            if (r101 == 0) goto L8;
            GLES30.glDeleteTextures(1, new int[]{r101}, 0);
        L8:
            int r102 = this.f396484k0;
            if (r102 == 0) goto L11;
            GLES30.glDeleteFramebuffers(1, new int[]{r102}, 0);
        L11:
            int r103 = this.f396491p0;
            if (r103 == 0) goto L14;
            GLES30.glDeleteTextures(1, new int[]{r103}, 0);
        L14:
            int r104 = this.H0;
            if (r104 == 0) goto L17;
            GLES30.glDeleteFramebuffers(1, new int[]{r104}, 0);
        L17:
            int r105 = this.L0;
            if (r105 == 0) goto L20;
            GLES30.glDeleteTextures(1, new int[]{r105}, 0);
        L20:
            int r106 = this.P0;
            if (r106 == 0) goto L23;
            GLES30.glDeleteFramebuffers(1, new int[]{r106}, 0);
        L23:
            int r107 = this.V0;
            if (r107 == 0) goto L26;
            GLES30.glDeleteTextures(1, new int[]{r107}, 0);
        L26:
            int r108 = this.f396472b1;
            if (r108 == 0) goto L29;
            GLES30.glDeleteFramebuffers(1, new int[]{r108}, 0);
        L29:
            int r109 = this.f396478g1;
            if (r109 == 0) goto L32;
            GLES30.glDeleteTextures(1, new int[]{r109}, 0);
        L32:
            int[] r110 = b(this.f396492p1.width(), this.f396492p1.height());
            this.Y = r110[0];
            this.Z = r110[1];
            int[] r111 = b(this.f396492p1.width(), this.f396492p1.height());
            this.f396484k0 = r111[0];
            this.f396491p0 = r111[1];
            this.O = this.f396492p1.width() / 2;
            int r112 = this.f396492p1.height() / 2;
            this.P = r112;
            int[] r113 = b(this.O, r112);
            this.H0 = r113[0];
            this.L0 = r113[1];
            int[] r114 = b(this.O, this.P);
            this.P0 = r114[0];
            this.V0 = r114[1];
            this.Q = (int) Math.ceil(this.O / 2.0f);
            int r115 = (int) Math.ceil(this.P / 2.0f);
            this.R = r115;
            int[] r116 = b(this.Q, r115);
            this.f396472b1 = r116[0];
            this.f396478g1 = r116[1];
        }

        public a() {
            this.f396469J = 0;
            this.K = 0;
            this.L = 0;
            this.M = 0;
            this.N = 0;
            float[] r100 = {-1.0f, 1.0f, -1.0f, -1.0f, 1.0f, -1.0f, 1.0f, 1.0f};
            this.S = r100;
            this.W = 0;
            this.X = 0;
            this.Y = 0;
            this.Z = 0;
            this.f396484k0 = 0;
            this.f396491p0 = 0;
            this.H0 = 0;
            this.L0 = 0;
            this.P0 = 0;
            this.V0 = 0;
            this.f396472b1 = 0;
            this.f396478g1 = 0;
            this.f396480h1 = 60.0f;
            this.f396485k1 = 0;
            this.f396492p1 = new Rect(0, 0, 1264, 400);
            this.f396499v1 = new Rect(0, 0, 1264, 400);
            FloatBuffer r101 = ByteBuffer.allocateDirect(32).order(ByteOrder.nativeOrder()).asFloatBuffer().put(r100);
            this.T = r101;
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
        public final void onDrawFrame(GL10 r110) {
            if (this.K != 0) goto L5;
            return;
        L5:
            if (this.M != 0) goto L8;
            return;
        L8:
            if (this.V == this.U) goto L16;
            int r111 = this.f396469J;
            if (r111 == 0) goto L12;
            GLES30.glDeleteTextures(1, new int[]{r111}, 0);
        L12:
            Bitmap r112 = this.V;
            int[] r100 = new int[1];
            GLES30.glGenTextures(1, r100, 0);
            int r101 = r100[0];
            if (r101 == 0) goto L15;
            GLES30.glBindTexture(3553, r101);
            GLUtils.texImage2D(3553, 0, r112, 0);
            GLES30.glTexParameteri(3553, 10241, 9728);
            GLES30.glTexParameteri(3553, 10240, 9728);
            GLES30.glTexParameteri(3553, 10242, 10497);
            GLES30.glTexParameteri(3553, 10243, 10497);
            GLES30.glBindTexture(3553, 0);
        L15:
            this.f396469J = r100[0];
        L16:
            l(this.f396469J, this.W, true);
            if (this.f396499v1.width() == this.f396492p1.width()) goto L19;
        L20:
            g();
        L21:
            k(this.X, this.Y);
            float r113 = this.f396480h1 / 30.0f;
            i(this.Z, this.f396472b1, r113, this.Q, this.R);
            j(this.f396478g1, this.H0, r113, this.O, this.P);
            i(this.L0, this.f396472b1, r113, this.Q, this.R);
            j(this.f396478g1, this.H0, r113, this.O, this.P);
            i(this.L0, this.f396472b1, r113, this.Q, this.R);
            j(this.f396478g1, this.H0, r113, this.O, this.P);
            i(this.L0, this.f396472b1, r113, this.Q, this.R);
            j(this.f396478g1, this.H0, r113, this.O, this.P);
            i(this.L0, this.f396472b1, r113, this.Q, this.R);
            j(this.f396478g1, this.H0, r113, this.O, this.P);
            i(this.L0, this.f396472b1, r113, this.Q, this.R);
            j(this.f396478g1, this.H0, r113, this.O, this.P);
            i(this.L0, this.f396472b1, r113, this.Q, this.R);
            j(this.f396478g1, this.H0, r113, this.O, this.P);
            i(this.L0, this.f396472b1, r113, this.Q, this.R);
            j(this.f396478g1, this.H0, r113, this.O, this.P);
            int r102 = this.Z;
            int r103 = this.L0;
            int r104 = this.f396484k0;
            GLES30.glViewport(0, 0, this.f396492p1.width(), this.f396492p1.height());
            GLES30.glBindFramebuffer(36160, r104);
            GLES30.glClearColor(0.0f, 0.0f, 0.0f, 0.0f);
            GLES30.glClear(16384);
            GLES30.glUseProgram(this.B);
            GLES30.glUniform2f(this.F, this.f396492p1.width(), this.f396492p1.height());
            GLES30.glUniform1f(this.H, r113);
            int r114 = this.f396485k1;
            if (r114 != 0) goto L24;
            GLES30.glUniform4f(this.G, 0.0f, 0.0f, 0.0f, 1.0f);
        L26:
            GLES30.glActiveTexture(33984);
            GLES30.glBindTexture(3553, r102);
            GLES30.glUniform1i(this.D, 0);
            GLES30.glActiveTexture(33985);
            GLES30.glBindTexture(3553, r103);
            GLES30.glUniform1i(this.E, 1);
            GLES30.glBindVertexArray(this.I);
            GLES30.glDrawArrays(6, 0, 4);
            GLES30.glBindVertexArray(0);
            GLES30.glBindFramebuffer(36160, 0);
            l(this.X, 0, false);
            k(this.f396491p0, 0);
            this.L = this.K;
            this.N = this.M;
            this.U = this.V;
            this.f396499v1.set(this.f396492p1);
            return;
        L24:
            if (r114 != 1) goto L26;
            GLES30.glUniform4f(this.G, 0.0f, 1.0f, 0.0f, -1.0f);
            goto L26
        L19:
            if (this.f396499v1.height() == this.f396492p1.height()) goto L21;
            goto L20
        }

        public static int[] b(int r110, int r111) {
            int[] r100 = new int[1];
            GLES30.glGenFramebuffers(1, r100, 0);
            GLES30.glBindFramebuffer(36160, r100[0]);
            int[] r101 = new int[1];
            GLES30.glGenTextures(1, r101, 0);
            GLES30.glBindTexture(3553, r101[0]);
            GLES30.glTexImage2D(3553, 0, 6408, r110, r111, 0, 6408, 5121, null);
            GLES30.glTexParameteri(3553, 10242, 33648);
            GLES30.glTexParameteri(3553, 10243, 33648);
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
            GLES30.glBufferData(34962, this.S.length * 4, this.T, 35044);
            GLES30.glEnableVertexAttribArray(r111);
            GLES30.glVertexAttribPointer(r111, 2, 5126, false, 0, 0);
            GLES30.glBindBuffer(34962, 0);
            GLES30.glBindVertexArray(0);
            GLES30.glUseProgram(0);
            return new int[]{r101, r103};
        }

        public final void k(int r110, int r111) {
            if (r111 == 0) goto L5;
            GLES30.glViewport(0, 0, this.f396492p1.width(), this.f396492p1.height());
            GLES30.glBindFramebuffer(36160, r111);
            GLES30.glClearColor(0.0f, 0.0f, 0.0f, 0.0f);
            GLES30.glClear(16384);
        L6:
            GLES30.glUseProgram(this.f396498v);
            Rect r100 = this.f396492p1;
            float r101 = r100.left / this.K;
            int r102 = this.M;
            float r103 = (r102 - r100.bottom) / r102;
            float r104 = r100.width() / this.K;
            float r105 = this.f396492p1.height();
            int r106 = this.M;
            float r107 = r105 / r106;
            if (r111 == 0) goto L9;
            GLES30.glUniform2f(this.f396502y, this.f396492p1.width(), this.f396492p1.height());
            GLES30.glUniform4f(this.f396503z, r101, r103, r104, r107);
        L10:
            GLES30.glActiveTexture(33984);
            GLES30.glBindTexture(3553, r110);
            GLES30.glUniform1i(this.f396501x, 0);
            GLES30.glBindVertexArray(this.A);
            GLES30.glDrawArrays(6, 0, 4);
            GLES30.glBindVertexArray(0);
            GLES30.glBindTexture(3553, 0);
            if (r111 == 0) goto L14;
            GLES30.glBindFramebuffer(36160, 0);
            return;
        L14:
            return;
        L9:
            GLES30.glUniform2f(this.f396502y, this.K, r106);
            GLES30.glUniform4f(this.f396503z, (-r101) / r104, (-r103) / r107, 1.0f / r104, 1.0f / r107);
            goto L10
        L5:
            GLES30.glViewport(0, 0, this.K, this.M);
            goto L6
        }

        @Override // android.opengl.GLSurfaceView.Renderer
        public final void onSurfaceCreated(GL10 r100, EGLConfig r110) {
            int r101 = c("#version 300 es\nprecision highp float;\nuniform vec2 u_resolution;\nuniform vec2 u_uvOffset;\nuniform sampler2D u_background;\nuniform int u_revert;\nout vec4 fragColor;\nvoid main() {\n    vec2 texUV = gl_FragCoord.xy / u_resolution;\n    texUV.y = u_revert > 0 ? 1.0 - texUV.y : texUV.y;\n    texUV += u_uvOffset;\n    fragColor = texture(u_background, texUV);\n}\n");
            this.f396470a = r101;
            this.f396471b = GLES30.glGetAttribLocation(r101, "vPosition");
            a("glGetAttribLocation");
            this.f396473c = GLES30.glGetUniformLocation(this.f396470a, "u_background");
            a("glGetAttribLocation");
            this.f396474d = GLES30.glGetUniformLocation(this.f396470a, "u_resolution");
            a("glGetUniformLocation");
            this.f396475e = GLES30.glGetUniformLocation(this.f396470a, "u_revert");
            a("glGetUniformLocation");
            this.f396476f = GLES30.glGetUniformLocation(this.f396470a, "u_uvOffset");
            a("glGetUniformLocation");
            this.f396477g = e(this.f396470a, this.f396471b)[0];
            int r102 = c("#version 300 es\nprecision mediump float;\nuniform vec2 u_resolution;\nuniform vec4 u_direction;\nuniform sampler2D u_background;\nuniform float u_blurOffset;\nout vec4 fragColor;\nfloat easeInCubic(float t) {\n    return t * t;\n}\nvoid main() {\n    vec2 uv = gl_FragCoord.xy / u_resolution;\n    vec2 halfPixel = 0.5 / u_resolution;\n    float factor = dot(uv - u_direction.xy, u_direction.zw);\n    float blurOffset = u_blurOffset * easeInCubic(factor);\n    blurOffset = blurOffset < 1.0 ? 1.0 : blurOffset;\n    fragColor = texture(u_background, uv) * 0.5;\n    fragColor += texture(u_background, uv - halfPixel * blurOffset) * 0.125;\n    fragColor += texture(u_background, uv + halfPixel * blurOffset) * 0.125;\n    fragColor += texture(u_background, uv + vec2(halfPixel.x, -halfPixel.y) * blurOffset) * 0.125;\n    fragColor += texture(u_background, uv - vec2(halfPixel.x, -halfPixel.y) * blurOffset) * 0.125;\n}\n");
            this.f396479h = r102;
            this.f396481i = GLES30.glGetAttribLocation(r102, "vPosition");
            a("glGetAttribLocation");
            this.f396482j = GLES30.glGetUniformLocation(this.f396479h, "u_background");
            a("glGetAttribLocation");
            this.f396483k = GLES30.glGetUniformLocation(this.f396479h, "u_resolution");
            a("glGetUniformLocation");
            this.f396486l = GLES30.glGetUniformLocation(this.f396479h, "u_direction");
            a("glGetUniformLocation");
            this.f396487m = GLES30.glGetUniformLocation(this.f396479h, "u_blurOffset");
            a("glGetUniformLocation");
            this.f396488n = e(this.f396479h, this.f396481i)[0];
            int r103 = c("#version 300 es\nprecision mediump float;\nuniform vec2 u_resolution;\nuniform vec4 u_direction;\nuniform sampler2D u_background;\nuniform float u_blurOffset;\nout vec4 fragColor;\nfloat easeInCubic(float t) {\n    return t * t;\n}\nvoid main() {\n    vec2 uv = gl_FragCoord.xy / u_resolution;\n    vec2 halfPixel = 0.5 / u_resolution;\n    float factor = dot(uv - u_direction.xy, u_direction.zw);\n    float blurOffset = u_blurOffset * easeInCubic(factor);\n    blurOffset = blurOffset < 1.0 ? 1.0 : blurOffset;\n    fragColor =  texture(u_background, uv + vec2(-halfPixel.x * 2.0, 0.0) * blurOffset);\n    fragColor += texture(u_background, uv + vec2(-halfPixel.x, halfPixel.y) * blurOffset) * 2.0;\n    fragColor += texture(u_background, uv + vec2(0.0, halfPixel.y * 2.0) * blurOffset);\n    fragColor += texture(u_background, uv + vec2(halfPixel.x, halfPixel.y) * blurOffset) * 2.0;\n    fragColor += texture(u_background, uv + vec2(halfPixel.x * 2.0, 0.0) * blurOffset);\n    fragColor += texture(u_background, uv + vec2(halfPixel.x, -halfPixel.y) * blurOffset) * 2.0;\n    fragColor += texture(u_background, uv + vec2(0.0, -halfPixel.y * 2.0) * blurOffset);\n    fragColor += texture(u_background, uv + vec2(-halfPixel.x, -halfPixel.y) * blurOffset) * 2.0;\n    fragColor /=  12.0;\n}\n");
            this.f396489o = r103;
            this.f396490p = GLES30.glGetAttribLocation(r103, "vPosition");
            a("glGetAttribLocation");
            this.f396493q = GLES30.glGetUniformLocation(this.f396489o, "u_background");
            a("glGetAttribLocation");
            this.f396494r = GLES30.glGetUniformLocation(this.f396489o, "u_resolution");
            a("glGetUniformLocation");
            this.f396495s = GLES30.glGetUniformLocation(this.f396489o, "u_direction");
            a("glGetUniformLocation");
            this.f396496t = GLES30.glGetUniformLocation(this.f396489o, "u_blurOffset");
            a("glGetUniformLocation");
            this.f396497u = e(this.f396489o, this.f396490p)[0];
            int r104 = c("#version 300 es\nprecision highp float;\nuniform vec2 u_resolution;\nuniform sampler2D u_background;\nuniform int u_revert;\nuniform vec4 u_clip;\nout vec4 fragColor;\nvoid main() {\n    vec2 texUV = gl_FragCoord.xy / u_resolution;\n    texUV.x = u_clip.x + u_clip.z * texUV.x;\n    texUV.y = u_clip.y + u_clip.w * texUV.y;\n    if (texUV.x < 0.0 || texUV.x > 1.0 || texUV.y < 0.0 || texUV.y > 1.0) {\n        discard;\n    }\n    fragColor = texture(u_background, texUV);\n}\n");
            this.f396498v = r104;
            this.f396500w = GLES30.glGetAttribLocation(r104, "vPosition");
            a("glGetAttribLocation");
            this.f396501x = GLES30.glGetUniformLocation(this.f396498v, "u_background");
            a("glGetAttribLocation");
            this.f396502y = GLES30.glGetUniformLocation(this.f396498v, "u_resolution");
            a("glGetUniformLocation");
            this.f396503z = GLES30.glGetUniformLocation(this.f396498v, "u_clip");
            a("glGetUniformLocation");
            this.A = e(this.f396498v, this.f396500w)[0];
            int r105 = c("#version 300 es\nprecision highp float;\nuniform vec2 u_resolution;\nuniform vec4 u_direction;\nuniform sampler2D u_background;\nuniform sampler2D u_foreground;\nuniform float u_blurOffset;\nout vec4 fragColor;\nfloat easeInCubic(float t) {\n    return t * t;\n}\nvoid main() {\n    vec2 uv = gl_FragCoord.xy / u_resolution;\n    vec4 colorA = texture(u_background, uv);\n    vec4 colorB = texture(u_foreground, uv);\n    float factor = dot(uv - u_direction.xy, u_direction.zw);\n    float blurOffset = u_blurOffset * easeInCubic(factor);\n    float alpha = blurOffset > 2.0 ? 1.0 : blurOffset / 2.0;\n    fragColor = mix(colorA, colorB, alpha);\n}\n");
            this.B = r105;
            this.C = GLES30.glGetAttribLocation(r105, "vPosition");
            a("glGetAttribLocation");
            this.D = GLES30.glGetUniformLocation(this.B, "u_background");
            a("glGetAttribLocation");
            this.E = GLES30.glGetUniformLocation(this.B, "u_foreground");
            a("glGetAttribLocation");
            this.F = GLES30.glGetUniformLocation(this.B, "u_resolution");
            a("glGetUniformLocation");
            this.G = GLES30.glGetUniformLocation(this.B, "u_direction");
            a("glGetUniformLocation");
            this.H = GLES30.glGetUniformLocation(this.B, "u_blurOffset");
            a("glGetUniformLocation");
            this.I = e(this.B, this.C)[0];
        }

        public final void l(int r100, int r101, boolean r102) {
            GLES30.glViewport(0, 0, this.K, this.M);
            if (r101 == 0) goto L5;
            GLES30.glBindFramebuffer(36160, r101);
        L5:
            GLES30.glClearColor(0.0f, 0.0f, 0.0f, 0.0f);
            GLES30.glClear(16384);
            GLES30.glUseProgram(this.f396470a);
            GLES30.glUniform2f(this.f396474d, this.K, this.M);
            GLES30.glUniform1i(this.f396475e, r102 ? 1 : 0);
            GLES30.glUniform2f(this.f396476f, 0.0f, 0.0f);
            GLES30.glActiveTexture(33984);
            GLES30.glBindTexture(3553, r100);
            GLES30.glUniform1i(this.f396473c, 0);
            GLES30.glBindVertexArray(this.f396477g);
            GLES30.glDrawArrays(6, 0, 4);
            GLES30.glBindVertexArray(0);
            GLES30.glBindTexture(3553, 0);
            if (r101 == 0) goto L9;
            GLES30.glBindFramebuffer(36160, 0);
            return;
        }

        @Override // android.opengl.GLSurfaceView.Renderer
        public final void onSurfaceChanged(GL10 r100, int r101, int r102) {
            this.K = r101;
            this.M = r102;
            if (r101 == 0) goto L19;
            if (r102 != 0) goto L7;
            return;
        L7:
            if (r101 == this.L) goto L9;
        L11:
            int r103 = this.W;
            if (r103 == 0) goto L14;
            GLES30.glDeleteFramebuffers(1, new int[]{r103}, 0);
        L14:
            int r104 = this.X;
            if (r104 == 0) goto L17;
            GLES30.glDeleteTextures(1, new int[]{r104}, 0);
        L17:
            int[] r105 = b(this.K, this.M);
            this.W = r105[0];
            this.X = r105[1];
            g();
            return;
        L9:
            if (r102 != this.N) goto L11;
            return;
        }

        public final void i(int r100, int r101, float r102, int r103, int r104) {
            GLES30.glViewport(0, 0, r103, r104);
            GLES30.glBindFramebuffer(36160, r101);
            GLES30.glClearColor(0.0f, 0.0f, 0.0f, 0.0f);
            GLES30.glClear(16384);
            GLES30.glUseProgram(this.f396479h);
            GLES30.glUniform2f(this.f396483k, r103, r104);
            GLES30.glUniform1f(this.f396487m, r102);
            int r105 = this.f396485k1;
            if (r105 != 0) goto L6;
            GLES30.glUniform4f(this.f396486l, 0.0f, 0.0f, 0.0f, 1.0f);
        L8:
            GLES30.glActiveTexture(33984);
            GLES30.glBindTexture(3553, r100);
            GLES30.glUniform1i(this.f396482j, 0);
            GLES30.glBindVertexArray(this.f396488n);
            GLES30.glDrawArrays(6, 0, 4);
            GLES30.glBindVertexArray(0);
            if (r101 == 0) goto L12;
            GLES30.glBindFramebuffer(36160, 0);
            return;
        L12:
            return;
        L6:
            if (r105 != 1) goto L8;
            GLES30.glUniform4f(this.f396486l, 0.0f, 1.0f, 0.0f, -1.0f);
            goto L8
        }

        public final void j(int r100, int r101, float r102, int r103, int r104) {
            GLES30.glViewport(0, 0, r103, r104);
            GLES30.glBindFramebuffer(36160, r101);
            GLES30.glClearColor(0.0f, 0.0f, 0.0f, 0.0f);
            GLES30.glClear(16384);
            GLES30.glUseProgram(this.f396489o);
            GLES30.glUniform2f(this.f396494r, r103, r104);
            GLES30.glUniform1f(this.f396496t, r102);
            int r105 = this.f396485k1;
            if (r105 != 0) goto L6;
            GLES30.glUniform4f(this.f396495s, 0.0f, 0.0f, 0.0f, 1.0f);
        L8:
            GLES30.glActiveTexture(33984);
            GLES30.glBindTexture(3553, r100);
            GLES30.glUniform1i(this.f396493q, 0);
            GLES30.glBindVertexArray(this.f396497u);
            GLES30.glDrawArrays(6, 0, 4);
            GLES30.glBindVertexArray(0);
            GLES30.glBindFramebuffer(36160, 0);
            return;
        L6:
            if (r105 != 1) goto L8;
            GLES30.glUniform4f(this.f396495s, 0.0f, 1.0f, 0.0f, -1.0f);
            goto L8
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

    public GL3ShaderViewProgressBlur(Context r100) {
        super(r100, null);
    }

    @Override // android.view.Choreographer.FrameCallback
    public final void doFrame(long r100) {
        requestRender();
        Choreographer.getInstance().postFrameCallback(this);
    }

    public void setBackgroundImage(Bitmap r100) {
        this.f396468a.V = r100;
    }

    public void setBlurRadius(float r100) {
        float r101 = r100 * 20.0f;
        this.f396468a.f396480h1 = r101;
    }

    public void setClipRect(Rect r100) {
        this.f396468a.f396492p1.set(r100);
    }

    public void setDirection(int r100) {
        this.f396468a.f396485k1 = r100;
    }

    public GL3ShaderViewProgressBlur(Context r100, AttributeSet r101) {
        super(r100, r101);
        getHolder().setFormat(1);
        setZOrderOnTop(true);
        setEGLContextClientVersion(3);
        setEGLConfigChooser(8, 8, 8, 0, 0, 0);
        a r102 = new a();
        this.f396468a = r102;
        setRenderer(r102);
        setRenderMode(0);
        setPreserveEGLContextOnPause(true);
    }
}
