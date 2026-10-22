package kotlinx.coroutines;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
public final class u {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Object f505151a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Function1<Throwable, Unit> f505152b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof u) == true) goto L8;
        return false;
    L8:
        u r101 = (u) r100;
        if (Intrinsics.areEqual(this.f505151a, r101.f505151a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f505152b, r101.f505152b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        Object r100 = this.f505151a;
        if (r100 != null) goto L5;
        int r101 = 0;
    L7:
        return (r101 * 31) + this.f505152b.hashCode();
    L5:
        r101 = r100.hashCode();
        goto L7
    }

    public final String toString() {
        return "CompletedWithCancellation(result=" + this.f505151a + ", onCancellation=" + this.f505152b + ')';
    }

    /* JADX WARN: Multi-variable type inference failed */
    public u(Object r100, Function1<? super Throwable, Unit> r101) {
        this.f505151a = r100;
        this.f505152b = r101;
    }
}
