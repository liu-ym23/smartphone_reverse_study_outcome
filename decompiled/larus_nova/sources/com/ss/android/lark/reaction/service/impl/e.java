package com.ss.android.lark.reaction.service.impl;

import com.ss.android.lark.log.Log;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes37.dex */
public final class e<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final e<T> f439186a = null;

    static {
        f439186a = new e();
    }

    public e() {
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        Log.e("ReactionOrderService2", "onPushMRUReaction error", (Throwable) r100);
    }
}
