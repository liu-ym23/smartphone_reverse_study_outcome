package com.bytedance.android.shopping.store.home;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.FrameLayout;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import com.bytedance.android.bcm.api.model.BcmParams;
import com.bytedance.android.btm.api.BtmSDK;
import com.bytedance.android.btm.api.BtmSDKWrapper;
import com.bytedance.android.btm.api.model.PageFinder;
import com.bytedance.android.ec.common.api.IECPendantStateService;
import com.bytedance.android.ec.common.api.feedback.IECFeedbackService;
import com.bytedance.android.ec.core.opt.asyncInflate.ShoppingAsyncInflater;
import com.bytedance.android.ec.core.utils.j2;
import com.bytedance.android.ec.hybrid.list.entity.ECHybridListItemVO;
import com.bytedance.android.ec.sdk.ECSdk;
import com.bytedance.android.ec.store.view.ECShopRootFrameLayout;
import com.bytedance.android.shopping.store.arch.ECStoreActivity;
import com.bytedance.android.shopping.store.arch.ECStoreFoldPhoneHelper;
import com.bytedance.android.shopping.store.arch.FoldAdaptedFrameLayout;
import com.bytedance.android.shopping.store.home.api.ECStoreParam;
import com.bytedance.android.shopping.store.home.entity.ECStoreHomeTabResponseTabkit;
import com.bytedance.android.shopping.store.home.entity.ECStoreTabAreaVO;
import com.bytedance.android.shopping.store.home.entity.StoreSizeConfig;
import com.bytedance.android.shopping.store.home.event.ChangeStateType;
import com.bytedance.android.shopping.store.home.frame.container.ShopContainerType;
import com.bytedance.android.shopping.store.home.preload.resource.ECStoreResourcePreloadManager;
import com.bytedance.android.shopping.store.home.preload.resource.PageType;
import com.bytedance.android.shopping.store.home.presenter.c4;
import com.bytedance.android.shopping.store.home.presenter.f4;
import com.bytedance.android.shopping.store.lifecycle.ECStorePerfMonitor;
import com.bytedance.android.shopping.store.lifecycle.ShopEventListenCenter;
import com.bytedance.android.shopping.store.settings.ECShopABSettings;
import com.bytedance.android.shopping.store.tabkit.container.TabKitBottomSheetFragment;
import com.bytedance.android.shopping.store.tabkit.router.TabKitRouterParams;
import com.bytedance.android.shopping.store.viewmodel.ECStoreViewModel;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.apm.impl.protector.RunnableProtector;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import com.ss.android.ugc.aweme.kiwi.ui.QUIManager;
import java.io.Serializable;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0016\u0018\u00002\u00020\u0001:\u0001\u0004B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/shopping/store/home/ECStoreTabKitFragment;", "Lcom/bytedance/android/shopping/store/home/ECStoreTabKitFragmentBase;", "<init>", "()V", "a", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public class ECStoreTabKitFragment extends ECStoreTabKitFragmentBase {
    public static final a s = null;
    public final Lazy q;
    public final Lazy r;

    public static final class a {
        public a() {
        }

        public static Bundle a(ECStoreParam r4, Uri r5) {
            TabKitRouterParams r0 = new TabKitRouterParams();
            if (r4.isCroppedStyle() == false) goto L5;
            r0.getParamsMap().put("page_modal", String.valueOf(1));
            r0.getParamsMap().put("init_screen_status", String.valueOf(3));
        L6:
            Bundle r1 = new Bundle();
            r1.putSerializable("store_param", r4);
            r1.putSerializable("entrance_info", r4.getEntranceInfo());
            r1.putSerializable("schema", String.valueOf(r5));
            r1.putSerializable(TabKitRouterParams.KEY_ROUTER_PARAMS, r0);
            r1.putString("ec_store_instance_id", UUID.randomUUID().toString());
            return r1;
        L5:
            r0.getParamsMap().put("page_modal", String.valueOf(0));
            goto L6
        }

        public static void b(Context r5, ECStoreParam r6, Uri r7) {
            Intrinsics.checkNotNullParameter(r5, "context");
            Intrinsics.checkNotNullParameter(r6, "storeParam");
            Bundle r8 = a(r6, r7);
            boolean r2 = true;
            r8.putBoolean("is_store", true);
            int r1 = ECStorePerfMonitor.n;
            ECStorePerfMonitor r9 = ECStorePerfMonitor.a.a(Long.valueOf(r6.getLifecycleMonitorId()));
            if (r9 == null) goto L7;
            com.bytedance.android.shopping.store.lifecycle.g r10 = r9.k;
            if (r10 == null) goto L7;
            int r3 = com.bytedance.android.shopping.store.lifecycle.g.e;
            r10.c(2, null);
        L7:
            Serializable r4 = r8.getSerializable(TabKitRouterParams.KEY_ROUTER_PARAMS);
            if ((r4 instanceof TabKitRouterParams) == true) goto L10;
            r4 = null;
        L10:
            TabKitRouterParams r11 = (TabKitRouterParams) r4;
            if (r11 == null) goto L13;
            Integer r12 = r11.getPageModal();
        L14:
            if (r12 != null) goto L17;
        L32:
            int r13 = ECStoreActivity.e;
            Intrinsics.checkNotNullParameter(r5, "context");
            Intrinsics.checkNotNullParameter(ECStoreTabKitFragment.class, "tabKitFragmentClazz");
            String r14 = r8.getString("ec_store_instance_id");
            if (r14 != null) goto L35;
        L38:
            if (r2 == false) goto L40;
            r8.putString("ec_store_instance_id", UUID.randomUUID().toString());
        L40:
            String r15 = r8.getString("ec_store_instance_id");
            Intent r16 = new Intent(r5, ECStoreActivity.class);
            r16.putExtra("tabkit_fragment_clazz", ECStoreTabKitFragment.class);
            r16.putExtra("biz_arguments", r8);
            r16.putExtra("ec_store_instance_id", r15);
            Unit r17 = Unit.INSTANCE;
            r5.startActivity(r16);
            return;
        L35:
            if (StringsKt.isBlank(r14) == true) goto L38;
            r2 = false;
            goto L38
        L17:
            if (r12.intValue() != 1) goto L32;
            if ((r5 instanceof FragmentActivity) == true) goto L21;
            r5 = null;
        L21:
            FragmentActivity r18 = (FragmentActivity) r5;
            if (r18 == null) goto L48;
            FragmentManager r19 = r18.getSupportFragmentManager();
            if (r19 == null) goto L49;
            int r0 = TabKitBottomSheetFragment.p;     // Catch: Exception -> L43
            TabKitBottomSheetFragment r20 = TabKitBottomSheetFragment.a.a(ECStoreTabKitFragment.class, r8);     // Catch: Exception -> L43
            LandscapeRestrictionOperation r21 = LandscapeRestrictionOperation.DIALOG_FRAGMENT_SHOW;     // Catch: Exception -> L43
            LandscapeRestrictionGuard.markDialogFragmentIfAllowed(r20, "tabkit_bottom_sheet_fragment", r21);     // Catch: Exception -> L43
            if (LandscapeRestrictionGuard.shouldBlockDialogFragmentShow(r19, r20, r21) == true) goto L50;
            DialogFragmentLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L42
        L30:
            r20.show(r19, "tabkit_bottom_sheet_fragment");     // Catch: Exception -> L43
            return;
        L50:
            return;
        L52:
            return;
        L49:
            return;
        L48:
            return;
        L13:
            r12 = null;
            goto L14
        }
    }

    public static final class b implements Runnable {
        public final /* synthetic */ ECStoreTabKitFragment a;

        public b(ECStoreTabKitFragment r1) {
            this.a = r1;
        }

        @Override // java.lang.Runnable
        public final void run() {
        L6:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L13;
            throw th;
        L13:
            return;
        L3:
            if (Intrinsics.areEqual((Boolean) this.a.V90().getRestoreCoverVisible().getValue(), Boolean.TRUE) == false) goto L9;
            this.a.V90().getRestoreCoverVisible().setValue(Boolean.FALSE);     // Catch: Throwable -> L6
            return;
        }
    }

    public static final class c<T> implements Observer {
        public final /* synthetic */ ECStoreTabKitFragment a;

        public c(ECStoreTabKitFragment r1) {
            this.a = r1;
        }

        public final void onChanged(Object r6) {
            com.bytedance.android.shopping.store.home.entity.n r7 = (com.bytedance.android.shopping.store.home.entity.n) r6;
            Map r8 = MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("shop_id", this.a.V90().getStoreParam().getShopId())});
            String r0 = this.a.V90().getStoreParam().getBcm();
            if (r0 == null) goto L7;
            JSONObject r1 = com.bytedance.android.shopping.extensions.k.w(r0);
            if (r1 == null) goto L7;
            Object r2 = r1.opt("bcm_share_id");
        L8:
            if (r2 == null) goto L10;
            r8.put("bcm_share_id", r2.toString());
        L10:
            View r3 = this.a.l.p();
            Intrinsics.checkNotNullParameter(r3, "view");
            Intrinsics.checkNotNullParameter("page_show", "bcmEventName");
            Intrinsics.checkNotNullParameter(r8, "params");
            BcmParams r4 = new BcmParams();
            Iterator r9 = r8.entrySet().iterator();
        L12:
            if (r9.hasNext() == false) goto L14;
            Map.Entry r5 = (Map.Entry) r9.next();
            r4.put((String) r5.getKey(), r5.getValue());
            goto L12
        L14:
            com.bytedance.android.bcm.api.b.e(PageFinder.via(r3), "page_show", r4);
            if (com.bytedance.android.shopping.extensions.k.c(this.a.V90().getStoreParam().getStoreAccountParam().getUserId()) == true) goto L17;
            return;
        L17:
            if (this.a.getContext() == null) goto L26;
            int r10 = ECSdk.a;
            IECPendantStateService r11 = (IECPendantStateService) ECSdk.a(IECPendantStateService.class);
            if (r11 == null) goto L27;
            cf.f r12 = r11.getPendantStateListener("XiguaPendant");
            if (r12 == null) goto L28;
            this.a.V90().getStoreParam().getStoreAccountParam().getUserId();
            r12.onShow();
            return;
        L28:
            return;
        L27:
            return;
        L26:
            return;
        L7:
            r2 = null;
            goto L8
        }
    }

    public static final class d implements Runnable {
        public static final d a = null;

        static {
            a = new d();
        }

        public d() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            WeakReference<Function2<String, WindowManager, Unit>> r0 = ECStoreTabKitFragmentBase.o;     // Catch: Throwable -> L8
            if (r0 == null) goto L11;
            Function2<String, WindowManager, Unit> r1 = r0.get();     // Catch: Throwable -> L8
            if (r1 == null) goto L15;
            Unit r2 = (Unit) r1.invoke("topTabMall", null);     // Catch: Throwable -> L8
            return;
        L15:
            return;
        L11:
            return;
        L8:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L16;
            throw th;
        }
    }

    static {
        s = new a();
        Lazy r0 = BtmSDKWrapper.a;
        BtmSDKWrapper.c(ECStoreTabKitFragment.class, "a1.b6269");
    }

    public final void onStop() {
        if (((Boolean) this.q.getValue()).booleanValue() == true) goto L151;
        FragmentActivity r1 = getActivity();
        boolean r2 = true;
        if (r1 != null) goto L7;
    L8:
        dm.a.a("ec_shop_restore").a("store_onStop_save secShopId=" + V90().getStoreParam().getSecShopId() + " lmId=" + V90().getStoreParam().getLifecycleMonitorId());
        com.bytedance.android.shopping.store.restore.q r3 = V90().getPageRestoreCoordinator();
        if (r3 == null) goto L151;
        ECStoreViewModel r4 = V90();
        Intrinsics.checkNotNullParameter(r4, "viewModel");
        com.bytedance.android.shopping.store.restore.n r5 = r3.a;
        if (r5 == null) goto L151;
        if (com.bytedance.android.shopping.store.restore.r.a() == false) goto L151;
        Float r6 = (Float) r4.getUpglideFactor().getValue();
        if (r6 == null) goto L19;
        float r7 = r6.floatValue();
    L21:
        if (r7 < 1.0f) goto L23;
        int r8 = 1;
    L24:
        Pair r9 = (Pair) r4.getSelectedTabLocation().getValue();
        if (r9 == null) goto L27;
        Integer r10 = (Integer) r9.getFirst();
    L28:
        if (r10 != null) goto L30;
    L63:
        uj3.j r11 = r4.getCurrentTab();
        if (r11 == null) goto L67;
        Integer r12 = Integer.valueOf(r11.d);
    L66:
        Integer r13 = r12;
    L68:
        Pair r14 = (Pair) r4.getSelectedTabLocation().getValue();
        if (r14 != null) goto L71;
    L81:
        com.bytedance.android.shopping.store.restore.u r15 = new com.bytedance.android.shopping.store.restore.u(r13, null, null, (Integer) r4.getCroppedState().getValue(), Integer.valueOf(r8));
    L82:
        com.bytedance.android.shopping.store.restore.u r16 = r15;
        long r17 = System.currentTimeMillis();
        com.bytedance.android.shopping.store.restore.v r18 = new com.bytedance.android.shopping.store.restore.v((Boolean) r4.getHeaderAreaStartScrollTag().getValue());
        com.bytedance.android.shopping.store.home.entity.n r19 = (com.bytedance.android.shopping.store.home.entity.n) r4.getHeaderArea().getValue();
        ECStoreTabAreaVO r110 = (ECStoreTabAreaVO) r4.getTabArea().getValue();
        if (com.bytedance.android.shopping.store.restore.r.c() == true) goto L86;
        Map r20 = MapsKt.emptyMap();
    L85:
        com.bytedance.android.shopping.store.restore.q r24 = r3;
        com.bytedance.android.shopping.store.restore.s r21 = new com.bytedance.android.shopping.store.restore.s(r5, r17, r16, r18, r19, r110, r20);
        if (com.bytedance.android.shopping.store.restore.r.b() == false) goto L150;
        LinkedHashMap r0 = new LinkedHashMap();
        Iterator<Map.Entry<Integer, com.bytedance.android.shopping.store.restore.k>> r22 = r24.e.entrySet().iterator();
    L123:
        if (r22.hasNext() == false) goto L147;
        com.bytedance.android.shopping.store.restore.k r23 = r22.next().getValue();
        com.bytedance.android.shopping.store.restore.j r25 = r23.a();
        if (r25 == null) goto L123;
        com.bytedance.android.ec.hybrid.list.entity.k r26 = r25.a;
        if (r26 == null) goto L123;
        Integer r27 = Integer.valueOf(r23.getTabType());
        Intrinsics.checkNotNullParameter(r26, "$this$detachSortCallbacks");
        com.bytedance.android.ec.hybrid.list.entity.k r28 = r26.a();
        ArrayList r29 = r28.c;
        if (r29 == null) goto L145;
        Iterator r30 = r29.iterator();
    L133:
        if (r30.hasNext() == false) goto L145;
        ArrayList r31 = ((com.bytedance.android.ec.hybrid.list.entity.i) r30.next()).i;
        if (r31 == null) goto L133;
        Iterator r32 = r31.iterator();
    L138:
        if (r32.hasNext() == false) goto L133;
        ECHybridListItemVO r33 = (ECHybridListItemVO) r32.next();
        Object r111 = r33.d();
        if ((r111 instanceof ej3.f) == true) goto L142;
        r111 = null;
    L142:
        ej3.f r112 = (ej3.f) r111;
        if (r112 == null) goto L138;
        r33.o(com.bytedance.android.shopping.store.restore.t.a(r112));
    L145:
        r0.put(r27, r28);
        goto L123
    L147:
        if (r0.isEmpty() == true) goto L150;
        com.bytedance.android.shopping.store.restore.d r34 = r24.h;
        com.bytedance.android.shopping.store.restore.n r35 = r21.a;
        long r113 = System.currentTimeMillis();
        int r36 = com.bytedance.android.shopping.store.restore.r.a;
        r34.b(new com.bytedance.android.shopping.store.restore.m(r35, r113, r21, r0));
    L150:
        com.bytedance.android.shopping.store.restore.q.b("coordinator_save key=" + r5 + " productTabs=" + r21.h.keySet() + " fullEnabled=" + com.bytedance.android.shopping.store.restore.r.b());
        goto L151
    L86:
        r20 = new LinkedHashMap();
        LinkedHashMap r37 = new LinkedHashMap();
        Iterator<Map.Entry<Integer, com.bytedance.android.shopping.store.restore.c>> r38 = r3.d.entrySet().iterator();
    L88:
        if (r38.hasNext() == false) goto L92;
        com.bytedance.android.shopping.store.restore.c r114 = r38.next().getValue();
        com.bytedance.android.shopping.store.restore.i r115 = r114.a();
        if (r115 == null) goto L88;
        r37.put(Integer.valueOf(r114.getTabType()), r115);
        goto L88
    L92:
        LinkedHashMap r39 = new LinkedHashMap();
        Iterator<Map.Entry<Integer, com.bytedance.android.shopping.store.restore.k>> r116 = r3.e.entrySet().iterator();
    L94:
        if (r116.hasNext() == false) goto L100;
        com.bytedance.android.shopping.store.restore.k r117 = r116.next().getValue();
        com.bytedance.android.shopping.store.restore.j r118 = r117.a();
        if (r118 == null) goto L94;
        com.bytedance.android.shopping.store.restore.f r119 = r118.b;
        if (r119 == null) goto L94;
        r39.put(Integer.valueOf(r117.getTabType()), r119);
        goto L94
    L100:
        LinkedHashMap r120 = new LinkedHashMap();
        Iterator<Map.Entry<Integer, com.bytedance.android.shopping.store.restore.a>> r121 = r3.f.entrySet().iterator();
    L102:
        if (r121.hasNext() == false) goto L107;
        com.bytedance.android.shopping.store.restore.a r122 = r121.next().getValue();
        com.bytedance.android.shopping.store.restore.h r40 = r122.a();
        if (r40 == null) goto L102;
        r120.put(Integer.valueOf(r122.getTabType()), r40);
        goto L102
    L107:
        LinkedHashMap r41 = new LinkedHashMap();
        Iterator<Map.Entry<Integer, com.bytedance.android.shopping.store.restore.b>> r123 = r3.g.entrySet().iterator();
    L109:
        if (r123.hasNext() == false) goto L114;
        com.bytedance.android.shopping.store.restore.b r124 = r123.next().getValue();
        Iterator<Map.Entry<Integer, com.bytedance.android.shopping.store.restore.b>> r125 = r123;
        com.bytedance.android.shopping.store.restore.g r126 = r124.a();
        if (r126 == null) goto L113;
        r41.put(Integer.valueOf(r124.getTabType()), r126);
    L113:
        r123 = r125;
        goto L109
    L114:
        Iterator r127 = CollectionsKt.union(CollectionsKt.union(CollectionsKt.union(r37.keySet(), r39.keySet()), r120.keySet()), r41.keySet()).iterator();
    L116:
        if (r127.hasNext() == false) goto L85;
        int r128 = ((Number) r127.next()).intValue();
        r20.put(Integer.valueOf(r128), new com.bytedance.android.shopping.store.restore.l(r128, (com.bytedance.android.shopping.store.restore.i) r37.get(Integer.valueOf(r128)), (com.bytedance.android.shopping.store.restore.f) r39.get(Integer.valueOf(r128)), (com.bytedance.android.shopping.store.restore.h) r120.get(Integer.valueOf(r128)), (com.bytedance.android.shopping.store.restore.g) r41.get(Integer.valueOf(r128))));
        r127 = r127;
        r3 = r3;
        goto L116
    L71:
        if (((Number) r14.getFirst()).intValue() >= 0) goto L73;
    L75:
        r2 = false;
    L76:
        if (r2 == true) goto L79;
        r14 = null;
    L79:
        if (r14 == null) goto L81;
        r15 = new com.bytedance.android.shopping.store.restore.u(r13, (Integer) r14.getFirst(), (Integer) r14.getSecond(), (Integer) r4.getCroppedState().getValue(), Integer.valueOf(r8));
        goto L82
    L73:
        if (((Number) r14.getSecond()).intValue() < 0) goto L75;
    L67:
        r13 = null;
        goto L68
    L30:
        if (r10.intValue() < 0) goto L63;
        ECStoreTabAreaVO r42 = (ECStoreTabAreaVO) r4.getTabArea().getValue();
        if (r42 == null) goto L39;
        ECStoreHomeTabResponseTabkit r43 = r42.a;
        if (r43 == null) goto L39;
        com.bytedance.android.shopping.store.tabkit.model.z r44 = r43.getTabkitResponse();
        if (r44 == null) goto L39;
        List<com.bytedance.android.shopping.store.tabkit.model.k> r45 = r44.j();
    L40:
        if (r45 == null) goto L42;
        com.bytedance.android.shopping.store.tabkit.model.k r46 = (com.bytedance.android.shopping.store.tabkit.model.k) CollectionsKt.getOrNull(r45, r10.intValue());
    L43:
        if (r46 != null) goto L48;
        uj3.j r47 = r4.getCurrentTab();
        if (r47 == null) goto L67;
        r12 = Integer.valueOf(r47.d);
        goto L66
    L48:
        if (r46.g() == true) goto L50;
        r12 = r46.n();
        goto L66
    L50:
        int r48 = ((Number) r9.getSecond()).intValue();
        List<com.bytedance.android.shopping.store.tabkit.model.k> r49 = r46.m();
        if (r49 == null) goto L53;
        com.bytedance.android.shopping.store.tabkit.model.k r50 = (com.bytedance.android.shopping.store.tabkit.model.k) CollectionsKt.getOrNull(r49, r48);
    L54:
        if (r50 != null) goto L56;
        r50 = r46.d();
    L56:
        if (r50 != null) goto L61;
        List<com.bytedance.android.shopping.store.tabkit.model.k> r51 = r46.m();
        if (r51 == null) goto L60;
        r50 = (com.bytedance.android.shopping.store.tabkit.model.k) CollectionsKt.firstOrNull(r51);
        goto L61
    L60:
        r50 = null;
    L61:
        if (r50 == null) goto L67;
        r12 = r50.n();
        goto L66
    L53:
        r50 = null;
        goto L54
    L42:
        r46 = null;
    L39:
        r45 = null;
        goto L40
    L27:
        r10 = null;
        goto L28
    L23:
        r8 = 0;
        goto L24
    L19:
        r7 = 0.0f;
        goto L21
    L7:
        if (r1.isFinishing() != true) goto L8;
    L151:
        super.onStop();
    }

    @Override // com.bytedance.android.shopping.store.tabkit.TabKitFragment, com.bytedance.android.shopping.store.tabkit.f
    public final Integer tv() {
        ECShopABSettings.k.getClass();
        if (ECShopABSettings.i() == false) goto L6;
        return null;
    L6:
        return 2131371222;
    }

    public ECStoreTabKitFragment() {
        this.q = LazyKt.lazy(new ECStoreTabKitFragment$skipRestore$2(this));
        this.r = LazyKt.lazy(ECStoreTabKitFragment$enableStoreTabKitFragmentLeakFix$2.INSTANCE);
    }

    @Override // com.bytedance.android.shopping.store.home.ECStoreTabKitFragmentBase, com.bytedance.android.shopping.store.tabkit.TabKitFragment
    public final void onDestroy() {
        super.onDestroy();
        if (((Boolean) this.r.getValue()).booleanValue() == false) goto L6;
        this.l.r(com.bytedance.android.shopping.store.home.module.k.class);
        return;
    }

    @Override // com.bytedance.android.shopping.store.home.ECStoreTabKitFragmentBase
    public final void onPause() {
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

    @Override // com.bytedance.android.shopping.store.tabkit.TabKitFragment
    public final void onCreate(Bundle r20) {
        super.onCreate(r20);
        Bundle r0 = getArguments();
        if (r0 == null) goto L5;
        Serializable r1 = r0.getSerializable("store_param");
    L7:
        if ((r1 instanceof ECStoreParam) == true) goto L9;
        r1 = null;
    L9:
        ECStoreParam r10 = (ECStoreParam) r1;
        if (r10 != null) goto L13;
        return;
    L13:
        if (T90() == true) goto L15;
        return;
    L15:
        Bundle r2 = getArguments();
        if (r2 == null) goto L18;
        String r3 = r2.getString("schema");
    L19:
        Uri r4 = UriProtector.parse(r3);
        this.k = r4;
        Lazy r5 = BtmSDKWrapper.a;
        if (r4 == null) goto L22;
        String r6 = UriProtector.getQueryParameter(r4, "source_btm_token");
    L23:
        BtmSDKWrapper.b(this, "a1.b6269", r6);
        BtmSDK r7 = BtmSDK.INSTANCE;
        PageFinder r8 = PageFinder.via(this);
        BcmParams.a r9 = BcmParams.Companion;
        Map r11 = MapsKt.mapOf(TuplesKt.to("entrance_location", r10.getEntranceLocation()));
        r9.getClass();
        boolean r12 = false;
        r7.setBcmPageParams(r8, BcmParams.a.c(r11), false);
        Map<Long, com.bytedance.android.shopping.store.lifecycle.m> r13 = com.bytedance.android.shopping.store.lifecycle.a.a;
        com.bytedance.android.shopping.store.lifecycle.m r14 = com.bytedance.android.shopping.store.lifecycle.a.a(Long.valueOf(r10.getLifecycleMonitorId()));
        if (r14 == null) goto L30;
        Context r15 = getContext();
        FragmentActivity r16 = getActivity();
        if (r16 == null) goto L28;
        JSONObject r17 = hm.c.d(r16);
    L29:
        r14.B(r15, r10, r17, PageType.DEFAULT);
        goto L30
    L28:
        r17 = null;
    L30:
        com.bytedance.android.shopping.utils.e0.a();
        kc.a r18 = com.bytedance.android.bcm.api.b.c(PageFinder.via(this), CollectionsKt.listOf("live_guide_info"));
        if (r18 != null) goto L33;
    L68:
        f4 r19 = V90().getShopFrameController();
        if (r19 == null) goto L71;
        wi3.b r21 = new wi3.b(getContext());
        wi3.a r22 = new wi3.a(getContext());
        Intrinsics.checkNotNullParameter(r10, "storeParams");
        Intrinsics.checkNotNullParameter(r21, "frameTransformer");
        Intrinsics.checkNotNullParameter(r22, "containerTransformer");
        dm.a.a("shop_frame").w("initTransformer", null);
        r19.e = r10;
        r19.a = r21;
        r19.b = r22;
    L71:
        BtmSDK r23 = BtmSDK.INSTANCE;
        kc.a r24 = BtmSDK.getBcmChainByFinder$default(r23, PageFinder.via(getView()), 0, false, 6, null);
        ECStoreViewModel r25 = V90();
        Context r26 = requireContext();
        Uri r27 = this.k;
        FragmentActivity r28 = getActivity();
        if (r28 == null) goto L74;
        String r29 = hm.c.e(r28);
    L75:
        FragmentActivity r30 = getActivity();
        if (r30 == null) goto L78;
        JSONObject r31 = hm.c.d(r30);
    L79:
        if (r24 == null) goto L81;
        String r32 = r24.a().toString();
    L82:
        r25.init(r26, r10, r27, r29, r31, r32);
        if (((Boolean) this.q.getValue()).booleanValue() == false) goto L85;
        dm.a.a("ec_shop_restore").a("store_onCreate_skip_restore secShopId=" + r10.getSecShopId() + " lmId=" + r10.getLifecycleMonitorId());
    L166:
        V90().setShareHelper(new ECShopShareHelper(this));
        V90().getStoreParam().setBtmPageId(r23.getPageId(PageFinder.via(this)));
        Uri r33 = this.k;
        if (r33 != null) goto L169;
    L171:
        boolean r34 = false;
    L172:
        this.m = r34;
        if (r20 == null) goto L177;
        s r35 = new s();
        JSONObject r36 = new JSONObject();
        r36.put("store_type", "shop");     // Catch: Exception -> L191
        r36.put("event_unique_id", "ec_store_activity_recreate");     // Catch: Exception -> L191
    L176:
        Unit r37 = Unit.INSTANCE;
        s.c(r35, "ec_store_activity_recreate", null, r10, r36, null, 50);
    L177:
        if (r20 == null) goto L180;
        r12 = true;
    L180:
        if (this.m == false) goto L182;
    L187:
        int r38 = ECSdk.a;
        IECFeedbackService r39 = (IECFeedbackService) ECSdk.a(IECFeedbackService.class);
        if (r39 == null) goto L196;
        r39.registerScreenCapture(getContext(), this);
        return;
    L196:
        return;
    L182:
        if (V90().isCroppedStyle() == true) goto L187;
        if (r12 == true) goto L187;
        if (ECStoreTabKitFragmentBase.W90() == true) goto L187;
        requireActivity().overridePendingTransition(2130772245, 2130772253);
        goto L187
    L169:
        if (r33.getBooleanQueryParameter("disable_enter_anim", false) != true) goto L171;
        r34 = true;
        goto L172
    L85:
        if (V90().getPageRestoreCoordinator() != null) goto L87;
        V90().setPageRestoreCoordinator(new com.bytedance.android.shopping.store.restore.q());
    L87:
        Bundle r40 = getArguments();
        FragmentActivity r41 = getActivity();
        if (r41 == null) goto L92;
        Intent r42 = r41.getIntent();
        if (r42 == null) goto L92;
        String r43 = r42.getStringExtra("ec_store_instance_id");
    L93:
        if (r43 != null) goto L107;
        if (r40 == null) goto L96;
        r43 = r40.getString("ec_store_instance_id");
    L97:
        if (r43 != null) goto L99;
    L102:
        boolean r44 = true;
    L104:
        if ((!r44) == true) goto L107;
        r43 = null;
        goto L107
    L99:
        if (StringsKt.isBlank(r43) == true) goto L102;
        r44 = false;
        goto L104
    L96:
        r43 = null;
    L107:
        if (r43 != null) goto L109;
        r43 = UUID.randomUUID().toString();
    L109:
        if (r40 == null) goto L111;
        r40.putString("ec_store_instance_id", r43);
    L111:
        StringBuilder r45 = new StringBuilder("store_onCreate secShopId=");
        r45.append(r10.getSecShopId());
        r45.append(" lmId=");
        r45.append(r10.getLifecycleMonitorId());
        r45.append(" instanceId=");
        r45.append(r43);
        r45.append(" recreate=");
        if (r20 == null) goto L114;
        boolean r46 = true;
    L115:
        r45.append(r46);
        dm.a.a("ec_shop_restore").a(r45.toString());
        com.bytedance.android.shopping.store.restore.q r47 = V90().getPageRestoreCoordinator();
        if (r47 == null) goto L137;
        Uri r48 = this.k;
        if (r20 == null) goto L120;
        boolean r49 = true;
    L121:
        Intrinsics.checkNotNullParameter(r10, "storeParam");
        Intrinsics.checkNotNullParameter(r43, "instanceId");
        r47.c = false;
        if (r48 == null) goto L125;
        String r50 = UriProtector.getQueryParameter(r48, "modal");
        if (r50 == null) goto L125;
    L126:
        r47.a = new com.bytedance.android.shopping.store.restore.n(r10.getSecShopId(), r10.getEntranceLocation(), r50, r10.getStoreSourcePage(), r43);
        r47.b = null;
        com.bytedance.android.shopping.store.restore.q.b("coordinator_onPageCreate secShopId=" + r10.getSecShopId() + " lmId=" + r10.getLifecycleMonitorId() + " instanceId=" + r43 + " enabled=" + com.bytedance.android.shopping.store.restore.r.a());
        if (com.bytedance.android.shopping.store.restore.r.a() == false) goto L137;
        if (r49 == false) goto L137;
        com.bytedance.android.shopping.store.restore.n r51 = r47.a;
        if (r51 == null) goto L137;
        r47.b = r47.h.a(r51, System.currentTimeMillis());
        StringBuilder r52 = new StringBuilder("coordinator_load key=");
        r52.append(r51);
        r52.append(" hitFull=");
        if (r47.b == null) goto L135;
        boolean r53 = true;
    L136:
        r52.append(r53);
        r52.append(" fullEnabled=");
        r52.append(com.bytedance.android.shopping.store.restore.r.b());
        r52.append(" productEnabled=");
        r52.append(com.bytedance.android.shopping.store.restore.r.c());
        com.bytedance.android.shopping.store.restore.q.b(r52.toString());
        goto L137
    L135:
        r53 = false;
    L125:
        r50 = r10.getSchemaQueryMap().get("modal");
        goto L126
    L120:
        r49 = false;
    L137:
        if (r20 == null) goto L166;
        jm.a<Boolean> r54 = V90().getRestoreCoverVisible();
        Boolean r55 = Boolean.TRUE;
        r54.setValue(r55);
        com.bytedance.android.shopping.store.restore.q r56 = V90().getPageRestoreCoordinator();
        if (r56 == null) goto L141;
        r56.c(V90());
    L141:
        com.bytedance.android.shopping.store.restore.q r57 = V90().getPageRestoreCoordinator();
        if (r57 == null) goto L164;
        ECStoreViewModel r58 = V90();
        Intrinsics.checkNotNullParameter(r58, "viewModel");
        if (com.bytedance.android.shopping.store.restore.r.a() == false) goto L164;
        com.bytedance.android.shopping.store.restore.m r59 = r57.b;
        if (r59 == null) goto L164;
        com.bytedance.android.shopping.store.restore.s r60 = r59.d;
        if (r60 == null) goto L164;
        com.bytedance.android.shopping.store.restore.u r61 = r60.d;
        if (r61 == null) goto L164;
        Integer r62 = r61.e;
        if (r62 == null) goto L164;
        int r63 = r62.intValue();
        if (r63 != 1) goto L158;
        r58.getSkipHeaderCollapseAnimOnce().setValue(r55);
    L158:
        r58.getHeaderStateEvent().setValue(new ui3.e(r63, ChangeStateType.AUTO));
        com.bytedance.android.shopping.store.restore.v r64 = r60.e;
        if (r64 == null) goto L163;
        Boolean r65 = r64.a;
        if (r65 == null) goto L163;
        r58.getHeaderAreaStartScrollTag().setValue(Boolean.valueOf(r65.booleanValue()));
    L163:
        com.bytedance.android.shopping.store.restore.q.b("coordinator_restore_header_state key=" + r60.a + " headerState=" + r63);
    L164:
        new Handler(Looper.getMainLooper()).postDelayed(new b(this), 500);
        goto L166
    L114:
        r46 = false;
    L92:
        r43 = null;
        goto L93
    L81:
        r32 = null;
        goto L82
    L78:
        r31 = null;
        goto L79
    L74:
        r29 = null;
        goto L75
    L33:
        if (r18.a.isEmpty() == true) goto L68;
        if (r18.a.size() < 4) goto L45;
        if (Intrinsics.areEqual(ECStoreTabKitFragmentBase.U90((kc.a.a) ListProtector.get(r18.a, 1)), "a1.b8094.c0.d0") == false) goto L45;
        if (Intrinsics.areEqual(ECStoreTabKitFragmentBase.U90((kc.a.a) ListProtector.get(r18.a, 2)), "a1.b0715.c0.d0") == false) goto L45;
        if (Intrinsics.areEqual(ECStoreTabKitFragmentBase.U90((kc.a.a) ListProtector.get(r18.a, 3)), "a1128.b3295.c0.d0") == false) goto L45;
        kc.a.a r66 = (kc.a.a) ListProtector.get(r18.a, 3);
    L52:
        if (r66 == null) goto L68;
        Result.Companion r67 = Result.Companion;     // Catch: Throwable -> L66
        kc.a.a.a r68 = r66.g;     // Catch: Throwable -> L66
        if (r68 == null) goto L63;
        BcmParams r69 = r68.a;     // Catch: Throwable -> L66
        if (r69 == null) goto L63;
        JSONObject r70 = r69.toJSONObject();     // Catch: Throwable -> L66
        if (r70 == null) goto L63;
        FragmentActivity r71 = getActivity();     // Catch: Throwable -> L66
        if (r71 == null) goto L64;
        hm.c.a(r71, r70);     // Catch: Throwable -> L66
    L64:
        Result.constructor-impl(r70);     // Catch: Throwable -> L66
    L63:
        r70 = null;
    L66:
        th = move-exception;
        Result.Companion r72 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
    L45:
        if (r18.a.size() >= 3) goto L47;
    L51:
        r66 = null;
        goto L52
    L47:
        if (Intrinsics.areEqual(ECStoreTabKitFragmentBase.U90((kc.a.a) ListProtector.get(r18.a, 1)), "a1.b8094.c0.d0") == false) goto L51;
        if (Intrinsics.areEqual(ECStoreTabKitFragmentBase.U90((kc.a.a) ListProtector.get(r18.a, 2)), "a1128.b3295.c0.d0") == false) goto L51;
        r66 = (kc.a.a) ListProtector.get(r18.a, 2);
        goto L52
    L22:
        r6 = null;
        goto L23
    L18:
        r3 = null;
        goto L19
    L5:
        r1 = null;
        goto L7
    }

    @Override // com.bytedance.android.shopping.store.tabkit.TabKitFragment
    public final void onViewCreated(View r10, Bundle r11) {
        Intrinsics.checkNotNullParameter(r10, "view");
        Intrinsics.checkNotNullParameter(r10, "root");
        HashMap r12 = new HashMap();
        ShopContainerType[] r0 = ShopContainerType.values();
        int r1 = r0.length;
        int r3 = 0;
    L3:
        vi3.b r4 = null;
        if (r3 >= r1) goto L20;
        ShopContainerType r6 = r0[r3];
        switch(c4.a[r6.ordinal()]) {
            case 1: goto L16;
            case 2: goto L15;
            case 3: goto L14;
            case 4: goto L13;
            case 5: goto L12;
            case 6: goto L11;
            case 7: goto L10;
            case 8: goto L9;
            case 9: goto L8;
            default: goto L17;
        };
    L8:
        r4 = new vi3.b(ShopContainerType.ROOT_CONTAINER, r10.findViewById(2131371126));
        goto L17
    L9:
        r4 = new vi3.b(ShopContainerType.BOTTOM_BAR_CONTAINER, r10.findViewById(2131371128));
        goto L17
    L10:
        r4 = new vi3.b(ShopContainerType.LIVE_TAB_CONTAINER, r10.findViewById(2131386247));
        goto L17
    L11:
        r4 = new vi3.b(ShopContainerType.TAB_CONTENT_CONTAINER, r10.findViewById(2131371056));
        goto L17
    L12:
        r4 = new vi3.b(ShopContainerType.SHOP_LYNX, r10.findViewById(2131370929));
        goto L17
    L13:
        r4 = new vi3.b(ShopContainerType.LIVE_PREVIEW_CONTAINER, r10.findViewById(2131371107));
        goto L17
    L14:
        r4 = new vi3.b(ShopContainerType.BACKGROUND_CONTAINER, r10.findViewById(2131371041));
        goto L17
    L15:
        r4 = new vi3.b(ShopContainerType.SHOP_INFO_CONTAINER, r10.findViewById(2131371092));
        goto L17
    L16:
        r4 = new vi3.b(ShopContainerType.SHOP_TOPBAR_CONTAINER, r10.findViewById(2131371156));
    L17:
        if (r4 == null) goto L19;
        r12.put(r6, r4);
    L19:
        r3 = r3 + 1;
        goto L3
    L20:
        f4 r2 = V90().getShopFrameController();
        Map<? extends ShopContainerType, ? extends vi3.b<? extends View>> r13 = MapsKt.toMap(r12);
        r2.getClass();
        Intrinsics.checkNotNullParameter(r13, "map");
        r2.d.putAll(r13);
        dm.a.a("shop_frame").w("initContainer", null);
        if (r2.g != null) goto L23;
    L25:
        this.l.c(com.bytedance.android.shopping.store.home.module.k.class, null);
        this.j.J(null, r10, null);
        if (V90().getStoreParam().getNeedShowMallBackView() == false) goto L28;
        r10.post(d.a);
    L28:
        ShopEventListenCenter.b.onShow(null);
        V90().fetchAll(getContext());
        View r14 = getView();
        if (r14 == null) goto L31;
        FoldAdaptedFrameLayout r15 = (FoldAdaptedFrameLayout) r14.findViewById(2131371127);
    L32:
        View r16 = getView();
        if (r16 == null) goto L35;
        FoldAdaptedFrameLayout r17 = (FoldAdaptedFrameLayout) r16.findViewById(2131371146);
    L36:
        if (r15 == null) goto L39;
        r15.setAdaptedEnabled(false);
    L39:
        if (ECStoreFoldPhoneHelper.d() == false) goto L43;
        if (r17 == null) goto L42;
        r17.setOnTabSizeChangeListener(new ECStoreTabKitFragment$setAnimationController$1(this));
    L42:
        V90().isBrandShop().a(this, new u(r15), false);
    L43:
        View r18 = getView();
        if (r18 == null) goto L48;
        ECShopRootFrameLayout r19 = r18.findViewById(2131371126);
        if (r19 == null) goto L48;
        v r5 = new v(this);
        Intrinsics.checkNotNullParameter(r5, "listener");
        r19.d.add(r5);
    L48:
        V90().isBrandShop().a(this, new w(r17), false);
        int r110 = ECStorePerfMonitor.n;
        ECStorePerfMonitor r111 = ECStorePerfMonitor.a.a(Long.valueOf(V90().getStoreParam().getLifecycleMonitorId()));
        if (r111 == null) goto L57;
        com.bytedance.android.shopping.store.lifecycle.g r112 = r111.k;
        if (r112 == null) goto L58;
        int r113 = com.bytedance.android.shopping.store.lifecycle.g.e;
        r112.c(4, null);
        return;
    L58:
        return;
    L57:
        return;
    L35:
        r17 = null;
        goto L36
    L31:
        r15 = null;
        goto L32
    L23:
        if (r2.h == null) goto L25;
        dm.a.a("shop_frame").w("updateContainer with hold data", null);
        com.bytedance.android.shopping.store.home.entity.n r114 = r2.g;
        Intrinsics.checkNotNull(r114);
        StoreSizeConfig r7 = r2.h;
        Intrinsics.checkNotNull(r7);
        r2.a(r114, r7);
        goto L25
    }

    @Override // com.bytedance.android.shopping.store.tabkit.TabKitFragment
    public final View onCreateView(LayoutInflater r7, ViewGroup r8, Bundle r9) {
        Intrinsics.checkNotNullParameter(r7, "inflater");
        j2 r10 = j2.g;
        StringBuilder r11 = new StringBuilder("call ECStoreTabKitFragment.onCreateView debug_info=");
        DialogFragment r0 = null;
        if (r8 == null) goto L5;
        Context r1 = r8.getContext();
    L6:
        r11.append(r10.b(r1));
        j2.d(r11.toString());
        QUIManager r12 = this.l;
        FrameLayout r13 = new FrameLayout(requireContext());
        Context r2 = th.a.e(requireContext(), true);
        View r3 = ((ECStoreResourcePreloadManager) ECStoreResourcePreloadManager.c.getValue()).a(r2, 2131560954);
        if (r3 != null) goto L10;
        ContextThemeWrapper r4 = new ContextThemeWrapper(th.a.e(r2, true), 2131952363);
        ShoppingAsyncInflater.e.getClass();
        r3 = ShoppingAsyncInflater.a.a(r4).aU(2131560954, r8, false);
    L10:
        com.bytedance.android.shopping.extensions.f.a(r13, r3);
        Unit r14 = Unit.INSTANCE;
        pn.b.a(r12, new com.bytedance.android.shopping.store.home.module.k(r13, this, V90().isCroppedStyle()), requireContext(), this);
        V90().getHeaderArea().a(this, new c(this), false);
        Lifecycle r15 = getLifecycle();
        DialogFragment r16 = getParentFragment();
        if ((r16 instanceof DialogFragment) == false) goto L14;
        r0 = r16;
    L14:
        DialogFragment r5 = r0;
        View r17 = this.l.p();
        if (r17 == null) goto L19;
        r15.addObserver(new StoreLifeCycleObserver(r5, (FrameLayout) r17, V90()));
        return this.l.p();
    L19:
        throw new NullPointerException("null cannot be cast to non-null type android.widget.FrameLayout");
    L5:
        r1 = null;
        goto L6
    }
}
