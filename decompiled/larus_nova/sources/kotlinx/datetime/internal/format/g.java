package kotlinx.datetime.internal.format;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes42.dex */
public final class g<T, E> implements s<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final E f505288a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Function1<T, E> f505289b;

    @Override // kotlinx.datetime.internal.format.s
    public final boolean test(T r100) {
        return Intrinsics.areEqual(this.f505289b.invoke(r100), this.f505288a);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public g(Object r100, OptionalFormatStructure$PropertyWithDefault$isDefaultComparisonPredicate$1 r101) {
        Intrinsics.checkNotNullParameter(r101, "getter");
        this.f505288a = r100;
        this.f505289b = r101;
    }
}
