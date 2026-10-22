package com.bytedance.live.livelink.kmp.api.base.event;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\u0012\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013¨\u0006\u0014"}, d2 = {"Lcom/bytedance/live/livelink/kmp/api/base/event/EventCategory;", "", "", "value", "Ljava/lang/String;", "getValue", "()Ljava/lang/String;", "RTC_ENGINE_MANAGER", "RTC_ROOM_MANAGER", "LINK_MANAGER", "RTC_ENGINE_EVENT", "RTC_ENGINE_EVENT_EX", "RTC_ROOM_EVENT", "RTC_ROOM_EVENT_EX", "RTC_MIXER_EVENT", "RTC_WTN_STREAM_EVENT", "LINK_USER_MANAGER", "VIDEO_MANAGER", "AUDIO_MANAGER", "SEI_MANAGER", "live-link-kmp-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final enum EventCategory extends Enum<EventCategory> {
    public static final EventCategory AUDIO_MANAGER = null;
    public static final EventCategory LINK_MANAGER = null;
    public static final EventCategory LINK_USER_MANAGER = null;
    public static final EventCategory RTC_ENGINE_EVENT = null;
    public static final EventCategory RTC_ENGINE_EVENT_EX = null;
    public static final EventCategory RTC_ENGINE_MANAGER = null;
    public static final EventCategory RTC_MIXER_EVENT = null;
    public static final EventCategory RTC_ROOM_EVENT = null;
    public static final EventCategory RTC_ROOM_EVENT_EX = null;
    public static final EventCategory RTC_ROOM_MANAGER = null;
    public static final EventCategory RTC_WTN_STREAM_EVENT = null;
    public static final EventCategory SEI_MANAGER = null;
    public static final EventCategory VIDEO_MANAGER = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ EventCategory[] f255220a = null;
    private final String value;

    public static EventCategory valueOf(String r100) {
        return (EventCategory) a.a(EventCategory.class, r100);
    }

    public static EventCategory[] values() {
        return (EventCategory[]) f255220a.clone();
    }

    static {
        EventCategory r100 = new EventCategory("RTC_ENGINE_MANAGER", 0, "rtc_engine_manager");
        RTC_ENGINE_MANAGER = r100;
        EventCategory r101 = new EventCategory("RTC_ROOM_MANAGER", 1, "rtc_room_manager");
        RTC_ROOM_MANAGER = r101;
        EventCategory r102 = new EventCategory("LINK_MANAGER", 2, "link_manager");
        LINK_MANAGER = r102;
        EventCategory r103 = new EventCategory("RTC_ENGINE_EVENT", 3, "rtc_engine_event_handler");
        RTC_ENGINE_EVENT = r103;
        EventCategory r104 = new EventCategory("RTC_ENGINE_EVENT_EX", 4, "rtc_engine_event_handler_ex");
        RTC_ENGINE_EVENT_EX = r104;
        EventCategory r105 = new EventCategory("RTC_ROOM_EVENT", 5, "rtc_room_event_handler");
        RTC_ROOM_EVENT = r105;
        EventCategory r106 = new EventCategory("RTC_ROOM_EVENT_EX", 6, "rtc_room_event_handler_ex");
        RTC_ROOM_EVENT_EX = r106;
        EventCategory r107 = new EventCategory("RTC_MIXER_EVENT", 7, "rtc_mixer_event_handler");
        RTC_MIXER_EVENT = r107;
        EventCategory r108 = new EventCategory("RTC_WTN_STREAM_EVENT", 8, "rtc_wtn_stream_event_handler");
        RTC_WTN_STREAM_EVENT = r108;
        EventCategory r109 = new EventCategory("LINK_USER_MANAGER", 9, "link_user_manager");
        LINK_USER_MANAGER = r109;
        EventCategory r110 = new EventCategory("VIDEO_MANAGER", 10, "video_manager");
        VIDEO_MANAGER = r110;
        EventCategory r111 = new EventCategory("AUDIO_MANAGER", 11, "audio_manager");
        AUDIO_MANAGER = r111;
        EventCategory r112 = new EventCategory("SEI_MANAGER", 12, "sei_manager");
        SEI_MANAGER = r112;
        f255220a = new EventCategory[]{r100, r101, r102, r103, r104, r105, r106, r107, r108, r109, r110, r111, r112};
    }

    public final String getValue() {
        return this.value;
    }

    public EventCategory(String r100, int r101, String r102) {
        super(r100, r101);
        this.value = r102;
    }
}
