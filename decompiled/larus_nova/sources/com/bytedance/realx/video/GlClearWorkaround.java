package com.bytedance.realx.video;

import android.opengl.GLES20;
import android.os.Build;
import java.nio.FloatBuffer;

/* JADX INFO: loaded from: classes21.dex */
public class GlClearWorkaround {
    private static final String DEFAULT_FRAGMENT_SHADER_STRING = "#ifdef GL_ES\nprecision mediump float;\n#endif\nuniform vec4 u_clear_color;\nvoid main(void) {\n  gl_FragColor = u_clear_color;\n}\n";
    private static final String DEFAULT_VERTEX_SHADER_STRING = "#ifdef GL_ES\nprecision mediump float;\n#endif\nuniform float u_clear_depth;\nattribute vec4 a_position;\nvoid main(void) {\n  gl_Position = vec4(a_position.x, a_position.y, u_clear_depth, 1.0);\n}\n";
    private static final FloatBuffer FULL_RECTANGLE_BUFFER = null;
    private GlShader currentShader;
    private boolean mHasInit;

    public static final enum WORKAROUND_STATUS extends Enum<WORKAROUND_STATUS> {
        private static final /* synthetic */ WORKAROUND_STATUS[] $VALUES = null;
        public static final WORKAROUND_STATUS kStatusDisable = null;
        public static final WORKAROUND_STATUS kStatusEnable = null;
        public static final WORKAROUND_STATUS kStatusUnknown = null;

        static {
            WORKAROUND_STATUS r100 = new WORKAROUND_STATUS("kStatusUnknown", 0);
            kStatusUnknown = r100;
            WORKAROUND_STATUS r101 = new WORKAROUND_STATUS("kStatusEnable", 1);
            kStatusEnable = r101;
            WORKAROUND_STATUS r102 = new WORKAROUND_STATUS("kStatusDisable", 2);
            kStatusDisable = r102;
            $VALUES = new WORKAROUND_STATUS[]{r100, r101, r102};
        }

        public static WORKAROUND_STATUS[] values() {
            return (WORKAROUND_STATUS[]) $VALUES.clone();
        }

        public static WORKAROUND_STATUS valueOf(String r100) {
            return (WORKAROUND_STATUS) r27.a.a(WORKAROUND_STATUS.class, r100);
        }

        private WORKAROUND_STATUS(String r100, int r101) {
            super(r100, r101);
        }
    }

    public synchronized void init() {
        monitor-enter(this);
        this.mHasInit = true;     // Catch: Throwable -> L7
        monitor-exit(this);
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public synchronized void release() {
        monitor-enter(this);
        this.mHasInit = false;     // Catch: Throwable -> L9
        GlShader r100 = this.currentShader;     // Catch: Throwable -> L9
        if (r100 == null) goto L7;
        r100.release();     // Catch: Throwable -> L9
        this.currentShader = null;     // Catch: Throwable -> L9
    L7:
        monitor-exit(this);
        return;
    L9:
        th = move-exception;
        throw th;
    }

    static {
        FULL_RECTANGLE_BUFFER = GlUtil.createFloatBuffer(new float[]{-1.0f, -1.0f, 1.0f, -1.0f, -1.0f, 1.0f, 1.0f, 1.0f});
    }

    private GlShader createShader() {
        return new GlShader(DEFAULT_VERTEX_SHADER_STRING, DEFAULT_FRAGMENT_SHADER_STRING);
    }

    public static WORKAROUND_STATUS isNeedWorkaround() {
        int r100 = Build.VERSION.SDK_INT;
        if (r100 >= 23) goto L7;
        return WORKAROUND_STATUS.kStatusEnable;
    L7:
        if (r100 >= 26) goto L9;
        String r101 = GLES20.glGetString(7936).toLowerCase();
        if (r101.contains("mali") == true) goto L18;
        if (r101.contains("arm") == true) goto L18;
        return WORKAROUND_STATUS.kStatusDisable;
    L18:
        return WORKAROUND_STATUS.kStatusEnable;
    L9:
        return WORKAROUND_STATUS.kStatusDisable;
    }

    public GlClearWorkaround() {
        this.mHasInit = false;
    }

    private void prepareShader() {
        GlShader r100 = createShader();
        this.currentShader = r100;
        r100.useProgram();
        GlUtil.checkNoGLES2Error("Create shader");
        int r101 = r100.getAttribLocation("a_position");
        GLES20.glEnableVertexAttribArray(r101);
        GLES20.glVertexAttribPointer(r101, 2, 5126, false, 0, FULL_RECTANGLE_BUFFER);
        GlUtil.checkNoGLES2Error("Prepare shader");
    }

    public synchronized void clear(int r100, int r101, int r102, float r103, float r104, float r105, float r106, float r110, int r111) {
        monitor-enter(this);
    L24:
        th = move-exception;
        throw th;
    L4:
        if (this.mHasInit == true) goto L8;
        monitor-exit(this);
        return;
    L8:
        if (this.currentShader != null) goto L10;
        prepareShader();     // Catch: Throwable -> L24
    L10:
        this.currentShader.useProgram();     // Catch: Throwable -> L24
        GLES20.glUniform1f(this.currentShader.getUniformLocation("u_clear_depth"), r110);     // Catch: Throwable -> L24
        GLES20.glUniform4f(this.currentShader.getUniformLocation("u_clear_color"), r103, r104, r105, r106);     // Catch: Throwable -> L24
        if ((r102 & 16384) != 0) goto L13;
        GLES20.glColorMask(false, false, false, false);     // Catch: Throwable -> L24
    L13:
        GlUtil.checkNoGLES2Error("before depth test");     // Catch: Throwable -> L24
        if ((r102 & 256) == 0) goto L16;
        GLES20.glEnable(2929);     // Catch: Throwable -> L24
        GLES20.glDepthFunc(519);     // Catch: Throwable -> L24
    L17:
        GlUtil.checkNoGLES2Error("before stencil test");     // Catch: Throwable -> L24
        if ((r102 & 1024) == 0) goto L20;
        GLES20.glEnable(2960);     // Catch: Throwable -> L24
        GLES20.glStencilFunc(519, r111, 255);     // Catch: Throwable -> L24
        GLES20.glStencilOp(7680, 7680, 7681);     // Catch: Throwable -> L24
    L21:
        GlUtil.checkNoGLES2Error("before clear workaround");     // Catch: Throwable -> L24
        GLES20.glDisable(2884);     // Catch: Throwable -> L24
        GLES20.glDisable(3042);     // Catch: Throwable -> L24
        GLES20.glDisable(32823);     // Catch: Throwable -> L24
        GLES20.glViewport(0, 0, r100, r101);     // Catch: Throwable -> L24
        GLES20.glDrawArrays(5, 0, 4);     // Catch: Throwable -> L24
        GlUtil.checkNoGLES2Error("after clear workaround");     // Catch: Throwable -> L24
        monitor-exit(this);
        return;
    L20:
        GLES20.glDisable(2960);     // Catch: Throwable -> L24
        GLES20.glStencilOp(7680, 7680, 7680);     // Catch: Throwable -> L24
        GLES20.glStencilMask(0);     // Catch: Throwable -> L24
        goto L21
    L16:
        GLES20.glDisable(2929);     // Catch: Throwable -> L24
        GLES20.glDepthFunc(512);     // Catch: Throwable -> L24
        goto L17
    }
}
