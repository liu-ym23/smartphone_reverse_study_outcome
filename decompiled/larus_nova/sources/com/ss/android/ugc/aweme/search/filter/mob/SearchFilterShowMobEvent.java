package com.ss.android.ugc.aweme.search.filter.mob;

import com.obric.miniapp.alarm.AlarmSessionType;
import com.ss.android.ugc.aweme.search.mob.base.BaseFilterMobEvent;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0004B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, d2 = {"Lcom/ss/android/ugc/aweme/search/filter/mob/SearchFilterShowMobEvent;", "Lcom/ss/android/ugc/aweme/search/mob/base/BaseFilterMobEvent;", "<init>", "()V", "Companion", "ec-search-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class SearchFilterShowMobEvent extends BaseFilterMobEvent<SearchFilterShowMobEvent> {

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004¨\u0006\u0007"}, d2 = {"Lcom/ss/android/ugc/aweme/search/filter/mob/SearchFilterShowMobEvent$Companion;", "", "", AlarmSessionType.EVENT, "Ljava/lang/String;", "<init>", "()V", "ec-search-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(int r100) {
            this();
        }
    }

    static {
        new Companion(0);
    }

    public SearchFilterShowMobEvent() {
        super("search_filter_show");
    }
}
