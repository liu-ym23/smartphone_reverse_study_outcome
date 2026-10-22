package com.bytedance.awemeopen.apps.framework.feed.ui.rightbar.avatar;

import android.animation.Animator;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class o extends com.bytedance.awemeopen.infra.base.anim.lottie.e {
    public final /* synthetic */ AvatarElementView a;

    public o(AvatarElementView r1) {
        this.a = r1;
    }

    public final void onAnimationEnd(Animator r2) {
        Intrinsics.checkNotNullParameter(r2, "animation");
        ((p) this.a.b).e.b(Unit.INSTANCE);
    }
}
