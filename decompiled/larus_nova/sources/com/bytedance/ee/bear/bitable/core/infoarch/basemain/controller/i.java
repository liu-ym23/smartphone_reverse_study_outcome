package com.bytedance.ee.bear.bitable.core.infoarch.basemain.controller;

import android.animation.Animator;
import android.view.View;
import com.alibaba.gaiax.template.GXTemplateKey;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
public final class i extends com.bytedance.ee.bear.bitable.common.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f210429a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ OfficeBaseMainHeaderScrollController f210430b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ View f210431c;

    @Override // com.bytedance.ee.bear.bitable.common.b, android.animation.Animator.AnimatorListener
    public final void onAnimationCancel(Animator r100) {
        Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
        this.f210429a = true;
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator r100) {
        Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
        if (this.f210429a == false) goto L5;
    L7:
        r100.removeListener(this);
        OfficeBaseMainHeaderScrollController r101 = this.f210430b;
        if (r101.f210325h != r100) goto L11;
        r101.f210325h = null;
        return;
    L11:
        return;
    L5:
        if (Intrinsics.areEqual(this.f210430b.f210324g, Boolean.FALSE) == false) goto L7;
        this.f210431c.setVisibility(8);
        goto L7
    }

    public i(OfficeBaseMainHeaderScrollController r100, View r101) {
        this.f210430b = r100;
        this.f210431c = r101;
    }
}
