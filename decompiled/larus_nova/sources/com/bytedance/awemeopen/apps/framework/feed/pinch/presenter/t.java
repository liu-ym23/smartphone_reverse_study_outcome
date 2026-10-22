package com.bytedance.awemeopen.apps.framework.feed.pinch.presenter;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.graphics.Rect;
import android.view.View;
import com.alibaba.gaiax.template.GXTemplateKey;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
public final class t extends AnimatorListenerAdapter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ u f195737a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ View f195738b;

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator r100) {
        Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
        u r101 = this.f195737a;
        View r102 = this.f195738b;
        r101.getClass();
        r102.getGlobalVisibleRect(new Rect());
        float r103 = r102.getTranslationX();
        float r104 = r102.getTranslationY();
        boolean r105 = false;
        if ((((r102.getLeft() + ((r102.getWidth() - r102.getPivotX()) * r102.getScaleX())) + r102.getTranslationX()) + r102.getPivotX()) >= com.bytedance.awemeopen.apps.framework.utils.d0.d(r102.getContext())) goto L5;
        r103 = com.bytedance.awemeopen.apps.framework.utils.d0.d(r102.getContext()) - ((r102.getLeft() + ((r102.getWidth() - r102.getPivotX()) * r102.getScaleX())) + r102.getPivotX());
    L9:
        if (r103 != r102.getTranslationX()) goto L11;
        boolean r106 = true;
    L12:
        if (r106 == true) goto L14;
    L17:
        u.b(r102, r103, r104);
        return;
    L14:
        if (r104 != r102.getTranslationY()) goto L16;
        r105 = true;
    L16:
        if (r105 == false) goto L17;
        return;
    L11:
        r106 = false;
        goto L12
    L5:
        float r107 = 0;
        if ((((r102.getLeft() + ((r107 - r102.getPivotX()) * r102.getScaleX())) + r102.getTranslationX()) + r102.getPivotX()) <= 0.0f) goto L9;
        r103 = 0.0f - ((r102.getLeft() + ((r107 - r102.getPivotX()) * r102.getScaleX())) + r102.getPivotX());
        goto L9
    }

    public t(u r100, View r101) {
        this.f195737a = r100;
        this.f195738b = r101;
    }
}
