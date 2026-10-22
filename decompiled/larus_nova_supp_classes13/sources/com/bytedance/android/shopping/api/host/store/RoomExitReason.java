package com.bytedance.android.shopping.api.host.store;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u000b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\f"}, d2 = {"Lcom/bytedance/android/shopping/api/host/store/RoomExitReason;", "", "LIVE_DISTRIBUTION_EXIT", "NORMAL", "LIVE_END", "NEW_ROOM_CREATE", "USER_PASSIVE_KICTOUT", "USER_PROACTIVE_LEAVE", "ROOM_ERROR", "REPEAT_ENTER", "SLIDE", "OTHER", "ec-host-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum RoomExitReason extends Enum<RoomExitReason> {
    public static final RoomExitReason LIVE_DISTRIBUTION_EXIT = null;
    public static final RoomExitReason LIVE_END = null;
    public static final RoomExitReason NEW_ROOM_CREATE = null;
    public static final RoomExitReason NORMAL = null;
    public static final RoomExitReason OTHER = null;
    public static final RoomExitReason REPEAT_ENTER = null;
    public static final RoomExitReason ROOM_ERROR = null;
    public static final RoomExitReason SLIDE = null;
    public static final RoomExitReason USER_PASSIVE_KICTOUT = null;
    public static final RoomExitReason USER_PROACTIVE_LEAVE = null;
    public static final /* synthetic */ RoomExitReason[] a = null;

    static {
        RoomExitReason r1 = new RoomExitReason("LIVE_DISTRIBUTION_EXIT", 0);
        LIVE_DISTRIBUTION_EXIT = r1;
        RoomExitReason r2 = new RoomExitReason("NORMAL", 1);
        NORMAL = r2;
        RoomExitReason r3 = new RoomExitReason("LIVE_END", 2);
        LIVE_END = r3;
        RoomExitReason r4 = new RoomExitReason("NEW_ROOM_CREATE", 3);
        NEW_ROOM_CREATE = r4;
        RoomExitReason r5 = new RoomExitReason("USER_PASSIVE_KICTOUT", 4);
        USER_PASSIVE_KICTOUT = r5;
        RoomExitReason r6 = new RoomExitReason("USER_PROACTIVE_LEAVE", 5);
        USER_PROACTIVE_LEAVE = r6;
        RoomExitReason r7 = new RoomExitReason("ROOM_ERROR", 6);
        ROOM_ERROR = r7;
        RoomExitReason r8 = new RoomExitReason("REPEAT_ENTER", 7);
        REPEAT_ENTER = r8;
        RoomExitReason r9 = new RoomExitReason("SLIDE", 8);
        SLIDE = r9;
        RoomExitReason r10 = new RoomExitReason("OTHER", 9);
        OTHER = r10;
        a = new RoomExitReason[]{r1, r2, r3, r4, r5, r6, r7, r8, r9, r10};
    }

    public static RoomExitReason valueOf(String r1) {
        return (RoomExitReason) a.a(RoomExitReason.class, r1);
    }

    public static RoomExitReason[] values() {
        return (RoomExitReason[]) a.clone();
    }

    public RoomExitReason(String r1, int r2) {
        super(r1, r2);
    }
}
