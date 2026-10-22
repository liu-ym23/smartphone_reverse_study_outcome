package com.ss.android.ugc.aweme.search.common.mob;

import com.ss.android.ugc.aweme.search.mob.base.BaseSearchMobEvent;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0004B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, d2 = {"Lcom/ss/android/ugc/aweme/search/common/mob/SearchNoResultShowMobEvent;", "Lcom/ss/android/ugc/aweme/search/mob/base/BaseSearchMobEvent;", "<init>", "()V", "Companion", "ec-search-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class SearchNoResultShowMobEvent extends BaseSearchMobEvent<SearchNoResultShowMobEvent> {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final String f451778e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final String f451779f = null;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/ss/android/ugc/aweme/search/common/mob/SearchNoResultShowMobEvent$Companion;", "", "<init>", "()V", "ec-search-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(int r100) {
            this();
        }
    }

    static {
        new Companion(0);
        f451778e = "search_no_result_show";
        f451779f = "result_type";
    }

    public SearchNoResultShowMobEvent() {
        super(f451778e);
    }
}
