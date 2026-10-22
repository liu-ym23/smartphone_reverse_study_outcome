package ma3;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class c {
    public static final b a(com.bytedance.kmp.ec.yata.common.protocol.data.e r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$transformToBuyNowResponse");
        b r101 = new b(r100.g(), 4);
        r101.d(r100.a());
        r101.e(r100.b());
        r101.f(r100.c());
        r101.f251550a = r100.f251550a;
        return r101;
    }

    public static final com.bytedance.android.shopping.sku.inner.repo.a b(com.bytedance.kmp.ec.yata.common.protocol.data.e r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$transformToSKUResponse");
        com.bytedance.android.shopping.sku.inner.repo.a r101 = new com.bytedance.android.shopping.sku.inner.repo.a(r100.g(), 6);
        r101.d(r100.a());
        r101.e(r100.b());
        r101.f(r100.c());
        r101.f251550a = r100.f251550a;
        return r101;
    }
}
