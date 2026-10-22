package huc;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes42.dex */
public final class i<T> implements e<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Function1<T, String> f487271a;

    /* JADX WARN: Multi-variable type inference failed */
    public i(Function1<? super T, String> r100) {
        Intrinsics.checkNotNullParameter(r100, "string");
        this.f487271a = r100;
    }
}
