package com.huawei.hmf.tasks.a;

import com.huawei.hmf.tasks.CancellationToken;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes23.dex */
public class c extends CancellationToken {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<Runnable> f276777a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Object f276778b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f276779c;

    public c() {
        this.f276777a = new ArrayList();
        this.f276778b = new Object();
        this.f276779c = false;
    }

    public final void a() {
        if (this.f276779c == false) goto L5;
        return;
    L5:
        Object r100 = this.f276778b;
        monitor-enter(r100);
        this.f276779c = true;     // Catch: Throwable -> L14
        Iterator<Runnable> r101 = this.f276777a.iterator();     // Catch: Throwable -> L14
    L10:
        if (r101.hasNext() == false) goto L12;
        r101.next().run();     // Catch: Throwable -> L14
        goto L10
    L12:
        monitor-exit(r100);     // Catch: Throwable -> L14
        return;
    L14:
        th = move-exception;
        throw th;
    }

    @Override // com.huawei.hmf.tasks.CancellationToken
    public boolean isCancellationRequested() {
        return this.f276779c;
    }

    @Override // com.huawei.hmf.tasks.CancellationToken
    public CancellationToken register(Runnable r100) {
        Object r101 = this.f276778b;
        monitor-enter(r101);
    L10:
        th = move-exception;
        throw th;
    L5:
        if (this.f276779c == false) goto L7;
        r100.run();     // Catch: Throwable -> L10
    L8:
        monitor-exit(r101);     // Catch: Throwable -> L10
        return this;
    L7:
        this.f276777a.add(r100);     // Catch: Throwable -> L10
        goto L8
    }
}
