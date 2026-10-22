package com.ss.android.ttve.nativePort;

/* JADX INFO: loaded from: classes38.dex */
public class TESpeechTest {
    private long handle;

    public TESpeechTest() {
    }

    private static native long createSpeechUtils();

    private static native void init(long r100);

    private static native int process(long r100, short[] r101, int r102);

    private static native int stop(long r100);

    public static TESpeechTest create() {
        TESpeechTest r100 = new TESpeechTest();
        r100.handle = createSpeechUtils();
        return r100;
    }

    public void init() {
        init(this.handle);
    }

    public int stop() {
        return stop(this.handle);
    }

    public int process(short[] r100, int r101) {
        return process(this.handle, r100, r101);
    }
}
