package com.ss.android.lark.coremd.span.list;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes35.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/ss/android/lark/coremd/span/list/ListHeadType;", "", "<init>", "(Ljava/lang/String;I)V", "ListHead", "VirtualHead", "None", "core-md_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum ListHeadType extends Enum<ListHeadType> {
    public static final ListHeadType ListHead = null;
    public static final ListHeadType None = null;
    public static final ListHeadType VirtualHead = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ListHeadType[] f419948a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f419949b = null;

    public static EnumEntries<ListHeadType> getEntries() {
        return f419949b;
    }

    static {
        ListHeadType r100 = new ListHeadType("ListHead", 0);
        ListHead = r100;
        ListHeadType r101 = new ListHeadType("VirtualHead", 1);
        VirtualHead = r101;
        ListHeadType r102 = new ListHeadType("None", 2);
        None = r102;
        ListHeadType[] r103 = {r100, r101, r102};
        f419948a = r103;
        f419949b = EnumEntriesKt.enumEntries(r103);
    }

    public static ListHeadType[] values() {
        return (ListHeadType[]) f419948a.clone();
    }

    public static ListHeadType valueOf(String r100) {
        return (ListHeadType) a.a(ListHeadType.class, r100);
    }

    public ListHeadType(String r100, int r101) {
        super(r100, r101);
    }
}
