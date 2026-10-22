package com.bytedance.android.shopping.anchorv4.voavhs.detailhead;

import android.os.MessageQueue;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class g implements MessageQueue.IdleHandler {
    public final /* synthetic */ AnchorV4DetailHeadView a;

    @Override // android.os.MessageQueue.IdleHandler
    public final boolean queueIdle() {
        AutoHeightViewPager r0 = this.a.k;
        if (r0 == null) goto L5;
        r0.h(0);
    L5:
        return false;
    }

    public g(AnchorV4DetailHeadView r1) {
        this.a = r1;
    }
}
