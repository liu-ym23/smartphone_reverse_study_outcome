package io.reactivex.subjects;

import io.reactivex.Completable;
import io.reactivex.b;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes41.dex */
public final class CompletableSubject extends Completable implements b {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final CompletableDisposable[] f495113d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final CompletableDisposable[] f495114e = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AtomicReference<CompletableDisposable[]> f495115a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final AtomicBoolean f495116b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Throwable f495117c;

    public static final class CompletableDisposable extends AtomicReference<CompletableSubject> implements Disposable {
        private static final long serialVersionUID = -7650903191002190468L;
        final b downstream;

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            CompletableSubject r100 = getAndSet(null);
            if (r100 == null) goto L6;
            r100.e(this);
            return;
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            if (get() != null) goto L5;
            return true;
        L5:
            return false;
        }

        public CompletableDisposable(b r100, CompletableSubject r101) {
            this.downstream = r100;
            lazySet(r101);
        }
    }

    static {
        f495113d = new CompletableDisposable[0];
        f495114e = new CompletableDisposable[0];
    }

    public final boolean d() {
        if (this.f495115a.get() == f495114e) goto L5;
    L7:
        return false;
    L5:
        if (this.f495117c != null) goto L7;
        return true;
    }

    @Override // io.reactivex.b
    public final void onComplete() {
        int r100 = 0;
        if (this.f495116b.compareAndSet(false, true) == false) goto L7;
        CompletableDisposable[] r101 = this.f495115a.getAndSet(f495114e);
        int r102 = r101.length;
    L5:
        if (r100 >= r102) goto L9;
        r101[r100].downstream.onComplete();
        r100 = r100 + 1;
        goto L5
    L9:
        return;
    }

    public CompletableSubject() {
        this.f495116b = new AtomicBoolean();
        this.f495115a = new AtomicReference(f495113d);
    }

    public final void e(CompletableDisposable r100) {
    L2:
        CompletableDisposable[] r101 = this.f495115a.get();
        int r102 = r101.length;
        if (r102 == 0) goto L4;
        boolean r103 = false;
        int r104 = 0;
    L6:
        if (r104 >= r102) goto L11;
        if (r101[r104] == r100) goto L12;
        r104 = r104 + 1;
    L12:
        if (r104 < 0) goto L13;
        if (r102 != 1) goto L17;
        CompletableDisposable[] r105 = f495113d;
    L18:
        AtomicReference<CompletableDisposable[]> r106 = this.f495115a;
    L20:
        if (r106.compareAndSet(r101, r105) == true) goto L21;
        if (r106.get() == r101) goto L20;
    L24:
        if (r103 == false) goto L2;
        return;
    L21:
        r103 = true;
        goto L24
    L17:
        CompletableDisposable[] r107 = new CompletableDisposable[r102 - 1];
        System.arraycopy(r101, 0, r107, 0, r104);
        System.arraycopy(r101, r104 + 1, r107, r104, (r102 - r104) - 1);
        r105 = r107;
        goto L18
    L13:
        return;
    L11:
        r104 = -1;
        goto L12
    }

    @Override // io.reactivex.b
    public final void onError(Throwable r100) {
        ObjectHelper.requireNonNull(r100, "onError called with null. Null values are generally not allowed in 2.x operators and sources.");
        int r101 = 0;
        if (this.f495116b.compareAndSet(false, true) == false) goto L7;
        this.f495117c = r100;
        CompletableDisposable[] r102 = this.f495115a.getAndSet(f495114e);
        int r103 = r102.length;
    L5:
        if (r101 >= r103) goto L10;
        r102[r101].downstream.onError(r100);
        r101 = r101 + 1;
        goto L5
    L10:
        return;
    L7:
        RxJavaPlugins.onError(r100);
    }

    @Override // io.reactivex.b
    public final void onSubscribe(Disposable r100) {
        if (this.f495115a.get() != f495114e) goto L6;
        r100.dispose();
        return;
    }

    @Override // io.reactivex.Completable
    public final void subscribeActual(b r100) {
        CompletableDisposable r101 = new CompletableDisposable(r100, this);
        r100.onSubscribe(r101);
    L3:
        CompletableDisposable[] r102 = this.f495115a.get();
        boolean r103 = false;
        if (r102 == f495114e) goto L14;
        int r104 = r102.length;
        CompletableDisposable[] r105 = new CompletableDisposable[r104 + 1];
        System.arraycopy(r102, 0, r105, 0, r104);
        r105[r104] = r101;
        AtomicReference<CompletableDisposable[]> r106 = this.f495115a;
    L8:
        if (r106.compareAndSet(r102, r105) == true) goto L9;
        if (r106.get() == r102) goto L8;
    L12:
        if (r103 == false) goto L3;
        r103 = true;
        goto L14
    L9:
        r103 = true;
    L14:
        if (r103 == true) goto L16;
        Throwable r107 = this.f495117c;
        if (r107 == null) goto L21;
        r100.onError(r107);
        return;
    L21:
        r100.onComplete();
        return;
    L16:
        if (r101.isDisposed() == false) goto L30;
        e(r101);
        return;
    }
}
