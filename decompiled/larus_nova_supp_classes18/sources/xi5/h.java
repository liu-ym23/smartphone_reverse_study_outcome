package xi5;

import com.bytedance.ee.bear.contract.Result;
import io.reactivex.functions.Function;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class h<T, R> implements Function {
    public static final h<T, R> a = null;

    static {
        a = new h();
    }

    public h() {
    }

    public final Object apply(Object r2) {
        Result r3 = (Result) r2;
        Intrinsics.checkNotNullParameter(r3, "it");
        return (Boolean) r3.data;
    }
}
