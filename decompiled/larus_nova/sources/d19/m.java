package d19;

import android.graphics.RuntimeShader;

/* JADX INFO: loaded from: classes27.dex */
public final class m extends RuntimeShader {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public float f466470a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public float f466471b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public float f466472c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public float f466473d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f466474e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public float f466475f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public float f466476g;

    public static final class a {
    }

    static {
    }

    public m() {
        super("\n        // [AGSL 基础语法说明]\n        // uniform: 从外部 (Kotlin代码) 传递进来的只读变量，在每一帧中保持不变\n        // vec2/vec3/vec4: 向量类型，分别包含 2/3/4 个浮点数\n\n        // --- 1. Uniforms & Constants (全局变量与常量) ---\n        uniform vec2 uResolution; // 画布分辨率 (宽, 高)\n        uniform float uTime;      // 动画运行时间 (秒)\n        uniform float uAlpha;     // 整体透明度\n        uniform float uDensity;   // 屏幕密度 (density)\n        uniform float uAudioAmplitude; // 音频振幅\n        uniform int uDarkMode; // 是否暗色模式 (0=false, 1=true)\n        \n        const float PI = 3.1415926535897932384626;\n        \n        // --- 2. Color Palette (颜色配置) ---\n        // Light Mode\n        const vec3 COLOR_L_0   = vec3(0.953, 0.675, 0.800); // 0%   F3ACCC\n        const vec3 COLOR_L_18  = vec3(0.659, 0.741, 0.910); // 18%  A8BDE8\n        const vec3 COLOR_L_40  = vec3(0.945, 0.847, 0.780); // 40%  F1D8C7\n        const vec3 COLOR_L_60  = vec3(0.957, 0.741, 0.839); // 60%  F4BDD6\n        const vec3 COLOR_L_80  = vec3(0.965, 0.871, 0.839); // 80%  F6DED6\n        const vec3 COLOR_L_100 = vec3(0.953, 0.675, 0.800); // 100% F3ACCC\n\n        // Dark Mode\n        const vec3 COLOR_D_0   = vec3(0.486, 0.157, 0.310); // 0%   7C284F\n        const vec3 COLOR_D_18  = vec3(0.153, 0.267, 0.494); // 18%  27447E\n        const vec3 COLOR_D_40  = vec3(0.455, 0.239, 0.118); // 40%  743D1E\n        const vec3 COLOR_D_60  = vec3(0.443, 0.137, 0.278); // 60%  712347\n        const vec3 COLOR_D_80  = vec3(0.455, 0.243, 0.114); // 80%  743E1D\n        const vec3 COLOR_D_100 = vec3(0.486, 0.157, 0.310); // 100% 7C284F\n\n        // --- 3. Animation Config (动画参数) ---\n        const float MARGIN = 15.0;\n        const float CORNER_RADIUS = 60.0; \n        const float FEATHER_SHARPNESS = 0.7;\n\n\n        // --- 4. Helper Functions (工具函数) ---\n\n        /**\n         * 计算圆角矩形的 SDF (Signed Distance Field)\n         * \n         * @param p 像素坐标 (相对于中心)\n         * @param b 矩形半宽高\n         * @param r 圆角半径\n         * @return 点距离圆角矩形的最短距离 \n         */\n        float sdRoundedBox(vec2 p, vec2 b, float r) {\n            // abs(p)先把p映射到第一象限。\n            // 计算p到矩形b边缘的距离\n            vec2 q = abs(p) - b + r;\n            // 先计算点到矩形的最短距离，再减去圆角半径，就是点到圆角矩形的最短距离\n            // 实际逻辑就是: \n//            if (q.x > 0 && q.y > 0) { // 这里处理角部的情况\n//                return length(q) - r  // length()是返回向量的长度，这里就是点p到b的距离\n//            } else { \n//                return max(q.x, q.y) - r // 这是在计算点p到矩形b的最短距离，减去圆角半径r\n//            }\n            return min(max(q.x, q.y), 0.0) + length(max(q, 0.0)) - r;\n        }\n        \n        /**\n         * 获取当前进度的渐变颜色 (线性插值)\n         */\n        vec3 getGradientColor(float t) {\n            vec3 c0, c18, c40, c60, c80, c100;\n            if (uDarkMode == 1) {\n                c0 = COLOR_D_0;\n                c18 = COLOR_D_18;\n                c40 = COLOR_D_40;\n                c60 = COLOR_D_60;\n                c80 = COLOR_D_80;\n                c100 = COLOR_D_100;\n            } else {\n                c0 = COLOR_L_0;\n                c18 = COLOR_L_18;\n                c40 = COLOR_L_40;\n                c60 = COLOR_L_60;\n                c80 = COLOR_L_80;\n                c100 = COLOR_L_100;\n            }\n\n            if (t < 0.18) return mix(c0, c18, t / 0.18);\n            if (t < 0.40) return mix(c18, c40, (t - 0.18) / 0.22);\n            if (t < 0.60) return mix(c40, c60, (t - 0.40) / 0.20);\n            if (t < 0.80) return mix(c60, c80, (t - 0.60) / 0.20);\n            return mix(c80, c100, (t - 0.80) / 0.20);\n        }\n\n        /**\n         * 计算归一化角度，将屏幕上的像素坐标转换为一个 从 12 点钟开始顺时针增长的进度值 (0.0 -> 1.0)\n         * 返回 [0.0, 1.0], 其中 0.0 对应 12点钟方向\n         */\n        float calculateNormalizedAngle(vec2 uv) {\n            // 1. 计算原始弧度角\n            // atan(y, x) 返回点 (x, y) 与 X轴正方向的夹角，范围是 [-PI, PI]\n            // 在屏幕坐标系中：\n            // - 0 弧度 = 3点钟方向 (X轴正向)\n            // - PI/2 = 6点钟方向 (Y轴向下)\n            // - -PI/2 = 12点钟方向 (Y轴向上)\n            float angle = atan(uv.y, uv.x); // [-PI, PI]\n            // 2. 映射到 [0, 1] 区间\n            // angle / (2.0 * PI) -> 范围变为 [-0.5, 0.5]\n            // + 0.5             -> 范围变为 [0.0, 1.0]\n            // 此时：\n            // - 0.5  = 3点钟 (原0)\n            // - 0.75 = 6点钟 (原PI/2)\n            // - 0.25 = 12点钟 (原-PI/2)\n            float normalized = angle / (2.0 * PI) + 0.5; // [0, 1]\n            // 3. 旋转坐标系 (对齐 12 点钟)\n            // 我们希望 12点钟方向的值为 0.0。\n            // 当前 12点钟是 0.25，所以减去 0.25。\n            // fract(...) 取小数部分，处理减法产生的负数，确保结果在 [0.0, 1.0] 循环。\n            // 结果：\n            // - 12点钟: 0.25 - 0.25 = 0.0\n            // - 3点钟:  0.50 - 0.25 = 0.25\n            // - 6点钟:  0.75 - 0.25 = 0.50\n            // - 9点钟:  0.00 - 0.25 = -0.25 -> fract -> 0.75\n            return fract(normalized - 0.25); // Rotate so 0 is Top\n        }\n\n        /**\n         * 计算随时间旋转的颜色\n         */\n        vec3 calculateRotatingColor(float angle01, float time) {\n            float timePeriod = 12.0;\n            float timeOffset = mod(time, timePeriod) / timePeriod;\n            float t = fract(angle01 - timeOffset);\n            return getGradientColor(t);\n        }\n        \n        /**\n         * 计算 Alpha 遮罩，带羽化锐度控制\n         * \n         * @param maskStart 遮罩开始的位置 (通常是 -currentMargin)\n         * @param dist 当前像素距离边缘的距离 (0是边缘，负数是内部)\n         * @param sharpness 羽化锐度 [0.0 - 1.0+]\n         *                  - 1.0: 线性渐变 (默认 smoothstep 行为)\n         *                  - > 1.0: 更锐利，边缘变化更快 (如 2.0, 4.0)\n         *                  - < 1.0: 更柔和，边缘变化更慢 (如 0.5)\n         */\n        float calculateAlphaMaskWithSharpness(float maskStart, float dist, float sharpness) {\n            // 1. 计算基础进度 [0.0 - 1.0]\n            // maskStart (内部) -> 0.0\n            // 0.0 (边缘)       -> 1.0\n            float t = smoothstep(maskStart, 0.0, dist);\n            \n            // 2. 应用锐度控制 (Power Function)\n            // pow(t, sharpness) 改变曲线形状\n            // 如果 sharpness > 1: 曲线下凹，低值区域被压低，高值区域陡峭 -> 看起来更锐利，因为大部分区域透明度低，只在边缘迅速变不透明\n            // 如果 sharpness < 1: 曲线上凸，低值区域被拉高 -> 看起来更柔和，因为很早就开始变得不透明了\n            // 注意：这里 t 代表 Alpha，所以：\n            // - pow(t, 3.0) 会让 Alpha 在内部长时间保持低值，直到靠近边缘才迅速升到 1 -> 视觉上边缘很\"硬\"或\"薄\"\n            // - pow(t, 0.5) 会让 Alpha 迅速升高，大部分区域都比较不透明 -> 视觉上边缘很\"软\"或\"厚\"\n            return pow(t, sharpness);\n        }\n\n        // --- 5. Main Shader Function ---\n        vec4 main(vec2 pixelCoord) {\n            // [准备] 坐标系处理\n            vec2 center = uResolution * 0.5;\n            vec2 uv = pixelCoord - center; // 移动原点到中心\n            float density = max(uDensity, 1.0);\n\n            // [步骤1] 计算基础状态参数\n            float angle01 = calculateNormalizedAngle(uv);\n            float currentMargin = MARGIN * density;\n\n            // [步骤3] 计算几何与遮罩\n            // 计算带波纹的 SDF 距离\n            float dist = sdRoundedBox(uv, center, CORNER_RADIUS * density);\n            \n            // 计算遮罩 (从内部 maskStart 处开始向边缘渐变)\n//         屏幕中心                           屏幕边缘\n//            |                                 |\n//      ......|-------------------|-------------|......\n//           -width               0             0      (dist值)\n//            |                   |             |\n//         完全透明区域           渐变区          边缘\n//         (Alpha=0)          (0<Alpha<1)     (Alpha=1)\n//            |                   |             |\n//            |<--- 透明 --------->|<--指数衰减-->|\n            \n            // 羽化锐度控制 (可作为 Uniform 传入，这里暂时写死测试)\n            // 1.0 = 标准线性平滑\n            // 3.0 = 锐利 (边缘渐变区更窄)\n            // 0.5 = 柔和 (边缘渐变区更宽)\n            float alphaMask = calculateAlphaMaskWithSharpness(-currentMargin, dist, FEATHER_SHARPNESS);\n\n            // [步骤4] 生成颜色\n            vec3 color = calculateRotatingColor(angle01, uTime);\n\n            // [输出]\n            // 使用 Premultiplied Alpha (预乘 Alpha) 格式输出\n            // 避免在 Alpha 接近 0 时出现颜色残留或发白的问题\n            float finalAlpha = uAlpha * alphaMask;\n            return vec4(color * finalAlpha, finalAlpha);\n        }\n        ");
        this.f466470a = -1.0f;
        this.f466471b = -1.0f;
        this.f466472c = -1.0f;
        this.f466473d = -1.0f;
        this.f466474e = -1;
        this.f466475f = -1.0f;
        this.f466476g = -1.0f;
    }

    public final void a(float r100) {
        if (this.f466471b != r100) goto L5;
        boolean r101 = true;
    L6:
        if (r101 == true) goto L9;
        setFloatUniform("uAlpha", r100);
        this.f466471b = r100;
        return;
    L9:
        return;
    L5:
        r101 = false;
        goto L6
    }
}
