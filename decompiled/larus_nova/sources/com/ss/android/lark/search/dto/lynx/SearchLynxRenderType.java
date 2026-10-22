package com.ss.android.lark.search.dto.lynx;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes38.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\f"}, d2 = {"Lcom/ss/android/lark/search/dto/lynx/SearchLynxRenderType;", "", "reportName", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getReportName", "()Ljava/lang/String;", "UNKNOWN", "GECKO", "KA", "DEFAULT", "search-dto_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum SearchLynxRenderType extends Enum<SearchLynxRenderType> {
    public static final SearchLynxRenderType DEFAULT = null;
    public static final SearchLynxRenderType GECKO = null;
    public static final SearchLynxRenderType KA = null;
    public static final SearchLynxRenderType UNKNOWN = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ SearchLynxRenderType[] f440168a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f440169b = null;
    private final String reportName;

    public static EnumEntries<SearchLynxRenderType> getEntries() {
        return f440169b;
    }

    static {
        SearchLynxRenderType r100 = new SearchLynxRenderType("UNKNOWN", 0, "unknown");
        UNKNOWN = r100;
        SearchLynxRenderType r101 = new SearchLynxRenderType("GECKO", 1, "gecko");
        GECKO = r101;
        SearchLynxRenderType r102 = new SearchLynxRenderType("KA", 2, "ka");
        KA = r102;
        SearchLynxRenderType r103 = new SearchLynxRenderType("DEFAULT", 3, "default");
        DEFAULT = r103;
        SearchLynxRenderType[] r104 = {r100, r101, r102, r103};
        f440168a = r104;
        f440169b = EnumEntriesKt.enumEntries(r104);
    }

    public static SearchLynxRenderType[] values() {
        return (SearchLynxRenderType[]) f440168a.clone();
    }

    public final String getReportName() {
        return this.reportName;
    }

    public static SearchLynxRenderType valueOf(String r100) {
        return (SearchLynxRenderType) a.a(SearchLynxRenderType.class, r100);
    }

    public SearchLynxRenderType(String r100, int r101, String r102) {
        super(r100, r101);
        this.reportName = r102;
    }
}
