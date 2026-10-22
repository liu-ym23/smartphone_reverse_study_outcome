package com.larus.voicecall.impl.video;

import android.animation.Animator;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: classes32.dex */
public final class z implements Animator.AnimatorListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ y f379641a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ boolean f379642b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ ViewPortContainerView f379643c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ float f379644d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ float f379645e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final /* synthetic */ float f379646f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final /* synthetic */ Function0 f379647g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final /* synthetic */ ViewPortContainerView f379648h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final /* synthetic */ float f379649i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final /* synthetic */ float f379650j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final /* synthetic */ float f379651k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final /* synthetic */ boolean f379652l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final /* synthetic */ ViewPortContainerView f379653m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final /* synthetic */ float f379654n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final /* synthetic */ float f379655o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final /* synthetic */ float f379656p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final /* synthetic */ Function0 f379657q;

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationRepeat(Animator r100) {
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationCancel(Animator r100) {
        this.f379648h.setScaleX(this.f379649i);
        this.f379648h.setScaleY(this.f379649i);
        this.f379648h.setTranslationX(this.f379650j);
        this.f379648h.setTranslationY(this.f379651k);
        this.f379641a.getClass();
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator r100) {
        this.f379641a.getClass();
        if (this.f379642b == true) goto L5;
        this.f379643c.setScaleX(this.f379644d);
        this.f379643c.setScaleY(this.f379644d);
        this.f379643c.setTranslationX(this.f379645e);
        this.f379643c.setTranslationY(this.f379646f);
    L5:
        Function0 r101 = this.f379647g;
        if (r101 == null) goto L9;
        r101.invoke();
        return;
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationStart(Animator r100) {
        this.f379641a.getClass();
        if (this.f379652l == false) goto L5;
        this.f379653m.setScaleX(this.f379654n);
        this.f379653m.setScaleY(this.f379654n);
        this.f379653m.setTranslationX(this.f379655o);
        this.f379653m.setTranslationY(this.f379656p);
    L5:
        Function0 r101 = this.f379657q;
        if (r101 == null) goto L9;
        r101.invoke();
        return;
    }

    public z(y r100, boolean r101, ViewPortContainerView r102, float r103, float r104, float r105, Function0 r106, ViewPortContainerView r110, float r111, float r112, float r113, boolean r114, ViewPortContainerView r115, float r116, float r117, float r118, Function0 r119) {
        this.f379641a = r100;
        this.f379642b = r101;
        this.f379643c = r102;
        this.f379644d = r103;
        this.f379645e = r104;
        this.f379646f = r105;
        this.f379647g = r106;
        this.f379648h = r110;
        this.f379649i = r111;
        this.f379650j = r112;
        this.f379651k = r113;
        this.f379652l = r114;
        this.f379653m = r115;
        this.f379654n = r116;
        this.f379655o = r117;
        this.f379656p = r118;
        this.f379657q = r119;
    }
}
