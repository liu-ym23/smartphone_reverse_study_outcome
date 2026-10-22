package ww7;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes23.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Object f561648a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f561649b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Object f561650c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Exception f561651d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public List<y<Object>> f561652e;

    public final void a() {
        Object r100 = this.f561648a;
        monitor-enter(r100);
        Iterator<y<Object>> r101 = this.f561652e.iterator();     // Catch: Throwable -> L18
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
        this.f561652e = null;     // Catch: Throwable -> L18
        monitor-exit(r100);     // Catch: Throwable -> L18
        return;
    L18:
        th = move-exception;
        throw th;
    }

    public final Exception c() {
        Object r100 = this.f561648a;
        monitor-enter(r100);
        Exception r101 = this.f561651d;     // Catch: Throwable -> L7
        monitor-exit(r100);     // Catch: Throwable -> L7
        return r101;
    L7:
        th = move-exception;
        throw th;
    }

    public final Object d() {
        Object r100 = this.f561648a;
        monitor-enter(r100);
    L11:
        th = move-exception;
        throw th;
    L5:
        if (this.f561651d != null) goto L10;
        Object r101 = this.f561650c;     // Catch: Throwable -> L11
        monitor-exit(r100);     // Catch: Throwable -> L11
        return r101;
    L10:
        throw new RuntimeException(this.f561651d);     // Catch: Throwable -> L11
    }

    public final void e() {
        Object r100 = this.f561648a;
        monitor-enter(r100);
        monitor-exit(r100);     // Catch: Throwable -> L6
        return;
    L6:
        th = move-exception;
        throw th;
    }

    public final boolean f() {
        Object r100 = this.f561648a;
        monitor-enter(r100);
    L12:
        th = move-exception;
        throw th;
    L5:
        if (this.f561649b == false) goto L9;
        e();     // Catch: Throwable -> L12
        if (this.f561651d != null) goto L9;
        boolean r101 = true;
    L10:
        monitor-exit(r100);     // Catch: Throwable -> L12
        return r101;
    L9:
        r101 = false;
        goto L10
    }

    public e() {
        this.f561648a = new Object();
        this.f561652e = new ArrayList();
    }

    public final void b(y r100) {
        Object r101 = this.f561648a;
        monitor-enter(r101);
    L10:
        th = move-exception;
        throw th;
    L5:
        if (this.f561649b == true) goto L7;
        ((ArrayList) this.f561652e).add(r100);     // Catch: Throwable -> L10
    L8:
        monitor-exit(r101);     // Catch: Throwable -> L10
        return;
    L7:
        r100.a(this);     // Catch: Throwable -> L10
        goto L8
    }
}
