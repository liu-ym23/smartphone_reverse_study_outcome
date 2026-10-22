package com.bytedance.android.shopping.store.router.hybridpage.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import com.bytedance.android.ec.core.arch.viewmodel.c;
import com.bytedance.android.shopping.store.router.hybridpage.setting.HybridPageConfigSetting;
import com.bytedance.android.shopping.store.router.hybridpage.viewmodel.HybridPageViewModel;
import com.ss.android.ugc.aweme.kiwi.ui.QUIManager;
import com.ss.android.ugc.aweme.kiwi.viewmodel.QViewModelOwner;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import pm.a;
import vj3.b;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0016\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B\u0007¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/shopping/store/router/hybridpage/fragment/HybridPageFragment;", "Landroidx/fragment/app/Fragment;", "Lcom/ss/android/ugc/aweme/kiwi/viewmodel/QViewModelOwner;", "Lpm/a;", "<init>", "()V", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public class HybridPageFragment extends Fragment implements QViewModelOwner, a {
    public final Lazy d;
    public final c e;
    public final QUIManager f;
    public boolean g;

    public final HybridPageViewModel T90() {
        return (HybridPageViewModel) this.e.getValue();
    }

    public final ViewModelProvider.Factory o6() {
        return (ViewModelProvider.Factory) this.d.getValue();
    }

    public b S90() {
        return (b) HybridPageConfigSetting.a.getValue();
    }

    public final void bindModule() {
        if (this.g == false) goto L5;
        return;
    L5:
        this.g = true;
        this.f.c(yj3.b.class, null);
    }

    public HybridPageFragment() {
        this.d = LazyKt.lazy(HybridPageFragment$factory$2.INSTANCE);
        Function0<ViewModelProvider.Factory> r0 = new HybridPageFragment$viewModel$2(this);
        final Function0<Fragment> r1 = new HybridPageFragment$$special$$inlined$viewModels$1(this);
        this.e = com.bytedance.android.ec.core.arch.viewmodel.b.a(this, Reflection.getOrCreateKotlinClass(HybridPageViewModel.class), new HybridPageFragment$$special$$inlined$viewModels$2(r1), r0);
        this.f = new QUIManager();
    }

    public final void onDestroy() {
        super.onDestroy();
        this.f.r(yj3.b.class);
    }

    public void onCreate(Bundle r3) {
        super.onCreate(r3);
        T90().initData(requireContext(), S90());
    }

    public final void onViewCreated(View r2, Bundle r3) {
        Intrinsics.checkNotNullParameter(r2, "view");
        super.onViewCreated(r2, r3);
        bindModule();
    }

    public final View onCreateView(LayoutInflater r4, ViewGroup r5, Bundle r6) {
        Intrinsics.checkNotNullParameter(r4, "inflater");
        QUIManager r7 = this.f;
        View r8 = th.a.c(requireContext(), 2131560859, r5, false);
        if (r8 == null) goto L7;
        r7.k(new yj3.b((ViewGroup) r8), requireContext(), this);
        return this.f.p();
    L7:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup");
    }
}
