package com.ss.bytertc.engine;

import com.ss.bytertc.engine.handler.RTCAudioEffectPlayerEventHandler;

/* JADX INFO: loaded from: classes40.dex */
public class NativeAudioEffectPlayerFunctions {
    public NativeAudioEffectPlayerFunctions() {
    }

    public static native int nativeGetDuration(long r100, int r101);

    public static native int nativeGetPosition(long r100, int r101);

    public static native int nativeGetVolume(long r100, int r101);

    public static native int nativePause(long r100, int r101);

    public static native int nativePauseAll(long r100);

    public static native int nativePreload(long r100, int r101, String r102);

    public static native int nativeResume(long r100, int r101);

    public static native int nativeResumeAll(long r100);

    public static native int nativeSetEventHandler(long r100, long r101, RTCAudioEffectPlayerEventHandler r102);

    public static native int nativeSetPosition(long r100, int r101, int r102);

    public static native int nativeSetVolume(long r100, int r101, int r102);

    public static native int nativeSetVolumeAll(long r100, int r101);

    public static native int nativeStart(long r100, int r101, String r102, int r103, int r104, int r105, int r106);

    public static native int nativeStop(long r100, int r101);

    public static native int nativeStopAll(long r100);

    public static native int nativeUnload(long r100, int r101);

    public static native int nativeUnloadAll(long r100);
}
