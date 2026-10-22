package com.bytedance.android.livesdk.livecommerce.promotionlist.presenter;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "p1", "", "invoke"}, k = 3, mv = {1, 4, 3})
final /* synthetic */ class LivePromotionListGroupPresenter$observeData$6 extends FunctionReferenceImpl implements Function1<String, Unit> {
    public LivePromotionListGroupPresenter$observeData$6(LivePromotionListGroupPresenter r8) {
        super(1, r8, LivePromotionListGroupPresenter.class, "setListBackgroundColorString", "setListBackgroundColorString(Ljava/lang/String;)V", 0);
    }

    public final void invoke(String r3) {
        LivePromotionListGroupPresenter r0 = (LivePromotionListGroupPresenter) ((CallableReference) this).receiver;
        int r1 = LivePromotionListGroupPresenter.D;
        r0.getClass();
        Integer r4 = com.bytedance.android.ec.core.utils.s.b(r3);
        if (r4 == null) goto L6;
        int r5 = r4.intValue();
        r0.Z().b(2131378086).f().setBackgroundColor(r5);
        return;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        invoke((String) r1);
        return Unit.INSTANCE;
    }
}
