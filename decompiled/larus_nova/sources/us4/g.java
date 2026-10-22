package us4;

import com.bytedance.ee.bear.bitable.homepage.preview.HomePageBoostData;
import com.bytedance.ee.bear.contract.Result;
import io.reactivex.functions.Function;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
public final class g<T, R> implements Function {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final g<T, R> f551488a = null;

    static {
        f551488a = new g();
    }

    public g() {
    }

    @Override // io.reactivex.functions.Function
    public final Object apply(Object r100) {
        Result r101 = (Result) r100;
        Intrinsics.checkNotNullParameter(r101, "it");
        return (HomePageBoostData) r101.getData();
    }
}
