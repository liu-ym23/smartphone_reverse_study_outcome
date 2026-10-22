package com.ss.android.lark.reaction.service.impl;

import com.ss.android.lark.log.Log;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes37.dex */
public final class c<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final c<T> f439184a = null;

    static {
        f439184a = new c();
    }

    public c() {
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        Log.e("ReactionOrderService2", "onPushEmojiPanel error", (Throwable) r100);
    }
}
