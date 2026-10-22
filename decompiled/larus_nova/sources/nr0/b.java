package nr0;

import com.bytedance.android.live.profit.lottery.k3;
import io.reactivex.functions.Function;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
public final class b<T, R> implements Function {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f520156a = null;

    static {
        f520156a = new b();
    }

    public b() {
    }

    @Override // io.reactivex.functions.Function
    public final Object apply(Object r100) {
        k3 r101 = (k3) r100;
        Intrinsics.checkNotNullParameter(r101, "it");
        return r101.f88133c;
    }
}
