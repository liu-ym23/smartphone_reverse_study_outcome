package com.bytedance.android.livesdk.livecommerce.promotionlist.presenter;

import android.view.View;
import android.view.ViewGroup;
import com.bytedance.android.livesdk.livecommerce.utils.UtilityKotlinExtentionsKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "p1", "", "invoke"}, k = 3, mv = {1, 4, 3})
final /* synthetic */ class LivePromotionListGroupPresenter$observeData$10 extends FunctionReferenceImpl implements Function1<Integer, Unit> {
    public LivePromotionListGroupPresenter$observeData$10(LivePromotionListGroupPresenter r8) {
        super(1, r8, LivePromotionListGroupPresenter.class, "setListHeaderExtraMargin", "setListHeaderExtraMargin(I)V", 0);
    }

    public final void invoke(int r6) {
        LivePromotionListGroupPresenter r0 = (LivePromotionListGroupPresenter) ((CallableReference) this).receiver;
        int r1 = LivePromotionListGroupPresenter.D;
        View r2 = r0.Z().b(2131378118).f();
        Integer r7 = Integer.valueOf(UtilityKotlinExtentionsKt.d(Integer.valueOf(r6)));
        Intrinsics.checkNotNullParameter(r2, "$this$setMarginsDefaultCur");
        ViewGroup.LayoutParams r3 = r2.getLayoutParams();
        if ((r3 instanceof ViewGroup.MarginLayoutParams) == true) goto L5;
        r3 = null;
    L5:
        ViewGroup.MarginLayoutParams r4 = (ViewGroup.MarginLayoutParams) r3;
        if (r4 == null) goto L13;
        int r5 = r4.leftMargin;
        int r8 = r4.topMargin;
        int r9 = r4.rightMargin;
        if (r7 == null) goto L10;
        int r10 = r7.intValue();
    L11:
        r4.setMargins(r5, r8, r9, r10);
        Unit r11 = Unit.INSTANCE;
        r2.setLayoutParams(r4);
        return;
    L10:
        r10 = r4.bottomMargin;
        goto L11
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        invoke(((Number) r1).intValue());
        return Unit.INSTANCE;
    }
}
