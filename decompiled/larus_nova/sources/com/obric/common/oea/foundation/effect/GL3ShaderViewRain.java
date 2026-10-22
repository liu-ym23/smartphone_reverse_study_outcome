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
public class GL3ShaderViewRain extends GLSurfaceView implements Choreographer.FrameCallback {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ int f396504b = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public a f396505a;

    public static class a implements GLSurfaceView.Renderer {
        public int A;
        public int B;
        public int C;
        public int D;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f396506a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f396507b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f396508c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f396509d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public int f396510e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public int f396511f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public int f396512g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public int f396513h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public int f396514i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public int f396515j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public int f396516k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public float f396517l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public float f396518m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public float f396519n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public int f396520o;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        public int f396521p;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        public int f396522q;

        /* JADX INFO: renamed from: r, reason: collision with root package name */
        public int f396523r;

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        public final c f396524s;

        /* JADX INFO: renamed from: t, reason: collision with root package name */
        public final c f396525t;

        /* JADX INFO: renamed from: u, reason: collision with root package name */
        public final c f396526u;

        /* JADX INFO: renamed from: v, reason: collision with root package name */
        public final float[] f396527v;

        /* JADX INFO: renamed from: w, reason: collision with root package name */
        public final FloatBuffer f396528w;

        /* JADX INFO: renamed from: x, reason: collision with root package name */
        public Bitmap f396529x;

        /* JADX INFO: renamed from: y, reason: collision with root package name */
        public int f396530y;

        /* JADX INFO: renamed from: z, reason: collision with root package name */
        public int f396531z;

        public a(Context r100) {
            this.f396517l = -1.0f;
            this.f396518m = -1.0f;
            this.f396519n = -1.0f;
            this.f396520o = 0;
            this.f396521p = 0;
            this.f396522q = 0;
            this.f396523r = 0;
            this.f396524s = new c(1.0f);
            this.f396525t = new c(1.0f);
            this.f396526u = new c(0.25f);
            float[] r101 = {-1.0f, 1.0f, -1.0f, -1.0f, 1.0f, -1.0f, 1.0f, 1.0f};
            this.f396527v = r101;
            this.f396530y = 0;
            this.C = 0;
            this.D = 0;
            FloatBuffer r102 = ByteBuffer.allocateDirect(32).order(ByteOrder.nativeOrder()).asFloatBuffer().put(r101);
            this.f396528w = r102;
            r102.position(0);
        }

        public static void a(String r100) {
            int r101 = GLES30.glGetError();
            if (r101 != 0) goto L5;
            return;
        L5:
            int r102 = GL3ShaderViewRain.f396504b;
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
            int r105 = GL3ShaderViewRain.f396504b;
            GLES30.glGetProgramInfoLog(r103);
            GLES30.glDeleteProgram(r103);
            return 0;
        L14:
            return r103;
        }

        @Override // android.opengl.GLSurfaceView.Renderer
        public final void onDrawFrame(GL10 r210) {
            if (this.f396520o != this.f396521p) goto L7;
            if (this.f396522q != this.f396523r) goto L7;
        L16:
            long r100 = System.currentTimeMillis();
            GLES30.glClearColor(0.0f, 0.0f, 0.0f, 0.0f);
            GLES30.glClear(16384);
            GLES30.glUseProgram(this.f396506a);
            GLES30.glUniform1f(this.f396511f, (r100 % 1000000) / 1000.0f);
            int r101 = this.f396520o;
            if (r101 == this.f396521p) goto L19;
        L20:
            this.f396521p = r101;
            int r102 = this.f396522q;
            this.f396523r = r102;
            GLES30.glUniform2f(this.f396510e, r101, r102);
        L21:
            float r103 = this.f396524s.f472896a;
            if (r103 == this.f396517l) goto L24;
            this.f396517l = r103;
            GLES30.glUniform1f(this.f396512g, r103);
        L24:
            float r104 = this.f396525t.f472896a;
            if (r104 == this.f396518m) goto L27;
            this.f396518m = r104;
            GLES30.glUniform1f(this.f396513h, r104);
        L27:
            float r105 = this.f396526u.f472896a;
            if (r105 == this.f396519n) goto L30;
            this.f396519n = r105;
            GLES30.glUniform1f(this.f396514i, r105);
        L30:
            GLES30.glActiveTexture(33984);
            GLES30.glBindTexture(3553, this.f396515j);
            GLES30.glUniform1i(this.f396508c, 0);
            GLES30.glActiveTexture(33985);
            GLES30.glBindTexture(3553, this.D);
            GLES30.glUniform1i(this.f396509d, 1);
            GLES30.glBindVertexArray(this.f396516k);
            GLES30.glDrawArrays(6, 0, 4);
            GLES30.glBindVertexArray(0);
            return;
        L19:
            if (this.f396522q == this.f396523r) goto L21;
        L7:
            if (this.f396530y != 0) goto L9;
            int r106 = b("#version 300 es\nprecision mediump float;\nuniform vec2 u_resolution;\nuniform sampler2D u_background;\nout vec4 fragColor;\nvec3 blendOverlay(in vec3 base, in vec3 blend) {\n    return mix(2.0 * base * blend, 1.0 - 2.0 * (1.0 - base) * (1.0 - blend), step(0.5, base));\n}\nvec3 dim(in vec3 baseColor) {\n    vec3 overlayColor = vec3(0.0);\n    vec3 overlayResult = blendOverlay(baseColor, overlayColor);\n    float overlayAlpha = 0.3;\n    return mix(baseColor, overlayResult, overlayAlpha);\n}\nvoid main() {\n    vec2 texUV = gl_FragCoord.xy / u_resolution;\n    texUV.y = 1.0 - texUV.y;\n    vec4 baseColor = texture(u_background, texUV);\n    fragColor = vec4(dim(baseColor.rgb), baseColor.a);\n}\n");
            this.f396530y = r106;
            this.f396531z = GLES30.glGetAttribLocation(r106, "vPosition");
            a("glGetAttribLocation");
            this.A = GLES30.glGetUniformLocation(this.f396530y, "u_background");
            a("glGetAttribLocation");
            this.B = GLES30.glGetUniformLocation(this.f396530y, "u_resolution");
            a("glGetUniformLocation");
        L9:
            GLES30.glUseProgram(this.f396530y);
            if (this.C != 0) goto L12;
            int[] r107 = new int[1];
            GLES30.glGenFramebuffers(1, r107, 0);
            this.C = r107[0];
        L12:
            GLES30.glBindFramebuffer(36160, this.C);
            if (this.D != 0) goto L15;
            int[] r108 = new int[1];
            GLES30.glGenTextures(1, r108, 0);
            this.D = r108[0];
        L15:
            GLES30.glBindTexture(3553, this.D);
            GLES30.glTexImage2D(3553, 0, 6408, this.f396520o, this.f396522q, 0, 6408, 5121, null);
            GLES30.glTexParameteri(3553, 10241, 9987);
            GLES30.glTexParameteri(3553, 10240, 9729);
            GLES30.glTexParameteri(3553, 10242, 33071);
            GLES30.glTexParameteri(3553, 10243, 33071);
            GLES30.glFramebufferTexture2D(36160, 36064, 3553, this.D, 0);
            GLES30.glBindFramebuffer(36160, 0);
            GLES30.glUseProgram(0);
            GLES30.glBindFramebuffer(36160, this.C);
            GLES30.glClearColor(0.0f, 0.0f, 0.0f, 0.0f);
            GLES30.glClear(16384);
            GLES30.glUseProgram(this.f396530y);
            GLES30.glUniform2f(this.B, this.f396520o, this.f396522q);
            GLES30.glActiveTexture(33984);
            GLES30.glBindTexture(3553, this.f396515j);
            GLES30.glUniform1i(this.A, 0);
            GLES30.glEnableVertexAttribArray(this.f396531z);
            GLES30.glVertexAttribPointer(this.f396531z, 2, 5126, false, 0, this.f396528w);
            GLES30.glDrawArrays(6, 0, 4);
            GLES30.glBindTexture(3553, this.D);
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
            int r104 = GL3ShaderViewRain.f396504b;
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
            int r101 = b("#version 300 es\nprecision highp float;\nuniform vec2 u_resolution;\nuniform float u_time;\nuniform sampler2D u_background;\nuniform sampler2D u_prepass;\nuniform float u_alpha;\nuniform float u_intensity;\nuniform float u_speed;\nconst float LOD = 9.0;\nconst float RAIN_AMOUNT = 0.5;\nconst float RAIN_TURBIDITY = 2.0;\nconst float RAIN_TRAIL = 1.5;\nconst float MASK_SIZE = 0.55;\nconst float MASK_BLUR = 0.4;\nconst float MASK_RATIO = 1.75;\nout vec4 fragColor;\nvec3 random3(float seed) {\n    vec3 p3 = fract(vec3(seed) * vec3(0.1031, 0.11369, 0.13787));\n    p3 += dot(p3, p3.yzx + 19.19);\n    return fract(vec3((p3.x + p3.y) * p3.z,\n            (p3.x + p3.z) * p3.y,\n            (p3.y + p3.z) * p3.x));\n}\nfloat random(float t) {\n    return fract(sin(t * 12345.564) * 7658.76);\n}\nfloat saw(float border, float t) {\n    return smoothstep(0.0, border, t) * smoothstep(1.0, border, t);\n}\nvec2 computeDropLayer(vec2 uv, float time) {\n    vec2 originalUV = uv;\n    uv.y += time * 0.75;\n    vec2 gridBase = vec2(6.0, 1.0);\n    vec2 gridSize = gridBase * 2.0;\n    vec2 cellID = floor(uv * gridSize);\n    float columnOffset = random(cellID.x);\n    uv.y += columnOffset;\n    cellID = floor(uv * gridSize);\n    vec3 cellNoise = random3(cellID.x * 35.2 + cellID.y * 2376.1);\n    vec2 cellPos = fract(uv * gridSize) - vec2(0.5, 0.0);\n    float dropCenterX = cellNoise.x - 0.5;\n    float yFactor = originalUV.y * 20.0;\n    float wiggle = sin(yFactor + sin(yFactor));\n    dropCenterX += wiggle * (0.5 - abs(dropCenterX)) * (cellNoise.z - 0.5);\n    dropCenterX *= 0.7;\n    float timeOffset = fract(time + cellNoise.z);\n    float dropCenterY = (saw(0.85, timeOffset) - 0.5) * 0.9 + 0.5;\n    vec2 dropCenter = vec2(dropCenterX, dropCenterY);\n    float distToDrop = length((cellPos - dropCenter) * vec2(1.0, 6.0));\n    float mainDrop = smoothstep(0.4, 0.0, distToDrop);\n    float rFactor = sqrt(smoothstep(1.0, dropCenterY, cellPos.y));\n    float deltaX = abs(cellPos.x - dropCenterX);\n    float trailIntensity = smoothstep(0.23 * rFactor, 0.15 * rFactor * rFactor, deltaX);\n    float frontTrail = smoothstep(-0.02, 0.02, cellPos.y - dropCenterY);\n    trailIntensity *= frontTrail * rFactor * rFactor;\n    float trail2 = smoothstep(0.2 * rFactor, 0.0, deltaX);\n    float droplets = max(0.0, (sin(originalUV.y * (1.0 - originalUV.y) * 120.0) - cellPos.y))\n            * trail2 * frontTrail * cellNoise.z;\n    float adjustedY = fract(originalUV.y * 10.0) + (cellPos.y - 0.5);\n    float dropletsDist = length(cellPos - vec2(dropCenterX, adjustedY));\n    droplets = smoothstep(0.3, 0.0, dropletsDist);\n    float dropValue = mainDrop + droplets * rFactor * frontTrail;\n    return vec2(dropValue, trailIntensity);\n}\nfloat computeStaticDrops(vec2 uv, float time) {\n    uv *= 40.0;\n    vec2 cellID = floor(uv);\n    uv = fract(uv) - 0.5;\n    vec3 cellNoise = random3(cellID.x * 107.45 + cellID.y * 3543.654);\n    vec2 targetPos = (cellNoise.xy - 0.5) * 0.7;\n    float distanceToTarget = length(uv - targetPos);\n    float fade = saw(0.025, fract(time + cellNoise.z));\n    float dropsVal = smoothstep(0.3, 0.0, distanceToTarget)\n            * fract(cellNoise.z * 10.0) * fade;\n    return dropsVal;\n}\nvec2 computeDrops(vec2 uv, float time, float staticLevel, float layerOneLevel, float layerTwoLevel) {\n    float dropsStatic = computeStaticDrops(uv, time) * staticLevel;\n    vec2 dropLayerA = computeDropLayer(uv, time) * layerOneLevel;\n    vec2 dropLayerB = computeDropLayer(uv * 1.85, time) * layerTwoLevel;\n    float combinedDrops = dropsStatic + dropLayerA.x + dropLayerB.x;\n    combinedDrops = smoothstep(0.3, 1.0, combinedDrops);\n    return vec2(combinedDrops, max(dropLayerA.y * staticLevel, dropLayerB.y * layerOneLevel));\n}\nvoid main() {\n    vec2 uv = (gl_FragCoord.xy - 0.5 * u_resolution) / u_resolution.y;\n    float t = u_time * u_speed;\n    // 计算各层级系数\n    float staticLevel = smoothstep(-0.5, 1.0, RAIN_AMOUNT * u_intensity) * 2.0;\n    float layerOneLevel = smoothstep(0.25, 0.75, RAIN_AMOUNT * u_intensity);\n    float layerTwoLevel = smoothstep(0.0, 0.5, RAIN_AMOUNT * u_intensity);\n    // 计算雨滴效果\n    vec2 dropEffect = computeDrops(uv, t, staticLevel, layerOneLevel, layerTwoLevel);\n    // 根据屏幕坐标生成遮罩（一般用于限定雨滴的区域）\n    vec2 maskUV = (gl_FragCoord.xy - 0.5 * u_resolution) / u_resolution.y;\n    maskUV.x *= MASK_RATIO;\n    float mask = 1.0 - smoothstep(MASK_SIZE - MASK_BLUR, MASK_SIZE, length(maskUV));\n    vec2 maskedDropEffect = dropEffect * mask;\n    // 计算法线用于扰动预处理贴图\n    vec2 offset = vec2(0.001, 0.0);\n    float dropRight = computeDrops(uv + offset, t, staticLevel, layerOneLevel, layerTwoLevel).x * mask;\n    float dropDown  = computeDrops(uv + offset.yx, t, staticLevel, layerOneLevel, layerTwoLevel).x * mask;\n    vec2 normal = vec2(dropRight - maskedDropEffect.x,\n            dropDown - maskedDropEffect.x);\n    // 焦点根据拖尾效果混合两个采样 LOD\n    float focus = mix(LOD - maskedDropEffect.y * RAIN_TRAIL, RAIN_TURBIDITY, smoothstep(0.1, 0.2, maskedDropEffect.x));\n    vec2 texUV = gl_FragCoord.xy / u_resolution;\n    vec3 baseColor = texture(u_background, texUV).rgb;\n    vec3 effectColor = textureLod(u_prepass, texUV + normal, focus).rgb;\n    vec3 finalColor = mix(baseColor, effectColor, u_alpha);\n    fragColor = vec4(finalColor, 1.0);\n}\n");
            this.f396506a = r101;
            if (r101 != 0) goto L5;
            return;
        L5:
            this.f396507b = GLES30.glGetAttribLocation(r101, "vPosition");
            a("glGetAttribLocation");
            this.f396508c = GLES30.glGetUniformLocation(this.f396506a, "u_background");
            a("glGetAttribLocation");
            this.f396509d = GLES30.glGetUniformLocation(this.f396506a, "u_prepass");
            a("glGetAttribLocation");
            this.f396510e = GLES30.glGetUniformLocation(this.f396506a, "u_resolution");
            a("glGetUniformLocation");
            this.f396511f = GLES30.glGetUniformLocation(this.f396506a, "u_time");
            a("glGetUniformLocation");
            this.f396512g = GLES30.glGetUniformLocation(this.f396506a, "u_alpha");
            a("glGetUniformLocation");
            this.f396513h = GLES30.glGetUniformLocation(this.f396506a, "u_intensity");
            a("glGetUniformLocation");
            this.f396514i = GLES30.glGetUniformLocation(this.f396506a, "u_speed");
            a("glGetUniformLocation");
            GLES30.glUseProgram(this.f396506a);
            Bitmap r102 = this.f396529x;
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
            this.f396515j = r103[0];
            int[] r105 = new int[1];
            GLES30.glGenVertexArrays(1, r105, 0);
            int r106 = r105[0];
            this.f396516k = r106;
            GLES30.glBindVertexArray(r106);
            int[] r107 = new int[1];
            GLES30.glGenBuffers(1, r107, 0);
            GLES30.glBindBuffer(34962, r107[0]);
            GLES30.glBufferData(34962, this.f396527v.length * 4, this.f396528w, 35044);
            GLES30.glEnableVertexAttribArray(this.f396507b);
            GLES30.glVertexAttribPointer(this.f396507b, 2, 5126, false, 0, 0);
            GLES30.glBindBuffer(34962, 0);
            GLES30.glBindVertexArray(0);
            GLES30.glUseProgram(0);
        }

        @Override // android.opengl.GLSurfaceView.Renderer
        public final void onSurfaceChanged(GL10 r100, int r101, int r102) {
            this.f396520o = r101;
            this.f396522q = r102;
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

    public GL3ShaderViewRain(Context r100) {
        super(r100, null);
    }

    @Override // android.view.Choreographer.FrameCallback
    public final void doFrame(long r100) {
        requestRender();
        Choreographer.getInstance().postFrameCallback(this);
    }

    public void setBackgroundImage(Bitmap r100) {
        this.f396505a.f396529x = r100;
    }

    public void setShaderAlpha(float r100) {
        this.f396505a.f396524s.f472896a = r100;
    }

    public void setShaderIntensity(float r100) {
        this.f396505a.f396525t.f472896a = r100;
    }

    public void setShaderSpeed(float r100) {
        this.f396505a.f396526u.f472896a = r100;
    }

    public GL3ShaderViewRain(Context r100, AttributeSet r101) {
        super(r100, r101);
        getHolder().setFormat(1);
        setZOrderOnTop(true);
        setEGLContextClientVersion(3);
        setEGLConfigChooser(8, 8, 8, 0, 0, 0);
        a r102 = new a(getContext());
        this.f396505a = r102;
        setRenderer(r102);
        setRenderMode(0);
        setPreserveEGLContextOnPause(true);
    }
}
