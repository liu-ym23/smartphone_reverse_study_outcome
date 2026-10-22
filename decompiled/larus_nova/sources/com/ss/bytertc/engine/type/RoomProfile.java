package com.ss.bytertc.engine.type;

import r27.a;

/* JADX INFO: loaded from: classes40.dex */
public final enum RoomProfile extends Enum<RoomProfile> {
    private static final /* synthetic */ RoomProfile[] $VALUES = null;
    public static final RoomProfile CALL = null;
    public static final RoomProfile CHAT_ROOM = null;
    public static final RoomProfile CHORUS = null;
    public static final RoomProfile CLASSROOM = null;
    public static final RoomProfile CLOUD_GAME = null;
    public static final RoomProfile COMMUNICATION = null;
    public static final RoomProfile GAME = null;
    public static final RoomProfile GAME_STREAMING = null;
    public static final RoomProfile INTERACTIVE_PODCAST = null;
    public static final RoomProfile LIVE = null;
    public static final RoomProfile LOW_LATENCY = null;
    public static final RoomProfile MEETING = null;
    public static final RoomProfile MEETING_ROOM = null;
    private final int value;

    static {
        RoomProfile r100 = new RoomProfile("COMMUNICATION", 0, 0);
        COMMUNICATION = r100;
        RoomProfile r101 = new RoomProfile("GAME", 1, 2);
        GAME = r101;
        RoomProfile r102 = new RoomProfile("CLOUD_GAME", 2, 3);
        CLOUD_GAME = r102;
        RoomProfile r103 = new RoomProfile("LOW_LATENCY", 3, 4);
        LOW_LATENCY = r103;
        RoomProfile r104 = new RoomProfile("CHAT_ROOM", 4, 6);
        CHAT_ROOM = r104;
        RoomProfile r110 = new RoomProfile("INTERACTIVE_PODCAST", 5, 10);
        INTERACTIVE_PODCAST = r110;
        RoomProfile r111 = new RoomProfile("CHORUS", 6, 12);
        CHORUS = r111;
        RoomProfile r112 = new RoomProfile("GAME_STREAMING", 7, 14);
        GAME_STREAMING = r112;
        RoomProfile r105 = new RoomProfile("MEETING", 8, 16);
        MEETING = r105;
        RoomProfile r106 = new RoomProfile("MEETING_ROOM", 9, 17);
        MEETING_ROOM = r106;
        RoomProfile r107 = new RoomProfile("CLASSROOM", 10, 18);
        CLASSROOM = r107;
        RoomProfile r108 = new RoomProfile("CALL", 11, 19);
        CALL = r108;
        RoomProfile r113 = new RoomProfile("LIVE", 12, 20);
        LIVE = r113;
        $VALUES = new RoomProfile[]{r100, r101, r102, r103, r104, r110, r111, r112, r105, r106, r107, r108, r113};
    }

    public static RoomProfile[] values() {
        return (RoomProfile[]) $VALUES.clone();
    }

    public int value() {
        return this.value;
    }

    public static RoomProfile fromId(int r100) {
        RoomProfile[] r101 = values();
        int r102 = r101.length;
        int r103 = 0;
    L3:
        if (r103 >= r102) goto L9;
        RoomProfile r104 = r101[r103];
        if (r104.value() == r100) goto L6;
        r103 = r103 + 1;
        goto L3
    L6:
        return r104;
    L9:
        return COMMUNICATION;
    }

    public static RoomProfile valueOf(String r100) {
        return (RoomProfile) a.a(RoomProfile.class, r100);
    }

    private RoomProfile(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
