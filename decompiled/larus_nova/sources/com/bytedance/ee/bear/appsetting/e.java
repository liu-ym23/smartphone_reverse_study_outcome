package com.bytedance.ee.bear.appsetting;

import java.util.List;
import java.util.concurrent.Callable;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes15.dex */
public final class e<V> implements Callable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Function1<List<String>, Unit> f206255a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ List<String> f206256b;

    /* JADX WARN: Multi-variable type inference failed */
    public e(Function1<? super List<String>, Unit> r100, List<String> r101) {
        this.f206255a = r100;
        this.f206256b = r101;
    }

    @Override // java.util.concurrent.Callable
    public final void call() {
        this.f206255a.invoke(this.f206256b);
    }

    @Override // java.util.concurrent.Callable
    public /* bridge */ /* synthetic */ Object call() {
        call();
        return Unit.INSTANCE;
    }
}
