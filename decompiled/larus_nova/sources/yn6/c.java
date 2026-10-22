package yn6;

import java.lang.ref.WeakReference;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ConcurrentHashMap<String, ConcurrentHashMap<String, WeakReference<Object>>> f568562a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final d f568563b;

    public c() {
        this.f568562a = new ConcurrentHashMap();
        this.f568563b = new d();
    }

    public final Object a(String r100, Object r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, "key");
        Intrinsics.checkNotNullParameter(r102, "domain");
        ConcurrentHashMap<String, WeakReference<Object>> r103 = this.f568562a.get(r102);
        if (r103 == null) goto L11;
        WeakReference<Object> r104 = r103.get(r100);
        if (r104 == null) goto L12;
        Object r105 = r104.get();
        if (r105 != null) goto L10;
        return r101;
    L10:
        return r105;
    L12:
        return r101;
    L11:
        return r101;
    }
}
