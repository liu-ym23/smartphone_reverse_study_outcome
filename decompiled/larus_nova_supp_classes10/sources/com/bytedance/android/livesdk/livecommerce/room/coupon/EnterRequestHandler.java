package com.bytedance.android.livesdk.livecommerce.room.coupon;

import com.bytedance.android.ec.core.hybrid.utils.ECLiveHybridUtil;
import com.bytedance.android.ec.core.monitor.ECExceptionMonitor;
import com.bytedance.android.ec.core.utils.u0;
import com.bytedance.android.ec.model.response.IconItem;
import com.bytedance.android.ec.model.response.IconShowStrategy;
import com.bytedance.android.ec.model.response.LocalIconState;
import com.bytedance.android.ec.model.response.TimeLimitScope;
import com.bytedance.android.ec.model.response.r;
import com.bytedance.android.ec.sdk.helper.q;
import com.bytedance.android.livesdk.livecommerce.ab.ECLiveABUtils;
import com.bytedance.android.livesdk.livecommerce.event.t0;
import com.bytedance.android.livesdk.livecommerce.event.v0;
import com.bytedance.android.livesdk.livecommerce.utils.UtilityKotlinExtentionsKt;
import java.util.Calendar;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Deprecated;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import org.json.JSONArray;
import org.json.JSONObject;
import ti.j;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class EnterRequestHandler {
    public static final Lazy a = null;
    public static volatile LocalEnterRoomInfoState b;
    public static volatile r c;
    public static IconItem d;
    public static final Lazy e = null;
    public static final EnterRequestHandler f = null;

    public static final class a implements j {
        public a() {
        }

        public final void a(JSONObject r7) {
            Intrinsics.checkNotNullParameter(r7, "params");
            dm.a.a("EnterRequestHandler").i("receive event, params = " + r7);
            Lazy r0 = EnterRequestHandler.a;
            String r1 = r7.optString("limit_key");
            boolean r2 = r7.optBoolean("is_single_room");
            long r3 = r7.optLong("expired_timestamp");
            r r8 = EnterRequestHandler.c;
            if (r8 == null) goto L21;
            com.bytedance.android.ec.model.response.e r9 = r8.b();
            if (r9 == null) goto L21;
            List r10 = r9.a();
            if (r10 == null) goto L21;
            Iterator r11 = r10.iterator();
        L10:
            if (r11.hasNext() == false) goto L21;
            LocalIconState r4 = ((IconItem) r11.next()).getLocalIconState();
            if (r4 == null) goto L10;
            if (Intrinsics.areEqual(r4.getLimitKey(), r1) == true) goto L17;
            r4 = null;
        L17:
            if (r4 == null) goto L10;
            if (r2 == true) goto L19;
            r4.setSkipTimestamp(r3);
            goto L10
        L19:
            r4.setCurRoomSkipTimestamp(r3);
        L21:
            EnterRequestHandler.l(EnterRequestHandler.b);
        }
    }

    public EnterRequestHandler() {
    }

    static {
        f = new EnterRequestHandler();
        a = LazyKt.lazy(EnterRequestHandler$KEY_LOCAL_STATE_SP_NAME$2.INSTANCE);
        e = LazyKt.lazy(EnterRequestHandler$calendar$2.INSTANCE);
        ECLiveHybridUtil.m("ecom.event.cart.cancel_anim", new a());
    }

    public static final LocalEnterRoomInfoState c() {
        EnterRequestHandler r0 = f;
        monitor-enter(r0);
        LocalEnterRoomInfoState r1 = b;     // Catch: Throwable -> L15
        if (r1 == null) goto L18;
    L10:
        if (r1 != null) goto L12;
        r1 = new LocalEnterRoomInfoState();     // Catch: Throwable -> L15
    L12:
        b = r1;     // Catch: Throwable -> L15
        monitor-exit(r0);
        return r1;
    L18:
        r1 = (LocalEnterRoomInfoState) u0.b(q.a.getString((String) a.getValue(), ""), LocalEnterRoomInfoState.class);     // Catch: Exception -> L8 Throwable -> L15
    L8:
        e = move-exception;
        ECExceptionMonitor.e(e);     // Catch: Throwable -> L15
        r1 = null;
    L15:
        th = move-exception;
        throw th;
    }

    public static void e() {
        r r0 = c;
        if (r0 == null) goto L12;
        com.bytedance.android.ec.model.response.e r1 = r0.b();
        if (r1 == null) goto L12;
        List r2 = r1.a();
        if (r2 == null) goto L12;
        Iterator r3 = r2.iterator();
    L10:
        if (r3.hasNext() == false) goto L12;
        IconItem r4 = (IconItem) r3.next();
        UtilityKotlinExtentionsKt.f(r4.getLocalIconState(), r4.getShowStrategy(), EnterRequestHandler$clickCart$1$1.INSTANCE);
    L12:
        l(b);
    }

    @Deprecated(message = "should use consumeCartIconV2() instead")
    public static String f() {
        IconItem r0 = d;
        if (r0 != null) goto L5;
    L11:
        final Ref.ObjectRef r1 = new Ref.ObjectRef();
        r1.element = null;
        r r2 = c;
        if (r2 == null) goto L22;
        com.bytedance.android.ec.model.response.e r3 = r2.b();
        if (r3 == null) goto L22;
        List r4 = r3.a();
        if (r4 == null) goto L22;
        Iterator r5 = r4.iterator();
    L19:
        if (r5.hasNext() == false) goto L22;
        final IconItem r6 = (IconItem) r5.next();
        UtilityKotlinExtentionsKt.f(r6.getLocalIconState(), r6.getShowStrategy(), new EnterRequestHandler$consumeCartIcon$$inlined$apply$lambda$1(r6, r1));
        if (cg4.a.a((String) r1.element) == false) goto L19;
    L22:
        l(b);
        return (String) r1.element;
    L5:
        if (cg4.a.a(r0.getAnimatedIcon()) == true) goto L8;
        r0 = null;
    L8:
        if (r0 == null) goto L11;
        d = null;
        m(r0);
        return r0.getAnimatedIcon();
    }

    public static IconItem g() {
        EnterRequestHandler$consumeCartIconV2$1 r0 = EnterRequestHandler$consumeCartIconV2$1.INSTANCE;
        IconItem r1 = d;
        if (r1 != null) goto L5;
    L11:
        final Ref.ObjectRef r2 = new Ref.ObjectRef();
        r2.element = null;
        r r3 = c;
        if (r3 == null) goto L22;
        com.bytedance.android.ec.model.response.e r4 = r3.b();
        if (r4 == null) goto L22;
        List r5 = r4.a();
        if (r5 == null) goto L22;
        Iterator r6 = r5.iterator();
    L19:
        if (r6.hasNext() == false) goto L22;
        final IconItem r7 = (IconItem) r6.next();
        UtilityKotlinExtentionsKt.f(r7.getLocalIconState(), r7.getShowStrategy(), new EnterRequestHandler$consumeCartIconV2$$inlined$apply$lambda$1(r7, r2));
        if (EnterRequestHandler$consumeCartIconV2$1.INSTANCE.invoke((IconItem) r2.element) == false) goto L19;
    L22:
        l(b);
        return (IconItem) r2.element;
    L5:
        if (EnterRequestHandler$consumeCartIconV2$1.INSTANCE.invoke(r1) == true) goto L8;
        r1 = null;
    L8:
        if (r1 == null) goto L11;
        d = null;
        m(r1);
        return r1;
    }

    public static JSONObject h() {
        LocalEnterRoomInfoState r0 = b;
        JSONObject r1 = null;
        if (r0 == null) goto L37;
        Map<String, LocalIconState> r2 = r0.getIconMap();
        if (r2 == null) goto L37;
        LinkedHashMap r3 = new LinkedHashMap();
        Iterator<Map.Entry<String, LocalIconState>> r4 = r2.entrySet().iterator();
    L7:
        boolean r5 = true;
        if (r4.hasNext() == false) goto L20;
        Map.Entry<String, LocalIconState> r6 = r4.next();
        if (r6 == null) goto L16;
        LocalIconState r7 = r6.getValue();
        if (r7 == null) goto L16;
        if (r7.isOutOfTimes() != true) goto L16;
    L17:
        if (r5 == false) goto L7;
        r3.put(r6.getKey(), r6.getValue());
    L16:
        r5 = false;
        goto L17
    L20:
        if ((!r3.isEmpty()) == true) goto L23;
        r3 = null;
    L23:
        if (r3 == null) goto L37;
        r1 = new JSONObject();
        JSONArray r8 = new JSONArray();
        Iterator r9 = r3.entrySet().iterator();
    L26:
        if (r9.hasNext() == false) goto L38;
        Map.Entry r10 = (Map.Entry) r9.next();
        Result.Companion r11 = Result.Companion;     // Catch: Throwable -> L30
        Result.constructor-impl(r8.put(new JSONObject().put("business_key", ((LocalIconState) r10.getValue()).getBusinessKey()).put("icon_key", ((LocalIconState) r10.getValue()).getIconKey())));     // Catch: Throwable -> L30
    L30:
        th = move-exception;
        Result.Companion r12 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
        goto L26
    L38:
        Result.Companion r13 = Result.Companion;     // Catch: Throwable -> L34
        Object r14 = Result.constructor-impl(r1.put("limited_cart_icons", r8));     // Catch: Throwable -> L34
    L36:
        Result.box-impl(r14);
    L34:
        th = move-exception;
        Result.Companion r15 = Result.Companion;
        r14 = Result.constructor-impl(ResultKt.createFailure(th));
    L37:
        return r1;
    }

    public static final void a(LocalEnterRoomInfoState r6) {
        long r0 = System.currentTimeMillis() / ((long) 1000);
        Map<String, LocalIconState> r7 = r6.getIconMap();
        if (r7 == null) goto L13;
        Iterator<Map.Entry<String, LocalIconState>> r8 = r7.entrySet().iterator();
    L6:
        if (r8.hasNext() == false) goto L21;
        Map.Entry<String, LocalIconState> r2 = r8.next();
        if (r0 <= r2.getValue().getExpiredTimestamp()) goto L12;
        if (r0 <= r2.getValue().getSkipTimestamp()) goto L12;
        r8.remove();
    L12:
        r2.getValue().setCurRoomTimes(0);
        r2.getValue().setCurRoomSkipTimestamp(0);
        goto L6
    L21:
        return;
    }

    public static final void d(LocalEnterRoomInfoState r2) {
        if (r2 == null) goto L5;
        q.a.putString((String) a.getValue(), u0.d(r2));
        return;
    }

    public static long k(TimeLimitScope r6) {
        if (r6 == null) goto L4;
        Long r0 = r6.getPeriod();
    L5:
        if (r0 == null) goto L11;
        r0.longValue();
        long r1 = System.currentTimeMillis() / ((long) 1000);
        if (r6.isNaturalTime() == false) goto L9;
        Lazy r7 = e;
        ((Calendar) r7.getValue()).setTimeInMillis(r1);
        int r3 = ((Calendar) r7.getValue()).get(11);
        int r4 = ((Calendar) r7.getValue()).get(12);
        int r5 = ((r3 * 60) + r4) * 60;
        r1 = r1 - ((long) (r5 + ((Calendar) r7.getValue()).get(13)));
        long r8 = r0.longValue();
    L13:
        return r1 + r8;
    L9:
        r8 = r0.longValue();
        goto L13
    L11:
        return 0;
    L4:
        r0 = null;
        goto L5
    }

    public static void l(final LocalEnterRoomInfoState r1) {
        UtilityKotlinExtentionsKt.i(new EnterRequestHandler$setLocalStateAsync$1(r1));
    }

    public static void m(IconItem r5) {
        t0 r0 = new t0("livesdk_coupon_effect_show");
        String r1 = r5.getBusinessKey();
        String r2 = "";
        if (r1 != null) goto L5;
        r1 = "";
    L5:
        r0.f("business_key", r1);
        String r3 = r5.getIconKey();
        if (r3 != null) goto L8;
        r3 = "";
    L8:
        r0.f("icon_key", r3);
        r0.k();
        v0 r4 = new v0("live_coupon_effect_show");
        r4.o();
        Pair[] r6 = new Pair[3];
        Map r7 = r5.getReportParams();
        if (r7 == null) goto L12;
        String r8 = (String) r7.get("anchor_id");
        if (r8 == null) goto L12;
    L13:
        r6[0] = TuplesKt.to("anchor_id", r8);
        Map r9 = r5.getReportParams();
        if (r9 == null) goto L17;
        String r10 = (String) r9.get("room_id");
        if (r10 == null) goto L17;
    L18:
        r6[1] = TuplesKt.to("room_id", r10);
        String r11 = r5.getAnimatedIcon();
        if (r11 != null) goto L21;
        r11 = "";
    L21:
        r6[2] = TuplesKt.to("image_url", r11);
        r4.n(MapsKt.mapOf(r6));
        Map r12 = r5.getReportParams();
        if (r12 == null) goto L25;
        String r13 = (String) r12.get("creative_id");
        if (r13 == null) goto L25;
    L26:
        Intrinsics.checkNotNullParameter(r13, "creativeId");
        r4.f("value", r13);
        Map r14 = r5.getReportParams();
        if (r14 == null) goto L32;
        String r15 = (String) r14.get("log_extra");
        if (r15 == null) goto L32;
        r2 = r15;
    L32:
        Intrinsics.checkNotNullParameter(r2, "logExtra");
        r4.f("log_extra", r2);
        r4.k();
        return;
    L25:
        r13 = "";
    L17:
        r10 = "";
    L12:
        r8 = "";
        goto L13
    }

    public static void i(final r r1, final com.bytedance.android.ec.adapter.api.state.a r2) {
        Intrinsics.checkNotNullParameter(r1, "response");
        Intrinsics.checkNotNullParameter(r2, "roomState");
        c = null;
        if (ECLiveABUtils.INSTANCE.getEC_LIVE_SHOPPING_CART_NEW().booleanValue() == false) goto L6;
        UtilityKotlinExtentionsKt.i(EnterRequestHandler$handleResponse$1.INSTANCE);
    L6:
        if (r1.a() == null) goto L8;
    L10:
        UtilityKotlinExtentionsKt.i(new EnterRequestHandler$handleResponse$2(r1, r2));
        return;
    L8:
        if (r1.b() != null) goto L10;
    }

    public static void j(final r r2, final Map r3) {
        Intrinsics.checkNotNullParameter(r2, "response");
        Intrinsics.checkNotNullParameter(r3, "reportParams");
        if (ECLiveABUtils.INSTANCE.getEC_LIVE_SHOPPING_CART_NEW().booleanValue() == true) goto L5;
        return;
    L5:
        com.bytedance.android.ec.model.response.e r0 = r2.b();
        if (r0 == null) goto L12;
        final List r1 = r0.a();
        if (r1 == null) goto L13;
        UtilityKotlinExtentionsKt.i(new EnterRequestHandler$handleSupplementResponse$1(r2, r3, r1));
        return;
    L13:
        return;
    }

    public static final void b(LocalEnterRoomInfoState r6, r r7, Map r8) {
        EnterRequestHandler r0 = f;
        monitor-enter(r0);
        com.bytedance.android.ec.model.response.e r9 = r7.b();     // Catch: Throwable -> L50
        if (r9 == null) goto L48;
        List r10 = r9.a();     // Catch: Throwable -> L50
        if (r10 == null) goto L48;
        Iterator r11 = r10.iterator();     // Catch: Throwable -> L50
    L9:
        if (r11.hasNext() == false) goto L48;
        IconItem r1 = (IconItem) r11.next();     // Catch: Throwable -> L50
        Map<String, LocalIconState> r2 = r6.getIconMap();     // Catch: Throwable -> L50
        String r3 = null;
        if (r2 == null) goto L18;
        IconShowStrategy r4 = r1.getShowStrategy();     // Catch: Throwable -> L50
        if (r4 == null) goto L16;
        String r5 = r4.getLimitKey();     // Catch: Throwable -> L50
    L17:
        LocalIconState r12 = r2.get(r5);     // Catch: Throwable -> L50
    L19:
        IconShowStrategy r13 = r1.getShowStrategy();     // Catch: Throwable -> L50
        if (r13 == null) goto L22;
        String r14 = r13.getLimitKey();     // Catch: Throwable -> L50
    L24:
        if (cg4.a.a(r14) == false) goto L46;
        if (r12 != null) goto L45;
        r12 = new LocalIconState();     // Catch: Throwable -> L50
        IconShowStrategy r15 = r1.getShowStrategy();     // Catch: Throwable -> L50
        if (r15 == null) goto L29;
        TimeLimitScope r16 = r15.getTimesLimitScope();     // Catch: Throwable -> L50
    L30:
        r12.setExpiredTimestamp(k(r16));     // Catch: Throwable -> L50
        IconShowStrategy r17 = r1.getShowStrategy();     // Catch: Throwable -> L50
        if (r17 == null) goto L33;
        String r18 = r17.getLimitKey();     // Catch: Throwable -> L50
    L34:
        r12.setLimitKey(r18);     // Catch: Throwable -> L50
        if (r6.getIconMap() != null) goto L37;
        r6.setIconMap(new LinkedHashMap());     // Catch: Throwable -> L50
    L37:
        Map<String, LocalIconState> r19 = r6.getIconMap();     // Catch: Throwable -> L50
        if (r19 == null) goto L45;
        IconShowStrategy r20 = r1.getShowStrategy();     // Catch: Throwable -> L50
        if (r20 == null) goto L42;
        r3 = r20.getLimitKey();     // Catch: Throwable -> L50
    L42:
        if (r3 != null) goto L44;
        r3 = "";
    L44:
        LocalIconState r21 = r19.put(r3, r12);     // Catch: Throwable -> L50
        goto L45
    L33:
        r18 = null;
        goto L34
    L29:
        r16 = null;
    L45:
        r12.setBusinessKey(r1.getBusinessKey());     // Catch: Throwable -> L50
        r12.setIconKey(r1.getIconKey());     // Catch: Throwable -> L50
        r1.setLocalIconState(r12);     // Catch: Throwable -> L50
    L46:
        r1.setReportParams(r8);     // Catch: Throwable -> L50
        goto L9
    L22:
        r14 = null;
        goto L24
    L16:
        r5 = null;
        goto L17
    L18:
        r12 = null;
    L48:
        monitor-exit(r0);
        return;
    L50:
        th = move-exception;
        throw th;
    }
}
