package com.bytedance.ee.bear.bitable.infoarch.nativeview.common.list;

import com.bytedance.ee.bear.bitable.infoarch.nativeview.common.NativeViewRenderEnd;
import com.larus.apm.impl.protector.RunnableProtector;
import dt4.k;

/* JADX INFO: loaded from: classes15.dex */
public final class d implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ k<Object> f213365a;

    public d(k<Object> r100) {
        this.f213365a = r100;
    }

    @Override // java.lang.Runnable
    public final void run() {
        com.bytedance.ee.bear.bitable.infoarch.nativeview.b.b("onSwitchView", "onSwitchView post run");     // Catch: Throwable -> L4
        this.f213365a.e().a(new NativeViewRenderEnd());     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
