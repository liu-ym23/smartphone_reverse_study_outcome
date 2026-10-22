package com.bytedance.android.livesdk.livecommerce.promotionlist.viewmodel.subviewmodel;

import android.view.Choreographer;
import com.android.ttcjpaysdk.base.ktextension.KtSafeMethodExtensionKt;
import com.bytedance.android.ec.monitor.duration.h;
import com.bytedance.android.livesdk.livecommerce.opt.ECLivePerformanceMonitor;
import com.bytedance.android.livesdk.livecommerce.room.api.ControllerExtensionsKt;
import com.bytedance.android.livesdk.livecommerce.room.controller.business.PromotionListController;
import com.bytedance.android.livesdk.livecommerce.room.controller.business.RoomContextController;
import com.bytedance.android.livesdk.livecommerce.room.store.ECContext;
import com.bytedance.android.livesdk.livecommerce.utils.EComABUtils;
import com.bytedance.bdlocation.exception.BDLocationException;
import com.bytedance.live.datacontext.i;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class c extends com.bytedance.android.livesdk.livecommerce.promotionlist.base.b {
    public static final /* synthetic */ int g = 0;
    public boolean c;
    public boolean d;
    public boolean e;
    public final Function0<RoomContextController> f;

    public static final class a {
    }

    static {
    }

    @Override // com.bytedance.android.livesdk.livecommerce.promotionlist.base.b
    public final void a() {
    }

    public c(Function0<RoomContextController> r2) {
        Intrinsics.checkNotNullParameter(r2, "roomContextController");
        super(0);
        this.f = r2;
    }

    public final void k(String r12, h r13) {
        Intrinsics.checkNotNullParameter(r12, "roomId");
        if (this.c == false) goto L5;
        return;
    L5:
        if (this.a == false) goto L46;
        int r1 = RoomContextController.h;
        ECContext r2 = RoomContextController.a.a().r();
        if (r2 == null) goto L11;
        i<ECLivePerformanceMonitor> r3 = r2.getEcLivePerformanceMonitor();
        if (r3 == null) goto L11;
        final ECLivePerformanceMonitor r4 = (ECLivePerformanceMonitor) r3.getValue();
    L12:
        final PromotionListController r5 = ControllerExtensionsKt.c((RoomContextController) this.f.invoke(), r12).A().r;
        if (r4 == null) goto L33;
        boolean r6 = this.e;
        boolean r7 = this.d;
        Intrinsics.checkNotNullParameter(r12, "roomId");
        Intrinsics.checkNotNullParameter(r5, "promotionListController");
        r4.u("ec_perf_duration_promotion_list", "render_end", null);
        String r0 = "1";
        if (r6 == false) goto L17;
        String r8 = "1";
    L18:
        r4.b("ec_perf_duration_promotion_list", "use_cache", r8);
        if (r7 == false) goto L21;
        String r9 = "1";
    L22:
        r4.b("ec_perf_duration_promotion_list", "use_layout_cache", r9);
        r4.b("ec_perf_duration_promotion_list", "scene", r4.e);
        PromotionListController r14 = ControllerExtensionsKt.b(r5, r12);
        Long r10 = r4.t;
        if (r10 == null) goto L25;
        r4.b("ec_perf_duration_promotion_list", "list_show_duration", String.valueOf(System.currentTimeMillis() - r10.longValue()));
    L25:
        Long r11 = r4.u;
        if (r11 == null) goto L28;
        r4.b("ec_perf_duration_promotion_list", "list_render_duration", String.valueOf(System.currentTimeMillis() - r11.longValue()));
    L28:
        r4.b("ec_perf_duration_promotion_list", "enter_room_to_list_show_duration", String.valueOf(r14.k));
        if (r14.s == 2) goto L32;
        r0 = BDLocationException.ERROR_TIMEOUT;
    L32:
        r4.b("ec_perf_duration_promotion_list", "is_instant_room", r0);
        r4.b("ec_perf_duration_promotion_list", "instant_type", String.valueOf(r5.A().t.U));
        r4.b("ec_perf_duration_promotion_list", "first_page_promotion_count", String.valueOf(r14.t));
        r4.b("ec_perf_duration_promotion_list", "total_promotion_count", String.valueOf(r14.u));
        r4.b("ec_perf_duration_promotion_list", "routine_optimize", String.valueOf(EComABUtils.enableServerRoutineOpt()));
        r4.b("ec_perf_duration_promotion_list", "routine_optimize_reverse_step", String.valueOf(EComABUtils.serverRoutineReverseStep()));
        ECLivePerformanceMonitor.w(r4, "ec_perf_duration_promotion_list", r13, null, 4);
        goto L33
    L21:
        r9 = BDLocationException.ERROR_TIMEOUT;
        goto L22
    L17:
        r8 = BDLocationException.ERROR_TIMEOUT;
    L33:
        r5.K.put("list_load_end", Long.valueOf(System.currentTimeMillis()));
        r5.K.put("use_cache", Boolean.valueOf(this.e));
        com.bytedance.android.shopping.ligo.context.b<?> r15 = r5.J;
        if (r15 == null) goto L36;
        r15.b("live_list_perf_data", KtSafeMethodExtensionKt.safeToJson(r5.K));
    L36:
        Map r16 = com.bytedance.android.ec.core.monitor.c.a;
        Function0<Unit> r17 = new LivePromotionListMonitorViewModel$reportPromotionMonitor$1(this, r4, r5);
        Intrinsics.checkNotNullParameter(r17, "callBack");
        Choreographer.getInstance().postFrameCallback(new com.bytedance.android.ec.core.monitor.b(r17));     // Catch: Throwable -> L39
    L41:
        this.c = true;
        return;
    L39:
        th = move-exception;
        r17.invoke();
        th.printStackTrace();
    L11:
        r4 = null;
        goto L12
    }
}
