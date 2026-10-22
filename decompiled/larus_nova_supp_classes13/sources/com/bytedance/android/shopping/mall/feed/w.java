package com.bytedance.android.shopping.mall.feed;

import java.util.Map;
import java.util.concurrent.Callable;
import kotlin.Unit;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class w<V> implements Callable {
    public final /* synthetic */ ECMallFeed.ReportAbility a;
    public final /* synthetic */ String b;
    public final /* synthetic */ Map c;

    public w(ECMallFeed.ReportAbility r1, String r2, Map r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    @Override // java.util.concurrent.Callable
    public final void call() {
        this.a.e(this.b, com.bytedance.android.ec.hybrid.list.util.k.b(this.c));
    }

    @Override // java.util.concurrent.Callable
    public /* bridge */ /* synthetic */ Object call() {
        call();
        return Unit.INSTANCE;
    }
}
