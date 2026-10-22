package com.bytedance.awemeopen.apps.framework.feed.pinch.presenter;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.graphics.Rect;
import android.view.View;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class t extends AnimatorListenerAdapter {
    public final /* synthetic */ u a;
    public final /* synthetic */ View b;

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator r8) {
        Intrinsics.checkNotNullParameter(r8, "animation");
        u r9 = this.a;
        View r0 = this.b;
        r9.getClass();
        r0.getGlobalVisibleRect(new Rect());
        float r10 = r0.getTranslationX();
        float r1 = r0.getTranslationY();
        boolean r4 = false;
        if ((((r0.getLeft() + ((r0.getWidth() - r0.getPivotX()) * r0.getScaleX())) + r0.getTranslationX()) + r0.getPivotX()) >= com.bytedance.awemeopen.apps.framework.utils.d0.d(r0.getContext())) goto L5;
        r10 = com.bytedance.awemeopen.apps.framework.utils.d0.d(r0.getContext()) - ((r0.getLeft() + ((r0.getWidth() - r0.getPivotX()) * r0.getScaleX())) + r0.getPivotX());
    L9:
        if (r10 != r0.getTranslationX()) goto L11;
        boolean r2 = true;
    L12:
        if (r2 == true) goto L14;
    L17:
        u.b(r0, r10, r1);
        return;
    L14:
        if (r1 != r0.getTranslationY()) goto L16;
        r4 = true;
    L16:
        if (r4 == false) goto L17;
        return;
    L11:
        r2 = false;
        goto L12
    L5:
        float r3 = 0;
        if ((((r0.getLeft() + ((r3 - r0.getPivotX()) * r0.getScaleX())) + r0.getTranslationX()) + r0.getPivotX()) <= 0.0f) goto L9;
        r10 = 0.0f - ((r0.getLeft() + ((r3 - r0.getPivotX()) * r0.getScaleX())) + r0.getPivotX());
        goto L9
    }

    public t(u r1, View r2) {
        this.a = r1;
        this.b = r2;
    }
}
