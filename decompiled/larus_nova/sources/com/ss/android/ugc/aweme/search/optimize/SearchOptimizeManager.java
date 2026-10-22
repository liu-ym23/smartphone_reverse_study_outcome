package com.ss.android.ugc.aweme.search.optimize;

import com.larus.dora.obric.device_management.device_home.DoraObricDeviceHomeViewModel;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0001\u0004B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, d2 = {"Lcom/ss/android/ugc/aweme/search/optimize/SearchOptimizeManager;", "", "<init>", "()V", "EventDispatcher", "trade-search-impl_release"}, k = 1, mv = {1, 4, 3})
public final class SearchOptimizeManager {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final HashMap<String, PreloadData> f453358a;

    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0004\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/ss/android/ugc/aweme/search/optimize/SearchOptimizeManager$EventDispatcher;", "Lcom/ss/android/ugc/aweme/search/optimize/IEventDispatcher;", "trade-search-impl_release"}, k = 1, mv = {1, 4, 3})
    public final class EventDispatcher implements IEventDispatcher {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final ArrayList<IOptimize> f453359a;

        @Override // com.ss.android.ugc.aweme.search.optimize.IEventDispatcher
        public final void b(final String r100) {
            Intrinsics.checkNotNullParameter(r100, "scene");
            e(new SearchOptimizeManager$EventDispatcher$onRefreshViewDrawEnd$1(r100));
        }

        public final void e(Function1<? super IOptimize, Unit> r100) {
            Iterator<T> r101 = this.f453359a.iterator();
        L4:
            if (r101.hasNext() == false) goto L6;
            r100.invoke((IOptimize) r101.next());
            goto L4
        }

        public EventDispatcher(String r100, ArrayList r101) {
            Intrinsics.checkNotNullParameter(r100, "pageName");
            Intrinsics.checkNotNullParameter(r101, "currentPageOptimizeList");
            this.f453359a = r101;
        }

        @Override // com.ss.android.ugc.aweme.search.optimize.IEventDispatcher
        public final void a(final Object r100, final SearchOptimizeRequestContext r101) {
            Intrinsics.checkNotNullParameter(r100, DoraObricDeviceHomeViewModel.PARAM_PRODUCT_MODEL);
            e(new SearchOptimizeManager$EventDispatcher$beforeRefreshData$1(r100, r101));
        }

        @Override // com.ss.android.ugc.aweme.search.optimize.IEventDispatcher
        public final void c(boolean r100, final SearchOptimizeRequestContext r101) {
            final boolean r102 = true;
            e(new SearchOptimizeManager$EventDispatcher$onRequestStart$1(r102, r101));
        }
    }

    public SearchOptimizeManager() {
        this.f453358a = new HashMap();
    }
}
