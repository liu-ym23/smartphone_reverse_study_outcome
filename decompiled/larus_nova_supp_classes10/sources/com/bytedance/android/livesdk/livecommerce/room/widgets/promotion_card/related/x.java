package com.bytedance.android.livesdk.livecommerce.room.widgets.promotion_card.related;

import android.os.SystemClock;
import android.view.View;
import com.bytedance.android.ec.core.utils.OptCardUtil;
import com.bytedance.android.ec.model.promotion.ECUIPromotion;
import com.bytedance.android.livesdk.livecommerce.opt.ECLivePerformanceMonitor;
import com.bytedance.android.livesdk.livecommerce.room.widgets.promotion_card.refactor.ExplainCardViewModel;
import com.bytedance.android.livesdk.livecommerce.utils.UtilityKotlinExtentionsKt;
import java.util.Map;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class x extends com.bytedance.android.livesdk.livecommerce.room.widgets.anim.b {
    public final /* synthetic */ RelatedCardWidgetController f;
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
        ECLivePerformanceMonitor r0 = this.f.h();
        if (r0 == null) goto L14;
        boolean r2 = this.j;
        if (r2 == false) goto L7;
        r0.u("ec_perf_duration_shopping_related_card", "render_end", Long.valueOf(SystemClock.elapsedRealtime()));
    L8:
        if (r2 == false) goto L14;
        r0.b("ec_perf_duration_shopping_card", "is_use_related_card", "1");
        String r3 = r0.p;
        if (r3 == null) goto L12;
        Map r6 = com.bytedance.android.ec.core.monitor.c.a;
        com.bytedance.android.ec.core.monitor.c.e(r3, "is_use_related_card", "1");
    L12:
        ECLivePerformanceMonitor.w(r0, "ec_perf_duration_shopping_related_card", null, null, 6);
        goto L14
    L7:
        r0.v("ec_perf_duration_shopping_related_card", CollectionsKt.listOf("render_end"), Long.valueOf(SystemClock.elapsedRealtime()));
    L14:
        if (this.f.a.a() == true) goto L19;
        RelatedCardWidgetController r1 = this.f;
        boolean r4 = this.j;
        r1.getClass();
        if (r4 == true) goto L23;
        UtilityKotlinExtentionsKt.b.post(new v(r1));
        return;
    L23:
        return;
    L19:
        if (this.j == false) goto L21;
        this.f.getClass();
        return;
    L21:
        RelatedCardWidgetController r5 = this.f;
        r5.i = true;
        r5.h = true;
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
    }

    public x(RelatedCardWidgetController r1, Function0 r2, ExplainCardViewModel r3, ECUIPromotion r4, boolean r5, String r6, View r7, Function2 r8) {
        this.f = r1;
        this.g = r2;
        this.h = r3;
        this.i = r4;
        this.j = r5;
        super(r6, r7, 0, r8);
    }
}
