package com.bytedance.android.shopping.mall.homepage;

import com.bytedance.android.ec.hybrid.hostapi.IHybridHostService;
import com.bytedance.android.ec.hybrid.list.ECHybridListAdapter;
import com.bytedance.android.ec.hybrid.list.ECHybridListEngine;
import com.bytedance.android.ec.hybrid.log.mall.ECMallLogUtil;
import java.util.ArrayList;
import kotlin.Lazy;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class a implements x93.a {
    public final /* synthetic */ ECMallFragment a;

    @Override // x93.a
    public final void I() {
    }

    @Override // x93.a
    public final void d1() {
    }

    @Override // x93.a
    public final String F() {
        return a.class.getName();
    }

    @Override // x93.a
    public final void run() {
        IHybridHostService r0 = com.bytedance.android.ec.hybrid.a.h();
        if (r0 == null) goto L18;
        yj.g r1 = r0.getHostAB();
        if (r1 == null) goto L19;
        com.bytedance.android.ec.hybrid.data.i r2 = r1.k();
        if (r2 != null) goto L9;
        return;
    L9:
        if (r2.c == true) goto L11;
        return;
    L11:
        if (r2.a() <= 0) goto L22;
        Lazy r3 = ECMallLogUtil.a;
        ECMallLogUtil.c(com.bytedance.android.ec.hybrid.log.mall.k.a.b, "add load more image preload");
        ECHybridListEngine r4 = this.a.H0;
        if (r4 == null) goto L23;
        ECHybridListAdapter r5 = r4.a;
        if (r5 == null) goto L24;
        ECMallFragment$addLoadMoreImagePreload$loadMoreImagePrefetchTask$1$run$$inlined$let$lambda$1 r6 = new ECMallFragment$addLoadMoreImagePreload$loadMoreImagePrefetchTask$1$run$$inlined$let$lambda$1(r2, this);
        Intrinsics.checkNotNullParameter(r6, "listener");
        ((ArrayList) r5.h).add(r6);
        return;
    L24:
        return;
    L23:
        return;
    L22:
        return;
    L19:
        return;
    }

    public a(ECMallFragment r1) {
        this.a = r1;
    }

    @Override // java.lang.Comparable
    public final int compareTo(x93.a r2) {
        x93.a r3 = r2;
        Intrinsics.checkNotNullParameter(r3, "other");
        Intrinsics.checkNotNullParameter(r3, "other");
        r3.d1();
        return 1;
    }
}
