package com.story.ai.biz.comment.view;

import android.view.animation.Animation;
import com.larus.utils.logger.FLogger;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: classes38.dex */
public final class a0 implements Animation.AnimationListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Function0<Unit> f459955a;

    public a0(z r100) {
        this.f459955a = r100;
    }

    @Override // android.view.animation.Animation.AnimationListener
    public final void onAnimationEnd(Animation r100) {
        Function0<Unit> r101 = this.f459955a;
        if (r101 == null) goto L5;
        r101.invoke();
    L5:
        FLogger.f375446a.i("LikeBotSegment", "onAnimationEnd");
    }

    @Override // android.view.animation.Animation.AnimationListener
    public final void onAnimationRepeat(Animation r100) {
        FLogger.f375446a.i("LikeBotSegment", "onAnimationRepeat");
    }

    @Override // android.view.animation.Animation.AnimationListener
    public final void onAnimationStart(Animation r100) {
        FLogger.f375446a.i("LikeBotSegment", "onAnimationStart");
    }
}
