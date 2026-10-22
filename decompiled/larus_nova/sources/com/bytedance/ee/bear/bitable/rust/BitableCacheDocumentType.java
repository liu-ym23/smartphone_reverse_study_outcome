package com.bytedance.ee.bear.bitable.rust;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes16.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0080\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/bytedance/ee/bear/bitable/rust/BitableCacheDocumentType;", "", "<init>", "(Ljava/lang/String;I)V", "Main", "Record", "AddRecord", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum BitableCacheDocumentType extends Enum<BitableCacheDocumentType> {
    public static final BitableCacheDocumentType AddRecord = null;
    public static final BitableCacheDocumentType Main = null;
    public static final BitableCacheDocumentType Record = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ BitableCacheDocumentType[] f215254a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f215255b = null;

    public static EnumEntries<BitableCacheDocumentType> getEntries() {
        return f215255b;
    }

    static {
        BitableCacheDocumentType r100 = new BitableCacheDocumentType("Main", 0);
        Main = r100;
        BitableCacheDocumentType r101 = new BitableCacheDocumentType("Record", 1);
        Record = r101;
        BitableCacheDocumentType r102 = new BitableCacheDocumentType("AddRecord", 2);
        AddRecord = r102;
        BitableCacheDocumentType[] r103 = {r100, r101, r102};
        f215254a = r103;
        f215255b = EnumEntriesKt.enumEntries(r103);
    }

    public static BitableCacheDocumentType[] values() {
        return (BitableCacheDocumentType[]) f215254a.clone();
    }

    public static BitableCacheDocumentType valueOf(String r100) {
        return (BitableCacheDocumentType) r27.a.a(BitableCacheDocumentType.class, r100);
    }

    public BitableCacheDocumentType(String r100, int r101) {
        super(r100, r101);
    }
}
