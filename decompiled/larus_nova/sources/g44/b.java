package g44;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
public class b<KEY, DATA> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ConcurrentMap<KEY, Long> f479996a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ConcurrentMap<KEY, DATA> f479997b;

    public b(h24.a r100) {
        Intrinsics.checkNotNullParameter(r100, "config");
        this.f479996a = new ConcurrentHashMap();
        this.f479997b = new ConcurrentHashMap();
    }
}
