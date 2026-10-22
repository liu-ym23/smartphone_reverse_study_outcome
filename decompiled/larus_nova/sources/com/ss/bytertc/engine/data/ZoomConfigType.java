package com.ss.bytertc.engine.data;

import r27.a;

/* JADX INFO: loaded from: classes40.dex */
public final enum ZoomConfigType extends Enum<ZoomConfigType> {
    private static final /* synthetic */ ZoomConfigType[] $VALUES = null;
    public static final ZoomConfigType ZOOM_FOCUS_OFFSET = null;
    public static final ZoomConfigType ZOOM_MOVE_OFFSET = null;
    private int value;

    static {
        ZoomConfigType r100 = new ZoomConfigType("ZOOM_FOCUS_OFFSET", 0, 0);
        ZOOM_FOCUS_OFFSET = r100;
        ZoomConfigType r101 = new ZoomConfigType("ZOOM_MOVE_OFFSET", 1, 1);
        ZOOM_MOVE_OFFSET = r101;
        $VALUES = new ZoomConfigType[]{r100, r101};
    }

    public static ZoomConfigType[] values() {
        return (ZoomConfigType[]) $VALUES.clone();
    }

    public int value() {
        return this.value;
    }

    public static ZoomConfigType fromId(int r100) {
        ZoomConfigType[] r101 = values();
        int r102 = r101.length;
        int r103 = 0;
    L3:
        if (r103 >= r102) goto L8;
        ZoomConfigType r104 = r101[r103];
        if (r104.value() == r100) goto L6;
        r103 = r103 + 1;
        goto L3
    L6:
        return r104;
    L8:
        return null;
    }

    public static ZoomConfigType valueOf(String r100) {
        return (ZoomConfigType) a.a(ZoomConfigType.class, r100);
    }

    private ZoomConfigType(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
