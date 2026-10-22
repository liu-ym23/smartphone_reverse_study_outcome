package com.bytedance.awemeopen.apps.framework.comment.view.commentimage;

import com.bytedance.awemeopen.infra.base.anim.lottie.AoAnimationLottieView;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class e implements com.bytedance.awemeopen.infra.base.image.a {
    public final /* synthetic */ d a;
    public final /* synthetic */ t14.a b;

    public final void onFail() {
        x54.b.d(this.a.j);
        AoAnimationLottieView r0 = this.a.i;
        if (r0 == null) goto L6;
        x54.b.a(r0);
        r0.h.cancelAnimation();
        return;
    }

    public final void onSuccess() {
        d r0 = this.a;
        if (r0.c == true) goto L5;
        return;
    L5:
        if (Intrinsics.areEqual(r0.h.getTag(2131386907), this.b) == false) goto L13;
        x54.b.a(this.a.j);
        AoAnimationLottieView r1 = this.a.i;
        if (r1 == null) goto L12;
        x54.b.a(r1);
        r1.h.cancelAnimation();
        return;
    L12:
        return;
    }

    public e(d r1, t14.a r2) {
        this.a = r1;
        this.b = r2;
    }
}
