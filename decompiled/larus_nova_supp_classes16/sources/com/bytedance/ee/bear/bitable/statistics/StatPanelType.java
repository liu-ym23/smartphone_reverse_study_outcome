package com.bytedance.ee.bear.bitable.statistics;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\t\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\f"}, d2 = {"Lcom/bytedance/ee/bear/bitable/statistics/StatPanelType;", "", "type", "", "<init>", "(Ljava/lang/String;II)V", "getType", "()I", "UNKONW", "GROUPING_STATISTICS_VIEW", "GROUPING_STATISTICS_TYPE", "TOTAL_STATISTICS_VIEW", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum StatPanelType extends Enum<StatPanelType> {
    public static final StatPanelType GROUPING_STATISTICS_TYPE = null;
    public static final StatPanelType GROUPING_STATISTICS_VIEW = null;
    public static final StatPanelType TOTAL_STATISTICS_VIEW = null;
    public static final StatPanelType UNKONW = null;
    public static final /* synthetic */ StatPanelType[] a = null;
    public static final /* synthetic */ EnumEntries b = null;
    private final int type;

    public static EnumEntries<StatPanelType> getEntries() {
        return b;
    }

    static {
        StatPanelType r0 = new StatPanelType("UNKONW", 0, -1);
        UNKONW = r0;
        StatPanelType r1 = new StatPanelType("GROUPING_STATISTICS_VIEW", 1, 1);
        GROUPING_STATISTICS_VIEW = r1;
        StatPanelType r2 = new StatPanelType("GROUPING_STATISTICS_TYPE", 2, 2);
        GROUPING_STATISTICS_TYPE = r2;
        StatPanelType r5 = new StatPanelType("TOTAL_STATISTICS_VIEW", 3, 3);
        TOTAL_STATISTICS_VIEW = r5;
        StatPanelType[] r7 = {r0, r1, r2, r5};
        a = r7;
        b = EnumEntriesKt.enumEntries(r7);
    }

    public static StatPanelType[] values() {
        return (StatPanelType[]) a.clone();
    }

    public final int getType() {
        return this.type;
    }

    public static StatPanelType valueOf(String r1) {
        return (StatPanelType) a.a(StatPanelType.class, r1);
    }

    public StatPanelType(String r1, int r2, int r3) {
        super(r1, r2);
        this.type = r3;
    }
}
