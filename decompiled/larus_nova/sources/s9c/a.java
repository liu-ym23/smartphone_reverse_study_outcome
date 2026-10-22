package s9c;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.internal.Intrinsics;
import o9c.c;

/* JADX INFO: loaded from: classes38.dex */
public final class a implements c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map<Object, Object> f541131a;

    public a() {
        this.f541131a = new ConcurrentHashMap();
    }

    @Override // o9c.c
    public final Object get(Object r100) {
        Intrinsics.checkNotNullParameter(r100, "key");
        return ((ConcurrentHashMap) this.f541131a).get(r100);
    }

    @Override // o9c.c
    public final void remove(Object r100) {
        Intrinsics.checkNotNullParameter(r100, "key");
        ((ConcurrentHashMap) this.f541131a).remove(r100);
    }

    @Override // o9c.c
    public final void set(Object r100, Object r101) {
        Intrinsics.checkNotNullParameter(r100, "key");
        Intrinsics.checkNotNullParameter(r101, "value");
        ((ConcurrentHashMap) this.f541131a).put(r100, r101);
    }
}
