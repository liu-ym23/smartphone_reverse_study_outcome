package com.larus.im.bean.message.block;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes29.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\n\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\r"}, d2 = {"Lcom/larus/im/bean/message/block/SearchType;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "Default", "WebSearch", "TextSearchImage", "ImageSearchImage", "ScholarSearch", "imsdkkmp_api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum SearchType extends Enum<SearchType> {
    public static final SearchType Default = null;
    public static final SearchType ImageSearchImage = null;
    public static final SearchType ScholarSearch = null;
    public static final SearchType TextSearchImage = null;
    public static final SearchType WebSearch = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ SearchType[] f347062a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f347063b = null;
    private final int value;

    public static EnumEntries<SearchType> getEntries() {
        return f347063b;
    }

    static {
        SearchType r100 = new SearchType("Default", 0, 0);
        Default = r100;
        SearchType r101 = new SearchType("WebSearch", 1, 1);
        WebSearch = r101;
        SearchType r102 = new SearchType("TextSearchImage", 2, 2);
        TextSearchImage = r102;
        SearchType r103 = new SearchType("ImageSearchImage", 3, 3);
        ImageSearchImage = r103;
        SearchType r104 = new SearchType("ScholarSearch", 4, 4);
        ScholarSearch = r104;
        SearchType[] r105 = {r100, r101, r102, r103, r104};
        f347062a = r105;
        f347063b = EnumEntriesKt.enumEntries(r105);
    }

    public static SearchType[] values() {
        return (SearchType[]) f347062a.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public static SearchType valueOf(String r100) {
        return (SearchType) a.a(SearchType.class, r100);
    }

    public SearchType(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
