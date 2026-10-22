package com.bytedance.android.shopping.mall.homepage;

import com.bytedance.android.ec.hybrid.log.mall.ECMallLogUtil;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 4, 3})
final class ECMallFragment$handleCacheDataWrapper$1$onEnd$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ b this$0;

    public ECMallFragment$handleCacheDataWrapper$1$onEnd$1(b r1) {
        this.this$0 = r1;
        super(0);
    }

    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
    public final void m1160invoke() {
        Lazy r0 = ECMallLogUtil.a;
        ECMallLogUtil.c(com.bytedance.android.ec.hybrid.log.mall.m.a.b, "try invoke handleCacheData after PreloadLynxViewTask end, timestamp = " + System.currentTimeMillis());
        this.this$0.getClass();
        throw null;
    }

    public /* bridge */ /* synthetic */ Object invoke() {
        m1160invoke();
        return Unit.INSTANCE;
    }
}
