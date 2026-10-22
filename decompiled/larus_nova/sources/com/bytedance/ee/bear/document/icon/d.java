package com.bytedance.ee.bear.document.icon;

import io.reactivex.functions.Consumer;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes16.dex */
public final class d<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Function1<Throwable, Unit> f219991a;

    /* JADX WARN: Multi-variable type inference failed */
    public d(Function1<? super Throwable, Unit> r100) {
        this.f219991a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        Function1<Throwable, Unit> r101 = this.f219991a;
        r101.invoke((Throwable) r100);
    }
}
