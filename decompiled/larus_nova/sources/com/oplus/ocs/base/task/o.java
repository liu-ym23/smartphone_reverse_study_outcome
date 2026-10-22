package com.oplus.ocs.base.task;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/* JADX INFO: loaded from: classes34.dex */
final class o implements Continuation<Void, Task<List<Task<?>>>> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Collection f404303a;

    public o(Collection r100) {
        this.f404303a = r100;
    }

    @Override // com.oplus.ocs.base.task.Continuation
    public final /* synthetic */ Task<List<Task<?>>> then(Task<Void> r100) {
        com.oplus.ocs.base.utils.d.a(r100);
        ArrayList r101 = new ArrayList();
        r101.addAll(this.f404303a);
        return Tasks.forResult(r101);
    }
}
