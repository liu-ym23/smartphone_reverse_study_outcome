package com.bytedance.android.window.shop.repository.tab.datasource.impl;

import com.bytedance.android.ec.core.monitor.ECExceptionMonitor;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class d<T> implements Consumer {
    public final /* synthetic */ a a;
    public final /* synthetic */ com.bytedance.android.window.shop.repository.tab.datasource.c b;

    public d(a r1, com.bytedance.android.window.shop.repository.tab.datasource.c r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void accept(Object r3) {
        this.b.onError("");
        ((mq3.a) this.a.e.b()).setExtensionCardParam(null);
        ECExceptionMonitor.e((Throwable) r3);
    }
}
