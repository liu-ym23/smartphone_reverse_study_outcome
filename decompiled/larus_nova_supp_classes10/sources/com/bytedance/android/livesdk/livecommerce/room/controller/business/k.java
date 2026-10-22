package com.bytedance.android.livesdk.livecommerce.room.controller.business;

import com.bytedance.android.livesdk.livecommerce.network.response.ECFlashResponse;
import vi2.v0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class k implements v0<ECFlashResponse> {
    public final /* synthetic */ EntryController a;

    public k(EntryController r1) {
        this.a = r1;
    }

    @Override // vi2.v0
    public final void onError(Throwable r3) {
        this.a.c0(new si2.e(0, false));
    }

    @Override // vi2.v0
    public final void onSuccess(ECFlashResponse r5) {
        ECFlashResponse r6 = r5;
        if (r6 == null) goto L6;
        this.a.c0(new si2.e(r6.getHasAuth(), r6.isOpen()));
        this.a.A().p.K(r6);
        return;
    }
}
