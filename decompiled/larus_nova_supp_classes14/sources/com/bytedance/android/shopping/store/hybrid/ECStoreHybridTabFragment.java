package com.bytedance.android.shopping.store.hybrid;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ViewModelProvider;
import com.bytedance.android.ec.core.opt.asyncInflate.ShoppingAsyncInflater;
import com.bytedance.android.shopping.store.home.ECStoreModuleBinderFragment;
import com.bytedance.android.shopping.store.home.api.ECStoreParam;
import com.bytedance.android.shopping.store.home.entity.n;
import com.bytedance.android.shopping.store.hybrid.viewmodel.ECStoreHybridTabViewModel;
import com.bytedance.android.shopping.store.repository.vo.TabEnum;
import com.bytedance.android.shopping.store.settings.ECShopABSettings;
import com.bytedance.android.shopping.store.utils.m;
import com.ss.android.ugc.aweme.kiwi.ui.QUIManager;
import com.ss.android.ugc.aweme.kiwi.ui.QUIModule;
import com.ss.android.ugc.aweme.kiwi.viewmodel.QViewModelOwner;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002:\u0001\u0005B\u0007¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/shopping/store/hybrid/ECStoreHybridTabFragment;", "Lcom/bytedance/android/shopping/store/home/ECStoreModuleBinderFragment;", "Lcom/ss/android/ugc/aweme/kiwi/viewmodel/QViewModelOwner;", "<init>", "()V", "a", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ECStoreHybridTabFragment extends ECStoreModuleBinderFragment implements QViewModelOwner {
    public static final /* synthetic */ int n = 0;
    public boolean h;
    public final com.bytedance.android.ec.core.arch.viewmodel.c i;
    public final QUIManager j;
    public StoreTabConfig k;
    public ViewGroup l;
    public String m;

    public static final class a {
    }

    static {
    }

    public final ECStoreHybridTabViewModel V90() {
        return (ECStoreHybridTabViewModel) this.i.getValue();
    }

    @Override // com.bytedance.android.shopping.store.home.ECStoreModuleBinderFragment
    public final void T90() {
        this.j.c(com.bytedance.android.shopping.store.hybrid.a.class, null);
    }

    public final ViewModelProvider.Factory o6() {
        return new ViewModelProvider.NewInstanceFactory();
    }

    public ECStoreHybridTabFragment() {
        Function0<ViewModelProvider.Factory> r0 = new ECStoreHybridTabFragment$viewModel$2(this);
        final Function0<Fragment> r1 = new ECStoreHybridTabFragment$$special$$inlined$viewModels$1(this);
        this.i = com.bytedance.android.ec.core.arch.viewmodel.b.a(this, Reflection.getOrCreateKotlinClass(ECStoreHybridTabViewModel.class), new ECStoreHybridTabFragment$$special$$inlined$viewModels$2(r1), r0);
        this.j = new QUIManager();
    }

    public final void onDestroy() {
        super.onDestroy();
        this.j.r(com.bytedance.android.shopping.store.hybrid.a.class);
        String r0 = this.m;
        if (r0 == null) goto L6;
        ConcurrentHashMap<String, StoreTabConfig> r1 = m.a;
        Intrinsics.checkNotNullParameter(r0, "key");
        m.a.remove(r0);
        return;
    }

    public final void onDetach() {
        super.onDetach();
        this.h = false;
    }

    @Override // com.bytedance.android.shopping.store.home.ECStoreModuleBinderFragment
    public final void onPause() {
        super.onPause();
        if (Intrinsics.areEqual((Boolean) V90().isVisible().a(), Boolean.TRUE) == false) goto L6;
        V90().isVisible().g(Boolean.FALSE);
        return;
    }

    public final void onResume() {
        super.onResume();
        if (Intrinsics.areEqual((Boolean) V90().isVisible().a(), Boolean.FALSE) == false) goto L11;
        ECShopABSettings.k.getClass();
        if (ECShopABSettings.i() == true) goto L7;
        V90().isVisible().g(Boolean.TRUE);
        return;
    L7:
        if (isInForeground() == false) goto L12;
        V90().isVisible().g(Boolean.TRUE);
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

    public final void onAttach(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super.onAttach(r2);
        this.h = true;
    }

    public final void onCreate(Bundle r5) {
        super.onCreate(r5);
        Bundle r6 = getArguments();
        Map<String, String> r0 = null;
        if (r6 == null) goto L5;
        String r7 = r6.getString("store_tab_config_key");
    L6:
        this.m = r7;
        if (r7 == null) goto L9;
        this.k = m.a(r7);
    L9:
        ECStoreHybridTabViewModel r8 = V90();
        ECStoreParam r1 = U90().getStoreParam();
        FragmentActivity r2 = getActivity();
        if (r2 == null) goto L12;
        String r3 = hm.c.e(r2);
    L13:
        n r4 = (n) U90().getHeaderArea().getValue();
        if (r4 == null) goto L16;
        r0 = r4.k;
    L16:
        r8.init(r1, r3, r0);
        return;
    L12:
        r3 = null;
        goto L13
    L5:
        r7 = null;
        goto L6
    }

    @Deprecated(message = "Deprecated in Java")
    public final void setUserVisibleHint(boolean r3) {
        super.setUserVisibleHint(r3);
        if (this.h == true) goto L5;
        return;
    L5:
        if ((!Intrinsics.areEqual((Boolean) V90().isVisible().a(), Boolean.valueOf(r3))) == false) goto L9;
        V90().isVisible().g(Boolean.valueOf(r3));
        return;
    }

    @Override // com.bytedance.android.shopping.store.tabkit.TabKitTabFragment
    public final void onViewCreated(View r2, Bundle r3) {
        Intrinsics.checkNotNullParameter(r2, "view");
        super.onViewCreated(r2, r3);
        ECShopABSettings.k.getClass();
        if (ECShopABSettings.i() == false) goto L6;
        getTabKitViewModel().getCurrentTab().observe(getViewLifecycleOwner(), new AnonymousClass1(this));
        return;
    }

    public final View onCreateView(LayoutInflater r4, ViewGroup r5, Bundle r6) {
        Intrinsics.checkNotNullParameter(r4, "inflater");
        if (this.l != null) goto L89;
        StoreTabConfig r7 = this.k;
        QUIModule r8 = null;
        if (r7 != null) goto L7;
    L82:
        if (r8 == null) goto L89;
        pn.b.a(this.j, r8, requireContext(), this);
        View r9 = this.j.p();
        if (r9 == null) goto L87;
        this.l = (ViewGroup) r9;
        goto L89
    L87:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup");
    L7:
        if (Integer.valueOf(r7.getTabId()) == null) goto L82;
        StoreTabConfig r10 = this.k;
        if (r10 == null) goto L11;
        Integer r11 = Integer.valueOf(r10.getTabType());
    L12:
        if (r11 == null) goto L82;
        StoreTabConfig r12 = this.k;
        Intrinsics.checkNotNull(r12);
        if (r12.isDynamicTabConfig() == false) goto L17;
        Integer r13 = 2131560942;
    L58:
        if (r13 == null) goto L82;
        int r14 = r13.intValue();
        ShoppingAsyncInflater.a r0 = ShoppingAsyncInflater.e;
        Context r1 = requireContext();
        r0.getClass();
        View r15 = com.bytedance.android.ec.opt.asyncInflate.c.a(ShoppingAsyncInflater.a.a(r1), r14, r5, 4);
        Context r16 = getContext();
        boolean r2 = true;
        if (r16 == null) goto L62;
        r8 = th.a.e(r16, true);
    L62:
        if (r8 != null) goto L64;
    L73:
        if (r8 != null) goto L75;
    L81:
        Unit r17 = Unit.INSTANCE;
        StoreTabConfig r18 = this.k;
        Intrinsics.checkNotNull(r18);
        r8 = new com.bytedance.android.shopping.store.hybrid.a(r15, r18, U90());
        goto L82
    L75:
        if (U90().isWhiteBrand() == false) goto L77;
    L80:
        r15.setBackgroundColor(r8.getResources().getColor(2131106784));
        goto L81
    L77:
        if (U90().isKolShop() == true) goto L80;
        if (U90().isMiddleTabFramework() == false) goto L81;
    L64:
        if (U90().isWhiteBrand() == false) goto L66;
    L71:
        if (r2 == true) goto L73;
        r15.setBackgroundColor(r8.getResources().getColor(2131101857));
        goto L73
    L66:
        if (U90().isKolShop() == true) goto L71;
        if (U90().isMiddleTabFramework() == true) goto L71;
        r2 = false;
        goto L71
    L17:
        StoreTabConfig r19 = this.k;
        if (r19 == null) goto L20;
        Integer r20 = Integer.valueOf(r19.getTabType());
    L21:
        int r3 = TabEnum.SELECTION_TAB.getType();
        if (r20 != null) goto L25;
    L27:
        int r21 = TabEnum.BIGSALE_TAB.getType();
        if (r20 != null) goto L31;
    L33:
        int r22 = TabEnum.CATEGORY_TAB.getType();
        if (r20 != null) goto L37;
    L39:
        int r23 = TabEnum.ISV_TAB.getType();
        if (r20 != null) goto L43;
    L45:
        int r24 = TabEnum.MEMBER_TAB.getType();
        if (r20 != null) goto L49;
    L51:
        int r25 = TabEnum.ISV_PLUS_TAB.getType();
        if (r20 != null) goto L55;
    L57:
        r13 = null;
        goto L58
    L55:
        if (r20.intValue() != r25) goto L57;
    L56:
        r13 = 2131560942;
        goto L58
    L49:
        if (r20.intValue() != r24) goto L51;
    L43:
        if (r20.intValue() != r23) goto L45;
    L37:
        if (r20.intValue() != r22) goto L39;
    L31:
        if (r20.intValue() != r21) goto L33;
    L25:
        if (r20.intValue() != r3) goto L27;
    L20:
        r20 = null;
        goto L21
    L11:
        r11 = null;
    L89:
        return this.l;
    }
}
