package com.larus.im.internal.jni.model;

import android.opengl.EGL14;
import android.opengl.EGLConfig;
import android.opengl.EGLContext;
import android.opengl.EGLDisplay;
import android.opengl.EGLSurface;
import android.opengl.GLES20;
import com.ss.android.lark.chameleon.container.webcontainer.report.ChameleonOpenTracker;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes29.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0014\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001\u001dB\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003JN\u0010\u000b\u001a\u0004\u0018\u00010\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u000f\u001a\u00020\u00072\b\u0010\u0010\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0012\u001a\u00020\u00072\u0006\u0010\u0013\u001a\u00020\u00072\u0006\u0010\u0014\u001a\u00020\u00072\u0006\u0010\u0015\u001a\u00020\u00072\u0006\u0010\u0016\u001a\u00020\u0007H\u0007J\u0010\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u0011H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u001e"}, d2 = {"Lcom/larus/im/internal/jni/model/OmniVideoFrameSelectorBridge;", "", "<init>", "()V", "TAG", "", "PIXEL_FORMAT_OES", "", "lock", "renderer", "Lcom/larus/im/internal/jni/model/OmniVideoFrameSelectorBridge$TextureRgbaRenderer;", "extractRGBA", "", "sharedContext", "Landroid/opengl/EGLContext;", "textureId", "textureMatrix", "", "width", "height", "pixelFormat", "outputWidth", "outputHeight", "createFloatBuffer", "Ljava/nio/FloatBuffer;", "data", "VERTEX_SHADER", "FRAGMENT_SHADER_2D", "FRAGMENT_SHADER_OES", "TextureRgbaRenderer", "omnisdk-av_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class OmniVideoFrameSelectorBridge {
    private static final String FRAGMENT_SHADER_2D = "\n        precision mediump float;\n        varying vec2 vTexCoord;\n        uniform sampler2D uTexture;\n        void main() {\n            vec4 color = texture2D(uTexture, vTexCoord);\n            gl_FragColor = color;\n        }\n    ";
    private static final String FRAGMENT_SHADER_OES = "\n        #extension GL_OES_EGL_image_external : require\n        precision mediump float;\n        varying vec2 vTexCoord;\n        uniform samplerExternalOES uTexture;\n        void main() {\n            vec4 color = texture2D(uTexture, vTexCoord);\n            gl_FragColor = color;\n        }\n    ";
    public static final OmniVideoFrameSelectorBridge INSTANCE = null;
    private static final int PIXEL_FORMAT_OES = 36197;
    private static final String TAG = "OmniVideoFrameSelector";
    private static final String VERTEX_SHADER = "\n        attribute vec4 aPosition;\n        attribute vec2 aTexCoord;\n        uniform mat4 uTexMatrix;\n        varying vec2 vTexCoord;\n        void main() {\n            gl_Position = aPosition;\n            vec4 mapped = uTexMatrix * vec4(aTexCoord, 0.0, 1.0);\n            vTexCoord = mapped.xy;\n        }\n    ";
    private static final Object lock = null;
    private static final TextureRgbaRenderer renderer = null;

    @Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0014\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J:\u0010\u0017\u001a\u0004\u0018\u00010\u00182\u0006\u0010\f\u001a\u00020\u00072\u0006\u0010\u0019\u001a\u00020\u000e2\b\u0010\u001a\u001a\u0004\u0018\u00010\u00162\u0006\u0010\u001b\u001a\u00020\u000e2\u0006\u0010\u001c\u001a\u00020\u000e2\u0006\u0010\u001d\u001a\u00020\u000eJ \u0010\u001e\u001a\u00020\u001f2\u0006\u0010\f\u001a\u00020\u00072\u0006\u0010 \u001a\u00020\u000e2\u0006\u0010!\u001a\u00020\u000eH\u0002J\b\u0010\"\u001a\u00020\u000eH\u0002J\b\u0010#\u001a\u00020\u000eH\u0002J\b\u0010$\u001a\u00020\u001fH\u0002J\u0018\u0010%\u001a\u00020\u000e2\u0006\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020'H\u0002J\u0018\u0010)\u001a\u00020\u000e2\u0006\u0010*\u001a\u00020\u000e2\u0006\u0010+\u001a\u00020'H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006,"}, d2 = {"Lcom/larus/im/internal/jni/model/OmniVideoFrameSelectorBridge$TextureRgbaRenderer;", "", "<init>", "()V", "display", "Landroid/opengl/EGLDisplay;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/opengl/EGLContext;", "surface", "Landroid/opengl/EGLSurface;", "config", "Landroid/opengl/EGLConfig;", "sharedContext", "surfaceWidth", "", "surfaceHeight", "oesProgram", "texture2DProgram", "vertexBuffer", "Ljava/nio/FloatBuffer;", "texCoordBuffer", "identityMatrix", "", ChameleonOpenTracker.Stage.RENDER, "", "textureId", "textureMatrix", "pixelFormat", "outputWidth", "outputHeight", "ensureEgl", "", "width", "height", "ensureOesProgram", "ensureTexture2DProgram", "release", "createProgram", "vertexSource", "", "fragmentSource", "compileShader", "type", "source", "omnisdk-av_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class TextureRgbaRenderer {
        private EGLConfig config;
        private EGLContext context;
        private EGLDisplay display;
        private float[] identityMatrix;
        private int oesProgram;
        private EGLContext sharedContext;
        private EGLSurface surface;
        private int surfaceHeight;
        private int surfaceWidth;
        private FloatBuffer texCoordBuffer;
        private int texture2DProgram;
        private FloatBuffer vertexBuffer;

        private final int ensureOesProgram() {
            if (this.oesProgram != 0) goto L6;
            this.oesProgram = createProgram(OmniVideoFrameSelectorBridge.VERTEX_SHADER, OmniVideoFrameSelectorBridge.FRAGMENT_SHADER_OES);
        L6:
            return this.oesProgram;
        }

        private final int ensureTexture2DProgram() {
            if (this.texture2DProgram != 0) goto L6;
            this.texture2DProgram = createProgram(OmniVideoFrameSelectorBridge.VERTEX_SHADER, OmniVideoFrameSelectorBridge.FRAGMENT_SHADER_2D);
        L6:
            return this.texture2DProgram;
        }

        private final void release() {
            EGLDisplay r100 = this.display;
            if (r100 == EGL14.EGL_NO_DISPLAY) goto L11;
            EGLSurface r101 = EGL14.EGL_NO_SURFACE;
            EGL14.eglMakeCurrent(r100, r101, r101, EGL14.EGL_NO_CONTEXT);
            EGLSurface r102 = this.surface;
            if (r102 == EGL14.EGL_NO_SURFACE) goto L7;
            EGL14.eglDestroySurface(this.display, r102);
        L7:
            EGLContext r103 = this.context;
            if (r103 == EGL14.EGL_NO_CONTEXT) goto L10;
            EGL14.eglDestroyContext(this.display, r103);
        L10:
            EGL14.eglTerminate(this.display);
        L11:
            this.display = EGL14.EGL_NO_DISPLAY;
            this.context = EGL14.EGL_NO_CONTEXT;
            this.surface = EGL14.EGL_NO_SURFACE;
            this.sharedContext = null;
            this.config = null;
            this.surfaceWidth = 0;
            this.surfaceHeight = 0;
        }

        public TextureRgbaRenderer() {
            this.display = EGL14.EGL_NO_DISPLAY;
            this.context = EGL14.EGL_NO_CONTEXT;
            this.surface = EGL14.EGL_NO_SURFACE;
            OmniVideoFrameSelectorBridge r100 = OmniVideoFrameSelectorBridge.INSTANCE;
            this.vertexBuffer = OmniVideoFrameSelectorBridge.access$createFloatBuffer(r100, new float[]{-1.0f, -1.0f, 1.0f, -1.0f, -1.0f, 1.0f, 1.0f, 1.0f});
            this.texCoordBuffer = OmniVideoFrameSelectorBridge.access$createFloatBuffer(r100, new float[]{0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 1.0f, 1.0f, 1.0f});
            this.identityMatrix = new float[]{1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f};
        }

        private final int compileShader(int r100, String r101) {
            int r102 = GLES20.glCreateShader(r100);
            GLES20.glShaderSource(r102, r101);
            GLES20.glCompileShader(r102);
            int[] r103 = new int[1];
            GLES20.glGetShaderiv(r102, 35713, r103, 0);
            if (r103[0] != 0) goto L6;
            GLES20.glDeleteShader(r102);
            return 0;
        L6:
            return r102;
        }

        private final int createProgram(String r100, String r101) {
            int r102 = compileShader(35633, r100);
            int r103 = compileShader(35632, r101);
            if (r102 == 0) goto L11;
            if (r103 == 0) goto L11;
            int r104 = GLES20.glCreateProgram();
            GLES20.glAttachShader(r104, r102);
            GLES20.glAttachShader(r104, r103);
            GLES20.glLinkProgram(r104);
            int[] r105 = new int[1];
            GLES20.glGetProgramiv(r104, 35714, r105, 0);
            GLES20.glDeleteShader(r102);
            GLES20.glDeleteShader(r103);
            if (r105[0] != 0) goto L10;
            GLES20.glDeleteProgram(r104);
            return 0;
        L10:
            return r104;
        L11:
            return 0;
        }

        private final void ensureEgl(EGLContext r110, int r111, int r210) {
            if (this.display != EGL14.EGL_NO_DISPLAY) goto L5;
        L15:
            release();
            EGLDisplay r100 = EGL14.eglGetDisplay(0);
            this.display = r100;
            if (r100 == EGL14.EGL_NO_DISPLAY) goto L38;
            int[] r101 = new int[2];
            if (EGL14.eglInitialize(r100, r101, 0, r101, 1) == false) goto L36;
            EGLConfig[] r102 = new EGLConfig[1];
            int[] r103 = new int[1];
            if (EGL14.eglChooseConfig(this.display, new int[]{12324, 8, 12323, 8, 12322, 8, 12321, 8, 12352, 4, 12339, 1, 12344}, 0, r102, 0, 1, r103, 0) == false) goto L34;
            if (r103[0] <= 0) goto L34;
            EGLConfig r104 = r102[0];
            this.config = r104;
            EGLContext r105 = EGL14.eglCreateContext(this.display, r104, r110, new int[]{12440, 2, 12344}, 0);
            this.context = r105;
            if (r105 == EGL14.EGL_NO_CONTEXT) goto L32;
            EGLSurface r106 = EGL14.eglCreatePbufferSurface(this.display, this.config, new int[]{12375, r111, 12374, r210, 12344}, 0);
            this.surface = r106;
            if (r106 == EGL14.EGL_NO_SURFACE) goto L30;
            this.sharedContext = r110;
            this.surfaceWidth = r111;
            this.surfaceHeight = r210;
            return;
        L30:
            throw new IllegalStateException("eglCreatePbufferSurface failed");
        L32:
            throw new IllegalStateException("eglCreateContext failed");
        L34:
            throw new IllegalStateException("eglChooseConfig failed");
        L36:
            throw new IllegalStateException("eglInitialize failed");
        L38:
            throw new IllegalStateException("eglGetDisplay failed");
        L5:
            if (this.context == EGL14.EGL_NO_CONTEXT) goto L15;
            if (this.surface == EGL14.EGL_NO_SURFACE) goto L15;
            if (Intrinsics.areEqual(this.sharedContext, r110) == false) goto L15;
            if (this.surfaceWidth != r111) goto L15;
            if (this.surfaceHeight != r210) goto L15;
        }

        public final byte[] render(EGLContext r110, int r111, float[] r210, int r211, int r212, int r213) {
            float[] r100 = r210;
            Intrinsics.checkNotNullParameter(r110, "sharedContext");
            ensureEgl(r110, r212, r213);
            EGLDisplay r101 = this.display;
            EGLSurface r102 = this.surface;
            if (EGL14.eglMakeCurrent(r101, r102, r102, this.context) == true) goto L5;
            return null;
        L5:
            GLES20.glViewport(0, 0, r212, r213);
            GLES20.glDisable(3042);
            GLES20.glClearColor(0.0f, 0.0f, 0.0f, 1.0f);
            GLES20.glClear(16384);
            if (r211 != OmniVideoFrameSelectorBridge.PIXEL_FORMAT_OES) goto L8;
            int r103 = ensureOesProgram();
        L9:
            if (r103 != 0) goto L11;
            return null;
        L11:
            GLES20.glUseProgram(r103);
            int r112 = GLES20.glGetAttribLocation(r103, "aPosition");
            int r104 = GLES20.glGetAttribLocation(r103, "aTexCoord");
            int r113 = GLES20.glGetUniformLocation(r103, "uTexMatrix");
            int r105 = GLES20.glGetUniformLocation(r103, "uTexture");
            this.vertexBuffer.position(0);
            GLES20.glEnableVertexAttribArray(r112);
            GLES20.glVertexAttribPointer(r112, 2, 5126, false, 0, this.vertexBuffer);
            this.texCoordBuffer.position(0);
            GLES20.glEnableVertexAttribArray(r104);
            GLES20.glVertexAttribPointer(r104, 2, 5126, false, 0, this.texCoordBuffer);
            if (r100 != null) goto L14;
        L16:
            r100 = this.identityMatrix;
        L17:
            GLES20.glUniformMatrix4fv(r113, 1, false, r100, 0);
            int r106 = OmniVideoFrameSelectorBridge.PIXEL_FORMAT_OES;
            if (r211 == OmniVideoFrameSelectorBridge.PIXEL_FORMAT_OES) goto L21;
            r106 = 3553;
        L21:
            GLES20.glActiveTexture(33984);
            GLES20.glBindTexture(r106, r111);
            GLES20.glUniform1i(r105, 0);
            GLES20.glDrawArrays(5, 0, 4);
            GLES20.glBindTexture(r106, 0);
            ByteBuffer r107 = ByteBuffer.allocateDirect((r212 * r213) * 4).order(ByteOrder.nativeOrder());
            GLES20.glReadPixels(0, 0, r212, r213, 6408, 5121, r107);
            if (GLES20.glGetError() == 0) goto L25;
            return null;
        L25:
            byte[] r108 = new byte[r107.capacity()];
            r107.position(0);
            r107.get(r108);
            return r108;
        L14:
            if (r100.length < 16) goto L16;
        L8:
            r103 = ensureTexture2DProgram();
            goto L9
        }
    }

    private OmniVideoFrameSelectorBridge() {
    }

    static {
        INSTANCE = new OmniVideoFrameSelectorBridge();
        lock = new Object();
        renderer = new TextureRgbaRenderer();
    }

    private final FloatBuffer createFloatBuffer(float[] r100) {
        FloatBuffer r101 = ByteBuffer.allocateDirect(r100.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
        r101.put(r100);
        r101.position(0);
        return r101;
    }

    public static final /* synthetic */ FloatBuffer access$createFloatBuffer(OmniVideoFrameSelectorBridge r100, float[] r101) {
        return r100.createFloatBuffer(r101);
    }

    @JvmStatic
    public static final byte[] extractRGBA(EGLContext r100, int r101, float[] r110, int r111, int r112, int r113, int r114, int r115) {
        byte[] r102 = null;
        if (r100 == null) goto L14;
        if (r101 <= 0) goto L14;
        if (r111 <= 0) goto L14;
        if (r112 <= 0) goto L14;
        if (r114 <= 0) goto L14;
        if (r115 <= 0) goto L14;
        Object r116 = lock;
        monitor-enter(r116);
        r102 = renderer.render(r100, r101, r110, r113, r114, r115);     // Catch: Throwable -> L15
    L13:
        monitor-exit(r116);
    L14:
        return r102;
    }
}
