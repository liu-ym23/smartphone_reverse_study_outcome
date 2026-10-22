package com.bytedance.android.shopping.mall.homepage;

import com.bytedance.android.ec.hybrid.list.util.CommonUtilKt;
import com.bytedance.android.ec.hybrid.log.mall.ECMallLogUtil;
import com.bytedance.android.shopping.mall.feed.ECMallFeed;
import kotlin.Lazy;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class l implements ECMallFeed.m {
    public final /* synthetic */ ECMallFragment a;
    public final /* synthetic */ ECMallFeed b;

    @Override // com.bytedance.android.shopping.mall.feed.ECMallFeed.m
    public final void a(com.bytedance.android.ec.hybrid.list.util.d r2) {
        Intrinsics.checkNotNullParameter(r2, "lynxLoadResult");
        if (this.a.U2 == false) goto L6;
        Lazy r3 = ECMallLogUtil.a;
        ECMallLogUtil.a(com.bytedance.android.ec.hybrid.log.mall.m.a.b, "going to hide loading view after relayout");
        CommonUtilKt.g(new ECMallFragment$initListEngine$9$onLoadEnd$1(this));
        return;
    }

    public l(ECMallFragment r1, ECMallFeed r2) {
        this.a = r1;
        this.b = r2;
    }
}
