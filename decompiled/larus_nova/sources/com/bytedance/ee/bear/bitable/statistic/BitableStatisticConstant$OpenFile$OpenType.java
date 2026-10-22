package com.bytedance.ee.bear.bitable.statistic;

import com.bytedance.android.service.manager.pull.PullConfiguration;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes16.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/bytedance/ee/bear/bitable/statistic/BitableStatisticConstant$OpenFile$OpenType;", "", "value", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", "Main", "ShareRecord", "FastAdd", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum BitableStatisticConstant$OpenFile$OpenType extends Enum<BitableStatisticConstant$OpenFile$OpenType> {
    public static final BitableStatisticConstant$OpenFile$OpenType FastAdd = null;
    public static final BitableStatisticConstant$OpenFile$OpenType Main = null;
    public static final BitableStatisticConstant$OpenFile$OpenType ShareRecord = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ BitableStatisticConstant$OpenFile$OpenType[] f215592a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f215593b = null;
    private final String value;

    public static EnumEntries<BitableStatisticConstant$OpenFile$OpenType> getEntries() {
        return f215593b;
    }

    static {
        BitableStatisticConstant$OpenFile$OpenType r100 = new BitableStatisticConstant$OpenFile$OpenType("Main", 0, PullConfiguration.PROCESS_NAME_MAIN);
        Main = r100;
        BitableStatisticConstant$OpenFile$OpenType r101 = new BitableStatisticConstant$OpenFile$OpenType("ShareRecord", 1, "share_record");
        ShareRecord = r101;
        BitableStatisticConstant$OpenFile$OpenType r102 = new BitableStatisticConstant$OpenFile$OpenType("FastAdd", 2, "base_add");
        FastAdd = r102;
        BitableStatisticConstant$OpenFile$OpenType[] r103 = {r100, r101, r102};
        f215592a = r103;
        f215593b = EnumEntriesKt.enumEntries(r103);
    }

    public static BitableStatisticConstant$OpenFile$OpenType[] values() {
        return (BitableStatisticConstant$OpenFile$OpenType[]) f215592a.clone();
    }

    public final String getValue() {
        return this.value;
    }

    public static BitableStatisticConstant$OpenFile$OpenType valueOf(String r100) {
        return (BitableStatisticConstant$OpenFile$OpenType) r27.a.a(BitableStatisticConstant$OpenFile$OpenType.class, r100);
    }

    public BitableStatisticConstant$OpenFile$OpenType(String r100, int r101, String r102) {
        super(r100, r101);
        this.value = r102;
    }
}
