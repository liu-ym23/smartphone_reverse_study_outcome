package com.bytedance.ies.bullet.kit.resourceloader.loader;

import com.bytedance.ies.bullet.service.base.d1;
import java.util.concurrent.Callable;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import v26.l;

/* JADX INFO: loaded from: classes19.dex */
public final class a<V> implements Callable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ GeckoLoader f246860a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ d1 f246861b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ l f246862c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ Function1<d1, Unit> f246863d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ Function1<Throwable, Unit> f246864e;

    /* JADX WARN: Multi-variable type inference failed */
    public a(GeckoLoader r100, d1 r101, l r102, Function1<? super d1, Unit> r103, Function1<? super Throwable, Unit> r104) {
        this.f246860a = r100;
        this.f246861b = r101;
        this.f246862c = r102;
        this.f246863d = r103;
        this.f246864e = r104;
    }

    @Override // java.util.concurrent.Callable
    public final void call() {
        GeckoLoader r100 = this.f246860a;
        d1 r101 = this.f246861b;
        l r102 = this.f246862c;
        Function1<d1, Unit> r103 = this.f246863d;
        Function1<Throwable, Unit> r104 = this.f246864e;
        int r105 = GeckoLoader.f246846b;
        r100.b(false, r101, r102, null, r103, r104);
    }

    @Override // java.util.concurrent.Callable
    public /* bridge */ /* synthetic */ Object call() {
        call();
        return Unit.INSTANCE;
    }
}
