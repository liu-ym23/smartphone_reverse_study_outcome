package com.bytedance.android.livesdk.livecommerce.iron.helper;

import android.content.Context;
import com.bytedance.android.livesdk.livecommerce.promotion.cardV2.tracker.LiveActionTracker;
import com.bytedance.common.utility.UIUtils;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class o implements cf.a {
    public final /* synthetic */ sl.c a;
    public final /* synthetic */ PromotionJumpDispatcher b;
    public final /* synthetic */ com.bytedance.android.ec.common.api.jump.model.g c;
    public final /* synthetic */ com.bytedance.android.btm.api.model.d d;
    public final /* synthetic */ Context e;
    public final /* synthetic */ il2.a f;
    public final /* synthetic */ String g;

    public final jf.e a() {
        return null;
    }

    public final boolean c() {
        return true;
    }

    public final void onFailed() {
        Context r0 = this.e;
        sl.c r1 = this.a;
        if (r1 == null) goto L5;
        String r2 = r1.a();
    L6:
        UIUtils.displayToast(r0, r2);
        il2.a r3 = this.f;
        if (r3 == null) goto L12;
        il2.a r4 = il2.a.C0145a.a(r3, "add_cart_directly_failed", null, false, null, null, null, 56);
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

    public o(sl.c r1, PromotionJumpDispatcher r2, com.bytedance.android.ec.common.api.jump.model.g r3, com.bytedance.android.btm.api.model.d r4, Context r5, il2.a r6, String r7) {
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
        this.b.n(this.e, r2, this.d, this.c, this.g, this.f);
        return;
    L7:
        il2.a r3 = this.f;
        if (r3 == null) goto L14;
        il2.a r4 = il2.a.C0145a.a(r3, "open_schema", null, false, "schema_is_null", null, null, 48);
        if (r4 == null) goto L15;
        ((LiveActionTracker) r4).e(false);
        return;
    L15:
        return;
    }
}
