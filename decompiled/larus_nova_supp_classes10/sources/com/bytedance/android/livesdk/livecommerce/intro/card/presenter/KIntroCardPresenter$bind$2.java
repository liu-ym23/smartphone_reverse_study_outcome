package com.bytedance.android.livesdk.livecommerce.intro.card.presenter;

import android.view.View;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"<anonymous>", "", "it", "invoke", "(Lkotlin/Unit;)V"}, k = 3, mv = {1, 4, 3})
final class KIntroCardPresenter$bind$2 extends Lambda implements Function1<Unit, Unit> {
    final /* synthetic */ j this$0;

    public KIntroCardPresenter$bind$2(j r1) {
        this.this$0 = r1;
        super(1);
    }

    public final void invoke(Unit r2) {
        Intrinsics.checkNotNullParameter(r2, "it");
        int r3 = nh2.a.a;
        Intrinsics.checkNotNullParameter(this.this$0.w().f(), "view");
        View r4 = this.this$0.w().f();
        r4.setFocusable(true);
        r4.sendAccessibilityEvent(8);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        invoke((Unit) r1);
        return Unit.INSTANCE;
    }
}
