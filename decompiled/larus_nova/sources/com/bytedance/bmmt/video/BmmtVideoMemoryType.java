package com.bytedance.bmmt.video;

/* JADX INFO: loaded from: classes8.dex */
public final enum BmmtVideoMemoryType extends Enum<BmmtVideoMemoryType> {
    private static final /* synthetic */ BmmtVideoMemoryType[] $VALUES = null;
    public static final BmmtVideoMemoryType kBYTE_MEMORY = null;
    public static final BmmtVideoMemoryType kOPENGL_TEXTURE = null;
    public static final BmmtVideoMemoryType kUNKNOWN = null;
    private int value;

    private static /* synthetic */ BmmtVideoMemoryType[] $values() {
        return new BmmtVideoMemoryType[]{kUNKNOWN, kBYTE_MEMORY, kOPENGL_TEXTURE};
    }

    static {
        kUNKNOWN = new BmmtVideoMemoryType("kUNKNOWN", 0, 0);
        kBYTE_MEMORY = new BmmtVideoMemoryType("kBYTE_MEMORY", 1, 1);
        kOPENGL_TEXTURE = new BmmtVideoMemoryType("kOPENGL_TEXTURE", 2, 3);
        $VALUES = $values();
    }

    public static BmmtVideoMemoryType[] values() {
        return (BmmtVideoMemoryType[]) $VALUES.clone();
    }

    public int value() {
        return this.value;
    }

    public static BmmtVideoMemoryType fromId(int r100) {
        BmmtVideoMemoryType[] r101 = values();
        int r102 = r101.length;
        int r103 = 0;
    L3:
        if (r103 >= r102) goto L8;
        BmmtVideoMemoryType r104 = r101[r103];
        if (r104.value() == r100) goto L6;
        r103 = r103 + 1;
        goto L3
    L6:
        return r104;
    L8:
        return null;
    }

    public static BmmtVideoMemoryType valueOf(String r100) {
        return (BmmtVideoMemoryType) r27.a.a(BmmtVideoMemoryType.class, r100);
    }

    private BmmtVideoMemoryType(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
