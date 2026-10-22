package com.bytedance.android.livesdk.livecommerce.room.utils;

import android.content.Context;
import android.view.View;
import com.bytedance.android.btm.api.model.PageFinder;
import com.bytedance.android.ec.core.monitor.ECExceptionMonitor;
import com.bytedance.android.ec.model.response.j0;
import com.bytedance.android.ec.model.sku.SkuRestoreState;
import com.bytedance.android.ec.model.sku.SkuShowAndDismissState;
import com.bytedance.android.livesdk.livecommerce.promotion.cardV2.tracker.LiveActionTracker;
import com.bytedance.android.livesdk.livecommerce.room.controller.business.EntryController;
import com.bytedance.android.livesdk.livecommerce.room.controller.business.RoomContextController;
import com.bytedance.android.livesdk.livecommerce.room.widgets.shoppingcart.ShoppingCart;
import com.bytedance.android.livesdk.livecommerce.utils.m0;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;
import org.json.JSONObject;
import ti.j;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class ECLiveEventHelper {
    public static com.bytedance.android.ec.common.api.jump.model.g a;
    public static jf.d b;
    public static e c;
    public static boolean d;
    public static final Lazy e = null;
    public static final ECLiveEventHelper$skuAddCartEventSubscriber$1 f = null;
    public static final ECLiveEventHelper$skuDismissEventSubscriber$1 g = null;
    public static final ECLiveEventHelper$skuSpecChangeEventSubscriber$1 h = null;
    public static final ECLiveEventHelper$adLogCallbackEventSubscriber$1 i = null;
    public static final Lazy j = null;
    public static final Lazy k = null;
    public static final a l = null;
    public static final ECLiveEventHelper m = null;

    public static final class a implements j {
        public a() {
        }

        public final void a(JSONObject r25) {
            Intrinsics.checkNotNullParameter(r25, "params");
            String r0 = r25.toString();
            Result.Companion r3 = Result.Companion;     // Catch: Throwable -> L5
            int r4 = m0.a;     // Catch: Throwable -> L5
            Object r1 = Result.constructor-impl((com.bytedance.android.livesdk.livecommerce.room.model.b) m0.a.a.fromJson(r0, com.bytedance.android.livesdk.livecommerce.room.model.b.class));     // Catch: Throwable -> L5
        L7:
            Throwable r5 = Result.exceptionOrNull-impl(r1);
            com.bytedance.android.btm.api.model.d r6 = null;
            if (r5 == null) goto L11;
            ECExceptionMonitor.e(r5);
            r1 = null;
        L11:
            com.bytedance.android.livesdk.livecommerce.room.model.b r2 = (com.bytedance.android.livesdk.livecommerce.room.model.b) r1;
            if (r2 != null) goto L14;
            return;
        L14:
            com.bytedance.android.livesdk.livecommerce.room.model.f r7 = r2.g();
            if (r7 == null) goto L17;
            String r8 = r7.e();
        L18:
            com.bytedance.android.livesdk.livecommerce.room.model.f r9 = r2.g();
            if (r9 == null) goto L21;
            String r10 = r9.f();
        L22:
            int r11 = RoomContextController.h;
            RoomContextController r12 = RoomContextController.a.b(r8, r10);
            boolean r13 = EntryController.M1;
            EntryController r14 = EntryController.a.b(r8, r10);
            Context r15 = r12.getContext();
            if (r15 != null) goto L25;
            r15 = com.bytedance.android.ec.sdk.helper.d.b.getIECHostAppInfo().getApplicationContext();
        L25:
            Context r16 = r15;
            LiveActionTracker r17 = r14.K().a("livesdk_live_room", null);
            if (r17 == null) goto L28;
            il2.a.C0145a.a(r17, "recv_live_event_js", MapsKt.mapOf(new Pair[]{TuplesKt.to("params", r25), TuplesKt.to("subscriber", "handle_click")}), false, null, null, null, 60);
        L29:
            if (r16 != null) goto L36;
            if (r17 == null) goto L61;
            il2.a r18 = il2.a.C0145a.a(r17, "check_live_js_event", null, false, "context_is_null", null, null, 48);
            if (r18 == null) goto L62;
            ((LiveActionTracker) r18).e(false);
            return;
        L62:
            return;
        L61:
            return;
        L36:
            if (r2.b() != null) goto L42;
            if (r17 == null) goto L63;
            il2.a r19 = il2.a.C0145a.a(r17, "check_live_js_event", null, false, "action_is_null", null, null, 48);
            if (r19 == null) goto L64;
            ((LiveActionTracker) r19).e(false);
            return;
        L64:
            return;
        L63:
            return;
        L42:
            ShoppingCart r20 = r14.s;
            if (r20 == null) goto L45;
            View r21 = r20.getViewSafe();
        L46:
            PageFinder r22 = PageFinder.via(r21);
            if (r17 == null) goto L49;
            il2.a.C0145a.a(r17, "check_live_js_event", MapsKt.mapOf(TuplesKt.to("action", r2.b())), false, null, null, null, 60);
        L49:
            jf.d r23 = (jf.d) ECLiveEventHelper.k.getValue();
            String r24 = r2.d();
            if (r24 != null) goto L52;
            r24 = "button";
        L52:
            String r26 = r24;
            Integer r27 = r2.e();
            com.bytedance.android.ec.common.api.jump.model.g r110 = com.bytedance.android.livesdk.livecommerce.room.model.b.a(r2, r22);
            j0 r111 = r2.b();
            int r112 = r2.f();
            int r113 = r2.h();
            com.bytedance.android.livesdk.livecommerce.room.model.d r28 = r2.c();
            if (r28 == null) goto L55;
            r6 = r28.c(r22);
        L55:
            if (r17 == null) goto L57;
            r17.g = r6;
        L57:
            Unit r29 = Unit.INSTANCE;
            r23.l(r16, r26, r27, r110, r111, 0, r112, null, r113, r6, r17);
            return;
        L45:
            r21 = null;
            goto L46
        L28:
            r17 = null;
            goto L29
        L21:
            r10 = null;
            goto L22
        L17:
            r8 = null;
        L5:
            th = move-exception;
            Result.Companion r30 = Result.Companion;
            r1 = Result.constructor-impl(ResultKt.createFailure(th));
            goto L7
        }
    }

    public ECLiveEventHelper() {
    }

    /* JADX WARN: Type inference failed for: r0v3, types: [com.bytedance.android.livesdk.livecommerce.room.utils.ECLiveEventHelper$skuAddCartEventSubscriber$1] */
    /* JADX WARN: Type inference failed for: r0v4, types: [com.bytedance.android.livesdk.livecommerce.room.utils.ECLiveEventHelper$skuDismissEventSubscriber$1] */
    /* JADX WARN: Type inference failed for: r0v5, types: [com.bytedance.android.livesdk.livecommerce.room.utils.ECLiveEventHelper$skuSpecChangeEventSubscriber$1] */
    /* JADX WARN: Type inference failed for: r0v6, types: [com.bytedance.android.livesdk.livecommerce.room.utils.ECLiveEventHelper$adLogCallbackEventSubscriber$1] */
    static {
        m = new ECLiveEventHelper();
        e = LazyKt.lazy(ECLiveEventHelper$openOrder$2.INSTANCE);
        f = new ECLiveEventHelper$skuAddCartEventSubscriber$1();
        g = new ECLiveEventHelper$skuDismissEventSubscriber$1();
        h = new ECLiveEventHelper$skuSpecChangeEventSubscriber$1();
        i = new ECLiveEventHelper$adLogCallbackEventSubscriber$1();
        j = LazyKt.lazy(ECLiveEventHelper$disposable$2.INSTANCE);
        k = LazyKt.lazy(ECLiveEventHelper$handleClickJumpDispatcher$2.INSTANCE);
        l = new a();
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public final void onReceiveSkuRestoreStateUpdateEvent(jl.a r5) {
        Intrinsics.checkNotNullParameter(r5, "event");
        if (r5.b.length() <= 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L20;
        SkuRestoreState r1 = r5.a;
        if (r1 == null) goto L21;
        e r2 = c;
        if (r2 != null) goto L12;
        return;
    L12:
        if (Intrinsics.areEqual(r2.d(), r5.b) == true) goto L15;
        r2 = null;
    L15:
        if (r2 == null) goto L23;
        Function1<SkuShowAndDismissState, Unit> r6 = r2.c();
        if (r6 == null) goto L24;
        Unit r7 = (Unit) r6.invoke(new SkuShowAndDismissState(false, r1, new ul.f()));
        return;
    L24:
        return;
    L23:
        return;
    L21:
        return;
    L20:
        return;
    L5:
        r0 = false;
        goto L6
    }

    public static final void a(JSONObject r2, Function2 r3) {
        String r4 = r2.optString("sku_session_id", "");     // Catch: Exception -> L16
        if (r4.length() <= 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L21;
        e r1 = c;     // Catch: Exception -> L16
        if (r1 != null) goto L10;
        return;
    L10:
        if (Intrinsics.areEqual(r1.d(), r4) == true) goto L13;
        r1 = null;
    L13:
        if (r1 == null) goto L23;
        r3.invoke(r4, r1);     // Catch: Exception -> L16
        return;
    L23:
        return;
    L21:
        return;
    L5:
        r0 = false;
    L16:
        e = move-exception;
        ECExceptionMonitor.e(e);
    }
}
