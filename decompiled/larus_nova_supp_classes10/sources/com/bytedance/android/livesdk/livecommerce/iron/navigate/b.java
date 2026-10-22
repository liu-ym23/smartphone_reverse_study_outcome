package com.bytedance.android.livesdk.livecommerce.iron.navigate;

import com.bytedance.android.ec.core.monitor.ECExceptionMonitor;
import com.bytedance.android.livesdk.livecommerce.promotion.cardV2.tracker.LiveActionTracker;
import io.reactivex.functions.Consumer;
import si2.g;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class b<T> implements Consumer {
    public final /* synthetic */ il2.a a;
    public final /* synthetic */ yk.a b;

    public b(LiveActionTracker r1, yk.a r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void accept(Object r9) {
        Throwable r10 = (Throwable) r9;
        il2.a r0 = this.a;
        if (r0 == null) goto L7;
        il2.a r1 = il2.a.C0145a.a(r0, "req_get_fail", null, false, r10.getMessage(), null, null, 48);
        if (r1 == null) goto L7;
        ((LiveActionTracker) r1).e(false);
    L7:
        ECExceptionMonitor.e(r10);
        yk.a r2 = this.b;
        if (r2 == null) goto L11;
        r2.onFailure(g.k, r10);
        return;
    }
}
