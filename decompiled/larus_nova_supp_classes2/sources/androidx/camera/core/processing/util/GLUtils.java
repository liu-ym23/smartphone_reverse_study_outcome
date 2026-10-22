package androidx.camera.core.processing.util;

import android.opengl.EGL14;
import android.opengl.EGLConfig;
import android.opengl.EGLDisplay;
import android.opengl.EGLSurface;
import android.opengl.GLES20;
import android.opengl.Matrix;
import android.util.Size;
import android.view.Surface;
import androidx.camera.core.DynamicRange;
import androidx.camera.core.Logger;
import androidx.camera.core.processing.ShaderProvider;
import androidx.compose.material3.MenuKt;
import androidx.core.util.Preconditions;
import com.bytedance.mt.protector.impl.PatternProtector;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.regex.Matcher;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
public final class GLUtils {
    public static final String BLANK_FRAGMENT_SHADER = "precision mediump float;\nuniform float uAlphaScale;\nvoid main() {\n    gl_FragColor = vec4(0.0, 0.0, 0.0, uAlphaScale);\n}\n";
    public static final String BLANK_VERTEX_SHADER = "uniform mat4 uTransMatrix;\nattribute vec4 aPosition;\nvoid main() {\n    gl_Position = uTransMatrix * aPosition;\n}\n";
    public static final String DEFAULT_VERTEX_SHADER = null;
    public static final int EGL_GL_COLORSPACE_BT2020_HLG_EXT = 13632;
    public static final int EGL_GL_COLORSPACE_KHR = 12445;
    public static final int[] EMPTY_ATTRIBS = null;
    public static final String HDR_VERTEX_SHADER = null;
    public static final int[] HLG_SURFACE_ATTRIBS = null;
    public static final OutputSurface NO_OUTPUT_SURFACE = null;
    public static final int PIXEL_STRIDE = 4;
    private static final ShaderProvider SHADER_PROVIDER_DEFAULT = null;
    private static final ShaderProvider SHADER_PROVIDER_HDR_DEFAULT = null;
    private static final ShaderProvider SHADER_PROVIDER_HDR_YUV = null;
    public static final int SIZEOF_FLOAT = 4;
    public static final String TAG = "GLUtils";
    public static final FloatBuffer TEX_BUF = null;
    public static final float[] TEX_COORDS = null;
    public static final String VAR_TEXTURE = "sTexture";
    public static final String VAR_TEXTURE_COORD = "vTextureCoord";
    public static final String VERSION_UNKNOWN = "0.0";
    public static final FloatBuffer VERTEX_BUF = null;
    public static final float[] VERTEX_COORDS = null;

    public static class BlankShaderProgram extends Program2D {
        public BlankShaderProgram() {
            super(GLUtils.BLANK_VERTEX_SHADER, GLUtils.BLANK_FRAGMENT_SHADER);
        }
    }

    public static final enum InputFormat extends Enum<InputFormat> {
        private static final /* synthetic */ InputFormat[] $VALUES = null;
        public static final InputFormat DEFAULT = null;
        public static final InputFormat UNKNOWN = null;
        public static final InputFormat YUV = null;

        private static /* synthetic */ InputFormat[] $values() {
            return new InputFormat[]{UNKNOWN, DEFAULT, YUV};
        }

        static {
            UNKNOWN = new InputFormat("UNKNOWN", 0);
            DEFAULT = new InputFormat("DEFAULT", 1);
            YUV = new InputFormat("YUV", 2);
            $VALUES = $values();
        }

        public static InputFormat[] values() {
            return (InputFormat[]) $VALUES.clone();
        }

        public static InputFormat valueOf(String r1) {
            return (InputFormat) a.a(InputFormat.class, r1);
        }

        private InputFormat(String r1, int r2) {
            super(r1, r2);
        }
    }

    public static abstract class Program2D {
        protected int mAlphaScaleLoc;
        protected int mPositionLoc;
        protected int mProgramHandle;
        protected int mTransMatrixLoc;

        private void loadLocations() {
            int r0 = GLES20.glGetAttribLocation(this.mProgramHandle, "aPosition");
            this.mPositionLoc = r0;
            GLUtils.checkLocationOrThrow(r0, "aPosition");
            int r1 = GLES20.glGetUniformLocation(this.mProgramHandle, "uTransMatrix");
            this.mTransMatrixLoc = r1;
            GLUtils.checkLocationOrThrow(r1, "uTransMatrix");
            int r2 = GLES20.glGetUniformLocation(this.mProgramHandle, "uAlphaScale");
            this.mAlphaScaleLoc = r2;
            GLUtils.checkLocationOrThrow(r2, "uAlphaScale");
        }

        public void delete() {
            GLES20.glDeleteProgram(this.mProgramHandle);
        }

        public void use() {
            GLES20.glUseProgram(this.mProgramHandle);
            GLUtils.checkGlErrorOrThrow("glUseProgram");
            GLES20.glEnableVertexAttribArray(this.mPositionLoc);
            GLUtils.checkGlErrorOrThrow("glEnableVertexAttribArray");
            GLES20.glVertexAttribPointer(this.mPositionLoc, 2, 5126, false, 0, GLUtils.VERTEX_BUF);
            GLUtils.checkGlErrorOrThrow("glVertexAttribPointer");
            updateTransformMatrix(GLUtils.create4x4IdentityMatrix());
            updateAlpha(1.0f);
        }

        public static /* synthetic */ void access$100(Program2D r0) {
            r0.loadLocations();
        }

        public void updateAlpha(float r2) {
            GLES20.glUniform1f(this.mAlphaScaleLoc, r2);
            GLUtils.checkGlErrorOrThrow("glUniform1f");
        }

        public void updateTransformMatrix(float[] r4) {
            GLES20.glUniformMatrix4fv(this.mTransMatrixLoc, 1, false, r4, 0);
            GLUtils.checkGlErrorOrThrow("glUniformMatrix4fv");
        }

        public Program2D(String r8, String r9) {
            this.mTransMatrixLoc = -1;
            this.mAlphaScaleLoc = -1;
            this.mPositionLoc = -1;
            int r10 = GLUtils.loadShader(35633, r8);     // Catch: Throwable -> L26 IllegalStateException -> L28
            int r11 = GLUtils.loadShader(35632, r9);     // Catch: IllegalArgumentException -> L22 IllegalStateException -> L24
            int r3 = GLES20.glCreateProgram();     // Catch: IllegalArgumentException -> L18 IllegalStateException -> L20
        L41:
            GLUtils.checkGlErrorOrThrow("glCreateProgram");     // Catch: IllegalArgumentException -> L14 IllegalStateException -> L16
            GLES20.glAttachShader(r3, r10);     // Catch: IllegalArgumentException -> L14 IllegalStateException -> L16
            GLUtils.checkGlErrorOrThrow("glAttachShader");     // Catch: IllegalArgumentException -> L14 IllegalStateException -> L16
            GLES20.glAttachShader(r3, r11);     // Catch: IllegalArgumentException -> L14 IllegalStateException -> L16
            GLUtils.checkGlErrorOrThrow("glAttachShader");     // Catch: IllegalArgumentException -> L14 IllegalStateException -> L16
            GLES20.glLinkProgram(r3);     // Catch: IllegalArgumentException -> L14 IllegalStateException -> L16
            int[] r4 = new int[1];     // Catch: IllegalArgumentException -> L14 IllegalStateException -> L16
            GLES20.glGetProgramiv(r3, 35714, r4, 0);     // Catch: IllegalArgumentException -> L14 IllegalStateException -> L16
            if (r4[0] != 1) goto L13;
            this.mProgramHandle = r3;     // Catch: IllegalArgumentException -> L14 IllegalStateException -> L16
            loadLocations();
            return;
        L13:
            throw new IllegalStateException("Could not link program: " + GLES20.glGetProgramInfoLog(r3));     // Catch: IllegalArgumentException -> L14 IllegalStateException -> L16
        L14:
            e = e;
        L32:
            if (r10 == (-1)) goto L34;
            GLES20.glDeleteShader(r10);
        L34:
            if (r11 == (-1)) goto L36;
            GLES20.glDeleteShader(r11);
        L36:
            if (r3 == (-1)) goto L38;
            GLES20.glDeleteProgram(r3);
        L38:
            throw e;
        L16:
            e = e;
        L18:
            e = e;
        L31:
            r3 = -1;
        L20:
            e = e;
            goto L31
        L22:
            e = e;
        L30:
            r11 = -1;
        L24:
            e = e;
        L26:
            e = e;
            r10 = -1;
            goto L30
        }
    }

    public static class SamplerShaderProgram extends Program2D {
        private int mSamplerLoc;
        private int mTexCoordLoc;
        private int mTexMatrixLoc;

        private void loadLocations() {
            Program2D.access$100(this);
            int r0 = GLES20.glGetUniformLocation(this.mProgramHandle, GLUtils.VAR_TEXTURE);
            this.mSamplerLoc = r0;
            GLUtils.checkLocationOrThrow(r0, GLUtils.VAR_TEXTURE);
            int r1 = GLES20.glGetAttribLocation(this.mProgramHandle, "aTextureCoord");
            this.mTexCoordLoc = r1;
            GLUtils.checkLocationOrThrow(r1, "aTextureCoord");
            int r2 = GLES20.glGetUniformLocation(this.mProgramHandle, "uTexMatrix");
            this.mTexMatrixLoc = r2;
            GLUtils.checkLocationOrThrow(r2, "uTexMatrix");
        }

        @Override // androidx.camera.core.processing.util.GLUtils.Program2D
        public void use() {
            super.use();
            GLES20.glUniform1i(this.mSamplerLoc, 0);
            GLES20.glEnableVertexAttribArray(this.mTexCoordLoc);
            GLUtils.checkGlErrorOrThrow("glEnableVertexAttribArray");
            GLES20.glVertexAttribPointer(this.mTexCoordLoc, 2, 5126, false, 0, GLUtils.TEX_BUF);
            GLUtils.checkGlErrorOrThrow("glVertexAttribPointer");
        }

        public void updateTextureMatrix(float[] r4) {
            GLES20.glUniformMatrix4fv(this.mTexMatrixLoc, 1, false, r4, 0);
            GLUtils.checkGlErrorOrThrow("glUniformMatrix4fv");
        }

        public SamplerShaderProgram(DynamicRange r1, ShaderProvider r2) {
            if (r1.is10BitHdr() == false) goto L5;
            String r3 = GLUtils.HDR_VERTEX_SHADER;
        L6:
            super(r3, GLUtils.access$000(r2));
            this.mSamplerLoc = -1;
            this.mTexMatrixLoc = -1;
            this.mTexCoordLoc = -1;
            loadLocations();
            return;
        L5:
            r3 = GLUtils.DEFAULT_VERTEX_SHADER;
            goto L6
        }

        private static ShaderProvider resolveDefaultShaderProvider(DynamicRange r2, InputFormat r3) {
            if (r2.is10BitHdr() == false) goto L15;
            if (r3 == InputFormat.UNKNOWN) goto L7;
            boolean r4 = true;
        L8:
            Preconditions.checkArgument(r4, "No default sampler shader available for" + r3);
            if (r3 != InputFormat.YUV) goto L13;
            return GLUtils.access$200();
        L13:
            return GLUtils.access$300();
        L7:
            r4 = false;
            goto L8
        L15:
            return GLUtils.access$400();
        }

        public SamplerShaderProgram(DynamicRange r1, InputFormat r2) {
            this(r1, resolveDefaultShaderProvider(r1, r2));
        }
    }

    static {
        EMPTY_ATTRIBS = new int[]{12344};
        HLG_SURFACE_ATTRIBS = new int[]{EGL_GL_COLORSPACE_KHR, EGL_GL_COLORSPACE_BT2020_HLG_EXT, 12344};
        Locale r1 = Locale.US;
        DEFAULT_VERTEX_SHADER = String.format(r1, "uniform mat4 uTexMatrix;\nuniform mat4 uTransMatrix;\nattribute vec4 aPosition;\nattribute vec4 aTextureCoord;\nvarying vec2 %s;\nvoid main() {\n    gl_Position = uTransMatrix * aPosition;\n    %s = (uTexMatrix * aTextureCoord).xy;\n}\n", new Object[]{VAR_TEXTURE_COORD, VAR_TEXTURE_COORD});
        HDR_VERTEX_SHADER = String.format(r1, "#version 300 es\nin vec4 aPosition;\nin vec4 aTextureCoord;\nuniform mat4 uTexMatrix;\nuniform mat4 uTransMatrix;\nout vec2 %s;\nvoid main() {\n  gl_Position = uTransMatrix * aPosition;\n  %s = (uTexMatrix * aTextureCoord).xy;\n}\n", new Object[]{VAR_TEXTURE_COORD, VAR_TEXTURE_COORD});
        SHADER_PROVIDER_DEFAULT = new AnonymousClass1();
        SHADER_PROVIDER_HDR_DEFAULT = new AnonymousClass2();
        SHADER_PROVIDER_HDR_YUV = new AnonymousClass3();
        float[] r2 = {-1.0f, -1.0f, 1.0f, -1.0f, -1.0f, 1.0f, 1.0f, 1.0f};
        VERTEX_COORDS = r2;
        VERTEX_BUF = createFloatBuffer(r2);
        float[] r0 = {MenuKt.ClosedAlphaTarget, MenuKt.ClosedAlphaTarget, 1.0f, MenuKt.ClosedAlphaTarget, MenuKt.ClosedAlphaTarget, 1.0f, 1.0f, 1.0f};
        TEX_COORDS = r0;
        TEX_BUF = createFloatBuffer(r0);
        NO_OUTPUT_SURFACE = OutputSurface.of(EGL14.EGL_NO_SURFACE, 0, 0);
    }

    public static int createTexture() {
        int[] r1 = new int[1];
        GLES20.glGenTextures(1, r1, 0);
        checkGlErrorOrThrow("glGenTextures");
        int r0 = r1[0];
        GLES20.glBindTexture(36197, r0);
        checkGlErrorOrThrow("glBindTexture " + r0);
        GLES20.glTexParameteri(36197, 10241, 9728);
        GLES20.glTexParameteri(36197, 10240, 9729);
        GLES20.glTexParameteri(36197, 10242, 33071);
        GLES20.glTexParameteri(36197, 10243, 33071);
        checkGlErrorOrThrow("glTexParameter");
        return r0;
    }

    public static int generateFbo() {
        int[] r1 = new int[1];
        GLES20.glGenFramebuffers(1, r1, 0);
        checkGlErrorOrThrow("glGenFramebuffers");
        return r1[0];
    }

    public static int generateTexture() {
        int[] r1 = new int[1];
        GLES20.glGenTextures(1, r1, 0);
        checkGlErrorOrThrow("glGenTextures");
        return r1[0];
    }

    public static float[] create4x4IdentityMatrix() {
        float[] r0 = new float[16];
        Matrix.setIdentityM(r0, 0);
        return r0;
    }

    public static String getGlVersionNumber() {
        Matcher r0 = PatternProtector.compile("OpenGL ES ([0-9]+)\\.([0-9]+).*").matcher(GLES20.glGetString(7938));
        if (r0.find() == true) goto L5;
        return VERSION_UNKNOWN;
    L5:
        return ((String) Preconditions.checkNotNull(r0.group(1))) + "." + ((String) Preconditions.checkNotNull(r0.group(2)));
    }

    private GLUtils() {
    }

    public static /* synthetic */ ShaderProvider access$200() {
        return SHADER_PROVIDER_HDR_YUV;
    }

    public static /* synthetic */ ShaderProvider access$300() {
        return SHADER_PROVIDER_HDR_DEFAULT;
    }

    public static /* synthetic */ ShaderProvider access$400() {
        return SHADER_PROVIDER_DEFAULT;
    }

    public static /* synthetic */ String access$000(ShaderProvider r0) {
        return getFragmentShaderSource(r0);
    }

    public static void checkEglErrorOrLog(String r2) {
        checkEglErrorOrThrow(r2);     // Catch: IllegalStateException -> L4
        return;
    L4:
        e = move-exception;
        Logger.e(TAG, e.toString(), e);
    }

    public static void checkEglErrorOrThrow(String r3) {
        int r0 = EGL14.eglGetError();
        if (r0 != 12288) goto L6;
        return;
    L6:
        throw new IllegalStateException(r3 + ": EGL error: 0x" + Integer.toHexString(r0));
    }

    public static void checkGlErrorOrThrow(String r3) {
        int r0 = GLES20.glGetError();
        if (r0 != 0) goto L6;
        return;
    L6:
        throw new IllegalStateException(r3 + ": GL error 0x" + Integer.toHexString(r0));
    }

    public static void checkGlThreadOrThrow(Thread r1) {
        if (r1 != ThreadMethodProxy.currentThread()) goto L5;
        boolean r2 = true;
    L6:
        Preconditions.checkState(r2, "Method call must be called on the GL thread.");
        return;
    L5:
        r2 = false;
        goto L6
    }

    public static FloatBuffer createFloatBuffer(float[] r2) {
        ByteBuffer r0 = ByteBuffer.allocateDirect(r2.length * 4);
        r0.order(ByteOrder.nativeOrder());
        FloatBuffer r1 = r0.asFloatBuffer();
        r1.put(r2);
        r1.position(0);
        return r1;
    }

    public static void deleteFbo(int r3) {
        GLES20.glDeleteFramebuffers(1, new int[]{r3}, 0);
        checkGlErrorOrThrow("glDeleteFramebuffers");
    }

    public static void deleteTexture(int r3) {
        GLES20.glDeleteTextures(1, new int[]{r3}, 0);
        checkGlErrorOrThrow("glDeleteTextures");
    }

    private static String getFragmentShaderSource(ShaderProvider r2) {
        String r3 = r2.createFragmentShader(VAR_TEXTURE, VAR_TEXTURE_COORD);     // Catch: Throwable -> L12
        if (r3 == null) goto L11;
        if (r3.contains(VAR_TEXTURE_COORD) == false) goto L11;
        if (r3.contains(VAR_TEXTURE) == false) goto L11;
        return r3;
    L11:
        throw new IllegalArgumentException("Invalid fragment shader");     // Catch: Throwable -> L12
    L12:
        th = move-exception;
        if ((th instanceof IllegalArgumentException) == false) goto L17;
        throw th;
    L17:
        throw new IllegalArgumentException("Unable retrieve fragment shader source", th);
    }

    public static void checkInitializedOrThrow(AtomicBoolean r0, boolean r1) {
        if (r1 != r0.get()) goto L5;
        boolean r2 = true;
    L6:
        if (r1 == false) goto L8;
        String r3 = "OpenGlRenderer is not initialized";
    L9:
        Preconditions.checkState(r2, r3);
        return;
    L8:
        r3 = "OpenGlRenderer is already initialized";
        goto L9
    L5:
        r2 = false;
        goto L6
    }

    public static void checkLocationOrThrow(int r2, String r3) {
        if (r2 < 0) goto L5;
        return;
    L5:
        throw new IllegalStateException("Unable to locate '" + r3 + "' in program");
    }

    public static int[] chooseSurfaceAttrib(String r2, DynamicRange r3) {
        int[] r0 = EMPTY_ATTRIBS;
        if (r3.getEncoding() == 3) goto L5;
        return r0;
    L5:
        if (r2.contains("EGL_EXT_gl_colorspace_bt2020_hlg") == true) goto L10;
        Logger.w(TAG, "Dynamic range uses HLG encoding, but device does not support EGL_EXT_gl_colorspace_bt2020_hlg.Fallback to default colorspace.");
        return r0;
    L10:
        return HLG_SURFACE_ATTRIBS;
    }

    public static Map<InputFormat, Program2D> createPrograms(DynamicRange r10, Map<InputFormat, ShaderProvider> r11) {
        HashMap r0 = new HashMap();
        InputFormat[] r1 = InputFormat.values();
        int r2 = r1.length;
        int r4 = 0;
    L3:
        if (r4 >= r2) goto L25;
        InputFormat r5 = r1[r4];
        ShaderProvider r6 = r11.get(r5);
        if (r6 == null) goto L8;
        Object r7 = new SamplerShaderProgram(r10, r6);
    L24:
        Objects.toString(r5);
        r7.toString();
        r0.put(r5, r7);
        r4 = r4 + 1;
        goto L3
    L8:
        if (r5 == InputFormat.YUV) goto L23;
        InputFormat r8 = InputFormat.DEFAULT;
        if (r5 == r8) goto L23;
        if (r5 != InputFormat.UNKNOWN) goto L15;
        boolean r9 = true;
    L16:
        Preconditions.checkState(r9, "Unhandled input format: " + r5);
        if (r10.is10BitHdr() == false) goto L19;
        r7 = new BlankShaderProgram();
        goto L24
    L19:
        ShaderProvider r12 = r11.get(r8);
        if (r12 == null) goto L22;
        r7 = new SamplerShaderProgram(r10, r12);
        goto L24
    L22:
        r7 = new SamplerShaderProgram(r10, r8);
        goto L24
    L15:
        r9 = false;
    L23:
        r7 = new SamplerShaderProgram(r10, r5);
        goto L24
    L25:
        return r0;
    }

    public static Size getSurfaceSize(EGLDisplay r2, EGLSurface r3) {
        return new Size(querySurface(r2, r3, 12375), querySurface(r2, r3, 12374));
    }

    public static int loadShader(int r4, String r5) {
        int r0 = GLES20.glCreateShader(r4);
        checkGlErrorOrThrow("glCreateShader type=" + r4);
        GLES20.glShaderSource(r0, r5);
        GLES20.glCompileShader(r0);
        int[] r1 = new int[1];
        GLES20.glGetShaderiv(r0, 35713, r1, 0);
        if (r1[0] == 0) goto L5;
        return r0;
    L5:
        Logger.w(TAG, "Could not compile shader: " + r5);
        GLES20.glDeleteShader(r0);
        throw new IllegalStateException("Could not compile shader type " + r4 + ":" + GLES20.glGetShaderInfoLog(r0));
    }

    public static int querySurface(EGLDisplay r2, EGLSurface r3, int r4) {
        int[] r0 = new int[1];
        EGL14.eglQuerySurface(r2, r3, r4, r0, 0);
        return r0[0];
    }

    public static EGLSurface createPBufferSurface(EGLDisplay r3, EGLConfig r4, int r5, int r6) {
        EGLSurface r7 = EGL14.eglCreatePbufferSurface(r3, r4, new int[]{12375, r5, 12374, r6, 12344}, 0);
        checkEglErrorOrThrow("eglCreatePbufferSurface");
        if (r7 == null) goto L6;
        return r7;
    L6:
        throw new IllegalStateException("surface was null");
    }

    public static EGLSurface createWindowSurface(EGLDisplay r1, EGLConfig r2, Surface r3, int[] r4) {
        EGLSurface r5 = EGL14.eglCreateWindowSurface(r1, r2, r3, r4, 0);
        checkEglErrorOrThrow("eglCreateWindowSurface");
        if (r5 == null) goto L6;
        return r5;
    L6:
        throw new IllegalStateException("surface was null");
    }
}
