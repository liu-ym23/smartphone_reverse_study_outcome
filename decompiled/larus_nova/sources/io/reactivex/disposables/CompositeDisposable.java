package io.reactivex.disposables;

import com.bytedance.mt.protector.impl.collections.ListProtector;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.util.ExceptionHelper;
import io.reactivex.internal.util.OpenHashSet;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: loaded from: classes41.dex */
public final class CompositeDisposable implements Disposable, utc.a {
    volatile boolean disposed;
    OpenHashSet<Disposable> resources;

    public void clear() {
        if (this.disposed == false) goto L5;
        return;
    L5:
        monitor-enter(this);
    L14:
        th = move-exception;
        throw th;
    L7:
        if (this.disposed == false) goto L10;
        monitor-exit(this);     // Catch: Throwable -> L14
        return;
    L10:
        OpenHashSet<Disposable> r100 = this.resources;     // Catch: Throwable -> L14
        this.resources = null;     // Catch: Throwable -> L14
        monitor-exit(this);     // Catch: Throwable -> L14
        dispose(r100);
    }

    @Override // io.reactivex.disposables.Disposable
    public void dispose() {
        if (this.disposed == false) goto L5;
        return;
    L5:
        monitor-enter(this);
    L14:
        th = move-exception;
        throw th;
    L7:
        if (this.disposed == false) goto L10;
        monitor-exit(this);     // Catch: Throwable -> L14
        return;
    L10:
        this.disposed = true;     // Catch: Throwable -> L14
        OpenHashSet<Disposable> r100 = this.resources;     // Catch: Throwable -> L14
        this.resources = null;     // Catch: Throwable -> L14
        monitor-exit(this);     // Catch: Throwable -> L14
        dispose(r100);
    }

    public int size() {
        int r100 = 0;
        if (this.disposed == false) goto L5;
        return 0;
    L5:
        monitor-enter(this);
    L15:
        th = move-exception;
        throw th;
    L7:
        if (this.disposed == false) goto L10;
        monitor-exit(this);     // Catch: Throwable -> L15
        return 0;
    L10:
        OpenHashSet<Disposable> r101 = this.resources;     // Catch: Throwable -> L15
        if (r101 == null) goto L13;
        r100 = r101.size();     // Catch: Throwable -> L15
    L13:
        monitor-exit(this);     // Catch: Throwable -> L15
        return r100;
    }

    public CompositeDisposable() {
    }

    @Override // io.reactivex.disposables.Disposable
    public boolean isDisposed() {
        return this.disposed;
    }

    public CompositeDisposable(Iterable<? extends Disposable> r100) {
        ObjectHelper.requireNonNull(r100, "resources is null");
        this.resources = new OpenHashSet();
        Iterator<? extends Disposable> r101 = r100.iterator();
    L4:
        if (r101.hasNext() == false) goto L6;
        Disposable r102 = r101.next();
        ObjectHelper.requireNonNull(r102, "Disposable item is null");
        this.resources.add(r102);
        goto L4
    }

    @Override // utc.a
    public boolean add(Disposable r100) {
        ObjectHelper.requireNonNull(r100, "d is null");
        if (this.disposed == true) goto L19;
        monitor-enter(this);
    L16:
        th = move-exception;
        throw th;
    L6:
        if (this.disposed == true) goto L14;
        OpenHashSet<Disposable> r101 = this.resources;     // Catch: Throwable -> L16
        if (r101 != null) goto L10;
        r101 = new OpenHashSet();     // Catch: Throwable -> L16
        this.resources = r101;     // Catch: Throwable -> L16
    L10:
        r101.add(r100);     // Catch: Throwable -> L16
        monitor-exit(this);     // Catch: Throwable -> L16
        return true;
    L14:
        monitor-exit(this);     // Catch: Throwable -> L16
    L19:
        r100.dispose();
        return false;
    }

    public boolean addAll(Disposable... r100) {
        ObjectHelper.requireNonNull(r100, "ds is null");
        int r101 = 0;
        if (this.disposed == true) goto L20;
        monitor-enter(this);
    L17:
        th = move-exception;
        throw th;
    L6:
        if (this.disposed == true) goto L15;
        OpenHashSet<Disposable> r102 = this.resources;     // Catch: Throwable -> L17
        if (r102 != null) goto L10;
        r102 = new OpenHashSet(r100.length + 1);     // Catch: Throwable -> L17
        this.resources = r102;     // Catch: Throwable -> L17
    L10:
        int r103 = r100.length;     // Catch: Throwable -> L17
    L11:
        if (r101 >= r103) goto L13;
        Disposable r104 = r100[r101];     // Catch: Throwable -> L17
        ObjectHelper.requireNonNull(r104, "d is null");     // Catch: Throwable -> L17
        r102.add(r104);     // Catch: Throwable -> L17
        r101 = r101 + 1;     // Catch: Throwable -> L17
        goto L11
    L13:
        monitor-exit(this);     // Catch: Throwable -> L17
        return true;
    L15:
        monitor-exit(this);     // Catch: Throwable -> L17
    L20:
        int r105 = r100.length;
        int r106 = 0;
    L21:
        if (r106 >= r105) goto L23;
        r100[r106].dispose();
        r106 = r106 + 1;
        goto L21
    L23:
        return false;
    }

    @Override // utc.a
    public boolean delete(Disposable r100) {
        ObjectHelper.requireNonNull(r100, "Disposable item is null");
        if (this.disposed == false) goto L5;
        return false;
    L5:
        monitor-enter(this);
    L20:
        th = move-exception;
        throw th;
    L7:
        if (this.disposed == false) goto L10;
        monitor-exit(this);     // Catch: Throwable -> L20
        return false;
    L10:
        OpenHashSet<Disposable> r101 = this.resources;     // Catch: Throwable -> L20
        if (r101 != null) goto L13;
    L18:
        monitor-exit(this);     // Catch: Throwable -> L20
        return false;
    L13:
        if (r101.remove(r100) == false) goto L18;
        monitor-exit(this);     // Catch: Throwable -> L20
        return true;
    }

    public void dispose(OpenHashSet<Disposable> r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        Object[] r101 = r100.keys();
        int r102 = r101.length;
        ArrayList r103 = null;
        int r104 = 0;
    L5:
        if (r104 >= r102) goto L16;
        Object r105 = r101[r104];
        if ((r105 instanceof Disposable) == false) goto L15;
        ((Disposable) r105).dispose();     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        Exceptions.throwIfFatal(th);
        if (r103 != null) goto L14;
        r103 = new ArrayList();
    L14:
        r103.add(th);
    L15:
        r104 = r104 + 1;
        goto L5
    L16:
        if (r103 != null) goto L18;
        return;
    L18:
        if (r103.size() != 1) goto L22;
        throw ExceptionHelper.d((Throwable) ListProtector.get(r103, 0));
    L22:
        throw new CompositeException(r103);
    }

    @Override // utc.a
    public boolean remove(Disposable r100) {
        if (delete(r100) == false) goto L6;
        r100.dispose();
        return true;
    L6:
        return false;
    }

    public CompositeDisposable(Disposable... r100) {
        ObjectHelper.requireNonNull(r100, "resources is null");
        this.resources = new OpenHashSet(r100.length + 1);
        int r101 = r100.length;
        int r102 = 0;
    L3:
        if (r102 >= r101) goto L5;
        Disposable r103 = r100[r102];
        ObjectHelper.requireNonNull(r103, "Disposable item is null");
        this.resources.add(r103);
        r102 = r102 + 1;
        goto L3
    }
}
