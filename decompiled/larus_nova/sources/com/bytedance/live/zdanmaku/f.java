package com.bytedance.live.zdanmaku;

import com.larus.apm.impl.protector.RunnableProtector;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes19.dex */
public final class f implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ e f255853a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Function1 f255854b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Function1 f255855c;

    public f(e r100, Function1 r101, Function1 r102) {
        this.f255853a = r100;
        this.f255854b = r101;
        this.f255855c = r102;
    }

    public final void a() {
        DanmakuController<T> r100 = this.f255853a.f255846g;
        final Function1 r101 = this.f255854b;
        final Function1 r102 = this.f255855c;
        CollectionsKt.removeAll(r100.f255814d, new DanmakuController$clearAllDanmaku$1(r101));
        CollectionsKt.removeAll(r100.f255815e, new DanmakuController$clearAllDanmaku$2(r101));
        CollectionsKt.removeAll(r100.f255813c, new DanmakuController$clearAllDanmaku$3(r102));
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
