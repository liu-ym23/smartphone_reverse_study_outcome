package dc2;

import io.reactivex.functions.Predicate;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class d<T> implements Predicate {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final d f467874a = null;

    static {
        f467874a = new d();
    }

    public d() {
    }

    @Override // io.reactivex.functions.Predicate
    public final boolean test(Object r100) {
        c.a r101 = (c.a) r100;
        Intrinsics.checkNotNullParameter(r101, "it");
        if (r101.f467857c == null) goto L5;
        return true;
    L5:
        return false;
    }
}
