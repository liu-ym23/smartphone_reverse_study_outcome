package com.ss.android.ugc.aweme.search.filter.mob;

import com.ss.android.ugc.aweme.search.mob.base.BaseSearchMobEvent;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0002¨\u0006\u0003"}, d2 = {"Lcom/ss/android/ugc/aweme/search/filter/mob/FilterPromptShowEvent;", "Lcom/ss/android/ugc/aweme/search/mob/base/BaseSearchMobEvent;", "Companion", "ec-search-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class FilterPromptShowEvent extends BaseSearchMobEvent<FilterPromptShowEvent> {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/ss/android/ugc/aweme/search/filter/mob/FilterPromptShowEvent$Companion;", "", "()V", "LIFE_EVENT", "", "PROMPT_TYPE", "ec-search-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
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

    public FilterPromptShowEvent() {
        Intrinsics.checkNotNullParameter("life_search_filter_prompt_show", "event");
        super("life_search_filter_prompt_show");
    }
}
