package com.bytedance.awemeopen.apps.framework.feed.ui.rightbar.collect;

import android.animation.Animator;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class f extends com.bytedance.awemeopen.infra.base.anim.lottie.e {
    public final /* synthetic */ CollectElementView a;

    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[CollectElementView.State.values().length];
            r0[CollectElementView.State.AnimToCollect.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L9:
            r0[CollectElementView.State.AnimToUnCollect.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L5:
            a = r0;
        }
    }

    public f(CollectElementView r1) {
        this.a = r1;
    }

    public final void onAnimationEnd(Animator r3) {
        Intrinsics.checkNotNullParameter(r3, "animation");
        CollectElementView r4 = this.a;
        CollectElementView.State r0 = r4.j;
        int r1 = a.a[r0.ordinal()];
        if (r1 != 1) goto L5;
        CollectElementView.State r2 = CollectElementView.State.Collect;
    L9:
        r4.j = r2;
        return;
    L5:
        if (r1 == 2) goto L7;
        r2 = this.a.j;
        goto L9
    L7:
        r2 = CollectElementView.State.UnCollect;
        goto L9
    }
}
