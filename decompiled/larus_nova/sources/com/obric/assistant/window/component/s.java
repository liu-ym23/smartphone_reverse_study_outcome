package com.obric.assistant.window.component;

import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.api.window.animation.IWindowAnimator;
import com.obric.assistant.interaction.api.window.animation.WindowAnimationType;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes33.dex */
public final class s implements IWindowAnimator {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ WindowAnimationType f394838a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ WindowAnimationComponent f394839b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ boolean f394840c;

    @Override // com.obric.assistant.interaction.api.window.animation.IWindowAnimator
    public final void cancel() {
        FLogger.f375446a.i("WindowAnimationComponent", "window bottom blur cancel " + this.f394838a);
    }

    @Override // com.obric.assistant.interaction.api.window.animation.IWindowAnimator
    public final void start(Function1<? super Boolean, Unit> r100) {
        Intrinsics.checkNotNullParameter(r100, "onEnd");
        FLogger r101 = FLogger.f375446a;
        r101.i("WindowAnimationComponent", "window bottom blur start " + this.f394838a);
        xha.f r102 = (xha.f) this.f394839b.f394719h.getValue();
        if (r102 == null) goto L13;
        com.obric.assistant.view.n r103 = r102.FG();
        if (r103 == null) goto L13;
        if (this.f394840c == false) goto L10;
        float r104 = 1.0f;
    L11:
        r103.setBlurAlpha(r104);
        r100.invoke(Boolean.TRUE);
        return;
    L10:
        r104 = 0.0f;
    L13:
        r101.w("WindowAnimationComponent", "windowBottomBlurView is null");
        r100.invoke(Boolean.TRUE);
    }

    public s(WindowAnimationType r100, WindowAnimationComponent r101, boolean r102) {
        this.f394838a = r100;
        this.f394839b = r101;
        this.f394840c = r102;
    }
}
