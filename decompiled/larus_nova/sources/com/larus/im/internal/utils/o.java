package com.larus.im.internal.utils;

import java.util.Iterator;

/* JADX INFO: loaded from: classes4.dex */
public final class o implements gd9.l.b {
    public o() {
    }

    @Override // gd9.l.b
    public final void onAppLifeCycleChange(boolean r100) {
        Iterator<LifecycleManager.a> r101 = LifecycleManager.f350520c.iterator();
    L4:
        if (r101.hasNext() == false) goto L6;
        r101.next().a(!r100);
        goto L4
    L6:
        com.larus.im.internal.delegate.a.f348188b.i(LifecycleManager.f350519b, "app on " + r100);
    }
}
