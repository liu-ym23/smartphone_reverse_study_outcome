package com.bytedance.android.livesdk.livecommerce.intro.auction;

import com.bytedance.android.livesdk.livecommerce.intro.event.IntroCardEventCenter;
import com.bytedance.android.livesdk.livecommerce.intro.event.i;
import com.bytedance.android.livesdk.livecommerce.intro.model.vo.IntroAuctionPromotionVO;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\n¢\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", "", "stamp", "", "cardState", "Lcom/bytedance/android/livesdk/livecommerce/intro/model/vo/IntroAuctionPromotionVO;", "invoke"}, k = 3, mv = {1, 4, 3})
final class IntroAuctionPresenter$logShowDurationEvent$1 extends Lambda implements Function2<Long, IntroAuctionPromotionVO, Unit> {
    final /* synthetic */ IntroAuctionPresenter this$0;

    public IntroAuctionPresenter$logShowDurationEvent$1(IntroAuctionPresenter r1) {
        this.this$0 = r1;
        super(2);
    }

    public final void invoke(long r4, IntroAuctionPromotionVO r6) {
        Intrinsics.checkNotNullParameter(r6, "cardState");
        IntroAuctionPresenter r7 = this.this$0;
        oh2.e r0 = r7.j;
        if (r0 == null) goto L11;
        IntroCardEventCenter r1 = r0.a;
        if (r1 == null) goto L12;
        IntroAuctionPromotionVO r8 = r7.h;
        long r2 = System.currentTimeMillis() - r4;
        IntroAuctionViewModel r5 = this.this$0.f;
        if (r5 == null) goto L9;
        r5.getRoomContextController();
    L9:
        IntroCardEventCenter.b(new i(r1, r8, r2));
        return;
    L12:
        return;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r3, Object r4) {
        invoke(((Number) r3).longValue(), (IntroAuctionPromotionVO) r4);
        return Unit.INSTANCE;
    }
}
