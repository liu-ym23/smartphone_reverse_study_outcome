package com.bytedance.android.livesdk.livecommerce.userinfo.rank.persenter;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lkl2/a;", "<name for destructuring parameter 0>", "", "invoke", "(Lkl2/a;)V", "<anonymous>"}, k = 3, mv = {1, 4, 3})
final class ECRankPresenter$onBind$1 extends Lambda implements Function1<kl2.a, Unit> {
    final /* synthetic */ a this$0;

    public ECRankPresenter$onBind$1(a r1) {
        super(1);
    }

    public final void invoke(kl2.a r2) {
        Intrinsics.checkNotNullParameter(r2, "<name for destructuring parameter 0>");
        kl2.a.C0150a r0 = r2.a;
        if (r2.b != null) goto L5;
        return;
    L5:
        int r3 = a.e;
        throw null;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        invoke((kl2.a) r1);
        return Unit.INSTANCE;
    }
}
