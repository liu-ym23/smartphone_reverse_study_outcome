package com.bytedance.android.livesdk.livecommerce.promotionlist.presenter;

import android.view.View;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "Landroid/view/View;", "p1", "", "invoke"}, k = 3, mv = {1, 4, 3})
final /* synthetic */ class LivePromotionListRootPresenter$initLinkMicStyle$2 extends FunctionReferenceImpl implements Function1<Integer, View> {
    public LivePromotionListRootPresenter$initLinkMicStyle$2(LivePromotionListRootPresenter r8) {
        super(1, r8, LivePromotionListRootPresenter.class, "getPageView", "getPageView(I)Landroid/view/View;", 0);
    }

    public final View invoke(int r2) {
        LivePromotionListRootPresenter r0 = (LivePromotionListRootPresenter) ((CallableReference) this).receiver;
        if (r2 != 0) goto L9;
        View r3 = r0.l;
        if (r3 == null) goto L8;
        return r3;
    L8:
        throw new NullPointerException("null cannot be cast to non-null type android.view.View");
    L9:
        int r4 = LivePromotionListRootPresenter.t;
        return r0.j0();
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        return invoke(((Number) r1).intValue());
    }
}
