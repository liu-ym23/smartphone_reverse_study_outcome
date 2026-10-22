package com.bytedance.android.shopping.mall.feed;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 4, 3})
final class ECMallFeed$createHomePageStickyAction$2 extends Lambda implements Function0<Unit> {
    final /* synthetic */ ECMallFeed this$0;

    public ECMallFeed$createHomePageStickyAction$2(ECMallFeed r1) {
        this.this$0 = r1;
        super(0);
    }

    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
    public final void m995invoke() {
        ECMallFeed.h0(this.this$0, "favorite_section", 0, true, 0.0f, null, 24);
    }

    public /* bridge */ /* synthetic */ Object invoke() {
        m995invoke();
        return Unit.INSTANCE;
    }
}
