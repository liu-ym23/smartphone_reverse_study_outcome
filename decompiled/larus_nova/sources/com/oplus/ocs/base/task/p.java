package com.oplus.ocs.base.task;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes34.dex */
final class p<TResult> implements Continuation<Void, List<TResult>> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Collection<? extends Task<?>> f404304a;

    public p(Collection<? extends Task<?>> r100) {
        this.f404304a = r100;
    }

    @Override // com.oplus.ocs.base.task.Continuation
    public final /* synthetic */ Object then(Task<Void> r100) {
        com.oplus.ocs.base.utils.d.a(r100);
        ArrayList r101 = new ArrayList();
        Iterator<? extends Task<?>> r102 = this.f404304a.iterator();
    L4:
        if (r102.hasNext() == false) goto L6;
        r101.add(r102.next().getResult());
        goto L4
    L6:
        return r101;
    }
}
