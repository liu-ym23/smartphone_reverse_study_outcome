package com.ss.android.lark.passport.flow.core.network;

import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes37.dex */
public final class k<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ AtomicBoolean f437781a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ AtomicReference<Disposable> f437782b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ kotlinx.coroutines.i<f> f437783c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ e f437784d;

    public k(AtomicBoolean r100, AtomicReference r101, kotlinx.coroutines.j r102, e r103) {
        this.f437781a = r100;
        this.f437782b = r101;
        this.f437783c = r102;
        this.f437784d = r103;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        Throwable r101 = (Throwable) r100;
        if (this.f437781a.compareAndSet(false, true) == false) goto L13;
        Disposable r102 = this.f437782b.getAndSet(null);
        if (r102 == null) goto L9;
        r102.dispose();
    L9:
        if (this.f437783c.isActive() == false) goto L12;
        kotlinx.coroutines.i<f> r103 = this.f437783c;
        Result.Companion r104 = Result.Companion;
        String r105 = this.f437784d.f437758c;
        Intrinsics.checkNotNull(r101);
        r103.resumeWith(Result.m9449constructorimpl(ResultKt.createFailure(new PassportHttpTransportException(r105, null, null, null, r101))));
        return;
    L12:
        return;
    }
}
