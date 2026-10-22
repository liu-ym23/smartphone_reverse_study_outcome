package d19;

import android.opengl.GLES20;
import com.larus.utils.logger.FLogger;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;

/* JADX INFO: loaded from: classes27.dex */
public final class d implements c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f466448a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final FloatBuffer f466449b;

    public static final class a {
    }

    static {
    }

    @Override // d19.c
    public final void a() {
        GLES20.glClearColor(0.0f, 0.0f, 0.0f, 0.0f);
        int r100 = c(35633, "\n        attribute vec4 aPosition;\n        varying vec2 vUv;\n        void main() {\n            gl_Position = aPosition;\n            vUv = aPosition.xy * 0.5 + 0.5;\n        }\n    ");
        int r101 = c(35632, "\n        precision highp float;\n        \n        uniform vec2 uResolution;\n        uniform float uTime;\n        uniform float uAlpha;\n        uniform float uDensity;\n        uniform float uAudioAmplitude;\n        uniform int uDarkMode;\n        \n        varying vec2 vUv;\n        \n        \n        const float PI = 3.1415926535897932384626;\n        \n        // Light Mode\n        const vec3 COLOR_L_0   = vec3(0.953, 0.675, 0.800); // 0%   F3ACCC\n        const vec3 COLOR_L_18  = vec3(0.659, 0.741, 0.910); // 18%  A8BDE8\n        const vec3 COLOR_L_40  = vec3(0.945, 0.847, 0.780); // 40%  F1D8C7\n        const vec3 COLOR_L_60  = vec3(0.957, 0.741, 0.839); // 60%  F4BDD6\n        const vec3 COLOR_L_80  = vec3(0.965, 0.871, 0.839); // 80%  F6DED6\n        const vec3 COLOR_L_100 = vec3(0.953, 0.675, 0.800); // 100% F3ACCC\n\n        // Dark Mode\n        const vec3 COLOR_D_0   = vec3(0.486, 0.157, 0.310); // 0%   7C284F\n        const vec3 COLOR_D_18  = vec3(0.153, 0.267, 0.494); // 18%  27447E\n        const vec3 COLOR_D_40  = vec3(0.455, 0.239, 0.118); // 40%  743D1E\n        const vec3 COLOR_D_60  = vec3(0.443, 0.137, 0.278); // 60%  712347\n        const vec3 COLOR_D_80  = vec3(0.455, 0.243, 0.114); // 80%  743E1D\n        const vec3 COLOR_D_100 = vec3(0.486, 0.157, 0.310); // 100% 7C284F\n        \n        const float MARGIN_MIN = 15.0;\n        const float CORNER_RADIUS = 40.0;\n        const float FEATHER_SHARPNESS = 0.7;\n        \n        float sdRoundedBox(vec2 p, vec2 b, float r) {\n            vec2 q = abs(p) - b + r;\n            return min(max(q.x, q.y), 0.0) + length(max(q, 0.0)) - r;\n        }\n        \n        vec3 getGradientColor(float t) {\n            vec3 c0, c18, c40, c60, c80, c100;\n            if (uDarkMode == 1) {\n                c0 = COLOR_D_0; \n                c18 = COLOR_D_18; \n                c40 = COLOR_D_40;\n                c60 = COLOR_D_60; \n                c80 = COLOR_D_80; \n                c100 = COLOR_D_100;\n            } else {\n                c0 = COLOR_L_0; \n                c18 = COLOR_L_18; \n                c40 = COLOR_L_40;\n                c60 = COLOR_L_60; \n                c80 = COLOR_L_80; \n                c100 = COLOR_L_100;\n            }\n\n            if (t < 0.18) return mix(c0, c18, t / 0.18);\n            if (t < 0.40) return mix(c18, c40, (t - 0.18) / 0.22);\n            if (t < 0.60) return mix(c40, c60, (t - 0.40) / 0.20);\n            if (t < 0.80) return mix(c60, c80, (t - 0.60) / 0.20);\n            return mix(c80, c100, (t - 0.80) / 0.20);\n        }\n        \n        float calculateNormalizedAngle(vec2 uv) {\n            float angle = atan(uv.y, uv.x);\n            float normalized = angle / (2.0 * PI) + 0.5;\n            return fract(normalized - 0.25);\n        }\n        \n        vec3 calculateRotatingColor(float angle01, float time) {\n            float timePeriod = 12.0;\n            float timeOffset = mod(time, timePeriod) / timePeriod;\n            float t = fract(angle01 - timeOffset);\n            return getGradientColor(t);\n        }\n        \n        float calculateRippledSDF(vec2 uv, vec2 center, float radius, float rippleAmp, float time) {\n            float baseDist = sdRoundedBox(uv, center, radius);\n            float angle = atan(uv.y, uv.x);\n            float ripple = abs(sin(angle * 0.5 + time * 4.0)) * rippleAmp;\n            return baseDist + ripple;\n        }\n        \n        float calculateAlphaMask1(float maskStart, float dist) {\n            return smoothstep(maskStart, 0.0, dist);\n        }\n        \n        float calculateAlphaMaskWithSharpness(float maskStart, float dist, float sharpness) {\n            float t = smoothstep(maskStart, 0.0, dist);\n            return pow(t, sharpness);\n        }\n    \n        \n        void main() {\n            \n            vec2 pixelCoord = gl_FragCoord.xy;\n            pixelCoord.y = uResolution.y - pixelCoord.y;\n        \n            vec2 center = uResolution * 0.5;\n            vec2 uv = pixelCoord - center;\n            float density = max(uDensity, 1.0);\n        \n            float angle01 = calculateNormalizedAngle(uv);\n            float currentMargin = MARGIN_MIN * density;\n        \n            float dist = sdRoundedBox(uv, center, CORNER_RADIUS * density);\n            float alphaMask = calculateAlphaMaskWithSharpness(-currentMargin, dist, FEATHER_SHARPNESS);\n        \n            vec3 color = calculateRotatingColor(angle01, uTime);\n        \n            float finalAlpha = uAlpha * alphaMask;\n    \n            gl_FragColor = vec4(color * finalAlpha, finalAlpha);\n        }\n    ");
        int r102 = GLES20.glCreateProgram();
        GLES20.glAttachShader(r102, r100);
        GLES20.glAttachShader(r102, r101);
        GLES20.glLinkProgram(r102);
        int[] r103 = new int[1];
        GLES20.glGetProgramiv(r102, 35714, r103, 0);
        if (r103[0] != 0) goto L5;
        FLogger.f375446a.e("EdgeRenderStrategy.EdgeRenderStrategyES2", "ES2 Program link failed: " + GLES20.glGetProgramInfoLog(r102));
        GLES20.glDeleteProgram(r102);
        r102 = 0;
    L5:
        this.f466448a = r102;
    }

    public d() {
        FloatBuffer r100 = ByteBuffer.allocateDirect(80).order(ByteOrder.nativeOrder()).asFloatBuffer();
        r100.put(new float[]{-1.0f, -1.0f, 0.0f, 0.0f, 0.0f, 1.0f, -1.0f, 0.0f, 1.0f, 0.0f, -1.0f, 1.0f, 0.0f, 0.0f, 1.0f, 1.0f, 1.0f, 0.0f, 1.0f, 1.0f});
        r100.position(0);
        this.f466449b = r100;
    }

    public static final int c(int r100, String r101) {
        int r102 = GLES20.glCreateShader(r100);
        GLES20.glShaderSource(r102, r101);
        GLES20.glCompileShader(r102);
        int[] r103 = new int[1];
        GLES20.glGetShaderiv(r102, 35713, r103, 0);
        if (r103[0] != 0) goto L6;
        FLogger.f375446a.e("EdgeRenderStrategy.EdgeRenderStrategyES2", "ES2 Shader compile failed: " + GLES20.glGetShaderInfoLog(r102));
        GLES20.glDeleteShader(r102);
        return 0;
    L6:
        return r102;
    }

    public final void d(String r100, float r101) {
        int r102 = GLES20.glGetUniformLocation(this.f466448a, r100);
        if (r102 == (-1)) goto L6;
        GLES20.glUniform1f(r102, r101);
        return;
    }

    @Override // d19.c
    public final void onSurfaceChanged(int r100, int r101) {
        GLES20.glViewport(0, 0, r100, r101);
    }

    @Override // d19.c
    public final void b(float r110, float r111, float r112, float r113, int r114, float r115, float r116) {
        GLES20.glClear(16384);
        if (r111 > 0.001f) goto L5;
        return;
    L5:
        GLES20.glUseProgram(this.f466448a);
        int r100 = GLES20.glGetAttribLocation(this.f466448a, "aPosition");
        this.f466449b.position(0);
        GLES20.glVertexAttribPointer(r100, 3, 5126, false, 20, this.f466449b);
        GLES20.glEnableVertexAttribArray(r100);
        d("uTime", r110);
        int r101 = GLES20.glGetUniformLocation(this.f466448a, "uResolution");
        if (r101 == (-1)) goto L8;
        GLES20.glUniform2f(r101, r115, r116);
    L8:
        d("uDensity", r112);
        d("uAlpha", r111);
        d("uAudioAmplitude", r113);
        int r102 = GLES20.glGetUniformLocation(this.f466448a, "uDarkMode");
        if (r102 == (-1)) goto L11;
        GLES20.glUniform1i(r102, r114);
    L11:
        GLES20.glDrawArrays(5, 0, 4);
        GLES20.glDisableVertexAttribArray(r100);
    }
}
