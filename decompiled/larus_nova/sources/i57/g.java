package i57;

import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
public final class g extends a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Map<String, Object> f488326b;

    public g(Map<String, Object> r100) {
        Intrinsics.checkNotNullParameter(r100, "contents");
        super(r100);
        this.f488326b = r100;
    }

    public final <T> void b(a.C6231a<T> r100, T r101) {
        Intrinsics.checkNotNullParameter(r100, "key");
        Intrinsics.checkNotNullParameter(r101, "value");
        this.f488326b.put(r100.f488316a, r101);
    }
}
