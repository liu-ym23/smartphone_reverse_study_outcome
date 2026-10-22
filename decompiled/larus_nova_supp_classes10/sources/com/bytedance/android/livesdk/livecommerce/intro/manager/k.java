package com.bytedance.android.livesdk.livecommerce.intro.manager;

import android.util.SparseArray;
import com.bytedance.android.livesdk.livecommerce.intro.model.req.IntroCardScene;
import com.bytedance.android.livesdk.livecommerce.intro.model.resp.r0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class k implements com.bytedance.android.livesdk.livecommerce.intro.controller.a {
    public final /* synthetic */ i a;

    @Override // com.bytedance.android.livesdk.livecommerce.intro.controller.a
    public final void b() {
        i.a r0 = new i.a();
        if (Intrinsics.areEqual(this.a.f, r0) == false) goto L6;
        this.a.f = null;
        return;
    }

    @Override // com.bytedance.android.livesdk.livecommerce.intro.controller.a
    public final void c() {
        com.bytedance.android.livesdk.livecommerce.intro.utils.k.c("[onOpenPriceAnimationFinished] request latest intro card");
        i r0 = this.a;
        r0.f = null;
        c.a.a(r0, IntroCardScene.ACTION, 126);
    }

    public k(i r1) {
        this.a = r1;
    }

    @Override // com.bytedance.android.livesdk.livecommerce.intro.controller.a
    public final void a(boolean r5) {
        SparseArray<com.bytedance.android.livesdk.livecommerce.intro.controller.b> r0 = this.a.d;
        int r1 = r0.size();
        int r2 = 0;
    L3:
        if (r2 >= r1) goto L5;
        r0.keyAt(r2);
        r0.valueAt(r2).k(r5);
        r2 = r2 + 1;
        goto L3
    }

    @Override // com.bytedance.android.livesdk.livecommerce.intro.controller.a
    public final void d(r0 r4) {
        int r0 = com.bytedance.android.livesdk.livecommerce.intro.utils.k.a;
        StringBuilder r1 = new StringBuilder("[onCardFinishedAction] action=");
        String r2 = null;
        if (r4 == null) goto L5;
        String r3 = r4.a();
    L6:
        r1.append(r3);
        com.bytedance.android.livesdk.livecommerce.intro.utils.k.c(r1.toString());
        if (r4 == null) goto L9;
        r2 = r4.a();
    L9:
        if (r2 != null) goto L12;
        return;
    L12:
        if (r2.hashCode() == (-1689642695)) goto L15;
        return;
    L15:
        if (r2.equals("LIVE_INTRO") == false) goto L18;
        c.a.a(this.a, IntroCardScene.ACTION, 126);
        return;
    L18:
        return;
    L5:
        r3 = null;
        goto L6
    }
}
