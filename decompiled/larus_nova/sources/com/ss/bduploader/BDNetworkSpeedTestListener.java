package com.ss.bduploader;

/* JADX INFO: loaded from: classes40.dex */
public interface BDNetworkSpeedTestListener {
    public static final int ContextTypeSpeedTestFailed = 1;
    public static final int ContextTypeSpeedTestSuccess = 0;

    void onSpeedTestContext(int r100, int r101, String r102);

    int speedTestCheckNetState(int r100, int r101);
}
