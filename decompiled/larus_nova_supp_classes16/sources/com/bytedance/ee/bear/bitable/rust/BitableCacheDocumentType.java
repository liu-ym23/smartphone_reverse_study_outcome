package com.bytedance.ee.bear.bitable.rust;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0080\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/bytedance/ee/bear/bitable/rust/BitableCacheDocumentType;", "", "<init>", "(Ljava/lang/String;I)V", "Main", "Record", "AddRecord", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum BitableCacheDocumentType extends Enum<BitableCacheDocumentType> {
    public static final BitableCacheDocumentType AddRecord = null;
    public static final BitableCacheDocumentType Main = null;
    public static final BitableCacheDocumentType Record = null;
    public static final /* synthetic */ BitableCacheDocumentType[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<BitableCacheDocumentType> getEntries() {
        return b;
    }

    static {
        BitableCacheDocumentType r0 = new BitableCacheDocumentType("Main", 0);
        Main = r0;
        BitableCacheDocumentType r1 = new BitableCacheDocumentType("Record", 1);
        Record = r1;
        BitableCacheDocumentType r3 = new BitableCacheDocumentType("AddRecord", 2);
        AddRecord = r3;
        BitableCacheDocumentType[] r5 = {r0, r1, r3};
        a = r5;
        b = EnumEntriesKt.enumEntries(r5);
    }

    public static BitableCacheDocumentType[] values() {
        return (BitableCacheDocumentType[]) a.clone();
    }

    public static BitableCacheDocumentType valueOf(String r1) {
        return (BitableCacheDocumentType) r27.a.a(BitableCacheDocumentType.class, r1);
    }

    public BitableCacheDocumentType(String r1, int r2) {
        super(r1, r2);
    }
}
