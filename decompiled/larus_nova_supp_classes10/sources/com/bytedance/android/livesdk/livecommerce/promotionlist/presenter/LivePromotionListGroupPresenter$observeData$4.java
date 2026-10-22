package com.bytedance.android.livesdk.livecommerce.promotionlist.presenter;

import android.view.View;
import com.bytedance.android.livesdk.livecommerce.iron.ui.IronPromotionListBackgroundView;
import com.bytedance.android.livesdk.livecommerce.network.response.ECPromotionList;
import com.bytedance.android.livesdk.livecommerce.utils.UtilityKotlinExtentionsKt;
import com.ss.android.ugc.aweme.kiwi.presenter.QFragmentPresenter;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\b\u0010\u0001\u001a\u0004\u0018\u00010\u0000¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/bytedance/android/livesdk/livecommerce/network/response/ECPromotionList$r;", "p1", "", "invoke", "(Lcom/bytedance/android/livesdk/livecommerce/network/response/ECPromotionList$r;)V", "<anonymous>"}, k = 3, mv = {1, 4, 3})
final /* synthetic */ class LivePromotionListGroupPresenter$observeData$4 extends FunctionReferenceImpl implements Function1<ECPromotionList.r, Unit> {
    public LivePromotionListGroupPresenter$observeData$4(LivePromotionListGroupPresenter r8) {
        super(1, r8, LivePromotionListGroupPresenter.class, "setPromotionBackGround", "setPromotionBackGround(Lcom/bytedance/android/livesdk/livecommerce/network/response/ECPromotionList$PromotionBackground;)V", 0);
    }

    public final void invoke(ECPromotionList.r r11) {
        LivePromotionListGroupPresenter r0 = (LivePromotionListGroupPresenter) ((CallableReference) this).receiver;
        int r1 = LivePromotionListGroupPresenter.D;
        r0.getClass();
        Integer r2 = null;
        if (r11 == null) goto L5;
        Integer r3 = Integer.valueOf(r11.type);
    L6:
        if (r11 == null) goto L8;
        ECPromotionList.s r4 = r11.vertical;
    L10:
        if (r3 == null) goto L25;
        if (r4 == null) goto L25;
        IronPromotionListBackgroundView r5 = r0.l;
        if (r5 != null) goto L15;
        Intrinsics.throwUninitializedPropertyAccessException("backgroundView");
    L15:
        IronPromotionListBackgroundView.b(r5, r4, r3.intValue(), r0.d0().getParams().getRoomId(), r0.d0().getPromotionListParams(), r0.d0().getNewJumpHelper(), r0.d0().isInSplitScreen());
        View r12 = ((QFragmentPresenter) r0).e.getView();
        if (r12 == null) goto L30;
        Integer r13 = Integer.valueOf(r12.getWidth());
        if (r13.intValue() <= UtilityKotlinExtentionsKt.c(375)) goto L20;
        boolean r6 = true;
    L21:
        if (r6 == false) goto L23;
        r2 = r13;
    L23:
        if (r2 == null) goto L31;
        com.bytedance.android.ec.core.arch.event.c.d(r0.d0(), new com.bytedance.android.livesdk.livecommerce.promotionlist.viewmodel.a.b((r2.intValue() * 20) / 375.0f));
        return;
    L31:
        return;
    L20:
        r6 = false;
        goto L21
    L30:
        return;
    L25:
        IronPromotionListBackgroundView r7 = r0.l;
        if (r7 != null) goto L28;
        Intrinsics.throwUninitializedPropertyAccessException("backgroundView");
    L28:
        r7.setVisibility(8);
        return;
    L8:
        r4 = null;
        goto L10
    L5:
        r3 = null;
        goto L6
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        invoke((ECPromotionList.r) r1);
        return Unit.INSTANCE;
    }
}
