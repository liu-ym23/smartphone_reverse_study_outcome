package com.ss.android.vesdk.audio;

/* JADX INFO: loaded from: classes40.dex */
public interface VEAudioCaptureListener extends i {
    @Override // com.ss.android.vesdk.audio.i
    /* synthetic */ void onError(int r100, int r101, String r102);

    @Override // com.ss.android.vesdk.audio.i
    /* synthetic */ void onInfo(int r100, int r101, double r102, Object r103);

    void onReceive(VEAudioSample r100);
}
