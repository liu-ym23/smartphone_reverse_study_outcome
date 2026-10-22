package com.larus.im.bean.message.block;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes29.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/larus/im/bean/message/block/SearchQueryResultScene;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "Think", "SearchReference", "imsdkkmp_api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum SearchQueryResultScene extends Enum<SearchQueryResultScene> {
    public static final SearchQueryResultScene SearchReference = null;
    public static final SearchQueryResultScene Think = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ SearchQueryResultScene[] f347054a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f347055b = null;
    private final int value;

    public static EnumEntries<SearchQueryResultScene> getEntries() {
        return f347055b;
    }

    static {
        SearchQueryResultScene r100 = new SearchQueryResultScene("Think", 0, 1);
        Think = r100;
        SearchQueryResultScene r101 = new SearchQueryResultScene("SearchReference", 1, 2);
        SearchReference = r101;
        SearchQueryResultScene[] r102 = {r100, r101};
        f347054a = r102;
        f347055b = EnumEntriesKt.enumEntries(r102);
    }

    public static SearchQueryResultScene[] values() {
        return (SearchQueryResultScene[]) f347054a.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public static SearchQueryResultScene valueOf(String r100) {
        return (SearchQueryResultScene) a.a(SearchQueryResultScene.class, r100);
    }

    public SearchQueryResultScene(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
