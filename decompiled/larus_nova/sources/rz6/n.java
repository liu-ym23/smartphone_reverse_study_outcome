package rz6;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes21.dex */
public abstract class n<V, O> implements m<V, O> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<xz6.a<V>> f539977a;

    public final String toString() {
        StringBuilder r100 = new StringBuilder();
        if (this.f539977a.isEmpty() == true) goto L6;
        r100.append("values=");
        r100.append(Arrays.toString(this.f539977a.toArray()));
    L6:
        return r100.toString();
    }

    public n(V r100) {
        this(Collections.singletonList(new xz6.a(r100)));
    }

    public n(List<xz6.a<V>> r100) {
        this.f539977a = r100;
    }
}
