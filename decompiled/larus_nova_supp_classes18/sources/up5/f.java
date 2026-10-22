package up5;

import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.WikiTreeModel;
import io.reactivex.Flowable;
import io.reactivex.functions.Function;
import io.reactivex.internal.functions.Functions;
import java.util.concurrent.Callable;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class f<T, R> implements Function {
    public final /* synthetic */ Function1<T, Unit> a;

    public static final class a<V> implements Callable {
        public final /* synthetic */ Function1 a;
        public final /* synthetic */ Object b;

        public a(Function1 r1, Object r2) {
            this.a = r1;
            this.b = r2;
        }

        @Override // java.util.concurrent.Callable
        public final void call() {
            this.a.invoke(this.b);
        }

        @Override // java.util.concurrent.Callable
        public /* bridge */ /* synthetic */ Object call() {
            call();
            return Unit.INSTANCE;
        }
    }

    public f(WikiTreeModel.a r1) {
        this.a = r1;
    }

    public final T apply(T r4) {
        Intrinsics.checkNotNullParameter(r4, "it");
        Flowable.fromCallable(new a(this.a, r4)).subscribeOn(fo5.d.f()).subscribe(Functions.emptyConsumer(), e.a);
        return r4;
    }
}
