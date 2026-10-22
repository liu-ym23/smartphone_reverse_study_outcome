package com.ss.android.lark.search.doubao.api.request;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes38.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\t\b\u0086\u0081\u0002\u0018\u0000 \u000b2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u000bB\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\f"}, d2 = {"Lcom/ss/android/lark/search/doubao/api/request/SearchContentType;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "ONLY_TITLE", "FULL_CONTENT", "ONLY_COMMENT", "Companion", "search-doubao-api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum SearchContentType extends Enum<SearchContentType> {
    public static final a Companion = null;
    public static final SearchContentType FULL_CONTENT = null;
    public static final SearchContentType ONLY_COMMENT = null;
    public static final SearchContentType ONLY_TITLE = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ SearchContentType[] f439948a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f439949b = null;
    private final int value;

    public static EnumEntries<SearchContentType> getEntries() {
        return f439949b;
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [com.ss.android.lark.search.doubao.api.request.SearchContentType$a] */
    static {
        SearchContentType r100 = new SearchContentType("ONLY_TITLE", 0, 1);
        ONLY_TITLE = r100;
        SearchContentType r101 = new SearchContentType("FULL_CONTENT", 1, 2);
        FULL_CONTENT = r101;
        SearchContentType r102 = new SearchContentType("ONLY_COMMENT", 2, 3);
        ONLY_COMMENT = r102;
        SearchContentType[] r103 = {r100, r101, r102};
        f439948a = r103;
        f439949b = EnumEntriesKt.enumEntries(r103);
        Companion = new a();
    }

    public static SearchContentType[] values() {
        return (SearchContentType[]) f439948a.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public static SearchContentType valueOf(String r100) {
        return (SearchContentType) r27.a.a(SearchContentType.class, r100);
    }

    public SearchContentType(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
