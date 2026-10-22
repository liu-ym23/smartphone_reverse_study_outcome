package com.bytedance.bmmt.video;

import android.opengl.GLES20;
import com.bytedance.bmmt.base.Logging;
import java.nio.FloatBuffer;

/* JADX INFO: loaded from: classes8.dex */
public class GlGenericDrawer implements RendererCommon.GlDrawer {
    private static final String DEFAULT_VERTEX_SHADER_STRING = "varying vec2 tc;\nattribute vec4 in_pos;\nattribute vec4 in_tc;\nuniform mat4 tex_mat;\nvoid main() {\n  gl_Position = in_pos;\n  tc = (tex_mat * in_tc).xy;\n}\n";
    private static final FloatBuffer FULL_RECTANGLE_BUFFER = null;
    private static final FloatBuffer FULL_RECTANGLE_TEXTURE_BUFFER = null;
    private static final String INPUT_TEXTURE_COORDINATE_NAME = "in_tc";
    private static final String INPUT_VERTEX_COORDINATE_NAME = "in_pos";
    private static final String ORI_TEX_SIZE_NAME = "ori_tex_size";
    private static final String TAR_TEX_SIZE_NAME = "tar_tex_size";
    private static final String TEXTURE_MATRIX_NAME = "tex_mat";
    private FilterType currentScaleFilter;
    private GlShader currentShader;
    private ShaderType currentShaderType;
    private int dstHeight;
    private int dstWidth;
    private int frameHeight;
    private int frameWidth;
    private final String genericFragmentSource;
    private int inPosLocation;
    private int inTcLocation;
    private FloatBuffer mPosCoordinate;
    private int oriTexSizeLocation;
    private final ShaderCallbacks shaderCallbacks;
    private int tarTexSizeLocation;
    private int texMatrixLocation;
    private final String vertexShader;

    public interface ShaderCallbacks {
        void onNewShader(GlShader r100);

        void onPrepareShader(GlShader r100, float[] r101, int r102, int r103, int r104, int r105);
    }

    public static final enum ShaderType extends Enum<ShaderType> {
        private static final /* synthetic */ ShaderType[] $VALUES = null;
        public static final ShaderType OES = null;
        public static final ShaderType RGB = null;
        public static final ShaderType YUV = null;

        private static /* synthetic */ ShaderType[] $values() {
            return new ShaderType[]{OES, RGB, YUV};
        }

        static {
            OES = new ShaderType("OES", 0);
            RGB = new ShaderType("RGB", 1);
            YUV = new ShaderType("YUV", 2);
            $VALUES = $values();
        }

        public static ShaderType[] values() {
            return (ShaderType[]) $VALUES.clone();
        }

        public static ShaderType valueOf(String r100) {
            return (ShaderType) r27.a.a(ShaderType.class, r100);
        }

        private ShaderType(String r100, int r101) {
            super(r100, r101);
        }
    }

    static {
        FULL_RECTANGLE_BUFFER = GlUtil.createFloatBuffer(new float[]{-1.0f, -1.0f, 1.0f, -1.0f, -1.0f, 1.0f, 1.0f, 1.0f});
        FULL_RECTANGLE_TEXTURE_BUFFER = GlUtil.createFloatBuffer(new float[]{0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 1.0f, 1.0f, 1.0f});
    }

    @Override // com.bytedance.bmmt.video.RendererCommon.GlDrawer
    public void release() {
        GlShader r100 = this.currentShader;
        if (r100 == null) goto L6;
        r100.release();
        this.currentShader = null;
        this.currentShaderType = null;
        return;
    }

    public GlGenericDrawer(String r100, ShaderCallbacks r101) {
        this(DEFAULT_VERTEX_SHADER_STRING, r100, r101);
    }

    public GlShader createShader(ShaderType r100, FilterType r101) {
        return new GlShader(this.vertexShader, createFragmentShaderString(this.genericFragmentSource, r100, r101));
    }

    public GlGenericDrawer(String r100, String r101, ShaderCallbacks r102) {
        this.mPosCoordinate = GlUtil.createFloatBuffer(new float[]{-1.0f, -1.0f, 1.0f, -1.0f, -1.0f, 1.0f, 1.0f, 1.0f});
        this.vertexShader = r100;
        this.genericFragmentSource = r101;
        this.shaderCallbacks = r102;
    }

    public static String createFragmentShaderString(String r100, ShaderType r101, FilterType r102) {
        StringBuilder r103 = new StringBuilder();
        ShaderType r104 = ShaderType.OES;
        if (r101 != r104) goto L5;
        r103.append("#extension GL_OES_EGL_image_external : require\n");
    L5:
        r103.append("precision mediump float;\nvarying vec2 tc;\n");
        if (r102 == FilterType.Origin) goto L9;
        r103.append("uniform vec2 tar_tex_size;\nuniform vec2 ori_tex_size;\n");
    L9:
        if (r101 != ShaderType.YUV) goto L21;
        r103.append("uniform sampler2D y_tex;\nuniform sampler2D u_tex;\nuniform sampler2D v_tex;\n");
        if (r102 != FilterType.Bilinear) goto L14;
        r103.append("float bilinearTextureSample(sampler2D tex, vec2 p) {\n        vec2 c_onePixel =  vec2(1.0 / ori_tex_size.y - tar_tex_size.x + tar_tex_size.x, 1.0 / ori_tex_size.y);\n    vec2 frac = vec2(0.5, 0.5);\n    float C11 = texture2D(tex, p - c_onePixel).r;\n    float C21 = texture2D(tex, p + vec2( c_onePixel.x , -c_onePixel.y)).r;\n    float C12 = texture2D(tex, p + vec2( -c_onePixel.x , c_onePixel.y)).r;\n    float C22 = texture2D(tex, p + c_onePixel).r;\n    float x1 = mix(C11, C21, frac.x);\n    float x2 = mix(C12, C22, frac.x);\n    return mix(x1, x2, frac.y);\n}\nvec4 sample(vec2 p) {\n  float y = bilinearTextureSample(y_tex, p) * 1.16438;\n  float u = bilinearTextureSample(u_tex, p);\n  float v = bilinearTextureSample(v_tex, p);\n  return vec4(y + 1.59603 * v - 0.874202,\n    y - 0.391762 * u - 0.812968 * v + 0.531668,\n    y + 2.01723 * u - 1.08563, 1);\n}\n");
    L20:
        r103.append(r100);
    L35:
        return r103.toString();
    L14:
        if (r102 != FilterType.Bicubic) goto L17;
        r103.append("vec3 cubic_hermite (vec3 A, vec3 B, vec3 C, vec3 D, float t) {\n    float t2 = t*t;\n    float t3 = t*t*t;\n    vec3 a = -A/2.0 + (3.0*B)/2.0 - (3.0*C)/2.0 + D/2.0;\n    vec3 b = A - (5.0*B)/2.0 + 2.0*C - D / 2.0;\n    vec3 c = -A/2.0 + C/2.0;\n   \tvec3 d = B;\n    return a*t3 + b*t2 + c*t + d;\n}\nvec4 bicubic_sample (sampler2D tex, vec2 P) {\n    float c_onePixel_x = 1.0 / ori_tex_size.x - tar_tex_size.x + tar_tex_size.x;\n    float c_onePixel_y = 1.0 / ori_tex_size.y;\n    float c_twoPixels_x = 2.0 / ori_tex_size.x;\n    float c_twoPixels_y = 2.0 / ori_tex_size.y;\n    vec2 pixel = vec2(P.x * ori_tex_size.x, P.y * ori_tex_size.y) + 0.5;\n    vec2 frac = fract(pixel);\n    pixel = floor(pixel);\n    pixel = vec2(pixel.x / ori_tex_size.x, pixel.y / ori_tex_size.y) - vec2(c_onePixel_x, c_onePixel_y) / 2.0;\n    vec3 C00 = texture2D(tex, pixel + vec2(-c_onePixel_x ,-c_onePixel_y)).rgb;\n    vec3 C10 = texture2D(tex, pixel + vec2( 0.0        ,-c_onePixel_y)).rgb;\n    vec3 C20 = texture2D(tex, pixel + vec2( c_onePixel_x ,-c_onePixel_y)).rgb;\n    vec3 C30 = texture2D(tex, pixel + vec2( c_twoPixels_x,-c_onePixel_y)).rgb;\n    vec3 C01 = texture2D(tex, pixel + vec2(-c_onePixel_x , 0.0)).rgb;\n    vec3 C11 = texture2D(tex, pixel + vec2( 0.0        , 0.0)).rgb;\n    vec3 C21 = texture2D(tex, pixel + vec2( c_onePixel_x , 0.0)).rgb;\n    vec3 C31 = texture2D(tex, pixel + vec2( c_twoPixels_x, 0.0)).rgb;\n    vec3 C02 = texture2D(tex, pixel + vec2(-c_onePixel_x , c_onePixel_y)).rgb;\n    vec3 C12 = texture2D(tex, pixel + vec2( 0.0        , c_onePixel_y)).rgb;\n    vec3 C22 = texture2D(tex, pixel + vec2( c_onePixel_x , c_onePixel_y)).rgb;\n    vec3 C32 = texture2D(tex, pixel + vec2( c_twoPixels_x, c_onePixel_y)).rgb;\n    vec3 C03 = texture2D(tex, pixel + vec2(-c_onePixel_x , c_twoPixels_y)).rgb;\n    vec3 C13 = texture2D(tex, pixel + vec2( 0.0        , c_twoPixels_y)).rgb;\n    vec3 C23 = texture2D(tex, pixel + vec2( c_onePixel_x , c_twoPixels_y)).rgb;\n    vec3 C33 = texture2D(tex, pixel + vec2( c_twoPixels_x, c_twoPixels_y)).rgb;  \n    vec3 CP0X = cubic_hermite(C00, C10, C20, C30, frac.x);\n    vec3 CP1X = cubic_hermite(C01, C11, C21, C31, frac.x);\n    vec3 CP2X = cubic_hermite(C02, C12, C22, C32, frac.x);\n    vec3 CP3X = cubic_hermite(C03, C13, C23, C33, frac.x);\n    return vec4(cubic_hermite(CP0X, CP1X, CP2X, CP3X, frac.y), 1.0);}\nvec4 sample(vec2 p) {\n  float y = bicubic_sample(y_tex, p) * 1.16438;\n  float u = bicubic_sample(u_tex, p);\n  float v = bicubic_sample(v_tex, p);\n  return vec4(y + 1.59603 * v - 0.874202,\n    y - 0.391762 * u - 0.812968 * v + 0.531668,\n    y + 2.01723 * u - 1.08563, 1);\n}\n");
        goto L20
    L17:
        if (r102 != FilterType.BOX) goto L19;
        r103.append("float box_filter(sampler2D tex, vec2 p) {\n  vec2 c_onePixel =  1.0 / ori_tex_size;\n  float C11, C12, C13, C21, C22, C23, C31, C32, C33;\n  C11 = texture2D(tex, p - c_onePixel).r;\n  C12 = texture2D(tex, p + vec2( 0, -c_onePixel.y)).r;\n  C13 = texture2D(tex, p + vec2( c_onePixel.x, -c_onePixel.y)).r;\n  C21 = texture2D(tex, p + vec2( -c_onePixel.x , 0)).r;\n  C22 = texture2D(tex, p).r;\n  C23 = texture2D(tex, p + vec2( c_onePixel.x , 0)).r;\n  C31 = texture2D(tex, p + vec2( -c_onePixel.x , c_onePixel.y)).r;\n  C32 = texture2D(tex, p + vec2( 0 , c_onePixel.y)).r;\n  C33 = texture2D(tex, p + c_onePixel).r;\n  return (C11 + C12 + C13 + C21 + C22 + C23 + C31 + C32 + C33) / 9.0;\n}\nvec4 sample(vec2 p) {\n  float y = box_filter(y_tex, p) * 1.16438;\n  float u = box_filter(u_tex, p);\n  float v = box_filter(v_tex, p);\n  return vec4(y + 1.59603 * v - 0.874202,\n    y - 0.391762 * u - 0.812968 * v + 0.531668,\n    y + 2.01723 * u - 1.08563, 1);\n}\n");
        goto L20
    L19:
        r103.append("vec4 sample(vec2 p) {\n  float y = texture2D(y_tex, p).r * 1.16438;\n  float u = texture2D(u_tex, p).r;\n  float v = texture2D(v_tex, p).r;\n  return vec4(y + 1.59603 * v - 0.874202,\n    y - 0.391762 * u - 0.812968 * v + 0.531668,\n    y + 2.01723 * u - 1.08563, 1);\n}\n");
        goto L20
    L21:
        if (r101 != r104) goto L23;
        String r105 = "samplerExternalOES";
    L24:
        r103.append("uniform ");
        r103.append(r105);
        r103.append(" tex;\n");
        if (r102 != FilterType.Bilinear) goto L28;
        r103.append("vec4 sample(vec2 p) {\n    vec2 c_onePixel =  vec2(1.0 / ori_tex_size.y - tar_tex_size.x + tar_tex_size.x, 1.0 / ori_tex_size.y);\n    vec2 frac = vec2(0.5, 0.5);\n    vec3 C11 = texture2D(tex, p - c_onePixel).rgb;\n    vec3 C21 = texture2D(tex, p + vec2( c_onePixel.x , -c_onePixel.y)).rgb;\n    vec3 C12 = texture2D(tex, p + vec2( -c_onePixel.x , c_onePixel.y)).rgb;\n    vec3 C22 = texture2D(tex, p + c_onePixel).rgb;\n    vec3 x1 = mix(C11, C21, frac.x);\n    vec3 x2 = mix(C12, C22, frac.x);\n    return vec4(mix(x1, x2, frac.y), 1);\n}\n");
        r103.append(r100);
        goto L35
    L28:
        if (r102 != FilterType.Bicubic) goto L31;
        r103.append("vec3 cubic_hermite (vec3 A, vec3 B, vec3 C, vec3 D, float t) {\n\t  float t2 = t*t;\n    float t3 = t*t*t;\n    vec3 a = -A/2.0 + (3.0*B)/2.0 - (3.0*C)/2.0 + D/2.0;\n    vec3 b = A - (5.0*B)/2.0 + 2.0*C - D / 2.0;\n    vec3 c = -A/2.0 + C/2.0;\n   \tvec3 d = B;\n    return a*t3 + b*t2 + c*t + d;\n}\nvec4 sample (vec2 P) {\n    float c_onePixel_x = 1.0 / ori_tex_size.x - tar_tex_size.x + tar_tex_size.x;\n    float c_onePixel_y = 1.0 / ori_tex_size.y;\n    float c_twoPixels_x = 2.0 / ori_tex_size.x;\n    float c_twoPixels_y = 2.0 / ori_tex_size.y;\n    vec2 pixel = vec2(P.x * ori_tex_size.x, P.y * ori_tex_size.y) + 0.5;\n    vec2 frac = fract(pixel);\n    pixel = floor(pixel);\n    pixel = vec2(pixel.x / ori_tex_size.x, pixel.y / ori_tex_size.y) - vec2(c_onePixel_x, c_onePixel_y) / 2.0;\n    vec3 C00 = texture2D(tex, pixel + vec2(-c_onePixel_x ,-c_onePixel_y)).rgb;\n    vec3 C10 = texture2D(tex, pixel + vec2( 0.0        ,-c_onePixel_y)).rgb;\n    vec3 C20 = texture2D(tex, pixel + vec2( c_onePixel_x ,-c_onePixel_y)).rgb;\n    vec3 C30 = texture2D(tex, pixel + vec2( c_twoPixels_x,-c_onePixel_y)).rgb;\n    vec3 C01 = texture2D(tex, pixel + vec2(-c_onePixel_x , 0.0)).rgb;\n    vec3 C11 = texture2D(tex, pixel + vec2( 0.0        , 0.0)).rgb;\n    vec3 C21 = texture2D(tex, pixel + vec2( c_onePixel_x , 0.0)).rgb;\n    vec3 C31 = texture2D(tex, pixel + vec2( c_twoPixels_x, 0.0)).rgb;\n    vec3 C02 = texture2D(tex, pixel + vec2(-c_onePixel_x , c_onePixel_y)).rgb;\n    vec3 C12 = texture2D(tex, pixel + vec2( 0.0        , c_onePixel_y)).rgb;\n    vec3 C22 = texture2D(tex, pixel + vec2( c_onePixel_x , c_onePixel_y)).rgb;\n    vec3 C32 = texture2D(tex, pixel + vec2( c_twoPixels_x, c_onePixel_y)).rgb;\n    vec3 C03 = texture2D(tex, pixel + vec2(-c_onePixel_x , c_twoPixels_y)).rgb;\n    vec3 C13 = texture2D(tex, pixel + vec2( 0.0        , c_twoPixels_y)).rgb;\n    vec3 C23 = texture2D(tex, pixel + vec2( c_onePixel_x , c_twoPixels_y)).rgb;\n    vec3 C33 = texture2D(tex, pixel + vec2( c_twoPixels_x, c_twoPixels_y)).rgb;  \n    vec3 CP0X = cubic_hermite(C00, C10, C20, C30, frac.x);\n    vec3 CP1X = cubic_hermite(C01, C11, C21, C31, frac.x);\n    vec3 CP2X = cubic_hermite(C02, C12, C22, C32, frac.x);\n    vec3 CP3X = cubic_hermite(C03, C13, C23, C33, frac.x);\n    return vec4(cubic_hermite(CP0X, CP1X, CP2X, CP3X, frac.y), 1.0);}\n");
        r103.append(r100);
        goto L35
    L31:
        if (r102 != FilterType.BOX) goto L33;
        r103.append("vec4 sample(vec2 p) {\n  vec2 c_onePixel =  1.0 / ori_tex_size;\n  vec3 C11 = texture2D(tex, p - c_onePixel).rgb;\n  vec3 C12 = texture2D(tex, p + vec2( 0, -c_onePixel.y)).rgb;\n  vec3 C13 = texture2D(tex, p + vec2( c_onePixel.x, -c_onePixel.y)).rgb;\n  vec3 C21 = texture2D(tex, p + vec2( -c_onePixel.x , 0)).rgb;\n  vec3 C22 = texture2D(tex, p).rgb;\n  vec3 C23 = texture2D(tex, p + vec2( c_onePixel.x , 0)).rgb;\n  vec3 C31 = texture2D(tex, p + vec2( -c_onePixel.x , c_onePixel.y)).rgb;\n  vec3 C32 = texture2D(tex, p + vec2( 0 , c_onePixel.y)).rgb;\n  vec3 C33 = texture2D(tex, p + c_onePixel).rgb;\n  return vec4((C11 + C12 + C13 + C21 + C22 + C23 + C31 + C32 + C33) / 9.0, 1.0);\n}\n");
        r103.append(r100);
        goto L35
    L33:
        r103.append(r100.replace("sample(", "texture2D(tex, "));
        goto L35
    L23:
        r105 = "sampler2D";
        goto L24
    }

    private void prepareTexAndPosCoord(int r100, int r101, int r102, int r103) {
        if (r102 == 0) goto L18;
        if (r103 == 0) goto L19;
        if (r100 > r102) goto L20;
        if (r101 <= r103) goto L8;
        return;
    L8:
        if (this.frameWidth == r100) goto L10;
    L16:
        this.frameWidth = r100;
        this.frameHeight = r101;
        this.dstWidth = r102;
        this.dstHeight = r103;
        float r104 = (((r103 - r101) * 2.0f) / r103) - 1.0f;
        float r105 = ((r100 * 2.0f) / r102) - 1.0f;
        this.mPosCoordinate = GlUtil.createFloatBuffer(new float[]{-1.0f, r104, r105, r104, -1.0f, 1.0f, r105, 1.0f});
        return;
    L10:
        if (this.frameHeight != r101) goto L16;
        if (this.dstWidth != r102) goto L16;
        if (this.dstHeight != r103) goto L16;
        return;
    L20:
        return;
    L19:
        return;
    }

    @Override // com.bytedance.bmmt.video.RendererCommon.GlDrawer
    public void drawOes(int r110, float[] r111, int r112, int r113, int r114, int r115, int r116, int r210) {
        drawOes(r110, r111, r112, r113, r114, r115, r116, r210, FilterType.Origin, 0, 0);
    }

    @Override // com.bytedance.bmmt.video.RendererCommon.GlDrawer
    public void drawRgb(int r110, float[] r111, int r112, int r113, int r114, int r115, int r116, int r210) {
        drawRgb(r110, r111, r112, r113, r114, r115, r116, r210, FilterType.Origin, 0, 0);
    }

    @Override // com.bytedance.bmmt.video.RendererCommon.GlDrawer
    public void drawYuv(int[] r110, float[] r111, int r112, int r113, int r114, int r115, int r116, int r210) {
        drawYuv(r110, r111, r112, r113, r114, r115, r116, r210, FilterType.Origin, 0, 0);
    }

    private void prepareShader(ShaderType r110, float[] r111, int r112, int r210, int r211, int r212, FilterType r213, int r214, int r215) {
        if (r213 == null) goto L8;
        if (r214 == 0) goto L8;
        if (r215 == 0) goto L8;
        FilterType r100 = r213;
        int r101 = r214;
        int r102 = r215;
    L10:
        if (r110.equals(this.currentShaderType) == true) goto L12;
    L14:
        this.currentShaderType = r110;
        GlShader r103 = this.currentShader;
        if (r103 == null) goto L17;
        r103.release();
    L17:
        GlShader r104 = createShader(r110, r100);
        this.currentShader = r104;
        this.currentScaleFilter = r100;
        r104.useProgram();
        if (r110 != ShaderType.YUV) goto L20;
        GLES20.glUniform1i(r104.getUniformLocation("y_tex"), 0);
        GLES20.glUniform1i(r104.getUniformLocation("u_tex"), 1);
        GLES20.glUniform1i(r104.getUniformLocation("v_tex"), 2);
    L21:
        GlUtil.checkNoGLES2Error("Create shader");
        this.shaderCallbacks.onNewShader(r104);
        this.texMatrixLocation = r104.getUniformLocation(TEXTURE_MATRIX_NAME);
        this.inPosLocation = r104.getAttribLocation(INPUT_VERTEX_COORDINATE_NAME);
        this.inTcLocation = r104.getAttribLocation(INPUT_TEXTURE_COORDINATE_NAME);
        GlShader r105 = r104;
    L22:
        FilterType r106 = FilterType.Origin;
        if (r100 != r106) goto L25;
    L28:
        GlUtil.checkNoGLES2Error("before useProgram ");
        r105.useProgram();
        GLES20.glEnableVertexAttribArray(this.inPosLocation);
        GLES20.glVertexAttribPointer(this.inPosLocation, 2, 5126, false, 0, this.mPosCoordinate);
        GLES20.glEnableVertexAttribArray(this.inTcLocation);
        GLES20.glVertexAttribPointer(this.inTcLocation, 2, 5126, false, 0, FULL_RECTANGLE_TEXTURE_BUFFER);
        GLES20.glUniformMatrix4fv(this.texMatrixLocation, 1, false, r111, 0);
        if (r100 == r106) goto L40;
        if (r101 <= 0) goto L40;
        if (r101 <= 0) goto L40;
        int r107 = this.tarTexSizeLocation;
        if (r107 == 0) goto L36;
        GLES20.glUniform2f(r107, r112, r210);
    L36:
        int r108 = this.oriTexSizeLocation;
        if (r108 == 0) goto L40;
        GLES20.glUniform2f(r108, r101, r102);
    L40:
        this.shaderCallbacks.onPrepareShader(r105, r111, r112, r210, r211, r212);
        GlUtil.checkNoGLES2Error("Prepare shader");
        return;
    L25:
        if (r100 == FilterType.BOX) goto L27;
        this.tarTexSizeLocation = r105.getUniformLocation(TAR_TEX_SIZE_NAME);
    L27:
        this.oriTexSizeLocation = r105.getUniformLocation(ORI_TEX_SIZE_NAME);
        goto L28
    L20:
        GLES20.glUniform1i(r104.getUniformLocation("tex"), 0);
        goto L21
    L12:
        if (r100.equals(this.currentScaleFilter) == false) goto L14;
        r105 = this.currentShader;
    L8:
        r100 = FilterType.Origin;
        r101 = 0;
        r102 = 0;
        goto L10
    }

    @Override // com.bytedance.bmmt.video.RendererCommon.GlDrawer
    public void drawOes(int r110, float[] r111, int r112, int r113, int r114, int r115, int r116, int r117, FilterType r118, int r210, int r211) {
        prepareShader(ShaderType.OES, r111, r112, r113, r116, r117, r118, r210, r211);
        GLES20.glActiveTexture(33984);
        GLES20.glBindTexture(36197, r110);
        int r100 = GLES20.glGetError();
        if (r100 == 0) goto L6;
        Logging.e("GlGenericDrawer", "drawOes glBindTexture error: " + r100);
        return;
    L6:
        GLES20.glViewport(r114, r115, r116, r117);
        GLES20.glDrawArrays(5, 0, 4);
        GLES20.glBindTexture(36197, 0);
        GlUtil.checkNoGLES2Error("drawOes done");
    }

    @Override // com.bytedance.bmmt.video.RendererCommon.GlDrawer
    public void drawRgb(int r110, float[] r111, int r112, int r113, int r114, int r115, int r116, int r117, FilterType r118, int r210, int r211) {
        prepareShader(ShaderType.RGB, r111, r112, r113, r116, r117, r118, r210, r211);
        GlUtil.checkNoGLES2Error("after prepare shader");
        GLES20.glActiveTexture(33984);
        GLES20.glBindTexture(3553, r110);
        int r100 = GLES20.glGetError();
        if (r100 == 0) goto L6;
        Logging.e("GlGenericDrawer", "drawRgb glBindTexture error: " + r100);
        return;
    L6:
        GLES20.glViewport(r114, r115, r116, r117);
        GLES20.glDrawArrays(5, 0, 4);
        GLES20.glBindTexture(3553, 0);
        GlUtil.checkNoGLES2Error("drawRgb done");
    }

    @Override // com.bytedance.bmmt.video.RendererCommon.GlDrawer
    public void drawYuv(int[] r110, float[] r111, int r112, int r113, int r114, int r115, int r116, int r117, FilterType r118, int r210, int r211) {
        prepareShader(ShaderType.YUV, r111, r112, r113, r116, r117, r118, r210, r211);
        int r100 = 0;
    L4:
        if (r100 >= 3) goto L6;
        GLES20.glActiveTexture(33984 + r100);
        GLES20.glBindTexture(3553, r110[r100]);
        r100 = r100 + 1;
        goto L4
    L6:
        int r101 = GLES20.glGetError();
        if (r101 == 0) goto L10;
        Logging.e("GlGenericDrawer", "drawYuv glBindTexture error: " + r101);
        return;
    L10:
        GLES20.glViewport(r114, r115, r116, r117);
        GLES20.glDrawArrays(5, 0, 4);
        int r102 = 0;
    L11:
        if (r102 >= 3) goto L13;
        GLES20.glActiveTexture(r102 + 33984);
        GLES20.glBindTexture(3553, 0);
        r102 = r102 + 1;
        goto L11
    L13:
        GlUtil.checkNoGLES2Error("drawYuv done");
    }

    @Override // com.bytedance.bmmt.video.RendererCommon.GlDrawer
    public void drawOes(int r100, float[] r101, int r102, int r103, int r104, int r105, int r106, int r107, FilterType r108, int r110, int r111, int r112, int r113) {
        prepareTexAndPosCoord(r102, r103, r112, r113);
        drawOes(r100, r101, r102, r103, r104, r105, r106, r107, r108, r110, r111);
    }

    @Override // com.bytedance.bmmt.video.RendererCommon.GlDrawer
    public void drawRgb(int r100, float[] r101, int r102, int r103, int r104, int r105, int r106, int r107, FilterType r108, int r110, int r111, int r112, int r113) {
        prepareTexAndPosCoord(r102, r103, r112, r113);
        drawRgb(r100, r101, r102, r103, r104, r105, r106, r107, r108, r110, r111);
    }

    @Override // com.bytedance.bmmt.video.RendererCommon.GlDrawer
    public void drawYuv(int[] r100, float[] r101, int r102, int r103, int r104, int r105, int r106, int r107, FilterType r108, int r110, int r111, int r112, int r113) {
        prepareTexAndPosCoord(r102, r103, r112, r113);
        drawYuv(r100, r101, r102, r103, r104, r105, r106, r107, r108, r110, r111);
    }
}
