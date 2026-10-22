package com.bytedance.assem.jedi_vm.viewModel;

import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes14.dex */
public final class b implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ LifecycleAwareObserver f193127a;

    public b(LifecycleAwareObserver r100) {
        this.f193127a = r100;
    }

    @Override // java.lang.Runnable
    public final void run() {
        LifecycleAwareObserver.access$requireOwner(this.f193127a).getLifecycle().removeObserver(this.f193127a);     // Catch: Throwable -> L7
        if (this.f193127a.isDisposed() == true) goto L5;
        this.f193127a.dispose();     // Catch: Throwable -> L7
    L5:
        LifecycleAwareObserver.access$setOwner$p(this.f193127a, null);     // Catch: Throwable -> L7
        LifecycleAwareObserver.access$setSourceObserver$p(this.f193127a, null);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L11;
        return;
    L11:
        throw th;
    }
}
