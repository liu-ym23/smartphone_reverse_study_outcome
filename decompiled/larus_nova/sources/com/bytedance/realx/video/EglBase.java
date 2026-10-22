package com.bytedance.realx.video;

import android.graphics.SurfaceTexture;
import android.view.Surface;
import javax.microedition.khronos.egl.EGLContext;

/* JADX INFO: loaded from: classes21.dex */
public interface EglBase {
    public static final int[] CONFIG_PIXEL_BUFFER = null;
    public static final int[] CONFIG_PIXEL_RGBA_BUFFER = null;
    public static final int[] CONFIG_PLAIN = null;
    public static final int[] CONFIG_RECORDABLE = null;
    public static final int[] CONFIG_RGBA = null;
    public static final int EGL_OPENGL_ES2_BIT = 4;
    public static final int EGL_OPENGL_ES3_BIT = 64;
    public static final int EGL_RECORDABLE_ANDROID = 12610;
    public static final int[] ES2_CONFIG_PIXEL_BUFFER = null;
    public static final int[] ES2_CONFIG_PIXEL_RGBA_BUFFER = null;
    public static final int[] ES2_CONFIG_PLAIN = null;
    public static final int[] ES2_CONFIG_RECORDABLE = null;
    public static final int[] ES2_CONFIG_RGBA = null;
    public static final int[] ES3_CONFIG_PIXEL_BUFFER = null;
    public static final int[] ES3_CONFIG_PIXEL_RGBA_BUFFER = null;
    public static final int[] ES3_CONFIG_PLAIN = null;
    public static final int[] ES3_CONFIG_RECORDABLE = null;
    public static final int[] ES3_CONFIG_RGBA = null;
    public static final String TAG = "EglBase";
    public static final Object lock = null;

    /* JADX INFO: renamed from: com.bytedance.realx.video.EglBase$-CC, reason: invalid class name */
    public final /* synthetic */ class CC {
        static {
            Object r100 = EglBase.lock;
        }

        public static EglBase create() {
            return create(null, getEGLConfig(EglVersion.getPreferredEglVersion(), Config.CONFIG_PLAIN));
        }

        public static void eglContextDestoryEnd() {
            EglBaseCheckerHelper.EglContextDestoryEnd();
        }

        public static void eglContextDestoryStart() {
            EglBaseCheckerHelper.EglContextDestoryStart();
        }

        public static EglBase create(Context r100) {
            return create(r100, getEGLConfig(EglVersion.getPreferredEglVersion(), Config.CONFIG_PLAIN));
        }

        public static EglBase createEgl10(int[] r100) {
            return new EglBase10(null, r100);
        }

        public static EglBase createEgl14(int[] r100) {
            return new EglBase14(EglVersion.getPreferredEglVersion(), null, r100);
        }

        public static void setEglContextChecker(EglContextChecker r100) {
            EglBaseCheckerHelper.setEglContextChecker(r100);
        }

        public static EglBase create(Context r100, int[] r101) {
            if (EglBase14.isEGL14Supported() == false) goto L9;
            if (r100 == null) goto L10;
            if ((r100 instanceof EglBase14.Context) == false) goto L9;
        L10:
            return new EglBase14(EglVersion.getPreferredEglVersion(), (EglBase14.Context) r100, r101);
        L9:
            return new EglBase10((EglBase10.Context) r100, r101);
        }

        public static EglBase createEgl10(EGLContext r100, int[] r101) {
            int[] r102 = createModifiedEGLConfigArray(r101, 12352, 64, 4);
            return new EglBase10(new EglBase10.Context(r100), r102);
        }

        public static EglBase createEgl14(android.opengl.EGLContext r100, int[] r101) {
            return new EglBase14(EglVersion.getPreferredEglVersion(), new EglBase14.Context(r100, EglVersion.getPreferredEglVersion()), r101);
        }

        public static int[] getEGLConfig(int r100, Config r101) {
            int r102 = AnonymousClass1.$SwitchMap$com$bytedance$realx$video$EglBase$Config[r101.ordinal()];
            if (r102 != 1) goto L5;
            if (r100 != 3) goto L28;
            return EglBase.ES3_CONFIG_RGBA;
        L28:
            return EglBase.ES2_CONFIG_RGBA;
        L5:
            if (r102 == 2) goto L21;
            if (r102 != 3) goto L8;
            if (r100 != 3) goto L20;
            return EglBase.ES3_CONFIG_PIXEL_RGBA_BUFFER;
        L20:
            return EglBase.ES2_CONFIG_PIXEL_RGBA_BUFFER;
        L8:
            if (r102 == 4) goto L13;
            if (r100 != 3) goto L12;
            return EglBase.ES3_CONFIG_PLAIN;
        L12:
            return EglBase.ES2_CONFIG_PLAIN;
        L13:
            if (r100 != 3) goto L16;
            return EglBase.ES3_CONFIG_RECORDABLE;
        L16:
            return EglBase.ES2_CONFIG_RECORDABLE;
        L21:
            if (r100 != 3) goto L24;
            return EglBase.ES3_CONFIG_PIXEL_BUFFER;
        L24:
            return EglBase.ES2_CONFIG_PIXEL_BUFFER;
        }

        public static int[] createModifiedEGLConfigArray(int[] r100, int r101, int r102, int r103) {
            int[] r104 = (int[]) r100.clone();
            int r105 = 0;
        L4:
            if (r105 >= r104.length) goto L13;
            if (r104[r105] != r101) goto L12;
            int r106 = r105 + 1;
            if (r106 >= r104.length) goto L12;
            if (r104[r106] != r102) goto L12;
            r104[r106] = r103;
        L12:
            r105 = r105 + 1;
        L13:
            return r104;
        }
    }

    /* JADX INFO: renamed from: com.bytedance.realx.video.EglBase$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$bytedance$realx$video$EglBase$Config = null;

        static {
            int[] r100 = new int[Config.values().length];
            $SwitchMap$com$bytedance$realx$video$EglBase$Config = r100;
            r100[Config.CONFIG_RGBA.ordinal()] = 1;     // Catch: NoSuchFieldError -> L9
        L14:
            $SwitchMap$com$bytedance$realx$video$EglBase$Config[Config.CONFIG_PIXEL_BUFFER.ordinal()] = 2;     // Catch: NoSuchFieldError -> L10
        L18:
            $SwitchMap$com$bytedance$realx$video$EglBase$Config[Config.CONFIG_PIXEL_RGBA_BUFFER.ordinal()] = 3;     // Catch: NoSuchFieldError -> L11
        L22:
            $SwitchMap$com$bytedance$realx$video$EglBase$Config[Config.CONFIG_RECORDABLE.ordinal()] = 4;     // Catch: NoSuchFieldError -> L12
        L16:
            $SwitchMap$com$bytedance$realx$video$EglBase$Config[Config.CONFIG_PLAIN.ordinal()] = 5;     // Catch: NoSuchFieldError -> L13
            return;
        }
    }

    public static final enum Config extends Enum<Config> {
        private static final /* synthetic */ Config[] $VALUES = null;
        public static final Config CONFIG_PIXEL_BUFFER = null;
        public static final Config CONFIG_PIXEL_RGBA_BUFFER = null;
        public static final Config CONFIG_PLAIN = null;
        public static final Config CONFIG_RECORDABLE = null;
        public static final Config CONFIG_RGBA = null;

        static {
            Config r100 = new Config("CONFIG_PLAIN", 0);
            CONFIG_PLAIN = r100;
            Config r101 = new Config("CONFIG_RGBA", 1);
            CONFIG_RGBA = r101;
            Config r102 = new Config("CONFIG_PIXEL_BUFFER", 2);
            CONFIG_PIXEL_BUFFER = r102;
            Config r103 = new Config("CONFIG_PIXEL_RGBA_BUFFER", 3);
            CONFIG_PIXEL_RGBA_BUFFER = r103;
            Config r104 = new Config("CONFIG_RECORDABLE", 4);
            CONFIG_RECORDABLE = r104;
            $VALUES = new Config[]{r100, r101, r102, r103, r104};
        }

        public static Config[] values() {
            return (Config[]) $VALUES.clone();
        }

        public static Config valueOf(String r100) {
            return (Config) r27.a.a(Config.class, r100);
        }

        private Config(String r100, int r101) {
            super(r100, r101);
        }
    }

    public interface Context {
        public static final long NO_CONTEXT = 0;

        android.opengl.EGLContext getEgl14Context();

        int getGLESVersion();

        long getNativeEglContext();
    }

    public interface EglContextChecker {
        void EglContextDestoryEnd();

        void EglContextDestoryStart();
    }

    public static class EglLock {
        public static boolean enableEglLock = true;

        public EglLock() {
        }
    }

    public static class EglVersion {
        public static final int EGL_VERSION_2 = 2;
        public static final int EGL_VERSION_3 = 3;
        private static int PREFERRED_EGL_VERSION = 2;

        public EglVersion() {
        }

        public static int getPreferredEglVersion() {
            return PREFERRED_EGL_VERSION;
        }

        public static void setPreferredEglVersion(int r100) {
            PREFERRED_EGL_VERSION = r100;
        }
    }

    void createDummyPbufferSurface();

    void createPbufferSurface(int r100, int r101);

    void createSurface(SurfaceTexture r100);

    void createSurface(Surface r100);

    void detachCurrent();

    Context getEglBaseContext();

    int getGLESVersion();

    boolean hasSurface();

    void makeCurrent();

    void release();

    void releaseSurface();

    int surfaceHeight();

    int surfaceWidth();

    void swapBuffers();

    void swapBuffers(long r100);

    static {
        lock = new Object();
        ES3_CONFIG_PLAIN = new int[]{12324, 8, 12323, 8, 12322, 8, 12352, 64, 12344};
        int[] r100 = {12324, 8, 12323, 8, 12322, 8, 12352, 4, 12344};
        ES2_CONFIG_PLAIN = r100;
        ES3_CONFIG_RGBA = new int[]{12324, 8, 12323, 8, 12322, 8, 12321, 8, 12352, 64, 12344};
        int[] r101 = {12324, 8, 12323, 8, 12322, 8, 12321, 8, 12352, 4, 12344};
        ES2_CONFIG_RGBA = r101;
        ES3_CONFIG_PIXEL_BUFFER = new int[]{12324, 8, 12323, 8, 12322, 8, 12352, 64, 12339, 1, 12344};
        int[] r102 = {12324, 8, 12323, 8, 12322, 8, 12352, 4, 12339, 1, 12344};
        ES2_CONFIG_PIXEL_BUFFER = r102;
        ES3_CONFIG_PIXEL_RGBA_BUFFER = new int[]{12324, 8, 12323, 8, 12322, 8, 12321, 8, 12352, 64, 12339, 1, 12344};
        int[] r103 = {12324, 8, 12323, 8, 12322, 8, 12321, 8, 12352, 4, 12339, 1, 12344};
        ES2_CONFIG_PIXEL_RGBA_BUFFER = r103;
        ES3_CONFIG_RECORDABLE = new int[]{12324, 8, 12323, 8, 12322, 8, 12321, 8, 12352, 64, 12610, 1, 12344};
        int[] r104 = {12324, 8, 12323, 8, 12322, 8, 12321, 8, 12352, 4, 12610, 1, 12344};
        ES2_CONFIG_RECORDABLE = r104;
        CONFIG_PLAIN = r100;
        CONFIG_RGBA = r101;
        CONFIG_PIXEL_BUFFER = r102;
        CONFIG_PIXEL_RGBA_BUFFER = r103;
        CONFIG_RECORDABLE = r104;
    }
}
