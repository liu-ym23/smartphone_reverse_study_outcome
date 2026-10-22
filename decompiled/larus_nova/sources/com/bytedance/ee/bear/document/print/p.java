package com.bytedance.ee.bear.document.print;

import com.larus.apm.impl.protector.RunnableProtector;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes16.dex */
public final class p implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ PrintMinutesOptionSelector f221206a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ long f221207b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ oj5.c f221208c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ Boolean f221209d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ Function1<String, Unit> f221210e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final /* synthetic */ Function0<Unit> f221211f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final /* synthetic */ Function0<Unit> f221212g;

    /* JADX WARN: Multi-variable type inference failed */
    public p(PrintMinutesOptionSelector r100, long r101, oj5.c r102, Boolean r103, Function1<? super String, Unit> r104, Function0<Unit> r105, Function0<Unit> r106) {
        this.f221206a = r100;
        this.f221207b = r101;
        this.f221208c = r102;
        this.f221209d = r103;
        this.f221210e = r104;
        this.f221211f = r105;
        this.f221212g = r106;
    }

    @Override // java.lang.Runnable
    public final void run() {
        PrintMinutesOptionSelector r100 = this.f221206a;     // Catch: Throwable -> L7
        long r101 = this.f221207b;     // Catch: Throwable -> L7
        int r102 = PrintMinutesOptionSelector.f221126e;     // Catch: Throwable -> L7
        if (r100.f(r101) == false) goto L10;
        this.f221206a.h(this.f221207b, this.f221208c, Intrinsics.areEqual(this.f221209d, Boolean.TRUE), this.f221210e, this.f221211f, this.f221212g);     // Catch: Throwable -> L7
        return;
    L10:
        return;
    L7:
        th = move-exception;
        if (RunnableProtector.intercept(th) == true) goto L14;
        throw th;
    }
}
