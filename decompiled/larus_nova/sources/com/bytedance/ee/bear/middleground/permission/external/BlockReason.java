package com.bytedance.ee.bear.middleground.permission.external;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes18.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/bytedance/ee/bear/middleground/permission/external/BlockReason;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "BLOCK_BY_SECRET", "BLOCK_BY_PUBLIC_PERM", "middleground-permission-model_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum BlockReason extends Enum<BlockReason> {
    public static final BlockReason BLOCK_BY_PUBLIC_PERM = null;
    public static final BlockReason BLOCK_BY_SECRET = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ BlockReason[] f233879a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f233880b = null;
    private final int value;

    public static EnumEntries<BlockReason> getEntries() {
        return f233880b;
    }

    static {
        BlockReason r100 = new BlockReason("BLOCK_BY_SECRET", 0, 432);
        BLOCK_BY_SECRET = r100;
        BlockReason r101 = new BlockReason("BLOCK_BY_PUBLIC_PERM", 1, 133);
        BLOCK_BY_PUBLIC_PERM = r101;
        BlockReason[] r102 = {r100, r101};
        f233879a = r102;
        f233880b = EnumEntriesKt.enumEntries(r102);
    }

    public static BlockReason[] values() {
        return (BlockReason[]) f233879a.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public static BlockReason valueOf(String r100) {
        return (BlockReason) a.a(BlockReason.class, r100);
    }

    public BlockReason(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
