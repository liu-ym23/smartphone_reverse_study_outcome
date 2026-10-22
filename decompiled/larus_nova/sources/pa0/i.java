package pa0;

import com.bytedance.android.live.network.response.ExtraResponse;
import io.reactivex.functions.Function;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
public final class i<T, R> implements Function {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final i f528342a = null;

    static {
        f528342a = new i();
    }

    public i() {
    }

    @Override // io.reactivex.functions.Function
    public final Object apply(Object r100) {
        ExtraResponse r101 = (ExtraResponse) r100;
        Intrinsics.checkNotNullParameter(r101, "it");
        com.bytedance.android.live.recharge.platform.business.model.income.a r102 = (com.bytedance.android.live.recharge.platform.business.model.income.a) r101.data;
        EXTRA r103 = r101.extra;
        if ((r102 instanceof com.bytedance.android.live.recharge.platform.business.model.income.b) == true) goto L5;
    L7:
        boolean r104 = false;
    L8:
        if (r104 == false) goto L11;
        return r101;
    L11:
        throw new IllegalStateException("Check failed.".toString());
    L5:
        if ((r103 instanceof com.bytedance.android.live.recharge.platform.business.model.income.d) == false) goto L7;
        r104 = true;
        goto L8
    }
}
