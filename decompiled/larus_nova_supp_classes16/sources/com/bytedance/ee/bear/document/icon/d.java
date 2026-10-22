package com.bytedance.ee.bear.document.icon;

import io.reactivex.functions.Consumer;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class d<T> implements Consumer {
    public final /* synthetic */ Function1<Throwable, Unit> a;

    /* JADX WARN: Multi-variable type inference failed */
    public d(Function1<? super Throwable, Unit> r1) {
        this.a = r1;
    }

    public final void accept(Object r2) {
        Function1<Throwable, Unit> r0 = this.a;
        r0.invoke((Throwable) r2);
    }
}
