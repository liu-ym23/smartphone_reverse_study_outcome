package huc;

import java.util.List;
import kotlin.Pair;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes42.dex */
public final class b<T> implements e<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<Pair<Function1<T, Boolean>, e<T>>> f487264a;

    /* JADX WARN: Multi-variable type inference failed */
    public b(List<? extends Pair<? extends Function1<? super T, Boolean>, ? extends e<? super T>>> r100) {
        Intrinsics.checkNotNullParameter(r100, "formatters");
        this.f487264a = r100;
    }
}
