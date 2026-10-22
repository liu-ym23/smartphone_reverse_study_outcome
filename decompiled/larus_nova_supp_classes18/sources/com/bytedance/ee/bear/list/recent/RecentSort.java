package com.bytedance.ee.bear.list.recent;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0012\b\u0086\u0081\u0002\u0018\u0000 \u00192\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0019B1\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\u0003¢\u0006\u0004\b\n\u0010\u000bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0007\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u0011\u0010\t\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\rj\u0002\b\u0016j\u0002\b\u0017j\u0002\b\u0018¨\u0006\u001a"}, d2 = {"Lcom/bytedance/ee/bear/list/recent/RecentSort;", "", "resId", "", "rank", "asc", "", "reportSort", "", "sortPos", "<init>", "(Ljava/lang/String;IIIZLjava/lang/String;I)V", "getResId", "()I", "getRank", "getAsc", "()Z", "getReportSort", "()Ljava/lang/String;", "setReportSort", "(Ljava/lang/String;)V", "getSortPos", "OPENED", "MODIFIED", "CREATED", "Companion", "contentmanager-list_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum RecentSort extends Enum<RecentSort> {
    public static final RecentSort CREATED = null;
    public static final a Companion = null;
    public static final RecentSort MODIFIED = null;
    public static final RecentSort OPENED = null;
    public static final /* synthetic */ RecentSort[] a = null;
    public static final /* synthetic */ EnumEntries b = null;
    private final boolean asc;
    private final int rank;
    private String reportSort;
    private final int resId;
    private final int sortPos;

    public static final class a {
        public a() {
        }
    }

    public static EnumEntries<RecentSort> getEntries() {
        return b;
    }

    static {
        RecentSort r7 = new RecentSort("OPENED", 0, 2131889658, 6, "last_opened", 2);
        OPENED = r7;
        RecentSort r0 = new RecentSort("MODIFIED", 1, 2131889266, 7, "last_modified", 0);
        MODIFIED = r0;
        RecentSort r1 = new RecentSort("CREATED", 2, 2131887983, 3, "last_created", 1);
        CREATED = r1;
        RecentSort[] r2 = {r7, r0, r1};
        a = r2;
        b = EnumEntriesKt.enumEntries(r2);
        Companion = new a();
    }

    public static RecentSort[] values() {
        return (RecentSort[]) a.clone();
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

    public final int getSortPos() {
        return this.sortPos;
    }

    @JvmStatic
    public static final RecentSort getSort(int r2) {
        Companion.getClass();
        RecentSort r0 = MODIFIED;
        if (r2 == r0.getRank()) goto L10;
        RecentSort r1 = CREATED;
        if (r2 != r1.getRank()) goto L9;
        return r1;
    L9:
        return OPENED;
    L10:
        return r0;
    }

    public static RecentSort valueOf(String r1) {
        return (RecentSort) r27.a.a(RecentSort.class, r1);
    }

    public final void setReportSort(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.reportSort = r2;
    }

    public RecentSort(String r1, int r2, int r3, int r4, String r5, int r6) {
        super(r1, r2);
        this.resId = r3;
        this.rank = r4;
        this.asc = false;
        this.reportSort = r5;
        this.sortPos = r6;
    }
}
