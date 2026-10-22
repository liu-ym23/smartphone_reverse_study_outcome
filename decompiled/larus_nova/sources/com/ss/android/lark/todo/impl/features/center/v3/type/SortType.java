package com.ss.android.lark.todo.impl.features.center.v3.type;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes38.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/ss/android/lark/todo/impl/features/center/v3/type/SortType;", "", "<init>", "(Ljava/lang/String;I)V", "DUE_TIME_SORT", "CREATE_TIME_SORT", "COMPLETE_TIME_SORT", "SUMMARY_SORT", "DEFINED_SORT", "todo_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum SortType extends Enum<SortType> {
    public static final SortType COMPLETE_TIME_SORT = null;
    public static final SortType CREATE_TIME_SORT = null;
    public static final SortType DEFINED_SORT = null;
    public static final SortType DUE_TIME_SORT = null;
    public static final SortType SUMMARY_SORT = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ SortType[] f441768a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f441769b = null;

    public static EnumEntries<SortType> getEntries() {
        return f441769b;
    }

    static {
        SortType r100 = new SortType("DUE_TIME_SORT", 0);
        DUE_TIME_SORT = r100;
        SortType r101 = new SortType("CREATE_TIME_SORT", 1);
        CREATE_TIME_SORT = r101;
        SortType r102 = new SortType("COMPLETE_TIME_SORT", 2);
        COMPLETE_TIME_SORT = r102;
        SortType r103 = new SortType("SUMMARY_SORT", 3);
        SUMMARY_SORT = r103;
        SortType r104 = new SortType("DEFINED_SORT", 4);
        DEFINED_SORT = r104;
        SortType[] r105 = {r100, r101, r102, r103, r104};
        f441768a = r105;
        f441769b = EnumEntriesKt.enumEntries(r105);
    }

    public static SortType[] values() {
        return (SortType[]) f441768a.clone();
    }

    public static SortType valueOf(String r100) {
        return (SortType) a.a(SortType.class, r100);
    }

    public SortType(String r100, int r101) {
        super(r100, r101);
    }
}
