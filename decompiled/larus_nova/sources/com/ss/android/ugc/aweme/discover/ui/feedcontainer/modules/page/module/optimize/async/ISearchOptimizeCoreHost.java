package com.ss.android.ugc.aweme.discover.ui.feedcontainer.modules.page.module.optimize.async;

import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;
import com.ss.android.ugc.aweme.config.PreloadCardConfig;
import com.ss.android.ugc.aweme.search.dynamic.core.IDynamicCard;
import java.util.Map;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002J\b\u0010\u0004\u001a\u00020\u0003H&¨\u0006\u0005"}, d2 = {"Lcom/ss/android/ugc/aweme/discover/ui/feedcontainer/modules/page/module/optimize/async/ISearchOptimizeCoreHost;", "MODEL", "", "Landroidx/fragment/app/FragmentActivity;", "getActivity", "ec-search-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface ISearchOptimizeCoreHost<MODEL> {
    int c(MODEL r100);

    MODEL e(String r100, String r101, int r102);

    boolean f(PreloadCardConfig r100, Map<String, ? extends Object> r101);

    int g(Object r100);

    FragmentActivity getActivity();

    IAsyncLoad<?> getAdapter();

    String getPageName();

    RecyclerView getRecyclerView();

    void h(RecyclerView.ViewHolder r100);

    int i();

    void j(RecyclerView.ViewHolder r100, Object r101);

    boolean l();

    IVhManager n();

    IDynamicCard o(RecyclerView.ViewHolder r100);
}
