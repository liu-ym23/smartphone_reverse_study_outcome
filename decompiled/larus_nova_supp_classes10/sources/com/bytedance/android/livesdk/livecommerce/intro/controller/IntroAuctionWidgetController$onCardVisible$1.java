package com.bytedance.android.livesdk.livecommerce.intro.controller;

import com.bytedance.android.livesdk.livecommerce.intro.model.vo.IntroAuctionPromotionVO;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u0004\u0018\u00010\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 4, 3})
final class IntroAuctionWidgetController$onCardVisible$1 extends Lambda implements Function0<String> {
    final /* synthetic */ IntroAuctionWidgetController this$0;

    public IntroAuctionWidgetController$onCardVisible$1(IntroAuctionWidgetController r1) {
        this.this$0 = r1;
        super(0);
    }

    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
    public final String m714invoke() {
        IntroAuctionPromotionVO r0 = this.this$0.c.getCardState().a();
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getScheme();
    }

    public /* bridge */ /* synthetic */ Object invoke() {
        return m714invoke();
    }
}
