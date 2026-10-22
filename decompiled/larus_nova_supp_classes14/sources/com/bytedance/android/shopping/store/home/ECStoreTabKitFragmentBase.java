package com.bytedance.android.shopping.store.home;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.view.WindowManager;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ViewModelProvider;
import com.bytedance.android.btm.api.BtmSDK;
import com.bytedance.android.ec.adapter.api.IAdapterService;
import com.bytedance.android.ec.base.api.ai.IECAIHostService;
import com.bytedance.android.ec.common.api.IECPendantStateService;
import com.bytedance.android.ec.host.api.service.IECHostService;
import com.bytedance.android.ec.sdk.ECSdk;
import com.bytedance.android.ec.sdk.helper.ECAppInfoService;
import com.bytedance.android.shopping.store.arch.ECStoreActivity;
import com.bytedance.android.shopping.store.home.entity.ECShopHeadInfoBlock;
import com.bytedance.android.shopping.store.home.entity.ECStoreHomeTabResponseTabkit;
import com.bytedance.android.shopping.store.home.preload.data.ECStoreDataFutureManager;
import com.bytedance.android.shopping.store.lifecycle.ShopEventListenCenter;
import com.bytedance.android.shopping.store.tabkit.TabKitFragment;
import com.bytedance.android.shopping.store.tabkit.TabKitPresenter;
import com.bytedance.android.shopping.store.viewmodel.ECStoreViewModel;
import com.bytedance.awemeopen.apps.framework.comment.api.root.CommentScene;
import com.ss.android.ugc.aweme.kiwi.ui.QUIManager;
import java.lang.ref.WeakReference;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b&\u0018\u00002\u00020\u0001:\u0001\u0004B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/shopping/store/home/ECStoreTabKitFragmentBase;", "Lcom/bytedance/android/shopping/store/tabkit/TabKitFragment;", "<init>", "()V", "a", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public abstract class ECStoreTabKitFragmentBase extends TabKitFragment {
    public static WeakReference<Function2<String, WindowManager, Unit>> o;
    public static WeakReference<Function1<String, Unit>> p;
    public final com.bytedance.android.ec.core.arch.viewmodel.c i;
    public final TabKitPresenter j;
    public Uri k;
    public final QUIManager l;
    public boolean m;
    public boolean n;

    public static final class a {
    }

    public static final class b extends com.bytedance.android.ec.core.event.a {
        public final /* synthetic */ boolean a;

        public final void buildParams() {
            if (this.a == false) goto L5;
            String r0 = CommentScene.COMMENTSCENE_NO_AWEME;
        L6:
            com.bytedance.android.ec.core.event.a.b.a.getClass();
            appendParam("live_plugin_has_init", r0, com.bytedance.android.ec.core.event.a.b.a.a);
            return;
        L5:
            r0 = "0";
            goto L6
        }

        public b(boolean r1) {
            this.a = r1;
            super("saas_store_create_event");
        }
    }

    static {
    }

    public final ECStoreViewModel V90() {
        return (ECStoreViewModel) this.i.getValue();
    }

    public static boolean W90() {
        int r0 = ECSdk.a;
        IECHostService r1 = (IECHostService) ECSdk.a(IECHostService.class);
        if (r1 == null) goto L5;
        IECAIHostService r2 = r1.getECHostAIService();
    L6:
        if (r2 != null) goto L8;
    L12:
        return false;
    L8:
        if (r2.isInAppletAnim() != true) goto L12;
        if (r2.isLandingPage() == false) goto L12;
        return true;
    L5:
        r2 = null;
        goto L6
    }

    public final boolean T90() {
        Lazy r0 = ECAppInfoService.a;
        if (we.a.a == true) goto L5;
        return true;
    L5:
        int r1 = ECSdk.a;
        IAdapterService r2 = (IAdapterService) ECSdk.a(IAdapterService.class);
        if (r2 != null) goto L8;
    L10:
        boolean r3 = false;
    L11:
        new b(r3).post(null, null);
        if (r3 == true) goto L15;
        super.onCreate(null);
        finish();
        return false;
    L15:
        return true;
    L8:
        if (r2.isLiveServiceReady() != true) goto L10;
        r3 = true;
        goto L11
    }

    @Override // com.bytedance.android.shopping.store.tabkit.TabKitFragment
    public final ViewModelProvider.Factory o6() {
        return new ViewModelProvider.NewInstanceFactory();
    }

    public ECStoreTabKitFragmentBase() {
        Function0<ViewModelProvider.Factory> r0 = new ECStoreTabKitFragmentBase$viewModel$2(this);
        final Function0<Fragment> r1 = new ECStoreTabKitFragmentBase$$special$$inlined$viewModels$1(this);
        this.i = com.bytedance.android.ec.core.arch.viewmodel.b.a(this, Reflection.getOrCreateKotlinClass(ECStoreViewModel.class), new ECStoreTabKitFragmentBase$$special$$inlined$viewModels$2(r1), r0);
        this.j = new TabKitPresenter(this);
        this.l = new QUIManager();
    }

    @Override // com.bytedance.android.shopping.store.tabkit.TabKitFragment
    public final void S90() {
        if (V90().getCurrentTabIsLive() == false) goto L7;
        V90().getLiveTabBackPress().setValue(Unit.INSTANCE);
        return;
    L7:
        if (V90().isCroppedStyle() == false) goto L9;
        super.S90();
        return;
    L9:
        if (this.n == true) goto L14;
        int r0 = com.bytedance.android.shopping.store.utils.b0.a;
        if (com.bytedance.android.shopping.store.utils.b0.a(V90(), requireContext(), "slide") == true) goto L14;
        this.n = true;
        return;
    L14:
        int r1 = com.bytedance.android.ec.store.utils.h.a;
        com.bytedance.android.ec.store.utils.h.d(V90().getEntranceInfoJsonObject(), "click_return", "shop", V90().getAdParams(), "shop_window_ad");
        V90().getLiveManager().b();
        ECStoreViewModel r2 = V90();
        Pair<String, String>[] r3 = new Pair[4];
        r3[0] = TuplesKt.to("close_method", "slide");
        r3[1] = TuplesKt.to("btm_id", "a1.b6269.c0.d0");
        r3[2] = TuplesKt.to("duration", String.valueOf(System.currentTimeMillis() - V90().getStartTime()));
        if (Intrinsics.areEqual((Boolean) V90().isBrandShop().getValue(), Boolean.TRUE) == false) goto L17;
        String r4 = "brand";
    L18:
        r3[3] = TuplesKt.to("shop_version", r4);
        r2.doEventAction("close_store_page", r3);
        super.S90();
        return;
    L17:
        r4 = "0";
        goto L18
    }

    @Override // com.bytedance.android.shopping.store.tabkit.TabKitFragment, com.bytedance.android.shopping.store.tabkit.f
    public final void finish() {
        if ((getActivity() instanceof ECStoreActivity) == false) goto L7;
        FragmentActivity r0 = getActivity();
        if (r0 == null) goto L9;
        r0.finish();
        return;
    L9:
        return;
    L7:
        super.finish();
    }

    @Override // com.bytedance.android.shopping.store.tabkit.TabKitFragment
    public void onDestroy() {
        super.onDestroy();
        Lazy r0 = ECStoreDataFutureManager.g;
        ECStoreDataFutureManager r1 = ECStoreDataFutureManager.a.a();
        io.reactivex.internal.observers.h<ECShopHeadInfoBlock> r2 = r1.c;
        if (r2 == null) goto L5;
        r2.cancel(true);
    L5:
        r1.c = null;
        io.reactivex.internal.observers.h<ECStoreHomeTabResponseTabkit> r3 = r1.e;
        if (r3 == null) goto L8;
        r3.cancel(true);
    L8:
        r1.e = null;
        io.reactivex.internal.observers.h<com.bytedance.android.chunkstreamprediction.network.b<ECStoreHomeTabResponseTabkit>> r4 = r1.f;
        if (r4 == null) goto L11;
        r4.cancel(true);
    L11:
        r1.f = null;
        if (getContext() == null) goto L18;
        int r5 = ECSdk.a;
        IECPendantStateService r6 = (IECPendantStateService) ECSdk.a(IECPendantStateService.class);
        if (r6 == null) goto L18;
        cf.f r7 = r6.getPendantStateListener("XiguaPendant");
        if (r7 == null) goto L18;
        V90().getStoreParam().getStoreAccountParam().getUserId();
        r7.onDestroy();
    L18:
        FragmentActivity r8 = requireActivity();
        if (this.m == true) goto L26;
        if (V90().isCroppedStyle() == true) goto L26;
        if (W90() == true) goto L26;
        r8.overridePendingTransition(0, 2130772248);
    L26:
        if (r8.isTaskRoot() == true) goto L28;
    L30:
        hm.a.a.remove(Integer.valueOf(r8.hashCode()));
        hm.a.b.remove(Integer.valueOf(r8.hashCode()));
        if (V90().getStoreParam().getNeedShowMallBackView() == false) goto L37;
        WeakReference<Function1<String, Unit>> r9 = p;
        if (r9 == null) goto L37;
        Function1<String, Unit> r10 = r9.get();
        if (r10 == null) goto L37;
        Unit r11 = (Unit) r10.invoke("topTabMall");
    L37:
        ShopEventListenCenter.b.onDestroy();
        return;
    L28:
        if (V90().getStoreParam().isCroppedStyle() == true) goto L30;
        com.bytedance.android.ec.sdk.helper.p.a.c(r8);
        goto L30
    }

    public final void onDestroyView() {
        super.onDestroyView();
        this.l.r(com.bytedance.android.shopping.store.home.module.k.class);
    }

    public void onPause() {
        super.onPause();
        if (getContext() == null) goto L10;
        int r0 = ECSdk.a;
        IECPendantStateService r1 = (IECPendantStateService) ECSdk.a(IECPendantStateService.class);
        if (r1 == null) goto L11;
        cf.f r2 = r1.getPendantStateListener("XiguaPendant");
        if (r2 == null) goto L12;
        V90().getStoreParam().getStoreAccountParam().getUserId();
        r2.onHide();
        return;
    L12:
        return;
    L11:
        return;
    }

    public final void onResume() {
        super.onResume();
        if (com.bytedance.android.shopping.extensions.k.c(V90().getStoreParam().getStoreAccountParam().getUserId()) == true) goto L5;
    L11:
        String r0 = V90().getActivitySceneFroRedPack();
        if (r0 == null) goto L15;
        V90().fetchActivityData(r0);
        return;
    L15:
        return;
    L5:
        if (getContext() == null) goto L11;
        int r1 = ECSdk.a;
        IECPendantStateService r2 = (IECPendantStateService) ECSdk.a(IECPendantStateService.class);
        if (r2 == null) goto L11;
        cf.f r3 = r2.getPendantStateListener("XiguaPendant");
        if (r3 == null) goto L11;
        V90().getStoreParam().getStoreAccountParam().getUserId();
        r3.onShow();
        goto L11
    }

    @Override // com.bytedance.android.shopping.store.tabkit.TabKitFragment, com.bytedance.android.shopping.store.tabkit.f
    public final TabKitPresenter Mc() {
        return this.j;
    }

    public static String U90(kc.a.a r1) {
        if (BtmSDK.INSTANCE.removeBcmChainPageId() == false) goto L6;
        return cd.a.b(r1.c);
    L6:
        return r1.b;
    }

    @Override // com.bytedance.android.shopping.store.tabkit.TabKitFragment
    public final void onAttach(Context r3) {
        Intrinsics.checkNotNullParameter(r3, "context");
        super.onAttach(r3);
        ConcurrentHashMap r4 = hm.a.a;
        FragmentActivity r5 = getActivity();
        Bundle r0 = getArguments();
        if (r0 == null) goto L5;
        String r1 = r0.getString("entrance_info");
    L6:
        JSONObject r2 = com.bytedance.android.shopping.extensions.k.w(r1);
        if (r2 == null) goto L13;
        if (r5 == null) goto L14;
        hm.a.a.put(Integer.valueOf(r5.hashCode()), r2);
        return;
    L14:
        return;
    L13:
        return;
    L5:
        r1 = null;
        goto L6
    }
}
