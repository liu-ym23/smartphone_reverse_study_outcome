package com.ss.android.lark.chat.message.menu.v2;

import android.animation.ValueAnimator;
import android.view.View;
import com.alibaba.gaiax.template.GXTemplateKey;
import com.larksuite.component.universe_design.shadow.UDShadowLayout;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
public final class j implements ValueAnimator.AnimatorUpdateListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ View f415750a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ View f415751b;

    public j(UDShadowLayout r100, UDShadowLayout r101) {
        this.f415750a = r100;
        this.f415751b = r101;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator r100) {
        Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
        Float r101 = (Float) r100.getAnimatedValue();
        if (r101 == null) goto L5;
        float r102 = r101.floatValue();
    L6:
        float r103 = r102 / 1000.0f;
        this.f415750a.setAlpha(1 - r103);
        this.f415751b.setAlpha(r103);
        return;
    L5:
        r102 = 0.0f;
        goto L6
    }
}
