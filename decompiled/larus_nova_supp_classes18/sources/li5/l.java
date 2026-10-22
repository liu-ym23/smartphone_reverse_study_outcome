package li5;

import com.bytedance.ee.bear.contract.net.SimpleRequestResult;
import io.reactivex.Flowable;
import io.reactivex.functions.Function;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class l<T, R> implements Function {
    public static final l<T, R> a = null;

    static {
        a = new l();
    }

    public l() {
    }

    public final Object apply(Object r2) {
        Intrinsics.checkNotNullParameter((SimpleRequestResult) r2, "it");
        return Flowable.just(Boolean.TRUE);
    }
}
