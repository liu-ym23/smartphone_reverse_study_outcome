package com.bytedance.android.livesdk.livecommerce.eventcenter.ability;

import com.bytedance.android.ec.core.monitor.ECExceptionMonitor;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class i<T> implements Consumer {
    public static final i a = null;

    static {
        a = new i();
    }

    public i() {
    }

    public final void accept(Object r1) {
        ECExceptionMonitor.e((Throwable) r1);
    }
}
