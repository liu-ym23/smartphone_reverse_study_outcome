package com.ss.bytertc.engine;

/* JADX INFO: loaded from: classes40.dex */
public interface RTCHttpClient {

    public interface RtcHttpCallback {
        void run(int r100, String r101);
    }

    void GetAsync(String r100, RtcHttpCallback r101, int r102);

    void PostAsync(String r100, String r101, RtcHttpCallback r102, int r103);
}
