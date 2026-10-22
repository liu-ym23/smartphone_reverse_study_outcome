package kotlinx.coroutines.reactive;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlinx.coroutines.channels.BufferedChannel;

/* JADX INFO: loaded from: classes42.dex */
public final class g<T> extends BufferedChannel<T> implements wwc.b<T> {

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final /* synthetic */ AtomicReferenceFieldUpdater f505033n = null;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final /* synthetic */ AtomicIntegerFieldUpdater f505034o = null;
    private volatile /* synthetic */ int _requested$volatile;
    private volatile /* synthetic */ Object _subscription$volatile;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final int f505035m;

    static {
        f505033n = AtomicReferenceFieldUpdater.newUpdater(g.class, Object.class, "_subscription$volatile");
        f505034o = AtomicIntegerFieldUpdater.newUpdater(g.class, "_requested$volatile");
    }

    @Override // wwc.b
    public final void onComplete() {
        close(null);
    }

    @Override // kotlinx.coroutines.channels.BufferedChannel
    public final void A() {
        f505034o.incrementAndGet(this);
    }

    @Override // kotlinx.coroutines.channels.BufferedChannel
    public final void B() {
        AtomicIntegerFieldUpdater r100 = f505034o;
    L3:
        int r101 = r100.get(this);
        wwc.c r102 = (wwc.c) f505033n.get(this);
        int r103 = r101 - 1;
        if (r102 == null) goto L14;
        if (r103 >= 0) goto L14;
        int r104 = this.f505035m;
        if (r101 == r104) goto L11;
        if (f505034o.compareAndSet(this, r101, r104) == false) goto L3;
    L11:
        r102.request(this.f505035m - r103);
        return;
    L14:
        if (f505034o.compareAndSet(this, r101, r103) == false) goto L3;
    }

    @Override // kotlinx.coroutines.channels.BufferedChannel
    public final void x() {
        wwc.c r100 = (wwc.c) f505033n.getAndSet(this, null);
        if (r100 == null) goto L6;
        r100.cancel();
        return;
    }

    public g(int r100) {
        super(Integer.MAX_VALUE, null);
        this.f505035m = r100;
        if (r100 < 0) goto L5;
        boolean r101 = true;
    L6:
        if (r101 == false) goto L9;
        return;
    L9:
        throw new IllegalArgumentException(("Invalid request size: " + r100).toString());
    L5:
        r101 = false;
        goto L6
    }

    @Override // wwc.b
    public final void onError(Throwable r100) {
        close(r100);
    }

    @Override // wwc.b
    public final void onNext(T r100) {
        f505034o.decrementAndGet(this);
        mo10962trySendJP2dKIU(r100);
    }

    @Override // wwc.b
    public final void onSubscribe(wwc.c r100) {
        f505033n.set(this, r100);
    L4:
        if (isClosedForSend() == true) goto L5;
        AtomicIntegerFieldUpdater r101 = f505034o;
        int r102 = r101.get(this);
        int r103 = this.f505035m;
        if (r102 >= r103) goto L9;
        if (r101.compareAndSet(this, r102, r103) == false) goto L4;
        r100.request(this.f505035m - r102);
        return;
    L9:
        return;
    L5:
        r100.cancel();
    }
}
