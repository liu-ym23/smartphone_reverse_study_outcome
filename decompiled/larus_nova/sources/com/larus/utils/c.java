package com.larus.utils;

import android.transition.Transition;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: classes31.dex */
public final class c implements Transition.TransitionListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Function0 f375366a;

    @Override // android.transition.Transition.TransitionListener
    public final void onTransitionCancel(Transition r100) {
    }

    @Override // android.transition.Transition.TransitionListener
    public final void onTransitionEnd(Transition r100) {
    }

    @Override // android.transition.Transition.TransitionListener
    public final void onTransitionPause(Transition r100) {
    }

    @Override // android.transition.Transition.TransitionListener
    public final void onTransitionResume(Transition r100) {
    }

    public c(Function0 r100) {
        this.f375366a = r100;
    }

    @Override // android.transition.Transition.TransitionListener
    public final void onTransitionStart(Transition r100) {
        this.f375366a.invoke();
    }
}
