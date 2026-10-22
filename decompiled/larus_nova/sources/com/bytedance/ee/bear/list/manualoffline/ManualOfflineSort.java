package com.bytedance.ee.bear.list.manualoffline;

import com.larus.nova.R;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0010\b\u0086\u0081\u0002\u0018\u0000 \u00172\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0017B)\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0007\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016¨\u0006\u0018"}, d2 = {"Lcom/bytedance/ee/bear/list/manualoffline/ManualOfflineSort;", "", "resId", "", "rank", "asc", "", "reportSort", "", "<init>", "(Ljava/lang/String;IIIZLjava/lang/String;)V", "getResId", "()I", "getRank", "getAsc", "()Z", "getReportSort", "()Ljava/lang/String;", "setReportSort", "(Ljava/lang/String;)V", "DEFAULT", "MODIFIED", "CREATED", "Companion", "contentmanager-list_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum ManualOfflineSort extends Enum<ManualOfflineSort> {
    public static final ManualOfflineSort CREATED = null;
    public static final a Companion = null;
    public static final ManualOfflineSort DEFAULT = null;
    public static final ManualOfflineSort MODIFIED = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ManualOfflineSort[] f228677a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f228678b = null;

    /* JADX INFO: renamed from: asc, reason: collision with root package name */
    private final boolean f228679asc;
    private final int rank;
    private String reportSort;
    private final int resId;

    public static final class a {
        public a() {
        }
    }

    public static EnumEntries<ManualOfflineSort> getEntries() {
        return f228678b;
    }

    static {
        ManualOfflineSort r100 = new ManualOfflineSort("DEFAULT", 0, R.string.Doc_Facade_Default, 9, "default");
        DEFAULT = r100;
        ManualOfflineSort r101 = new ManualOfflineSort("MODIFIED", 1, R.string.Doc_List_Filter_Recent_Modified, 7, "last_modified");
        MODIFIED = r101;
        ManualOfflineSort r102 = new ManualOfflineSort("CREATED", 2, R.string.Doc_List_Filter_Recent_Created, 3, "last_created");
        CREATED = r102;
        ManualOfflineSort[] r103 = {r100, r101, r102};
        f228677a = r103;
        f228678b = EnumEntriesKt.enumEntries(r103);
        Companion = new a();
    }

    public static ManualOfflineSort[] values() {
        return (ManualOfflineSort[]) f228677a.clone();
    }

    public final boolean getAsc() {
        return this.f228679asc;
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
    public static final ManualOfflineSort getSort(int r100) {
        Companion.getClass();
        ManualOfflineSort r101 = MODIFIED;
        if (r100 == r101.getRank()) goto L10;
        ManualOfflineSort r102 = CREATED;
        if (r100 != r102.getRank()) goto L9;
        return r102;
    L9:
        return DEFAULT;
    L10:
        return r101;
    }

    public static ManualOfflineSort valueOf(String r100) {
        return (ManualOfflineSort) r27.a.a(ManualOfflineSort.class, r100);
    }

    public final void setReportSort(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.reportSort = r100;
    }

    public ManualOfflineSort(String r100, int r101, int r102, int r103, String r104) {
        super(r100, r101);
        this.resId = r102;
        this.rank = r103;
        this.f228679asc = false;
        this.reportSort = r104;
    }
}
