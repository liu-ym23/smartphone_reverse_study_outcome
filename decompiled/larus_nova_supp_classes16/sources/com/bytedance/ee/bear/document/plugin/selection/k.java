package com.bytedance.ee.bear.document.plugin.selection;

import android.animation.ValueAnimator;
import android.webkit.WebView;
import com.ss.android.lark.chameleonv2.container.webcontainer.view.ChameleonWebView;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class k implements ValueAnimator.AnimatorUpdateListener {
    public final /* synthetic */ j.a a;
    public final /* synthetic */ WebView b;

    public k(j.a r1, ChameleonWebView r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator r4) {
        Intrinsics.checkNotNullParameter(r4, "animation");
        j.a r0 = this.a;
        int r1 = r0.a;
        WebView r2 = this.b;
        if (r2.canScrollVertically(r0.b) == true) goto L5;
        r4.cancel();
        return;
    L5:
        if (this.a.b > 0) goto L8;
        r1 = -r1;
    L8:
        r2.scrollBy(0, r1);
        boolean r5 = this.a.c;
    }
}
