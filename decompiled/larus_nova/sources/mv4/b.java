package mv4;

import com.bytedance.ee.bear.bitable.workbench.WorkBenchStatus;
import io.reactivex.functions.Function;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes16.dex */
public final class b<T, R> implements Function {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b<T, R> f515879a = null;

    static {
        f515879a = new b();
    }

    public b() {
    }

    @Override // io.reactivex.functions.Function
    public final Object apply(Object r100) {
        WorkBenchStatus r101 = (WorkBenchStatus) r100;
        Intrinsics.checkNotNullParameter(r101, "it");
        return Boolean.valueOf(r101.getStatus());
    }
}
