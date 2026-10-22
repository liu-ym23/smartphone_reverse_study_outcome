package com.ss.bytedance.ies.audiorecord.api;

/* JADX INFO: loaded from: classes40.dex */
public interface IAudioRecordEventHandler {
    public static final int kByteAudioDeviceEventSupportHardwareEarback = 5201;

    void onHandleEvent(int r100, int r101, String r102);
}
