package com.larksuite.common_selection;

import com.obric.miniapp.alarm.AccountType;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes24.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/larksuite/common_selection/SelectionGranularity;", "", "<init>", "(Ljava/lang/String;I)V", "CHARACTER", "WORD", "PARAGRAPH", "ALL_TEXT", AccountType.ALL, "common-selection_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum SelectionGranularity extends Enum<SelectionGranularity> {
    public static final SelectionGranularity ALL = null;
    public static final SelectionGranularity ALL_TEXT = null;
    public static final SelectionGranularity CHARACTER = null;
    public static final SelectionGranularity PARAGRAPH = null;
    public static final SelectionGranularity WORD = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ SelectionGranularity[] f282856a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f282857b = null;

    public static EnumEntries<SelectionGranularity> getEntries() {
        return f282857b;
    }

    static {
        SelectionGranularity r100 = new SelectionGranularity("CHARACTER", 0);
        CHARACTER = r100;
        SelectionGranularity r101 = new SelectionGranularity("WORD", 1);
        WORD = r101;
        SelectionGranularity r102 = new SelectionGranularity("PARAGRAPH", 2);
        PARAGRAPH = r102;
        SelectionGranularity r103 = new SelectionGranularity("ALL_TEXT", 3);
        ALL_TEXT = r103;
        SelectionGranularity r104 = new SelectionGranularity(AccountType.ALL, 4);
        ALL = r104;
        SelectionGranularity[] r105 = {r100, r101, r102, r103, r104};
        f282856a = r105;
        f282857b = EnumEntriesKt.enumEntries(r105);
    }

    public static SelectionGranularity[] values() {
        return (SelectionGranularity[]) f282856a.clone();
    }

    public static SelectionGranularity valueOf(String r100) {
        return (SelectionGranularity) r27.a.a(SelectionGranularity.class, r100);
    }

    public SelectionGranularity(String r100, int r101) {
        super(r100, r101);
    }
}
