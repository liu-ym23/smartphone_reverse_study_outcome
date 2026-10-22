package com.bytedance.awemeopen.apps.framework.landscape.ui;

import android.animation.Animator;
import com.bytedance.awemeopen.bizmodels.profile.User;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class d extends com.bytedance.awemeopen.infra.base.anim.lottie.e {
    public final /* synthetic */ AvatarElement a;

    public d(AvatarElement r1) {
        this.a = r1;
    }

    public final void onAnimationEnd(Animator r4) {
        Intrinsics.checkNotNullParameter(r4, "animation");
        AvatarElement r5 = this.a;
        y24.d r0 = r5.i;
        String r6 = AvatarElement.a(r5);
        User r1 = this.a.a.f();
        int r2 = 0;
        if (r1 == null) goto L5;
        int r3 = r1.m();
    L7:
        if (r0.q2(r6, r3) == false) goto L9;
        this.a.c();
        return;
    L9:
        AvatarElement r7 = this.a;
        y24.d r8 = r7.i;
        String r9 = AvatarElement.a(r7);
        User r10 = this.a.a.f();
        if (r10 == null) goto L13;
        r2 = r10.m();
    L13:
        if (r8.y(r9, r2) == false) goto L17;
        zx3.a.c(this.a.g, 2131894274).d();
        this.a.e.setImageResource(2131231411);
        return;
    L17:
        return;
    L5:
        r3 = 0;
        goto L7
    }
}
