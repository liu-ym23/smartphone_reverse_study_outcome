package com.bytedance.android.window.shop.search.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import com.bytedance.android.ec.core.arch.viewmodel.b;
import com.bytedance.android.ec.core.arch.viewmodel.c;
import com.bytedance.android.window.shop.search.router.ECWindowSearchParam;
import com.bytedance.android.window.shop.search.viewmodel.WindowSearchFragmentProductViewModel;
import com.ss.android.ugc.aweme.kiwi.ui.QUIManager;
import com.ss.android.ugc.aweme.kiwi.viewmodel.QViewModelOwner;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import vq3.g;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003:\u0001\u0006B\u0007¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0007"}, d2 = {"Lcom/bytedance/android/window/shop/search/fragment/WindowSearchResultListFragment;", "Landroidx/fragment/app/Fragment;", "Lcom/ss/android/ugc/aweme/kiwi/viewmodel/QViewModelOwner;", "", "<init>", "()V", "a", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class WindowSearchResultListFragment extends Fragment implements QViewModelOwner {
    public static final /* synthetic */ int g = 0;
    public final c d;
    public final QUIManager e;
    public boolean f;

    public static final class a {
    }

    static {
    }

    public final WindowSearchFragmentProductViewModel S90() {
        return (WindowSearchFragmentProductViewModel) this.d.getValue();
    }

    public final ViewModelProvider.Factory o6() {
        return new ViewModelProvider.NewInstanceFactory();
    }

    public WindowSearchResultListFragment() {
        Function0<ViewModelProvider.Factory> r0 = new WindowSearchResultListFragment$viewModel$2(this);
        final Function0<Fragment> r1 = new WindowSearchResultListFragment$$special$$inlined$viewModels$1(this);
        this.d = b.a(this, Reflection.getOrCreateKotlinClass(WindowSearchFragmentProductViewModel.class), new WindowSearchResultListFragment$$special$$inlined$viewModels$2(r1), r0);
        this.e = new QUIManager();
    }

    public final void onDestroy() {
        super.onDestroy();
        this.e.r(g.class);
    }

    public final void onResume() {
        super.onResume();
        if (isDetached() == false) goto L5;
        return;
    L5:
        if (getContext() != null) goto L7;
        return;
    L7:
        if (this.f == false) goto L12;
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
        ECWindowSearchParam r8 = (ECWindowSearchParam) r7;
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
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.window.shop.search.router.ECWindowSearchParam");
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
        if (this.f == false) goto L12;
        S90().getPlayVideoAction().setValue(new rg.a(Boolean.valueOf(r3)));
        return;
    }

    public final void onViewCreated(View r2, Bundle r3) {
        Intrinsics.checkNotNullParameter(r2, "view");
        super.onViewCreated(r2, r3);
        if (this.f == true) goto L7;
        this.f = true;
        this.e.c(g.class, null);
        return;
    }

    public final View onCreateView(LayoutInflater r4, ViewGroup r5, Bundle r6) {
        Intrinsics.checkNotNullParameter(r4, "inflater");
        QUIManager r7 = this.e;
        View r8 = th.a.c(requireContext(), 2131564665, r5, false);
        if (r8 == null) goto L7;
        r7.k(new g((ViewGroup) r8), requireContext(), this);
        return this.e.p();
    L7:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup");
    }
}
