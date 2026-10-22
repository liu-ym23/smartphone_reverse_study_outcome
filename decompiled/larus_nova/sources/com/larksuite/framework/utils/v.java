package com.larksuite.framework.utils;

/* JADX INFO: loaded from: classes24.dex */
public class v<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Object[] f286045a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f286046b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Object f286047c;

    public T a(Object... r100) {
        throw null;
    }

    public boolean b(T r100, Object... r101) {
        return true;
    }

    public v(int r100) {
        this.f286047c = new Object();
        this.f286045a = new Object[r100];
        this.f286046b = 0;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final T c(Object... r100) {
        Object r101 = this.f286047c;
        monitor-enter(r101);
        int r102 = this.f286046b;     // Catch: Throwable -> L19
        T r103 = null;
        if (r102 <= 0) goto L15;
        int r104 = r102 - 1;     // Catch: Throwable -> L19
        int r105 = r104;
    L7:
        if (r105 < 0) goto L15;
        Object r106 = this.f286045a[r105];     // Catch: Throwable -> L19
        if (b(r106, r100) == true) goto L10;
        r105 = r105 - 1;     // Catch: Throwable -> L19
        goto L7
    L10:
        int r107 = r104 - r105;     // Catch: Throwable -> L19
        if (r107 <= 0) goto L13;
        Object[] r108 = this.f286045a;     // Catch: Throwable -> L19
        System.arraycopy(r108, r105 + 1, r108, r105, r107);     // Catch: Throwable -> L19
    L13:
        this.f286045a[r104] = null;     // Catch: Throwable -> L19
        this.f286046b--;     // Catch: Throwable -> L19
        r103 = (T) r106;
    L15:
        monitor-exit(r101);     // Catch: Throwable -> L19
        if (r103 == null) goto L18;
        return r103;
    L18:
        return (T) a(r100);
    L19:
        th = move-exception;
        throw th;
    }

    public final void d(T r100) {
        Object r101 = this.f286047c;
        monitor-enter(r101);
        boolean r102 = false;
        int r103 = 0;
    L23:
        int r104 = this.f286046b;     // Catch: Throwable -> L21
        if (r103 >= r104) goto L11;
        if (this.f286045a[r103] == r100) goto L9;
        r103 = r103 + 1;     // Catch: Throwable -> L21
        goto L23
    L9:
        r102 = true;
    L11:
        if (r102 == false) goto L14;
        monitor-exit(r101);     // Catch: Throwable -> L21
        return;
    L14:
        Object[] r105 = this.f286045a;     // Catch: Throwable -> L21
        if (r104 >= r105.length) goto L17;
        r105[r104] = r100;     // Catch: Throwable -> L21
        this.f286046b = r104 + 1;     // Catch: Throwable -> L21
    L17:
        monitor-exit(r101);     // Catch: Throwable -> L21
        return;
    L21:
        th = move-exception;
        throw th;
    }
}
