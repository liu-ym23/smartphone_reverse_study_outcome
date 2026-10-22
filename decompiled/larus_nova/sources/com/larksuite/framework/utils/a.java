package com.larksuite.framework.utils;

import com.larus.apm.impl.protector.RunnableProtector;
import java.util.Collections;

/* JADX INFO: loaded from: classes24.dex */
public final class a implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Object f285944a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ AndroidThrottle f285945b;

    /* JADX WARN: Type inference incomplete: some casts might be missing */
    @Override // java.lang.Runnable
    public final void run() {
        this.f285945b.f285872e.a(Collections.singletonList(this.f285944a));     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }

    public a(AndroidThrottle r100, wgb.b.RunnableC8112b r101) {
        this.f285945b = r100;
        this.f285944a = r101;
    }
}
