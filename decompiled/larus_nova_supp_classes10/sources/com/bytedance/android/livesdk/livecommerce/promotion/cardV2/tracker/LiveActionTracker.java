package com.bytedance.android.livesdk.livecommerce.promotion.cardV2.tracker;

import com.bytedance.android.ec.common.api.jump.model.g;
import com.bytedance.android.ec.core.monitor.ECExceptionMonitor;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class LiveActionTracker implements il2.a {
    public final List<LiveSingleAction> a;
    public final String b;
    public boolean c;
    public g d;
    public final Lazy e;
    public final String f;
    public com.bytedance.android.btm.api.model.d g;
    public final c h;

    public static final class a {
    }

    static {
    }

    @Override // il2.a
    public final il2.b b() {
        return (il2.b) this.e.getValue();
    }

    @Override // il2.a
    public final LiveActionTracker a(g r1) {
        this.d = r1;
        return this;
    }

    @Override // il2.a
    public final LiveActionTracker d(com.bytedance.android.btm.api.model.d r1) {
        this.g = r1;
        return this;
    }

    public final void e(boolean r11) {
        if (this.c == false) goto L5;
        return;
    L5:
        ArrayList r0 = (ArrayList) this.a;
        if ((!r0.isEmpty()) == true) goto L9;
        r0 = null;
    L9:
        ArrayList r7 = r0;
        if (r7 == null) goto L18;
        int r1 = b.a;
        String r5 = this.f;
        g r4 = this.d;
        com.bytedance.android.btm.api.model.d r9 = this.g;
        String r6 = this.b;
        Intrinsics.checkNotNullParameter(r5, "pageName");
        Intrinsics.checkNotNullParameter(r7, "actionStack");
        Intrinsics.checkNotNullParameter(r6, "uuid");
        if (r7.isEmpty() == true) goto L18;
        oh.a.c("ecom_live_action_quality_track", new com.bytedance.android.livesdk.livecommerce.promotion.cardV2.tracker.a(r4, r5, r6, r7, r11, r9));     // Catch: Exception -> L16
    L16:
        e = move-exception;
        ECExceptionMonitor.e(e);
    L18:
        c r12 = this.h;
        r12.getClass();
        Intrinsics.checkNotNullParameter(this, "tracker");
        int r2 = c.b;
        dm.a.a("ActionTrack").a("remove tracker " + this);
        c.b r13 = r12.a;
        r13.getClass();
        Intrinsics.checkNotNullParameter(this, "key");
        r13.a.remove(this);
        this.c = true;
    }

    public LiveActionTracker(String r2, com.bytedance.android.btm.api.model.d r3, c r4) {
        Intrinsics.checkNotNullParameter(r2, "pageName");
        Intrinsics.checkNotNullParameter(r4, "trackerCenter");
        this.f = r2;
        this.g = r3;
        this.h = r4;
        this.a = new ArrayList();
        this.b = UUID.randomUUID().toString();
        this.e = LazyKt.lazy(LiveActionTracker$trackerExtra$2.INSTANCE);
    }

    @Override // il2.a
    public final LiveActionTracker c(String r9, Map r10, boolean r11, String r12, String r13, String r14) {
        Intrinsics.checkNotNullParameter(r9, "actionName");
        if (this.c == false) goto L5;
        return this;
    L5:
        LiveSingleAction r0 = new LiveSingleAction(r9, r10, r11, r12, r13, r14);
        ((ArrayList) this.a).add(r0);
        return this;
    }
}
