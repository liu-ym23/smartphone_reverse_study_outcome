package com.bytedance.caijing.sdk.infra.base.impl.jsb.xbridge.bridge;

import com.larus.apm.impl.protector.RunnableProtector;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: classes15.dex */
public final class k0 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Function0<Unit> f202652a;

    public k0(Function0<Unit> r100) {
        this.f202652a = r100;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f202652a.invoke();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
