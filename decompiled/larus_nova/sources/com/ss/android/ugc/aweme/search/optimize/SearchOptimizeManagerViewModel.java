package com.ss.android.ugc.aweme.search.optimize;

import androidx.lifecycle.ViewModel;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u00072\u00020\u0001:\u0001\u0007B\u0005¢\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\b"}, d2 = {"Lcom/ss/android/ugc/aweme/search/optimize/SearchOptimizeManagerViewModel;", "Landroidx/lifecycle/ViewModel;", "()V", "searchOptimizeManager", "Lcom/ss/android/ugc/aweme/search/optimize/SearchOptimizeManager;", "getSearchOptimizeManager", "()Lcom/ss/android/ugc/aweme/search/optimize/SearchOptimizeManager;", "Companion", "trade-search-impl_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
public final class SearchOptimizeManagerViewModel extends ViewModel {
    public static final Companion Companion = null;
    private final SearchOptimizeManager searchOptimizeManager;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/ss/android/ugc/aweme/search/optimize/SearchOptimizeManagerViewModel$Companion;", "", "<init>", "()V", "trade-search-impl_release"}, k = 1, mv = {1, 4, 3})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(int r100) {
            this();
        }
    }

    static {
        Companion = new Companion(0);
    }

    public SearchOptimizeManagerViewModel() {
        this.searchOptimizeManager = new SearchOptimizeManager();
    }

    public final SearchOptimizeManager getSearchOptimizeManager() {
        return this.searchOptimizeManager;
    }
}
