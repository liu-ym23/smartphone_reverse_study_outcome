package com.bytedance.flow.search.kmp.api.store;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\t\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/bytedance/flow/search/kmp/api/store/SearchLoadingState;", "", "<init>", "(Ljava/lang/String;I)V", "Loading", "LoadingMore", "LoadSuccessCanLoadMore", "LoadSuccessFinished", "LoadMoreFailed", "LoadFailed", "aggregate_search_kmp_api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum SearchLoadingState extends Enum<SearchLoadingState> {
    public static final SearchLoadingState LoadFailed = null;
    public static final SearchLoadingState LoadMoreFailed = null;
    public static final SearchLoadingState LoadSuccessCanLoadMore = null;
    public static final SearchLoadingState LoadSuccessFinished = null;
    public static final SearchLoadingState Loading = null;
    public static final SearchLoadingState LoadingMore = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ SearchLoadingState[] f243546a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f243547b = null;

    public static EnumEntries<SearchLoadingState> getEntries() {
        return f243547b;
    }

    static {
        SearchLoadingState r100 = new SearchLoadingState("Loading", 0);
        Loading = r100;
        SearchLoadingState r101 = new SearchLoadingState("LoadingMore", 1);
        LoadingMore = r101;
        SearchLoadingState r102 = new SearchLoadingState("LoadSuccessCanLoadMore", 2);
        LoadSuccessCanLoadMore = r102;
        SearchLoadingState r103 = new SearchLoadingState("LoadSuccessFinished", 3);
        LoadSuccessFinished = r103;
        SearchLoadingState r104 = new SearchLoadingState("LoadMoreFailed", 4);
        LoadMoreFailed = r104;
        SearchLoadingState r105 = new SearchLoadingState("LoadFailed", 5);
        LoadFailed = r105;
        SearchLoadingState[] r110 = {r100, r101, r102, r103, r104, r105};
        f243546a = r110;
        f243547b = EnumEntriesKt.enumEntries(r110);
    }

    public static SearchLoadingState[] values() {
        return (SearchLoadingState[]) f243546a.clone();
    }

    public static SearchLoadingState valueOf(String r100) {
        return (SearchLoadingState) a.a(SearchLoadingState.class, r100);
    }

    public SearchLoadingState(String r100, int r101) {
        super(r100, r101);
    }
}
