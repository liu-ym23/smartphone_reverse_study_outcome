package pu4;

import com.bytedance.ee.bear.bitable.share.permission.ShareTokenData;
import io.reactivex.functions.Function;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class d<T, R> implements Function {
    public static final d<T, R> a = null;

    static {
        a = new d();
    }

    public d() {
    }

    public final Object apply(Object r2) {
        ShareTokenData r3 = (ShareTokenData) r2;
        Intrinsics.checkNotNullParameter(r3, "it");
        return r3.getShareToken();
    }
}
