package com.larus.bmhome.chat.list.cell.spacer;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
import android.view.animation.PathInterpolator;
import com.alibaba.gaiax.template.GXTemplateKey;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: classes25.dex */
public final class h extends AnimatorListenerAdapter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f305931a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ SpacerCell f305932b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ View f305933c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ int f305934d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ Ref.BooleanRef f305935e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final /* synthetic */ boolean f305936f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final /* synthetic */ int f305937g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final /* synthetic */ Ref.IntRef f305938h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final /* synthetic */ Function0<Unit> f305939i;

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationCancel(Animator r100) {
        Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
        this.f305931a = true;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator r100) {
        Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
        if (this.f305931a == false) goto L5;
        return;
    L5:
        SpacerCell r101 = this.f305932b;
        View r102 = this.f305933c;
        int r103 = this.f305934d;
        PathInterpolator r104 = SpacerCell.f305892e;
        r101.getClass();
        SpacerCell.x(r102, r103);
        if (this.f305935e.element == true) goto L8;
    L11:
        Function0<Unit> r105 = this.f305939i;
        if (r105 == null) goto L15;
        r105.invoke();
        return;
    L15:
        return;
    L8:
        if (this.f305936f == false) goto L10;
        SpacerCell.o(this.f305932b, this.f305933c, (this.f305934d - this.f305937g) - this.f305938h.element);
        goto L11
    L10:
        this.f305932b.u(Integer.MAX_VALUE);
        goto L11
    }

    public h(SpacerCell r100, View r101, int r102, Ref.BooleanRef r103, boolean r104, int r105, Ref.IntRef r106, Function0<Unit> r107) {
        this.f305932b = r100;
        this.f305933c = r101;
        this.f305934d = r102;
        this.f305935e = r103;
        this.f305936f = r104;
        this.f305937g = r105;
        this.f305938h = r106;
        this.f305939i = r107;
    }
}
