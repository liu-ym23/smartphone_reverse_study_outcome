package com.bytedance.android.shopping.feed.event;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class q0<T> implements Consumer {
    public static final q0 a = null;

    static {
        a = new q0();
    }

    public q0() {
    }

    public final void accept(Object r1) {
        ((com.bytedance.android.ec.core.event.a) r1).newPost();
    }
}
