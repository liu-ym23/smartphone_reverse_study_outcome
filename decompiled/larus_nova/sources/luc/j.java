package luc;

import java.util.Iterator;
import kotlin.jvm.internal.markers.KMappedMarker;

/* JADX INFO: loaded from: classes42.dex */
public final class j implements Iterator<String>, KMappedMarker {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f510872a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ f f510873b;

    @Override // java.util.Iterator
    public final void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        if (this.f510872a <= 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // java.util.Iterator
    public final String next() {
        f r100 = this.f510873b;
        int r101 = r100.d();
        int r102 = this.f510872a;
        this.f510872a = r102 - 1;
        return r100.b(r101 - r102);
    }

    public j(f r100) {
        this.f510873b = r100;
        this.f510872a = r100.d();
    }
}
