package com.relax;

import android.content.Context;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes34.dex */
public final class n implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ o.b f404655a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Context f404656b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ RuntimeType f404657c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ float f404658d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ o f404659e;

    @Override // java.lang.Runnable
    public final void run() {
        o.b r100 = this.f404655a;     // Catch: Throwable -> L4
        o r101 = this.f404659e;     // Catch: Throwable -> L4
        Context r102 = this.f404656b;     // Catch: Throwable -> L4
        RuntimeType r103 = this.f404657c;     // Catch: Throwable -> L4
        float r104 = this.f404658d;     // Catch: Throwable -> L4
        r101.getClass();     // Catch: Throwable -> L4
        RelaxView.o r105 = (RelaxView.o) r100;     // Catch: Throwable -> L4
        r105.f404609a.f404565e = new RelaxEngine(r102, r103, r104);     // Catch: Throwable -> L4
        r105.f404609a.f404573m.countDown();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }

    public n(o r100, RelaxView.o r101, Context r102, RuntimeType r103, float r104) {
        this.f404659e = r100;
        this.f404655a = r101;
        this.f404656b = r102;
        this.f404657c = r103;
        this.f404658d = r104;
    }
}
