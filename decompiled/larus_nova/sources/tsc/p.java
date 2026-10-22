package tsc;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
public final class p extends io.noties.markwon.html.tag.g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map<String, kw8.a> f547466a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f547467b;

    public p(Map<String, kw8.a> r100, boolean r101) {
        this.f547466a = r100;
        this.f547467b = r101;
    }

    @Override // io.noties.markwon.html.tag.g, io.noties.markwon.html.tag.i
    public final Object e(lsc.h r100, lsc.t r101, l r102) {
        Intrinsics.checkNotNullParameter(r100, "configuration");
        Intrinsics.checkNotNullParameter(r101, "renderProps");
        Intrinsics.checkNotNullParameter(r102, "tag");
        Object r103 = super.e(r100, r101, r102);
        int r104 = b.f547432a;
        Object[] r105 = b.a(r102, this.f547466a, this.f547467b);
        if (r103 != null) goto L6;
        if (r105 != null) goto L6;
        return null;
    L6:
        ArrayList r106 = new ArrayList();
        if (r105 == null) goto L13;
        Iterator r107 = ArraysKt.filterNotNull(r105).iterator();
    L10:
        if (r107.hasNext() == false) goto L13;
        r106.add(r107.next());
    L13:
        if ((r103 instanceof Object[]) == false) goto L18;
        Iterator r108 = ArraysKt.filterNotNull((Object[]) r103).iterator();
    L16:
        if (r108.hasNext() == false) goto L20;
        r106.add(r108.next());
    L20:
        Object[] r109 = r106.toArray(new Object[0]);
        if (r109 == null) goto L24;
        return r109;
    L24:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
    L18:
        if (r103 == null) goto L20;
        r106.add(r103);
        goto L20
    }
}
