package com.bytedance.android.shopping.store.moments;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import com.bytedance.android.ec.core.arch.viewmodel.b;
import com.bytedance.android.ec.core.arch.viewmodel.c;
import com.bytedance.android.ec.core.opt.asyncInflate.ShoppingAsyncInflater;
import com.bytedance.android.ec.hybrid.list.view.ECHybridRecyclerView;
import com.bytedance.android.shopping.store.home.ECStoreModuleBinderFragment;
import com.bytedance.android.shopping.store.home.api.ECStoreParam;
import com.bytedance.android.shopping.store.hybrid.StoreTabConfig;
import com.bytedance.android.shopping.store.moments.dto.ECStoreMomentResponse;
import com.bytedance.android.shopping.store.moments.viewmodel.ECStoreMomentViewModel;
import com.bytedance.android.shopping.store.settings.ECShopABSettings;
import com.bytedance.android.shopping.store.utils.m;
import com.ss.android.ugc.aweme.kiwi.ui.QUIManager;
import com.ss.android.ugc.aweme.kiwi.viewmodel.QViewModelOwner;
import java.io.Serializable;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002:\u0001\u0005B\u0007¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/shopping/store/moments/ECStoreMixFragment;", "Lcom/bytedance/android/shopping/store/home/ECStoreModuleBinderFragment;", "Lcom/ss/android/ugc/aweme/kiwi/viewmodel/QViewModelOwner;", "<init>", "()V", "a", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ECStoreMixFragment extends ECStoreModuleBinderFragment implements QViewModelOwner {
    public static final /* synthetic */ int o = 0;
    public StoreTabConfig h;
    public final c i;
    public final QUIManager j;
    public View k;
    public ECStoreMomentResponse l;
    public String m;
    public ECHybridRecyclerView n;

    public static final class a {
    }

    static {
    }

    @Override // com.bytedance.android.shopping.store.home.ECStoreModuleBinderFragment
    public final void T90() {
        this.j.c(jj3.a.class, null);
    }

    public final ViewModelProvider.Factory o6() {
        return new ViewModelProvider.NewInstanceFactory();
    }

    public ECStoreMixFragment() {
        Function0<ViewModelProvider.Factory> r0 = new ECStoreMixFragment$viewModel$2(this);
        final Function0<Fragment> r1 = new ECStoreMixFragment$$special$$inlined$viewModels$1(this);
        this.i = b.a(this, Reflection.getOrCreateKotlinClass(ECStoreMomentViewModel.class), new ECStoreMixFragment$$special$$inlined$viewModels$2(r1), r0);
        this.j = new QUIManager();
    }

    public final void onDestroy() {
        super.onDestroy();
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
        ECShopABSettings.k.getClass();
        if (ECShopABSettings.i() == false) goto L8;
        ECHybridRecyclerView r0 = this.n;
        if (r0 == null) goto L9;
        r0.V();
        return;
    L9:
        return;
    }

    public final void onResume() {
        super.onResume();
        ECShopABSettings.k.getClass();
        if (ECShopABSettings.i() == true) goto L5;
        return;
    L5:
        if (isInForeground() == false) goto L11;
        ECHybridRecyclerView r0 = this.n;
        if (r0 == null) goto L12;
        r0.c0();
        return;
    L12:
        return;
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

    public final void onCreate(Bundle r4) {
        super.onCreate(r4);
        ECStoreParam r5 = U90().getStoreParam();
        Map<Long, com.bytedance.android.shopping.store.lifecycle.m> r0 = com.bytedance.android.shopping.store.lifecycle.a.a;
        com.bytedance.android.shopping.store.lifecycle.m r1 = com.bytedance.android.shopping.store.lifecycle.a.a(Long.valueOf(r5.getLifecycleMonitorId()));
        if (r1 == null) goto L5;
        r1.e(this.h);
    L5:
        Bundle r2 = getArguments();
        Object r3 = null;
        if (r2 == null) goto L8;
        String r6 = r2.getString("store_tab_config_key");
    L9:
        this.m = r6;
        if (r6 == null) goto L12;
        StoreTabConfig r7 = m.a(r6);
    L13:
        this.h = r7;
        Bundle r8 = getArguments();
        if (r8 == null) goto L16;
        Serializable r9 = r8.getSerializable("prefetch_data");
    L18:
        if ((r9 instanceof ECStoreMomentResponse) == false) goto L21;
        r3 = r9;
    L21:
        this.l = (ECStoreMomentResponse) r3;
        ((ECStoreMomentViewModel) this.i.getValue()).init(r5, this.h, this.l);
        return;
    L16:
        r9 = null;
        goto L18
    L12:
        r7 = null;
        goto L13
    L8:
        r6 = null;
        goto L9
    }

    @Override // com.bytedance.android.shopping.store.tabkit.TabKitTabFragment
    public final void onViewCreated(View r2, Bundle r3) {
        Intrinsics.checkNotNullParameter(r2, "view");
        super.onViewCreated(r2, r3);
        ECShopABSettings.k.getClass();
        if (ECShopABSettings.i() == false) goto L6;
        this.n = r2.findViewById(2131371111).getRecyclerView();
        getTabKitViewModel().getCurrentTab().observe(getViewLifecycleOwner(), new AnonymousClass1(this));
        return;
    }

    public final View onCreateView(LayoutInflater r2, ViewGroup r3, Bundle r4) {
        Intrinsics.checkNotNullParameter(r2, "inflater");
        if (this.k != null) goto L9;
        ShoppingAsyncInflater.a r5 = ShoppingAsyncInflater.e;
        Context r6 = requireContext();
        r5.getClass();
        View r7 = com.bytedance.android.ec.opt.asyncInflate.c.a(ShoppingAsyncInflater.a.a(r6), 2131560950, r3, 4);
        if (U90().isWhiteBrand() == false) goto L7;
        r7.setBackgroundColor(0);
    L7:
        jj3.a r8 = new jj3.a(U90(), r7, this, this.h);
        QUIManager r9 = this.j;
        r9.a = this;
        r9.l(r8, requireContext(), true);
        this.k = this.j.p();
    L9:
        return this.k;
    }
}
