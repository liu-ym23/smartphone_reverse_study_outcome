package com.bytedance.ee.lark.infra.foundation.schedulers;

import java.util.concurrent.Callable;

/* JADX INFO: loaded from: classes19.dex */
public class CompletableCallable<V> implements Callable<V> {
    private Function<V> innerFunction;

    @Override // java.util.concurrent.Callable
    public V call() throws Exception {
        return this.innerFunction.fun();
    }

    public CompletableCallable(final Action r100) {
        this.innerFunction = new AnonymousClass1(this, r100);
    }

    public CompletableCallable(Function r100) {
        this.innerFunction = r100;
    }
}
