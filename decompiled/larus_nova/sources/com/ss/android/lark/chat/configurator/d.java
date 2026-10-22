package com.ss.android.lark.chat.configurator;

import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.chat.base.view.recycleview.ItemShineManager;

/* JADX INFO: loaded from: classes35.dex */
public final class d implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ItemShineManager<?> f414737a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ ItemShineManager f414738b;

    public d(ItemShineManager<?> r100, ItemShineManager r101) {
        this.f414737a = r100;
        this.f414738b = r101;
    }

    @Override // java.lang.Runnable
    public final void run() {
        ItemShineManager<?> r100 = this.f414737a;     // Catch: Throwable -> L12
        if (r100 == null) goto L7;
        g2b.a r101 = r100.f411800e;     // Catch: Throwable -> L12
        if (r101 == null) goto L7;
        r101.cancel();     // Catch: Throwable -> L12
    L7:
        ItemShineManager r102 = this.f414738b;     // Catch: Throwable -> L12
        if (r102.f411800e != null) goto L10;
        r102.a();     // Catch: Throwable -> L12
    L10:
        r102.f411800e.b();     // Catch: Throwable -> L12
        return;
    L12:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L16;
        return;
    L16:
        throw th;
    }
}
