package com.ss.ttvideoengine.metrics;

import android.os.Bundle;
import com.ss.ttvideoengine.log.VideoEventOnePlay;

/* JADX INFO: loaded from: classes34.dex */
class FirstFrameMetrics implements IMediaMetrics {
    private long mFirstFrameDecodedDuration;
    private long mFirstFrameRenderDuration;
    private int mFreeLastDuration;
    private Bundle mMetrics;
    private long mPlaybackBufferEndDuration;
    private long mPlayerFirstFrameRenderDuration;
    private long mReadFirstVideoPktDuration;
    private long mReadHeaderDuration;
    private int mType;

    @Override // com.ss.ttvideoengine.metrics.IMediaMetrics
    public String printf() {
        return this.mMetrics.toString();
    }

    @Override // com.ss.ttvideoengine.metrics.IMediaMetrics
    public int getType() {
        return this.mType;
    }

    @Override // com.ss.ttvideoengine.metrics.IMediaMetrics
    public Bundle popMetrics() {
        return this.mMetrics;
    }

    public FirstFrameMetrics(int r100) {
        this.mMetrics = new Bundle();
        this.mType = r100;
    }

    @Override // com.ss.ttvideoengine.metrics.IMediaMetrics
    public void logMetric(VideoEventOnePlay r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        long r101 = r100.tranFirstPacketT;
        long r102 = 0;
        if (r101 <= 0) goto L7;
        long r103 = r101 - r100.prepare_start_time;
    L8:
        this.mReadHeaderDuration = r103;
        long r104 = r100.receiveFirstVideoFrameT;
        long r105 = r100.prepare_start_time;
        this.mReadFirstVideoPktDuration = r104 - r105;
        this.mFirstFrameDecodedDuration = r100.decodeFirstVideoFrameT - r105;
        this.mFirstFrameRenderDuration = r100.f457088vt - r105;
        this.mPlayerFirstFrameRenderDuration = r100.playerFirstFrameT - r105;
        long r106 = r100.playbackBufferEndT;
        if (r106 <= 0) goto L11;
        r102 = r106 - r105;
    L11:
        this.mPlaybackBufferEndDuration = r102;
        this.mMetrics.putLong(IMediaMetrics.KEY_METRICS_READ_HEAD_DURATION, r103);
        this.mMetrics.putLong(IMediaMetrics.KEY_METRICS_READ_FIRST_DATA_DURATION, this.mReadFirstVideoPktDuration);
        this.mMetrics.putLong(IMediaMetrics.KEY_METRICS_FIRST_FRAME_DECODE_DURATION, this.mFirstFrameDecodedDuration);
        this.mMetrics.putLong(IMediaMetrics.KEY_METRICS_FIRST_RENDER_DURATION, this.mFirstFrameRenderDuration);
        this.mMetrics.putLong(IMediaMetrics.KEY_METRICS_PLAYBACK_BUFFERING_DURATION, this.mPlaybackBufferEndDuration);
        this.mMetrics.putLong(IMediaMetrics.KEY_METRICS_FIRST_FRAME_PLAYER_DURATION, this.mPlayerFirstFrameRenderDuration);
        return;
    L7:
        r103 = 0;
        goto L8
    }

    @Override // com.ss.ttvideoengine.metrics.IMediaMetrics
    public boolean popMetricBoolean(String r100) {
        return this.mMetrics.getBoolean(r100);
    }

    @Override // com.ss.ttvideoengine.metrics.IMediaMetrics
    public float popMetricFloat(String r100) {
        return this.mMetrics.getFloat(r100);
    }

    @Override // com.ss.ttvideoengine.metrics.IMediaMetrics
    public int popMetricInt(String r100) {
        return this.mMetrics.getInt(r100);
    }

    @Override // com.ss.ttvideoengine.metrics.IMediaMetrics
    public long popMetricLong(String r100) {
        return this.mMetrics.getLong(r100);
    }

    @Override // com.ss.ttvideoengine.metrics.IMediaMetrics
    public void logMetric(String r100, float r101) {
        this.mMetrics.putFloat(r100, r101);
    }

    @Override // com.ss.ttvideoengine.metrics.IMediaMetrics
    public void logMetric(String r100, int r101) {
        this.mMetrics.putInt(r100, r101);
    }

    @Override // com.ss.ttvideoengine.metrics.IMediaMetrics
    public void logMetric(String r100, String r101) {
        this.mMetrics.putString(r100, r101);
    }

    @Override // com.ss.ttvideoengine.metrics.IMediaMetrics
    public void logMetric(String r100, boolean r101) {
        this.mMetrics.putBoolean(r100, r101);
    }
}
