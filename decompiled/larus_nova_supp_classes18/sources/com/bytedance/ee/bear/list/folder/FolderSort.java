package com.bytedance.ee.bear.list.folder;

import com.bytedance.ee.bear.list.sort.SortAscType;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;
import zd5.q;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0000\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B1\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u000b\u0010\fJ\u0006\u0010\u001f\u001a\u00020 R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000eR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0007\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001a\u0010\t\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019j\u0002\b\u001aj\u0002\b\u001bj\u0002\b\u001cj\u0002\b\u001dj\u0002\b\u001e¨\u0006!"}, d2 = {"Lcom/bytedance/ee/bear/list/folder/FolderSort;", "", "resId", "", "rank", "asc", "", "reportSort", "", "sortAscType", "Lcom/bytedance/ee/bear/list/sort/SortAscType;", "<init>", "(Ljava/lang/String;IIIZLjava/lang/String;Lcom/bytedance/ee/bear/list/sort/SortAscType;)V", "getResId", "()I", "getRank", "getAsc", "()Z", "getReportSort", "()Ljava/lang/String;", "setReportSort", "(Ljava/lang/String;)V", "getSortAscType", "()Lcom/bytedance/ee/bear/list/sort/SortAscType;", "setSortAscType", "(Lcom/bytedance/ee/bear/list/sort/SortAscType;)V", "NAME", "OWNER", "CREATED_TIME", "MODIFIED_TIME", "SHARED_TIME", "convertSortType", "Lcom/bytedance/ee/bear/list/sort/SortType;", "contentmanager-list_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum FolderSort extends Enum<FolderSort> {
    public static final FolderSort CREATED_TIME = null;
    public static final FolderSort MODIFIED_TIME = null;
    public static final FolderSort NAME = null;
    public static final FolderSort OWNER = null;
    public static final FolderSort SHARED_TIME = null;
    public static final /* synthetic */ FolderSort[] a = null;
    public static final /* synthetic */ EnumEntries b = null;
    private final boolean asc;
    private final int rank;
    private String reportSort;
    private final int resId;
    private SortAscType sortAscType;

    public static EnumEntries<FolderSort> getEntries() {
        return b;
    }

    static {
        SortAscType r14 = SortAscType.TITLE;
        FolderSort r7 = new FolderSort("NAME", 0, 2131887985, 5, "name", r14);
        NAME = r7;
        FolderSort r0 = new FolderSort("OWNER", 1, 2131887984, 4, "owner", r14);
        OWNER = r0;
        SortAscType r2 = SortAscType.TIME;
        FolderSort r1 = new FolderSort("CREATED_TIME", 2, 2131887983, 3, "time_created", r2);
        CREATED_TIME = r1;
        FolderSort r3 = new FolderSort("MODIFIED_TIME", 3, 2131889266, 0, "time_modified", r2);
        MODIFIED_TIME = r3;
        FolderSort r4 = new FolderSort("SHARED_TIME", 4, 2131889637, 9, "time_shared", r2);
        SHARED_TIME = r4;
        FolderSort[] r5 = {r7, r0, r1, r3, r4};
        a = r5;
        b = EnumEntriesKt.enumEntries(r5);
    }

    public static FolderSort[] values() {
        return (FolderSort[]) a.clone();
    }

    public final q convertSortType() {
        return new q(this.resId, this.rank, this.asc, this.reportSort, null, this.sortAscType, 16);
    }

    public final boolean getAsc() {
        return this.asc;
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

    public static FolderSort valueOf(String r1) {
        return (FolderSort) r27.a.a(FolderSort.class, r1);
    }

    public final void setReportSort(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.reportSort = r2;
    }

    public final void setSortAscType(SortAscType r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.sortAscType = r2;
    }

    public FolderSort(String r1, int r2, int r3, int r4, String r5, SortAscType r6) {
        super(r1, r2);
        this.resId = r3;
        this.rank = r4;
        this.asc = false;
        this.reportSort = r5;
        this.sortAscType = r6;
    }
}
