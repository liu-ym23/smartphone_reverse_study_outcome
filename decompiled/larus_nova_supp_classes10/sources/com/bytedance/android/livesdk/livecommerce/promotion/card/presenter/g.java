package com.bytedance.android.livesdk.livecommerce.promotion.card.presenter;

import android.os.MessageQueue;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class g implements MessageQueue.IdleHandler {
    public final /* synthetic */ ListItemGroupPresenter a;

    public g(ListItemGroupPresenter r1) {
        this.a = r1;
    }

    @Override // android.os.MessageQueue.IdleHandler
    public final boolean queueIdle() {
        this.a.I(null);
        this.a.K();
        return false;
    }
}
