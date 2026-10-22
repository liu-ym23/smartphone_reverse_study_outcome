package com.bytedance.ee.bear.bitable.core.infoarch.basemain.controller;

import android.animation.Animator;
import com.alibaba.gaiax.template.GXTemplateKey;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
public final class c extends com.bytedance.ee.bear.bitable.common.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ OfficeBaseMainCatalogDrawerController f210397a;

    public c(OfficeBaseMainCatalogDrawerController r100) {
        this.f210397a = r100;
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator r100) {
        Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
        OfficeBaseMainCatalogDrawerController r101 = this.f210397a;
        com.bytedance.ee.bear.bitable.core.infoarch.g r102 = r101.f210299b;
        if (r102.f210554b == true) goto L5;
    L7:
        this.f210397a.f210298a.f210520q.animate().setListener(null).setUpdateListener(null);
        return;
    L5:
        if (r102.f210555c == true) goto L7;
        r101.f210298a.f210520q.setHeaderVisible(true);
        this.f210397a.g(false);
        goto L7
    }
}
