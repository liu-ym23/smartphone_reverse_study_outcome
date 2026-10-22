package com.bytedance.android.livesdk.livecommerce.room.widgets.promotion_card.strategy;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class e<T> implements Consumer {
    public static final e a = null;

    static {
        a = new e();
    }

    public e() {
    }

    public final void accept(Object r4) {
        f.a().b("query pop error, " + ((Throwable) r4).getMessage(), null);
    }
}
