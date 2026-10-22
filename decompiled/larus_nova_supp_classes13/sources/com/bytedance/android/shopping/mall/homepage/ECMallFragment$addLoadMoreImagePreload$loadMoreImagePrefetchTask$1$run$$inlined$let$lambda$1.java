package com.bytedance.android.shopping.mall.homepage;

import com.bytedance.android.ec.hybrid.list.util.CommonUtilKt;
import com.bytedance.android.shopping.mall.opt.MallOptUtil;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class ECMallFragment$addLoadMoreImagePreload$loadMoreImagePrefetchTask$1$run$$inlined$let$lambda$1 implements com.bytedance.android.ec.hybrid.list.ability.b {
    public final /* synthetic */ com.bytedance.android.ec.hybrid.data.i a;
    public final /* synthetic */ a b;

    public final void a(final int r2) {
        final Runnable r0 = new AnonymousClass1(this, r2);
        if (((Boolean) MallOptUtil.g.getValue()).booleanValue() == false) goto L5;
        CommonUtilKt.g(new AnonymousClass2(r0));
        return;
    L5:
        r0.run();
    }

    public ECMallFragment$addLoadMoreImagePreload$loadMoreImagePrefetchTask$1$run$$inlined$let$lambda$1(com.bytedance.android.ec.hybrid.data.i r1, a r2) {
        this.a = r1;
        this.b = r2;
    }
}
