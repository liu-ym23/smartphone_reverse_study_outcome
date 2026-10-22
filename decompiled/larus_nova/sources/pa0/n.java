package pa0;

import com.bytedance.android.live.network.response.ExtraResponse;
import io.reactivex.functions.Function;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
public final class n<T, R> implements Function {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final n f528349a = null;

    static {
        f528349a = new n();
    }

    public n() {
    }

    @Override // io.reactivex.functions.Function
    public final Object apply(Object r100) {
        ExtraResponse r101 = (ExtraResponse) r100;
        Intrinsics.checkNotNullParameter(r101, "it");
        return new k((com.bytedance.android.live.recharge.platform.business.model.income.b) r101.data, (com.bytedance.android.live.recharge.platform.business.model.income.d) r101.extra);
    }
}
