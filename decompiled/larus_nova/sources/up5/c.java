package up5;

import io.reactivex.functions.Function;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public final class c<T, R> implements Function {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final c<T, R> f551049a = null;

    static {
        f551049a = new c();
    }

    public c() {
    }

    @Override // io.reactivex.functions.Function
    public final Object apply(Object r100) {
        b r101 = (b) r100;
        Intrinsics.checkNotNullParameter(r101, "opt");
        return r101.a();
    }
}
