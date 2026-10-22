package com.ss.android.ugc.aweme.discover.commodity.holder.selects;

import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import com.ss.android.ugc.aweme.search.model.SearchResultParam;
import kotlin.Deprecated;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\bf\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/ss/android/ugc/aweme/discover/commodity/holder/selects/SelectsHost;", "", "ec-search-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface SelectsHost {
    void a(View r100);

    void b(ChangeFormatParam r100);

    void c(int r100, boolean r101);

    void d();

    RecyclerView e();

    void f(SearchResultParam r100);

    View g();

    Fragment getFragment();

    @Deprecated(message = "不要直接获取RV，容器化不支持了")
    RecyclerView getRecyclerView();
}
