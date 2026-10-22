package com.ss.android.ugc.aweme.search.optimize;

import androidx.recyclerview.widget.RecyclerView;
import com.ss.android.ugc.aweme.config.PreloadCardConfig;
import com.ss.ugc.android.cachalot.api.Trigger;
import com.ss.ugc.android.cachalot.common.async.controller.a;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\bf\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002¨\u0006\u0003"}, d2 = {"Lcom/ss/android/ugc/aweme/search/optimize/IOptimizeCore;", "CARD_DATA", "", "trade-search-impl_release"}, k = 1, mv = {1, 4, 3})
public interface IOptimizeCore<CARD_DATA> {
    int c(CARD_DATA r100);

    ExecutorService d();

    CARD_DATA e(String r100, String r101, int r102);

    boolean f(PreloadCardConfig r100, Map<String, ? extends Object> r101);

    int g(Object r100);

    void h(RecyclerView.ViewHolder r100);

    void i();

    PreBindResult j(int r100, a r101, Trigger r102);

    void l(Object r100, Function1 r101, Function1 r102, boolean r103, PreloadCardConfig r104);

    void n(int r100, int r101);
}
