package ie5;

import com.bytedance.ee.bear.contract.x;
import io.reactivex.functions.Function;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public final class f<T, R> implements Function {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final f<T, R> f489482a = null;

    static {
        f489482a = new f();
    }

    public f() {
    }

    @Override // io.reactivex.functions.Function
    public final Object apply(Object r100) {
        Intrinsics.checkNotNullParameter((String) r100, "it");
        return (x) org.koin.java.a.c(x.class, null, null, 6);
    }
}
