package com.bytedance.iesgurd.core;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\t\b\u0080\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/bytedance/iesgurd/core/BlockType;", "", "", "type", "I", "getType", "()I", "LAZY_UPDATE", "CLEAN_BLOCKLIST", "LOW_STORAGE", "OCCASION_UPDATE", "geckox_noasanRelease"}, k = 1, mv = {1, 4, 0})
public final enum BlockType extends Enum<BlockType> {
    public static final BlockType CLEAN_BLOCKLIST = null;
    public static final BlockType LAZY_UPDATE = null;
    public static final BlockType LOW_STORAGE = null;
    public static final BlockType OCCASION_UPDATE = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ BlockType[] f250630a = null;
    private final int type;

    static {
        BlockType r100 = new BlockType("LAZY_UPDATE", 0, 1);
        LAZY_UPDATE = r100;
        BlockType r101 = new BlockType("CLEAN_BLOCKLIST", 1, 2);
        CLEAN_BLOCKLIST = r101;
        BlockType r102 = new BlockType("LOW_STORAGE", 2, 3);
        LOW_STORAGE = r102;
        BlockType r103 = new BlockType("OCCASION_UPDATE", 3, 4);
        OCCASION_UPDATE = r103;
        f250630a = new BlockType[]{r100, r101, r102, r103};
    }

    public static BlockType valueOf(String r100) {
        return (BlockType) r27.a.a(BlockType.class, r100);
    }

    public static BlockType[] values() {
        return (BlockType[]) f250630a.clone();
    }

    public final int getType() {
        return this.type;
    }

    public BlockType(String r100, int r101, int r102) {
        super(r100, r101);
        this.type = r102;
    }
}
