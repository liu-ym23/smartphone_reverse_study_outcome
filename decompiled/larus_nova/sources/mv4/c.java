package mv4;

import com.bytedance.ee.bear.contract.net.SimpleRequestResult;
import io.reactivex.functions.Function;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes16.dex */
public final class c<T, R> implements Function {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final c<T, R> f515880a = null;

    static {
        f515880a = new c();
    }

    public c() {
    }

    @Override // io.reactivex.functions.Function
    public final Object apply(Object r100) {
        SimpleRequestResult r101 = (SimpleRequestResult) r100;
        Intrinsics.checkNotNullParameter(r101, "it");
        return Integer.valueOf(r101.code);
    }
}
