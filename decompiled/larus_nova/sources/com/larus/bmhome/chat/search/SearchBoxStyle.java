package com.larus.bmhome.chat.search;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes25.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\t\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/larus/bmhome/chat/search/SearchBoxStyle;", "", "<init>", "(Ljava/lang/String;I)V", "singleRowNormal", "singleRowTiny", "doubleColumnVideo", "doubleColumnImage", "singleRowVideoNew", "doubleColumnMixedMedia", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum SearchBoxStyle extends Enum<SearchBoxStyle> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ SearchBoxStyle[] f308600a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f308601b = null;
    public static final SearchBoxStyle doubleColumnImage = null;
    public static final SearchBoxStyle doubleColumnMixedMedia = null;
    public static final SearchBoxStyle doubleColumnVideo = null;
    public static final SearchBoxStyle singleRowNormal = null;
    public static final SearchBoxStyle singleRowTiny = null;
    public static final SearchBoxStyle singleRowVideoNew = null;

    public static EnumEntries<SearchBoxStyle> getEntries() {
        return f308601b;
    }

    static {
        SearchBoxStyle r100 = new SearchBoxStyle("singleRowNormal", 0);
        singleRowNormal = r100;
        SearchBoxStyle r101 = new SearchBoxStyle("singleRowTiny", 1);
        singleRowTiny = r101;
        SearchBoxStyle r102 = new SearchBoxStyle("doubleColumnVideo", 2);
        doubleColumnVideo = r102;
        SearchBoxStyle r103 = new SearchBoxStyle("doubleColumnImage", 3);
        doubleColumnImage = r103;
        SearchBoxStyle r104 = new SearchBoxStyle("singleRowVideoNew", 4);
        singleRowVideoNew = r104;
        SearchBoxStyle r105 = new SearchBoxStyle("doubleColumnMixedMedia", 5);
        doubleColumnMixedMedia = r105;
        SearchBoxStyle[] r110 = {r100, r101, r102, r103, r104, r105};
        f308600a = r110;
        f308601b = EnumEntriesKt.enumEntries(r110);
    }

    public static SearchBoxStyle[] values() {
        return (SearchBoxStyle[]) f308600a.clone();
    }

    public static SearchBoxStyle valueOf(String r100) {
        return (SearchBoxStyle) r27.a.a(SearchBoxStyle.class, r100);
    }

    public SearchBoxStyle(String r100, int r101) {
        super(r100, r101);
    }
}
