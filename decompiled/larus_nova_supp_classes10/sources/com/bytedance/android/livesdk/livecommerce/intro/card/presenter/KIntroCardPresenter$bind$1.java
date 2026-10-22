package com.bytedance.android.livesdk.livecommerce.intro.card.presenter;

import com.bytedance.android.livesdk.livecommerce.intro.card.vm.IntroCardViewModel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"<anonymous>", "", "it", "invoke", "(Lkotlin/Unit;)V"}, k = 3, mv = {1, 4, 3})
final class KIntroCardPresenter$bind$1 extends Lambda implements Function1<Unit, Unit> {
    final /* synthetic */ j this$0;

    public KIntroCardPresenter$bind$1(j r1) {
        this.this$0 = r1;
        super(1);
    }

    public final void invoke(Unit r3) {
        Intrinsics.checkNotNullParameter(r3, "it");
        IntroCardViewModel r4 = this.this$0.e;
        if (r4 == null) goto L5;
        r4.setLastShowedPromotionId(null);
    L5:
        j r5 = this.this$0;
        r5.j = Long.valueOf(System.currentTimeMillis());
        j r6 = this.this$0;
        r6.getClass();
        int r1 = nh2.a.a;
        Intrinsics.checkNotNullParameter(r6.w().f(), "view");
        this.this$0.u().d().q(ph2.h.class, 0);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        invoke((Unit) r1);
        return Unit.INSTANCE;
    }
}
