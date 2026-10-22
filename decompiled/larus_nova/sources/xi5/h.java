package xi5;

import com.bytedance.ee.bear.contract.Result;
import io.reactivex.functions.Function;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public final class h<T, R> implements Function {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final h<T, R> f563961a = null;

    static {
        f563961a = new h();
    }

    public h() {
    }

    @Override // io.reactivex.functions.Function
    public final Object apply(Object r100) {
        Result r101 = (Result) r100;
        Intrinsics.checkNotNullParameter(r101, "it");
        return (Boolean) r101.data;
    }
}
