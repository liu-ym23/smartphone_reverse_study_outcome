package com.bytedance.bdinstall;

import com.larus.apm.impl.protector.RunnableProtector;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: loaded from: classes8.dex */
public final class m0 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ i0.d f199718a;

    @Override // java.lang.Runnable
    public final void run() {
        Iterator r100 = new ArrayList(this.f199718a.f199668a).iterator();     // Catch: Throwable -> L9
    L4:
        if (r100.hasNext() == false) goto L21;
        i0.d.a r101 = (i0.d.a) ((WeakReference) r100.next()).get();     // Catch: Throwable -> L9
        if (r101 == null) goto L4;
        r101.onNetworkReady();     // Catch: Throwable -> L9
        goto L4
    L21:
        return;
    L9:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L13;
        return;
    L13:
        throw th;
    }

    public m0(i0.d r100) {
        this.f199718a = r100;
    }
}
