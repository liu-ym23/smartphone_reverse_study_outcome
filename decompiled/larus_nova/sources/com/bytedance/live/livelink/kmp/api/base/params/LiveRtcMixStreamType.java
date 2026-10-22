package com.bytedance.live.livelink.kmp.api.base.params;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\t\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/bytedance/live/livelink/kmp/api/base/params/LiveRtcMixStreamType;", "", "", "value", "I", "getValue", "()I", "SERVER_MIX", "RTC_CLIENT_MIX", "AUTO_MIX", "DISABLE_MIX", "live-link-kmp-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final enum LiveRtcMixStreamType extends Enum<LiveRtcMixStreamType> {
    public static final LiveRtcMixStreamType AUTO_MIX = null;
    public static final LiveRtcMixStreamType DISABLE_MIX = null;
    public static final LiveRtcMixStreamType RTC_CLIENT_MIX = null;
    public static final LiveRtcMixStreamType SERVER_MIX = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ LiveRtcMixStreamType[] f255222a = null;
    private final int value;

    static {
        LiveRtcMixStreamType r100 = new LiveRtcMixStreamType("SERVER_MIX", 0, 0);
        SERVER_MIX = r100;
        LiveRtcMixStreamType r101 = new LiveRtcMixStreamType("RTC_CLIENT_MIX", 1, 1);
        RTC_CLIENT_MIX = r101;
        LiveRtcMixStreamType r102 = new LiveRtcMixStreamType("AUTO_MIX", 2, 2);
        AUTO_MIX = r102;
        LiveRtcMixStreamType r103 = new LiveRtcMixStreamType("DISABLE_MIX", 3, 3);
        DISABLE_MIX = r103;
        f255222a = new LiveRtcMixStreamType[]{r100, r101, r102, r103};
    }

    public static LiveRtcMixStreamType valueOf(String r100) {
        return (LiveRtcMixStreamType) a.a(LiveRtcMixStreamType.class, r100);
    }

    public static LiveRtcMixStreamType[] values() {
        return (LiveRtcMixStreamType[]) f255222a.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public LiveRtcMixStreamType(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
