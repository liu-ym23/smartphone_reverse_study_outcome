package com.bytedance.ee.bear.document.selection;

import android.animation.ValueAnimator;
import android.view.ActionMode;
import android.webkit.WebView;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class e implements ValueAnimator.AnimatorUpdateListener {
    public final /* synthetic */ d.a a;
    public final /* synthetic */ WebView b;
    public final /* synthetic */ d.b c;

    public e(d.a r1, WebView r2, v r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator r4) {
        Intrinsics.checkNotNullParameter(r4, "animation");
        d.a r0 = this.a;
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
        if (this.a.c == false) goto L17;
        d.b r5 = this.c;
        if (r5 == null) goto L18;
        e0 r6 = ((v) r5).a;
        r6.q();
        ActionMode r7 = r6.C;
        if (r7 == null) goto L19;
        r7.invalidateContentRect();
        return;
    L19:
        return;
    L18:
        return;
    }
}
