package com.bytedance.assem.jedi_vm.viewModel;

import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class b implements Runnable {
    public final /* synthetic */ LifecycleAwareObserver a;

    public b(LifecycleAwareObserver r1) {
        this.a = r1;
    }

    @Override // java.lang.Runnable
    public final void run() {
        LifecycleAwareObserver.access$requireOwner(this.a).getLifecycle().removeObserver(this.a);     // Catch: Throwable -> L7
        if (this.a.isDisposed() == true) goto L5;
        this.a.dispose();     // Catch: Throwable -> L7
    L5:
        LifecycleAwareObserver.access$setOwner$p(this.a, null);     // Catch: Throwable -> L7
        LifecycleAwareObserver.access$setSourceObserver$p(this.a, null);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L11;
        return;
    L11:
        throw th;
    }
}
