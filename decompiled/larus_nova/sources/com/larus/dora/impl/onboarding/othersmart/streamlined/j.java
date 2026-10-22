package com.larus.dora.impl.onboarding.othersmart.streamlined;

import android.transition.Transition;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes27.dex */
public final class j implements Transition.TransitionListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ DoraHStreamlinedInterruptFragment f337274a;

    @Override // android.transition.Transition.TransitionListener
    public final void onTransitionPause(Transition r100) {
        Intrinsics.checkNotNullParameter(r100, "transition");
    }

    @Override // android.transition.Transition.TransitionListener
    public final void onTransitionResume(Transition r100) {
        Intrinsics.checkNotNullParameter(r100, "transition");
    }

    @Override // android.transition.Transition.TransitionListener
    public final void onTransitionStart(Transition r100) {
        Intrinsics.checkNotNullParameter(r100, "transition");
    }

    public j(DoraHStreamlinedInterruptFragment r100) {
        this.f337274a = r100;
    }

    @Override // android.transition.Transition.TransitionListener
    public final void onTransitionCancel(Transition r100) {
        Intrinsics.checkNotNullParameter(r100, "transition");
        r100.removeListener(this);
        DoraHStreamlinedInterruptFragment r101 = this.f337274a;
        float r102 = DoraHStreamlinedInterruptFragment.f337187z;
        r101.ia0();
    }

    @Override // android.transition.Transition.TransitionListener
    public final void onTransitionEnd(Transition r100) {
        Intrinsics.checkNotNullParameter(r100, "transition");
        r100.removeListener(this);
        DoraHStreamlinedInterruptFragment r101 = this.f337274a;
        float r102 = DoraHStreamlinedInterruptFragment.f337187z;
        r101.ia0();
    }
}
