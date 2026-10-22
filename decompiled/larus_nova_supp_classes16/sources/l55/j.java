package l55;

import io.reactivex.Flowable;
import io.reactivex.functions.Function;
import java.util.concurrent.TimeUnit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class j<T, R> implements Function {
    public static final j<T, R> a = null;

    static {
        a = new j();
    }

    public j() {
    }

    public final Object apply(Object r4) {
        Flowable r5 = (Flowable) r4;
        Intrinsics.checkNotNullParameter(r5, "objectFlowable");
        return r5.delay(3, TimeUnit.SECONDS);
    }
}
