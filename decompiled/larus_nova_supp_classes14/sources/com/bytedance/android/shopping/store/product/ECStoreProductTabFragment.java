package com.bytedance.android.shopping.store.product;

import ah.h;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import com.bytedance.android.ec.core.monitor.ECExceptionMonitor;
import com.bytedance.android.ec.core.opt.asyncInflate.ShoppingAsyncInflater;
import com.bytedance.android.ec.core.utils.s0;
import com.bytedance.android.ec.core.utils.z1;
import com.bytedance.android.ec.store.repository.vo.StoreV2ProductListResponseVO;
import com.bytedance.android.shopping.store.home.ECStoreModuleBinderFragment;
import com.bytedance.android.shopping.store.hybrid.StoreTabConfig;
import com.bytedance.android.shopping.store.hybridproduct.ECShopHybridProductViewModel;
import com.bytedance.android.shopping.store.hybridproduct.f0;
import com.bytedance.android.shopping.store.restore.g;
import com.bytedance.android.shopping.store.restore.i;
import com.bytedance.android.shopping.store.restore.l;
import com.bytedance.android.shopping.store.restore.q;
import com.bytedance.android.shopping.store.restore.r;
import com.bytedance.android.shopping.store.restore.s;
import com.bytedance.android.shopping.store.utils.m;
import com.bytedance.android.shopping.store.viewmodel.ECStoreViewModel;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.ugc.aweme.kiwi.ui.QUIManager;
import com.ss.android.ugc.aweme.kiwi.viewmodel.QViewModelOwner;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import org.greenrobot.eventbus.Subscribe;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u00012\u00020\u0002:\u0001\tB\u0007¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0007¨\u0006\n"}, d2 = {"Lcom/bytedance/android/shopping/store/product/ECStoreProductTabFragment;", "Lcom/bytedance/android/shopping/store/home/ECStoreModuleBinderFragment;", "Lcom/ss/android/ugc/aweme/kiwi/viewmodel/QViewModelOwner;", "Lah/h;", "event", "", "handleFreshEvent", "<init>", "()V", "a", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ECStoreProductTabFragment extends ECStoreModuleBinderFragment implements QViewModelOwner {
    public static final /* synthetic */ int r = 0;
    public final com.bytedance.android.ec.core.arch.viewmodel.c h;
    public final QUIManager i;
    public boolean j;
    public StoreV2ProductListResponseVO k;
    public final uj3.a l;
    public String m;
    public com.bytedance.android.shopping.store.product.a n;
    public com.bytedance.android.shopping.store.product.b o;
    public c p;
    public ViewGroup q;

    public static final class a {
    }

    public static final class b implements Runnable {
        public final /* synthetic */ ECStoreProductTabFragment a;

        public b(ECStoreProductTabFragment r1) {
            this.a = r1;
        }

        @Override // java.lang.Runnable
        public final void run() {
            ECStoreProductTabFragment r0 = this.a;     // Catch: Throwable -> L4
            int r1 = ECStoreProductTabFragment.r;     // Catch: Throwable -> L4
            r0.W90();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    static {
    }

    public final ECShopHybridProductViewModel V90() {
        return (ECShopHybridProductViewModel) this.h.getValue();
    }

    @Override // com.bytedance.android.shopping.store.home.ECStoreModuleBinderFragment
    public final void T90() {
        this.i.c(f0.class, null);
    }

    public final ViewModelProvider.Factory o6() {
        return new ViewModelProvider.NewInstanceFactory();
    }

    public ECStoreProductTabFragment() {
        Function0<ViewModelProvider.Factory> r0 = new ECStoreProductTabFragment$hybridViewModel$2(this);
        final Function0<Fragment> r1 = new ECStoreProductTabFragment$$special$$inlined$viewModels$1(this);
        this.h = com.bytedance.android.ec.core.arch.viewmodel.b.a(this, Reflection.getOrCreateKotlinClass(ECShopHybridProductViewModel.class), new ECStoreProductTabFragment$$special$$inlined$viewModels$2(r1), r0);
        this.i = new QUIManager();
        this.l = new uj3.a();
    }

    public final void W90() {
        String r0 = U90().getStoreParam().getProductTabPassThroughApi();
        if (r0 == null) goto L30;
        boolean r3 = true;
        if (r0.length() <= 0) goto L7;
        boolean r2 = true;
    L8:
        if (r2 == true) goto L11;
        r0 = null;
    L11:
        if (r0 == null) goto L30;
        JSONObject r1 = z1.g(r0);
        if (r1 == null) goto L30;
        long r5 = r1.optLong("sort_type", -1);
        int r4 = r1.optInt("pick_type", -1);
        String r8 = r1.optString("select_params");
        String r9 = r1.optString("filter_event_params");
        String r10 = r1.optString("custom_ids");
        String r6 = r1.optString("custom_id_type");
        if (r5 <= (-1)) goto L17;
        V90().refreshBySortAndSortType(Long.valueOf(r5), 0);
    L17:
        if (r4 <= (-1)) goto L20;
        V90().refreshByLiveSameTab(r4);
    L20:
        if (r8.length() > 0) goto L23;
        r3 = false;
    L23:
        if (r3 == false) goto L26;
        V90().refreshByDiscountSelect(r8, r9);
    L26:
        if (cg4.a.a(r6) == false) goto L30;
        if (cg4.a.a(r10) == false) goto L30;
        V90().refreshByCustomId(r6, r10);
        goto L30
    L7:
        r2 = false;
    L30:
        U90().getStoreParam().setProductTabPassThroughApi(null);
        if (cg4.a.a(U90().getProductTabParams()) == false) goto L34;
        U90().getSelectPanelState().c(Boolean.FALSE);
        V90().setButtonSelected(U90().getProductTabParams(), Intrinsics.areEqual(U90().getScene(), "shop_coupon_panel"));
        U90().setProductTabParams(null);
        return;
    }

    public final void onDestroy() {
        super.onDestroy();
        this.i.r(f0.class);
        com.bytedance.android.shopping.store.product.a r0 = this.n;
        if (r0 == null) goto L12;
        q r2 = U90().getPageRestoreCoordinator();
        if (r2 == null) goto L12;
        Intrinsics.checkNotNullParameter(r0, "provider");
        com.bytedance.android.shopping.store.restore.c r3 = r2.d.get(Integer.valueOf(r0.a));
        if (r3 == null) goto L12;
        if (Intrinsics.areEqual(r3, r0) == false) goto L12;
        r2.d.remove(Integer.valueOf(r0.a));
    L12:
        this.n = null;
        com.bytedance.android.shopping.store.product.b r4 = this.o;
        if (r4 == null) goto L22;
        q r5 = U90().getPageRestoreCoordinator();
        if (r5 == null) goto L22;
        Intrinsics.checkNotNullParameter(r4, "provider");
        com.bytedance.android.shopping.store.restore.a r6 = r5.f.get(Integer.valueOf(r4.a));
        if (r6 == null) goto L22;
        if (Intrinsics.areEqual(r6, r4) == false) goto L22;
        r5.f.remove(Integer.valueOf(r4.a));
    L22:
        this.o = null;
        c r7 = this.p;
        if (r7 == null) goto L32;
        q r8 = U90().getPageRestoreCoordinator();
        if (r8 == null) goto L32;
        Intrinsics.checkNotNullParameter(r7, "provider");
        com.bytedance.android.shopping.store.restore.b r1 = r8.g.get(Integer.valueOf(r7.a));
        if (r1 == null) goto L32;
        if (Intrinsics.areEqual(r1, r7) == false) goto L32;
        r8.g.remove(Integer.valueOf(r7.a));
    L32:
        this.p = null;
        String r9 = this.m;
        if (r9 == null) goto L35;
        ConcurrentHashMap<String, StoreTabConfig> r10 = m.a;
        Intrinsics.checkNotNullParameter(r9, "key");
        m.a.remove(r9);
    L35:
        s0.e(this);
    }

    @Override // com.bytedance.android.shopping.store.home.ECStoreModuleBinderFragment
    public final void onPause() {
        super.onPause();
        this.j = false;
        U90().getTabSlideCnt().put("products", Integer.valueOf(V90().getMaxDepth()));
    }

    public final void onResume() {
        super.onResume();
        this.j = true;
        W90();
    }

    @Subscribe
    public final void handleFreshEvent(h r4) {
        Intrinsics.checkNotNullParameter(r4, "event");
        dm.a.a("ShopRefreshProductEvent").a("event_id:" + r4.a);
        Integer r5 = r4.a;
        if (r5 != null) goto L6;
        return;
    L6:
        if (r5.intValue() == 3) goto L8;
        return;
    L8:
        W90();
    }

    public final void onCreate(Bundle r8) {
        super.onCreate(r8);
        if (getContext() != null) goto L6;
        ECExceptionMonitor.c("context is null when ECStoreProductTabFragment onCreate");
        return;
    L6:
        V90().setEcomEntranceFrom("products");
        Bundle r9 = getArguments();
        g r0 = null;
        if (r9 == null) goto L9;
        String r10 = r9.getString("store_tab_config_key");
    L10:
        this.m = r10;
        if (r10 == null) goto L13;
        StoreTabConfig r11 = m.a(r10);
    L14:
        int r1 = e.a;
        e.b(U90(), r11);
        e.a(U90(), V90(), r11, this.k, getContext(), getActivity());
        if (r11 == null) goto L17;
        Integer r12 = Integer.valueOf(r11.getTabType());
    L18:
        if (r12 != null) goto L20;
        return;
    L20:
        if (this.n != null) goto L40;
        com.bytedance.android.shopping.store.product.a r2 = new com.bytedance.android.shopping.store.product.a(this, r12);
        this.n = r2;
        q r3 = U90().getPageRestoreCoordinator();
        if (r3 == null) goto L40;
        Intrinsics.checkNotNullParameter(r2, "provider");
        if (r.c() == false) goto L40;
        r3.d.put(Integer.valueOf(r2.a), r2);
        com.bytedance.android.shopping.store.restore.m r4 = r3.b;
        if (r4 == null) goto L33;
        s r5 = r4.d;
        if (r5 == null) goto L33;
        Map<Integer, l> r6 = r5.h;
        if (r6 == null) goto L33;
        l r7 = r6.get(Integer.valueOf(r2.a));
    L34:
        if (r7 == null) goto L36;
        i r13 = r7.b;
    L37:
        if (r13 == null) goto L40;
        q.b("coordinator_restore_request tabId=" + r2.a);
        r2.b(r13);
        goto L40
    L36:
        r13 = null;
    L33:
        r7 = null;
    L40:
        if (this.o != null) goto L59;
        com.bytedance.android.shopping.store.product.b r14 = new com.bytedance.android.shopping.store.product.b(this, r12);
        this.o = r14;
        q r15 = U90().getPageRestoreCoordinator();
        if (r15 == null) goto L59;
        Intrinsics.checkNotNullParameter(r14, "provider");
        if (r.c() == false) goto L59;
        r15.f.put(Integer.valueOf(r14.a), r14);
        com.bytedance.android.shopping.store.restore.m r16 = r15.b;
        if (r16 == null) goto L55;
        s r17 = r16.d;
        if (r17 == null) goto L55;
        Map<Integer, l> r18 = r17.h;
        if (r18 == null) goto L55;
        l r19 = r18.get(Integer.valueOf(r14.a));
        if (r19 == null) goto L55;
        com.bytedance.android.shopping.store.restore.h r20 = r19.d;
    L56:
        if (r20 == null) goto L59;
        q.b("coordinator_restore_filterSort tabId=" + r14.a);
        r14.b(r20);
    L55:
        r20 = null;
    L59:
        if (this.p != null) goto L78;
        c r21 = new c(this, r12);
        this.p = r21;
        q r22 = U90().getPageRestoreCoordinator();
        if (r22 == null) goto L79;
        Intrinsics.checkNotNullParameter(r21, "provider");
        if (r.c() == false) goto L81;
        r22.g.put(Integer.valueOf(r21.a), r21);
        com.bytedance.android.shopping.store.restore.m r23 = r22.b;
        if (r23 == null) goto L74;
        s r24 = r23.d;
        if (r24 == null) goto L74;
        Map<Integer, l> r25 = r24.h;
        if (r25 == null) goto L74;
        l r26 = r25.get(Integer.valueOf(r21.a));
        if (r26 == null) goto L74;
        r0 = r26.e;
    L74:
        if (r0 == null) goto L80;
        q.b("coordinator_restore_middleCoupon tabId=" + r21.a);
        r21.b(r0);
        return;
    L80:
        return;
    L81:
        return;
    L79:
        return;
    L78:
        return;
    L17:
        r12 = null;
        goto L18
    L13:
        r11 = null;
        goto L14
    L9:
        r10 = null;
        goto L10
    }

    public final void setUserVisibleHint(boolean r2) {
        super.setUserVisibleHint(r2);
        if (r2 == true) goto L5;
        return;
    L5:
        if (this.j == true) goto L7;
        return;
    L7:
        if (V90().getHasBind() == false) goto L9;
        W90();
        return;
    L9:
        V90().getPendingAction().add(new b(this));
    }

    public final View onCreateView(LayoutInflater r3, ViewGroup r4, Bundle r5) {
        Intrinsics.checkNotNullParameter(r3, "inflater");
        if (this.q != null) goto L14;
        ShoppingAsyncInflater.a r6 = ShoppingAsyncInflater.e;
        Context r7 = requireContext();
        r6.getClass();
        View r8 = com.bytedance.android.ec.opt.asyncInflate.c.a(ShoppingAsyncInflater.a.a(r7), 2131564663, r4, 4);
        if (r8 == null) goto L12;
        QUIManager r9 = this.i;
        ECStoreViewModel r1 = U90();
        pn.b.a(r9, new f0(r1, (ViewGroup) r8, this), requireContext(), this);
        View r10 = this.i.p();
        if (r10 == null) goto L10;
        this.q = (ViewGroup) r10;
        goto L14
    L10:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup");
    L12:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup");
    L14:
        return this.q;
    }
}
