package zp5;

import io.reactivex.functions.Function;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class b<T, R> implements Function {
    public static final b<T, R> a = null;

    static {
        a = new b();
    }

    public b() {
    }

    public final Object apply(Object r3) {
        Intrinsics.checkNotNullParameter((String) r3, "it");
        return (xq5.a) org.koin.java.a.c(xq5.a.class, null, null, 6);
    }
}
