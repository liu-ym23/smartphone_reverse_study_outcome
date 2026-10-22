package com.larksuite.framework.callback;

import android.os.Handler;
import androidx.arch.core.util.Function;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.WeakHashMap;

/* JADX INFO: loaded from: classes24.dex */
public final class c extends a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final WeakHashMap<Runnable, WeakReference<Runnable>> f285566b;

    public final void d() {
        monitor-enter(this);
        Iterator<Runnable> r100 = this.f285566b.keySet().iterator();     // Catch: Throwable -> L14
    L5:
        if (r100.hasNext() == false) goto L11;
        Runnable r101 = r100.next();     // Catch: Throwable -> L14
        WeakReference<Runnable> r102 = this.f285566b.get(r101);     // Catch: Throwable -> L14
        if (r102 == null) goto L5;
        Runnable r103 = r102.get();     // Catch: Throwable -> L14
        if (r103 == null) goto L5;
        this.f285564a.removeCallbacks(r103);     // Catch: Throwable -> L14
        goto L5
    L11:
        this.f285566b.clear();     // Catch: Throwable -> L14
        monitor-exit(this);     // Catch: Throwable -> L14
        return;
    L14:
        th = move-exception;
        throw th;
    }

    public c(Handler r100) {
        super(r100);
        this.f285566b = new WeakHashMap();
    }

    @Override // com.larksuite.framework.callback.a
    public final void a(Runnable r100) {
        Function<? super Runnable, ? extends Runnable> r101 = b.f285565a;
        if (r101 == null) goto L5;
        Runnable r102 = r101.apply(r100);
    L6:
        monitor-enter(this);
        this.f285566b.put(r100, new WeakReference(r102));     // Catch: Throwable -> L11
        monitor-exit(this);     // Catch: Throwable -> L11
        super.a(r102);
        return;
    L11:
        th = move-exception;
        throw th;
    L5:
        r102 = r100;
        goto L6
    }

    public final void c(Runnable r100) {
        monitor-enter(this);
        WeakReference<Runnable> r101 = this.f285566b.remove(r100);     // Catch: Throwable -> L12
        if (r101 != null) goto L7;
        monitor-exit(this);     // Catch: Throwable -> L12
        return;
    L7:
        Runnable r102 = r101.get();     // Catch: Throwable -> L12
        monitor-exit(this);     // Catch: Throwable -> L12
        if (r102 == null) goto L16;
        this.f285564a.removeCallbacks(r102);
        return;
    L16:
        return;
    L12:
        th = move-exception;
        throw th;
    }

    @Override // com.larksuite.framework.callback.a
    public final void b(Runnable r100, long r101) {
        Function<? super Runnable, ? extends Runnable> r102 = b.f285565a;
        if (r102 == null) goto L5;
        Runnable r103 = r102.apply(r100);
    L6:
        monitor-enter(this);
        this.f285566b.put(r100, new WeakReference(r103));     // Catch: Throwable -> L11
        monitor-exit(this);     // Catch: Throwable -> L11
        super.b(r103, r101);
        return;
    L11:
        th = move-exception;
        throw th;
    L5:
        r103 = r100;
        goto L6
    }
}
