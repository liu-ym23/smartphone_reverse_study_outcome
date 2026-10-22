package com.bytedance.realx.video;

/* JADX INFO: loaded from: classes21.dex */
public final enum RXVideoMemoryType extends Enum<RXVideoMemoryType> {
    private static final /* synthetic */ RXVideoMemoryType[] $VALUES = null;
    public static final RXVideoMemoryType kBYTE_MEMORY = null;
    public static final RXVideoMemoryType kOPENGL_TEXTURE = null;
    public static final RXVideoMemoryType kUNKNOWN = null;
    private int value;

    static {
        RXVideoMemoryType r100 = new RXVideoMemoryType("kUNKNOWN", 0, 0);
        kUNKNOWN = r100;
        RXVideoMemoryType r101 = new RXVideoMemoryType("kBYTE_MEMORY", 1, 1);
        kBYTE_MEMORY = r101;
        RXVideoMemoryType r102 = new RXVideoMemoryType("kOPENGL_TEXTURE", 2, 3);
        kOPENGL_TEXTURE = r102;
        $VALUES = new RXVideoMemoryType[]{r100, r101, r102};
    }

    public static RXVideoMemoryType[] values() {
        return (RXVideoMemoryType[]) $VALUES.clone();
    }

    public int value() {
        return this.value;
    }

    public static RXVideoMemoryType fromId(int r100) {
        RXVideoMemoryType[] r101 = values();
        int r102 = r101.length;
        int r103 = 0;
    L3:
        if (r103 >= r102) goto L8;
        RXVideoMemoryType r104 = r101[r103];
        if (r104.value() == r100) goto L6;
        r103 = r103 + 1;
        goto L3
    L6:
        return r104;
    L8:
        return null;
    }

    public static RXVideoMemoryType valueOf(String r100) {
        return (RXVideoMemoryType) r27.a.a(RXVideoMemoryType.class, r100);
    }

    private RXVideoMemoryType(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
