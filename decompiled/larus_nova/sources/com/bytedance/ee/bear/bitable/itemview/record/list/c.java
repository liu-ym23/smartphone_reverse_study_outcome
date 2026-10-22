package com.bytedance.ee.bear.bitable.itemview.record.list;

import com.larus.apm.impl.protector.RunnableProtector;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: classes15.dex */
public final class c implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ b f214137a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Ref.ObjectRef<Integer> f214138b;

    public c(b r100, Ref.ObjectRef<Integer> r101) {
        this.f214137a = r100;
        this.f214138b = r101;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f214137a.f214132b.t();     // Catch: Throwable -> L6
        Integer r100 = this.f214138b.element;     // Catch: Throwable -> L6
        if (r100 == null) goto L9;
        b r101 = this.f214137a;     // Catch: Throwable -> L6
        int r102 = r100.intValue();     // Catch: Throwable -> L6
        r101.f214132b.scrollToPosition(r102);     // Catch: Throwable -> L6
        return;
    L9:
        return;
    L6:
        th = move-exception;
        if (RunnableProtector.intercept(th) == true) goto L13;
        throw th;
    }
}
