package com.ss.android.ugc.aweme.discover.ui.feedcontainer.modules.page.module.optimize.async;

import androidx.recyclerview.widget.RecyclerView;
import java.util.Queue;
import kotlin.Metadata;
import kotlin.ranges.IntRange;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\bf\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/ss/android/ugc/aweme/discover/ui/feedcontainer/modules/page/module/optimize/async/IAsyncPrefetchStrategy;", "", "ec-search-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface IAsyncPrefetchStrategy {
    Queue<Integer> C(RecyclerView r100, int r101);

    void a(RecyclerView r100);

    void b();

    void c();

    void d(RecyclerView r100);

    IntRange e(RecyclerView r100);

    Queue f(RecyclerView r100, int r101);

    void g(RecyclerView r100);

    void timeout();
}
