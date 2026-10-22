package com.ss.bytertc.engine;

import com.ss.bytertc.ktv.IKTVPlayerEventHandler;

/* JADX INFO: loaded from: classes40.dex */
public class NativeKTVPlayerFunctions {
    public NativeKTVPlayerFunctions() {
    }

    public static native void nativePauseMusic(long r100, String r101);

    public static native void nativePlayMusic(long r100, String r101, int r102, int r103);

    public static native void nativeReleaseKTVPlayerEventHandler(long r100);

    public static native void nativeResumeMusic(long r100, String r101);

    public static native void nativeSeekMusic(long r100, String r101, int r102);

    public static native void nativeSetMusicPitch(long r100, String r101, int r102);

    public static native void nativeSetMusicVolume(long r100, String r101, int r102);

    public static native long nativeSetPlayerEventHandler(long r100, IKTVPlayerEventHandler r101);

    public static native void nativeStopMusic(long r100, String r101);

    public static native void nativeSwitchAudioTrackType(long r100, String r101);
}
