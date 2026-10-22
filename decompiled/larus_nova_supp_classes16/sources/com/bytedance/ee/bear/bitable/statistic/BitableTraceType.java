package com.bytedance.ee.bear.bitable.statistic;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/bytedance/ee/bear/bitable/statistic/BitableTraceType;", "", "<init>", "(Ljava/lang/String;I)V", "Normal", "Fps", "Process", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum BitableTraceType extends Enum<BitableTraceType> {
    public static final BitableTraceType Fps = null;
    public static final BitableTraceType Normal = null;
    public static final BitableTraceType Process = null;
    public static final /* synthetic */ BitableTraceType[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<BitableTraceType> getEntries() {
        return b;
    }

    static {
        BitableTraceType r0 = new BitableTraceType("Normal", 0);
        Normal = r0;
        BitableTraceType r1 = new BitableTraceType("Fps", 1);
        Fps = r1;
        BitableTraceType r3 = new BitableTraceType("Process", 2);
        Process = r3;
        BitableTraceType[] r5 = {r0, r1, r3};
        a = r5;
        b = EnumEntriesKt.enumEntries(r5);
    }

    public static BitableTraceType[] values() {
        return (BitableTraceType[]) a.clone();
    }

    public static BitableTraceType valueOf(String r1) {
        return (BitableTraceType) r27.a.a(BitableTraceType.class, r1);
    }

    public BitableTraceType(String r1, int r2) {
        super(r1, r2);
    }
}
