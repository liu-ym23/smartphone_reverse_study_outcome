package com.bytedance.android.shopping.deepfeed.utlis;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
import android.view.ViewGroup;
import com.bytedance.android.shopping.deepfeed.ui.view.DeepFeedProductSlcView;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class c extends AnimatorListenerAdapter {
    public final /* synthetic */ View a;
    public final /* synthetic */ int b;
    public final /* synthetic */ Function0 c;

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator r2) {
        Intrinsics.checkNotNullParameter(r2, "animation");
        ViewGroup.LayoutParams r3 = this.a.getLayoutParams();
        r3.height = this.b;
        this.a.setLayoutParams(r3);
        Function0 r4 = this.c;
        if (r4 == null) goto L6;
        Unit r5 = (Unit) r4.invoke();
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public c(DeepFeedProductSlcView r1, int r2, Function0 r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }
}
