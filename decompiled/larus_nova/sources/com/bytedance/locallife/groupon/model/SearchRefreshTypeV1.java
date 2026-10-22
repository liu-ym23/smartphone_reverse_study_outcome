package com.bytedance.locallife.groupon.model;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/bytedance/locallife/groupon/model/SearchRefreshTypeV1;", "", "", "value", "Ljava/lang/String;", "getValue", "()Ljava/lang/String;", "UNKNOWN", "GROUPON_FEED_LOAD_MORE", "GROUPON_ENTER_FRONTGROUND", "locallife-groupon-api_release"}, k = 1, mv = {1, 4, 3})
public final enum SearchRefreshTypeV1 extends Enum<SearchRefreshTypeV1> {
    public static final SearchRefreshTypeV1 GROUPON_ENTER_FRONTGROUND = null;
    public static final SearchRefreshTypeV1 GROUPON_FEED_LOAD_MORE = null;
    public static final SearchRefreshTypeV1 UNKNOWN = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ SearchRefreshTypeV1[] f258806a = null;
    private final String value;

    public static SearchRefreshTypeV1 valueOf(String r100) {
        return (SearchRefreshTypeV1) a.a(SearchRefreshTypeV1.class, r100);
    }

    public static SearchRefreshTypeV1[] values() {
        return (SearchRefreshTypeV1[]) f258806a.clone();
    }

    static {
        SearchRefreshTypeV1 r100 = new SearchRefreshTypeV1("UNKNOWN", 0, "unknown");
        UNKNOWN = r100;
        SearchRefreshTypeV1 r101 = new SearchRefreshTypeV1("GROUPON_FEED_LOAD_MORE", 1, "groupon_feed_load_more");
        GROUPON_FEED_LOAD_MORE = r101;
        SearchRefreshTypeV1 r102 = new SearchRefreshTypeV1("GROUPON_ENTER_FRONTGROUND", 2, "groupon_enter_frontground");
        GROUPON_ENTER_FRONTGROUND = r102;
        f258806a = new SearchRefreshTypeV1[]{r100, r101, r102};
    }

    public final String getValue() {
        return this.value;
    }

    public SearchRefreshTypeV1(String r100, int r101, String r102) {
        super(r100, r101);
        this.value = r102;
    }
}
