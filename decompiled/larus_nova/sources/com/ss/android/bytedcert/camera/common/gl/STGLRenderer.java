package com.ss.android.bytedcert.camera.common.gl;

import android.opengl.GLES20;
import android.opengl.Matrix;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.ss.android.cert.manager.utils.CertLog;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.util.ArrayList;
import java.util.HashMap;

/* JADX INFO: loaded from: classes34.dex */
public final class STGLRenderer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f407270a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final FloatBuffer f407271b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final FloatBuffer f407272c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public FloatBuffer f407273d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public FloatBuffer f407274e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f407275f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final float[] f407276g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public float f407277h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f407278i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final ArrayList<HashMap<String, Integer>> f407279j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f407280k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f407281l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int[] f407282m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public int[] f407283n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final float[] f407284o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final float[] f407285p;

    public final void e() {
        int[] r100 = this.f407283n;
        if (r100 == null) goto L5;
        GLES20.glDeleteTextures(2, r100, 0);
        this.f407283n = null;
    L5:
        int[] r101 = this.f407282m;
        if (r101 == null) goto L9;
        GLES20.glDeleteFramebuffers(2, r101, 0);
        this.f407282m = null;
        return;
    }

    public final void j() {
        if (this.f407275f == 0) goto L5;
        return;
    L5:
        this.f407277h = Math.max(0.0f, Math.min(0.05f, 0.5f));
    }

    public STGLRenderer() {
        this.f407275f = -1;
        this.f407276g = new float[]{0.0f, 0.0f, 1.0f, 1.0f};
        this.f407277h = 0.0f;
        final int r100 = 2;
        this.f407279j = new AnonymousClass1(this, r100);
        this.f407284o = new float[16];
        this.f407285p = new float[16];
        FloatBuffer r101 = ByteBuffer.allocateDirect(32).order(ByteOrder.nativeOrder()).asFloatBuffer();
        this.f407271b = r101;
        r101.put(e.f407302e).position(0);
        FloatBuffer r102 = ByteBuffer.allocateDirect(32).order(ByteOrder.nativeOrder()).asFloatBuffer();
        this.f407272c = r102;
        r102.put(e.f407298a).position(0);
        ByteBuffer.allocateDirect(32).order(ByteOrder.nativeOrder()).asFloatBuffer().put(e.b(0, false, true)).position(0);
    }

    public static void g(String r100, HashMap r101) {
        if (((Integer) r101.get("program")).intValue() != 0) goto L16;
        int[] r102 = new int[1];
        int r103 = d.b("uniform mat4 uMVPMatrix;\nuniform mat4 uSTMatrix;\nattribute vec4 position;\nattribute vec4 inputTextureCoordinate;\n\nvarying vec2 textureCoordinate;\n\nvoid main()\n{\n\tgl_Position = uMVPMatrix * position;\n\ttextureCoordinate = (uSTMatrix*inputTextureCoordinate).xy;\n}", 35633);
        int r104 = 0;
        if (r103 != 0) goto L7;
        CertLog.d("Load Program", "Vertex Shader Failed");
    L14:
        r101.put("program", Integer.valueOf(r104));
        r101.put("position", Integer.valueOf(GLES20.glGetAttribLocation(r104, "position")));
        r101.put("inputImageTexture", Integer.valueOf(GLES20.glGetUniformLocation(r104, "inputImageTexture")));
        r101.put("inputTextureCoordinate", Integer.valueOf(GLES20.glGetAttribLocation(r104, "inputTextureCoordinate")));
        r101.put("uMVPMatrix", Integer.valueOf(GLES20.glGetUniformLocation(r104, "uMVPMatrix")));
        r101.put("uSTMatrix", Integer.valueOf(GLES20.glGetUniformLocation(r104, "uSTMatrix")));
        r101.put("intensity", Integer.valueOf(GLES20.glGetUniformLocation(r104, "intensity")));
        return;
    L7:
        int r105 = d.b(r100, 35632);
        if (r105 != 0) goto L10;
        CertLog.d("Load Program", "Fragment Shader Failed");
        goto L14
    L10:
        int r106 = GLES20.glCreateProgram();
        GLES20.glAttachShader(r106, r103);
        GLES20.glAttachShader(r106, r105);
        GLES20.glLinkProgram(r106);
        GLES20.glGetProgramiv(r106, 35714, r102, 0);
        if (r102[0] > 0) goto L13;
        CertLog.d("Load Program", "Linking Failed");
        goto L14
    L13:
        GLES20.glDeleteShader(r103);
        GLES20.glDeleteShader(r105);
        r104 = r106;
        goto L14
    }

    public final void a(int r100, boolean r101) {
        float[] r102 = e.b(r100, true, r101);
        if (this.f407273d != null) goto L5;
        this.f407273d = ByteBuffer.allocateDirect(r102.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
    L5:
        this.f407273d.clear();
        this.f407273d.put(r102).position(0);
    }

    public final void h(int r110, int r111) {
        if (this.f407278i == true) goto L5;
        return;
    L5:
        if (this.f407274e == null) goto L13;
        GLES20.glUseProgram(((Integer) ((HashMap) ListProtector.get(this.f407279j, 1)).get("program")).intValue());
        this.f407274e.position(0);
        int r100 = ((Integer) ((HashMap) ListProtector.get(this.f407279j, 1)).get("position")).intValue();
        GLES20.glVertexAttribPointer(r100, 2, 5126, false, 0, this.f407274e);
        GLES20.glEnableVertexAttribArray(r100);
        this.f407272c.position(0);
        int r101 = ((Integer) ((HashMap) ListProtector.get(this.f407279j, 1)).get("inputTextureCoordinate")).intValue();
        GLES20.glVertexAttribPointer(r101, 2, 5126, false, 0, this.f407272c);
        GLES20.glEnableVertexAttribArray(r101);
        if (r110 == (-1)) goto L10;
        GLES20.glActiveTexture(33984);
        GLES20.glBindTexture(3553, r110);
        GLES20.glUniform1i(((Integer) ((HashMap) ListProtector.get(this.f407279j, 1)).get("inputImageTexture")).intValue(), 0);
    L10:
        Matrix.setIdentityM(this.f407285p, 0);
        GLES20.glUniformMatrix4fv(((Integer) ((HashMap) ListProtector.get(this.f407279j, 1)).get("uSTMatrix")).intValue(), 1, false, this.f407285p, 0);
        int r102 = ((Integer) ((HashMap) ListProtector.get(this.f407279j, 1)).get("uMVPMatrix")).intValue();
        Matrix.setIdentityM(this.f407284o, 0);
        GLES20.glUniformMatrix4fv(r102, 1, false, this.f407284o, 0);
        GlUtil.a("glUniformMatrix4fv");
        GLES20.glUniform1f(((Integer) ((HashMap) ListProtector.get(this.f407279j, 1)).get("intensity")).intValue(), r111 / 100.0f);
        GLES20.glUniform4fv(GLES20.glGetUniformLocation(((Integer) ((HashMap) ListProtector.get(this.f407279j, 1)).get("program")).intValue(), "cropRegion"), 1, this.f407276g, 0);
        GLES20.glUniform1i(GLES20.glGetUniformLocation(((Integer) ((HashMap) ListProtector.get(this.f407279j, 1)).get("program")).intValue(), "cropShape"), this.f407275f);
        GLES20.glUniform1f(GLES20.glGetUniformLocation(((Integer) ((HashMap) ListProtector.get(this.f407279j, 1)).get("program")).intValue(), "cornerRadius"), this.f407277h);
        GLES20.glUniform1f(GLES20.glGetUniformLocation(((Integer) ((HashMap) ListProtector.get(this.f407279j, 1)).get("program")).intValue(), "aspectRatio"), this.f407280k / this.f407281l);
        GLES20.glClearColor(0.0f, 0.0f, 0.0f, 0.0f);
        GLES20.glClear(16384);
        GLES20.glEnable(3042);
        GLES20.glBlendFunc(770, 771);
        GLES20.glDrawArrays(5, 0, 4);
        GLES20.glDisableVertexAttribArray(r100);
        GLES20.glDisableVertexAttribArray(r101);
        GLES20.glActiveTexture(33984);
        GLES20.glBindTexture(3553, 0);
        GLES20.glDisable(3042);
        return;
    }

    public final int i(int r210, ByteBuffer r211) {
        if (this.f407282m != null) goto L5;
        return -2;
    L5:
        if (this.f407271b != null) goto L7;
        return -2;
    L7:
        if (this.f407273d != null) goto L9;
        return -2;
    L9:
        if (this.f407278i == false) goto L30;
        GLES20.glUseProgram(((Integer) ((HashMap) ListProtector.get(this.f407279j, 0)).get("program")).intValue());
        GlUtil.a("glUseProgram");     // Catch: RuntimeException -> L21
        this.f407271b.position(0);
        int r100 = ((Integer) ((HashMap) ListProtector.get(this.f407279j, 0)).get("position")).intValue();
        GLES20.glVertexAttribPointer(r100, 2, 5126, false, 0, this.f407271b);
        GLES20.glEnableVertexAttribArray(r100);
        this.f407273d.position(0);
        int r110 = ((Integer) ((HashMap) ListProtector.get(this.f407279j, 0)).get("inputTextureCoordinate")).intValue();
        GLES20.glVertexAttribPointer(r110, 2, 5126, false, 0, this.f407273d);
        GLES20.glEnableVertexAttribArray(r110);
        int r101 = ((Integer) ((HashMap) ListProtector.get(this.f407279j, 0)).get("uSTMatrix")).intValue();
        Matrix.setIdentityM(this.f407285p, 0);
        GLES20.glUniformMatrix4fv(r101, 1, false, this.f407285p, 0);
        if (r210 == (-1)) goto L16;
        GLES20.glActiveTexture(33984);
        GLES20.glBindTexture(36197, r210);
        GLES20.glUniform1i(((Integer) ((HashMap) ListProtector.get(this.f407279j, 0)).get("inputImageTexture")).intValue(), 0);
    L16:
        GLES20.glBindFramebuffer(36160, this.f407282m[0]);
        GlUtil.a("glBindFramebuffer");
        GLES20.glViewport(0, 0, this.f407280k, this.f407281l);
        GLES20.glClearColor(0.0f, 0.0f, 0.0f, 0.0f);
        GLES20.glClear(16384);
        int r102 = ((Integer) ((HashMap) ListProtector.get(this.f407279j, 0)).get("uMVPMatrix")).intValue();
        Matrix.setIdentityM(this.f407284o, 0);
        GLES20.glUniformMatrix4fv(r102, 1, false, this.f407284o, 0);
        GlUtil.a("glUniformMatrix4fv");
        GLES20.glDrawArrays(5, 0, 4);
        if (r211 == null) goto L19;
        GLES20.glReadPixels(0, 0, this.f407280k, this.f407281l, 6408, 5121, r211);
    L19:
        GLES20.glDisableVertexAttribArray(r100);
        GLES20.glDisableVertexAttribArray(r110);
        GLES20.glActiveTexture(33984);
        GLES20.glBindTexture(36197, 0);
        GLES20.glBindFramebuffer(36160, 0);
        GLES20.glUseProgram(0);
        return this.f407283n[0];
    L21:
        e = move-exception;
        CertLog.i("STGLRenderer", "glUseProgram fail msg=" + e.getMessage());
        return -2;
    L30:
        return -2;
    }

    public final void f(boolean r100, int r101, int r102) {
        if (this.f407278i == true) goto L5;
    L17:
        g("#extension GL_OES_EGL_image_external : require\n\nprecision mediump float;\nvarying vec2 textureCoordinate;\nuniform samplerExternalOES inputImageTexture;\n\nvoid main()\n{\n\tgl_FragColor = texture2D(inputImageTexture, textureCoordinate);\n}", (HashMap) ListProtector.get(this.f407279j, 0));
        if (r100 == false) goto L20;
        g("precision mediump float;\n//当前要采集像素的点\nvarying mediump vec2 textureCoordinate;\n//纹理\nuniform sampler2D inputImageTexture;\n//输出的宽与高\n//uniform vec2 singleStepOffset;\nuniform float intensity;\nvec2 blurCoordinates[20];\n// 裁剪参数 [left, top, right, bottom] (0.0-1.0)\nuniform vec4 cropRegion;\n// 裁剪形状 0:矩形, 1:圆形\nuniform int cropShape;\n// 圆角半径 (0.0-0.5, 相对于裁剪区域短边的比例)\nuniform float cornerRadius;\n// 纹理宽高比 (width/height)\nuniform float aspectRatio;\n\n\nvoid modifyColor(vec4 color){\n    color.r=max(min(color.r, 1.0), 0.0);\n    color.g=max(min(color.g, 1.0), 0.0);\n    color.b=max(min(color.b, 1.0), 0.0);\n    color.a=max(min(color.a, 1.0), 0.0);\n}\n\nvoid main()\n{\n    vec2 uv;\n    if (cropShape >= 0) {\n        // 裁剪后等比放大到填充\n        vec2 cropSize = vec2(cropRegion.z - cropRegion.x, cropRegion.w - cropRegion.y);\n        uv = cropRegion.xy + textureCoordinate * cropSize;\n        \n        // 圆形裁剪时保留圆形区域\n        if (cropShape == 1) {\n            vec2 center = vec2((cropRegion.x + cropRegion.z) / 2.0, (cropRegion.y + cropRegion.w) / 2.0);\n            // 根据宽高比校正x坐标，使圆形不变形\n            vec2 correctedUV = vec2((uv.x - center.x) * aspectRatio, uv.y - center.y);\n            float radius = min(cropSize.x * aspectRatio, cropSize.y) / 2.0;\n            float distance = length(correctedUV);\n            if (distance > radius) {\n                discard;\n            }\n        }\n        \n        // 矩形圆角裁剪\n        else if (cropShape == 0) {\n            if (cornerRadius > 0.0 && cornerRadius <= 0.5) {\n                // 计算实际像素空间的圆角半径\n                float pixelRadius = cornerRadius * min(cropSize.y, cropSize.x / aspectRatio);\n                \n                // 裁剪区域的四个角 (纹理坐标)\n                vec2 topLeft = cropRegion.xy;\n                vec2 bottomRight = cropRegion.zw;\n                \n                // 将纹理坐标转换为归一化坐标 (0.0-1.0)\n                vec2 normalizedUV = vec2(\n                    (uv.x - topLeft.x) / cropSize.x,\n                    (uv.y - topLeft.y) / cropSize.y\n                );\n                \n                // 计算裁剪区域的实际宽高比\n                float regionAspect = (cropSize.x * aspectRatio) / cropSize.y;\n                \n                // 对x坐标进行校正，使圆角在不同宽高比下保持圆形\n                if (regionAspect > 1.0) {\n                    normalizedUV.x *= regionAspect;\n                } else {\n                    normalizedUV.y /= regionAspect;\n                }\n                \n                // 计算归一化空间中的圆角半径\n                float normalizedRadius = pixelRadius / min(cropSize.y, cropSize.x / aspectRatio);\n                \n                // 计算到四个圆角的距离\n                vec2 topLeftCorner = vec2(normalizedRadius, normalizedRadius);\n                vec2 topRightCorner = vec2(1.0 - normalizedRadius, normalizedRadius);\n                vec2 bottomLeftCorner = vec2(normalizedRadius, 1.0 - normalizedRadius);\n                vec2 bottomRightCorner = vec2(1.0 - normalizedRadius, 1.0 - normalizedRadius);\n                \n                // 计算到各边的距离\n                float distLeft = normalizedUV.x - normalizedRadius;\n                float distRight = 1.0 - normalizedRadius - normalizedUV.x;\n                float distTop = normalizedUV.y - normalizedRadius;\n                float distBottom = 1.0 - normalizedRadius - normalizedUV.y;\n                \n                // 判断是否在圆角区域外\n                bool inCornerArea = false;\n                if (distLeft < 0.0 && distTop < 0.0) {\n                    inCornerArea = distance(normalizedUV, topLeftCorner) > normalizedRadius;\n                } else if (distRight < 0.0 && distTop < 0.0) {\n                    inCornerArea = distance(normalizedUV, topRightCorner) > normalizedRadius;\n                } else if (distLeft < 0.0 && distBottom < 0.0) {\n                    inCornerArea = distance(normalizedUV, bottomLeftCorner) > normalizedRadius;\n                } else if (distRight < 0.0 && distBottom < 0.0) {\n                    inCornerArea = distance(normalizedUV, bottomRightCorner) > normalizedRadius;\n                }\n                \n                if (inCornerArea) discard;\n            }\n        }\n        \n    } else {\n        uv = textureCoordinate;\n    }\n    //1、 模糊 ： 平滑处理 降噪\n    int width = 480;\n    int height = 640;\n    //singleStepOffset：步长 \n    vec2 singleStepOffset = vec2(1.0/float(width), 1.0/float(height));\n    blurCoordinates[0] = uv.xy + singleStepOffset *vec2(0.0, -10.0);\n    blurCoordinates[1] = uv.xy + singleStepOffset *vec2(0.0, 10.0);\n    blurCoordinates[2] = uv.xy + singleStepOffset *vec2(-10.0, 0.0);\n    blurCoordinates[3] = uv.xy + singleStepOffset *vec2(10.0, 0.0);\n    blurCoordinates[4] = uv.xy + singleStepOffset *vec2(5.0, -8.0);\n    blurCoordinates[5] = uv.xy + singleStepOffset *vec2(5.0, 8.0);\n    blurCoordinates[6] = uv.xy + singleStepOffset *vec2(-5.0, 8.0);\n    blurCoordinates[7] = uv.xy + singleStepOffset *vec2(-5.0, -8.0);\n    blurCoordinates[8] = uv.xy + singleStepOffset *vec2(8.0, -5.0);\n    blurCoordinates[9] = uv.xy + singleStepOffset *vec2(8.0, 5.0);\n    blurCoordinates[10] = uv.xy + singleStepOffset *vec2(-8.0, 5.0);\n    blurCoordinates[11] = uv.xy + singleStepOffset *vec2(-8.0, -5.0);\n    blurCoordinates[12] = uv.xy + singleStepOffset *vec2(0.0, -6.0);\n    blurCoordinates[13] = uv.xy + singleStepOffset *vec2(0.0, 6.0);\n    blurCoordinates[14] = uv.xy + singleStepOffset *vec2(6.0, 0.0);\n    blurCoordinates[15] = uv.xy + singleStepOffset *vec2(-6.0, 0.0);\n    blurCoordinates[16] = uv.xy + singleStepOffset *vec2(-4.0, -4.0);\n    blurCoordinates[17] = uv.xy + singleStepOffset *vec2(-4.0, 4.0);\n    blurCoordinates[18] = uv.xy + singleStepOffset *vec2(4.0, -4.0);\n    blurCoordinates[19] = uv.xy + singleStepOffset *vec2(4.0, 4.0);\n    //计算平均值   //本身的点的像素值 \n    vec4 currentColor = texture2D(inputImageTexture, uv);\n    vec3 rgb = currentColor.rgb;\n    // 计算偏移坐标的颜色值总和   \n    for (int i =0; i <20; i++) {\n        //采集20个点 的像素值 相加 得到总和\n        rgb += texture2D(inputImageTexture, blurCoordinates[i].xy).rgb; }\n    // rgb：21个点的像素和   //平均值 模糊效果   // rgba \n    vec4 blur =vec4(rgb *1.0 /21.0, currentColor.a);\n    //gl_FragColor = blur;    //高反差   \n    //强光处理:color = 2 * color1 * color2;\n    // 24.0 强光程度    // clamp:获得三个参数中大小处在中间的那个值   \n    vec4 highPassColor = currentColor - blur;\n    highPassColor.r = clamp(2.0 * highPassColor.r * highPassColor.r *24.0, 0.0, 1.0);\n    highPassColor.g = clamp(2.0 * highPassColor.g * highPassColor.g *24.0, 0.0, 1.0);\n    highPassColor.b = clamp(2.0 * highPassColor.b * highPassColor.b *24.0, 0.0, 1.0);\n    // 过滤疤痕\n    vec4 highPassBlur =vec4(highPassColor.rgb, 1.0);\n    //3、融合 -> 磨皮      //蓝色通道值\n    float b = min(currentColor.b, blur.b);\n    float value = clamp((b -0.2) *5.0, 0.0, 1.0);\n    // RGB的最大值\n    float maxChannelColor = max(max(highPassBlur.r, highPassBlur.g), highPassBlur.b);\n    // 磨皮程度   \n    \n    //float intensity = 0.5;\n    float currentIntensity = (1.0 - maxChannelColor / (maxChannelColor +0.2)) * value * intensity;\n    //gl_FragColor = highPassBlur;\n    // 一个滤镜    //opengl 内置函数 线性融合    //混合 x*(1−a)+y⋅a    // 第三个值越大，在这里融合的图像 越模糊   \n    vec3 r = mix(currentColor.rgb, blur.rgb, currentIntensity);\n    \n    // 美白\n    //float level = 0.4;\n    vec4 deltaColor = vec4(r, 1.0) + vec4(intensity * 0.15, intensity * 0.25, intensity * 0.25, 0.0);\n    modifyColor(deltaColor);\n    \n    gl_FragColor =deltaColor;\n    \n}\n", (HashMap) ListProtector.get(this.f407279j, 1));
    L21:
        this.f407280k = r101;
        this.f407281l = r102;
        e();
        if (this.f407282m != null) goto L24;
        int[] r103 = new int[2];
        this.f407282m = r103;
        this.f407283n = new int[2];
        GLES20.glGenFramebuffers(2, r103, 0);
        GLES20.glGenTextures(2, this.f407283n, 0);
        b(this.f407283n[0], this.f407282m[0], r101, r102);
        b(this.f407283n[1], this.f407282m[1], r101, r102);
    L24:
        this.f407278i = true;
        return;
    L20:
        g("precision mediump float;\nvarying highp vec2 textureCoordinate;\n \nuniform sampler2D inputImageTexture;\n \n// 裁剪参数 [left, top, right, bottom] (0.0-1.0)\nuniform vec4 cropRegion;\n// 裁剪形状 0:矩形, 1:圆形\nuniform int cropShape;\n// 圆角半径 (0.0-0.5, 相对于裁剪区域短边的比例)\nuniform float cornerRadius;\n// 纹理宽高比 (width/height)\nuniform float aspectRatio;\n\nvoid main()\n{\n    vec2 uv;\n    if (cropShape >= 0) {\n        // 裁剪后等比放大到填充\n        vec2 cropSize = vec2(cropRegion.z - cropRegion.x, cropRegion.w - cropRegion.y);\n        uv = cropRegion.xy + textureCoordinate * cropSize;\n        \n        // 圆形裁剪时保留圆形区域\n        if (cropShape == 1) {\n            vec2 center = vec2((cropRegion.x + cropRegion.z) / 2.0, (cropRegion.y + cropRegion.w) / 2.0);\n            // 根据宽高比校正x坐标，使圆形不变形\n            vec2 correctedUV = vec2((uv.x - center.x) * aspectRatio, uv.y - center.y);\n            float radius = min(cropSize.x * aspectRatio, cropSize.y) / 2.0;\n            float distance = length(correctedUV);\n            if (distance > radius) {\n                discard;\n            }\n        }\n        \n        // 矩形圆角裁剪\n        else if (cropShape == 0) {\n            if (cornerRadius > 0.0 && cornerRadius <= 0.5) {\n                // 计算实际像素空间的圆角半径\n                float pixelRadius = cornerRadius * min(cropSize.y, cropSize.x / aspectRatio);\n                \n                // 裁剪区域的四个角 (纹理坐标)\n                vec2 topLeft = cropRegion.xy;\n                vec2 bottomRight = cropRegion.zw;\n                \n                // 将纹理坐标转换为归一化坐标 (0.0-1.0)\n                vec2 normalizedUV = vec2(\n                    (uv.x - topLeft.x) / cropSize.x,\n                    (uv.y - topLeft.y) / cropSize.y\n                );\n                \n                // 计算裁剪区域的实际宽高比\n                float regionAspect = (cropSize.x * aspectRatio) / cropSize.y;\n                \n                // 对x坐标进行校正，使圆角在不同宽高比下保持圆形\n                if (regionAspect > 1.0) {\n                    normalizedUV.x *= regionAspect;\n                } else {\n                    normalizedUV.y /= regionAspect;\n                }\n                \n                // 计算归一化空间中的圆角半径\n                float normalizedRadius = pixelRadius / min(cropSize.y, cropSize.x / aspectRatio);\n                \n                // 计算到四个圆角的距离\n                vec2 topLeftCorner = vec2(normalizedRadius, normalizedRadius);\n                vec2 topRightCorner = vec2(1.0 - normalizedRadius, normalizedRadius);\n                vec2 bottomLeftCorner = vec2(normalizedRadius, 1.0 - normalizedRadius);\n                vec2 bottomRightCorner = vec2(1.0 - normalizedRadius, 1.0 - normalizedRadius);\n                \n                // 计算到各边的距离\n                float distLeft = normalizedUV.x - normalizedRadius;\n                float distRight = 1.0 - normalizedRadius - normalizedUV.x;\n                float distTop = normalizedUV.y - normalizedRadius;\n                float distBottom = 1.0 - normalizedRadius - normalizedUV.y;\n                \n                // 判断是否在圆角区域外\n                bool inCornerArea = false;\n                if (distLeft < 0.0 && distTop < 0.0) {\n                    inCornerArea = distance(normalizedUV, topLeftCorner) > normalizedRadius;\n                } else if (distRight < 0.0 && distTop < 0.0) {\n                    inCornerArea = distance(normalizedUV, topRightCorner) > normalizedRadius;\n                } else if (distLeft < 0.0 && distBottom < 0.0) {\n                    inCornerArea = distance(normalizedUV, bottomLeftCorner) > normalizedRadius;\n                } else if (distRight < 0.0 && distBottom < 0.0) {\n                    inCornerArea = distance(normalizedUV, bottomRightCorner) > normalizedRadius;\n                }\n                \n                if (inCornerArea) discard;\n            }\n        }\n        \n    } else {\n        uv = textureCoordinate;\n    }\n    gl_FragColor = texture2D(inputImageTexture, uv);\n}", (HashMap) ListProtector.get(this.f407279j, 1));
        goto L21
    L5:
        if (this.f407280k != r101) goto L17;
        if (this.f407281l != r102) goto L17;
        if (this.f407282m == null) goto L17;
        if (this.f407283n == null) goto L17;
        if (((Integer) ((HashMap) ListProtector.get(this.f407279j, 0)).get("program")).intValue() == 0) goto L17;
        if (((Integer) ((HashMap) ListProtector.get(this.f407279j, 1)).get("program")).intValue() == 0) goto L17;
    }

    public static void b(int r110, int r111, int r112, int r113) {
        GLES20.glBindTexture(3553, r110);
        GLES20.glTexImage2D(3553, 0, 6408, r112, r113, 0, 6408, 5121, null);
        GLES20.glTexParameterf(3553, 10240, 9729.0f);
        GLES20.glTexParameterf(3553, 10241, 9729.0f);
        GLES20.glTexParameterf(3553, 10242, 33071.0f);
        GLES20.glTexParameterf(3553, 10243, 33071.0f);
        GLES20.glBindFramebuffer(36160, r111);
        GLES20.glFramebufferTexture2D(36160, 36064, 3553, r110, 0);
        GLES20.glBindTexture(3553, 0);
        GLES20.glBindFramebuffer(36160, 0);
    }

    public final void c(int r100, int r101, int r110, int r111) {
        if (this.f407275f < 0) goto L5;
        float[] r102 = this.f407276g;
        float r103 = r102[2] - r102[0];
        float r104 = r102[3] - r102[1];
    L6:
        float r112 = r110 * r103;
        float r113 = r111 * r104;
        float r105 = r100;
        float r106 = r101;
        float r107 = Math.max(r105 / r112, r106 / r113);
        float r114 = Math.round(r112 * r107) / r105;
        float r108 = Math.round(r113 * r107) / r106;
        float[] r115 = e.f407302e;
        float[] r109 = {r115[0] / r108, r115[1] / r114, r115[2] / r108, r115[3] / r114, r115[4] / r108, r115[5] / r114, r115[6] / r108, r115[7] / r114};
        if (this.f407274e != null) goto L9;
        this.f407274e = ByteBuffer.allocateDirect(32).order(ByteOrder.nativeOrder()).asFloatBuffer();
    L9:
        this.f407274e.clear();
        this.f407274e.put(r109).position(0);
        return;
    L5:
        r103 = 1.0f;
        r104 = 1.0f;
        goto L6
    }

    public final void d(int r100, int r110, int r111, int r112) {
        if (this.f407270a == true) goto L5;
        c(r100, r110, r111, r112);
        return;
    L5:
        if (this.f407275f < 0) goto L7;
        float[] r101 = this.f407276g;
        float r102 = r101[2] - r101[0];
        float r103 = r101[3] - r101[1];
    L8:
        float r104 = r111 * r102;
        float r105 = r112 * r103;
        if (r100 <= 0) goto L20;
        if (r110 <= 0) goto L20;
        if (r104 <= 0.0f) goto L20;
        if (r105 <= 0.0f) goto L20;
        float r106 = r100;
        float r113 = r110;
        float r114 = Math.max(r106 / r104, r113 / r105);
        float r115 = Math.round(r104 * r114) / r106;
        float r107 = Math.round(r105 * r114) / r113;
        float[] r116 = e.f407302e;
        float[] r117 = {r116[0] * r115, r116[1] * r107, r116[2] * r115, r116[3] * r107, r116[4] * r115, r116[5] * r107, r116[6] * r115, r116[7] * r107};
        if (this.f407274e != null) goto L19;
        this.f407274e = ByteBuffer.allocateDirect(32).order(ByteOrder.nativeOrder()).asFloatBuffer();
    L19:
        this.f407274e.clear();
        this.f407274e.put(r117).position(0);
        return;
    L20:
        c(r100, r110, r111, r112);
        return;
    L7:
        r102 = 1.0f;
        r103 = 1.0f;
        goto L8
    }

    public final void k(float r100, float r101, float r102, float r103) {
        if (this.f407275f >= 0) goto L5;
        return;
    L5:
        this.f407276g[0] = Math.max(0.0f, Math.min(r100, 1.0f));
        this.f407276g[1] = Math.max(0.0f, Math.min(r101, 1.0f));
        float[] r104 = this.f407276g;
        r104[2] = Math.max(r104[0], Math.min(r102, 1.0f));
        float[] r105 = this.f407276g;
        r105[3] = Math.max(r105[1], Math.min(r103, 1.0f));
    }
}
