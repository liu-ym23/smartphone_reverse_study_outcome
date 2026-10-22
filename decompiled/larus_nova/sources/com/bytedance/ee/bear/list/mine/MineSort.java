package com.bytedance.ee.bear.list.mine;

import com.larus.nova.R;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000f\b\u0086\u0081\u0002\u0018\u0000 \u00162\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0016B)\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0007\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013j\u0002\b\u0014j\u0002\b\u0015¨\u0006\u0017"}, d2 = {"Lcom/bytedance/ee/bear/list/mine/MineSort;", "", "resId", "", "rank", "asc", "", "reportSort", "", "<init>", "(Ljava/lang/String;IIIZLjava/lang/String;)V", "getResId", "()I", "getRank", "getAsc", "()Z", "getReportSort", "()Ljava/lang/String;", "setReportSort", "(Ljava/lang/String;)V", "CREATE_TIME", "MODIFIED_TIME", "Companion", "contentmanager-list_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum MineSort extends Enum<MineSort> {
    public static final MineSort CREATE_TIME = null;
    public static final a Companion = null;
    public static final MineSort MODIFIED_TIME = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ MineSort[] f228680a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f228681b = null;

    /* JADX INFO: renamed from: asc, reason: collision with root package name */
    private final boolean f228682asc;
    private final int rank;
    private String reportSort;
    private final int resId;

    public static final class a {
        public a() {
        }
    }

    public static EnumEntries<MineSort> getEntries() {
        return f228681b;
    }

    static {
        MineSort r100 = new MineSort("CREATE_TIME", 0, R.string.Doc_List_SortByCreationTime, 3, "time_created");
        CREATE_TIME = r100;
        MineSort r101 = new MineSort("MODIFIED_TIME", 1, R.string.LarkCCM_Docs_SortByModified_Menu_Mob, 0, "time_modified");
        MODIFIED_TIME = r101;
        MineSort[] r102 = {r100, r101};
        f228680a = r102;
        f228681b = EnumEntriesKt.enumEntries(r102);
        Companion = new a();
    }

    public static MineSort[] values() {
        return (MineSort[]) f228680a.clone();
    }

    public final boolean getAsc() {
        return this.f228682asc;
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
    public static final MineSort getSort(int r100) {
        Companion.getClass();
        MineSort r101 = CREATE_TIME;
        if (r100 != r101.getRank()) goto L6;
        return r101;
    L6:
        return MODIFIED_TIME;
    }

    public static MineSort valueOf(String r100) {
        return (MineSort) r27.a.a(MineSort.class, r100);
    }

    public final void setReportSort(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.reportSort = r100;
    }

    public MineSort(String r100, int r101, int r102, int r103, String r104) {
        super(r100, r101);
        this.resId = r102;
        this.rank = r103;
        this.f228682asc = false;
        this.reportSort = r104;
    }
}
