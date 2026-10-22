package com.bytedance.ee.bear.bitable.statistic;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/bytedance/ee/bear/bitable/statistic/BitableStatisticConstant$OpenFile$OpenType;", "", "value", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", "Main", "ShareRecord", "FastAdd", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum BitableStatisticConstant$OpenFile$OpenType extends Enum<BitableStatisticConstant$OpenFile$OpenType> {
    public static final BitableStatisticConstant$OpenFile$OpenType FastAdd = null;
    public static final BitableStatisticConstant$OpenFile$OpenType Main = null;
    public static final BitableStatisticConstant$OpenFile$OpenType ShareRecord = null;
    public static final /* synthetic */ BitableStatisticConstant$OpenFile$OpenType[] a = null;
    public static final /* synthetic */ EnumEntries b = null;
    private final String value;

    public static EnumEntries<BitableStatisticConstant$OpenFile$OpenType> getEntries() {
        return b;
    }

    static {
        BitableStatisticConstant$OpenFile$OpenType r0 = new BitableStatisticConstant$OpenFile$OpenType("Main", 0, "main");
        Main = r0;
        BitableStatisticConstant$OpenFile$OpenType r1 = new BitableStatisticConstant$OpenFile$OpenType("ShareRecord", 1, "share_record");
        ShareRecord = r1;
        BitableStatisticConstant$OpenFile$OpenType r2 = new BitableStatisticConstant$OpenFile$OpenType("FastAdd", 2, "base_add");
        FastAdd = r2;
        BitableStatisticConstant$OpenFile$OpenType[] r4 = {r0, r1, r2};
        a = r4;
        b = EnumEntriesKt.enumEntries(r4);
    }

    public static BitableStatisticConstant$OpenFile$OpenType[] values() {
        return (BitableStatisticConstant$OpenFile$OpenType[]) a.clone();
    }

    public final String getValue() {
        return this.value;
    }

    public static BitableStatisticConstant$OpenFile$OpenType valueOf(String r1) {
        return (BitableStatisticConstant$OpenFile$OpenType) r27.a.a(BitableStatisticConstant$OpenFile$OpenType.class, r1);
    }

    public BitableStatisticConstant$OpenFile$OpenType(String r1, int r2, String r3) {
        super(r1, r2);
        this.value = r3;
    }
}
