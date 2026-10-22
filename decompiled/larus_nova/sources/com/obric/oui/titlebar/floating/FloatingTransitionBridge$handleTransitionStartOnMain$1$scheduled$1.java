package com.obric.oui.titlebar.floating;

import android.os.IBinder;
import android.view.SurfaceControl;
import android.view.ViewGroup;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import com.obric.oui.titlebar.OFloatingTitleBarActionHost;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: classes34.dex */
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class FloatingTransitionBridge$handleTransitionStartOnMain$1$scheduled$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ ViewGroup $decor;
    final /* synthetic */ OFloatingTitleBarActionHost $host;
    final /* synthetic */ SurfaceControl $interruptedOverlaySurface;
    final /* synthetic */ FloatingTransitionBridge.d $renderTarget;
    final /* synthetic */ com.obric.oui.titlebar.k $source;
    final /* synthetic */ SurfaceControl $sourceSurface;
    final /* synthetic */ com.obric.oui.titlebar.k $target;
    final /* synthetic */ SurfaceControl $transitionSurface;
    final /* synthetic */ FloatingTransitionBridge this$0;

    public FloatingTransitionBridge$handleTransitionStartOnMain$1$scheduled$1(SurfaceControl r100, FloatingTransitionBridge r101, SurfaceControl r102, OFloatingTitleBarActionHost r103, FloatingTransitionBridge.d r104, com.obric.oui.titlebar.k r105, com.obric.oui.titlebar.k r106, ViewGroup r107, SurfaceControl r108) {
        this.$sourceSurface = r100;
        this.this$0 = r101;
        this.$interruptedOverlaySurface = r102;
        this.$host = r103;
        this.$renderTarget = r104;
        this.$source = r105;
        this.$target = r106;
        this.$decor = r107;
        this.$transitionSurface = r108;
        super(0);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        SurfaceControl r100 = this.$sourceSurface;
        if (r100 == null) goto L9;
        FloatingTransitionBridge r101 = this.this$0;
        Map<IBinder, FloatingTransitionBridge> r102 = FloatingTransitionBridge.H;
        r101.getClass();
        r100.release();     // Catch: Throwable -> L7
        Intrinsics.stringPlus("releaseSurfaceControl done reason=", "targetFirstFrame");     // Catch: Throwable -> L7
    L7:
        th = move-exception;
        th.getMessage();
    L9:
        SurfaceControl r103 = this.$interruptedOverlaySurface;
        if (r103 == null) goto L16;
        FloatingTransitionBridge r104 = this.this$0;
        Map<IBinder, FloatingTransitionBridge> r105 = FloatingTransitionBridge.H;
        r104.getClass();
        r103.release();     // Catch: Throwable -> L14
        Intrinsics.stringPlus("releaseSurfaceControl done reason=", "interruptedTargetFirstFrame");     // Catch: Throwable -> L14
    L14:
        th = move-exception;
        th.getMessage();
    L16:
        FloatingTransitionBridge r106 = this.this$0;
        if (r106.f403557t == false) goto L19;
        r106.f403557t = false;
    L19:
        final Ref.BooleanRef r107 = new Ref.BooleanRef();
        final Ref.BooleanRef r108 = new Ref.BooleanRef();
        final FloatingTransitionBridge r110 = this.this$0;
        final ViewGroup r109 = this.$decor;
        final OFloatingTitleBarActionHost r111 = this.$host;
        final FloatingTransitionBridge.d r112 = this.$renderTarget;
        final SurfaceControl r113 = this.$transitionSurface;
        r110.f403563z = new AnonymousClass1(r108, r107, r110, r109, r111, r112, r113);
        OFloatingTitleBarActionHost r114 = this.$host;
        final FloatingTransitionBridge r115 = this.this$0;
        final FloatingTransitionBridge.d r116 = this.$renderTarget;
        r114.setFloatingTransitionDrawUpdateListener$OUI_standardRelease(new AnonymousClass2(r115, r116));
        this.$renderTarget.f403573f = true;
        int r117 = FloatingTransitionBridge.c(this.this$0, this.$source);
        com.obric.oui.titlebar.k r118 = this.$target;
        int r119 = r117 - r118.f403621a.f403656d;
        OFloatingTitleBarActionHost r120 = this.$host;
        if (FloatingTransitionBridge.c(this.this$0, this.$source) == FloatingTransitionBridge.c(this.this$0, this.$target)) goto L22;
    L25:
        boolean r121 = true;
    L26:
        Float r122 = Float.valueOf(r119);
        final FloatingTransitionBridge r123 = this.this$0;
        final FloatingTransitionBridge.d r124 = this.$renderTarget;
        final ViewGroup r125 = this.$decor;
        final OFloatingTitleBarActionHost r126 = this.$host;
        final SurfaceControl r127 = this.$transitionSurface;
        r120.a(r118, true, r121, r122, new AnonymousClass3(r107, r123, r124, r108, r125, r126, r127));
        this.this$0.f403559v = false;
        return;
    L22:
        if (r119 != this.$target.f403622b.f403661e) goto L25;
        r121 = false;
        goto L26
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.INSTANCE;
    }

    public static final void access$invoke$finishWhenReady(Ref.BooleanRef r100, Ref.BooleanRef r101, FloatingTransitionBridge r102, ViewGroup r103, OFloatingTitleBarActionHost r110, FloatingTransitionBridge.d r111, SurfaceControl r112) {
        if (r100.element == false) goto L6;
        return;
    L6:
        if (r101.element == true) goto L8;
        return;
    L8:
        if (r102.f403562y == false) goto L18;
        r100.element = true;
        r102.f403563z = null;
        if (r102.f403558u == false) goto L13;
        r102.p();
        return;
    L13:
        r102.f403563z = null;
        r102.f403562y = true;
        r102.C = false;
        r102.i();
        r102.q(r103, r110, r111, r112, true);
        return;
    }
}
