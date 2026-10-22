package com.bytedance.android.shopping.mall.homepage.card.headercard.channel.itemview;

import com.bytedance.android.ec.hybrid.ECHybridExtensionsKt;
import com.bytedance.android.ec.hybrid.card.event.d;
import com.bytedance.android.ec.hybrid.card.event.e;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class BigCardTitleView$playLottie$1$sub$1 implements e {
    public final /* synthetic */ BigCardTitleView$playLottie$1 a;

    public BigCardTitleView$playLottie$1$sub$1(BigCardTitleView$playLottie$1 r1) {
        this.a = r1;
    }

    public final void a(final d r2) {
        Intrinsics.checkNotNullParameter(r2, "jsEvent");
        ECHybridExtensionsKt.f(new BigCardTitleView$playLottie$1$sub$1$onReceiveJsEvent$1(this, r2));
    }
}
