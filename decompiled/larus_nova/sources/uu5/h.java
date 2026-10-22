package uu5;

import com.bytedance.ee.bear.bitable.card.view.cell.link.a0;
import io.reactivex.BackpressureStrategy;
import io.reactivex.Flowable;
import io.reactivex.FlowableEmitter;
import io.reactivex.disposables.Disposable;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes19.dex */
public abstract class h<V> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public FlowableEmitter<V> f551759a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Disposable f551760b;

    public interface a<V> {
    }

    public h(a0 r100) {
        BackpressureStrategy r101 = BackpressureStrategy.LATEST;
        this.f551760b = Flowable.create(new e(this), r101).throttleFirst(200, TimeUnit.MILLISECONDS).observeOn(fo5.d.d()).subscribe(new f(r100), new g());
    }
}
