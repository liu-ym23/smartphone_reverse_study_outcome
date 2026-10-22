package com.bytedance.android.livesdk.livecommerce.promotion.cardV2.presenter;

import android.os.MessageQueue;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class e implements MessageQueue.IdleHandler {
    public final /* synthetic */ f a;

    public e(f r1) {
        this.a = r1;
    }

    @Override // android.os.MessageQueue.IdleHandler
    public final boolean queueIdle() {
        this.a.G();
        this.a.I();
        return false;
    }
}
