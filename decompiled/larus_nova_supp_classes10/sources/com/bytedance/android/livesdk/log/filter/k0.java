package com.bytedance.android.livesdk.log.filter;

import com.bytedance.bdlocation.exception.BDLocationException;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class k0 extends a<com.bytedance.android.livesdk.user.l> {
    public com.bytedance.android.livesdk.user.l c;

    public k0() {
    }

    public final void J(com.bytedance.android.livesdk.user.l r5) {
        if (r5 == null) goto L4;
        String r0 = r5.d;
    L5:
        if (r0 == null) goto L7;
    L11:
        c("source", r0);
        if ("silent_auth_guide".equals(r0) == false) goto L14;
    L19:
        c("is_skip_confirm", "1");
    L20:
        c("is_coupon", BDLocationException.ERROR_TIMEOUT);
        c("sdk_type", "live");
        this.c = r5;
        return;
    L14:
        if ("silent_auth_guide_agreement".equals(r0) == true) goto L19;
        if ("silent_lite_interaction".equals(r0) == true) goto L19;
        c("is_skip_confirm", BDLocationException.ERROR_TIMEOUT);
        goto L20
    L7:
        if (com.bytedance.android.live.core.utils.v.a() == false) goto L11;
        throw new IllegalArgumentException("login params source cant be null");
    L4:
        r0 = null;
        goto L5
    }

    @Override // com.bytedance.android.livesdk.log.filter.a, com.bytedance.android.livesdk.log.filter.o
    public final /* bridge */ /* synthetic */ void setData(Object r1) {
        J((com.bytedance.android.livesdk.user.l) r1);
    }
}
