package com.bytedance.ee.bear.document.model.blockmenu;

import r27.a;

/* JADX INFO: loaded from: classes16.dex */
public final enum BlockMenuId extends Enum<BlockMenuId> {
    public static final BlockMenuId COMMENT = null;
    public static final BlockMenuId CONTENT_REACTION = null;
    public static final BlockMenuId COPY = null;
    public static final BlockMenuId COPY_LINK = null;
    public static final BlockMenuId CUT = null;
    public static final BlockMenuId DEBUG_BLOCK = null;
    public static final BlockMenuId DEBUG_CREATOR = null;
    public static final BlockMenuId DELETE = null;
    public static final BlockMenuId REFRESH_BLOCK = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ BlockMenuId[] f220257a = null;

    static {
        BlockMenuId r100 = new BlockMenuId("CUT", 0);
        CUT = r100;
        BlockMenuId r101 = new BlockMenuId("COMMENT", 1);
        COMMENT = r101;
        BlockMenuId r102 = new BlockMenuId("COPY", 2);
        COPY = r102;
        BlockMenuId r103 = new BlockMenuId("CONTENT_REACTION", 3);
        CONTENT_REACTION = r103;
        BlockMenuId r104 = new BlockMenuId("DELETE", 4);
        DELETE = r104;
        BlockMenuId r105 = new BlockMenuId("COPY_LINK", 5);
        COPY_LINK = r105;
        BlockMenuId r110 = new BlockMenuId("DEBUG_CREATOR", 6);
        DEBUG_CREATOR = r110;
        BlockMenuId r111 = new BlockMenuId("DEBUG_BLOCK", 7);
        DEBUG_BLOCK = r111;
        BlockMenuId r112 = new BlockMenuId("REFRESH_BLOCK", 8);
        REFRESH_BLOCK = r112;
        f220257a = new BlockMenuId[]{r100, r101, r102, r103, r104, r105, r110, r111, r112};
    }

    public static BlockMenuId[] values() {
        return (BlockMenuId[]) f220257a.clone();
    }

    public static BlockMenuId valueOf(String r100) {
        return (BlockMenuId) a.a(BlockMenuId.class, r100);
    }

    public BlockMenuId(String r100, int r101) {
        super(r100, r101);
    }
}
