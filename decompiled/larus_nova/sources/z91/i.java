package z91;

import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.network.response.BaseResponse;
import io.reactivex.functions.Function;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public final class i<T, R> implements Function {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final i f570987a = null;

    static {
        f570987a = new i();
    }

    public i() {
    }

    @Override // io.reactivex.functions.Function
    public final Object apply(Object r100) {
        BaseResponse r101 = (BaseResponse) r100;
        Intrinsics.checkNotNullParameter(r101, "response");
        T r102 = r101.data;
        if (r102 == null) goto L7;
        return (IBaseUser) r102;
    L7:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.live.base.model.user.IBaseUser");
    }
}
