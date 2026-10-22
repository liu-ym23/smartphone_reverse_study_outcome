package com.ss.android.lark.sticker.core.impl;

import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.sticker.core.model.PushCustomizedStickersRequest;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: classes38.dex */
public final class d implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ c f440813a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ PushCustomizedStickersRequest f440814b;

    public d(c r100, PushCustomizedStickersRequest r101) {
        this.f440813a = r100;
        this.f440814b = r101;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Iterator r100 = ((CopyOnWriteArrayList) this.f440813a.f440807c).iterator();     // Catch: Throwable -> L7
    L4:
        if (r100.hasNext() == false) goto L16;
        ((e6c.b.a) r100.next()).a(this.f440814b);     // Catch: Throwable -> L7
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
