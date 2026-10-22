package com.bytedance.android.window.shop.search.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ViewModelProvider;
import com.bytedance.android.btm.api.BtmSDKWrapper;
import com.bytedance.android.ec.core.arch.viewmodel.b;
import com.bytedance.android.ec.core.arch.viewmodel.c;
import com.bytedance.android.ec.monitor.duration.i;
import com.bytedance.android.ec.window.base.utils.quick.d;
import com.bytedance.android.window.shop.search.viewmodel.WindowSearchResultViewModel;
import com.ss.android.ugc.aweme.kiwi.ui.QUIManager;
import com.ss.android.ugc.aweme.kiwi.viewmodel.QViewModelOwner;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import vq3.f;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002:\u0001\u0005B\u0007¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/window/shop/search/fragment/WindowSearchResultFragment;", "Landroidx/fragment/app/Fragment;", "Lcom/ss/android/ugc/aweme/kiwi/viewmodel/QViewModelOwner;", "<init>", "()V", "a", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class WindowSearchResultFragment extends Fragment implements QViewModelOwner {
    public static final /* synthetic */ int f = 0;
    public final QUIManager d;
    public final c e;

    public static final class a {
    }

    static {
    }

    public final ViewModelProvider.Factory o6() {
        return new ViewModelProvider.NewInstanceFactory();
    }

    public WindowSearchResultFragment() {
        this.d = new QUIManager();
        Function0<ViewModelProvider.Factory> r0 = new WindowSearchResultFragment$viewModel$2(this);
        final Function0<Fragment> r1 = new WindowSearchResultFragment$$special$$inlined$viewModels$1(this);
        this.e = b.a(this, Reflection.getOrCreateKotlinClass(WindowSearchResultViewModel.class), new WindowSearchResultFragment$$special$$inlined$viewModels$2(r1), r0);
    }

    public final void onDestroy() {
        super.onDestroy();
        this.d.r(f.class);
    }

    public final void onPause() {
        super.onPause();
        ((WindowSearchResultViewModel) this.e.getValue()).traceTimeEnd();
    }

    public final void onResume() {
        super.onResume();
        ((WindowSearchResultViewModel) this.e.getValue()).setMToNewPage(true);
        ((WindowSearchResultViewModel) this.e.getValue()).traceTimeStart();
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
        Lazy r5 = BtmSDKWrapper.a;
        Bundle r6 = getArguments();
        if (r6 == null) goto L5;
        String r7 = r6.getString("source_btm_token");
    L6:
        BtmSDKWrapper.b(this, "a1.b7881", r7);
        ((WindowSearchResultViewModel) this.e.getValue()).initData(getArguments());
        Map r8 = wo.a.a;
        Intrinsics.checkNotNullParameter("ec_perf_duration_shop_search_result", "business");
        wo.a.a.put("ec_perf_duration_shop_search_result", i.a.create("ec_perf_duration_shop_search_result"));
        wo.a.b.put("ec_perf_duration_shop_search_result", new LinkedHashMap());
        wo.a.a("ec_perf_duration_shop_search_result", "initial", System.currentTimeMillis());
        return;
    L5:
        r7 = null;
        goto L6
    }

    public final void onViewCreated(View r2, Bundle r3) {
        Intrinsics.checkNotNullParameter(r2, "view");
        super.onViewCreated(r2, r3);
        this.d.c(f.class, null);
    }

    public final View onCreateView(LayoutInflater r2, ViewGroup r3, Bundle r4) {
        Intrinsics.checkNotNullParameter(r2, "inflater");
        View r5 = th.a.c(requireContext(), 2131561070, null, false);
        d.a(this.d, new f(r5, this), requireContext(), this);
        return this.d.p();
    }
}
