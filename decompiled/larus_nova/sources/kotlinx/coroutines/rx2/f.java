package kotlinx.coroutines.rx2;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.k;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlinx.coroutines.channels.BufferedChannel;

/* JADX INFO: loaded from: classes42.dex */
public final class f<T> extends BufferedChannel<T> implements Observer<T>, k<T> {

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final /* synthetic */ AtomicReferenceFieldUpdater f505054m = null;
    private volatile /* synthetic */ Object _subscription$volatile;

    static {
        f505054m = AtomicReferenceFieldUpdater.newUpdater(f.class, Object.class, "_subscription$volatile");
    }

    public f() {
        super(Integer.MAX_VALUE, null);
    }

    @Override // io.reactivex.Observer
    public final void onComplete() {
        close(null);
    }

    @Override // kotlinx.coroutines.channels.BufferedChannel
    public final void x() {
        Disposable r100 = (Disposable) f505054m.getAndSet(this, null);
        if (r100 == null) goto L6;
        r100.dispose();
        return;
    }

    @Override // io.reactivex.Observer
    public final void onError(Throwable r100) {
        close(r100);
    }

    @Override // io.reactivex.Observer
    public final void onNext(T r100) {
        mo10962trySendJP2dKIU(r100);
    }

    @Override // io.reactivex.Observer
    public final void onSubscribe(Disposable r100) {
        f505054m.set(this, r100);
    }

    @Override // io.reactivex.k
    public final void onSuccess(T r100) {
        mo10962trySendJP2dKIU(r100);
        close(null);
    }
}
