package com.bytedance.ee.bear.middleground.comment.card.aside;

import com.larus.apm.impl.protector.RunnableProtector;
import kotlin.Result;
import kotlin.Unit;

/* JADX INFO: loaded from: classes18.dex */
public final class a implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ kotlinx.coroutines.i<Unit> f230942a;

    public a(kotlinx.coroutines.j r100) {
        this.f230942a = r100;
    }

    @Override // java.lang.Runnable
    public final void run() {
    L8:
        th = move-exception;
        if (RunnableProtector.intercept(th) == true) goto L16;
        throw th;
    L16:
        return;
    L3:
        if (this.f230942a.isActive() == true) goto L5;
        return;
    L5:
        if (this.f230942a.isCancelled() == true) goto L15;
        kotlinx.coroutines.i<Unit> r100 = this.f230942a;     // Catch: Throwable -> L8
        Result.Companion r101 = Result.Companion;     // Catch: Throwable -> L8
        r100.resumeWith(Result.m9449constructorimpl(Unit.INSTANCE));     // Catch: Throwable -> L8
        return;
    }
}
