package com.bytedance.android.livesdk.live.extension.plugin.api.rtc.engine.type;

import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\u001d\b\u0086\u0001\u0018\u0000 \u00052\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0006J\u0006\u0010\u0003\u001a\u00020\u0002R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017j\u0002\b\u0018j\u0002\b\u0019j\u0002\b\u001aj\u0002\b\u001bj\u0002\b\u001cj\u0002\b\u001dj\u0002\b\u001e¨\u0006\u001f"}, d2 = {"Lcom/bytedance/android/livesdk/live/extension/plugin/api/rtc/engine/type/LiveWrappedRoomStateChangeReason;", "", "", "value", "I", "Companion", "a", "JOIN_ROOM", "RECONNECT", "LEAVE_ROOM", "JOIN_ROOM_FAILED", "INVALID_TOKEN", "TOKEN_EXPIRED", "UPDATE_TOKEN_WITH_INVALID_TOKEN", "ROOM_FORBIDDEN", "USER_FORBIDDEN", "KICKED_OUT", "ROOM_DISMISS", "DUPLICATE_LOGIN", "WITHOUT_LICENSE_AUTHENTICATE_SDK", "SERVER_LICENSE_EXPIRED", "EXCEEDS_THE_UPPER_LIMIT", "LICENSE_PARAMETER_ERROR", "LICENSE_FILE_PATH_ERROR", "LICENSE_ILLEGAL", "LICENSE_EXPIRED", "LICENSE_INFORMATION_NOT_MATCH", "LICENSE_NOT_MATCH_WITH_CACHE", "LICENSE_FUNCTION_NOT_FOUND", "STATE_ABNORMAL_SERVER_STATUS", "UNKNOWN", "live_extension_plugin_api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum LiveWrappedRoomStateChangeReason extends Enum<LiveWrappedRoomStateChangeReason> {
    public static final a Companion = null;
    public static final LiveWrappedRoomStateChangeReason DUPLICATE_LOGIN = null;
    public static final LiveWrappedRoomStateChangeReason EXCEEDS_THE_UPPER_LIMIT = null;
    public static final LiveWrappedRoomStateChangeReason INVALID_TOKEN = null;
    public static final LiveWrappedRoomStateChangeReason JOIN_ROOM = null;
    public static final LiveWrappedRoomStateChangeReason JOIN_ROOM_FAILED = null;
    public static final LiveWrappedRoomStateChangeReason KICKED_OUT = null;
    public static final LiveWrappedRoomStateChangeReason LEAVE_ROOM = null;
    public static final LiveWrappedRoomStateChangeReason LICENSE_EXPIRED = null;
    public static final LiveWrappedRoomStateChangeReason LICENSE_FILE_PATH_ERROR = null;
    public static final LiveWrappedRoomStateChangeReason LICENSE_FUNCTION_NOT_FOUND = null;
    public static final LiveWrappedRoomStateChangeReason LICENSE_ILLEGAL = null;
    public static final LiveWrappedRoomStateChangeReason LICENSE_INFORMATION_NOT_MATCH = null;
    public static final LiveWrappedRoomStateChangeReason LICENSE_NOT_MATCH_WITH_CACHE = null;
    public static final LiveWrappedRoomStateChangeReason LICENSE_PARAMETER_ERROR = null;
    public static final LiveWrappedRoomStateChangeReason RECONNECT = null;
    public static final LiveWrappedRoomStateChangeReason ROOM_DISMISS = null;
    public static final LiveWrappedRoomStateChangeReason ROOM_FORBIDDEN = null;
    public static final LiveWrappedRoomStateChangeReason SERVER_LICENSE_EXPIRED = null;
    public static final LiveWrappedRoomStateChangeReason STATE_ABNORMAL_SERVER_STATUS = null;
    public static final LiveWrappedRoomStateChangeReason TOKEN_EXPIRED = null;
    public static final LiveWrappedRoomStateChangeReason UNKNOWN = null;
    public static final LiveWrappedRoomStateChangeReason UPDATE_TOKEN_WITH_INVALID_TOKEN = null;
    public static final LiveWrappedRoomStateChangeReason USER_FORBIDDEN = null;
    public static final LiveWrappedRoomStateChangeReason WITHOUT_LICENSE_AUTHENTICATE_SDK = null;
    public static final /* synthetic */ LiveWrappedRoomStateChangeReason[] a = null;
    private final int value;

    public static LiveWrappedRoomStateChangeReason valueOf(String r1) {
        return (LiveWrappedRoomStateChangeReason) r27.a.a(LiveWrappedRoomStateChangeReason.class, r1);
    }

    public static LiveWrappedRoomStateChangeReason[] values() {
        return (LiveWrappedRoomStateChangeReason[]) a.clone();
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [com.bytedance.android.livesdk.live.extension.plugin.api.rtc.engine.type.LiveWrappedRoomStateChangeReason$a] */
    static {
        LiveWrappedRoomStateChangeReason r1 = new LiveWrappedRoomStateChangeReason("JOIN_ROOM", 0, 0);
        JOIN_ROOM = r1;
        LiveWrappedRoomStateChangeReason r2 = new LiveWrappedRoomStateChangeReason("RECONNECT", 1, 1);
        RECONNECT = r2;
        LiveWrappedRoomStateChangeReason r3 = new LiveWrappedRoomStateChangeReason("LEAVE_ROOM", 2, 2);
        LEAVE_ROOM = r3;
        LiveWrappedRoomStateChangeReason r4 = new LiveWrappedRoomStateChangeReason("JOIN_ROOM_FAILED", 3, -2001);
        JOIN_ROOM_FAILED = r4;
        LiveWrappedRoomStateChangeReason r5 = new LiveWrappedRoomStateChangeReason("INVALID_TOKEN", 4, -1000);
        INVALID_TOKEN = r5;
        LiveWrappedRoomStateChangeReason r6 = new LiveWrappedRoomStateChangeReason("TOKEN_EXPIRED", 5, -1009);
        TOKEN_EXPIRED = r6;
        LiveWrappedRoomStateChangeReason r7 = new LiveWrappedRoomStateChangeReason("UPDATE_TOKEN_WITH_INVALID_TOKEN", 6, -1010);
        UPDATE_TOKEN_WITH_INVALID_TOKEN = r7;
        LiveWrappedRoomStateChangeReason r8 = new LiveWrappedRoomStateChangeReason("ROOM_FORBIDDEN", 7, -1025);
        ROOM_FORBIDDEN = r8;
        LiveWrappedRoomStateChangeReason r9 = new LiveWrappedRoomStateChangeReason("USER_FORBIDDEN", 8, -1026);
        USER_FORBIDDEN = r9;
        LiveWrappedRoomStateChangeReason r10 = new LiveWrappedRoomStateChangeReason("KICKED_OUT", 9, -1006);
        KICKED_OUT = r10;
        LiveWrappedRoomStateChangeReason r11 = new LiveWrappedRoomStateChangeReason("ROOM_DISMISS", 10, -1011);
        ROOM_DISMISS = r11;
        LiveWrappedRoomStateChangeReason r12 = new LiveWrappedRoomStateChangeReason("DUPLICATE_LOGIN", 11, -1004);
        DUPLICATE_LOGIN = r12;
        LiveWrappedRoomStateChangeReason r13 = new LiveWrappedRoomStateChangeReason("WITHOUT_LICENSE_AUTHENTICATE_SDK", 12, -1012);
        WITHOUT_LICENSE_AUTHENTICATE_SDK = r13;
        LiveWrappedRoomStateChangeReason r14 = new LiveWrappedRoomStateChangeReason("SERVER_LICENSE_EXPIRED", 13, -1017);
        SERVER_LICENSE_EXPIRED = r14;
        LiveWrappedRoomStateChangeReason r15 = new LiveWrappedRoomStateChangeReason("EXCEEDS_THE_UPPER_LIMIT", 14, -1018);
        EXCEEDS_THE_UPPER_LIMIT = r15;
        LiveWrappedRoomStateChangeReason r16 = new LiveWrappedRoomStateChangeReason("LICENSE_PARAMETER_ERROR", 15, -1019);
        LICENSE_PARAMETER_ERROR = r16;
        LiveWrappedRoomStateChangeReason r17 = new LiveWrappedRoomStateChangeReason("LICENSE_FILE_PATH_ERROR", 16, -1020);
        LICENSE_FILE_PATH_ERROR = r17;
        LiveWrappedRoomStateChangeReason r18 = new LiveWrappedRoomStateChangeReason("LICENSE_ILLEGAL", 17, -1021);
        LICENSE_ILLEGAL = r18;
        LiveWrappedRoomStateChangeReason r19 = new LiveWrappedRoomStateChangeReason("LICENSE_EXPIRED", 18, -1022);
        LICENSE_EXPIRED = r19;
        LiveWrappedRoomStateChangeReason r20 = new LiveWrappedRoomStateChangeReason("LICENSE_INFORMATION_NOT_MATCH", 19, -1023);
        LICENSE_INFORMATION_NOT_MATCH = r20;
        LiveWrappedRoomStateChangeReason r21 = new LiveWrappedRoomStateChangeReason("LICENSE_NOT_MATCH_WITH_CACHE", 20, -1024);
        LICENSE_NOT_MATCH_WITH_CACHE = r21;
        LiveWrappedRoomStateChangeReason r22 = new LiveWrappedRoomStateChangeReason("LICENSE_FUNCTION_NOT_FOUND", 21, -1027);
        LICENSE_FUNCTION_NOT_FOUND = r22;
        LiveWrappedRoomStateChangeReason r23 = new LiveWrappedRoomStateChangeReason("STATE_ABNORMAL_SERVER_STATUS", 22, -1084);
        STATE_ABNORMAL_SERVER_STATUS = r23;
        LiveWrappedRoomStateChangeReason r24 = new LiveWrappedRoomStateChangeReason("UNKNOWN", 23, -1001);
        UNKNOWN = r24;
        a = new LiveWrappedRoomStateChangeReason[]{r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22, r23, r24};
        Companion = new a();
    }

    public final int value() {
        return this.value;
    }

    public LiveWrappedRoomStateChangeReason(String r1, int r2, int r3) {
        super(r1, r2);
        this.value = r3;
    }
}
