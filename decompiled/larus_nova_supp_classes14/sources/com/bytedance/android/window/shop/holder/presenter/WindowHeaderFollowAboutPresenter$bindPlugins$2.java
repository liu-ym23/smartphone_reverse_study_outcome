package com.bytedance.android.window.shop.holder.presenter;

import com.bytedance.android.ec.model.ECUrlModel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "p1", "", "invoke"}, k = 3, mv = {1, 4, 3})
final /* synthetic */ class WindowHeaderFollowAboutPresenter$bindPlugins$2 extends FunctionReferenceImpl implements Function1<Boolean, Unit> {
    public WindowHeaderFollowAboutPresenter$bindPlugins$2(WindowHeaderFollowAboutPresenter r8) {
        super(1, r8, WindowHeaderFollowAboutPresenter.class, "updateFansCouponFollowBubbleTag", "updateFansCouponFollowBubbleTag(Z)V", 0);
    }

    public final void invoke(boolean r3) {
        WindowHeaderFollowAboutPresenter r0 = (WindowHeaderFollowAboutPresenter) ((CallableReference) this).receiver;
        oq3.a r1 = r0.m;
        if (r1 == null) goto L5;
        ECUrlModel r2 = r1.t;
    L6:
        r0.o0(r3, r2);
        return;
    L5:
        r2 = null;
        goto L6
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        invoke(((Boolean) r1).booleanValue());
        return Unit.INSTANCE;
    }
}
