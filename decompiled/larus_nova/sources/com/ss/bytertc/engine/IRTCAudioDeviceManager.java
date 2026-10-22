package com.ss.bytertc.engine;

/* JADX INFO: loaded from: classes40.dex */
public interface IRTCAudioDeviceManager {
    int startAudioDeviceRecordTest(int r100);

    int startAudioPlaybackDeviceTest(String r100, int r101);

    int stopAudioDevicePlayTest();

    int stopAudioDeviceRecordAndPlayTest();

    int stopAudioPlaybackDeviceTest();
}
