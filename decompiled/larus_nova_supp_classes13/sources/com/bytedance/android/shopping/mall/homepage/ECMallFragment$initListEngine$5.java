package com.bytedance.android.shopping.mall.homepage;

import com.bytedance.android.ec.hybrid.list.util.CommonUtilKt;
import com.bytedance.android.shopping.mall.feed.ECMallFeed;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class ECMallFragment$initListEngine$5 implements ECMallFeed.g {
    public final /* synthetic */ ECMallFragment a;

    public ECMallFragment$initListEngine$5(ECMallFragment r1) {
        this.a = r1;
    }

    @Override // com.bytedance.android.shopping.mall.feed.ECMallFeed.g
    public final void a(final String r2) {
        Intrinsics.checkNotNullParameter(r2, "flag");
        kk.d.c(new ECMallFragment$initListEngine$5$onDataSetChanged$1(this, r2));
        if (Intrinsics.areEqual(r2, "cache") == false) goto L6;
        CommonUtilKt.g(new ECMallFragment$initListEngine$5$onDataSetChanged$2(this));
        return;
    L6:
        if (Intrinsics.areEqual(r2, "real") == false) goto L13;
        ECMallFragment r3 = this.a;
        int r0 = ECMallFragment.h4;
        if (r3.la0().getEnableExpand() == false) goto L14;
        CommonUtilKt.g(new ECMallFragment$expandCategoryTabTouchAreaIfNeed$1(r3));
        return;
    L14:
        return;
    }
}
