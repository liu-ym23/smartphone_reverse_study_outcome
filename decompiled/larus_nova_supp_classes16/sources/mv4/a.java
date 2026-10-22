package mv4;

import com.bytedance.ee.bear.contract.net.SimpleRequestResult;
import io.reactivex.functions.Function;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class a<T, R> implements Function {
    public static final a<T, R> a = null;

    static {
        a = new a();
    }

    public a() {
    }

    public final Object apply(Object r2) {
        SimpleRequestResult r3 = (SimpleRequestResult) r2;
        Intrinsics.checkNotNullParameter(r3, "it");
        return Integer.valueOf(r3.code);
    }
}
