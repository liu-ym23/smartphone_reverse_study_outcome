package com.ss.android.lark.chat.chatwindow.chat.v2.component.message.swipe;

import android.animation.ValueAnimator;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
public final class l implements ValueAnimator.AnimatorUpdateListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ SwipeActionItemDecoration f414244a;

    public l(SwipeActionItemDecoration r100) {
        this.f414244a = r100;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator r100) {
        Intrinsics.checkNotNullParameter(r100, "it");
        this.f414244a.i();
    }
}
