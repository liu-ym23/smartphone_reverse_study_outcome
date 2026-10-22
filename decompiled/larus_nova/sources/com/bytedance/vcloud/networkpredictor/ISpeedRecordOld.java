package com.bytedance.vcloud.networkpredictor;

/* JADX INFO: loaded from: classes22.dex */
public interface ISpeedRecordOld {
    long getBytes();

    long getLastRecvDate();

    String getProtocol();

    String getStreamId();

    long getTcpInfoRtt();

    long getTime();

    long getTimestamp();

    int getTrackType();
}
