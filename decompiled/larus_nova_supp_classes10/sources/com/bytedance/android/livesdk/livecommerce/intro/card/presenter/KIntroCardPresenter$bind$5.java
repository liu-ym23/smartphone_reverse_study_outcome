package com.bytedance.android.livesdk.livecommerce.intro.card.presenter;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/bytedance/android/livesdk/livecommerce/intro/card/vm/a;", "event", "", "invoke", "(Lcom/bytedance/android/livesdk/livecommerce/intro/card/vm/a;)V", "<anonymous>"}, k = 3, mv = {1, 4, 3})
final class KIntroCardPresenter$bind$5 extends Lambda implements Function1<com.bytedance.android.livesdk.livecommerce.intro.card.vm.a, Unit> {
    final /* synthetic */ j this$0;

    public KIntroCardPresenter$bind$5(j r1) {
        this.this$0 = r1;
        super(1);
    }

    public final void invoke(com.bytedance.android.livesdk.livecommerce.intro.card.vm.a r2) {
        Intrinsics.checkNotNullParameter(r2, "event");
        j.E(this.this$0, r2);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        invoke((com.bytedance.android.livesdk.livecommerce.intro.card.vm.a) r1);
        return Unit.INSTANCE;
    }
}
