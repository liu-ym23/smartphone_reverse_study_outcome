package com.suite.lark.platform.component.widget_biz_dinghelper.helper.view;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import com.alibaba.gaiax.template.GXTemplateKey;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
public final class d extends AnimatorListenerAdapter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ TopCardContainer f460878a;

    public d(TopCardContainer r100) {
        this.f460878a = r100;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator r100) {
        Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
        TopCardContainer.a r101 = this.f460878a.getOnTopCardMoveOutListener();
        if (r101 == null) goto L6;
        r101.a();
        return;
    }
}
