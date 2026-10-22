package com.ss.bytertc.engine;

/* JADX INFO: loaded from: classes40.dex */
public class NativeAudioDeviceManagerFunctions {
    public NativeAudioDeviceManagerFunctions() {
    }

    public static native int nativeStartAudioDeviceRecordTest(long r100, int r101);

    public static native int nativeStartAudioPlaybackDeviceTest(long r100, String r101, int r102);

    public static native int nativeStopAudioDevicePlayTest(long r100);

    public static native int nativeStopAudioDeviceRecordAndPlayTest(long r100);

    public static native int nativeStopAudioPlaybackDeviceTest(long r100);
}
