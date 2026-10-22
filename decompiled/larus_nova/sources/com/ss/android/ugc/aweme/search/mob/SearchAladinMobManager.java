package com.ss.android.ugc.aweme.search.mob;

import com.bytedance.android.ec.core.event.a;
import com.ss.android.ugc.aweme.search.common.mob.BaseSearchResultMobEvent;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/ss/android/ugc/aweme/search/mob/SearchAladinMobManager;", "", "<init>", "()V", "ec-search-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class SearchAladinMobManager {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final SearchAladinMobManager f453320a = null;

    private SearchAladinMobManager() {
    }

    static {
        f453320a = new SearchAladinMobManager();
    }

    public static void a(BaseSearchResultMobEvent r100, ItemMobParam r101) {
        String r102 = r101.f453304g;
        String r103 = r101.f453303f;
        String r104 = r101.f453302e;
        String r105 = r101.f453299b;
        String r106 = r101.f453301d;
        int r107 = r101.f453305h;
        r100.f("search_id", r104);
        r100.f("search_keyword", r105);
        r100.f("log_pb", r102);
        r100.f("sentence_id", null);
        r100.f("impr_id", r103);
        r100.f("enter_from", r106);
        Intrinsics.checkNotNullParameter("1", "param");
        r100.f(a.KEY_IS_ALADDIN, "1");
        r100.i(Integer.valueOf(r107));
        r100.a(r101.f453312o);
    }
}
