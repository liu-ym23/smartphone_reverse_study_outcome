package kotlinx.datetime.internal.format;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes42.dex */
public class h<T> implements n<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<q<T>> f505290a;

    @Override // kotlinx.datetime.internal.format.n
    public huc.e<T> a() {
        List<q<T>> r100 = this.f505290a;
        ArrayList r101 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r100, 10));
        Iterator<T> r102 = r100.iterator();
    L4:
        if (r102.hasNext() == false) goto L7;
        r101.add(((q) r102.next()).a());
        goto L4
    L7:
        if (r101.size() != 1) goto L10;
        return (huc.e) CollectionsKt.single(r101);
    L10:
        return new huc.a(r101);
    }

    public final int hashCode() {
        return this.f505290a.hashCode();
    }

    @Override // kotlinx.datetime.internal.format.n
    public kotlinx.datetime.internal.format.parser.u<T> parser() {
        List<q<T>> r100 = this.f505290a;
        ArrayList r101 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r100, 10));
        Iterator<T> r102 = r100.iterator();
    L4:
        if (r102.hasNext() == false) goto L7;
        r101.add(((q) r102.next()).parser());
        goto L4
    L7:
        return kotlinx.datetime.internal.format.parser.q.a(r101);
    }

    public final String toString() {
        return "ConcatenatedFormatStructure(" + CollectionsKt.joinToString$default(this.f505290a, ", ", null, null, 0, null, null, 62, null) + ')';
    }

    /* JADX WARN: Multi-variable type inference failed */
    public h(List<? extends q<? super T>> r100) {
        Intrinsics.checkNotNullParameter(r100, "formats");
        this.f505290a = r100;
    }

    public final boolean equals(Object r100) {
        if ((r100 instanceof h) == true) goto L5;
    L7:
        return false;
    L5:
        if (Intrinsics.areEqual(this.f505290a, ((h) r100).f505290a) == false) goto L7;
        return true;
    }
}
