package com.ss.android.lark.passportc.internal;

import com.larus.apm.impl.protector.RunnableProtector;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes37.dex */
public final class m implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Function1<f0c.b, Unit> f438474a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ f0c.b f438475b;

    public m(com.ss.android.lark.passportc.ffi.a.C5240a r100, f0c.b r101) {
        this.f438474a = r100;
        this.f438475b = r101;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f438474a.invoke(this.f438475b);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
