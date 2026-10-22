package com.bytedance.live.livelink.kmp.impl.core.video;

import com.bytedance.live.livelink.kmp.api.core.video.VideoPipelineType;

/* JADX INFO: loaded from: classes19.dex */
public final /* synthetic */ class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int[] f255448a = null;

    static {
        int[] r100 = new int[VideoPipelineType.values().length];
        f255448a = r100;
        r100[VideoPipelineType.VIDEO_RTC_PUBLISH_PIPELINE.ordinal()] = 1;
        r100[VideoPipelineType.VIDEO_RTC_SUBSCRIBE_PIPELINE.ordinal()] = 2;
    }
}
