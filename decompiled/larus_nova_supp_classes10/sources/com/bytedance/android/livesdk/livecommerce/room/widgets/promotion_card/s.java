package com.bytedance.android.livesdk.livecommerce.room.widgets.promotion_card;

import com.bytedance.android.ec.core.monitor.ECExceptionMonitor;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class s<T> implements Consumer {
    public final /* synthetic */ p a;

    public s(p r1) {
        this.a = r1;
    }

    public final void accept(Object r2) {
        ECExceptionMonitor.e((Throwable) r2);
        this.a.b = false;
    }
}
