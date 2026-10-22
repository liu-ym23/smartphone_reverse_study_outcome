package com.bytedance.android.shopping.store.home.presenter;

import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.os.SystemClock;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.OnLifecycleEvent;
import com.bytedance.android.btm.api.model.PageFinder;
import com.bytedance.android.ec.base.service.ECServiceManager;
import com.bytedance.android.ec.common.api.usertracker.IECUserTrackerService;
import com.bytedance.android.ec.core.hybrid.utils.ECLiveHybridUtil;
import com.bytedance.android.ec.core.hybrid.widgets.LynxTaskBanner;
import com.bytedance.android.ec.hybrid.bridge.LynxStatefulBridgeProxy;
import com.bytedance.android.ec.hybrid.card.bridge.ECBridgeMethodFinder;
import com.bytedance.android.ec.sdk.ECSdk;
import com.bytedance.android.ec.store.view.ECShopRootFrameLayout;
import com.bytedance.android.shopping.store.home.api.ECStoreParam;
import com.bytedance.android.shopping.store.home.datasource.ECShopDataStorageForRemote;
import com.bytedance.android.shopping.store.hybrid.download.ISVDownloadManager;
import com.bytedance.android.shopping.store.lifecycle.ShopEventListenCenter;
import com.bytedance.android.shopping.store.viewmodel.ECStoreViewModel;
import com.bytedance.android.shopping.store.viewmodel.ShopStatus;
import com.bytedance.ies.xbridge.event.Event;
import com.bytedance.ies.xbridge.event.EventCenter;
import com.bytedance.mt.protector.impl.JSONObjectProtectorUtils;
import com.bytedance.sdk.xbridge.cn.registry.core.IDLXBridgeMethod;
import com.bytedance.security.android.aopcheck.PolarisFileWriterWrapper;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import com.ss.android.ugc.aweme.kiwi.model.QModel;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u00012\u00020\u0002:\u0001\u0007J\b\u0010\u0004\u001a\u00020\u0003H\u0007J\b\u0010\u0005\u001a\u00020\u0003H\u0007J\b\u0010\u0006\u001a\u00020\u0003H\u0007¨\u0006\b"}, d2 = {"Lcom/bytedance/android/shopping/store/home/presenter/ECShopAbilityPresenter;", "Lcom/bytedance/android/shopping/store/home/presenter/ECShopBasePresenter;", "Landroidx/lifecycle/LifecycleObserver;", "", "onResume", "onPause", "onDestroy", "a", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ECShopAbilityPresenter extends ECShopBasePresenter implements LifecycleObserver {
    public static final /* synthetic */ int B = 0;
    public int A;
    public final o u;
    public final List<com.bytedance.android.shopping.store.hybrid.j> v;
    public final Map<String, IDLXBridgeMethod> w;
    public Object x;
    public long y;
    public boolean z;

    public static final class a {
    }

    public static final class b extends com.bytedance.android.shopping.store.hybrid.j {
        public final /* synthetic */ ECShopAbilityPresenter b;

        public b(ECShopAbilityPresenter r1) {
            this.b = r1;
            super("IESLiveKit_ecom_pendant_close_event");
        }

        public final void a(JSONObject r2) {
            Intrinsics.checkNotNullParameter(r2, "params");
            this.b.Q();
        }
    }

    public static final class c extends com.bytedance.android.shopping.store.hybrid.j {
        public final /* synthetic */ ECShopAbilityPresenter b;

        public c(ECShopAbilityPresenter r1) {
            this.b = r1;
            super("ecom.shop.attach_live_mini_window");
        }

        public final void a(JSONObject r3) {
            Intrinsics.checkNotNullParameter(r3, "params");
            if (JSONObjectProtectorUtils.getBoolean(r3, "attach") == false) goto L5;
            im.b.i(this.b.T().getLiveManager(), false, false, 3);
            return;
        L5:
            this.b.T().getLiveManager().b();
        }
    }

    public static final class d extends com.bytedance.android.shopping.store.hybrid.j {
        public final /* synthetic */ ECShopAbilityPresenter b;

        public d(ECShopAbilityPresenter r1) {
            this.b = r1;
            super("ecom.shop.update_max_swipe_distance");
        }

        public final void a(JSONObject r3) {
            Intrinsics.checkNotNullParameter(r3, "params");
            String r0 = r3.optString("tab_name");
            int r4 = r3.optInt("max_swipe_distance");
            if (r0.length() != 0) goto L5;
            boolean r1 = true;
        L6:
            if (r1 == true) goto L11;
            if (r4 == 0) goto L12;
            this.b.T().getTabSlideCnt().put(r0, Integer.valueOf(r4));
            return;
        L12:
            return;
        L11:
            return;
        L5:
            r1 = false;
            goto L6
        }
    }

    public static final class e extends com.bytedance.android.shopping.store.hybrid.j {
        public e() {
            super("ecom.shop.handle_native_for_remote_data");
        }

        public final void a(JSONObject r8) {
            Intrinsics.checkNotNullParameter(r8, "params");
            int r2 = r8.optInt("action_type");
            String r5 = r8.optString("business_id");
            String r3 = com.bytedance.android.shopping.extensions.k.k(r8.optString("sec_shop_id"), "-1");
            String r4 = com.bytedance.android.shopping.extensions.k.k(r8.optString("user_id"), "-1");
            String r6 = r8.optString("data");
            if (r5 != null) goto L5;
        L8:
            boolean r0 = true;
        L9:
            if (r0 == true) goto L19;
            if (r2 == 0) goto L17;
            if (r2 == 1) goto L17;
            if (r2 == 2) goto L17;
            if (r2 == 3) goto L17;
            return;
        L17:
            ECShopDataStorageForRemote.b.c(r2, r3, r4, r5, r6);
            return;
        L19:
            return;
        L5:
            if (StringsKt.isBlank(r5) == true) goto L8;
            r0 = false;
            goto L9
        }
    }

    public static final class f extends com.bytedance.android.shopping.store.hybrid.j {
        public final /* synthetic */ ECShopAbilityPresenter b;

        @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0000*\u0001\u0000\b\n\u0018\u00002\u0016\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u00020\u0001¨\u0006\u0005"}, d2 = {"com/bytedance/android/shopping/store/home/presenter/ECShopAbilityPresenter$f$a", "Lcom/google/gson/reflect/TypeToken;", "", "", "", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
        public static final class a extends TypeToken<Map<String, ? extends Object>> {
            public a() {
            }
        }

        public f(ECShopAbilityPresenter r1) {
            this.b = r1;
            super("ecom.shop.refresh_filter_field");
        }

        public final void a(JSONObject r5) {
            Intrinsics.checkNotNullParameter(r5, "params");
            Object r0 = r5.opt("filter_params");     // Catch: Exception -> L29
            String r1 = "";
            if (r0 == null) goto L8;
            String r2 = r0.toString();     // Catch: Exception -> L29
            if (r2 == null) goto L8;
        L9:
            Type r3 = new a().getType();     // Catch: Exception -> L29
            Map r4 = (Map) new Gson().fromJson(r2, r3);     // Catch: Exception -> L29
            Object r6 = r5.opt("client_state");     // Catch: Exception -> L29
            if (r6 == null) goto L15;
            String r7 = r6.toString();     // Catch: Exception -> L29
            if (r7 == null) goto L15;
            r1 = r7;
        L15:
            Map r8 = (Map) new Gson().fromJson(r1, r3);     // Catch: Exception -> L29
            int r9 = r5.optInt("tab_id");     // Catch: Exception -> L29
            String r10 = r5.optString("shop_id");     // Catch: Exception -> L29
            if (com.bytedance.android.shopping.extensions.k.c(r10) == true) goto L18;
        L20:
            com.bytedance.android.ec.core.arch.event.c.d(this.b.T(), new kj3.b(r4, r8, Integer.valueOf(r9)));     // Catch: Exception -> L29
            Object r11 = r4.get("has_filter");     // Catch: Exception -> L29
            if ((r11 instanceof Boolean) == true) goto L23;
            r11 = null;
        L23:
            Boolean r12 = (Boolean) r11;     // Catch: Exception -> L29
            if (r12 == null) goto L26;
            boolean r13 = r12.booleanValue();     // Catch: Exception -> L29
        L27:
            this.b.T().getSelectPanelState().c(Boolean.valueOf(r13));     // Catch: Exception -> L29
            return;
        L26:
            r13 = false;
            goto L27
        L18:
            if ((!Intrinsics.areEqual(r10, this.b.T().getStoreParam().getShopId())) == false) goto L20;
            return;
        L8:
            r2 = "";
        L29:
            e = move-exception;
            e.printStackTrace();
        }
    }

    public static final class g extends com.bytedance.android.shopping.store.hybrid.j {
        public final /* synthetic */ ECShopAbilityPresenter b;

        public g(ECShopAbilityPresenter r1) {
            this.b = r1;
            super("ecom.shop.refresh_layout_type");
        }

        public final void a(JSONObject r4) {
            Intrinsics.checkNotNullParameter(r4, "params");
            Object r0 = r4.get("layout_type");
            if ((r0 instanceof Integer) == true) goto L5;
            r0 = null;
        L5:
            Integer r1 = (Integer) r0;
            if (r1 != null) goto L9;
        L10:
            if (r1 != null) goto L13;
            return;
        L13:
            if (r1.intValue() == 1) goto L15;
            return;
        L15:
            int r5 = r4.optInt("tab_id");
            com.bytedance.android.ec.core.arch.event.c.d(this.b.T(), new kj3.c(r1, Integer.valueOf(r5)));
            return;
        L9:
            if (r1.intValue() == 0) goto L15;
            goto L10
        }
    }

    public static final class h extends com.bytedance.android.shopping.store.hybrid.j {
        public final /* synthetic */ ECShopAbilityPresenter b;

        public h(ECShopAbilityPresenter r1) {
            this.b = r1;
            super("ecom.shop.show_coupon_anim");
        }

        public final void a(JSONObject r2) {
            Intrinsics.checkNotNullParameter(r2, "params");
            this.b.T().getShowCouponAnimEvent().c(Boolean.TRUE);
        }
    }

    public static final class i extends com.bytedance.android.shopping.store.hybrid.j {
        public final /* synthetic */ ECShopAbilityPresenter b;

        public i(ECShopAbilityPresenter r1) {
            this.b = r1;
            super("ecom.shop.switch_scroll");
        }

        public final void a(JSONObject r2) {
            Intrinsics.checkNotNullParameter(r2, "params");
            int r3 = r2.optInt("scroll");
            if (r3 != 0) goto L6;
            this.b.T().getChangeScrollEvent().c(Boolean.FALSE);
            return;
        L6:
            if (r3 != 1) goto L10;
            this.b.T().getChangeScrollEvent().c(Boolean.TRUE);
            return;
        }
    }

    public static final class j extends com.bytedance.android.shopping.store.hybrid.j {
        public final /* synthetic */ ECShopAbilityPresenter b;

        public j(ECShopAbilityPresenter r1) {
            this.b = r1;
            super("ecom.shop.switch_state");
        }

        public final void a(JSONObject r5) {
            Intrinsics.checkNotNullParameter(r5, "params");
            int r6 = r5.optInt("state");
            if (r6 != 0) goto L8;
            if (((ShopStatus) this.b.T().getShopStatus().getValue()) != ShopStatus.PREVIEW_COLLAPSE) goto L20;
            this.b.T().getChangeStateEvent().setValue(new ui3.c(4, ShopStatus.PREVIEW_EXPANDED, 2));
            return;
        L20:
            return;
        L8:
            if (r6 == 1) goto L10;
            if (r6 == 2) goto L14;
            return;
        L14:
            if (com.bytedance.android.shopping.extensions.k.d((Float) this.b.T().getUpglideFactor().getValue()) >= 1.0f) goto L17;
            this.b.T().getHeaderStateEvent().c(new ui3.e(1));
        L17:
            if (((ShopStatus) this.b.T().getShopStatus().getValue()) != ShopStatus.PREVIEW_EXPANDED) goto L25;
            this.b.T().getChangeStateEvent().setValue(new ui3.c(3, ShopStatus.PREVIEW_COLLAPSE, 2));
            return;
        L25:
            return;
        L10:
            if (com.bytedance.android.shopping.extensions.k.d((Float) this.b.T().getUpglideFactor().getValue()) == 0.0f) goto L22;
            this.b.T().getHeaderStateEvent().c(new ui3.e(0));
            return;
        }
    }

    public static final class k implements Runnable {
        public final /* synthetic */ ECShopAbilityPresenter a;
        public final /* synthetic */ ECStoreParam b;

        public k(ECShopAbilityPresenter r1, ECStoreParam r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void a() {
            String r0 = this.b.getFrame();
            if (r0 != null) goto L26;
        L6:
            JSONObject r2 = null;
        L24:
            String r1 = this.b.getTaskRequestParams();     // Catch: JSONException -> L20
            if (r1 == null) goto L11;
            JSONObject r3 = new JSONObject(r1);     // Catch: JSONException -> L20
        L22:
            String r4 = this.b.getExtra();     // Catch: JSONException -> L19
            if (r4 == null) goto L16;
            JSONObject r5 = new JSONObject(r4);     // Catch: JSONException -> L19
        L17:
            Map r6 = LynxTaskBanner.i;
            ECShopAbilityPresenter r7 = this.a;
            int r8 = ECShopAbilityPresenter.B;
            LynxTaskBanner.a.a(r7.u().c(), MapsKt.mapOf(new Pair[]{TuplesKt.to("frame", r2), TuplesKt.to("task_enter_from", this.b.getTaskEnterFrom()), TuplesKt.to("task_type", this.b.getTaskType()), TuplesKt.to("enter_from", this.b.getEnterFrom()), TuplesKt.to("source_page", this.b.getEnterFrom()), TuplesKt.to("author_id", this.b.getStoreAccountParam().getUserId()), TuplesKt.to("page_name", this.b.getPageName()), TuplesKt.to("task_request_params", r3), TuplesKt.to("extra", r5)}), null);
            return;
        L16:
            r5 = null;
        L11:
            r3 = null;
            goto L22
        L26:
            r2 = new JSONObject(r0);     // Catch: JSONException -> L21
            goto L24
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static final class l<T> implements Observer {
        public final /* synthetic */ ECShopAbilityPresenter a;

        public l(ECShopAbilityPresenter r1) {
            this.a = r1;
        }

        public final void onChanged(Object r3) {
            Integer r4 = (Integer) r3;
            ECShopAbilityPresenter r5 = this.a;
            int r0 = ECShopAbilityPresenter.B;
            r5.r0();
            if (this.a.V() == false) goto L10;
            ECShopAbilityPresenter r6 = this.a;
            if (r6.h == null) goto L11;
            Map<Long, com.bytedance.android.shopping.store.lifecycle.m> r1 = com.bytedance.android.shopping.store.lifecycle.a.a;
            com.bytedance.android.shopping.store.lifecycle.m r7 = com.bytedance.android.shopping.store.lifecycle.a.a(Long.valueOf(r6.T().getStoreParam().getLifecycleMonitorId()));
            if (r7 == null) goto L12;
            r7.l();
            return;
        L12:
            return;
        L11:
            return;
        }
    }

    public static final class m<T> implements Observer {
        public final /* synthetic */ ECShopAbilityPresenter a;

        public m(ECShopAbilityPresenter r1) {
            this.a = r1;
        }

        public final void onChanged(Object r2) {
            ShopStatus r3 = (ShopStatus) r2;
            if (r3 != ShopStatus.PREVIEW_EXPANDED) goto L6;
            ECShopAbilityPresenter.q0(this.a, 0);
            return;
        L6:
            if (r3 != ShopStatus.PREVIEW_COLLAPSE) goto L10;
            ECShopAbilityPresenter.q0(this.a, 1);
            return;
        }
    }

    public static final class n<T> implements Observer {
        public final /* synthetic */ ECShopAbilityPresenter a;

        public n(ECShopAbilityPresenter r1) {
            this.a = r1;
        }

        public final void onChanged(Object r2) {
            Float r3 = (Float) r2;
            if (Intrinsics.areEqual(r3, 1.0f) == false) goto L6;
            ECShopAbilityPresenter.q0(this.a, 2);
            return;
        L6:
            if (Intrinsics.areEqual(r3, 0.0f) == false) goto L10;
            ECShopAbilityPresenter.q0(this.a, 1);
            return;
        }
    }

    public static final class o implements com.bytedance.android.ec.core.utils.b1 {
        public final /* synthetic */ ECShopAbilityPresenter a;

        public o(ECShopAbilityPresenter r1) {
            this.a = r1;
        }

        public final void a(String r4) {
            Intrinsics.checkNotNullParameter(r4, "filePath");
            this.a.T().doEventAction("store_screenshot", new Pair[]{TuplesKt.to("author_id", this.a.T().getStoreParam().getStoreAccountParam().getUserId()), TuplesKt.to("shop_id", this.a.T().getStoreParam().getShopId()), TuplesKt.to("sec_shop_id", this.a.T().getStoreParam().getSecShopId()), TuplesKt.to("entrance_location", this.a.T().getStoreParam().getEntranceLocation()), TuplesKt.to("store_source_page", this.a.T().getStoreParam().getStoreSourcePage()), TuplesKt.to("store_source_method", this.a.T().getStoreParam().getStoreSourceMethod()), TuplesKt.to("store_group_type", this.a.T().getStoreParam().getStoreGroupType()), TuplesKt.to("store_type", "shop")});
        }
    }

    static {
    }

    public ECShopAbilityPresenter() {
        this(null);
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    public final void onDestroy() {
        boolean r0 = gm.a.a;
        Context r2 = u().c();
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter("shop", "pageId");
        int r1 = ECSdk.a;
        IECUserTrackerService r3 = (IECUserTrackerService) ECSdk.a(IECUserTrackerService.class);
        if (r3 == null) goto L6;
        r3.leavePage(new of.b(r2, "shop", false, null, 28));
        return;
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    public final void onPause() {
        ShopEventListenCenter.b.onPause(T().getStoreParam().getShopId());
        T().doAnyEventActionWithBtm("a1.b6269.c0.d0", PageFinder.via(y()), "stay_store_page", MapsKt.emptyMap(), new Pair[]{TuplesKt.to("duration", String.valueOf(SystemClock.elapsedRealtime() - this.y)), TuplesKt.to("store_source_page", T().getStoreParam().getStoreSourcePage()), TuplesKt.to("store_source_method", T().getStoreParam().getStoreSourceMethod()), TuplesKt.to("store_group_type", T().getStoreParam().getStoreGroupType())});
        com.bytedance.android.ec.core.utils.i0 r0 = com.bytedance.android.ec.core.utils.i0.f;
        Context r1 = u().c();
        com.bytedance.android.ec.core.utils.i0.b.put(r1, null);
        r0.getClass();
        com.bytedance.android.ec.core.utils.i0.b(r1);
        Map<Long, com.bytedance.android.shopping.store.lifecycle.m> r2 = com.bytedance.android.shopping.store.lifecycle.a.a;
        com.bytedance.android.shopping.store.lifecycle.m r3 = com.bytedance.android.shopping.store.lifecycle.a.a(Long.valueOf(T().getStoreParam().getLifecycleMonitorId()));
        if (r3 == null) goto L6;
        r3.onPause();
        return;
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    public final void onResume() {
        boolean r0 = gm.a.a;
        Context r1 = u().c();
        boolean r2 = V();
        DialogFragment r3 = S();
        Intrinsics.checkNotNullParameter(r1, "context");
        Intrinsics.checkNotNullParameter("shop", "pageId");
        if (gm.a.a == false) goto L5;
        gm.a.a(r1, r2, r3);
    L5:
        Context r4 = u().c();
        com.bytedance.android.ec.core.utils.i0 r5 = com.bytedance.android.ec.core.utils.i0.f;
        com.bytedance.android.ec.core.utils.i0.b.put(r4, this.u);
        r5.getClass();
        com.bytedance.android.ec.core.utils.i0.a(r4);
        this.y = SystemClock.elapsedRealtime();
        ShopEventListenCenter.b.onResume(T().getStoreParam().getShopId());
        Map<Long, com.bytedance.android.shopping.store.lifecycle.m> r6 = com.bytedance.android.shopping.store.lifecycle.a.a;
        com.bytedance.android.shopping.store.lifecycle.m r7 = com.bytedance.android.shopping.store.lifecycle.a.a(Long.valueOf(T().getStoreParam().getLifecycleMonitorId()));
        if (r7 == null) goto L9;
        r7.onResume(u().c());
        return;
    }

    public final void C() {
        Activity r0 = com.bytedance.android.ec.core.utils.l0.b(u().c());
        boolean r1 = ECServiceManager.a;
        s83.c r2 = ((s83.g) ECServiceManager.c(s83.g.class)).D();
        if (r2 == null) goto L12;
        if (r0 == null) goto L6;
        boolean r4 = true;
    L7:
        if (r4 == true) goto L10;
        r2 = null;
    L10:
        if (r2 == null) goto L12;
        Intrinsics.checkNotNull(r0);
        r2.e(r0);
        goto L12
    L6:
        r4 = false;
    L12:
        this.x = null;
        Iterator<T> r3 = this.v.iterator();
    L14:
        if (r3.hasNext() == false) goto L16;
        com.bytedance.android.shopping.store.hybrid.j r5 = (com.bytedance.android.shopping.store.hybrid.j) r3.next();
        ECLiveHybridUtil.p(r5.a, r5);
        goto L14
    L16:
        Iterator<Map.Entry<String, IDLXBridgeMethod>> r6 = this.w.entrySet().iterator();
    L18:
        if (r6.hasNext() == false) goto L20;
        Map.Entry<String, IDLXBridgeMethod> r7 = r6.next();
        ECBridgeMethodFinder.a r8 = ECBridgeMethodFinder.h;
        String r9 = T().getSceneId();
        String r10 = r7.getKey();
        r8.getClass();
        ECBridgeMethodFinder.a.b(r9, r10);
        goto L18
    L20:
        k0().removeObserver(this);
        com.bytedance.android.ec.core.imagex.t.c(u().c());
        com.bytedance.android.shopping.store.utils.h r11 = ISVDownloadManager.c;
        if (r11 != null) goto L23;
    L34:
        ECStoreViewModel r12 = T();
        Map<String, Integer> r13 = T().getTabSlideCnt();
        ArrayList r14 = new ArrayList(r13.size());
        Iterator<Map.Entry<String, Integer>> r15 = r13.entrySet().iterator();
    L36:
        if (r15.hasNext() == false) goto L38;
        Map.Entry<String, Integer> r16 = r15.next();
        r14.add(TuplesKt.to(r16.getKey(), Float.valueOf(r16.getValue().intValue() / com.bytedance.android.ec.core.utils.k1.i())));
        goto L36
    L38:
        r12.doEventAction("store_user_slide", MapsKt.mapOf(TuplesKt.to("slide_cnt", com.bytedance.android.ec.hybrid.list.util.k.b(MapsKt.toMap(r14)).toString())), new Pair[0]);
        Map<Long, com.bytedance.android.shopping.store.lifecycle.m> r17 = com.bytedance.android.shopping.store.lifecycle.a.a;
        com.bytedance.android.shopping.store.lifecycle.m r18 = com.bytedance.android.shopping.store.lifecycle.a.a(Long.valueOf(T().getStoreParam().getLifecycleMonitorId()));
        if (r18 == null) goto L41;
        r18.J(T(), T().getStoreParam(), ((com.bytedance.android.ec.core.utils.k1.j(u().c()) - f0()) - e0()) - com.bytedance.android.ec.core.utils.l0.e(u().c()));
    L41:
        long r19 = T().getStoreParam().getLifecycleMonitorId();
        com.bytedance.android.shopping.store.lifecycle.a.a.remove(Long.valueOf(r19));
        com.bytedance.android.shopping.store.lifecycle.a.b.remove(Long.valueOf(r19));
        return;
    L23:
        if (r11.c == false) goto L34;
        r11.c = false;
        Result.Companion r20 = Result.Companion;     // Catch: Throwable -> L32
        r11.b();     // Catch: Throwable -> L32
        PolarisFileWriterWrapper r21 = new PolarisFileWriterWrapper(r11.d);     // Catch: Throwable -> L32
        r21.write("");     // Catch: Throwable -> L32
        r21.flush();     // Catch: Throwable -> L32
        Iterator<T> r22 = r11.f.iterator();     // Catch: Throwable -> L32
    L28:
        if (r22.hasNext() == false) goto L30;
        r21.write((String) r22.next());     // Catch: Throwable -> L32
        goto L28
    L30:
        r21.close();     // Catch: Throwable -> L32
        Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L32
    L32:
        th = move-exception;
        Result.Companion r23 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
        goto L34
    }

    public final void r0() {
        if (V() == true) goto L5;
        return;
    L5:
        ECStoreParam r0 = T().getStoreParam();
        if (this.z == true) goto L17;
        String r1 = r0.getTaskType();
        if (r1 != null) goto L10;
    L13:
        boolean r2 = true;
    L14:
        if (r2 == true) goto L18;
        new Handler().post(new k(this, r0));
        this.z = true;
        return;
    L18:
        return;
    L10:
        if (r1.length() == 0) goto L13;
        r2 = false;
        goto L14
    }

    public ECShopAbilityPresenter(final Fragment r17) {
        super(r17);
        this.u = new o(this);
        this.v = CollectionsKt.listOf(new com.bytedance.android.shopping.store.hybrid.j[]{new b(this), new c(this), new d(this), new e(), new f(this), new g(this), new h(this), new i(this), new j(this)});
        this.w = MapsKt.mapOf(new Pair[]{TuplesKt.to("sendAdLog", new LynxStatefulBridgeProxy(ECShopAbilityPresenter$sendAdLogBridge$1.INSTANCE, "sendAdLog")), TuplesKt.to("redirect_to_goods_detail", new LynxStatefulBridgeProxy(new ECShopAbilityPresenter$redirectToGoodsDetailBridge$1(this, r17), "redirect_to_goods_detail")), TuplesKt.to("ecom.shop.handle_native_for_remote_data", new LynxStatefulBridgeProxy(ECShopAbilityPresenter$handleDataForRemote$1.INSTANCE, "ecom.shop.handle_native_for_remote_data")), TuplesKt.to("ecom.shop.refresh_layout_type", new LynxStatefulBridgeProxy(new ECShopAbilityPresenter$handleLayoutType$1(this), "ecom.shop.refresh_layout_type")), TuplesKt.to("ecom.shop.refresh_filter_field", new LynxStatefulBridgeProxy(new ECShopAbilityPresenter$handleFilterField$1(this), "ecom.shop.refresh_filter_field")), TuplesKt.to("ecom.shop.open", new LynxStatefulBridgeProxy(new ECShopAbilityPresenter$handleShopOpen$1(this, r17), "ecom.shop.open")), TuplesKt.to("ecom.shop.get_ab_value", new LynxStatefulBridgeProxy(ECShopAbilityPresenter$getShopAbValueBridge$1.INSTANCE, "ecom.shop.get_ab_value"))});
        this.A = -1;
    }

    public final void A(QModel r5) {
        com.bytedance.android.ec.core.imagex.t.b(u().c(), T().getImageCallerContext());
        k0().addObserver(this);
        Iterator<T> r6 = this.v.iterator();
    L4:
        if (r6.hasNext() == false) goto L6;
        com.bytedance.android.shopping.store.hybrid.j r0 = (com.bytedance.android.shopping.store.hybrid.j) r6.next();
        ECLiveHybridUtil.m(r0.a, r0);
        goto L4
    L6:
        Iterator<Map.Entry<String, IDLXBridgeMethod>> r7 = this.w.entrySet().iterator();
    L8:
        if (r7.hasNext() == false) goto L10;
        Map.Entry<String, IDLXBridgeMethod> r1 = r7.next();
        ECBridgeMethodFinder.a r2 = ECBridgeMethodFinder.h;
        String r3 = T().getSceneId();
        String r4 = r1.getKey();
        IDLXBridgeMethod r8 = r1.getValue();
        r2.getClass();
        ECBridgeMethodFinder.a.a(r3, r4, r8);
        goto L8
    L10:
        Activity r9 = com.bytedance.android.ec.core.utils.l0.b(u().c());
        boolean r10 = ECServiceManager.a;
        s83.c r11 = ((s83.g) ECServiceManager.c(s83.g.class)).D();
        ECShopRootFrameLayout r12 = null;
        if (r11 == null) goto L20;
        if (r9 == null) goto L14;
        boolean r13 = true;
    L15:
        if (r13 == true) goto L18;
        r11 = null;
    L18:
        if (r11 == null) goto L20;
        Intrinsics.checkNotNull(r9);
        r11.b(r9);
        goto L20
    L14:
        r13 = false;
    L20:
        this.x = null;
        ECShopRootFrameLayout r14 = y();
        if ((r14 instanceof ECShopRootFrameLayout) == false) goto L24;
        r12 = r14;
    L24:
        ECShopRootFrameLayout r15 = r12;
        if (r15 == null) goto L27;
        com.bytedance.android.shopping.store.home.presenter.a r16 = new com.bytedance.android.shopping.store.home.presenter.a(this);
        Intrinsics.checkNotNullParameter(r16, "listener");
        r15.d.add(r16);
    L27:
        r0();
        T().getCroppedState().a(W(), new l(this), false);
        T().getShopStatus().a(W(), new m(this), false);
        T().getUpglideFactor().a(W(), new n(this), false);
    }

    public static final void q0(ECShopAbilityPresenter r8, int r9) {
        if (r9 == r8.A) goto L7;
        r8.A = r9;
        Event r10 = new Event("ecom.shop.state_change", System.currentTimeMillis(), null, 4, null);
        r10.setMapParams(MapsKt.mapOf(TuplesKt.to("state", Integer.valueOf(r9))));
        EventCenter.enqueueEvent(r10);
        return;
    }
}
