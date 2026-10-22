package com.bytedance.android.livesdk.livecommerce.iron.navigate;

import com.bytedance.android.ec.core.monitor.MetricNames;
import com.bytedance.android.ec.model.response.w;
import com.bytedance.android.livesdk.livecommerce.opt.ECLivePerformanceMonitor;
import com.bytedance.android.livesdk.livecommerce.promotion.cardV2.tracker.LiveActionTracker;
import com.bytedance.android.livesdk.livecommerce.room.controller.business.RoomContextController;
import com.bytedance.android.livesdk.livecommerce.room.store.ECContext;
import com.bytedance.android.livesdk.livecommerce.utils.c0;
import com.bytedance.live.datacontext.i;
import io.reactivex.functions.Consumer;
import java.util.Map;
import kotlin.jvm.functions.Function1;
import si2.g;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class a<T> implements Consumer {
    public final /* synthetic */ il2.a a;
    public final /* synthetic */ String b;
    public final /* synthetic */ String c;
    public final /* synthetic */ Function1 d;
    public final /* synthetic */ yk.a e;

    public a(LiveActionTracker r1, String r2, String r3, Function1 r4, yk.a r5) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
    }

    public final void accept(Object r9) {
        vj2.a r10 = (vj2.a) r9;
        il2.a r0 = this.a;
        if (r0 == null) goto L5;
        il2.a.C0145a.a(r0, "req_get_success", null, false, null, r10.a(), null, 46);
    L5:
        if (r10 != null) goto L7;
    L29:
        yk.a r1 = this.e;
        if (r1 == null) goto L33;
        r1.a(g.k, r10);
        return;
    L33:
        return;
    L7:
        if (((com.bytedance.android.ec.model.g) r10).statusCode != 0) goto L29;
        Map<String, w> r2 = r10.d();
        if (r2 == null) goto L12;
        w r3 = r2.get(this.b);
        if (r3 == null) goto L12;
    L16:
        if (r3 == null) goto L29;
        int r4 = RoomContextController.h;
        ECContext r5 = RoomContextController.a.a().r();
        if (r5 == null) goto L28;
        i<ECLivePerformanceMonitor> r6 = r5.getEcLivePerformanceMonitor();
        if (r6 == null) goto L28;
        ECLivePerformanceMonitor r7 = (ECLivePerformanceMonitor) r6.getValue();
        if (r7 == null) goto L28;
        String r8 = r7.s;
        if (r8 == null) goto L28;
        if (r7.d == true) goto L28;
        Map r11 = com.bytedance.android.ec.core.monitor.c.a;
        com.bytedance.android.ec.core.monitor.c.j(r8, MetricNames.GET_API_DURATION);
    L28:
        this.d.invoke(c0.a(r3, r10.a()));
    L12:
        Map<String, w> r12 = r10.b();
        if (r12 == null) goto L15;
        r3 = r12.get(this.c);
        goto L16
    L15:
        r3 = null;
        goto L16
    }
}
