package com.bytedance.android.shopping.new_cart.slice.widgets;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
import com.bytedance.android.ecom.arch.slice.action.SlcCommonAction;
import com.bytedance.android.ecom.arch.slice.render.elements.BaseSlcViewManager;
import com.bytedance.android.ecom.arch.slice.render.util.SlcViewExtensionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class a extends AnimatorListenerAdapter {
    public final /* synthetic */ BottomButtonContainerView a;
    public final /* synthetic */ View b;
    public final /* synthetic */ String c;

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator r7) {
        Intrinsics.checkNotNullParameter(r7, "animation");
        BaseSlcViewManager r8 = SlcViewExtensionsKt.g(this.a);
        if (r8 == null) goto L6;
        r8.getTemplateContext().d(new SlcCommonAction(this.c + "Click", MapsKt.emptyMap()), this.a, r8.l(), null, null);
        return;
    }

    public a(BottomButtonContainerView r1, View r2, String r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }
}
