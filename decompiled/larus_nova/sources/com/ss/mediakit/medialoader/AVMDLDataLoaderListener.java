package com.ss.mediakit.medialoader;

/* JADX INFO: loaded from: classes40.dex */
public interface AVMDLDataLoaderListener {
    String getCheckSumInfo(String r100);

    long getInt64Value(int r100, long r101);

    String getStringValue(int r100, long r101, String r102);

    void onNotify(AVMDLDataLoaderNotifyInfo r100);
}
