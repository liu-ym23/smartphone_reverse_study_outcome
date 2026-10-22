package com.bytedance.locallife.sdk;

import com.larus.apm.impl.protector.RunnableProtector;
import kotlin.Result;
import kotlin.ResultKt;

/* JADX INFO: loaded from: classes21.dex */
public final class b implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ a f264340a;

    public b(a r100) {
        this.f264340a = r100;
    }

    public final void a() {
    L56:
        a r100 = this.f264340a;     // Catch: Throwable -> L34
        Object r101 = r100.f264331c;     // Catch: Throwable -> L34
        monitor-enter(r101);     // Catch: Throwable -> L34
    L31:
        th = move-exception;
        throw th;     // Catch: Throwable -> L34
    L6:
        if (r100.f264332d.isEmpty() == false) goto L8;
        a.b r102 = null;
    L9:
        monitor-exit(r101);     // Catch: Throwable -> L34
        if (r102 == null) goto L11;
        a r103 = this.f264340a;     // Catch: Throwable -> L34
        Result.Companion r104 = Result.Companion;     // Catch: Throwable -> L27
        r103.getClass();     // Catch: Throwable -> L27
        throw null;     // Catch: Throwable -> L27
    L27:
        th = move-exception;
        Result.Companion r105 = Result.Companion;     // Catch: Throwable -> L34
        if (Result.m9452exceptionOrNullimpl(Result.m9449constructorimpl(ResultKt.createFailure(th))) == null) goto L56;
        goto L56
    L11:
        this.f264340a.f264337i.set(false);
        a r106 = this.f264340a;
        Object r107 = r106.f264331c;
        monitor-enter(r107);
        boolean r108 = !r106.f264332d.isEmpty();
        monitor-exit(r107);
        if (r108 == true) goto L18;
        return;
    L18:
        if (this.f264340a.f264330b.invoke().booleanValue() == false) goto L65;
        a.a(this.f264340a);
        return;
    L65:
        return;
    L21:
        th = move-exception;
        throw th;
    L8:
        r102 = r100.f264332d.removeFirst();     // Catch: Throwable -> L31
    L34:
        th = move-exception;
        this.f264340a.f264337i.set(false);
        a r109 = this.f264340a;
        monitor-enter(r109.f264331c);
        if ((!r109.f264332d.isEmpty()) == true) goto L42;
    L44:
        throw th;
    L42:
        if (this.f264340a.f264330b.invoke().booleanValue() == false) goto L44;
        a.a(this.f264340a);
    L45:
        th = move-exception;
        throw th;
    }

    @Override // java.lang.Runnable
    public final void run() {
        a();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
