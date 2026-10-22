package io.reactivex.subjects;

import io.reactivex.Maybe;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.k;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes41.dex */
public final class MaybeSubject<T> extends Maybe<T> implements k<T> {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final MaybeDisposable[] f495118e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final MaybeDisposable[] f495119f = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AtomicReference<MaybeDisposable<T>[]> f495120a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final AtomicBoolean f495121b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public T f495122c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Throwable f495123d;

    public static final class MaybeDisposable<T> extends AtomicReference<MaybeSubject<T>> implements Disposable {
        private static final long serialVersionUID = -7650903191002190468L;
        final k<? super T> downstream;

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            MaybeSubject<T> r100 = getAndSet(null);
            if (r100 == null) goto L6;
            r100.a(this);
            return;
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            if (get() != null) goto L5;
            return true;
        L5:
            return false;
        }

        public MaybeDisposable(k<? super T> r100, MaybeSubject<T> r101) {
            this.downstream = r100;
            lazySet(r101);
        }
    }

    static {
        f495118e = new MaybeDisposable[0];
        f495119f = new MaybeDisposable[0];
    }

    @Override // io.reactivex.k
    public final void onComplete() {
        int r100 = 0;
        if (this.f495121b.compareAndSet(false, true) == false) goto L7;
        MaybeDisposable<T>[] r101 = this.f495120a.getAndSet(f495119f);
        int r102 = r101.length;
    L5:
        if (r100 >= r102) goto L9;
        r101[r100].downstream.onComplete();
        r100 = r100 + 1;
        goto L5
    L9:
        return;
    }

    public MaybeSubject() {
        this.f495121b = new AtomicBoolean();
        this.f495120a = new AtomicReference(f495118e);
    }

    public final void a(MaybeDisposable<T> r100) {
    L2:
        MaybeDisposable<T>[] r101 = this.f495120a.get();
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
        MaybeDisposable<T>[] r105 = f495118e;
    L18:
        AtomicReference<MaybeDisposable<T>[]> r106 = this.f495120a;
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
        MaybeDisposable<T>[] r107 = new MaybeDisposable[r102 - 1];
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

    @Override // io.reactivex.k
    public final void onError(Throwable r100) {
        ObjectHelper.requireNonNull(r100, "onError called with null. Null values are generally not allowed in 2.x operators and sources.");
        int r101 = 0;
        if (this.f495121b.compareAndSet(false, true) == false) goto L7;
        this.f495123d = r100;
        MaybeDisposable<T>[] r102 = this.f495120a.getAndSet(f495119f);
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

    @Override // io.reactivex.k
    public final void onSubscribe(Disposable r100) {
        if (this.f495120a.get() != f495119f) goto L6;
        r100.dispose();
        return;
    }

    @Override // io.reactivex.k
    public final void onSuccess(T r100) {
        ObjectHelper.requireNonNull(r100, "onSuccess called with null. Null values are generally not allowed in 2.x operators and sources.");
        int r101 = 0;
        if (this.f495121b.compareAndSet(false, true) == false) goto L7;
        this.f495122c = r100;
        MaybeDisposable<T>[] r102 = this.f495120a.getAndSet(f495119f);
        int r103 = r102.length;
    L5:
        if (r101 >= r103) goto L9;
        r102[r101].downstream.onSuccess(r100);
        r101 = r101 + 1;
        goto L5
    L9:
        return;
    }

    @Override // io.reactivex.Maybe
    public final void subscribeActual(k<? super T> r100) {
        MaybeDisposable<T> r101 = new MaybeDisposable(r100, this);
        r100.onSubscribe(r101);
    L3:
        MaybeDisposable<T>[] r102 = this.f495120a.get();
        boolean r103 = false;
        if (r102 == f495119f) goto L14;
        int r104 = r102.length;
        MaybeDisposable<T>[] r105 = new MaybeDisposable[r104 + 1];
        System.arraycopy(r102, 0, r105, 0, r104);
        r105[r104] = r101;
        AtomicReference<MaybeDisposable<T>[]> r106 = this.f495120a;
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
        Throwable r107 = this.f495123d;
        if (r107 == null) goto L21;
        r100.onError(r107);
        return;
    L21:
        T r108 = this.f495122c;
        if (r108 != null) goto L24;
        r100.onComplete();
        return;
    L24:
        r100.onSuccess(r108);
        return;
    L16:
        if (r101.isDisposed() == false) goto L33;
        a(r101);
        return;
    }
}
