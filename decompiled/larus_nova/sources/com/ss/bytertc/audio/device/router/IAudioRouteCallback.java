package com.ss.bytertc.audio.device.router;

/* JADX INFO: loaded from: classes40.dex */
public interface IAudioRouteCallback {
    void onDeviceEvent(int r100, boolean r101, String r102);

    void onError(int r100, String r101);
}
