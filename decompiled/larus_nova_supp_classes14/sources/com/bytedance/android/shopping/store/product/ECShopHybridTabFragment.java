package com.bytedance.android.shopping.store.product;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import com.bytedance.android.ec.core.opt.asyncInflate.ShoppingAsyncInflater;
import com.bytedance.android.ec.core.utils.a2;
import com.bytedance.android.ec.store.repository.vo.StoreV2ProductListResponseVO;
import com.bytedance.android.shopping.store.home.ECStoreModuleBinderFragment;
import com.bytedance.android.shopping.store.hybrid.StoreTabConfig;
import com.bytedance.android.shopping.store.hybridproduct.ECShopHybridProductViewModel;
import com.bytedance.android.shopping.store.hybridproduct.h0;
import com.bytedance.android.shopping.store.utils.m;
import com.bytedance.android.shopping.store.viewmodel.ECStoreViewModel;
import com.ss.android.ugc.aweme.kiwi.ui.QUIManager;
import com.ss.android.ugc.aweme.kiwi.viewmodel.QViewModelOwner;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002:\u0001\u0005B\u0007¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/shopping/store/product/ECShopHybridTabFragment;", "Lcom/bytedance/android/shopping/store/home/ECStoreModuleBinderFragment;", "Lcom/ss/android/ugc/aweme/kiwi/viewmodel/QViewModelOwner;", "<init>", "()V", "a", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ECShopHybridTabFragment extends ECStoreModuleBinderFragment implements QViewModelOwner {
    public static final /* synthetic */ int n = 0;
    public final com.bytedance.android.ec.core.arch.viewmodel.c h;
    public final QUIManager i;
    public boolean j;
    public StoreV2ProductListResponseVO k;
    public final uj3.a l;
    public String m;

    public static final class a {
    }

    static {
    }

    @Override // com.bytedance.android.shopping.store.home.ECStoreModuleBinderFragment
    public final void T90() {
        this.i.c(h0.class, null);
    }

    public final ViewModelProvider.Factory o6() {
        return new ViewModelProvider.NewInstanceFactory();
    }

    public ECShopHybridTabFragment() {
        Function0<ViewModelProvider.Factory> r0 = new ECShopHybridTabFragment$hybridViewModel$2(this);
        final Function0<Fragment> r1 = new ECShopHybridTabFragment$$special$$inlined$viewModels$1(this);
        this.h = com.bytedance.android.ec.core.arch.viewmodel.b.a(this, Reflection.getOrCreateKotlinClass(ECShopHybridProductViewModel.class), new ECShopHybridTabFragment$$special$$inlined$viewModels$2(r1), r0);
        this.i = new QUIManager();
        this.l = new uj3.a();
    }

    public final void onDestroy() {
        super.onDestroy();
        this.i.r(h0.class);
        String r0 = this.m;
        if (r0 == null) goto L6;
        ConcurrentHashMap<String, StoreTabConfig> r1 = m.a;
        Intrinsics.checkNotNullParameter(r0, "key");
        m.a.remove(r0);
        return;
    }

    @Override // com.bytedance.android.shopping.store.home.ECStoreModuleBinderFragment
    public final void onPause() {
        super.onPause();
        U90().getTabSlideCnt().put("products_hybrid", Integer.valueOf(((ECShopHybridProductViewModel) this.h.getValue()).getMaxDepth()));
    }

    public final void onResume() {
        super.onResume();
    }

    public final void onActivityCreated(Bundle r3) {
        super.onActivityCreated(r3);
        Bundle r4 = getArguments();
        if (r4 != null) goto L5;
    L6:
        bindModule();
        return;
    L5:
        if (r4.getBoolean("auto_bind_module", true) == true) goto L6;
    }

    public final void onCreate(Bundle r8) {
        super.onCreate(r8);
        if (getContext() != null) goto L5;
        return;
    L5:
        Bundle r9 = getArguments();
        StoreTabConfig r0 = null;
        if (r9 == null) goto L8;
        String r10 = r9.getString("ecom_entrance_form");
    L10:
        if (a2.b(r10) == true) goto L13;
        r10 = null;
    L13:
        if (r10 == null) goto L15;
        ((ECShopHybridProductViewModel) this.h.getValue()).setEcomEntranceFrom(r10);
    L15:
        Bundle r11 = getArguments();
        if (r11 == null) goto L18;
        String r12 = r11.getString("store_tab_config_key");
    L19:
        this.m = r12;
        if (r12 == null) goto L22;
        r0 = m.a(r12);
    L22:
        StoreTabConfig r3 = r0;
        int r13 = e.a;
        e.b(U90(), r3);
        e.a(U90(), (ECShopHybridProductViewModel) this.h.getValue(), r3, this.k, getContext(), getActivity());
        return;
    L18:
        r12 = null;
        goto L19
    L8:
        r10 = null;
        goto L10
    }

    public final View onCreateView(LayoutInflater r2, ViewGroup r3, Bundle r4) {
        Intrinsics.checkNotNullParameter(r2, "inflater");
        if (this.j == true) goto L10;
        ShoppingAsyncInflater.a r5 = ShoppingAsyncInflater.e;
        Context r6 = requireContext();
        r5.getClass();
        View r7 = com.bytedance.android.ec.opt.asyncInflate.c.a(ShoppingAsyncInflater.a.a(r6), 2131564663, r3, 4);
        if (r7 == null) goto L8;
        QUIManager r8 = this.i;
        ECStoreViewModel r0 = U90();
        pn.b.a(r8, new h0(r0, (ViewGroup) r7, this), requireContext(), this);
        this.j = true;
        goto L10
    L8:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup");
    L10:
        return this.i.p();
    }
}
