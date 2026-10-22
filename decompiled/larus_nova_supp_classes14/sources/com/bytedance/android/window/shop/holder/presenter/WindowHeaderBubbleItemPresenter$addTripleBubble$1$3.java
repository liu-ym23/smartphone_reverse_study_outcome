package com.bytedance.android.window.shop.holder.presenter;

import android.view.View;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\u0010\u000b\u001a\u00020\u00072\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u000e\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006¢\u0006\u0004\b\t\u0010\n"}, d2 = {"Landroid/view/View;", "p1", "Luq3/e;", "p2", "", "p3", "Lkotlin/Function0;", "", "p4", "invoke", "(Landroid/view/View;Luq3/e;ILkotlin/jvm/functions/Function0;)V", "<anonymous>"}, k = 3, mv = {1, 4, 3})
final /* synthetic */ class WindowHeaderBubbleItemPresenter$addTripleBubble$1$3 extends FunctionReferenceImpl implements Function4<View, uq3.e, Integer, Function0<? extends Unit>, Unit> {
    public WindowHeaderBubbleItemPresenter$addTripleBubble$1$3(WindowHeaderBubbleItemPresenter r8) {
        super(4, r8, WindowHeaderBubbleItemPresenter.class, "bubbleCardBindGuide", "bubbleCardBindGuide(Landroid/view/View;Lcom/bytedance/android/window/shop/repository/vo/WindowBubbleVO;ILkotlin/jvm/functions/Function0;)V", 0);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2, Object r3, Object r4) {
        invoke((View) r1, (uq3.e) r2, ((Number) r3).intValue(), (Function0) r4);
        return Unit.INSTANCE;
    }

    public final void invoke(View r2, uq3.e r3, int r4, Function0<Unit> r5) {
        Intrinsics.checkNotNullParameter(r2, "p1");
        Intrinsics.checkNotNullParameter(r3, "p2");
        WindowHeaderBubbleItemPresenter.i0((WindowHeaderBubbleItemPresenter) ((CallableReference) this).receiver, r2, r3, r4, r5);
    }
}
