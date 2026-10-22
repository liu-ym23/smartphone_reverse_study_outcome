package com.bytedance.android.shopping.store.search.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ViewModelProvider;
import ck3.g;
import com.bytedance.android.btm.api.BtmSDKWrapper;
import com.bytedance.android.ec.core.arch.viewmodel.b;
import com.bytedance.android.ec.core.arch.viewmodel.c;
import com.bytedance.android.shopping.store.search.viewmodel.ShopSearchResultViewModel;
import com.ss.android.ugc.aweme.kiwi.ui.QUIManager;
import com.ss.android.ugc.aweme.kiwi.viewmodel.QViewModelOwner;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002:\u0001\u0005B\u0007¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/shopping/store/search/fragment/ShopSearchResultFragment;", "Landroidx/fragment/app/Fragment;", "Lcom/ss/android/ugc/aweme/kiwi/viewmodel/QViewModelOwner;", "<init>", "()V", "a", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ShopSearchResultFragment extends Fragment implements QViewModelOwner {
    public static final /* synthetic */ int g = 0;
    public final QUIManager d;
    public final Lazy e;
    public final c f;

    public static final class a {
    }

    static {
    }

    public final ShopSearchResultViewModel S90() {
        return (ShopSearchResultViewModel) this.f.getValue();
    }

    public final ViewModelProvider.Factory o6() {
        return (ViewModelProvider.Factory) this.e.getValue();
    }

    public ShopSearchResultFragment() {
        this.d = new QUIManager();
        this.e = LazyKt.lazy(ShopSearchResultFragment$factory$2.INSTANCE);
        Function0<ViewModelProvider.Factory> r0 = new ShopSearchResultFragment$viewModel$2(this);
        final Function0<Fragment> r1 = new ShopSearchResultFragment$$special$$inlined$viewModels$1(this);
        this.f = b.a(this, Reflection.getOrCreateKotlinClass(ShopSearchResultViewModel.class), new ShopSearchResultFragment$$special$$inlined$viewModels$2(r1), r0);
    }

    public final void onDestroy() {
        super.onDestroy();
        this.d.r(g.class);
        S90().traceTimeEnd();
    }

    public final void onPause() {
        super.onPause();
        S90().traceTimePause();
    }

    public final void onResume() {
        super.onResume();
        S90().setMToNewPage(true);
        S90().traceTimeStart();
    }

    public final void onStart() {
        super.onStart();
        int r0 = com.bytedance.sdk.xbridge.cn.ui.utils.a.a;
        FragmentActivity r1 = getActivity();
        if (r1 == null) goto L7;
        com.bytedance.sdk.xbridge.cn.ui.utils.a.h(r1);
        return;
    L7:
        throw new NullPointerException("null cannot be cast to non-null type android.app.Activity");
    }

    public final void onCreate(Bundle r4) {
        super.onCreate(r4);
        S90().initData(getArguments());
        Lazy r5 = BtmSDKWrapper.a;
        BtmSDKWrapper.b(this, S90().getPageBtm(), S90().getSearchParam().getSourceBtmToken());
        qm.a.b("ec_perf_duration_shop_search_result");
        qm.a.a("ec_perf_duration_shop_search_result", "initial", System.currentTimeMillis());
    }

    public final void onViewCreated(View r2, Bundle r3) {
        Intrinsics.checkNotNullParameter(r2, "view");
        super.onViewCreated(r2, r3);
        this.d.c(g.class, null);
    }

    public final View onCreateView(LayoutInflater r2, ViewGroup r3, Bundle r4) {
        Intrinsics.checkNotNullParameter(r2, "inflater");
        View r5 = th.a.c(requireContext(), 2131561063, null, false);
        pn.b.a(this.d, new g(r5, this), requireContext(), this);
        return this.d.p();
    }
}
