package com.bytedance.android.livesdk.livecommerce.intro.card.presenter;

import com.bytedance.android.livesdk.livecommerce.intro.card.vm.IntroCardViewModel;
import com.bytedance.android.livesdk.livecommerce.intro.model.vo.IntroPromotionVO;
import com.bytedance.android.livesdk.livecommerce.utils.UtilityKotlinExtentionsKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"<anonymous>", "", "it", "invoke", "(Lkotlin/Unit;)V"}, k = 3, mv = {1, 4, 3})
final class KIntroCardPresenter$bind$4 extends Lambda implements Function1<Unit, Unit> {
    final /* synthetic */ j this$0;

    public KIntroCardPresenter$bind$4(j r1) {
        this.this$0 = r1;
        super(1);
    }

    public final void invoke(Unit r5) {
        Intrinsics.checkNotNullParameter(r5, "it");
        final j r6 = this.this$0;
        IntroCardViewModel r0 = r6.e;
        com.bytedance.android.livesdk.livecommerce.room.model.e r1 = null;
        if (r0 == null) goto L7;
        bk2.e<IntroPromotionVO> r2 = r0.getCardState();
        if (r2 == null) goto L7;
        IntroPromotionVO r3 = r2.a();
    L8:
        IntroCardViewModel r4 = r6.e;
        if (r4 == null) goto L11;
        r1 = r4.getLiveRoomInfo();
    L11:
        UtilityKotlinExtentionsKt.g(r0, r3, r1, new KIntroCardPresenter$logShowEvent$1(r6));
        return;
    L7:
        r3 = null;
        goto L8
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        invoke((Unit) r1);
        return Unit.INSTANCE;
    }
}
