package com.bytedance.vcloud.abrmodule;

import java.util.List;
import java.util.Map;
import java.util.Queue;

/* JADX INFO: loaded from: classes22.dex */
public interface IPlayStateSupplier {
    Map<String, IBufferInfo> getAudioBufferInfo();

    float getAverageDownloadSpeed(int r100, int r101, boolean r102);

    int getCurrentDownloadAudioBitrate();

    int getCurrentDownloadAudioSegmentIndex();

    int getCurrentDownloadVideoBitrate();

    int getCurrentDownloadVideoSegmentIndex();

    int getCurrentPlaybackTime();

    float getDownloadSpeed();

    int getLoaderType();

    int getMaxCacheAudioTime();

    int getMaxCacheVideoTime();

    float getNetworkSpeed();

    int getNetworkState();

    float getPlaySpeed();

    int getPlayerAudioCacheTime();

    int getPlayerVideoCacheTime();

    List<? extends ISegmentInfo> getSegmentInfoList(int r100, int r101);

    float getSpeedConfidence();

    Queue<IABRModuleSpeedRecord> getTimelineNetworkSpeed();

    Map<String, IBufferInfo> getVideoBufferInfo();
}
