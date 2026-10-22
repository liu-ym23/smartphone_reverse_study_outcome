package com.ss.bytertc.engine.data;

import r27.a;

/* JADX INFO: loaded from: classes40.dex */
public final enum ZoomDirectionType extends Enum<ZoomDirectionType> {
    private static final /* synthetic */ ZoomDirectionType[] $VALUES = null;
    public static final ZoomDirectionType CAMERA_MOVE_DOWN = null;
    public static final ZoomDirectionType CAMERA_MOVE_LEFT = null;
    public static final ZoomDirectionType CAMERA_MOVE_RIGHT = null;
    public static final ZoomDirectionType CAMERA_MOVE_UP = null;
    public static final ZoomDirectionType CAMERA_RESET = null;
    public static final ZoomDirectionType CAMERA_ZOOM_IN = null;
    public static final ZoomDirectionType CAMERA_ZOOM_OUT = null;
    private int value;

    static {
        ZoomDirectionType r100 = new ZoomDirectionType("CAMERA_MOVE_LEFT", 0, 0);
        CAMERA_MOVE_LEFT = r100;
        ZoomDirectionType r101 = new ZoomDirectionType("CAMERA_MOVE_RIGHT", 1, 1);
        CAMERA_MOVE_RIGHT = r101;
        ZoomDirectionType r102 = new ZoomDirectionType("CAMERA_MOVE_UP", 2, 2);
        CAMERA_MOVE_UP = r102;
        ZoomDirectionType r103 = new ZoomDirectionType("CAMERA_MOVE_DOWN", 3, 3);
        CAMERA_MOVE_DOWN = r103;
        ZoomDirectionType r104 = new ZoomDirectionType("CAMERA_ZOOM_OUT", 4, 4);
        CAMERA_ZOOM_OUT = r104;
        ZoomDirectionType r105 = new ZoomDirectionType("CAMERA_ZOOM_IN", 5, 5);
        CAMERA_ZOOM_IN = r105;
        ZoomDirectionType r110 = new ZoomDirectionType("CAMERA_RESET", 6, 6);
        CAMERA_RESET = r110;
        $VALUES = new ZoomDirectionType[]{r100, r101, r102, r103, r104, r105, r110};
    }

    public static ZoomDirectionType[] values() {
        return (ZoomDirectionType[]) $VALUES.clone();
    }

    public int value() {
        return this.value;
    }

    public static ZoomDirectionType fromId(int r100) {
        ZoomDirectionType[] r101 = values();
        int r102 = r101.length;
        int r103 = 0;
    L3:
        if (r103 >= r102) goto L8;
        ZoomDirectionType r104 = r101[r103];
        if (r104.value() == r100) goto L6;
        r103 = r103 + 1;
        goto L3
    L6:
        return r104;
    L8:
        return null;
    }

    public static ZoomDirectionType valueOf(String r100) {
        return (ZoomDirectionType) a.a(ZoomDirectionType.class, r100);
    }

    private ZoomDirectionType(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
