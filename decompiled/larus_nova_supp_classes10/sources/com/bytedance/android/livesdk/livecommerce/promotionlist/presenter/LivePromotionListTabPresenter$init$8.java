package com.bytedance.android.livesdk.livecommerce.promotionlist.presenter;

import com.bytedance.android.ec.core.monitor.ECExceptionMonitor;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/bytedance/android/livesdk/livecommerce/promotionlist/viewmodel/a$f;", "it", "", "invoke", "(Lcom/bytedance/android/livesdk/livecommerce/promotionlist/viewmodel/a$f;)V", "<anonymous>"}, k = 3, mv = {1, 4, 3})
public final class LivePromotionListTabPresenter$init$8 extends Lambda implements Function1<com.bytedance.android.livesdk.livecommerce.promotionlist.viewmodel.a.f, Unit> {
    final /* synthetic */ LivePromotionListTabPresenter this$0;

    public LivePromotionListTabPresenter$init$8(LivePromotionListTabPresenter r1) {
        this.this$0 = r1;
        super(1);
    }

    public final void invoke(com.bytedance.android.livesdk.livecommerce.promotionlist.viewmodel.a.f r2) {
        Intrinsics.checkNotNullParameter(r2, "it");
        Result.Companion r3 = Result.Companion;     // Catch: Throwable -> L5
        LivePromotionListTabPresenter.h0(this.this$0).r(new LivePromotionListTabPresenter$init$8$$special$$inlined$runCatching$lambda$1(this));     // Catch: Throwable -> L5
        Object r4 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L5
    L7:
        Throwable r5 = Result.exceptionOrNull-impl(r4);
        if (r5 == null) goto L13;
        ECExceptionMonitor.e(r5);
        return;
    L13:
        return;
    L5:
        th = move-exception;
        Result.Companion r0 = Result.Companion;
        r4 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L7
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        invoke((com.bytedance.android.livesdk.livecommerce.promotionlist.viewmodel.a.f) r1);
        return Unit.INSTANCE;
    }
}
