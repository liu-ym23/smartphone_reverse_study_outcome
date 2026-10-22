package com.ss.android.ugc.aweme.discover.dynamic.optimize;

import androidx.recyclerview.widget.RecyclerView;
import com.ss.android.ugc.aweme.search.optimize.SearchOptimizeRequestContext;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\bf\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/ss/android/ugc/aweme/discover/dynamic/optimize/IECSaaSOptimize;", "", "ec-search-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface IECSaaSOptimize {
    void a(Object r100, SearchOptimizeRequestContext r101);

    void b(String r100);

    boolean d(RecyclerView.ViewHolder r100, int r101);

    RecyclerView.ViewHolder f(int r100);

    void i();

    boolean j();

    void onDestroy();
}
