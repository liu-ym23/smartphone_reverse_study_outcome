package com.ss.android.ugc.aweme.discover.commodity.view;

import com.ss.android.ugc.aweme.search.common.mob.SearchNoResultClickMobEvent;
import com.ss.android.ugc.aweme.search.common.mob.SearchNoResultShowMobEvent;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(d1 = {"\u0000\u0002\n\u0000¨\u0006\u0000"}, d2 = {"ec-search-impl_saasRelease"}, k = 2, mv = {1, 4, 3})
public final class SearchNoResultViewKt {
    public static final void a(String r100, String r101, String r102, String r103) {
        SearchNoResultClickMobEvent r104 = new SearchNoResultClickMobEvent();
        r104.f("enter_from", r100);
        r104.f("search_keyword", r102);
        r104.f("search_id", r101);
        r104.f("impr_id", r101);
        r104.f(SearchNoResultClickMobEvent.f451777f, r103);
        r104.post(null, null);
    }

    public static final void b(String r100, String r101, String r102, String r103) {
        SearchNoResultShowMobEvent r104 = new SearchNoResultShowMobEvent();
        r104.f("enter_from", r100);
        r104.f("search_keyword", r102);
        r104.f("search_id", r101);
        r104.f("impr_id", r101);
        r104.f(SearchNoResultShowMobEvent.f451779f, r103);
        r104.post(null, null);
    }
}
