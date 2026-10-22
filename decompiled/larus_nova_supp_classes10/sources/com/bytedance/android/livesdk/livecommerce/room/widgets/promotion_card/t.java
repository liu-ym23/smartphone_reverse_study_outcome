package com.bytedance.android.livesdk.livecommerce.room.widgets.promotion_card;

import android.content.Context;
import android.os.SystemClock;
import com.bytedance.android.ec.core.monitor.MetricNames;
import com.bytedance.android.ec.core.opt.asyncInflate.ShoppingAsyncInflater;
import com.bytedance.android.ec.core.utils.OptCardUtil;
import com.bytedance.android.ec.model.promotion.ECUIPromotion;
import com.bytedance.android.ec.model.response.ECCurrentPromotion;
import com.bytedance.android.livesdk.livecommerce.ab.ECLiveABUtils;
import com.bytedance.android.livesdk.livecommerce.opt.ECLivePerformanceMonitor;
import com.bytedance.android.livesdk.livecommerce.room.controller.business.EntryController;
import com.bytedance.android.livesdk.livecommerce.room.store.ECContext;
import com.bytedance.android.livesdk.livecommerce.utils.EComABUtils;
import com.bytedance.android.livesdk.livecommerce.utils.UtilityKotlinExtentionsKt;
import com.bytedance.bdlocation.exception.BDLocationException;
import java.lang.ref.WeakReference;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class t {
    public static final boolean f = false;
    public static final int g = 0;
    public static final boolean h = false;
    public static final boolean i = false;
    public static final boolean j = false;
    public static final boolean k = false;
    public static final boolean l = false;
    public static final boolean m = false;
    public static final boolean n = false;
    public static final boolean o = false;
    public static boolean p;
    public static Boolean q;
    public volatile ECUIPromotion a;
    public volatile boolean b;
    public volatile boolean c;
    public Function1<? super ECUIPromotion, Unit> d;
    public ECContext e;

    public static final class a {
        public static void a(Context r3) {
            Intrinsics.checkNotNullParameter(r3, "context");
            ShoppingAsyncInflater.a r0 = ShoppingAsyncInflater.e;
            Context r4 = th.a.e(r3, true);
            r0.getClass();
            com.bytedance.android.ec.opt.asyncInflate.d r5 = ShoppingAsyncInflater.a.a(r4).a();
            r5.c(2131560684, 1, "ec_explain_card_uimodule_above");
            r5.c(2131560682, 1, "ec_explain_card_bottom_layout");
            r5.commit();
        }
    }

    public t() {
    }

    static {
        boolean r0 = false;
        if (((Number) EComABUtils.getLiveSettingValue("ecom_live_opt_card_load_2", 0)).intValue() != 1) goto L5;
        boolean r1 = true;
    L6:
        f = r1;
        int r2 = EComABUtils.cardLoadOptV2Request();
        g = r2;
        if (r2 <= 0) goto L9;
        boolean r3 = true;
    L10:
        h = r3;
        if (EComABUtils.cardLoadOptV2Bind() != 1) goto L13;
        boolean r4 = true;
    L14:
        i = r4;
        if (EComABUtils.cardLoadOptV2Show() != 1) goto L17;
        boolean r5 = true;
    L18:
        j = r5;
        if (EComABUtils.cardLoadOptV2CardDoFrame() != 1) goto L21;
        boolean r6 = true;
    L22:
        k = r6;
        if (EComABUtils.cardLoadOptV2PicPreLoad() != 1) goto L25;
        boolean r7 = true;
    L26:
        l = r7;
        if (EComABUtils.cardLoadOptV2PicDoFrame() != 1) goto L29;
        boolean r8 = true;
    L30:
        m = r8;
        if (EComABUtils.cardLoadOptV2Coupon() != 1) goto L33;
        boolean r9 = true;
    L34:
        n = r9;
        if (r3 == true) goto L41;
        if (r4 == true) goto L41;
        if (r5 == true) goto L41;
        if (r6 == true) goto L41;
        if (r7 == true) goto L41;
        if (r8 == true) goto L41;
    L42:
        o = r0;
        return;
    L41:
        r0 = true;
        goto L42
    L33:
        r9 = false;
        goto L34
    L29:
        r8 = false;
        goto L30
    L25:
        r7 = false;
        goto L26
    L21:
        r6 = false;
        goto L22
    L17:
        r5 = false;
        goto L18
    L13:
        r4 = false;
        goto L14
    L9:
        r3 = false;
        goto L10
    L5:
        r1 = false;
        goto L6
    }

    @JvmStatic
    public static final void a(String r1, String r2, boolean r3, ECCurrentPromotion r4) {
        Intrinsics.checkNotNullParameter(r1, "roomId");
        Intrinsics.checkNotNullParameter(r2, "rooUniqueKey");
        if (r3 == false) goto L38;
        if (r4 == null) goto L39;
        boolean r5 = EntryController.M1;
        t r6 = EntryController.a.b(r1, r2).T;
        if (r6 == null) goto L40;
        Intrinsics.checkNotNullParameter(r4, "currentPromotion");
        if (h == true) goto L10;
        return;
    L10:
        if (r6.c == false) goto L42;
        ECContext r7 = r6.e;
        if (r7 != null) goto L14;
    L16:
        ECContext r8 = r6.e;
        if (r8 == null) goto L23;
        com.bytedance.live.datacontext.i<ECLivePerformanceMonitor> r9 = r8.getEcLivePerformanceMonitor();
        if (r9 == null) goto L23;
        ECLivePerformanceMonitor r10 = (ECLivePerformanceMonitor) r9.getValue();
        if (r10 == null) goto L23;
        r10.i();
    L23:
        r6.c = false;
        ECUIPromotion r11 = com.bytedance.android.livesdk.livecommerce.utils.k.e(com.bytedance.android.livesdk.livecommerce.utils.k.c(r4), Boolean.TRUE);
        if (r11 != null) goto L26;
        r11 = null;
    L30:
        r6.a = r11;
        r6.b = true;
        if (r6.d == null) goto L36;
        OptCardUtil.b(null, "handleResponse post callback");
        int r12 = g;
        if (r12 <= 1) goto L35;
        UtilityKotlinExtentionsKt.b.postAtTime(new u(r6), r12);
        return;
    L35:
        UtilityKotlinExtentionsKt.b.postAtFrontOfQueue(new v(r6));
        return;
    L36:
        OptCardUtil.b(null, "handleResponse callback is null");
        return;
    L26:
        if (l == false) goto L28;
        OptCardUtil.b(null, "handleResponse preload image");
        y.o.getClass();
        y.a.b(r11);
    L28:
        Unit r0 = Unit.INSTANCE;
        goto L30
    L14:
        if (r7.isCleared() != true) goto L16;
        return;
    L42:
        return;
    L40:
        return;
    L39:
        return;
    }

    public final void b(ECContext r10, com.bytedance.android.livesdk.livecommerce.room.model.g r11, Context r12, p r13, String r14) {
        Intrinsics.checkNotNullParameter(r10, "ecContext");
        Intrinsics.checkNotNullParameter(r11, "liveRoomInfo");
        if (ECLiveABUtils.INSTANCE.getENABLE_KMP_POP_CARD() == false) goto L5;
        return;
    L5:
        dm.a.b r0 = dm.a.a("LiveCardLoad");
        StringBuilder r1 = new StringBuilder("preload explain card, is instant = ");
        if (r13 == null) goto L8;
        boolean r3 = true;
    L9:
        r1.append(r3);
        r0.i(r1.toString());
        if (r13 == null) goto L14;
        r13.c(r10, r11, r14);
        return;
    L14:
        if (f == true) goto L16;
        return;
    L16:
        y.o.getClass();
        y r15 = y.n.get(r11.roomId());
        if (r15 != null) goto L19;
    L20:
        if (r15 != null) goto L22;
    L23:
        OptCardUtil.b(null, "request=" + h + " bind=" + i + " show=" + j + " CardDoFrame=" + k + " PicPreload=" + l + " PicDoFrame=" + m);
        qk2.a r4 = new qk2.a();
        this.c = true;
        ECLivePerformanceMonitor r2 = (ECLivePerformanceMonitor) r10.getEcLivePerformanceMonitor().getValue();
        r2.getClass();
        r2.u("ec_perf_duration_shopping_card", "request_start", Long.valueOf(SystemClock.elapsedRealtime()));
        String r5 = r2.p;
        if (r5 == null) goto L26;
        Map r6 = com.bytedance.android.ec.core.monitor.c.a;
        com.bytedance.android.ec.core.monitor.c.h(r5, MetricNames.POP_API_DURATION, null);
    L26:
        bk2.c.a(r4.b(r11, true, true, null, null).subscribe(new w(this, r10), new x(this, r10)), (bk2.d) r10.getDisposableContext().getValue());
    L27:
        this.e = r10;
        if (r12 != null) goto L30;
        return;
    L30:
        if (y.k == false) goto L54;
        if (r15 == null) goto L35;
        WeakReference<Context> r16 = r15.getContext();
        if (r16 == null) goto L35;
        Context r17 = r16.get();
    L36:
        boolean r18 = Intrinsics.areEqual(r17, r12);
        ECLivePerformanceMonitor r19 = (ECLivePerformanceMonitor) r10.getEcLivePerformanceMonitor().getValue();
        r19.getClass();
        String r7 = "1";
        if (r18 == false) goto L39;
        String r8 = "1";
    L40:
        r19.b("ec_perf_duration_shopping_card", "is_preload_same_activity", r8);
        String r110 = r19.p;
        if (r110 == null) goto L47;
        Map r111 = com.bytedance.android.ec.core.monitor.c.a;
        if (r18 == true) goto L46;
        r7 = BDLocationException.ERROR_TIMEOUT;
    L46:
        com.bytedance.android.ec.core.monitor.c.e(r110, "is_preload_same_activity", r7);
    L47:
        OptCardUtil.b(null, "async layout same: " + r18);
        if (r15 != null) goto L50;
    L53:
        a.a(r12);
        return;
    L50:
        if (r15.h != true) goto L53;
        if (r18 == false) goto L53;
        return;
    L39:
        r8 = BDLocationException.ERROR_TIMEOUT;
    L35:
        r17 = null;
        goto L36
    L54:
        a.a(r12);
        return;
    L22:
        if (r15.e == true) goto L27;
    L19:
        if (r15.a == true) goto L27;
    L8:
        r3 = false;
        goto L9
    }
}
