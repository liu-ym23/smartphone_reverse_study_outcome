package or1;

import com.bytedance.android.live.base.model.user.UserExtra;
import com.bytedance.android.live.network.response.BaseResponse;
import io.reactivex.functions.Function;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
public final class p<T, R> implements Function {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final p f524922a = null;

    static {
        f524922a = new p();
    }

    public p() {
    }

    @Override // io.reactivex.functions.Function
    public final Object apply(Object r100) {
        BaseResponse r101 = (BaseResponse) r100;
        Intrinsics.checkNotNullParameter(r101, "it");
        return new Pair(r101.data, Boolean.valueOf(((UserExtra) r101.extra).isAnonymousIsSilence()));
    }
}
