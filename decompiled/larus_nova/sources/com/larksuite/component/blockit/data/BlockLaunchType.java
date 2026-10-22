package com.larksuite.component.blockit.data;

import r27.a;

/* JADX INFO: loaded from: classes24.dex */
public final enum BlockLaunchType extends Enum<BlockLaunchType> {
    public static final BlockLaunchType ENTITY = null;
    public static final BlockLaunchType ID = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ BlockLaunchType[] f282976a = null;

    static {
        BlockLaunchType r100 = new BlockLaunchType("ENTITY", 0);
        ENTITY = r100;
        BlockLaunchType r101 = new BlockLaunchType("ID", 1);
        ID = r101;
        f282976a = new BlockLaunchType[]{r100, r101};
    }

    public static BlockLaunchType[] values() {
        return (BlockLaunchType[]) f282976a.clone();
    }

    public static BlockLaunchType valueOf(String r100) {
        return (BlockLaunchType) a.a(BlockLaunchType.class, r100);
    }

    public BlockLaunchType(String r100, int r101) {
        super(r100, r101);
    }
}
