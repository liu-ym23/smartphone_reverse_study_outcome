package com.bytedance.ee.bear.list.manualoffline;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0010\b\u0086\u0081\u0002\u0018\u0000 \u00172\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0017B)\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0007\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016¨\u0006\u0018"}, d2 = {"Lcom/bytedance/ee/bear/list/manualoffline/ManualOfflineSort;", "", "resId", "", "rank", "asc", "", "reportSort", "", "<init>", "(Ljava/lang/String;IIIZLjava/lang/String;)V", "getResId", "()I", "getRank", "getAsc", "()Z", "getReportSort", "()Ljava/lang/String;", "setReportSort", "(Ljava/lang/String;)V", "DEFAULT", "MODIFIED", "CREATED", "Companion", "contentmanager-list_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum ManualOfflineSort extends Enum<ManualOfflineSort> {
    public static final ManualOfflineSort CREATED = null;
    public static final a Companion = null;
    public static final ManualOfflineSort DEFAULT = null;
    public static final ManualOfflineSort MODIFIED = null;
    public static final /* synthetic */ ManualOfflineSort[] a = null;
    public static final /* synthetic */ EnumEntries b = null;
    private final boolean asc;
    private final int rank;
    private String reportSort;
    private final int resId;

    public static final class a {
        public a() {
        }
    }

    public static EnumEntries<ManualOfflineSort> getEntries() {
        return b;
    }

    static {
        ManualOfflineSort r6 = new ManualOfflineSort("DEFAULT", 0, 2131887734, 9, "default");
        DEFAULT = r6;
        ManualOfflineSort r0 = new ManualOfflineSort("MODIFIED", 1, 2131887917, 7, "last_modified");
        MODIFIED = r0;
        ManualOfflineSort r1 = new ManualOfflineSort("CREATED", 2, 2131887916, 3, "last_created");
        CREATED = r1;
        ManualOfflineSort[] r2 = {r6, r0, r1};
        a = r2;
        b = EnumEntriesKt.enumEntries(r2);
        Companion = new a();
    }

    public static ManualOfflineSort[] values() {
        return (ManualOfflineSort[]) a.clone();
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

    @JvmStatic
    public static final ManualOfflineSort getSort(int r2) {
        Companion.getClass();
        ManualOfflineSort r0 = MODIFIED;
        if (r2 == r0.getRank()) goto L10;
        ManualOfflineSort r1 = CREATED;
        if (r2 != r1.getRank()) goto L9;
        return r1;
    L9:
        return DEFAULT;
    L10:
        return r0;
    }

    public static ManualOfflineSort valueOf(String r1) {
        return (ManualOfflineSort) r27.a.a(ManualOfflineSort.class, r1);
    }

    public final void setReportSort(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.reportSort = r2;
    }

    public ManualOfflineSort(String r1, int r2, int r3, int r4, String r5) {
        super(r1, r2);
        this.resId = r3;
        this.rank = r4;
        this.asc = false;
        this.reportSort = r5;
    }
}
