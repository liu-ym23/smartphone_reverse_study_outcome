package com.bytedance.ee.bear.bitable.homepage;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/bytedance/ee/bear/bitable/homepage/BitableTabType;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "RECOMMEND", "MINE", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum BitableTabType extends Enum<BitableTabType> {
    public static final BitableTabType MINE = null;
    public static final BitableTabType RECOMMEND = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ BitableTabType[] f212240a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f212241b = null;
    private final int value;

    public static EnumEntries<BitableTabType> getEntries() {
        return f212241b;
    }

    static {
        BitableTabType r100 = new BitableTabType("RECOMMEND", 0, 0);
        RECOMMEND = r100;
        BitableTabType r101 = new BitableTabType("MINE", 1, 1);
        MINE = r101;
        BitableTabType[] r102 = {r100, r101};
        f212240a = r102;
        f212241b = EnumEntriesKt.enumEntries(r102);
    }

    public static BitableTabType[] values() {
        return (BitableTabType[]) f212240a.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public static BitableTabType valueOf(String r100) {
        return (BitableTabType) r27.a.a(BitableTabType.class, r100);
    }

    public BitableTabType(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
