package com.ss.bytertc.engine;

import com.ss.bytertc.engine.handler.RTCMediaPlayerAudioFrameObserver;
import com.ss.bytertc.engine.handler.RTCMediaPlayerCustomSourceProvider;
import com.ss.bytertc.engine.handler.RTCMediaPlayerEventHandler;

/* JADX INFO: loaded from: classes40.dex */
public class NativeMediaPlayerFunctions {
    public NativeMediaPlayerFunctions() {
    }

    public static native void nativeDestory(long r100);

    public static native int nativeGetAudioTrackCount(long r100);

    public static native int nativeGetPlaybackDuration(long r100);

    public static native int nativeGetPosition(long r100);

    public static native int nativeGetState(long r100);

    public static native int nativeGetTotalDuration(long r100);

    public static native int nativeGetVolume(long r100, int r101);

    public static native int nativeOpen(long r100, String r101, int r102, int r103, int r104, boolean r105, long r106, boolean r107);

    public static native int nativeOpenWithCustomSource(long r100, int r101, int r102, RTCMediaPlayerCustomSourceProvider r103, int r104, int r105, int r106, boolean r107, long r108, boolean r110);

    public static native int nativePause(long r100);

    public static native int nativePushExternalAudioFrame(long r100, byte[] r101, int r102, int r103, int r104);

    public static native int nativeRegisterAudioFrameObserver(long r100, RTCMediaPlayerAudioFrameObserver r101);

    public static native int nativeResume(long r100);

    public static native int nativeSelectAudioTrack(long r100, int r101);

    public static native int nativeSetAudioDualMonoMode(long r100, int r101);

    public static native int nativeSetAudioPitch(long r100, int r101);

    public static native int nativeSetEventHandler(long r100, RTCMediaPlayerEventHandler r101);

    public static native int nativeSetLoudness(long r100, float r101);

    public static native int nativeSetPlaybackSpeed(long r100, int r101);

    public static native int nativeSetPosition(long r100, int r101);

    public static native int nativeSetProgressInterval(long r100, long r101);

    public static native int nativeSetVolume(long r100, int r101, int r102);

    public static native int nativeStart(long r100);

    public static native int nativeStop(long r100);
}
