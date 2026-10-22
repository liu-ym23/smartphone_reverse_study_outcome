package com.obric.assistant.obric_action.handler.prompt;

import com.larus.apm.impl.protector.RunnableProtector;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: classes33.dex */
public final class g implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Ref.BooleanRef f390500a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ kotlinx.coroutines.i<j> f390501b;

    /* JADX WARN: Multi-variable type inference failed */
    public g(Ref.BooleanRef r100, kotlinx.coroutines.i<? super j> r101) {
        this.f390500a = r100;
        this.f390501b = r101;
    }

    @Override // java.lang.Runnable
    public final void run() {
        h.b(this.f390500a, this.f390501b, new j("dismissed", 14));     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
