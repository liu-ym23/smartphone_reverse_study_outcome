package com.ss.bytertc.engine.data;

import r27.a;

/* JADX INFO: loaded from: classes40.dex */
public final enum VideoBufferType extends Enum<VideoBufferType> {
    private static final /* synthetic */ VideoBufferType[] $VALUES = null;
    public static final VideoBufferType GL_TEXTURE = null;
    public static final VideoBufferType RAW_MEMORY = null;
    private int value;

    static {
        VideoBufferType r100 = new VideoBufferType("RAW_MEMORY", 0, 0);
        RAW_MEMORY = r100;
        VideoBufferType r101 = new VideoBufferType("GL_TEXTURE", 1, 2);
        GL_TEXTURE = r101;
        $VALUES = new VideoBufferType[]{r100, r101};
    }

    public static VideoBufferType[] values() {
        return (VideoBufferType[]) $VALUES.clone();
    }

    @Override // java.lang.Enum
    public String toString() {
        if (this != RAW_MEMORY) goto L5;
        return "kVideoBufferTypeRawMemory";
    L5:
        return "kVideoBufferTypeGLTexture";
    }

    public int value() {
        return this.value;
    }

    public static VideoBufferType fromId(int r100) {
        VideoBufferType[] r101 = values();
        int r102 = r101.length;
        int r103 = 0;
    L3:
        if (r103 >= r102) goto L8;
        VideoBufferType r104 = r101[r103];
        if (r104.value() == r100) goto L6;
        r103 = r103 + 1;
        goto L3
    L6:
        return r104;
    L8:
        return null;
    }

    public static VideoBufferType valueOf(String r100) {
        return (VideoBufferType) a.a(VideoBufferType.class, r100);
    }

    private VideoBufferType(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
