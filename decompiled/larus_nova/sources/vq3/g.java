package vq3;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.ugc.aweme.kiwi.presenter.QIPresenter;
import com.ss.android.ugc.aweme.kiwi.ui.QUIModule;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
public final class g extends QUIModule {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final ViewGroup f556765l;

    @Override // com.ss.android.ugc.aweme.kiwi.ui.QUIModule
    public final QIPresenter h() {
        return null;
    }

    @Override // com.ss.android.ugc.aweme.kiwi.ui.QUIModule
    public final List<QUIModule> i() {
        return CollectionsKt.listOf(new QUIModule[]{new h(th.a.d(th.a.e(this.f556765l.getContext(), true), R.layout.window_sort_bar_layout, this.f556765l, 4)), new i(this.f556765l.findViewById(R.id.fl_store_search_sort)), new j(this.f556765l.findViewById(R.id.sv_product_list_status))});
    }

    public g(ViewGroup r100) {
        Intrinsics.checkNotNullParameter(r100, "rootView");
        super(0);
        this.f556765l = r100;
    }

    @Override // com.ss.android.ugc.aweme.kiwi.ui.QUIModule
    public final View f(Context r100, ViewGroup r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        return this.f556765l;
    }
}
