package com.ss.bytertc.engine;

/* JADX INFO: loaded from: classes40.dex */
public interface IRTCAudioDeviceManagerEx {

    public interface IRTCAudioDeviceEventHandler {
        void onRecordingAudioVolumeIndication(int r100);
    }

    void setEnableSpeakerphone(boolean r100);

    int startAudioCaptureDeviceTest(int r100);

    int startAudioPlaybackDeviceTest(String r100, int r101);

    int stopAudioCaptureDeviceTest();

    int stopAudioPlaybackDeviceTest();
}
