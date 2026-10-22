package com.bytedance.vcloud.networkpredictor;

/* JADX INFO: loaded from: classes22.dex */
public interface ISpeedPredictorListener {
    String getCountry();

    boolean getDownFileState(String r100, String r101, String r102) throws Exception;

    String getFilesCachePath();

    Object getIOExecutor();

    String getNetworkType();

    int getPhoneSignal();
}
