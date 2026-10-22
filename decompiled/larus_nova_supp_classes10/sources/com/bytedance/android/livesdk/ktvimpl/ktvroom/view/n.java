package com.bytedance.android.livesdk.ktvimpl.ktvroom.view;

import android.animation.Animator;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class n extends com.bytedance.android.live.core.utils.s {
    public final /* synthetic */ float a;
    public final /* synthetic */ j b;

    public final void onAnimationCancel(Animator r2) {
        Intrinsics.checkNotNullParameter(r2, "animation");
        Intrinsics.checkNotNullParameter(r2, "animation");
        this.b.x = false;
    }

    public final void onAnimationEnd(Animator r2) {
        Intrinsics.checkNotNullParameter(r2, "animation");
        Intrinsics.checkNotNullParameter(r2, "animation");
        this.b.x = false;
        c r3 = this.b.N;
        r3.e = this.a;
        c r4 = this.b.M;
        r4.e = this.a;
        c r5 = this.b.O;
        r5.e = this.a;
        u r6 = this.b.P;
        r6.e = this.a;
    }

    public n(float r1, j r2) {
        this.a = r1;
        this.b = r2;
    }
}
