package com.bytedance.live.zdanmaku;

import com.larus.apm.impl.protector.RunnableProtector;
import java.util.LinkedList;
import java.util.concurrent.LinkedBlockingDeque;

/* JADX INFO: loaded from: classes19.dex */
public final class g implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ e f255856a;

    public g(e r100) {
        this.f255856a = r100;
    }

    @Override // java.lang.Runnable
    public final void run() {
        DanmakuController<T> r100 = this.f255856a.f255846g;     // Catch: Throwable -> L4
        ((LinkedList) r100.f255815e).clear();     // Catch: Throwable -> L4
        ((LinkedBlockingDeque) r100.f255813c).clear();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
