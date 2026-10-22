package com.bytedance.locallife.sdk;

import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes21.dex */
public final class d implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ a f264342a;

    public d(a r100) {
        this.f264342a = r100;
    }

    public final void a() {
        if (this.f264342a.f264336h.get() == false) goto L6;
        return;
    L6:
        if (this.f264342a.f264334f.get() == true) goto L8;
        return;
    L8:
        a r100 = this.f264342a;
        r100.f264329a.removeObserver(r100.f264339k);
        this.f264342a.f264334f.set(false);
        this.f264342a.f264336h.set(true);
    }

    @Override // java.lang.Runnable
    public final void run() {
        a();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
