package com.bytedance.live.livelink.kmp.api.core.video;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0003\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/live/livelink/kmp/api/core/video/VideoPipelineType;", "", "VIDEO_RTC_SUBSCRIBE_PIPELINE", "VIDEO_RTC_PUBLISH_PIPELINE", "live-link-kmp-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final enum VideoPipelineType extends Enum<VideoPipelineType> {
    public static final VideoPipelineType VIDEO_RTC_PUBLISH_PIPELINE = null;
    public static final VideoPipelineType VIDEO_RTC_SUBSCRIBE_PIPELINE = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ VideoPipelineType[] f255258a = null;

    static {
        VideoPipelineType r100 = new VideoPipelineType("VIDEO_RTC_SUBSCRIBE_PIPELINE", 0);
        VIDEO_RTC_SUBSCRIBE_PIPELINE = r100;
        VideoPipelineType r101 = new VideoPipelineType("VIDEO_RTC_PUBLISH_PIPELINE", 1);
        VIDEO_RTC_PUBLISH_PIPELINE = r101;
        f255258a = new VideoPipelineType[]{r100, r101};
    }

    public static VideoPipelineType valueOf(String r100) {
        return (VideoPipelineType) a.a(VideoPipelineType.class, r100);
    }

    public static VideoPipelineType[] values() {
        return (VideoPipelineType[]) f255258a.clone();
    }

    public VideoPipelineType(String r100, int r101) {
        super(r100, r101);
    }
}
