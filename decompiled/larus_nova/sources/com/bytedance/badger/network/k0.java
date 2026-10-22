package com.bytedance.badger.network;

import com.larus.apm.impl.protector.RunnableProtector;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes47.dex */
public final class k0 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Function0 f199117a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Function1 f199118b;

    public k0(Function0 r100, Function1 r101) {
        this.f199117a = r100;
        this.f199118b = r101;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Object r100 = Result.m9449constructorimpl(this.f199117a.invoke());     // Catch: Throwable -> L4
    L6:
        Throwable r101 = Result.m9452exceptionOrNullimpl(r100);     // Catch: Throwable -> L12
        if (r101 == null) goto L15;
        Function1 r102 = this.f199118b;     // Catch: Throwable -> L12
        if (r102 == null) goto L20;
        Unit r103 = (Unit) r102.invoke(r101);     // Catch: Throwable -> L12
        return;
    L20:
        return;
    L15:
        return;
    L12:
        th = move-exception;
        if (RunnableProtector.intercept(th) == true) goto L21;
        throw th;
    L21:
        return;
    L4:
        th = move-exception;
        r100 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L12
        goto L6
    }
}
