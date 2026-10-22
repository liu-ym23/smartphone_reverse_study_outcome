package com.larus.home.impl.main.side_bar.view.group.datasource.im;

import com.larus.apm.impl.protector.RunnableProtector;
import com.obric.aivoice.core.data.IdlKeys;
import kotlin.Result;

/* JADX INFO: loaded from: classes29.dex */
public final class r implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ kotlinx.coroutines.i<Object> f345379a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f345380b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ String f345381c;

    public r(kotlinx.coroutines.j r100, String r101, String r102) {
        this.f345379a = r100;
        this.f345380b = r101;
        this.f345381c = r102;
    }

    public final void a() {
        if (this.f345379a.isActive() == false) goto L6;
        int r100 = com.larus.home.impl.main.side_bar.feed.arch.t.f344637a;
        com.larus.home.impl.main.side_bar.feed.arch.t.c(this.f345380b + IdlKeys.Args_GrantTimeout, this.f345381c);
        this.f345379a.resumeWith(Result.m9449constructorimpl(null));
        return;
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
