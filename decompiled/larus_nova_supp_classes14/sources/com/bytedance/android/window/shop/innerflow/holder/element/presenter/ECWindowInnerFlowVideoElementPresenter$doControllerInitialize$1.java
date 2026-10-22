package com.bytedance.android.window.shop.innerflow.holder.element.presenter;

import com.bytedance.android.window.shop.innerflow.widget.ControllerState;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "Lcom/bytedance/android/window/shop/innerflow/widget/ControllerState;", "p1", "invoke"}, k = 3, mv = {1, 4, 3})
final /* synthetic */ class ECWindowInnerFlowVideoElementPresenter$doControllerInitialize$1 extends FunctionReferenceImpl implements Function1<ControllerState, ControllerState> {
    public ECWindowInnerFlowVideoElementPresenter$doControllerInitialize$1(ECWindowInnerFlowVideoElementPresenter.a r8) {
        super(1, r8, ECWindowInnerFlowVideoElementPresenter.a.class, "doStateTransform", "doStateTransform(Lcom/bytedance/android/window/shop/innerflow/widget/ControllerState;)Lcom/bytedance/android/window/shop/innerflow/widget/ControllerState;", 0);
    }

    public final ControllerState invoke(ControllerState r2) {
        Intrinsics.checkNotNullParameter(r2, "p1");
        ((ECWindowInnerFlowVideoElementPresenter.a) ((CallableReference) this).receiver).getClass();
        return ECWindowInnerFlowVideoElementPresenter.a.a(r2);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        return invoke((ControllerState) r1);
    }
}
