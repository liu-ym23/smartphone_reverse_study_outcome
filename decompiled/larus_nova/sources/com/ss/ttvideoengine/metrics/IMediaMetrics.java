package com.ss.ttvideoengine.metrics;

import android.os.Bundle;
import com.ss.ttvideoengine.log.VideoEventOnePlay;

/* JADX INFO: loaded from: classes34.dex */
public interface IMediaMetrics {
    public static final String KEY_METRICS_FIRST_FRAME_DECODE_DURATION = "ffr_decode_duration";
    public static final String KEY_METRICS_FIRST_FRAME_PLAYER_DURATION = "ffr_prender_duration";
    public static final String KEY_METRICS_FIRST_RENDER_DURATION = "ffr_render_duration";
    public static final String KEY_METRICS_PLAYBACK_BUFFERING_DURATION = "ffr_playback_buffering_duration";
    public static final String KEY_METRICS_READ_FIRST_DATA_DURATION = "ffr_read_first_data_duration";
    public static final String KEY_METRICS_READ_HEAD_DURATION = "ffr_read_head_duration";
    public static final String KEY_METRICS_RELEASE_LAST = "ffr_free_duration";
    public static final int METRICS_TYPE_FIRST_FRAME = 0;

    int getType();

    void logMetric(VideoEventOnePlay r100);

    void logMetric(String r100, float r101);

    void logMetric(String r100, int r101);

    void logMetric(String r100, String r101);

    void logMetric(String r100, boolean r101);

    boolean popMetricBoolean(String r100);

    float popMetricFloat(String r100);

    int popMetricInt(String r100);

    long popMetricLong(String r100);

    Bundle popMetrics();

    String printf();
}
