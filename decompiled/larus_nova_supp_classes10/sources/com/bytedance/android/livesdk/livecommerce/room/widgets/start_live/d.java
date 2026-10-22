package com.bytedance.android.livesdk.livecommerce.room.widgets.start_live;

import com.bytedance.android.ec.core.monitor.ECExceptionMonitor;
import com.bytedance.android.livesdk.livecommerce.network.response.ECPromotionCountResponse;
import sg2.z;
import vi2.v0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class d implements v0<ECPromotionCountResponse> {
    public final /* synthetic */ z a;

    public d(StartLivePromotionButton.c r1) {
        this.a = r1;
    }

    @Override // vi2.v0
    public final void onError(Throwable r1) {
        if (r1 == null) goto L4;
        String r2 = r1.getMessage();
    L5:
        ECExceptionMonitor.c(String.valueOf(r2));
        return;
    L4:
        r2 = null;
        goto L5
    }

    @Override // vi2.v0
    public final void onSuccess(ECPromotionCountResponse r4) {
        ECPromotionCountResponse r5 = r4;
        z r0 = this.a;
        if (r0 == null) goto L9;
        if (r5 == null) goto L6;
        int r6 = (int) r5.getCount();
    L7:
        r0.a(r6);
        return;
    L6:
        r6 = 0;
        goto L7
    }
}
