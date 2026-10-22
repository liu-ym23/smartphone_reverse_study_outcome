package mv4;

import com.bytedance.ee.bear.bitable.workbench.WorkBenchStatus;
import io.reactivex.functions.Function;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class b<T, R> implements Function {
    public static final b<T, R> a = null;

    static {
        a = new b();
    }

    public b() {
    }

    public final Object apply(Object r2) {
        WorkBenchStatus r3 = (WorkBenchStatus) r2;
        Intrinsics.checkNotNullParameter(r3, "it");
        return Boolean.valueOf(r3.getStatus());
    }
}
