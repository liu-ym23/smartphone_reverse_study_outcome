package com.ss.android.lark.passportc.internal;

import com.larus.apm.impl.protector.RunnableProtector;
import java.util.Iterator;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: classes37.dex */
public final class i0 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Ref.ObjectRef<List<Function1<f0c.h, Unit>>> f438471a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ f0c.h f438472b;

    public i0(Ref.ObjectRef<List<Function1<f0c.h, Unit>>> r100, f0c.h r101) {
        this.f438471a = r100;
        this.f438472b = r101;
    }

    @Override // java.lang.Runnable
    public final void run() {
        List<Function1<f0c.h, Unit>> r100 = this.f438471a.element;     // Catch: Throwable -> L7
        f0c.h r101 = this.f438472b;     // Catch: Throwable -> L7
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
