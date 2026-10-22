package bh2;

import java.lang.reflect.Constructor;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class y<T> implements am3.c<T> {
    public final Constructor<T> a;

    public y(Constructor<T> r2) {
        Intrinsics.checkNotNullParameter(r2, "constructor");
        this.a = r2;
    }

    public final T decode(am3.g r4) throws Exception {
        Intrinsics.checkNotNullParameter(r4, "reader");
        return this.a.newInstance(new Object[]{r4});
    }
}
