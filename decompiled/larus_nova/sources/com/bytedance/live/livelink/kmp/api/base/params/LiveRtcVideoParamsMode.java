package com.bytedance.live.livelink.kmp.api.base.params;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/bytedance/live/livelink/kmp/api/base/params/LiveRtcVideoParamsMode;", "", "", "value", "I", "getValue", "()I", "DEFAULT_LIVE_VIDEO_MODE", "SERVER_LIVE_VIDEO_MODE", "ONE_TO_ONE_lIVE_VIDEO_MODE", "live-link-kmp-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final enum LiveRtcVideoParamsMode extends Enum<LiveRtcVideoParamsMode> {
    public static final LiveRtcVideoParamsMode DEFAULT_LIVE_VIDEO_MODE = null;
    public static final LiveRtcVideoParamsMode ONE_TO_ONE_lIVE_VIDEO_MODE = null;
    public static final LiveRtcVideoParamsMode SERVER_LIVE_VIDEO_MODE = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ LiveRtcVideoParamsMode[] f255223a = null;
    private final int value;

    static {
        LiveRtcVideoParamsMode r100 = new LiveRtcVideoParamsMode("DEFAULT_LIVE_VIDEO_MODE", 0, 0);
        DEFAULT_LIVE_VIDEO_MODE = r100;
        LiveRtcVideoParamsMode r101 = new LiveRtcVideoParamsMode("SERVER_LIVE_VIDEO_MODE", 1, 1);
        SERVER_LIVE_VIDEO_MODE = r101;
        LiveRtcVideoParamsMode r102 = new LiveRtcVideoParamsMode("ONE_TO_ONE_lIVE_VIDEO_MODE", 2, 3);
        ONE_TO_ONE_lIVE_VIDEO_MODE = r102;
        f255223a = new LiveRtcVideoParamsMode[]{r100, r101, r102};
    }

    public static LiveRtcVideoParamsMode valueOf(String r100) {
        return (LiveRtcVideoParamsMode) a.a(LiveRtcVideoParamsMode.class, r100);
    }

    public static LiveRtcVideoParamsMode[] values() {
        return (LiveRtcVideoParamsMode[]) f255223a.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public LiveRtcVideoParamsMode(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
