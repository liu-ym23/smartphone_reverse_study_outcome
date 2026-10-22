package com.bytedance.ee.bear.document.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.larus.nova.R;

/* JADX INFO: loaded from: classes16.dex */
public class KeyboardPlaceholderView extends FrameLayout implements ocb.a {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final /* synthetic */ int f222492e = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f222493a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ValueAnimator f222494b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public ValueAnimator f222495c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f222496d;

    public class a extends AnimatorListenerAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f222497a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ KeyboardPlaceholderView f222498b;

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator r100) {
            if (this.f222497a != 1) goto L5;
            this.f222498b.f222494b = null;
            return;
        L5:
            this.f222498b.f222495c = null;
        }

        public a(KeyboardPlaceholderView r100, int r101) {
            this.f222498b = r100;
            this.f222497a = r101;
        }
    }

    public void setNeedRecordVisible(boolean r100) {
    }

    public final void a() {
        tt5.a.b(this.f222493a, "ariseIfKeyboardNotShow");
        if (pcb.a.AbstractC7181a.b((Activity) getContext()).isKeyboardShowing() == false) goto L5;
        return;
    L5:
        int r100 = getHolderHeight2();
        if (this.f222494b == null) goto L8;
        return;
    L8:
        if (getLayoutParams().height == r100) goto L13;
        c(r100);
        return;
    }

    private int getHolderHeight() {
        return pcb.a.AbstractC7181a.b((Activity) getContext()).getVisibleKeyboardHeight();
    }

    private int getHolderHeight2() {
        return pcb.a.AbstractC7181a.b((Activity) getContext()).keyBoardRawHeight();
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        tt5.a.b(this.f222493a, "onAttachedToWindow");
        pcb.a.AbstractC7181a.b((Activity) getContext()).c(this);
        c(getHolderHeight());
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        tt5.a.b(this.f222493a, "onDetachedFromWindow");
        pcb.a.AbstractC7181a.b((Activity) getContext()).a(this);
    }

    public KeyboardPlaceholderView(Context r100) {
        super(r100);
        this.f222493a = "KeyboardPlaceholder#" + Integer.toHexString(hashCode());
    }

    public final void b(int r100) {
        tt5.a.b(this.f222493a, "handleAnimatorWithKeyboardStatus");
        if (pcb.a.AbstractC7181a.b((Activity) getContext()).isKeyboardShowing() == false) goto L5;
        return;
    L5:
        int r101 = getHolderHeight2();
        if (r100 != 1) goto L11;
        ValueAnimator r102 = this.f222494b;
        ValueAnimator r103 = this.f222495c;
        if (r103 == null) goto L10;
        r103.cancel();
        this.f222495c = null;
    L10:
        int r104 = 0;
    L15:
        if (r102 == null) goto L17;
        return;
    L17:
        if (getLayoutParams().height == r101) goto L22;
        ValueAnimator r105 = ValueAnimator.ofInt(new int[]{r104, r101}).setDuration(getResources().getInteger(R.integer.keyboard_height_duration));
        r105.addUpdateListener(new r45.a(this));
        r105.addListener(new a(this, r100));
        r105.start();
        return;
    L22:
        return;
    L11:
        r102 = this.f222495c;
        ValueAnimator r106 = this.f222494b;
        if (r106 == null) goto L14;
        r106.cancel();
        this.f222494b = null;
    L14:
        r104 = r101;
        r101 = 0;
        goto L15
    }

    public final void c(int r100) {
        tt5.a.b(this.f222493a, "updateHeight:" + r100);
        ViewGroup.LayoutParams r101 = getLayoutParams();
        if (r101.height == r100) goto L5;
        r101.height = r100;
        requestLayout();
    L5:
        if (r100 <= 0) goto L7;
        int r102 = 0;
    L9:
        if (getVisibility() == r102) goto L12;
        setVisibility(r102);
        return;
    L12:
        return;
    L7:
        r102 = 8;
        goto L9
    }

    @Override // android.view.View
    public void setLayoutParams(ViewGroup.LayoutParams r100) {
        r100.height = getHolderHeight();
        super.setLayoutParams(r100);
    }

    public KeyboardPlaceholderView(Context r100, AttributeSet r101) {
        super(r100, r101);
        this.f222493a = "KeyboardPlaceholder#" + Integer.toHexString(hashCode());
    }

    public KeyboardPlaceholderView(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
        this.f222493a = "KeyboardPlaceholder#" + Integer.toHexString(hashCode());
    }

    @Override // ocb.a
    public final void onKeyboardHeightChanged(pcb.a r100, int r101, int r102) {
        tt5.a.b(this.f222493a, "onKeyboardHeightChanged:" + r101);
        if (this.f222496d == true) goto L12;
        ValueAnimator r103 = this.f222494b;
        if (r103 == null) goto L7;
        r103.cancel();
        this.f222494b = null;
    L7:
        ValueAnimator r104 = this.f222495c;
        if (r104 == null) goto L10;
        r104.cancel();
        this.f222495c = null;
    L10:
        c(getHolderHeight());
        return;
    }
}
