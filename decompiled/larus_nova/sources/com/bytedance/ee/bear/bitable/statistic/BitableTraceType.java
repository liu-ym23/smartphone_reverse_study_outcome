package com.bytedance.ee.bear.bitable.statistic;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes16.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/bytedance/ee/bear/bitable/statistic/BitableTraceType;", "", "<init>", "(Ljava/lang/String;I)V", "Normal", "Fps", "Process", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum BitableTraceType extends Enum<BitableTraceType> {
    public static final BitableTraceType Fps = null;
    public static final BitableTraceType Normal = null;
    public static final BitableTraceType Process = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ BitableTraceType[] f215598a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f215599b = null;

    public static EnumEntries<BitableTraceType> getEntries() {
        return f215599b;
    }

    static {
        BitableTraceType r100 = new BitableTraceType("Normal", 0);
        Normal = r100;
        BitableTraceType r101 = new BitableTraceType("Fps", 1);
        Fps = r101;
        BitableTraceType r102 = new BitableTraceType("Process", 2);
        Process = r102;
        BitableTraceType[] r103 = {r100, r101, r102};
        f215598a = r103;
        f215599b = EnumEntriesKt.enumEntries(r103);
    }

    public static BitableTraceType[] values() {
        return (BitableTraceType[]) f215598a.clone();
    }

    public static BitableTraceType valueOf(String r100) {
        return (BitableTraceType) r27.a.a(BitableTraceType.class, r100);
    }

    public BitableTraceType(String r100, int r101) {
        super(r100, r101);
    }
}
