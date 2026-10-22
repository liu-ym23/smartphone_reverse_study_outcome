package com.ss.bytertc.engine.data;

import r27.a;

/* JADX INFO: loaded from: classes40.dex */
public final enum MediaInputType extends Enum<MediaInputType> {
    private static final /* synthetic */ MediaInputType[] $VALUES = null;
    public static final MediaInputType MEDIA_INPUT_TYPE_EXTERNAL = null;
    public static final MediaInputType MEDIA_INPUT_TYPE_INTERNAL = null;
    private int value;

    static {
        MediaInputType r100 = new MediaInputType("MEDIA_INPUT_TYPE_EXTERNAL", 0, 0);
        MEDIA_INPUT_TYPE_EXTERNAL = r100;
        MediaInputType r101 = new MediaInputType("MEDIA_INPUT_TYPE_INTERNAL", 1, 1);
        MEDIA_INPUT_TYPE_INTERNAL = r101;
        $VALUES = new MediaInputType[]{r100, r101};
    }

    public static MediaInputType[] values() {
        return (MediaInputType[]) $VALUES.clone();
    }

    public int value() {
        return this.value;
    }

    public static MediaInputType fromId(int r100) {
        MediaInputType[] r101 = values();
        int r102 = r101.length;
        int r103 = 0;
    L3:
        if (r103 >= r102) goto L8;
        MediaInputType r104 = r101[r103];
        if (r104.value() == r100) goto L6;
        r103 = r103 + 1;
        goto L3
    L6:
        return r104;
    L8:
        return null;
    }

    public static MediaInputType valueOf(String r100) {
        return (MediaInputType) a.a(MediaInputType.class, r100);
    }

    private MediaInputType(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
