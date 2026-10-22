package com.bytedance.android.livesdk.livecommerce.iron.helper;

import com.bytedance.android.livesdk.livecommerce.promotion.cardV2.tracker.LiveActionTracker;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class h implements cf.a {
    public final /* synthetic */ com.bytedance.android.ec.common.api.jump.model.f a;
    public final /* synthetic */ cf.a b;
    public final /* synthetic */ il2.a c;

    public final boolean c() {
        return true;
    }

    public final jf.e a() {
        com.bytedance.android.ec.common.api.jump.model.f r0 = this.a;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.d;
    }

    public final void onFailed() {
        il2.a r0 = this.c;
        if (r0 == null) goto L8;
        il2.a r1 = il2.a.C0145a.a(r0, "add_cart_directly_failed", null, false, null, null, null, 56);
        if (r1 == null) goto L9;
        ((LiveActionTracker) r1).e(false);
        return;
    L9:
        return;
    }

    public h(com.bytedance.android.ec.common.api.jump.model.f r1, cf.a r2, il2.a r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    public final void b(int r12, String r13, String r14, String r15, Integer r16, String r17, String r18, Integer r19, String r20) {
        Intrinsics.checkNotNullParameter(r20, "addType");
        cf.a r2 = this.b;
        if (r2 == null) goto L5;
        cf.a.a.a(r2, r12, r13, r14, r15, r16, r17, r18, r19);
    L5:
        il2.a r1 = this.c;
        if (r1 == null) goto L11;
        il2.a r3 = il2.a.C0145a.a(r1, "add_cart_directly_success", MapsKt.mapOf(TuplesKt.to("product_id", r13)), false, null, null, null, 60);
        if (r3 == null) goto L12;
        ((LiveActionTracker) r3).e(false);
        return;
    L12:
        return;
    }
}
