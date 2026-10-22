package com.larksuite.component.openplatform.api.entity;

import r27.a;

/* JADX INFO: loaded from: classes24.dex */
public final enum BlockDataSourceService$DataInitMode extends Enum<BlockDataSourceService$DataInitMode> {
    public static final BlockDataSourceService$DataInitMode LAZY_EVERY = null;
    public static final BlockDataSourceService$DataInitMode LAZY_ONCE = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ BlockDataSourceService$DataInitMode[] f284030a = null;

    static {
        BlockDataSourceService$DataInitMode r100 = new BlockDataSourceService$DataInitMode("LAZY_ONCE", 0);
        LAZY_ONCE = r100;
        BlockDataSourceService$DataInitMode r101 = new BlockDataSourceService$DataInitMode("LAZY_EVERY", 1);
        LAZY_EVERY = r101;
        f284030a = new BlockDataSourceService$DataInitMode[]{r100, r101};
    }

    public static BlockDataSourceService$DataInitMode[] values() {
        return (BlockDataSourceService$DataInitMode[]) f284030a.clone();
    }

    public static BlockDataSourceService$DataInitMode valueOf(String r100) {
        return (BlockDataSourceService$DataInitMode) a.a(BlockDataSourceService$DataInitMode.class, r100);
    }

    public BlockDataSourceService$DataInitMode(String r100, int r101) {
        super(r100, r101);
    }
}
