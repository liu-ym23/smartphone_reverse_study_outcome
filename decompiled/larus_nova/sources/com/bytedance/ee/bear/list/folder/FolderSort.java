package com.bytedance.ee.bear.list.folder;

import com.bytedance.ee.bear.list.sort.SortAscType;
import com.larus.nova.R;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;
import zd5.q;

/* JADX INFO: loaded from: classes18.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0000\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B1\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u000b\u0010\fJ\u0006\u0010\u001f\u001a\u00020 R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000eR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0007\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001a\u0010\t\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019j\u0002\b\u001aj\u0002\b\u001bj\u0002\b\u001cj\u0002\b\u001dj\u0002\b\u001e¨\u0006!"}, d2 = {"Lcom/bytedance/ee/bear/list/folder/FolderSort;", "", "resId", "", "rank", "asc", "", "reportSort", "", "sortAscType", "Lcom/bytedance/ee/bear/list/sort/SortAscType;", "<init>", "(Ljava/lang/String;IIIZLjava/lang/String;Lcom/bytedance/ee/bear/list/sort/SortAscType;)V", "getResId", "()I", "getRank", "getAsc", "()Z", "getReportSort", "()Ljava/lang/String;", "setReportSort", "(Ljava/lang/String;)V", "getSortAscType", "()Lcom/bytedance/ee/bear/list/sort/SortAscType;", "setSortAscType", "(Lcom/bytedance/ee/bear/list/sort/SortAscType;)V", "NAME", "OWNER", "CREATED_TIME", "MODIFIED_TIME", "SHARED_TIME", "convertSortType", "Lcom/bytedance/ee/bear/list/sort/SortType;", "contentmanager-list_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum FolderSort extends Enum<FolderSort> {
    public static final FolderSort CREATED_TIME = null;
    public static final FolderSort MODIFIED_TIME = null;
    public static final FolderSort NAME = null;
    public static final FolderSort OWNER = null;
    public static final FolderSort SHARED_TIME = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ FolderSort[] f228015a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f228016b = null;

    /* JADX INFO: renamed from: asc, reason: collision with root package name */
    private final boolean f228017asc;
    private final int rank;
    private String reportSort;
    private final int resId;
    private SortAscType sortAscType;

    public static EnumEntries<FolderSort> getEntries() {
        return f228016b;
    }

    static {
        SortAscType r110 = SortAscType.TITLE;
        FolderSort r100 = new FolderSort("NAME", 0, R.string.Doc_List_SortByTitle, 5, "name", r110);
        NAME = r100;
        FolderSort r101 = new FolderSort("OWNER", 1, R.string.Doc_List_SortByOwner, 4, "owner", r110);
        OWNER = r101;
        SortAscType r102 = SortAscType.TIME;
        FolderSort r103 = new FolderSort("CREATED_TIME", 2, R.string.Doc_List_SortByCreationTime, 3, "time_created", r102);
        CREATED_TIME = r103;
        FolderSort r104 = new FolderSort("MODIFIED_TIME", 3, R.string.LarkCCM_Docs_SortByModified_Menu_Mob, 0, "time_modified", r102);
        MODIFIED_TIME = r104;
        FolderSort r105 = new FolderSort("SHARED_TIME", 4, R.string.LarkCCM_NewCM_SharedTime_Menu, 9, "time_shared", r102);
        SHARED_TIME = r105;
        FolderSort[] r106 = {r100, r101, r103, r104, r105};
        f228015a = r106;
        f228016b = EnumEntriesKt.enumEntries(r106);
    }

    public static FolderSort[] values() {
        return (FolderSort[]) f228015a.clone();
    }

    public final q convertSortType() {
        return new q(this.resId, this.rank, this.f228017asc, this.reportSort, null, this.sortAscType, 16);
    }

    public final boolean getAsc() {
        return this.f228017asc;
    }

    public final int getRank() {
        return this.rank;
    }

    public final String getReportSort() {
        return this.reportSort;
    }

    public final int getResId() {
        return this.resId;
    }

    public final SortAscType getSortAscType() {
        return this.sortAscType;
    }

    public static FolderSort valueOf(String r100) {
        return (FolderSort) r27.a.a(FolderSort.class, r100);
    }

    public final void setReportSort(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.reportSort = r100;
    }

    public final void setSortAscType(SortAscType r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.sortAscType = r100;
    }

    public FolderSort(String r100, int r101, int r102, int r103, String r104, SortAscType r105) {
        super(r100, r101);
        this.resId = r102;
        this.rank = r103;
        this.f228017asc = false;
        this.reportSort = r104;
        this.sortAscType = r105;
    }
}
