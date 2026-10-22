package com.ss.bytertc.engine.data;

import com.bytedance.android.livesdk.chatroom.event.UserProfileEvent;
import r27.a;

/* JADX INFO: loaded from: classes40.dex */
public final enum LocalLogLevel extends Enum<LocalLogLevel> {
    private static final /* synthetic */ LocalLogLevel[] $VALUES = null;
    public static final LocalLogLevel ERROR = null;
    public static final LocalLogLevel INFO = null;
    public static final LocalLogLevel NONE = null;
    public static final LocalLogLevel WARNING = null;
    private int value;

    static {
        LocalLogLevel r100 = new LocalLogLevel("INFO", 0, 0);
        INFO = r100;
        LocalLogLevel r101 = new LocalLogLevel("WARNING", 1, 1);
        WARNING = r101;
        LocalLogLevel r102 = new LocalLogLevel("ERROR", 2, 2);
        ERROR = r102;
        LocalLogLevel r103 = new LocalLogLevel(UserProfileEvent.POSITION_NONE, 3, 3);
        NONE = r103;
        $VALUES = new LocalLogLevel[]{r100, r101, r102, r103};
    }

    public static LocalLogLevel[] values() {
        return (LocalLogLevel[]) $VALUES.clone();
    }

    public int getValue() {
        return this.value;
    }

    public static LocalLogLevel fromId(int r100) {
        LocalLogLevel[] r101 = values();
        int r102 = r101.length;
        int r103 = 0;
    L3:
        if (r103 >= r102) goto L9;
        LocalLogLevel r104 = r101[r103];
        if (r104.getValue() == r100) goto L6;
        r103 = r103 + 1;
        goto L3
    L6:
        return r104;
    L9:
        return WARNING;
    }

    public static LocalLogLevel valueOf(String r100) {
        return (LocalLogLevel) a.a(LocalLogLevel.class, r100);
    }

    private LocalLogLevel(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
