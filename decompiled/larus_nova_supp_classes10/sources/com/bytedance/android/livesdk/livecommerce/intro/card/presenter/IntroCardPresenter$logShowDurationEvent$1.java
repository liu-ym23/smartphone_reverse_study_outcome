package com.bytedance.android.livesdk.livecommerce.intro.card.presenter;

import com.bytedance.android.livesdk.livecommerce.intro.card.vm.IntroCardViewModel;
import com.bytedance.android.livesdk.livecommerce.intro.event.IntroCardEventCenter;
import com.bytedance.android.livesdk.livecommerce.intro.model.vo.IntroPromotionVO;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\n¢\u0006\u0004\b\u0006\u0010\u0007"}, d2 = {"<anonymous>", "", "stamp", "", "cardState", "Lcom/bytedance/android/livesdk/livecommerce/intro/model/vo/IntroPromotionVO;", "invoke", "(JLcom/bytedance/android/livesdk/livecommerce/intro/model/vo/IntroPromotionVO;)Lkotlin/Unit;"}, k = 3, mv = {1, 4, 3})
final class IntroCardPresenter$logShowDurationEvent$1 extends Lambda implements Function2<Long, IntroPromotionVO, Unit> {
    final /* synthetic */ IntroCardPresenter this$0;

    public IntroCardPresenter$logShowDurationEvent$1(IntroCardPresenter r1) {
        this.this$0 = r1;
        super(2);
    }

    public final Unit invoke(long r4, IntroPromotionVO r6) {
        Intrinsics.checkNotNullParameter(r6, "cardState");
        IntroCardPresenter r7 = this.this$0;
        oh2.e r0 = r7.f;
        if (r0 == null) goto L10;
        IntroCardEventCenter r1 = r0.a;
        if (r1 == null) goto L10;
        IntroPromotionVO r8 = r7.i;
        long r2 = System.currentTimeMillis() - r4;
        IntroCardViewModel r5 = this.this$0.e;
        if (r5 == null) goto L9;
        r5.getRoomContextController();
    L9:
        IntroCardEventCenter.b(new com.bytedance.android.livesdk.livecommerce.intro.event.i(r1, r8, r2));
        return Unit.INSTANCE;
    L10:
        return null;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r3, Object r4) {
        return invoke(((Number) r3).longValue(), (IntroPromotionVO) r4);
    }
}
