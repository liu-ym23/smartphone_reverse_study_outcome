package ha9;

import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final b f484422a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ConcurrentHashMap<String, Object> f484423b;

    public f() {
        g r100 = g.f484424a;
        Intrinsics.checkNotNullParameter(r100, "reporter");
        this.f484422a = r100;
        this.f484423b = new ConcurrentHashMap();
    }
}
