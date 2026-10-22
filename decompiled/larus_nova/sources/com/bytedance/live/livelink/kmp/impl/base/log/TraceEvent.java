package com.bytedance.live.livelink.kmp.impl.base.log;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\u0012\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013¨\u0006\u0014"}, d2 = {"Lcom/bytedance/live/livelink/kmp/impl/base/log/TraceEvent;", "", "", "eventName", "Ljava/lang/String;", "getEventName", "()Ljava/lang/String;", "LINK_MANAGER", "LINK_SERVICE", "THREAD_MANAGER", "EVENT_MANAGER", "RTC_ENGINE_MANAGER", "RTC_ROOM_MANAGER", "INTERCEPT_MANAGER", "LINK_USER_MANAGER", "VIDEO_MANAGER", "AUDIO_MANAGER", "FORWARD_STREAM_MANAGER", "PUBLIC_STREAM_MANAGER", "STREAM_MIX_MANAGER", "live-link-kmp-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final enum TraceEvent extends Enum<TraceEvent> {
    public static final TraceEvent AUDIO_MANAGER = null;
    public static final TraceEvent EVENT_MANAGER = null;
    public static final TraceEvent FORWARD_STREAM_MANAGER = null;
    public static final TraceEvent INTERCEPT_MANAGER = null;
    public static final TraceEvent LINK_MANAGER = null;
    public static final TraceEvent LINK_SERVICE = null;
    public static final TraceEvent LINK_USER_MANAGER = null;
    public static final TraceEvent PUBLIC_STREAM_MANAGER = null;
    public static final TraceEvent RTC_ENGINE_MANAGER = null;
    public static final TraceEvent RTC_ROOM_MANAGER = null;
    public static final TraceEvent STREAM_MIX_MANAGER = null;
    public static final TraceEvent THREAD_MANAGER = null;
    public static final TraceEvent VIDEO_MANAGER = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ TraceEvent[] f255284a = null;
    private final String eventName;

    public static TraceEvent valueOf(String r100) {
        return (TraceEvent) a.a(TraceEvent.class, r100);
    }

    public static TraceEvent[] values() {
        return (TraceEvent[]) f255284a.clone();
    }

    static {
        TraceEvent r100 = new TraceEvent("LINK_MANAGER", 0, "link_manager");
        LINK_MANAGER = r100;
        TraceEvent r101 = new TraceEvent("LINK_SERVICE", 1, "link_service");
        LINK_SERVICE = r101;
        TraceEvent r102 = new TraceEvent("THREAD_MANAGER", 2, "thread_manager");
        THREAD_MANAGER = r102;
        TraceEvent r103 = new TraceEvent("EVENT_MANAGER", 3, "event_manager");
        EVENT_MANAGER = r103;
        TraceEvent r104 = new TraceEvent("RTC_ENGINE_MANAGER", 4, "rtc_engine_manager");
        RTC_ENGINE_MANAGER = r104;
        TraceEvent r105 = new TraceEvent("RTC_ROOM_MANAGER", 5, "rtc_room_manager");
        RTC_ROOM_MANAGER = r105;
        TraceEvent r106 = new TraceEvent("INTERCEPT_MANAGER", 6, "intercept_manager");
        INTERCEPT_MANAGER = r106;
        TraceEvent r107 = new TraceEvent("LINK_USER_MANAGER", 7, "link_user_manager");
        LINK_USER_MANAGER = r107;
        TraceEvent r108 = new TraceEvent("VIDEO_MANAGER", 8, "video_manager");
        VIDEO_MANAGER = r108;
        TraceEvent r109 = new TraceEvent("AUDIO_MANAGER", 9, "audio_manager");
        AUDIO_MANAGER = r109;
        TraceEvent r110 = new TraceEvent("FORWARD_STREAM_MANAGER", 10, "forward_stream_manager");
        FORWARD_STREAM_MANAGER = r110;
        TraceEvent r111 = new TraceEvent("PUBLIC_STREAM_MANAGER", 11, "public_stream_manager");
        PUBLIC_STREAM_MANAGER = r111;
        TraceEvent r112 = new TraceEvent("STREAM_MIX_MANAGER", 12, "stream_mix_manager");
        STREAM_MIX_MANAGER = r112;
        f255284a = new TraceEvent[]{r100, r101, r102, r103, r104, r105, r106, r107, r108, r109, r110, r111, r112};
    }

    public final String getEventName() {
        return this.eventName;
    }

    public TraceEvent(String r100, int r101, String r102) {
        super(r100, r101);
        this.eventName = r102;
    }
}
