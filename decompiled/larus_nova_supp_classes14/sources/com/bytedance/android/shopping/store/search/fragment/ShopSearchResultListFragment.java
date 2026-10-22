package com.bytedance.android.shopping.store.search.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import ck3.h;
import com.bytedance.android.ec.core.arch.viewmodel.b;
import com.bytedance.android.ec.core.arch.viewmodel.c;
import com.bytedance.android.shopping.store.search.router.ECShopSearchParam;
import com.bytedance.android.shopping.store.search.viewmodel.ShopSearchFragmentProductViewModel;
import com.ss.android.ugc.aweme.kiwi.ui.QUIManager;
import com.ss.android.ugc.aweme.kiwi.viewmodel.QViewModelOwner;
import java.io.Serializable;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003:\u0001\u0006B\u0007¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0007"}, d2 = {"Lcom/bytedance/android/shopping/store/search/fragment/ShopSearchResultListFragment;", "Landroidx/fragment/app/Fragment;", "Lcom/ss/android/ugc/aweme/kiwi/viewmodel/QViewModelOwner;", "Lpm/a;", "<init>", "()V", "a", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ShopSearchResultListFragment extends Fragment implements QViewModelOwner, pm.a {
    public static final /* synthetic */ int h = 0;
    public final Lazy d;
    public final c e;
    public final QUIManager f;
    public boolean g;

    public static final class a {
    }

    static {
    }

    public final ShopSearchFragmentProductViewModel S90() {
        return (ShopSearchFragmentProductViewModel) this.e.getValue();
    }

    public final ViewModelProvider.Factory o6() {
        return (ViewModelProvider.Factory) this.d.getValue();
    }

    public final void bindModule() {
        if (this.g == false) goto L5;
        return;
    L5:
        this.g = true;
        this.f.c(h.class, null);
    }

    public ShopSearchResultListFragment() {
        this.d = LazyKt.lazy(ShopSearchResultListFragment$factory$2.INSTANCE);
        Function0<ViewModelProvider.Factory> r0 = new ShopSearchResultListFragment$viewModel$2(this);
        final Function0<Fragment> r1 = new ShopSearchResultListFragment$$special$$inlined$viewModels$1(this);
        this.e = b.a(this, Reflection.getOrCreateKotlinClass(ShopSearchFragmentProductViewModel.class), new ShopSearchResultListFragment$$special$$inlined$viewModels$2(r1), r0);
        this.f = new QUIManager();
    }

    public final void onDestroy() {
        super.onDestroy();
        this.f.r(h.class);
    }

    public final void onResume() {
        super.onResume();
        if (isDetached() == false) goto L5;
        return;
    L5:
        if (getContext() != null) goto L7;
        return;
    L7:
        if (this.g == false) goto L12;
        S90().getPlayVideoAction().setValue(new rg.a(Boolean.TRUE));
        return;
    }

    public final void onStop() {
        super.onStop();
        S90().stopPlayVideo();
    }

    public final void onCreate(Bundle r5) {
        super.onCreate(r5);
        Bundle r6 = getArguments();
        if (r6 == null) goto L5;
        Serializable r7 = r6.getSerializable("store_param");
    L6:
        if (r7 == null) goto L13;
        ECShopSearchParam r8 = (ECShopSearchParam) r7;
        Bundle r1 = getArguments();
        boolean r2 = true;
        if (r1 == null) goto L10;
        r2 = r1.getBoolean("show_sort_bar", true);
    L10:
        S90().init(r8, null, r2);
        S90().setMyCartListener(null);
        S90().setDestView(null);
        return;
    L13:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.shopping.store.search.router.ECShopSearchParam");
    L5:
        r7 = null;
        goto L6
    }

    public final void setUserVisibleHint(boolean r3) {
        super.setUserVisibleHint(r3);
        if (isDetached() == false) goto L5;
        return;
    L5:
        if (getContext() != null) goto L7;
        return;
    L7:
        if (this.g == false) goto L12;
        S90().getPlayVideoAction().setValue(new rg.a(Boolean.valueOf(r3)));
        return;
    }

    public final void onViewCreated(View r2, Bundle r3) {
        Intrinsics.checkNotNullParameter(r2, "view");
        super.onViewCreated(r2, r3);
        bindModule();
    }

    public final View onCreateView(LayoutInflater r4, ViewGroup r5, Bundle r6) {
        Intrinsics.checkNotNullParameter(r4, "inflater");
        QUIManager r7 = this.f;
        View r8 = th.a.c(requireContext(), 2131564664, r5, false);
        if (r8 == null) goto L7;
        r7.k(new h((ViewGroup) r8), requireContext(), this);
        return this.f.p();
    L7:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup");
    }
}
