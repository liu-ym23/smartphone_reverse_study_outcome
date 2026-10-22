package com.bytedance.live.livelink.kmp.api.base.config;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0011\u0010\b\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\r"}, d2 = {"Lcom/bytedance/live/livelink/kmp/api/base/config/ChannelProfile;", "", "", "channelProfileNumber", "I", "", "getStringNum", "()Ljava/lang/String;", "stringNum", "CHANNEL_PROFILE_COMMUNICATION", "CHANNEL_PROFILE_LIVE_BROADCASTING", "CHANNEL_PROFILE_GAME", "CHANNEL_PROFILE_CLOUD_GAME", "live-link-kmp-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final enum ChannelProfile extends Enum<ChannelProfile> {
    public static final ChannelProfile CHANNEL_PROFILE_CLOUD_GAME = null;
    public static final ChannelProfile CHANNEL_PROFILE_COMMUNICATION = null;
    public static final ChannelProfile CHANNEL_PROFILE_GAME = null;
    public static final ChannelProfile CHANNEL_PROFILE_LIVE_BROADCASTING = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ChannelProfile[] f255215a = null;
    private final int channelProfileNumber;

    static {
        ChannelProfile r100 = new ChannelProfile("CHANNEL_PROFILE_COMMUNICATION", 0, 0);
        CHANNEL_PROFILE_COMMUNICATION = r100;
        ChannelProfile r101 = new ChannelProfile("CHANNEL_PROFILE_LIVE_BROADCASTING", 1, 1);
        CHANNEL_PROFILE_LIVE_BROADCASTING = r101;
        ChannelProfile r102 = new ChannelProfile("CHANNEL_PROFILE_GAME", 2, 2);
        CHANNEL_PROFILE_GAME = r102;
        ChannelProfile r103 = new ChannelProfile("CHANNEL_PROFILE_CLOUD_GAME", 3, 3);
        CHANNEL_PROFILE_CLOUD_GAME = r103;
        f255215a = new ChannelProfile[]{r100, r101, r102, r103};
    }

    public static ChannelProfile valueOf(String r100) {
        return (ChannelProfile) a.a(ChannelProfile.class, r100);
    }

    public static ChannelProfile[] values() {
        return (ChannelProfile[]) f255215a.clone();
    }

    public final String getStringNum() {
        return String.valueOf(this.channelProfileNumber);
    }

    public ChannelProfile(String r100, int r101, int r102) {
        super(r100, r101);
        this.channelProfileNumber = r102;
    }
}
