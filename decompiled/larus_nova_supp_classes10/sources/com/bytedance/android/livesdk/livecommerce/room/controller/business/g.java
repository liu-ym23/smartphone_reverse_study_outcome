package com.bytedance.android.livesdk.livecommerce.room.controller.business;

import android.os.Handler;
import android.os.SystemClock;
import com.bytedance.android.livesdk.livecommerce.event.j1;
import com.bytedance.android.livesdk.livecommerce.network.response.ECPromotionList;
import vi2.v0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class g implements v0<ECPromotionList> {
    public final /* synthetic */ EntryController a;
    public final /* synthetic */ String b;
    public final /* synthetic */ String c;

    @Override // vi2.v0
    public final void onError(Throwable r1) {
    }

    @Override // vi2.v0
    public final void onSuccess(ECPromotionList r4) {
        ECPromotionList r5 = r4;
        EntryController r0 = this.a;
        if (r5 == null) goto L7;
        boolean r1 = true;
        if (r5.showCart != 1) goto L7;
    L8:
        r0.H = r1;
        r0.G = r1;
        if (r1 == false) goto L12;
        Handler r6 = com.bytedance.android.livesdk.livecommerce.utils.k.a;
        r0.I = SystemClock.elapsedRealtime();
        new j1(this.b, this.c).k();
        return;
    L12:
        return;
    L7:
        r1 = false;
        goto L8
    }

    public g(EntryController r1, String r2, String r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }
}
