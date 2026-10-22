package com.bytedance.kmp.ec.yata.view.render.controller.viewgroup.anim;

import android.view.View;
import android.view.ViewGroup;

/* JADX INFO: loaded from: classes19.dex */
public final class f implements ViewGroupItemAnimator.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ View f252000a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ ViewGroupItemAnimator.a f252001b;

    @Override // com.bytedance.kmp.ec.yata.view.render.controller.viewgroup.anim.ViewGroupItemAnimator.b
    public final void a() {
    }

    @Override // com.bytedance.kmp.ec.yata.view.render.controller.viewgroup.anim.ViewGroupItemAnimator.b
    public final void onAnimationRepeat() {
    }

    @Override // com.bytedance.kmp.ec.yata.view.render.controller.viewgroup.anim.ViewGroupItemAnimator.b
    public final void onAnimationStart() {
    }

    @Override // com.bytedance.kmp.ec.yata.view.render.controller.viewgroup.anim.ViewGroupItemAnimator.b
    public final void b() {
        ViewGroup.LayoutParams r100 = this.f252000a.getLayoutParams();
        r100.height = this.f252001b.f251989e;
        this.f252000a.requestLayout();
    }

    public f(View r100, ViewGroupItemAnimator.a r101) {
        this.f252000a = r100;
        this.f252001b = r101;
    }
}
