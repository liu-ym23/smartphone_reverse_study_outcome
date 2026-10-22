package qyb;

import android.view.View;
import android.view.ViewGroup;
import java.util.Iterator;
import kotlin.jvm.internal.markers.KMutableIterator;

/* JADX INFO: loaded from: classes37.dex */
public final class b implements Iterator<View>, KMutableIterator {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f535214a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ ViewGroup f535215b;

    @Override // java.util.Iterator
    public final boolean hasNext() {
        if (this.f535214a >= this.f535215b.getChildCount()) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // java.util.Iterator
    public final View next() {
        ViewGroup r100 = this.f535215b;
        int r101 = this.f535214a;
        this.f535214a = r101 + 1;
        View r102 = r100.getChildAt(r101);
        if (r102 == null) goto L6;
        return r102;
    L6:
        throw new IndexOutOfBoundsException();
    }

    @Override // java.util.Iterator
    public final void remove() {
        ViewGroup r100 = this.f535215b;
        int r101 = this.f535214a - 1;
        this.f535214a = r101;
        r100.removeViewAt(r101);
    }

    public b(ViewGroup r100) {
        this.f535215b = r100;
    }
}
