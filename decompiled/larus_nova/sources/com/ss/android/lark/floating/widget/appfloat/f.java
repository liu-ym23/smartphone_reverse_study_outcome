package com.ss.android.lark.floating.widget.appfloat;

import android.animation.Animator;
import android.view.View;
import com.alibaba.gaiax.template.GXTemplateKey;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
public final class f implements Animator.AnimatorListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ TouchUtils f421949a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ View f421950b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ boolean f421951c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ boolean f421952d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ AppFloatManager.b f421953e;

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationRepeat(Animator r100) {
        Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationCancel(Animator r100) {
        Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
        this.f421949a.c(this.f421950b, this.f421951c, this.f421952d);
        AppFloatManager.b r101 = this.f421953e;
        if (r101 == null) goto L6;
        r101.a();
        return;
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator r100) {
        Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
        this.f421949a.c(this.f421950b, this.f421951c, this.f421952d);
        AppFloatManager.b r101 = this.f421953e;
        if (r101 == null) goto L6;
        r101.a();
        return;
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationStart(Animator r100) {
        Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
        TouchUtils r101 = this.f421949a;
        r101.f421903b.f554615j = true;
        TouchUtils.a(r101, this.f421951c);
    }

    public f(TouchUtils r100, d r101, boolean r102, boolean r103, AppFloatManager.e r104) {
        this.f421949a = r100;
        this.f421950b = r101;
        this.f421951c = r102;
        this.f421952d = r103;
        this.f421953e = r104;
    }
}
