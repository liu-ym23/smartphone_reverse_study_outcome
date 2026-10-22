package com.bytedance.android.livesdk.livecommerce.promotionlist.presenter;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"setListLeftExclusiveSpace", "", "space", "", "invoke"}, k = 3, mv = {1, 4, 3})
final class LivePromotionListGroupPresenter$initListOpenArea$1 extends Lambda implements Function1<Integer, Unit> {
    final /* synthetic */ LivePromotionListGroupPresenter this$0;

    public LivePromotionListGroupPresenter$initListOpenArea$1(LivePromotionListGroupPresenter r1) {
        this.this$0 = r1;
        super(1);
    }

    public final void invoke(int r3) {
        LivePromotionListGroupPresenter r0 = this.this$0;
        r0.t = r3;
        LivePromotionListGroupPresenter.h0(r0);
        if (r3 <= 0) goto L6;
        this.this$0.Z().b(2131372865).f().setBackgroundColor(-1);
        this.this$0.Z().b(2131372751).f().setBackgroundColor(-1);
        return;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        invoke(((Number) r1).intValue());
        return Unit.INSTANCE;
    }
}
