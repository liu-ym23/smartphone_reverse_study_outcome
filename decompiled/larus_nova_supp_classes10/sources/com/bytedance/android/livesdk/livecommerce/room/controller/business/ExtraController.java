package com.bytedance.android.livesdk.livecommerce.room.controller.business;

import android.content.Context;
import android.net.Uri;
import android.os.Handler;
import com.bytedance.android.ec.adapter.api.IAdapterService;
import com.bytedance.android.ec.core.hybrid.utils.ECLiveHybridUtil;
import com.bytedance.android.ec.core.monitor.ECExceptionMonitor;
import com.bytedance.android.ec.core.utils.s0;
import com.bytedance.android.ec.sdk.ECSdk;
import com.bytedance.android.livesdk.ktvimpl.base.viewmodel.BaseCoreViewModel;
import com.bytedance.android.livesdk.livecommerce.event.l0;
import com.bytedance.android.livesdk.livecommerce.event.s1;
import com.bytedance.android.livesdk.livecommerce.room.controller.ControllerCenter;
import com.bytedance.android.livesdk.livecommerce.room.controller.RealRoomController$roomResources$1;
import com.bytedance.android.livesdk.livecommerce.room.controller.c0;
import com.bytedance.android.livesdk.livecommerce.room.utils.ECLiveEventHelper;
import com.bytedance.android.livesdk.livecommerce.room.utils.ECLiveEventHelper$openOrder$2;
import com.bytedance.android.livesdk.livecommerce.utils.EComABUtils;
import com.bytedance.android.shopping.api.IEShoppingService;
import com.bytedance.bdlocation.exception.BDLocationException;
import com.bytedance.mt.protector.impl.UriProtector;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import java.util.HashMap;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;
import org.json.JSONException;
import org.json.JSONObject;
import vi2.b0;
import xi2.g0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class ExtraController extends c0 {
    public static final Lazy l = null;
    public boolean c;
    public boolean d;
    public int e;
    public boolean f;
    public boolean g;
    public String h;
    public boolean i;
    public boolean j;
    public JSONObject k;

    public static final class a {
    }

    public static final class b<T> implements Consumer {
        public final /* synthetic */ ExtraController a;
        public final /* synthetic */ String b;
        public final /* synthetic */ String c;

        public b(ExtraController r1, String r2, String r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }

        public final void accept(Object r3) {
            ExtraController r0 = this.a;
            int r1 = r0.e + 1;
            r0.e = r1;
            if (((com.bytedance.android.ec.model.g) ((g0) r3)).statusCode != 0) goto L5;
            return;
        L5:
            if (r1 < 3) goto L7;
            return;
        L7:
            if (r0.c == true) goto L12;
            r0.J(this.b, this.c);
            return;
        }
    }

    public static final class c<T> implements Consumer {
        public final /* synthetic */ ExtraController a;
        public final /* synthetic */ String b;
        public final /* synthetic */ String c;

        public c(ExtraController r1, String r2, String r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }

        public final void accept(Object r3) {
            Throwable r4 = (Throwable) r3;
            ExtraController r5 = this.a;
            int r0 = r5.e + 1;
            r5.e = r0;
            if (r0 < 3) goto L5;
            return;
        L5:
            if (r5.c == true) goto L9;
            r5.J(this.b, this.c);
            return;
        }
    }

    @Override // com.bytedance.android.livesdk.livecommerce.room.controller.c0
    public final void G() {
        this.k = null;
    }

    @Override // com.bytedance.android.livesdk.livecommerce.room.controller.c0, com.bytedance.android.livesdk.livecommerce.room.api.b
    public final void onStart() {
        this.i = true;
        if ((true ^ Intrinsics.areEqual(B(), ControllerCenter.c)) == false) goto L6;
        return;
    L6:
        if (this.i == true) goto L8;
        return;
    L8:
        if (this.h != null) goto L10;
        return;
    L10:
        if (u() == false) goto L15;
        Context r1 = m();
        String r2 = this.h;
        Intrinsics.checkNotNull(r2);
        ECLiveHybridUtil.k(r1, r2, false, false, false, null, 252);
        this.h = null;
        return;
    }

    @Override // com.bytedance.android.livesdk.livecommerce.room.controller.c0, com.bytedance.android.livesdk.livecommerce.room.api.b
    public final void onStop() {
        this.i = false;
    }

    static {
        l = LazyKt.lazy(ExtraController$Companion$allowedSceneIdSet$2.INSTANCE);
    }

    public final JSONObject H() {
        if (this.k != null) goto L37;
        int r0 = com.bytedance.android.livesdk.livecommerce.room.controller.w.h;
        JSONObject r1 = l0.p(ControllerCenter.b(A().m).a);
        if (r1 == null) goto L37;
        this.k = r1;
        if (w() == false) goto L23;
        JSONObject r2 = this.k;
        if (r2 == null) goto L23;
        if (r2.has("draw_order") == true) goto L16;
        JSONObject r3 = this.k;
        if (r3 == null) goto L16;
        r3.put("draw_order", C().n.getInt("EXTRA_ROOM_DRAW_INDEX", -1));
    L16:
        if (r2.has("outflow_order") == false) goto L23;
        if (r2.has("click_order") == true) goto L23;
        JSONObject r4 = this.k;
        if (r4 == null) goto L23;
        r4.put("click_order", r2.get("outflow_order"));
    L23:
        if (w() == false) goto L37;
        Map r5 = C().p;
        if (Intrinsics.areEqual("1", (String) r5.get("is_ec_shopping")) == false) goto L37;
        String r6 = (String) r5.get("share_content");
        if (r6 == null) goto L31;
        JSONObject r7 = this.k;
        if (r7 == null) goto L31;
        r7.put("share_content", r6);
    L31:
        String r8 = (String) r5.get("share_object");
        if (r8 == null) goto L37;
        JSONObject r9 = this.k;
        if (r9 == null) goto L37;
        r9.put("share_object", r8);
    L37:
        return this.k;
    }

    @Override // com.bytedance.android.livesdk.livecommerce.room.controller.c0, com.bytedance.android.livesdk.livecommerce.room.api.b
    public final void onCreate() {
        s0.c(this);
        this.c = false;
        this.d = false;
        this.e = 0;
        this.f = false;
    }

    @Override // com.bytedance.android.livesdk.livecommerce.room.controller.c0, com.bytedance.android.livesdk.livecommerce.room.api.b
    public final void onDestroy() {
        super.onDestroy();
        s0.e(this);
        this.c = true;
        int r0 = ECSdk.a;
        IEShoppingService r1 = (IEShoppingService) ECSdk.a(IEShoppingService.class);
        if (r1 == null) goto L6;
        r1.clearRoomLifecycleData();
        return;
    }

    @Override // com.bytedance.android.livesdk.livecommerce.room.controller.c0, com.bytedance.android.livesdk.livecommerce.room.api.b
    public final void onExitRoom() {
        super.onExitRoom();
        s0.e(this);
        ECLiveEventHelper r0 = ECLiveEventHelper.m;
        dm.a.a("ECLiveEventHelper").a("unRegisterOrderAndSkuJsEvent");
        ECLiveHybridUtil.p("openOrder", (ECLiveEventHelper$openOrder$2.AnonymousClass1) ECLiveEventHelper.e.getValue());
        ECLiveHybridUtil.p("ec.live.jump_dispatcher.handle_click", ECLiveEventHelper.l);
        s0.e(r0);
        ECLiveHybridUtil.p("ecom.sku.buynow", ECLiveEventHelper.i);
        ECLiveHybridUtil.p("ecom.sku.add.cart", ECLiveEventHelper.f);
        ECLiveHybridUtil.p("ecom.sku.dismiss", ECLiveEventHelper.g);
        ECLiveHybridUtil.p("ecom.sku.spec.change", ECLiveEventHelper.h);
        ECLiveEventHelper.d = false;
        ECLiveEventHelper.a = null;
        ECLiveEventHelper.b = null;
        ECLiveEventHelper.c = null;
        ((bk2.b) ECLiveEventHelper.j.getValue()).clearDisposable();
        Boolean r2 = com.bytedance.android.livesdk.livecommerce.utils.n.a;
        int r3 = ECSdk.a;
        IAdapterService r4 = (IAdapterService) ECSdk.a(IAdapterService.class);
        if (r4 == null) goto L5;
        r4.unregisterPerformanceStrategyTask();
    L5:
        this.h = null;
        this.g = false;
    }

    @Override // com.bytedance.android.livesdk.livecommerce.room.controller.c0, com.bytedance.android.livesdk.livecommerce.room.api.b
    public final void onWidgetLoadFinished() {
        Context r10 = m();
        com.bytedance.android.ec.adapter.api.state.a r6 = C();
        if (r6 != null) goto L6;
    L50:
        I(m(), C(), false);
        ECLiveEventHelper r0 = ECLiveEventHelper.m;
        dm.a.a("ECLiveEventHelper").a("registerOrderAndSkuJsEvent");
        if (ECLiveEventHelper.d == true) goto L53;
        ECLiveHybridUtil.m("openOrder", (ECLiveEventHelper$openOrder$2.AnonymousClass1) ECLiveEventHelper.e.getValue());
        ECLiveHybridUtil.n("ec.live.jump_dispatcher.handle_click", ECLiveEventHelper.l);
        s0.c(r0);
        ECLiveHybridUtil.m("ecom.sku.buynow", ECLiveEventHelper.i);
        ECLiveHybridUtil.m("ecom.sku.add.cart", ECLiveEventHelper.f);
        ECLiveHybridUtil.m("ecom.sku.dismiss", ECLiveEventHelper.g);
        ECLiveHybridUtil.m("ecom.sku.spec.change", ECLiveEventHelper.h);
        ECLiveEventHelper.d = true;
    L53:
        Boolean r1 = com.bytedance.android.livesdk.livecommerce.utils.n.a;
        if (((Boolean) EComABUtils.getLiveSettingValue("live_ecom_trigger_degrade_enable", Boolean.FALSE)).booleanValue() == true) goto L58;
        int r2 = ECSdk.a;
        IAdapterService r3 = (IAdapterService) ECSdk.a(IAdapterService.class);
        if (r3 == null) goto L64;
        r3.unregisterPerformanceStrategyTask();
        return;
    L64:
        return;
    L58:
        int r4 = ECSdk.a;
        IAdapterService r5 = (IAdapterService) ECSdk.a(IAdapterService.class);
        if (r5 == null) goto L66;
        r5.registerPerformanceStrategyTask(new com.bytedance.android.livesdk.livecommerce.utils.m());
        return;
    L66:
        return;
    L6:
        if (com.bytedance.android.livesdk.livecommerce.room.model.h.a(r6) == false) goto L8;
        dk2.a.b = new dk2.a();
        HashMap r7 = com.bytedance.android.ec.core.hybrid.utils.j.a;
        com.bytedance.android.ec.core.hybrid.utils.j.h("live_ecom_task_progress", null);
    L20:
        if (v() == true) goto L22;
        int r8 = com.bytedance.android.livesdk.livecommerce.room.controller.w.h;
        JSONObject r9 = com.bytedance.android.livesdk.livecommerce.room.controller.w.a.a(null);
    L23:
        JSONObject r11 = r9;
        String r12 = r11.optString("task_enter_from");
        String r13 = r11.optString("task_type");
        String r14 = r11.optString("task_request_params");
        if (r14.length() <= 0) goto L26;
        boolean r15 = true;
    L27:
        if (r15 == true) goto L30;
        r14 = null;
    L30:
        if (r14 != null) goto L62;
        JSONObject r16 = new JSONObject();
    L37:
        String r17 = r11.optString("extra_params");
        String r18 = r6.f;
        JSONObject r19 = new JSONObject();
        r19.put("roomID", r18);
        String r110 = r19.toString();
        if (r13 != null) goto L40;
    L43:
        boolean r20 = true;
    L44:
        if (r20 == true) goto L50;
        dk2.a r21 = dk2.a.b;
        if (r21 == null) goto L48;
        String r111 = r21.a;
    L49:
        String r22 = vi2.h.a;
        nl2.b.b(vi2.h.e(null, null, si2.g.M, new vi2.c0(r13, r110, r111, r16, r12)).observeOn(AndroidSchedulers.mainThread()).subscribe(new o(this, r12, r13, r18, r6, r17, r16, r10), new p(r10)));
        goto L50
    L48:
        r111 = null;
        goto L49
    L40:
        if (r13.length() == 0) goto L43;
        r20 = false;
        goto L44
    L62:
        JSONObject r23 = new JSONObject(r14);     // Catch: JSONException -> L33
    L35:
        r16 = r23;
    L33:
        e = move-exception;
        ECExceptionMonitor.e(e);
        r23 = new JSONObject();
        goto L35
    L26:
        r15 = false;
        goto L27
    L22:
        r9 = new JSONObject();
        goto L23
    L8:
        HashMap r24 = com.bytedance.android.ec.core.hybrid.utils.j.a;
        JSONObject r25 = com.bytedance.android.ec.core.hybrid.utils.j.d("live_ecom_task_has_finished");
        if (r25 == null) goto L11;
        String r26 = r25.optString("uniqueID");
    L12:
        dk2.a r27 = dk2.a.b;
        if (r27 == null) goto L15;
        String r28 = r27.a;
    L17:
        if (Intrinsics.areEqual(r26, r28) == false) goto L20;
    L15:
        r28 = null;
        goto L17
    L11:
        r26 = null;
        goto L12
    }

    public ExtraController(RealRoomController$roomResources$1 r2) {
        Intrinsics.checkNotNullParameter(r2, "roomResources");
        super(r2);
    }

    @Override // com.bytedance.android.livesdk.livecommerce.room.controller.c0, com.bytedance.android.livesdk.livecommerce.room.api.b
    public final void a(com.bytedance.android.ec.adapter.api.state.a r3) {
        Intrinsics.checkNotNullParameter(r3, BaseCoreViewModel.CORE_TAG_STATE);
        Intrinsics.checkNotNullParameter(r3, BaseCoreViewModel.CORE_TAG_STATE);
        String r0 = (String) r3.p.get("cps_track");
        if (this.d == false) goto L5;
        return;
    L5:
        if (cg4.a.a(r0) == true) goto L7;
        return;
    L7:
        if (this.c == true) goto L12;
        this.d = true;
        J(r3.f, r0);
        return;
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public final void onCloseAnchorV3PageEvent(hl.e r2) {
        Intrinsics.checkNotNullParameter(r2, "event");
        this.h = r2.a;
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public final void onLiveExpandProductDetailPage(hl.j r2) {
        Intrinsics.checkNotNullParameter(r2, "event");
        this.j = r2.a;
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public final void onLiveShowAnchorV3Event(hl.k r2) {
        Intrinsics.checkNotNullParameter(r2, "event");
        throw null;
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public final void onPurchasingIntentionActionEvent(hl.m r2) {
        Intrinsics.checkNotNullParameter(r2, "event");
        q().onPurchasingIntentionAction();
    }

    public final void J(String r4, String r5) {
        String r0 = vi2.h.a;
        nl2.b.b(vi2.h.e(null, null, si2.g.L, new b0(r4, r5)).observeOn(AndroidSchedulers.mainThread()).subscribe(new b(this, r4, r5), new c(this, r4, r5)));
    }

    @Override // com.bytedance.android.livesdk.livecommerce.room.controller.c0, com.bytedance.android.livesdk.livecommerce.room.api.b
    public final void c(Context r3, com.bytedance.android.ec.adapter.api.state.a r4) {
        super.c(r3, r4);
        s0.e(this);
        if (this.f == false) goto L5;
        ECLiveHybridUtil.f("ecomTaskLiveDidFinish", new JSONObject());
    L5:
        if (r3 == null) goto L8;
        I(r3, r4, true);
        return;
    }

    public final void I(Context r3, com.bytedance.android.ec.adapter.api.state.a r4, boolean r5) {
        if (r4 != null) goto L5;
        return;
    L5:
        if (this.g == true) goto L25;
        boolean r0 = true;
        this.g = true;
        String r6 = (String) r4.p.get("common_live_schema");
        if (s() == true) goto L26;
        if (r6 != null) goto L10;
    L13:
        if (r0 == true) goto L27;
        Uri.Builder r7 = UriProtector.parse(r6).buildUpon();     // Catch: Exception -> L20
        if (r5 == false) goto L17;
        String r8 = "1";
    L18:
        r7.appendQueryParameter("is_live_end", r8);     // Catch: Exception -> L20
        String r9 = r7.build().toString();     // Catch: Exception -> L20
        Handler r10 = com.bytedance.android.livesdk.livecommerce.utils.k.a;     // Catch: Exception -> L20
        com.bytedance.android.livesdk.livecommerce.room.f.b(r3, r9);     // Catch: Exception -> L20
        s1 r11 = new s1();     // Catch: Exception -> L20
        r11.f("schema", r9);     // Catch: Exception -> L20
        r11.k();     // Catch: Exception -> L20
        return;
    L17:
        r8 = BDLocationException.ERROR_TIMEOUT;
    L20:
        e = move-exception;
        ECExceptionMonitor.e(e);
        return;
    L27:
        return;
    L10:
        if (r6.length() == 0) goto L13;
        r0 = false;
        goto L13
    L26:
        return;
    }
}
