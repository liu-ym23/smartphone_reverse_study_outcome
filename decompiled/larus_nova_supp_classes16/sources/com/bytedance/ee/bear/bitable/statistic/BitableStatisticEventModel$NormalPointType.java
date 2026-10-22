package com.bytedance.ee.bear.bitable.statistic;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\r"}, d2 = {"Lcom/bytedance/ee/bear/bitable/statistic/BitableStatisticEventModel$NormalPointType;", "", "type", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getType", "()Ljava/lang/String;", "POINT", "INIT_POINT", "END_POINT", "TEMP_POINT", "TEMP_POINT_TRIGGER", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum BitableStatisticEventModel$NormalPointType extends Enum<BitableStatisticEventModel$NormalPointType> {
    public static final BitableStatisticEventModel$NormalPointType END_POINT = null;
    public static final BitableStatisticEventModel$NormalPointType INIT_POINT = null;
    public static final BitableStatisticEventModel$NormalPointType POINT = null;
    public static final BitableStatisticEventModel$NormalPointType TEMP_POINT = null;
    public static final BitableStatisticEventModel$NormalPointType TEMP_POINT_TRIGGER = null;
    public static final /* synthetic */ BitableStatisticEventModel$NormalPointType[] a = null;
    public static final /* synthetic */ EnumEntries b = null;
    private final String type;

    public static EnumEntries<BitableStatisticEventModel$NormalPointType> getEntries() {
        return b;
    }

    static {
        BitableStatisticEventModel$NormalPointType r0 = new BitableStatisticEventModel$NormalPointType("POINT", 0, "point");
        POINT = r0;
        BitableStatisticEventModel$NormalPointType r1 = new BitableStatisticEventModel$NormalPointType("INIT_POINT", 1, "init_point");
        INIT_POINT = r1;
        BitableStatisticEventModel$NormalPointType r2 = new BitableStatisticEventModel$NormalPointType("END_POINT", 2, "end_point");
        END_POINT = r2;
        BitableStatisticEventModel$NormalPointType r4 = new BitableStatisticEventModel$NormalPointType("TEMP_POINT", 3, "temp_point");
        TEMP_POINT = r4;
        BitableStatisticEventModel$NormalPointType r6 = new BitableStatisticEventModel$NormalPointType("TEMP_POINT_TRIGGER", 4, "temp_point_group");
        TEMP_POINT_TRIGGER = r6;
        BitableStatisticEventModel$NormalPointType[] r8 = {r0, r1, r2, r4, r6};
        a = r8;
        b = EnumEntriesKt.enumEntries(r8);
    }

    public static BitableStatisticEventModel$NormalPointType[] values() {
        return (BitableStatisticEventModel$NormalPointType[]) a.clone();
    }

    public final String getType() {
        return this.type;
    }

    public static BitableStatisticEventModel$NormalPointType valueOf(String r1) {
        return (BitableStatisticEventModel$NormalPointType) r27.a.a(BitableStatisticEventModel$NormalPointType.class, r1);
    }

    public BitableStatisticEventModel$NormalPointType(String r1, int r2, String r3) {
        super(r1, r2);
        this.type = r3;
    }
}
