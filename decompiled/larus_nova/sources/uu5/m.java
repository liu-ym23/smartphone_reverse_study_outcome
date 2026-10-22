package uu5;

import io.reactivex.BackpressureStrategy;
import io.reactivex.Flowable;
import io.reactivex.FlowableEmitter;
import io.reactivex.disposables.Disposable;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes19.dex */
public final class m<V> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public FlowableEmitter<V> f551764a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Disposable f551765b;

    public interface a<V> {
        void onSubscribe(V r100);
    }

    public m() {
        throw null;
    }

    public final void a(V r100) {
        FlowableEmitter<V> r101 = this.f551764a;
        if (r101 != null) goto L5;
        return;
    L5:
        if (r101.isCancelled() == true) goto L9;
        tt5.a.b("SampleFlowableWrapper", "onNext: " + r100);
        this.f551764a.onNext(r100);
        return;
    }

    public m(long r100, a<V> r101) {
        BackpressureStrategy r102 = BackpressureStrategy.LATEST;
        this.f551765b = Flowable.create(new l(this), r102).sample(r100, TimeUnit.MILLISECONDS, fo5.d.a()).observeOn(fo5.d.d()).subscribe(new j(r101), new k());
    }
}
