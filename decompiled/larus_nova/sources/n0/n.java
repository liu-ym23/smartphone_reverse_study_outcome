package n0;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public abstract class n<V, O> implements m<V, O> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<v0.a<V>> f516565a;

    public final String toString() {
        StringBuilder r100 = new StringBuilder();
        if (this.f516565a.isEmpty() == true) goto L6;
        r100.append("values=");
        r100.append(Arrays.toString(this.f516565a.toArray()));
    L6:
        return r100.toString();
    }

    public n(V r100) {
        this(Collections.singletonList(new v0.a(r100)));
    }

    public n(List<v0.a<V>> r100) {
        this.f516565a = r100;
    }
}
