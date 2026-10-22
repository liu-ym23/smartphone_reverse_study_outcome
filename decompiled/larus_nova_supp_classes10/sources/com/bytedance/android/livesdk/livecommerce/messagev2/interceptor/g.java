package com.bytedance.android.livesdk.livecommerce.messagev2.interceptor;

import com.bytedance.android.livesdk.livecommerce.ab.ECLiveABUtils;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class g extends a {
    public g() {
        super(true);
    }

    @Override // com.bytedance.android.livesdk.livecommerce.messagev2.interceptor.a
    public final void e(String r1, boolean r2) {
    }

    @Override // com.bytedance.android.livesdk.livecommerce.messagev2.interceptor.a
    public final boolean d() {
        return !ECLiveABUtils.INSTANCE.getECOM_LIVE_MESSAGE_NO_LOGIN().booleanValue();
    }

    @Override // com.bytedance.android.livesdk.livecommerce.messagev2.interceptor.a
    public final boolean c(sg2.a r2) {
        Intrinsics.checkNotNullParameter(r2, "message");
        if ((r2 instanceof si2.c) == true) goto L6;
        return false;
    L6:
        oj2.a r0 = (oj2.a) b(oj2.a.class, r2);
        if (r0 == null) goto L11;
        r0.w((si2.c) r2);
        return true;
    L11:
        return true;
    }
}
