package com.bytedance.ee.bear.list.sort;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes18.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/ee/bear/list/sort/SortAscType;", "", "<init>", "(Ljava/lang/String;I)V", "TIME", "TITLE", "contentmanager-list_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum SortAscType extends Enum<SortAscType> {
    public static final SortAscType TIME = null;
    public static final SortAscType TITLE = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ SortAscType[] f229671a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f229672b = null;

    public static EnumEntries<SortAscType> getEntries() {
        return f229672b;
    }

    static {
        SortAscType r100 = new SortAscType("TIME", 0);
        TIME = r100;
        SortAscType r101 = new SortAscType("TITLE", 1);
        TITLE = r101;
        SortAscType[] r102 = {r100, r101};
        f229671a = r102;
        f229672b = EnumEntriesKt.enumEntries(r102);
    }

    public static SortAscType[] values() {
        return (SortAscType[]) f229671a.clone();
    }

    public static SortAscType valueOf(String r100) {
        return (SortAscType) r27.a.a(SortAscType.class, r100);
    }

    public SortAscType(String r100, int r101) {
        super(r100, r101);
    }
}
