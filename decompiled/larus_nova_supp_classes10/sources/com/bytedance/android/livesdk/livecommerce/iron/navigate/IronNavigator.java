package com.bytedance.android.livesdk.livecommerce.iron.navigate;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.Window;
import com.bytedance.android.btm.api.BtmSDK;
import com.bytedance.android.btm.api.model.PageFinder;
import com.bytedance.android.ec.common.api.jump.model.f;
import com.bytedance.android.ec.core.monitor.MetricNames;
import com.bytedance.android.ec.core.utils.a2;
import com.bytedance.android.ec.core.utils.l0;
import com.bytedance.android.ec.core.utils.z1;
import com.bytedance.android.ec.model.g;
import com.bytedance.android.ec.sdk.helper.l;
import com.bytedance.android.livesdk.livecommerce.event.ECEventUtilsV2;
import com.bytedance.android.livesdk.livecommerce.opt.ECLivePerformanceMonitor;
import com.bytedance.android.livesdk.livecommerce.promotion.cardV2.tracker.LiveActionTracker;
import com.bytedance.android.livesdk.livecommerce.room.controller.business.EntryController;
import com.bytedance.android.livesdk.livecommerce.room.controller.business.RoomContextController;
import com.bytedance.android.livesdk.livecommerce.room.store.ECContext;
import com.bytedance.android.livesdk.livecommerce.utils.ECEnterRoomJumpLogUtils;
import com.bytedance.live.datacontext.i;
import com.larus.utils.logger.FLogger;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import io.reactivex.android.schedulers.AndroidSchedulers;
import java.util.List;
import java.util.Map;
import jf.e;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import org.json.JSONObject;
import vi2.h;
import vj2.d;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class IronNavigator {
    public static final IronNavigator a = null;

    public static final class a implements yk.a {
        public final /* synthetic */ String a;

        public a(String r1) {
            this.a = r1;
        }

        public final <T extends g> void a(String r2, T r3) {
            Intrinsics.checkNotNullParameter(r2, "path");
            IronNavigator.a.getClass();
            l.a(new IronNavigator$logOnNetworkRequestSuccess$1(r2, r3));
            ECEnterRoomJumpLogUtils.b(r2, true, null);
        }

        public final void onFailure(String r4, Throwable r5) {
            Intrinsics.checkNotNullParameter(r4, "path");
            IronNavigator.a(IronNavigator.a, this.a, r4, "ec_live_detail", r5);
        }
    }

    public IronNavigator() {
    }

    static {
        a = new IronNavigator();
    }

    public static com.bytedance.android.ec.common.api.jump.model.g b(RoomContextController r10, Context r11, JSONObject r12, ql.a r13) {
        com.bytedance.android.ec.common.api.jump.model.b r14 = r10.l();
        if (r14 != null) goto L5;
        r14 = com.bytedance.android.ec.common.api.jump.model.b.a;
    L5:
        KClass r0 = Reflection.getOrCreateKotlinClass(f.class);
        Activity r15 = l0.b(r11);
        if (r15 == null) goto L16;
        Window r16 = r15.getWindow();
        if (r16 == null) goto L16;
        View r17 = r16.getDecorView();
        if (com.larus.home.impl.utils.c.e == false) goto L14;
        FLogger.a.i("DecorViewLancet", "getDecorView");
        Thread r1 = ThreadMethodProxy.currentThread();
        if (r1 == com.larus.home.impl.utils.c.a) goto L14;
        com.larus.home.impl.utils.c.a(r1, "getDecorView");
    L14:
        if (r17 == null) goto L16;
        String r18 = BtmSDK.INSTANCE.getPageId(PageFinder.via(r17));
    L17:
        String r3 = r18;
        jf.b.k r4 = jf.b.k.b;
        e.g r5 = e.g.b;
        JSONObject r7 = new JSONObject();
        if (r12 == null) goto L20;
        z1.b(r7, r12);
    L20:
        r7.put("carrier_type", "schema");
        r7.put("live_list_channel", "schema");
        Unit r19 = Unit.INSTANCE;
        return r14.buildParams(r0, new f.a("c0.d0", r3, r4, r5, "schema", r7, null, 64)).buildParams(Reflection.getOrCreateKotlinClass(com.bytedance.android.ec.common.api.jump.model.g.class), new com.bytedance.android.ec.common.api.jump.model.g.a(r13));
    L16:
        r18 = null;
        goto L17
    }

    public static void c(final String r1, final String r2, final String r3, final JSONObject r4) {
        l.a(new IronNavigator$checkParamsForPromotionList$1(r1, r2, r3, r4));
    }

    public static final void a(IronNavigator r2, String r3, final String r4, String r5, final Throwable r6) {
        r2.getClass();
        l.a(new IronNavigator$logOnNetworkRequestFailed$1(r4, r6));
        int r7 = ECEnterRoomJumpLogUtils.a;
        String r8 = null;
        if (r6 == null) goto L5;
        String r0 = r6.getMessage();
    L6:
        ECEnterRoomJumpLogUtils.b(r4, false, r0);
        StringBuilder r1 = new StringBuilder("network req failed, path: ");
        r1.append(r4);
        r1.append(", msg: ");
        if (r6 == null) goto L9;
        r8 = r6.getMessage();
    L9:
        r1.append(r8);
        ECEnterRoomJumpLogUtils.e(r3, r5, r1.toString());
        return;
    L5:
        r0 = null;
        goto L6
    }

    public static void d(String r29, String r30, String r31, String r32, String r33, bk2.b r34, yk.a r35, LiveActionTracker r36, Function1 r37) {
        int r1 = RoomContextController.h;
        RoomContextController r2 = RoomContextController.a.a();
        ECContext r4 = RoomContextController.a.a().r();
        List r5 = null;
        if (r4 == null) goto L14;
        i<ECLivePerformanceMonitor> r6 = r4.getEcLivePerformanceMonitor();
        if (r6 == null) goto L14;
        ECLivePerformanceMonitor r7 = (ECLivePerformanceMonitor) r6.getValue();
        if (r7 == null) goto L14;
        String r8 = r7.s;
        if (r8 == null) goto L14;
        if (r7.d == true) goto L14;
        Map r9 = com.bytedance.android.ec.core.monitor.c.a;
        com.bytedance.android.ec.core.monitor.c.h(r8, MetricNames.GET_API_DURATION, null);
    L14:
        if (r29 == null) goto L16;
        List r13 = CollectionsKt.listOf(new d(null, r29, r31, 1));
    L18:
        if (r30 == null) goto L20;
        r5 = CollectionsKt.listOf(new d(r30, null, r31, 2));
    L20:
        List r14 = r5;
        if (r36 == null) goto L23;
        il2.a.C0145a.a(r36, "req_get", MapsKt.mapOf(new Pair[]{TuplesKt.to("use_promotion_v2", Boolean.TRUE), TuplesKt.to("promotion_id", r29), TuplesKt.to("product_id", r30), TuplesKt.to("sku_id", r31)}), false, null, null, null, 60);
    L23:
        String r15 = r2.y();
        String r16 = r2.z();
        String r17 = r2.B();
        String r18 = r2.D();
        String r19 = r2.B();
        if (r13 != null) goto L26;
        List r21 = r14;
    L27:
        bk2.c.a(h.k(r15, r16, r17, r18, r19, r32, r21, r33, 31, 73, null, true, null, null).observeOn(AndroidSchedulers.mainThread()).subscribe(new com.bytedance.android.livesdk.livecommerce.iron.navigate.a(r36, r29, r30, r37, r35), new b(r36, r35)), r34);
        return;
    L26:
        r21 = r13;
        goto L27
    L16:
        r13 = null;
        goto L18
    }

    public static void e(final Context r16, final String r17, final String r18, String r19, String r20, final String r21, final String r22, final com.bytedance.android.btm.api.model.d r23, final bk2.b r24) {
        Intrinsics.checkNotNullParameter(r18, "roomId");
        Intrinsics.checkNotNullParameter(r19, "anchorId");
        Intrinsics.checkNotNullParameter(r20, "anchorSecId");
        Intrinsics.checkNotNullParameter(r23, "btmModel");
        Intrinsics.checkNotNullParameter(r24, "disposableContext");
        boolean r0 = EntryController.M1;
        final String r1 = null;
        final LiveActionTracker r8 = EntryController.a.b(r18, null).K().a("livesdk_enter_room", r23);
        l.a(new IronNavigator$checkParamsForOrderOrSKU$1(r17, r1, r21, r22));
        d(r17, null, null, ECEventUtilsV2.c(ECEventUtilsV2.b, "schema", "schema", r21), r22, r24, new c(r18), r8, new IronNavigator$goToBuyById$2(r16, r18, r21, r23, r24, r8));
    }

    public static /* synthetic */ void g(Context r11, String r12, String r13, String r14, JSONObject r15, JSONObject r16, String r17, com.bytedance.android.btm.api.model.d r18, bk2.b r19) {
        f(r11, r12, r13, r14, null, r15, r16, r17, r18, r19, false);
    }

    @JvmStatic
    public static final void f(final Context r17, final String r18, final String r19, final String r20, final String r21, final JSONObject r22, final JSONObject r23, final String r24, final com.bytedance.android.btm.api.model.d r25, final bk2.b r26, final boolean r27) {
        Intrinsics.checkNotNullParameter(r25, "btmModel");
        Intrinsics.checkNotNullParameter(r26, "disposableContext");
        boolean r0 = EntryController.M1;
        final LiveActionTracker r13 = EntryController.a.b(r18, null).K().a("livesdk_enter_room", null);
        a.getClass();
        l.a(new IronNavigator$checkParamsForPDP$1(r19, r20, r21, r22, r23, r24));
        if (r19 != null) goto L11;
        if (r20 != null) goto L11;
        ECEnterRoomJumpLogUtils.e(r18, "ec_live_detail", "no promotion_id or product_id parameter is passed.");
        if (r13 == null) goto L19;
        il2.a r1 = il2.a.C0145a.a(r13, "open_product_detail", null, false, "promotion_id_is_null", null, null, 48);
        if (r1 == null) goto L20;
        ((LiveActionTracker) r1).e(false);
        return;
    L20:
        return;
    L19:
        return;
    L11:
        if (r23 == null) goto L16;
        String r2 = r23.optString("ecom_entrance_form");
        if (r2 == null) goto L16;
        String r3 = a2.d(r2);
        if (r3 == null) goto L16;
    L17:
        ECEventUtilsV2.b.getClass();
        d(r19, r20, r21, ECEventUtilsV2.e(r3), r24, r26, new a(r18), r13, new IronNavigator$openSpecificGoodDetail$2(r17, r18, r21, r27, r22, r23, r25, r26, r13));
        return;
    L16:
        r3 = "live_auto";
        goto L17
    }
}
