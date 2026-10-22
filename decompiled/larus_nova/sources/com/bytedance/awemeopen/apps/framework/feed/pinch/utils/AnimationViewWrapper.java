package com.bytedance.awemeopen.apps.framework.feed.pinch.utils;

import android.view.View;
import android.view.ViewGroup;
import com.bytedance.android.live.core.anim.LiveDegradeFpsAnimator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0010\b\u0007\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0006\u0010\u0007\u001a\u00020\bJ\u0006\u0010\t\u001a\u00020\nJ\u0006\u0010\u000b\u001a\u00020\nJ\u0006\u0010\f\u001a\u00020\nJ\u0006\u0010\r\u001a\u00020\nJ\u0006\u0010\u000e\u001a\u00020\nJ\u0006\u0010\u000f\u001a\u00020\nJ\u0006\u0010\u0010\u001a\u00020\bJ\u000e\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\bJ\u000e\u0010\u0014\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\nJ\u000e\u0010\u0016\u001a\u00020\u00122\u0006\u0010\u0017\u001a\u00020\nJ\u000e\u0010\u0018\u001a\u00020\u00122\u0006\u0010\u0019\u001a\u00020\nJ\u000e\u0010\u001a\u001a\u00020\u00122\u0006\u0010\u001b\u001a\u00020\nJ\u000e\u0010\u001c\u001a\u00020\u00122\u0006\u0010\u001d\u001a\u00020\nJ\u000e\u0010\u001e\u001a\u00020\u00122\u0006\u0010\u001f\u001a\u00020\nJ\u000e\u0010 \u001a\u00020\u00122\u0006\u0010!\u001a\u00020\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\""}, d2 = {"Lcom/bytedance/awemeopen/apps/framework/feed/pinch/utils/AnimationViewWrapper;", "", "view", "Landroid/view/View;", "(Landroid/view/View;)V", "getView", "()Landroid/view/View;", "getHeight", "", "getPivotX", "", "getPivotY", "getScaleX", "getScaleY", "getTranslationX", "getTranslationY", "getWidth", "setHeight", "", "height", "setPivotX", "pivotX", "setPivotY", "pivotY", "setScaleX", LiveDegradeFpsAnimator.SCALE_X, "setScaleY", LiveDegradeFpsAnimator.SCALE_Y, "setTranslationX", LiveDegradeFpsAnimator.TRANSLATION_X, "setTranslationY", LiveDegradeFpsAnimator.TRANSLATION_Y, "setWidth", "width", "ao_apps_framework_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class AnimationViewWrapper {
    private final View view;

    public final int getHeight() {
        return this.view.getHeight();
    }

    public final float getPivotX() {
        return this.view.getPivotX();
    }

    public final float getPivotY() {
        return this.view.getPivotY();
    }

    public final float getScaleX() {
        return this.view.getScaleX();
    }

    public final float getScaleY() {
        return this.view.getScaleY();
    }

    public final float getTranslationX() {
        return this.view.getTranslationX();
    }

    public final float getTranslationY() {
        return this.view.getTranslationY();
    }

    public final int getWidth() {
        return this.view.getWidth();
    }

    public final View getView() {
        return this.view;
    }

    public AnimationViewWrapper(View r100) {
        Intrinsics.checkNotNullParameter(r100, "view");
        this.view = r100;
    }

    public final void setHeight(int r100) {
        ViewGroup.LayoutParams r101 = this.view.getLayoutParams();
        r101.height = r100;
        this.view.setLayoutParams(r101);
    }

    public final void setPivotX(float r100) {
        this.view.setPivotX(r100);
    }

    public final void setPivotY(float r100) {
        this.view.setPivotY(r100);
    }

    public final void setScaleX(float r100) {
        this.view.setScaleX(r100);
    }

    public final void setScaleY(float r100) {
        this.view.setScaleY(r100);
    }

    public final void setTranslationX(float r100) {
        this.view.setTranslationX(r100);
    }

    public final void setTranslationY(float r100) {
        this.view.setTranslationY(r100);
    }

    public final void setWidth(int r100) {
        ViewGroup.LayoutParams r101 = this.view.getLayoutParams();
        r101.width = r100;
        this.view.setLayoutParams(r101);
    }
}
