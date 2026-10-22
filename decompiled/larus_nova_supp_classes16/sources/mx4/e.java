package mx4;

import io.reactivex.functions.Consumer;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class e<T> implements Consumer {
    public static final e<T> a = null;

    static {
        a = new e();
    }

    public e() {
    }

    public final void accept(Object r4) {
        Throwable r5 = (Throwable) r4;
        Intrinsics.checkNotNullParameter(r5, "t");
        tt5.a.e("DocAutoTestImpl2", "timeoutCalc err. ", r5, false);
    }
}
