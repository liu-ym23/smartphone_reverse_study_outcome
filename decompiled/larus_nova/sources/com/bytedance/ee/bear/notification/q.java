package com.bytedance.ee.bear.notification;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes18.dex */
public final class q implements Consumer<Throwable> {
    public q() {
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Throwable r100) throws Exception {
        tt5.a.e("NotificationViewModel", "loadUnSyncNotification failed", r100, false);
    }
}
