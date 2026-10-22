package com.bytedance.vcloud.abrmodule;

/* JADX INFO: loaded from: classes22.dex */
public interface IStream {
    int getBandwidth();

    String getCodec();

    int getRealBitrate();

    int getSegmentDuration();

    String getStreamId();
}
