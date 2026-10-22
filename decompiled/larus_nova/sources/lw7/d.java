package lw7;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kw7.f;
import nv3.g;

/* JADX INFO: loaded from: classes23.dex */
public final class d<TResult> extends kw7.d<TResult> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Object f511041a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f511042b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public TResult f511043c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Exception f511044d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public List<kw7.a<TResult>> f511045e;

    @Override // kw7.d
    public final void c() {
    }

    @Override // kw7.d
    public final Exception a() {
        Object r100 = this.f511041a;
        monitor-enter(r100);
        Exception r101 = this.f511044d;     // Catch: Throwable -> L7
        monitor-exit(r100);     // Catch: Throwable -> L7
        return r101;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // kw7.d
    public final TResult b() {
        Object r100 = this.f511041a;
        monitor-enter(r100);
    L11:
        th = move-exception;
        throw th;
    L5:
        if (this.f511044d != null) goto L10;
        TResult r101 = this.f511043c;     // Catch: Throwable -> L11
        monitor-exit(r100);     // Catch: Throwable -> L11
        return r101;
    L10:
        throw new RuntimeException(this.f511044d);     // Catch: Throwable -> L11
    }

    @Override // kw7.d
    public final boolean d() {
        Object r100 = this.f511041a;
        monitor-enter(r100);
    L12:
        th = move-exception;
        throw th;
    L5:
        if (this.f511042b == true) goto L7;
    L9:
        boolean r101 = false;
    L10:
        monitor-exit(r100);     // Catch: Throwable -> L12
        return r101;
    L7:
        if (this.f511044d != null) goto L9;
        r101 = true;
        goto L10
    }

    public final void g() {
        Object r100 = this.f511041a;
        monitor-enter(r100);
        Iterator<kw7.a<TResult>> r101 = this.f511045e.iterator();     // Catch: Throwable -> L18
    L6:
        if (r101.hasNext() == false) goto L15;
        r101.next().a(this);     // Catch: Exception -> L10 RuntimeException -> L13 Throwable -> L18
    L13:
        e = move-exception;
        throw e;     // Catch: Throwable -> L18
    L10:
        e = move-exception;
        throw new RuntimeException(e);     // Catch: Throwable -> L18
    L15:
        this.f511045e = null;     // Catch: Throwable -> L18
        monitor-exit(r100);     // Catch: Throwable -> L18
        return;
    L18:
        th = move-exception;
        throw th;
    }

    public final boolean h() {
        Object r100 = this.f511041a;
        monitor-enter(r100);
        boolean r101 = this.f511042b;     // Catch: Throwable -> L7
        monitor-exit(r100);     // Catch: Throwable -> L7
        return r101;
    L7:
        th = move-exception;
        throw th;
    }

    public d() {
        this.f511041a = new Object();
        this.f511045e = new ArrayList();
    }

    public final d e(g r100) {
        a r101 = new a(f.f506403c.f506405b, r100);
        Object r102 = this.f511041a;
        monitor-enter(r102);
        boolean r103 = h();     // Catch: Throwable -> L11
        if (r103 == true) goto L7;
        ((ArrayList) this.f511045e).add(r101);     // Catch: Throwable -> L11
    L7:
        monitor-exit(r102);     // Catch: Throwable -> L11
        if (r103 == false) goto L10;
        r101.a(this);
    L10:
        return this;
    L11:
        th = move-exception;
        throw th;
    }

    public final d f(nv3.f r100) {
        b r101 = new b(f.f506403c.f506405b, r100);
        Object r102 = this.f511041a;
        monitor-enter(r102);
        boolean r103 = h();     // Catch: Throwable -> L11
        if (r103 == true) goto L7;
        ((ArrayList) this.f511045e).add(r101);     // Catch: Throwable -> L11
    L7:
        monitor-exit(r102);     // Catch: Throwable -> L11
        if (r103 == false) goto L10;
        r101.a(this);
    L10:
        return this;
    L11:
        th = move-exception;
        throw th;
    }
}
