package com.bytedance.android.shopping.store.shopfeed.fragment;

import android.content.Context;
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
import com.bytedance.android.shopping.store.shopfeed.ECShopInnerFlowShareHelper;
import com.bytedance.android.shopping.store.shopfeed.viewmodel.ECShopFeedViewModel;
import com.ss.android.ugc.aweme.kiwi.ui.QUIManager;
import com.ss.android.ugc.aweme.kiwi.ui.QUIModule;
import com.ss.android.ugc.aweme.kiwi.viewmodel.QViewModelOwner;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b&\u0018\u00002\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/shopping/store/shopfeed/fragment/AbsShopFeedFragment;", "Landroidx/fragment/app/Fragment;", "Lcom/ss/android/ugc/aweme/kiwi/viewmodel/QViewModelOwner;", "<init>", "()V", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public abstract class AbsShopFeedFragment extends Fragment implements QViewModelOwner {
    public final QUIManager d;
    public final c e;

    public abstract int S90();

    public abstract String T90();

    public abstract Class<? extends QUIModule> U90();

    public abstract QUIModule V90(View r1);

    public final ViewModelProvider.Factory o6() {
        return new ViewModelProvider.NewInstanceFactory();
    }

    public AbsShopFeedFragment() {
        this.d = new QUIManager();
        Function0<ViewModelProvider.Factory> r0 = new AbsShopFeedFragment$viewModel$2(this);
        final Function0<Fragment> r1 = new AbsShopFeedFragment$$special$$inlined$viewModels$1(this);
        this.e = b.a(this, Reflection.getOrCreateKotlinClass(ECShopFeedViewModel.class), new AbsShopFeedFragment$$special$$inlined$viewModels$2(r1), r0);
    }

    public final void onDestroy() {
        super.onDestroy();
        this.d.r(U90());
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
        String r6 = T90();
        Bundle r0 = getArguments();
        if (r0 == null) goto L5;
        String r1 = r0.getString("source_btm_token");
    L6:
        BtmSDKWrapper.b(this, r6, r1);
        Context r7 = getContext();
        if (r7 == null) goto L10;
        ((ECShopFeedViewModel) this.e.getValue()).initParam(getArguments(), r7, this instanceof ECShopInnerFlowFragment);
        ((ECShopFeedViewModel) this.e.getValue()).setShareHelper(new ECShopInnerFlowShareHelper(this));
        return;
    L10:
        return;
    L5:
        r1 = null;
        goto L6
    }

    public final void onViewCreated(View r2, Bundle r3) {
        Intrinsics.checkNotNullParameter(r2, "view");
        super.onViewCreated(r2, r3);
        this.d.c(U90(), null);
    }

    public final View onCreateView(LayoutInflater r2, ViewGroup r3, Bundle r4) {
        Intrinsics.checkNotNullParameter(r2, "inflater");
        View r5 = th.a.c(requireContext(), 2131560852, null, false);
        View r6 = r5.findViewById(2131370872);
        if (r6 == null) goto L5;
        r6.setBackgroundColor(S90());
    L5:
        pn.b.a(this.d, V90(r5), requireContext(), this);
        return this.d.p();
    }
}
