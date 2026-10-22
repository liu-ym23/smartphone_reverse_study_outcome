package com.bytedance.awemeopen.apps.framework.feed.pages.recommend.photo.vh;

import com.bytedance.awemeopen.infra.base.anim.lottie.AoAnimationLottieView;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import r14.y;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class f implements com.bytedance.awemeopen.infra.base.image.a {
    public final /* synthetic */ d a;
    public final /* synthetic */ y b;
    public final /* synthetic */ int c;
    public final /* synthetic */ long d;
    public final /* synthetic */ Ref.IntRef e;

    public final void onFail() {
        d.p(this.a, false, this.c, this.d, this.e.element);
        x54.b.d(this.a.j);
        AoAnimationLottieView r0 = this.a.i;
        if (r0 == null) goto L6;
        x54.b.a(r0);
        r0.h.cancelAnimation();
        return;
    }

    public final void onSuccess() {
        this.a.getClass();
        d r0 = this.a;
        if (r0.c == true) goto L5;
        return;
    L5:
        if (Intrinsics.areEqual(r0.h.getTag(2131386907), this.b) == false) goto L13;
        d.p(this.a, true, this.c, this.d, this.e.element);
        x54.b.a(this.a.j);
        AoAnimationLottieView r1 = this.a.i;
        if (r1 == null) goto L12;
        x54.b.a(r1);
        r1.h.cancelAnimation();
        return;
    L12:
        return;
    }

    public f(d r1, y r2, int r3, long r4, Ref.IntRef r6) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r6;
    }
}
