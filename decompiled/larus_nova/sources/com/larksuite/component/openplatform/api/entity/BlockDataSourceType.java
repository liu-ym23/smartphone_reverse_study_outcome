package com.larksuite.component.openplatform.api.entity;

import r27.a;

/* JADX INFO: loaded from: classes24.dex */
public final enum BlockDataSourceType extends Enum<BlockDataSourceType> {
    public static final BlockDataSourceType ENTITY = null;
    public static final BlockDataSourceType GUIDE_INFO = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ BlockDataSourceType[] f284031a = null;
    public String type;

    static {
        BlockDataSourceType r100 = new BlockDataSourceType("ENTITY", 0, "entity");
        ENTITY = r100;
        BlockDataSourceType r101 = new BlockDataSourceType("GUIDE_INFO", 1, "guideInfo");
        GUIDE_INFO = r101;
        f284031a = new BlockDataSourceType[]{r100, r101};
    }

    public static BlockDataSourceType[] values() {
        return (BlockDataSourceType[]) f284031a.clone();
    }

    public static BlockDataSourceType valueOf(String r100) {
        return (BlockDataSourceType) a.a(BlockDataSourceType.class, r100);
    }

    public BlockDataSourceType(String r100, int r101, String r102) {
        super(r100, r101);
        this.type = r102;
    }
}
