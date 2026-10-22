package com.larksuite.component.blockit.entity;

/* JADX INFO: loaded from: classes24.dex */
public final enum BlockitEnv extends Enum<BlockitEnv> {
    public static final BlockitEnv BOE = null;
    public static final BlockitEnv ONLINE = null;
    public static final BlockitEnv PRE_RELEASE = null;
    public static final BlockitEnv STAGING = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ BlockitEnv[] f282981a = null;
    private int value;

    static {
        BlockitEnv r100 = new BlockitEnv("ONLINE", 0, 0);
        ONLINE = r100;
        BlockitEnv r101 = new BlockitEnv("PRE_RELEASE", 1, 1);
        PRE_RELEASE = r101;
        BlockitEnv r102 = new BlockitEnv("STAGING", 2, 2);
        STAGING = r102;
        BlockitEnv r103 = new BlockitEnv("BOE", 3, 3);
        BOE = r103;
        f282981a = new BlockitEnv[]{r100, r101, r102, r103};
    }

    public static BlockitEnv[] values() {
        return (BlockitEnv[]) f282981a.clone();
    }

    public int getNumber() {
        return this.value;
    }

    public static BlockitEnv forNumber(int r100) {
        if (r100 == 0) goto L18;
        if (r100 == 1) goto L16;
        if (r100 == 2) goto L14;
        if (r100 == 3) goto L12;
        return null;
    L12:
        return BOE;
    L14:
        return STAGING;
    L16:
        return PRE_RELEASE;
    L18:
        return ONLINE;
    }

    public static BlockitEnv valueOf(String r100) {
        return (BlockitEnv) r27.a.a(BlockitEnv.class, r100);
    }

    public static BlockitEnv valueOf(int r100) {
        return forNumber(r100);
    }

    public BlockitEnv(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
