package km;

import java.util.LinkedHashSet;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ConcurrentHashMap<String, Object> f504038a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Set<a<?>> f504039b;

    public b() {
        this.f504038a = new ConcurrentHashMap();
        this.f504039b = new LinkedHashSet();
    }

    public final <T> T a(a<T> r100, T r101) {
        Intrinsics.checkNotNullParameter(r100, "dataKey");
        Intrinsics.checkNotNullParameter(r101, "value");
        this.f504039b.add(r100);
        String r102 = r100.f504037a;
        T r103 = (T) this.f504038a.put(r102, r101);
        if ((r103 instanceof Object) == true) goto L6;
        return null;
    L6:
        return r103;
    }
}
