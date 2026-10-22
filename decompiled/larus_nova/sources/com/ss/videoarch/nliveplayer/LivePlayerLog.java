package com.ss.videoarch.nliveplayer;

/* JADX INFO: loaded from: classes38.dex */
public class LivePlayerLog {
    public LivePlayerLog() {
    }

    private static native void cpp_logD(int r100, String r101);

    private static native void cpp_logE(int r100, String r101);

    private static native void cpp_logF(int r100, String r101);

    private static native void cpp_logI(int r100, String r101);

    private static native void cpp_logV(int r100, String r101);

    private static native void cpp_logW(int r100, String r101);

    public static void a(String r100) {
        cpp_logD(0, "TextureRenderListener " + r100);
    }

    public static void b(String r100) {
        cpp_logE(0, "TextureRenderListener " + r100);
    }

    public static void c(int r100, String r101) {
        cpp_logI(r100, "SaveFrameCallback " + r101);
    }
}
