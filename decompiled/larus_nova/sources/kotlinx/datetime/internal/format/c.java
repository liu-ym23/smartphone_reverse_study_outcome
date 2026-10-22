package kotlinx.datetime.internal.format;

import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes42.dex */
public final class c<T> implements q<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final n<T> f505282a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<n<T>> f505283b;

    @Override // kotlinx.datetime.internal.format.n
    public final huc.e<T> a() {
        return this.f505282a.a();
    }

    public final int hashCode() {
        return (this.f505282a.hashCode() * 31) + this.f505283b.hashCode();
    }

    public final String toString() {
        return "AlternativesParsing(" + this.f505283b + ')';
    }

    @Override // kotlinx.datetime.internal.format.n
    public final kotlinx.datetime.internal.format.parser.u<T> parser() {
        List r100 = CollectionsKt.emptyList();
        List r101 = CollectionsKt.createListBuilder();
        r101.add(this.f505282a.parser());
        Iterator<n<T>> r102 = this.f505283b.iterator();
    L4:
        if (r102.hasNext() == false) goto L7;
        r101.add(r102.next().parser());
        goto L4
    L7:
        return new kotlinx.datetime.internal.format.parser.u(r100, CollectionsKt.build(r101));
    }

    public final boolean equals(Object r100) {
        if ((r100 instanceof c) == false) goto L9;
        c r101 = (c) r100;
        if (Intrinsics.areEqual(this.f505282a, r101.f505282a) == false) goto L9;
        if (Intrinsics.areEqual(this.f505283b, r101.f505283b) == false) goto L9;
        return true;
    L9:
        return false;
    }

    public c(h r100, List r101) {
        Intrinsics.checkNotNullParameter(r100, "mainFormat");
        Intrinsics.checkNotNullParameter(r101, "formats");
        this.f505282a = r100;
        this.f505283b = r101;
    }
}
