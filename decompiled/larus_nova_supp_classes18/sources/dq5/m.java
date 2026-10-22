package dq5;

import io.reactivex.Flowable;
import io.reactivex.functions.Function;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class m<T, R> implements Function {
    public static final m<T, R> a = null;

    static {
        a = new m();
    }

    public m() {
    }

    public final Object apply(Object r2) {
        Throwable r3 = (Throwable) r2;
        Intrinsics.checkNotNullParameter(r3, "it");
        if (tp5.b.b(r3, 920004002) == false) goto L6;
        int r4 = up5.b.b;
        return Flowable.just(up5.b.a.a());
    L6:
        return Flowable.error(r3);
    }
}
