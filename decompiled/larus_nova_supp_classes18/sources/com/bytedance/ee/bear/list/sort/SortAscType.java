package com.bytedance.ee.bear.list.sort;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/ee/bear/list/sort/SortAscType;", "", "<init>", "(Ljava/lang/String;I)V", "TIME", "TITLE", "contentmanager-list_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum SortAscType extends Enum<SortAscType> {
    public static final SortAscType TIME = null;
    public static final SortAscType TITLE = null;
    public static final /* synthetic */ SortAscType[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<SortAscType> getEntries() {
        return b;
    }

    static {
        SortAscType r0 = new SortAscType("TIME", 0);
        TIME = r0;
        SortAscType r1 = new SortAscType("TITLE", 1);
        TITLE = r1;
        SortAscType[] r3 = {r0, r1};
        a = r3;
        b = EnumEntriesKt.enumEntries(r3);
    }

    public static SortAscType[] values() {
        return (SortAscType[]) a.clone();
    }

    public static SortAscType valueOf(String r1) {
        return (SortAscType) r27.a.a(SortAscType.class, r1);
    }

    public SortAscType(String r1, int r2) {
        super(r1, r2);
    }
}
