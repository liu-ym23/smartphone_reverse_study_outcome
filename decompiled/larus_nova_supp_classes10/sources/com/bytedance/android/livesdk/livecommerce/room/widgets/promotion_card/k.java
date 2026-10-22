package com.bytedance.android.livesdk.livecommerce.room.widgets.promotion_card;

import android.os.SystemClock;
import android.view.View;
import com.bytedance.android.ec.core.monitor.MetricNames;
import com.bytedance.android.ec.core.utils.OptCardUtil;
import com.bytedance.android.ec.model.promotion.ECUIPromotion;
import com.bytedance.android.livesdk.livecommerce.opt.ECLivePerformanceMonitor;
import com.bytedance.android.livesdk.livecommerce.room.widgets.promotion_card.refactor.ExplainCardViewModel;
import com.bytedance.bdlocation.exception.BDLocationException;
import java.util.Map;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class k extends com.bytedance.android.livesdk.livecommerce.room.widgets.anim.b {
    public final /* synthetic */ ExplainCardWidgetController f;
    public final /* synthetic */ Function0 g;
    public final /* synthetic */ ExplainCardViewModel h;
    public final /* synthetic */ ECUIPromotion i;
    public final /* synthetic */ boolean j;

    @Override // com.bytedance.android.livesdk.livecommerce.room.widgets.anim.b
    public final void c() {
    }

    @Override // com.bytedance.android.livesdk.livecommerce.room.widgets.anim.b
    public final void a() {
        OptCardUtil.b(null, "call animEnd");
        this.h.getShowAfterAnimAction().e(new bk2.a(Unit.INSTANCE));
        ECLivePerformanceMonitor r2 = this.f.h();
        if (r2 == null) goto L17;
        boolean r0 = this.j;
        if (r0 == false) goto L7;
        r2.u("ec_perf_duration_shopping_card", "render_end", Long.valueOf(SystemClock.elapsedRealtime()));
    L8:
        if (r0 == false) goto L10;
        ECLivePerformanceMonitor.w(r2, "ec_perf_duration_shopping_card", null, null, 6);
    L10:
        String r3 = r2.p;
        if (r3 == null) goto L15;
        Map r4 = com.bytedance.android.ec.core.monitor.c.a;
        com.bytedance.android.ec.core.monitor.c.j(r3, MetricNames.POP_CARD_ANIM_DURATION);
        com.bytedance.android.ec.core.monitor.c.j(r3, MetricNames.RENDER_DURATION);
        com.bytedance.android.ec.core.monitor.c.j(r3, MetricNames.DURATION);
        if (r0 == false) goto L15;
        com.bytedance.android.ec.core.monitor.c.d(r3);
        r2.p = null;
    L15:
        r2.x(false, Boolean.valueOf(this.j), this.f.a, this.c, BDLocationException.ERROR_TIMEOUT);
        goto L17
    L7:
        r2.v("ec_perf_duration_shopping_card", CollectionsKt.listOf("render_end"), Long.valueOf(SystemClock.elapsedRealtime()));
    L17:
        if (this.f.a.a() == true) goto L20;
        ExplainCardWidgetController.e(this.f, this.j);
        return;
    L20:
        if (this.j == false) goto L22;
        ExplainCardWidgetController.e(this.f, true);
        return;
    L22:
        ExplainCardWidgetController r1 = this.f;
        r1.o = true;
        r1.n = true;
    }

    @Override // com.bytedance.android.livesdk.livecommerce.room.widgets.anim.b
    public final void b() {
        Function0 r0 = this.g;
        if (r0 == null) goto L5;
        Unit r1 = (Unit) r0.invoke();
    L5:
        this.h.getShowBeforeAnimAction().e(new bk2.a(Unit.INSTANCE));
        OptCardUtil.b(null, "call anim start; set promotion state");
        this.h.getPromotionState().e(this.i);
        int r2 = com.bytedance.android.livesdk.livecommerce.kmp.a.a;
        Intrinsics.checkNotNullParameter("pop_card_load", "scene");
    }

    public k(ExplainCardWidgetController r1, Function0 r2, ExplainCardViewModel r3, ECUIPromotion r4, boolean r5, String r6, View r7, Function2 r8) {
        this.f = r1;
        this.g = r2;
        this.h = r3;
        this.i = r4;
        this.j = r5;
        super(r6, r7, 0, r8);
    }
}
