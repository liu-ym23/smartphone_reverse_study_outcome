package utc;

import com.bytedance.mt.protector.impl.collections.ListProtector;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.util.ExceptionHelper;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/* JADX INFO: loaded from: classes41.dex */
public final class b implements Disposable, a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public List<Disposable> f551719a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public volatile boolean f551720b;

    @Override // io.reactivex.disposables.Disposable
    public final void dispose() {
        if (this.f551720b == false) goto L5;
        return;
    L5:
        monitor-enter(this);
    L33:
        th = move-exception;
        throw th;
    L7:
        if (this.f551720b == false) goto L10;
        monitor-exit(this);     // Catch: Throwable -> L33
        return;
    L10:
        this.f551720b = true;     // Catch: Throwable -> L33
        List<Disposable> r100 = this.f551719a;     // Catch: Throwable -> L33
        ArrayList r101 = null;
        this.f551719a = null;     // Catch: Throwable -> L33
        monitor-exit(this);     // Catch: Throwable -> L33
        if (r100 == null) goto L43;
        Iterator<Disposable> r102 = r100.iterator();
    L16:
        if (r102.hasNext() == false) goto L25;
        r102.next().dispose();     // Catch: Throwable -> L20
    L20:
        th = move-exception;
        Exceptions.throwIfFatal(th);
        if (r101 != null) goto L24;
        r101 = new ArrayList();
    L24:
        r101.add(th);
        goto L16
    L25:
        if (r101 != null) goto L27;
        return;
    L27:
        if (r101.size() != 1) goto L31;
        throw ExceptionHelper.d((Throwable) ListProtector.get(r101, 0));
    L31:
        throw new CompositeException(r101);
    }

    public b() {
    }

    @Override // io.reactivex.disposables.Disposable
    public final boolean isDisposed() {
        return this.f551720b;
    }

    @Override // utc.a
    public final boolean add(Disposable r100) {
        ObjectHelper.requireNonNull(r100, "d is null");
        if (this.f551720b == true) goto L19;
        monitor-enter(this);
    L16:
        th = move-exception;
        throw th;
    L6:
        if (this.f551720b == true) goto L14;
        List r101 = this.f551719a;     // Catch: Throwable -> L16
        if (r101 != null) goto L10;
        r101 = new LinkedList();     // Catch: Throwable -> L16
        this.f551719a = r101;     // Catch: Throwable -> L16
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

    @Override // utc.a
    public boolean delete(Disposable r100) {
        ObjectHelper.requireNonNull(r100, "Disposable item is null");
        if (this.f551720b == false) goto L5;
        return false;
    L5:
        monitor-enter(this);
    L20:
        th = move-exception;
        throw th;
    L7:
        if (this.f551720b == false) goto L10;
        monitor-exit(this);     // Catch: Throwable -> L20
        return false;
    L10:
        List<Disposable> r101 = this.f551719a;     // Catch: Throwable -> L20
        if (r101 != null) goto L13;
    L18:
        monitor-exit(this);     // Catch: Throwable -> L20
        return false;
    L13:
        if (r101.remove(r100) == false) goto L18;
        monitor-exit(this);     // Catch: Throwable -> L20
        return true;
    }

    @Override // utc.a
    public final boolean remove(Disposable r100) {
        if (delete(r100) == false) goto L6;
        r100.dispose();
        return true;
    L6:
        return false;
    }
}
