package wtc;

import com.bytedance.pia.core.metrics.ErrorType;
import io.reactivex.annotations.CheckReturnValue;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.operators.parallel.ParallelFromPublisher;
import io.reactivex.plugins.RxJavaPlugins;
import org.reactivestreams.Publisher;

/* JADX INFO: loaded from: classes41.dex */
public abstract class a<T> {
    public a() {
    }

    @CheckReturnValue
    public static <T> a<T> a(Publisher<? extends T> r100, int r101, int r102) {
        ObjectHelper.requireNonNull(r100, "source");
        ObjectHelper.verifyPositive(r101, "parallelism");
        ObjectHelper.verifyPositive(r102, ErrorType.PREFETCH);
        return RxJavaPlugins.onAssembly(new ParallelFromPublisher(r100));
    }
}
