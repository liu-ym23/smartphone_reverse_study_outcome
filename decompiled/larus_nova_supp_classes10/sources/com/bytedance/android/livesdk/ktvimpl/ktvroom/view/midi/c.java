package com.bytedance.android.livesdk.ktvimpl.ktvroom.view.midi;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class c extends AnimatorListenerAdapter {
    public final /* synthetic */ KtvComponentMidiView a;

    public c(KtvComponentMidiView r1) {
        this.a = r1;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator r2) {
        Intrinsics.checkNotNullParameter(r2, "animation");
        KtvComponentMidiView r3 = this.a;
        if (r3.i == false) goto L8;
        Animator r4 = r3.o;
        if (r4 == null) goto L9;
        r4.start();
        return;
    L9:
        return;
    }
}
