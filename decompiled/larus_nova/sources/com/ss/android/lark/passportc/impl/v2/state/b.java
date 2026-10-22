package com.ss.android.lark.passportc.impl.v2.state;

import com.larus.apm.impl.protector.RunnableProtector;
import java.util.Iterator;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes37.dex */
public final class b implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ List<Function1<f0c.b, Unit>> f438301a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ f0c.b f438302b;

    /* JADX WARN: Multi-variable type inference failed */
    public b(List<? extends Function1<? super f0c.b, Unit>> r100, f0c.b r101) {
        this.f438301a = r100;
        this.f438302b = r101;
    }

    @Override // java.lang.Runnable
    public final void run() {
        List<Function1<f0c.b, Unit>> r100 = this.f438301a;     // Catch: Throwable -> L7
        f0c.b r101 = this.f438302b;     // Catch: Throwable -> L7
        Iterator<T> r102 = r100.iterator();     // Catch: Throwable -> L7
    L4:
        if (r102.hasNext() == false) goto L16;
        ((Function1) r102.next()).invoke(r101);     // Catch: Throwable -> L7
        goto L4
    L16:
        return;
    L7:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L11;
        return;
    L11:
        throw th;
    }
}
