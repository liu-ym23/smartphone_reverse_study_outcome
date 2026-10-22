package com.bytedance.ee.bear.bitable.chameleon;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/bytedance/ee/bear/bitable/chameleon/BitableSubType;", "", "<init>", "(Ljava/lang/String;I)V", "BaseAdd", "BaseRecord", "BaseApp", "BaseMain", "Unknown", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum BitableSubType extends Enum<BitableSubType> {
    public static final BitableSubType BaseAdd = null;
    public static final BitableSubType BaseApp = null;
    public static final BitableSubType BaseMain = null;
    public static final BitableSubType BaseRecord = null;
    public static final BitableSubType Unknown = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ BitableSubType[] f209630a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f209631b = null;

    public static EnumEntries<BitableSubType> getEntries() {
        return f209631b;
    }

    static {
        BitableSubType r100 = new BitableSubType("BaseAdd", 0);
        BaseAdd = r100;
        BitableSubType r101 = new BitableSubType("BaseRecord", 1);
        BaseRecord = r101;
        BitableSubType r102 = new BitableSubType("BaseApp", 2);
        BaseApp = r102;
        BitableSubType r103 = new BitableSubType("BaseMain", 3);
        BaseMain = r103;
        BitableSubType r104 = new BitableSubType("Unknown", 4);
        Unknown = r104;
        BitableSubType[] r105 = {r100, r101, r102, r103, r104};
        f209630a = r105;
        f209631b = EnumEntriesKt.enumEntries(r105);
    }

    public static BitableSubType[] values() {
        return (BitableSubType[]) f209630a.clone();
    }

    public static BitableSubType valueOf(String r100) {
        return (BitableSubType) r27.a.a(BitableSubType.class, r100);
    }

    public BitableSubType(String r100, int r101) {
        super(r100, r101);
    }
}
