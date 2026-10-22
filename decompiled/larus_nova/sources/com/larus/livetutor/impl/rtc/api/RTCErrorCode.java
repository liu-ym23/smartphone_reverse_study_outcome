package com.larus.livetutor.impl.rtc.api;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes30.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u000f\b\u0087\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011¨\u0006\u0012"}, d2 = {"Lcom/larus/livetutor/impl/rtc/api/RTCErrorCode;", "", "code", "", "<init>", "(Ljava/lang/String;II)V", "getCode", "()I", "CREATE_ENGINE", "JOIN_ROOM", "START_AUDIO_CAPTURE", "STOP_AUDIO_CAPTURE", "LEAVE_ROOM", "UNSUBSCRIBE_AUDIO", "SUBSCRIBE_AUDIO", "MUTE_AUDIO", "ENGINE_CONFLICT", "RTC_CONNECT_TIME_OUT", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum RTCErrorCode extends Enum<RTCErrorCode> {
    private static final /* synthetic */ EnumEntries $ENTRIES = null;
    private static final /* synthetic */ RTCErrorCode[] $VALUES = null;
    public static final RTCErrorCode CREATE_ENGINE = null;
    public static final RTCErrorCode ENGINE_CONFLICT = null;
    public static final RTCErrorCode JOIN_ROOM = null;
    public static final RTCErrorCode LEAVE_ROOM = null;
    public static final RTCErrorCode MUTE_AUDIO = null;
    public static final RTCErrorCode RTC_CONNECT_TIME_OUT = null;
    public static final RTCErrorCode START_AUDIO_CAPTURE = null;
    public static final RTCErrorCode STOP_AUDIO_CAPTURE = null;
    public static final RTCErrorCode SUBSCRIBE_AUDIO = null;
    public static final RTCErrorCode UNSUBSCRIBE_AUDIO = null;
    private final int code;

    private static final /* synthetic */ RTCErrorCode[] $values() {
        return new RTCErrorCode[]{CREATE_ENGINE, JOIN_ROOM, START_AUDIO_CAPTURE, STOP_AUDIO_CAPTURE, LEAVE_ROOM, UNSUBSCRIBE_AUDIO, SUBSCRIBE_AUDIO, MUTE_AUDIO, ENGINE_CONFLICT, RTC_CONNECT_TIME_OUT};
    }

    public static EnumEntries<RTCErrorCode> getEntries() {
        return $ENTRIES;
    }

    static {
        CREATE_ENGINE = new RTCErrorCode("CREATE_ENGINE", 0, 1);
        JOIN_ROOM = new RTCErrorCode("JOIN_ROOM", 1, 2);
        START_AUDIO_CAPTURE = new RTCErrorCode("START_AUDIO_CAPTURE", 2, 3);
        STOP_AUDIO_CAPTURE = new RTCErrorCode("STOP_AUDIO_CAPTURE", 3, 4);
        LEAVE_ROOM = new RTCErrorCode("LEAVE_ROOM", 4, 5);
        UNSUBSCRIBE_AUDIO = new RTCErrorCode("UNSUBSCRIBE_AUDIO", 5, 6);
        SUBSCRIBE_AUDIO = new RTCErrorCode("SUBSCRIBE_AUDIO", 6, 7);
        MUTE_AUDIO = new RTCErrorCode("MUTE_AUDIO", 7, 8);
        ENGINE_CONFLICT = new RTCErrorCode("ENGINE_CONFLICT", 8, 9);
        RTC_CONNECT_TIME_OUT = new RTCErrorCode("RTC_CONNECT_TIME_OUT", 9, 101);
        RTCErrorCode[] r100 = $values();
        $VALUES = r100;
        $ENTRIES = EnumEntriesKt.enumEntries(r100);
    }

    public static RTCErrorCode[] values() {
        return (RTCErrorCode[]) $VALUES.clone();
    }

    public final int getCode() {
        return this.code;
    }

    public static RTCErrorCode valueOf(String r100) {
        return (RTCErrorCode) r27.a.a(RTCErrorCode.class, r100);
    }

    private RTCErrorCode(String r100, int r101, int r102) {
        super(r100, r101);
        this.code = r102;
    }
}
