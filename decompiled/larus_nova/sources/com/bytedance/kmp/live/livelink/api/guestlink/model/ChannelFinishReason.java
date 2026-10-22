package com.bytedance.kmp.live.livelink.api.guestlink.model;

import com.ss.videoarch.strategy.dataCenter.config.model.FeatureConfigInfo;
import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\u000e\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000f¨\u0006\u0010"}, d2 = {"Lcom/bytedance/kmp/live/livelink/api/guestlink/model/ChannelFinishReason;", "", "", "requestSource", "Ljava/lang/String;", "getRequestSource", "()Ljava/lang/String;", FeatureConfigInfo.ANCHOR_PROFILE_FEATURE_TYPE_ID, "LINKER", "ADMIN", "CLIENT_TIME_OUT", "SERVER_TIME_OUT", "SERVER_CHECK_RTC", "SELF_RTC_EXCEPTION", "REMOTE_USER_LEAVE", "CLIENT_CHECK", "multi-link-service-kmp-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final enum ChannelFinishReason extends Enum<ChannelFinishReason> {
    public static final ChannelFinishReason ADMIN = null;
    public static final ChannelFinishReason ANCHOR = null;
    public static final ChannelFinishReason CLIENT_CHECK = null;
    public static final ChannelFinishReason CLIENT_TIME_OUT = null;
    public static final ChannelFinishReason LINKER = null;
    public static final ChannelFinishReason REMOTE_USER_LEAVE = null;
    public static final ChannelFinishReason SELF_RTC_EXCEPTION = null;
    public static final ChannelFinishReason SERVER_CHECK_RTC = null;
    public static final ChannelFinishReason SERVER_TIME_OUT = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ChannelFinishReason[] f252199a = null;
    private final String requestSource;

    public static ChannelFinishReason valueOf(String r100) {
        return (ChannelFinishReason) a.a(ChannelFinishReason.class, r100);
    }

    public static ChannelFinishReason[] values() {
        return (ChannelFinishReason[]) f252199a.clone();
    }

    static {
        ChannelFinishReason r100 = new ChannelFinishReason(FeatureConfigInfo.ANCHOR_PROFILE_FEATURE_TYPE_ID, 0, "anchor");
        ANCHOR = r100;
        ChannelFinishReason r101 = new ChannelFinishReason("LINKER", 1, "linker");
        LINKER = r101;
        ChannelFinishReason r102 = new ChannelFinishReason("ADMIN", 2, "administer");
        ADMIN = r102;
        ChannelFinishReason r103 = new ChannelFinishReason("CLIENT_TIME_OUT", 3, "client_time_out");
        CLIENT_TIME_OUT = r103;
        ChannelFinishReason r104 = new ChannelFinishReason("SERVER_TIME_OUT", 4, "server_time_out");
        SERVER_TIME_OUT = r104;
        ChannelFinishReason r105 = new ChannelFinishReason("SERVER_CHECK_RTC", 5, "server_check_rtc");
        SERVER_CHECK_RTC = r105;
        ChannelFinishReason r106 = new ChannelFinishReason("SELF_RTC_EXCEPTION", 6, "self_rtc_exception");
        SELF_RTC_EXCEPTION = r106;
        ChannelFinishReason r107 = new ChannelFinishReason("REMOTE_USER_LEAVE", 7, "remote_user_leave");
        REMOTE_USER_LEAVE = r107;
        ChannelFinishReason r108 = new ChannelFinishReason("CLIENT_CHECK", 8, "client_check");
        CLIENT_CHECK = r108;
        f252199a = new ChannelFinishReason[]{r100, r101, r102, r103, r104, r105, r106, r107, r108};
    }

    public final String getRequestSource() {
        return this.requestSource;
    }

    public ChannelFinishReason(String r100, int r101, String r102) {
        super(r100, r101);
        this.requestSource = r102;
    }
}
