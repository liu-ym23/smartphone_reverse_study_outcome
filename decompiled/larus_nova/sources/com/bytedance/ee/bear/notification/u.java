package com.bytedance.ee.bear.notification;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes18.dex */
public final class u implements Consumer<Throwable> {
    public u() {
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Throwable r100) throws Exception {
        tt5.a.e("NotificationViewModel", "loadValidNotificationFromNet", r100, false);
    }
}
