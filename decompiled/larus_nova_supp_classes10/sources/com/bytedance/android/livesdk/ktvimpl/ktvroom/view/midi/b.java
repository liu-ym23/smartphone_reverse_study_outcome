package com.bytedance.android.livesdk.ktvimpl.ktvroom.view.midi;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class b extends AnimatorListenerAdapter {
    public final /* synthetic */ KtvComponentMidiView a;

    public b(KtvComponentMidiView r1) {
        this.a = r1;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator r2) {
        Intrinsics.checkNotNullParameter(r2, "animation");
        Animator r3 = this.a.p;
        if (r3 == null) goto L6;
        r3.start();
        return;
    }
}
