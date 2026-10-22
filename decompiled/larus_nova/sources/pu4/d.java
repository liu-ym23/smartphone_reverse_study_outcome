package pu4;

import com.bytedance.ee.bear.bitable.share.permission.ShareTokenData;
import io.reactivex.functions.Function;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes16.dex */
public final class d<T, R> implements Function {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final d<T, R> f530726a = null;

    static {
        f530726a = new d();
    }

    public d() {
    }

    @Override // io.reactivex.functions.Function
    public final Object apply(Object r100) {
        ShareTokenData r101 = (ShareTokenData) r100;
        Intrinsics.checkNotNullParameter(r101, "it");
        return r101.getShareToken();
    }
}
