package com.obric.assistant.window.component;

import android.view.ViewGroup;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.api.window.animation.IWindowAnimator;
import com.obric.assistant.interaction.api.window.animation.WindowAnimationType;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes33.dex */
public final class w implements IWindowAnimator {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ WindowAnimationType f394848a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ WindowAnimationComponent f394849b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ boolean f394850c;

    @Override // com.obric.assistant.interaction.api.window.animation.IWindowAnimator
    public final void cancel() {
        FLogger.f375446a.i("WindowAnimationComponent", "window chat root cancel " + this.f394848a);
    }

    @Override // com.obric.assistant.interaction.api.window.animation.IWindowAnimator
    public final void start(Function1<? super Boolean, Unit> r100) {
        Intrinsics.checkNotNullParameter(r100, "onEnd");
        FLogger r101 = FLogger.f375446a;
        r101.i("WindowAnimationComponent", "window chat root start " + this.f394848a);
        ViewGroup r102 = (ViewGroup) this.f394849b.f394724m.getValue();
        if (r102 != null) goto L6;
        r101.w("WindowAnimationComponent", "chatRoot is null");
        r100.invoke(Boolean.TRUE);
        return;
    L6:
        float r103 = 0.0f;
        r102.setTranslationY(0.0f);
        if (this.f394850c == false) goto L9;
        r103 = 1.0f;
    L9:
        r102.setAlpha(r103);
        r100.invoke(Boolean.TRUE);
        r101.i("WindowAnimationComponent", "window chat root start " + this.f394848a + " end");
    }

    public w(WindowAnimationType r100, WindowAnimationComponent r101, boolean r102) {
        this.f394848a = r100;
        this.f394849b = r101;
        this.f394850c = r102;
    }
}
