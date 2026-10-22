package com.bytedance.ee.bear.notification;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class q implements Consumer<Throwable> {
    public q() {
    }

    public final void accept(Object r4) throws Exception {
        tt5.a.e("NotificationViewModel", "loadUnSyncNotification failed", (Throwable) r4, false);
    }
}
