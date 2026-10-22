package io.ktor.util;

import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes41.dex */
public abstract class c implements b {
    public c() {
    }

    public abstract Map<a<?>, Object> f();

    @Override // io.ktor.util.b
    public final <T> T b(a<T> r100) {
        Intrinsics.checkNotNullParameter(r100, "key");
        return (T) f().get(r100);
    }

    @Override // io.ktor.util.b
    public final <T> T c(a<T> r100) {
        Intrinsics.checkNotNullParameter(r100, "key");
        T r101 = (T) b(r100);
        if (r101 == null) goto L6;
        return r101;
    L6:
        throw new IllegalStateException("No instance for key " + r100);
    }

    @Override // io.ktor.util.b
    public final boolean d(a<?> r100) {
        Intrinsics.checkNotNullParameter(r100, "key");
        return f().containsKey(r100);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // io.ktor.util.b
    public final <T> void a(a<T> r100, T r101) {
        Intrinsics.checkNotNullParameter(r100, "key");
        Intrinsics.checkNotNullParameter(r101, "value");
        f().put(r100, r101);
    }
}
