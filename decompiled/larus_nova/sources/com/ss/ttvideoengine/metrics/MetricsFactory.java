package com.ss.ttvideoengine.metrics;

import com.ss.ttvideoengine.log.VideoEventOnePlay;

/* JADX INFO: loaded from: classes34.dex */
public final class MetricsFactory {
    private MetricsFactory() {
    }

    public static IMediaMetrics createMetrics(int r100, VideoEventOnePlay r101) {
        if (r100 == 0) goto L4;
        FirstFrameMetrics r102 = null;
    L5:
        if (r102 == null) goto L7;
        r102.logMetric(r101);
    L7:
        return r102;
    L4:
        r102 = new FirstFrameMetrics(r100);
        goto L5
    }
}
