package zc1;

import android.text.TextUtils;
import com.bytedance.android.live.base.exception.ApiServerException;
import com.bytedance.android.live.base.model.MinorExtra;
import com.bytedance.android.live.network.response.ExtraResponse;
import io.reactivex.functions.Function;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
public final class p<T, R> implements Function {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final p f571266a = null;

    static {
        f571266a = new p();
    }

    public p() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // io.reactivex.functions.Function
    public final Object apply(Object r100) {
        ExtraResponse r101 = (ExtraResponse) r100;
        Intrinsics.checkNotNullParameter(r101, "resp");
        if (TextUtils.isEmpty(((MinorExtra) r101.extra).getTwoFactorAuthInfo()) == true) goto L5;
        ApiServerException r102 = new ApiServerException(-666666);
        r102.setExtra(((MinorExtra) r101.extra).getTwoFactorAuthInfo());
        throw r102;
    L5:
        return (com.bytedance.android.live.wallet.model.d) r101.data;
    }
}
