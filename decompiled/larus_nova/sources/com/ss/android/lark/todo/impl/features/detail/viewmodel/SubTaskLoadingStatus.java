package com.ss.android.lark.todo.impl.features.detail.viewmodel;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes38.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/ss/android/lark/todo/impl/features/detail/viewmodel/SubTaskLoadingStatus;", "", "<init>", "(Ljava/lang/String;I)V", "LOADING_FIRST", "LOADING_PAGE", "LOADING_FAILED", "LOADING_SUCCESS_NEXT", "LOADING_SUCCESS_ALL", "todo_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum SubTaskLoadingStatus extends Enum<SubTaskLoadingStatus> {
    public static final SubTaskLoadingStatus LOADING_FAILED = null;
    public static final SubTaskLoadingStatus LOADING_FIRST = null;
    public static final SubTaskLoadingStatus LOADING_PAGE = null;
    public static final SubTaskLoadingStatus LOADING_SUCCESS_ALL = null;
    public static final SubTaskLoadingStatus LOADING_SUCCESS_NEXT = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ SubTaskLoadingStatus[] f443634a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f443635b = null;

    public static EnumEntries<SubTaskLoadingStatus> getEntries() {
        return f443635b;
    }

    static {
        SubTaskLoadingStatus r100 = new SubTaskLoadingStatus("LOADING_FIRST", 0);
        LOADING_FIRST = r100;
        SubTaskLoadingStatus r101 = new SubTaskLoadingStatus("LOADING_PAGE", 1);
        LOADING_PAGE = r101;
        SubTaskLoadingStatus r102 = new SubTaskLoadingStatus("LOADING_FAILED", 2);
        LOADING_FAILED = r102;
        SubTaskLoadingStatus r103 = new SubTaskLoadingStatus("LOADING_SUCCESS_NEXT", 3);
        LOADING_SUCCESS_NEXT = r103;
        SubTaskLoadingStatus r104 = new SubTaskLoadingStatus("LOADING_SUCCESS_ALL", 4);
        LOADING_SUCCESS_ALL = r104;
        SubTaskLoadingStatus[] r105 = {r100, r101, r102, r103, r104};
        f443634a = r105;
        f443635b = EnumEntriesKt.enumEntries(r105);
    }

    public static SubTaskLoadingStatus[] values() {
        return (SubTaskLoadingStatus[]) f443634a.clone();
    }

    public static SubTaskLoadingStatus valueOf(String r100) {
        return (SubTaskLoadingStatus) r27.a.a(SubTaskLoadingStatus.class, r100);
    }

    public SubTaskLoadingStatus(String r100, int r101) {
        super(r100, r101);
    }
}
