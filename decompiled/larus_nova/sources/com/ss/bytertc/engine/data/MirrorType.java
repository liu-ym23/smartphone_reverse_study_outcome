package com.ss.bytertc.engine.data;

import r27.a;

/* JADX INFO: loaded from: classes40.dex */
public final enum MirrorType extends Enum<MirrorType> {
    private static final /* synthetic */ MirrorType[] $VALUES = null;
    public static final MirrorType MIRROR_TYPE_NONE = null;
    public static final MirrorType MIRROR_TYPE_RENDER = null;
    public static final MirrorType MIRROR_TYPE_RENDER_AND_ENCODER = null;
    private int value;

    static {
        MirrorType r100 = new MirrorType("MIRROR_TYPE_NONE", 0, 0);
        MIRROR_TYPE_NONE = r100;
        MirrorType r101 = new MirrorType("MIRROR_TYPE_RENDER", 1, 1);
        MIRROR_TYPE_RENDER = r101;
        MirrorType r102 = new MirrorType("MIRROR_TYPE_RENDER_AND_ENCODER", 2, 3);
        MIRROR_TYPE_RENDER_AND_ENCODER = r102;
        $VALUES = new MirrorType[]{r100, r101, r102};
    }

    public static MirrorType[] values() {
        return (MirrorType[]) $VALUES.clone();
    }

    @Override // java.lang.Enum
    public String toString() {
        if (this != MIRROR_TYPE_NONE) goto L7;
        return "kMirrorTypeNone";
    L7:
        if (this != MIRROR_TYPE_RENDER) goto L11;
        return "kMirrorTypeRender";
    L11:
        if (this != MIRROR_TYPE_RENDER_AND_ENCODER) goto L14;
        return "kMirrorTypeRenderAndEncoder";
    L14:
        return "";
    }

    public int value() {
        return this.value;
    }

    public static MirrorType fromId(int r100) {
        MirrorType[] r101 = values();
        int r102 = r101.length;
        int r103 = 0;
    L3:
        if (r103 >= r102) goto L8;
        MirrorType r104 = r101[r103];
        if (r104.value() == r100) goto L6;
        r103 = r103 + 1;
        goto L3
    L6:
        return r104;
    L8:
        return null;
    }

    public static MirrorType valueOf(String r100) {
        return (MirrorType) a.a(MirrorType.class, r100);
    }

    private MirrorType(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
