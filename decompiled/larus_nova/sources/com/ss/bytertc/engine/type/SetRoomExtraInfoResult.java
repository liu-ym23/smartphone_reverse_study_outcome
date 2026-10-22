package com.ss.bytertc.engine.type;

import com.ss.android.ttvecamera.TECameraResult;
import r27.a;

/* JADX INFO: loaded from: classes40.dex */
public final enum SetRoomExtraInfoResult extends Enum<SetRoomExtraInfoResult> {
    private static final /* synthetic */ SetRoomExtraInfoResult[] $VALUES = null;
    public static final SetRoomExtraInfoResult KEY_IS_EMPTY = null;
    public static final SetRoomExtraInfoResult KEY_IS_NULL = null;
    public static final SetRoomExtraInfoResult KEY_TOO_LONG = null;
    public static final SetRoomExtraInfoResult NOT_JOIN_ROOM = null;
    public static final SetRoomExtraInfoResult SERVER_ERROR = null;
    public static final SetRoomExtraInfoResult SILENT_USER = null;
    public static final SetRoomExtraInfoResult SUCCESS = null;
    public static final SetRoomExtraInfoResult TOO_OFTEN = null;
    public static final SetRoomExtraInfoResult UNKNOW = null;
    public static final SetRoomExtraInfoResult VALUE_IS_NULL = null;
    public static final SetRoomExtraInfoResult VALUE_TOO_LONG = null;
    private final int value;

    static {
        SetRoomExtraInfoResult r100 = new SetRoomExtraInfoResult("SUCCESS", 0, 0);
        SUCCESS = r100;
        SetRoomExtraInfoResult r101 = new SetRoomExtraInfoResult("NOT_JOIN_ROOM", 1, -1);
        NOT_JOIN_ROOM = r101;
        SetRoomExtraInfoResult r102 = new SetRoomExtraInfoResult("KEY_IS_NULL", 2, -2);
        KEY_IS_NULL = r102;
        SetRoomExtraInfoResult r103 = new SetRoomExtraInfoResult("VALUE_IS_NULL", 3, -3);
        VALUE_IS_NULL = r103;
        SetRoomExtraInfoResult r104 = new SetRoomExtraInfoResult("UNKNOW", 4, -99);
        UNKNOW = r104;
        SetRoomExtraInfoResult r105 = new SetRoomExtraInfoResult("KEY_IS_EMPTY", 5, -400);
        KEY_IS_EMPTY = r105;
        SetRoomExtraInfoResult r110 = new SetRoomExtraInfoResult("TOO_OFTEN", 6, -406);
        TOO_OFTEN = r110;
        SetRoomExtraInfoResult r111 = new SetRoomExtraInfoResult("SILENT_USER", 7, -412);
        SILENT_USER = r111;
        SetRoomExtraInfoResult r112 = new SetRoomExtraInfoResult("KEY_TOO_LONG", 8, -413);
        KEY_TOO_LONG = r112;
        SetRoomExtraInfoResult r113 = new SetRoomExtraInfoResult("VALUE_TOO_LONG", 9, TECameraResult.TER_CAMERA_EC_NOT_SUPPORT);
        VALUE_TOO_LONG = r113;
        SetRoomExtraInfoResult r114 = new SetRoomExtraInfoResult("SERVER_ERROR", 10, -500);
        SERVER_ERROR = r114;
        $VALUES = new SetRoomExtraInfoResult[]{r100, r101, r102, r103, r104, r105, r110, r111, r112, r113, r114};
    }

    public static SetRoomExtraInfoResult[] values() {
        return (SetRoomExtraInfoResult[]) $VALUES.clone();
    }

    public int value() {
        return this.value;
    }

    public static SetRoomExtraInfoResult fromId(int r100) {
        SetRoomExtraInfoResult[] r101 = values();
        int r102 = r101.length;
        int r103 = 0;
    L3:
        if (r103 >= r102) goto L9;
        SetRoomExtraInfoResult r104 = r101[r103];
        if (r104.value() == r100) goto L6;
        r103 = r103 + 1;
        goto L3
    L6:
        return r104;
    L9:
        return UNKNOW;
    }

    public static SetRoomExtraInfoResult valueOf(String r100) {
        return (SetRoomExtraInfoResult) a.a(SetRoomExtraInfoResult.class, r100);
    }

    private SetRoomExtraInfoResult(String r100, int r101) {
        super(r100, r101);
        this.value = 0;
    }

    private SetRoomExtraInfoResult(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
