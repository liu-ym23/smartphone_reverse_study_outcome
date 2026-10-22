package com.bytedance.android.shopping.mall.feed;

import com.bytedance.android.shopping.mall.feed.help.ECMallGulRefresh;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 4, 3})
final class ECMallFeed$autoGulRefresh$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ ECMallFeed this$0;

    public ECMallFeed$autoGulRefresh$1(ECMallFeed r1) {
        this.this$0 = r1;
        super(0);
    }

    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
    public final void m982invoke() {
        com.bytedance.android.shopping.mall.opt.g r0 = new com.bytedance.android.shopping.mall.opt.g("autoRefresh", this.this$0.B1.c);
        r0.b(null);
        Integer r2 = this.this$0.D1;
        if (r2 != null) goto L5;
    L8:
        ECMallFeed r3 = this.this$0;
        Lazy r4 = ECMallGulRefresh.g;
        String r5 = r3.r(ECMallGulRefresh.Companion.a().c());
    L9:
        this.this$0.m(null, r5, true, r0);
        return;
    L5:
        if (r2.intValue() == 0) goto L8;
        r5 = null;
        goto L9
    }

    public /* bridge */ /* synthetic */ Object invoke() {
        m982invoke();
        return Unit.INSTANCE;
    }
}
