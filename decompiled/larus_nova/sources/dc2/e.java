package dc2;

import io.reactivex.functions.Function;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class e<T, R> implements Function {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final e f467875a = null;

    static {
        f467875a = new e();
    }

    public e() {
    }

    @Override // io.reactivex.functions.Function
    public final Object apply(Object r100) {
        c.a r101 = (c.a) r100;
        Intrinsics.checkNotNullParameter(r101, "it");
        return r101.f467857c;
    }
}
