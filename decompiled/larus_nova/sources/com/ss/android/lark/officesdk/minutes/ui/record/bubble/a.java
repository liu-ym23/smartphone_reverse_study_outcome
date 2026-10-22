package com.ss.android.lark.officesdk.minutes.ui.record.bubble;

import android.app.Activity;
import android.view.View;
import com.ss.android.lark.officesdk.minutes.ui.record.MmUiLogScene;
import com.ttnet.org.chromium.base.BaseSwitches;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: classes37.dex */
public final class a implements View.OnAttachStateChangeListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Ref.BooleanRef f435811a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Ref.BooleanRef f435812b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Ref.ObjectRef<qub.a> f435813c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ qub.b f435814d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ Activity f435815e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final /* synthetic */ rub.a f435816f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final /* synthetic */ Ref.BooleanRef f435817g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final /* synthetic */ Ref.ObjectRef<View.OnAttachStateChangeListener> f435818h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final /* synthetic */ View f435819i;

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewAttachedToWindow(View r110) {
        Intrinsics.checkNotNullParameter(r110, BaseSwitches.V);
        int r111 = bwb.b.f21271a;
        bwb.b.g(MmUiLogScene.OVERLAY, "showBubble", "anchor attached, show pending bubble", null, 8);
        c.d(this.f435811a, this.f435812b, this.f435813c, this.f435814d, this.f435815e, this.f435816f, this.f435817g, this.f435818h, this.f435819i);
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewDetachedFromWindow(View r110) {
        Intrinsics.checkNotNullParameter(r110, BaseSwitches.V);
        int r111 = bwb.b.f21271a;
        bwb.b.g(MmUiLogScene.OVERLAY, "showBubble", "anchor detached", null, 8);
        c.a(this.f435811a, this.f435812b, this.f435813c, this.f435817g, this.f435818h, this.f435819i, "anchorDetached");
    }

    public a(Ref.BooleanRef r100, Ref.BooleanRef r101, Ref.ObjectRef<qub.a> r102, qub.b r103, Activity r104, rub.a r105, Ref.BooleanRef r106, Ref.ObjectRef<View.OnAttachStateChangeListener> r107, View r108) {
        this.f435811a = r100;
        this.f435812b = r101;
        this.f435813c = r102;
        this.f435814d = r103;
        this.f435815e = r104;
        this.f435816f = r105;
        this.f435817g = r106;
        this.f435818h = r107;
        this.f435819i = r108;
    }
}
