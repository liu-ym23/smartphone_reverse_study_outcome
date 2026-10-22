package uu5;

import io.reactivex.BackpressureStrategy;
import io.reactivex.Flowable;
import io.reactivex.FlowableEmitter;
import io.reactivex.disposables.Disposable;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes19.dex */
public final class d<V> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public FlowableEmitter<V> f551755a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Disposable f551756b;

    public interface a<V> {
        void onSubscribe(V r100);
    }

    public final void a() {
        Disposable r100 = this.f551756b;
        if (r100 == null) goto L6;
        r100.dispose();
        return;
    }

    public final void b(V r100) {
        FlowableEmitter<V> r101 = this.f551755a;
        if (r101 != null) goto L5;
        return;
    L5:
        if (r101.isCancelled() == true) goto L9;
        tt5.a.b("DebounceFlowableWrapper", "onNext: " + r100);
        this.f551755a.onNext(r100);
        return;
    }

    public d(long r100, a<V> r101) {
        BackpressureStrategy r102 = BackpressureStrategy.LATEST;
        this.f551756b = Flowable.create(new c(this), r102).debounce(r100, TimeUnit.MILLISECONDS, fo5.d.a()).observeOn(fo5.d.d()).subscribe(new uu5.a(r101), new b());
    }
}
