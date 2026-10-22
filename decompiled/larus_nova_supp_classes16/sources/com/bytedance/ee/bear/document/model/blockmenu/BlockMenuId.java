package com.bytedance.ee.bear.document.model.blockmenu;

import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
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
    public static final /* synthetic */ BlockMenuId[] a = null;

    static {
        BlockMenuId r0 = new BlockMenuId("CUT", 0);
        CUT = r0;
        BlockMenuId r1 = new BlockMenuId("COMMENT", 1);
        COMMENT = r1;
        BlockMenuId r3 = new BlockMenuId("COPY", 2);
        COPY = r3;
        BlockMenuId r5 = new BlockMenuId("CONTENT_REACTION", 3);
        CONTENT_REACTION = r5;
        BlockMenuId r7 = new BlockMenuId("DELETE", 4);
        DELETE = r7;
        BlockMenuId r9 = new BlockMenuId("COPY_LINK", 5);
        COPY_LINK = r9;
        BlockMenuId r11 = new BlockMenuId("DEBUG_CREATOR", 6);
        DEBUG_CREATOR = r11;
        BlockMenuId r13 = new BlockMenuId("DEBUG_BLOCK", 7);
        DEBUG_BLOCK = r13;
        BlockMenuId r16 = new BlockMenuId("REFRESH_BLOCK", 8);
        REFRESH_BLOCK = r16;
        a = new BlockMenuId[]{r0, r1, r3, r5, r7, r9, r11, r13, r16};
    }

    public static BlockMenuId[] values() {
        return (BlockMenuId[]) a.clone();
    }

    public static BlockMenuId valueOf(String r1) {
        return (BlockMenuId) a.a(BlockMenuId.class, r1);
    }

    public BlockMenuId(String r1, int r2) {
        super(r1, r2);
    }
}
