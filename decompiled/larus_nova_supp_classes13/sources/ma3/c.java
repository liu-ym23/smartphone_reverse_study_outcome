package ma3;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class c {
    public static final b a(com.bytedance.kmp.ec.yata.common.protocol.data.e r3) {
        Intrinsics.checkNotNullParameter(r3, "$this$transformToBuyNowResponse");
        b r0 = new b(r3.g(), 4);
        r0.d(r3.a());
        r0.e(r3.b());
        r0.f(r3.c());
        ((com.bytedance.kmp.ec.yata.common.protocol.data.a) r0).a = ((com.bytedance.kmp.ec.yata.common.protocol.data.a) r3).a;
        return r0;
    }

    public static final com.bytedance.android.shopping.sku.inner.repo.a b(com.bytedance.kmp.ec.yata.common.protocol.data.e r3) {
        Intrinsics.checkNotNullParameter(r3, "$this$transformToSKUResponse");
        com.bytedance.android.shopping.sku.inner.repo.a r0 = new com.bytedance.android.shopping.sku.inner.repo.a(r3.g(), 6);
        r0.d(r3.a());
        r0.e(r3.b());
        r0.f(r3.c());
        ((com.bytedance.kmp.ec.yata.common.protocol.data.a) r0).a = ((com.bytedance.kmp.ec.yata.common.protocol.data.a) r3).a;
        return r0;
    }
}
