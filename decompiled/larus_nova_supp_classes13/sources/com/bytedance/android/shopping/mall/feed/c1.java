package com.bytedance.android.shopping.mall.feed;

import android.content.Context;
import com.bytedance.android.ec.hybrid.card.service.ECLynxAnnieXService;
import java.util.concurrent.Callable;
import kotlin.Unit;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class c1<V> implements Callable {
    public final /* synthetic */ Context a;
    public final /* synthetic */ String b;

    public c1(Context r1) {
        this.a = r1;
        this.b = "product_detail";
    }

    @Override // java.util.concurrent.Callable
    public final void call() {
        if (ECLynxAnnieXService.b() == false) goto L5;
        new ECMallFeedPreloadTask4AnnieX(this.a, this.b).run();
        return;
    L5:
        new ECMallFeedPreloadTask4LynxCard(this.a, this.b).run();
    }

    @Override // java.util.concurrent.Callable
    public /* bridge */ /* synthetic */ Object call() {
        call();
        return Unit.INSTANCE;
    }
}
