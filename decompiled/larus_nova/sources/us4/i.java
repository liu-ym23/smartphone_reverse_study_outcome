package us4;

import com.bytedance.ee.bear.bitable.infoarch.nativeview.common.BitableNativeViewData;
import com.bytedance.ee.bear.contract.Result;
import io.reactivex.functions.Function;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
public final class i<T, R> implements Function {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final i<T, R> f551490a = null;

    static {
        f551490a = new i();
    }

    public i() {
    }

    @Override // io.reactivex.functions.Function
    public final Object apply(Object r100) {
        Result r101 = (Result) r100;
        Intrinsics.checkNotNullParameter(r101, "data");
        return (BitableNativeViewData) r101.data;
    }
}
