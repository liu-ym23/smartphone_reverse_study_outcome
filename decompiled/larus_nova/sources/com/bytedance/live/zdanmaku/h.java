package com.bytedance.live.zdanmaku;

import com.larus.apm.impl.protector.RunnableProtector;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes19.dex */
public final class h implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ e f255857a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Function1 f255858b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Function1 f255859c;

    public h(e r100, Function1 r101, Function1 r102) {
        this.f255857a = r100;
        this.f255858b = r101;
        this.f255859c = r102;
    }

    @Override // java.lang.Runnable
    public final void run() {
        DanmakuController<T> r100 = this.f255857a.f255846g;     // Catch: Throwable -> L4
        final Function1 r101 = this.f255858b;     // Catch: Throwable -> L4
        final Function1 r102 = this.f255859c;     // Catch: Throwable -> L4
        CollectionsKt.removeAll(r100.f255815e, new DanmakuController$clearBufferDanmaku$1(r101));     // Catch: Throwable -> L4
        CollectionsKt.removeAll(r100.f255813c, new DanmakuController$clearBufferDanmaku$2(r102));     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
