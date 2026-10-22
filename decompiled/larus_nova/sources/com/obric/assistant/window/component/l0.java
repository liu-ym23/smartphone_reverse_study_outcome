package com.obric.assistant.window.component;

import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.api.window.animation.IWindowAnimator;
import com.obric.assistant.interaction.api.window.animation.WindowAnimationType;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes33.dex */
public final class l0 implements IWindowAnimator {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ boolean f394821a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ WindowAnimationType f394822b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ WindowDimComponent.BackgroundDimScene f394823c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ WindowDimComponent f394824d;

    @Override // com.obric.assistant.interaction.api.window.animation.IWindowAnimator
    public final void cancel() {
        FLogger.f375446a.i("WindowDimComponent", "window background dim cancel, isShow=" + this.f394821a + ", type=" + this.f394822b + ", scene=" + this.f394823c);
        WindowDimComponent r100 = this.f394824d;
        int r101 = WindowDimComponent.f394736u;
        r100.P2(false);
    }

    @Override // com.obric.assistant.interaction.api.window.animation.IWindowAnimator
    public final void start(final Function1<? super Boolean, Unit> r110) {
        Intrinsics.checkNotNullParameter(r110, "onEnd");
        FLogger.f375446a.i("WindowDimComponent", "window background dim start, isShow=" + this.f394821a + ", type=" + this.f394822b + ", scene=" + this.f394823c);
        final WindowDimComponent r100 = this.f394824d;
        final boolean r101 = this.f394821a;
        r100.f394742m = r101;
        final WindowAnimationType r102 = this.f394822b;
        if (r102 != WindowAnimationType.None) goto L6;
        r100.P2(false);
        WindowDimComponent r103 = this.f394824d;
        r103.F2(r103.m3(this.f394821a, this.f394823c));
        r110.invoke(Boolean.TRUE);
        return;
    L6:
        r100.f394746q = true;
        final WindowDimComponent.BackgroundDimScene r104 = this.f394823c;
        r100.z3(r101, r104, new k0(r101, r102, r110, r100, r104));
    }

    public l0(boolean r100, WindowAnimationType r101, WindowDimComponent.BackgroundDimScene r102, WindowDimComponent r103) {
        this.f394821a = r100;
        this.f394822b = r101;
        this.f394823c = r102;
        this.f394824d = r103;
    }
}
