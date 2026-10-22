package com.bytedance.android.livesdk.livecommerce.room.utils;

import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\n\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\f"}, d2 = {"Lcom/bytedance/android/livesdk/livecommerce/room/utils/LiveRoomRedirectPriority;", "", "", "value", "I", "getValue", "()I", "UNDEFINED", "ENTER_ROOM", "ROOM_ENTER", "TOOL_BAR_CONTROL_MESSAGE", "LIVE_HIGH_HEAT_MESSAGE", "livecommerce_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum LiveRoomRedirectPriority extends Enum<LiveRoomRedirectPriority> {
    public static final LiveRoomRedirectPriority ENTER_ROOM = null;
    public static final LiveRoomRedirectPriority LIVE_HIGH_HEAT_MESSAGE = null;
    public static final LiveRoomRedirectPriority ROOM_ENTER = null;
    public static final LiveRoomRedirectPriority TOOL_BAR_CONTROL_MESSAGE = null;
    public static final LiveRoomRedirectPriority UNDEFINED = null;
    public static final /* synthetic */ LiveRoomRedirectPriority[] a = null;
    private final int value;

    static {
        LiveRoomRedirectPriority r1 = new LiveRoomRedirectPriority("UNDEFINED", 0, -1);
        UNDEFINED = r1;
        LiveRoomRedirectPriority r2 = new LiveRoomRedirectPriority("ENTER_ROOM", 1, 0);
        ENTER_ROOM = r2;
        LiveRoomRedirectPriority r3 = new LiveRoomRedirectPriority("ROOM_ENTER", 2, 1);
        ROOM_ENTER = r3;
        LiveRoomRedirectPriority r4 = new LiveRoomRedirectPriority("TOOL_BAR_CONTROL_MESSAGE", 3, 2);
        TOOL_BAR_CONTROL_MESSAGE = r4;
        LiveRoomRedirectPriority r5 = new LiveRoomRedirectPriority("LIVE_HIGH_HEAT_MESSAGE", 4, 3);
        LIVE_HIGH_HEAT_MESSAGE = r5;
        a = new LiveRoomRedirectPriority[]{r1, r2, r3, r4, r5};
    }

    public static LiveRoomRedirectPriority valueOf(String r1) {
        return (LiveRoomRedirectPriority) r27.a.a(LiveRoomRedirectPriority.class, r1);
    }

    public static LiveRoomRedirectPriority[] values() {
        return (LiveRoomRedirectPriority[]) a.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public LiveRoomRedirectPriority(String r1, int r2, int r3) {
        super(r1, r2);
        this.value = r3;
    }
}
