package com.ss.bytertc.engine;

import com.ss.bytertc.engine.data.DataMessageSourceType;
import com.ss.bytertc.engine.data.VideoFrameInfo;
import com.ss.bytertc.engine.data.WTNSubscribeState;
import com.ss.bytertc.engine.data.WTNSubscribeStateChangeReason;
import com.ss.bytertc.engine.type.RemoteAudioStats;
import com.ss.bytertc.engine.type.RemoteVideoStats;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes40.dex */
public interface IWTNStreamEventHandler {
    void onWTNAudioSubscribeStateChanged(String r100, WTNSubscribeState r101, WTNSubscribeStateChangeReason r102);

    void onWTNDataMessageReceived(String r100, ByteBuffer r101, DataMessageSourceType r102);

    void onWTNFirstRemoteAudioFrame(String r100);

    void onWTNFirstRemoteVideoFrameDecoded(String r100, VideoFrameInfo r101);

    void onWTNRemoteAudioStats(String r100, RemoteAudioStats r101);

    void onWTNRemoteVideoStats(String r100, RemoteVideoStats r101);

    void onWTNSEIMessageReceived(String r100, int r101, ByteBuffer r102);

    void onWTNVideoSubscribeStateChanged(String r100, WTNSubscribeState r101, WTNSubscribeStateChangeReason r102);
}
