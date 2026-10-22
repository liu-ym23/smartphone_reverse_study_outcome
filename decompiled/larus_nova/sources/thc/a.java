package thc;

import io.reactivex.functions.Function;
import java.util.List;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes40.dex */
public final class a<T, R> implements Function<Pair<? extends List<Object>, Object>, List<Object>> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f545988a = null;

    static {
        f545988a = new a();
    }

    public a() {
    }

    @Override // io.reactivex.functions.Function
    public final List<Object> apply(Pair<? extends List<Object>, Object> r100) {
        Pair<? extends List<Object>, Object> r101 = r100;
        Intrinsics.checkNotNullParameter(r101, "<name for destructuring parameter 0>");
        return r101.component1();
    }
}
