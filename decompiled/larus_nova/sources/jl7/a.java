package jl7;

import java.util.ArrayList;
import xk7.e;

/* JADX INFO: loaded from: classes3.dex */
public class a<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public T f499530a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ArrayList<b<T>> f499531b;

    public a() {
        this.f499530a = null;
        this.f499531b = new ArrayList();
    }

    public final void a(e r100) {
        ArrayList<b<T>> r101 = this.f499531b;
        monitor-enter(r101);
    L11:
        th = move-exception;
        throw th;
    L5:
        if (this.f499531b.contains(r100) == true) goto L9;
        this.f499531b.add(r100);     // Catch: Throwable -> L11
        T r102 = this.f499530a;     // Catch: Throwable -> L11
        if (r102 == null) goto L9;
        r100.a(r102);     // Catch: Throwable -> L11
    L9:
        monitor-exit(r101);     // Catch: Throwable -> L11
    }

    public void b(e r100) {
        ArrayList<b<T>> r101 = this.f499531b;
        monitor-enter(r101);
        this.f499531b.remove(r100);     // Catch: Throwable -> L7
        monitor-exit(r101);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }
}
