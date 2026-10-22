package com.bytedance.android.livesdk.livecommerce.iron.helper;

import android.content.Context;
import android.view.View;
import com.bytedance.android.livesdk.livecommerce.promotion.cardV2.tracker.LiveActionTracker;
import com.bytedance.common.utility.UIUtils;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class u implements cf.a {
    public final /* synthetic */ sl.c a;
    public final /* synthetic */ PromotionJumpDispatcher b;
    public final /* synthetic */ il2.a c;
    public final /* synthetic */ com.bytedance.android.ec.common.api.jump.model.g d;
    public final /* synthetic */ com.bytedance.android.btm.api.model.d e;
    public final /* synthetic */ Context f;
    public final /* synthetic */ View g;

    public final jf.e a() {
        return null;
    }

    public final boolean c() {
        return true;
    }

    public final void onFailed() {
        Context r0 = this.f;
        sl.c r1 = this.a;
        if (r1 == null) goto L5;
        String r2 = r1.a();
    L6:
        UIUtils.displayToast(r0, r2);
        il2.a r3 = this.c;
        if (r3 == null) goto L12;
        il2.a r4 = il2.a.C0145a.a(r3, "add_cart_directly", null, false, "add_cart_callback_fail", null, null, 48);
        if (r4 == null) goto L13;
        ((LiveActionTracker) r4).e(false);
        return;
    L13:
        return;
    L12:
        return;
    L5:
        r2 = null;
        goto L6
    }

    public u(sl.c r1, PromotionJumpDispatcher r2, il2.a r3, com.bytedance.android.ec.common.api.jump.model.g r4, com.bytedance.android.btm.api.model.d r5, Context r6, View r7) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
        this.f = r6;
        this.g = r7;
    }

    public final void b(int r10, String r11, String r12, String r13, Integer r14, String r15, String r16, Integer r17, String r18) {
        Intrinsics.checkNotNullParameter(r18, "addType");
        sl.c r1 = this.a;
        if (r1 == null) goto L7;
        String r2 = r1.b();
        if (r2 == null) goto L7;
        this.b.n(this.f, r2, this.e, this.d, null, null);
    L7:
        il2.a r3 = this.c;
        if (r3 == null) goto L19;
        sl.c r4 = this.a;
        if (r4 == null) goto L12;
        String r5 = r4.b();
    L13:
        if (r5 != null) goto L15;
        r5 = "";
    L15:
        il2.a r6 = il2.a.C0145a.a(r3, "add_cart_directly", MapsKt.mapOf(TuplesKt.to("schema", r5)), false, null, null, null, 60);
        if (r6 == null) goto L20;
        ((LiveActionTracker) r6).e(false);
        return;
    L20:
        return;
    L12:
        r5 = null;
        goto L13
    }
}
