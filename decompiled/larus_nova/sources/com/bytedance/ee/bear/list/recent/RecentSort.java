package com.bytedance.ee.bear.list.recent;

import com.larus.nova.R;
import com.ss.android.cert.manager.constants.EventConstant;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0012\b\u0086\u0081\u0002\u0018\u0000 \u00192\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0019B1\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\u0003¢\u0006\u0004\b\n\u0010\u000bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0007\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u0011\u0010\t\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\rj\u0002\b\u0016j\u0002\b\u0017j\u0002\b\u0018¨\u0006\u001a"}, d2 = {"Lcom/bytedance/ee/bear/list/recent/RecentSort;", "", "resId", "", "rank", "asc", "", "reportSort", "", "sortPos", "<init>", "(Ljava/lang/String;IIIZLjava/lang/String;I)V", "getResId", "()I", "getRank", "getAsc", "()Z", "getReportSort", "()Ljava/lang/String;", "setReportSort", "(Ljava/lang/String;)V", "getSortPos", EventConstant.Event.EVENT_NFC_OPENED, "MODIFIED", "CREATED", "Companion", "contentmanager-list_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum RecentSort extends Enum<RecentSort> {
    public static final RecentSort CREATED = null;
    public static final a Companion = null;
    public static final RecentSort MODIFIED = null;
    public static final RecentSort OPENED = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ RecentSort[] f229247a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f229248b = null;

    /* JADX INFO: renamed from: asc, reason: collision with root package name */
    private final boolean f229249asc;
    private final int rank;
    private String reportSort;
    private final int resId;
    private final int sortPos;

    public static final class a {
        public a() {
        }
    }

    public static EnumEntries<RecentSort> getEntries() {
        return f229248b;
    }

    static {
        RecentSort r100 = new RecentSort(EventConstant.Event.EVENT_NFC_OPENED, 0, R.string.LarkCCM_NewCM_ViewedTime_Option, 6, "last_opened", 2);
        OPENED = r100;
        RecentSort r101 = new RecentSort("MODIFIED", 1, R.string.LarkCCM_Docs_SortByModified_Menu_Mob, 7, "last_modified", 0);
        MODIFIED = r101;
        RecentSort r102 = new RecentSort("CREATED", 2, R.string.Doc_List_SortByCreationTime, 3, "last_created", 1);
        CREATED = r102;
        RecentSort[] r103 = {r100, r101, r102};
        f229247a = r103;
        f229248b = EnumEntriesKt.enumEntries(r103);
        Companion = new a();
    }

    public static RecentSort[] values() {
        return (RecentSort[]) f229247a.clone();
    }

    public final boolean getAsc() {
        return this.f229249asc;
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

    public final int getSortPos() {
        return this.sortPos;
    }

    @JvmStatic
    public static final RecentSort getSort(int r100) {
        Companion.getClass();
        RecentSort r101 = MODIFIED;
        if (r100 == r101.getRank()) goto L10;
        RecentSort r102 = CREATED;
        if (r100 != r102.getRank()) goto L9;
        return r102;
    L9:
        return OPENED;
    L10:
        return r101;
    }

    public static RecentSort valueOf(String r100) {
        return (RecentSort) r27.a.a(RecentSort.class, r100);
    }

    public final void setReportSort(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.reportSort = r100;
    }

    public RecentSort(String r100, int r101, int r102, int r103, String r104, int r105) {
        super(r100, r101);
        this.resId = r102;
        this.rank = r103;
        this.f229249asc = false;
        this.reportSort = r104;
        this.sortPos = r105;
    }
}
