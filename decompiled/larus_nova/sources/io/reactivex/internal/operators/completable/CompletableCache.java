package io.reactivex.internal.operators.completable;

import io.reactivex.Completable;
import io.reactivex.CompletableSource;
import io.reactivex.disposables.Disposable;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes41.dex */
public final class CompletableCache extends Completable implements io.reactivex.b {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final InnerCompletableCache[] f492904e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final InnerCompletableCache[] f492905f = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final CompletableSource f492906a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final AtomicReference<InnerCompletableCache[]> f492907b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final AtomicBoolean f492908c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Throwable f492909d;

    public final class InnerCompletableCache extends AtomicBoolean implements Disposable {
        private static final long serialVersionUID = 8943152917179642732L;
        final io.reactivex.b downstream;
        final /* synthetic */ CompletableCache this$0;

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            if (compareAndSet(false, true) == false) goto L6;
            this.this$0.d(this);
            return;
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return get();
        }

        public InnerCompletableCache(CompletableCache r100, io.reactivex.b r101) {
            this.this$0 = r100;
            this.downstream = r101;
        }
    }

    static {
        f492904e = new InnerCompletableCache[0];
        f492905f = new InnerCompletableCache[0];
    }

    @Override // io.reactivex.b
    public final void onSubscribe(Disposable r100) {
    }

    @Override // io.reactivex.b
    public final void onComplete() {
        InnerCompletableCache[] r100 = this.f492907b.getAndSet(f492905f);
        int r101 = r100.length;
        int r102 = 0;
    L3:
        if (r102 >= r101) goto L8;
        InnerCompletableCache r103 = r100[r102];
        if (r103.get() == true) goto L7;
        r103.downstream.onComplete();
    L7:
        r102 = r102 + 1;
        goto L3
    }

    public CompletableCache(CompletableSource r100) {
        this.f492906a = r100;
        this.f492907b = new AtomicReference(f492904e);
        this.f492908c = new AtomicBoolean();
    }

    public final void d(InnerCompletableCache r100) {
    L2:
        InnerCompletableCache[] r101 = this.f492907b.get();
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
        InnerCompletableCache[] r105 = f492904e;
    L18:
        AtomicReference<InnerCompletableCache[]> r106 = this.f492907b;
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
        InnerCompletableCache[] r107 = new InnerCompletableCache[r102 - 1];
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
        this.f492909d = r100;
        InnerCompletableCache[] r101 = this.f492907b.getAndSet(f492905f);
        int r102 = r101.length;
        int r103 = 0;
    L3:
        if (r103 >= r102) goto L8;
        InnerCompletableCache r104 = r101[r103];
        if (r104.get() == true) goto L7;
        r104.downstream.onError(r100);
    L7:
        r103 = r103 + 1;
        goto L3
    }

    @Override // io.reactivex.Completable
    public final void subscribeActual(io.reactivex.b r100) {
        InnerCompletableCache r101 = new InnerCompletableCache(this, r100);
        r100.onSubscribe(r101);
    L3:
        InnerCompletableCache[] r102 = this.f492907b.get();
        if (r102 == f492905f) goto L5;
        int r103 = r102.length;
        InnerCompletableCache[] r104 = new InnerCompletableCache[r103 + 1];
        System.arraycopy(r102, 0, r104, 0, r103);
        r104[r103] = r101;
        AtomicReference<InnerCompletableCache[]> r105 = this.f492907b;
    L8:
        if (r105.compareAndSet(r102, r104) == true) goto L9;
        if (r105.get() == r102) goto L8;
        boolean r106 = false;
    L13:
        if (r106 == false) goto L3;
        boolean r107 = true;
    L15:
        if (r107 == true) goto L17;
        Throwable r108 = this.f492909d;
        if (r108 == null) goto L25;
        r100.onError(r108);
        return;
    L25:
        r100.onComplete();
        return;
    L17:
        if (r101.isDisposed() == false) goto L20;
        d(r101);
    L20:
        if (this.f492908c.compareAndSet(false, true) == false) goto L35;
        this.f492906a.subscribe(this);
        return;
    L35:
        return;
    L9:
        r106 = true;
        goto L13
    L5:
        r107 = false;
        goto L15
    }
}
