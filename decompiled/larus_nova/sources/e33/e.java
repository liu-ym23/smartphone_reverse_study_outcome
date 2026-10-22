package e33;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
public final class e<K, V> implements g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map<K, List<V>> f470906a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Function0<List<V>> f470907b;

    @Override // e33.g
    public final Collection a(Object r100) {
        List<V> r101 = this.f470906a.get(r100);
        if (r101 != null) goto L6;
        r101 = CollectionsKt.emptyList();
    L6:
        return r101;
    }

    @Override // e33.g
    public final V get(K r100) {
        List<V> r101 = this.f470906a.get(r100);
        if (r101 != null) goto L7;
        return null;
    L7:
        return (V) CollectionsKt.lastOrNull(r101);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public e(Map<K, List<V>> r100, Function0<? extends List<V>> r101) {
        Intrinsics.checkNotNullParameter(r100, "map");
        Intrinsics.checkNotNullParameter(r101, "listFactory");
        this.f470906a = r100;
        this.f470907b = r101;
    }

    public final void b(K r100, V r101) {
        Map<K, List<V>> r102 = this.f470906a;
        Function0<List<V>> r103 = this.f470907b;
        List<V> r104 = r102.get(r100);
        if (r104 != null) goto L5;
        r104 = r103.invoke();
        r102.put(r100, r104);
    L5:
        r104.add(r101);
    }
}
