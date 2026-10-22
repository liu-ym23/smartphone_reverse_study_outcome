package com.ss.lens.algorithm;

import com.larus.utils.logger.FLogger;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import r27.a;

/* JADX INFO: loaded from: classes40.dex */
public class SmartCodec {
    private static boolean isLibLoaded;
    private long mNativePtr;

    public static final enum InputMode extends Enum<InputMode> {
        private static final /* synthetic */ InputMode[] $VALUES = null;
        public static final InputMode BUFFER_RGBA = null;
        public static final InputMode BUFFER_YUV = null;
        public static final InputMode SURFACE_RGBA = null;
        public static final InputMode UNKNOWN = null;

        static {
            InputMode r100 = new InputMode("UNKNOWN", 0);
            UNKNOWN = r100;
            InputMode r101 = new InputMode("SURFACE_RGBA", 1);
            SURFACE_RGBA = r101;
            InputMode r102 = new InputMode("BUFFER_YUV", 2);
            BUFFER_YUV = r102;
            InputMode r103 = new InputMode("BUFFER_RGBA", 3);
            BUFFER_RGBA = r103;
            $VALUES = new InputMode[]{r100, r101, r102, r103};
        }

        public static InputMode[] values() {
            return (InputMode[]) $VALUES.clone();
        }

        public static InputMode valueOf(String r100) {
            return (InputMode) a.a(InputMode.class, r100);
        }

        private InputMode(String r100, int r101) {
            super(r100, r101);
        }
    }

    public static final enum Preset extends Enum<Preset> {
        private static final /* synthetic */ Preset[] $VALUES = null;
        public static final Preset FAST = null;
        public static final Preset MEDIUM = null;
        public static final Preset SLOW = null;

        static {
            Preset r100 = new Preset("SLOW", 0);
            SLOW = r100;
            Preset r101 = new Preset("MEDIUM", 1);
            MEDIUM = r101;
            Preset r102 = new Preset("FAST", 2);
            FAST = r102;
            $VALUES = new Preset[]{r100, r101, r102};
        }

        public static Preset[] values() {
            return (Preset[]) $VALUES.clone();
        }

        public static Preset valueOf(String r100) {
            return (Preset) a.a(Preset.class, r100);
        }

        private Preset(String r100, int r101) {
            super(r100, r101);
        }
    }

    public static /* synthetic */ void access$000(String r100) {
        System.loadLibrary(r100);
    }

    private native SmartCodecResult nativeGetSmartCodecBufferOutput(long r100, SmartCodecResult r101);

    private native SmartCodecResult nativeGetSmartCodecGLOutput(long r100, SmartCodecResult r101);

    private native long nativeInitSmartCodec(int r100, int r101, int r102, int r103, float r104, int r105, int r106, int r107, String r108, String r110, String r111, boolean r112);

    private native void nativeReleaseSmartCodec(long r100);

    private native int nativeSmartCodecBufferProcess(long r100, byte[] r101, int r102, int r103, float r104, float r105, int r106);

    private native int nativeSmartCodecGLProcess(long r100, int r101, int r102, int r103, float[] r104, float r105, float r106, int r107);

    public void ReleaseSmartCodec() {
        long r100 = this.mNativePtr;
        if (r100 != 0) goto L5;
        return;
    L5:
        nativeReleaseSmartCodec(r100);
        this.mNativePtr = 0;
    }

    public SmartCodec() {
        this.mNativePtr = 0;
    }

    @JvmStatic
    public static void INVOKESTATIC_com_ss_lens_algorithm_SmartCodec_com_larus_home_impl_utils_SystemLoadLibraryHook_loadLibrary(String r100) {
        Intrinsics.checkNotNullParameter(r100, "libName");
        FLogger r101 = FLogger.f375446a;
        r101.i("Librarian_loadLib", "loadLibrary start libName -> " + r100);
        com.bytedance.librarian.a.c(r100);
        r101.i("Librarian_loadLib", "loadLibrary success by librarian -> " + r100);
    }

    public SmartCodecResult GetSmartCodecBufferOutput(SmartCodecResult r100) {
        long r101 = this.mNativePtr;
        if (r101 != 0) goto L6;
        return r100;
    L6:
        return nativeGetSmartCodecBufferOutput(r101, r100);
    }

    public SmartCodecResult GetSmartCodecGLOutput(SmartCodecResult r100) {
        long r101 = this.mNativePtr;
        if (r101 != 0) goto L6;
        return r100;
    L6:
        return nativeGetSmartCodecGLOutput(r101, r100);
    }

    public int SmartCodecBufferProcess(byte[] r110, int r111, int r112, int r113, float r114, float r115, int r116) {
        long r100 = this.mNativePtr;
        if (r100 == 0) goto L9;
        if (r111 <= 0) goto L11;
        if (r112 > 0) goto L8;
        return -1;
    L8:
        return nativeSmartCodecBufferProcess(r100, r110, r111, r112, r114, r115, r116);
    L11:
        return -1;
    L9:
        return -1;
    }

    public int SmartCodecProcess(int r110, int r111, int r112, float[] r113, float r114, float r115, int r116) {
        long r100 = this.mNativePtr;
        if (r100 == 0) goto L9;
        if (r111 <= 0) goto L11;
        if (r112 > 0) goto L8;
        return -1;
    L8:
        return nativeSmartCodecGLProcess(r100, r110, r111, r112, r113, r114, r115, r116);
    L11:
        return -1;
    L9:
        return -1;
    }

    public synchronized boolean InitSmartCodec(int r110, int r111, int r210, int r211, float r212, int r213, Preset r214, InputMode r215, String r216, String r217, boolean r218, String r219) {
        monitor-enter(this);
    L24:
        th = move-exception;
        throw th;
    L6:
        if (isLibLoaded == false) goto L29;
    L17:
        long r100 = nativeInitSmartCodec(r111, r110, r211, r210, r212, r213, r214.ordinal(), r215.ordinal(), r216, r217, r219, r218);     // Catch: Throwable -> L24
        this.mNativePtr = r100;     // Catch: Throwable -> L24
        if (r100 != 0) goto L22;
        monitor-exit(this);
        return false;
    L22:
        monitor-exit(this);
        return true;
    L29:
        INVOKESTATIC_com_ss_lens_algorithm_SmartCodec_com_larus_home_impl_utils_SystemLoadLibraryHook_loadLibrary("c++_shared");     // Catch: UnsatisfiedLinkError -> L9 Throwable -> L24
        INVOKESTATIC_com_ss_lens_algorithm_SmartCodec_com_larus_home_impl_utils_SystemLoadLibraryHook_loadLibrary("bytenn");     // Catch: UnsatisfiedLinkError -> L9 Throwable -> L24
        INVOKESTATIC_com_ss_lens_algorithm_SmartCodec_com_larus_home_impl_utils_SystemLoadLibraryHook_loadLibrary("fastcv");     // Catch: UnsatisfiedLinkError -> L9 Throwable -> L24
    L27:
        INVOKESTATIC_com_ss_lens_algorithm_SmartCodec_com_larus_home_impl_utils_SystemLoadLibraryHook_loadLibrary("lens");     // Catch: UnsatisfiedLinkError -> L13 Throwable -> L24
        isLibLoaded = true;     // Catch: Throwable -> L24
        goto L17
    L13:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L24
        return false;
    L9:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L24
        goto L27
    }
}
