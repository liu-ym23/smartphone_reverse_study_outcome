package huc;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes42.dex */
public final class f<T> implements e<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final e<T> f487267a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Function1<T, Boolean> f487268b;

    public f(e r100, Function1 r101) {
        Intrinsics.checkNotNullParameter(r100, "formatter");
        Intrinsics.checkNotNullParameter(r101, "allSubFormatsNegative");
        this.f487267a = r100;
        this.f487268b = r101;
    }
}
