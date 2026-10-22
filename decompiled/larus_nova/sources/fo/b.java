package fo;

import java.util.LinkedHashSet;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ConcurrentHashMap<String, Object> f478065a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Set<a<?>> f478066b;

    public b() {
        this.f478065a = new ConcurrentHashMap();
        this.f478066b = new LinkedHashSet();
    }

    public final <T> T a(a<T> r100) {
        Intrinsics.checkNotNullParameter(r100, "dataKey");
        String r101 = r100.f478064a;
        T r102 = (T) this.f478065a.get(r101);
        if ((r102 instanceof Object) == true) goto L6;
        return null;
    L6:
        return r102;
    }

    public final <T> T c(a<T> r100) {
        Intrinsics.checkNotNullParameter(r100, "dataKey");
        this.f478066b.remove(r100);
        String r101 = r100.f478064a;
        T r102 = (T) this.f478065a.remove(r101);
        if ((r102 instanceof Object) == true) goto L6;
        return null;
    L6:
        return r102;
    }

    public final <T> T b(a<T> r100, T r101) {
        Intrinsics.checkNotNullParameter(r100, "dataKey");
        Intrinsics.checkNotNullParameter(r101, "value");
        this.f478066b.add(r100);
        String r102 = r100.f478064a;
        T r103 = (T) this.f478065a.put(r102, r101);
        if ((r103 instanceof Object) == true) goto L6;
        return null;
    L6:
        return r103;
    }

    public final <T> void d(a<T> r100, T r101) {
        Intrinsics.checkNotNullParameter(r100, "dataKey");
        Intrinsics.checkNotNullParameter(r101, "value");
        b(r100, r101);
    }
}
