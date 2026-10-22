package kotlinx.datetime.internal.format;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes42.dex */
public final class e<T> implements q<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final k<T> f505285a;

    @Override // kotlinx.datetime.internal.format.n
    public final huc.e<T> a() {
        return this.f505285a.a();
    }

    public final int hashCode() {
        return this.f505285a.hashCode();
    }

    @Override // kotlinx.datetime.internal.format.n
    public final kotlinx.datetime.internal.format.parser.u<T> parser() {
        return this.f505285a.parser();
    }

    public final String toString() {
        return "BasicFormatStructure(" + this.f505285a + ')';
    }

    /* JADX WARN: Multi-variable type inference failed */
    public e(k<? super T> r100) {
        Intrinsics.checkNotNullParameter(r100, "directive");
        this.f505285a = r100;
    }

    public final boolean equals(Object r100) {
        if ((r100 instanceof e) == true) goto L5;
    L7:
        return false;
    L5:
        if (Intrinsics.areEqual(this.f505285a, ((e) r100).f505285a) == false) goto L7;
        return true;
    }
}
