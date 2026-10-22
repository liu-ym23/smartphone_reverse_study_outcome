package ie5;

import com.bytedance.ee.bear.contract.x;
import io.reactivex.functions.Function;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class f<T, R> implements Function {
    public static final f<T, R> a = null;

    static {
        a = new f();
    }

    public f() {
    }

    public final Object apply(Object r3) {
        Intrinsics.checkNotNullParameter((String) r3, "it");
        return (x) org.koin.java.a.c(x.class, null, null, 6);
    }
}
