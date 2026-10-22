package com.bytedance.android.livesdk.livecommerce.messagev2.interceptor;

import com.bytedance.android.ec.core.hybrid.utils.ECLiveHybridUtil;
import com.bytedance.android.ec.core.monitor.ECExceptionMonitor;
import com.bytedance.android.ec.core.utils.u0;
import com.bytedance.android.livesdk.livecommerce.room.controller.business.LynxAnchorPromotionListUtils;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class c0 extends a {
    public c0() {
        super(false);
    }

    @Override // com.bytedance.android.livesdk.livecommerce.messagev2.interceptor.a
    public final void e(String r1, boolean r2) {
    }

    @Override // com.bytedance.android.livesdk.livecommerce.messagev2.interceptor.a
    public final boolean c(sg2.a r6) {
        Intrinsics.checkNotNullParameter(r6, "message");
        if ((r6 instanceof si2.b0) == true) goto L5;
        r6 = null;
    L5:
        si2.b0 r7 = (si2.b0) r6;
        if (r7 != null) goto L8;
    L21:
        return false;
    L8:
        if (r7.msgType != 1) goto L10;
        boolean r3 = true;
    L11:
        if (r3 == true) goto L14;
        r7 = null;
    L14:
        if (r7 == null) goto L21;
        boolean r1 = LynxAnchorPromotionListUtils.a;
        Intrinsics.checkNotNullParameter(r7, "message");
        ECLiveHybridUtil.f("ecom.anchor.sellerMessage", tv5.a.a(u0.c(), r7));     // Catch: JSONException -> L18
    L20:
        return true;
    L18:
        e = move-exception;
        dm.a.a("ecom.anchor.sellerMessage").b(String.valueOf(e.getMessage()), null);
        ECExceptionMonitor.c(String.valueOf(e.getMessage()));
        goto L20
    L10:
        r3 = false;
        goto L11
    }
}
