package dvc;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.NoSuchElementException;

/* JADX INFO: loaded from: classes42.dex */
public final class g implements Iterator<e.d> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Iterator<e.c> f470280a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public e.d f470281b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public e.d f470282c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ e f470283d;

    @Override // java.util.Iterator
    public final boolean hasNext() {
        if (this.f470281b == null) goto L5;
        return true;
    L5:
        e r100 = this.f470283d;
        monitor-enter(r100);
    L24:
        th = move-exception;
        throw th;
    L8:
        if (this.f470283d.f470255o == false) goto L12;
        monitor-exit(r100);     // Catch: Throwable -> L24
        return false;
    L12:
        if (this.f470280a.hasNext() == false) goto L22;
        e.c r101 = this.f470280a.next();     // Catch: Throwable -> L24
        if (r101.f470271e == false) goto L12;
        e.d r102 = r101.a();     // Catch: Throwable -> L24
        if (r102 == null) goto L12;
        this.f470281b = r102;     // Catch: Throwable -> L24
        monitor-exit(r100);     // Catch: Throwable -> L24
        return true;
    L22:
        monitor-exit(r100);     // Catch: Throwable -> L24
        return false;
    }

    @Override // java.util.Iterator
    public final void remove() {
        e.d r100 = this.f470282c;
        if (r100 == null) goto L13;
        this.f470283d.m(r100.f470275a);     // Catch: Throwable -> L7 IOException -> L14
    L7:
        th = move-exception;
        this.f470282c = null;
        throw th;
    L10:
        this.f470282c = null;
        return;
    L13:
        throw new IllegalStateException("remove() before next()");
    }

    @Override // java.util.Iterator
    public final e.d next() {
        if (hasNext() == false) goto L7;
        e.d r100 = this.f470281b;
        this.f470282c = r100;
        this.f470281b = null;
        return r100;
    L7:
        throw new NoSuchElementException();
    }

    public g(e r100) {
        this.f470283d = r100;
        this.f470280a = new ArrayList(r100.f470251k.values()).iterator();
    }
}
