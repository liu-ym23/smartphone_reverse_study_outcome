package com.bytedance.ee.bear.document.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.FrameLayout;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public class KeyboardPlaceholderView extends FrameLayout implements ocb.a {
    public static final /* synthetic */ int e = 0;
    public final String a;
    public ValueAnimator b;
    public ValueAnimator c;
    public boolean d;

    public class a extends AnimatorListenerAdapter {
        public final /* synthetic */ int a;
        public final /* synthetic */ KeyboardPlaceholderView b;

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator r3) {
            if (this.a != 1) goto L5;
            this.b.b = null;
            return;
        L5:
            this.b.c = null;
        }

        public a(KeyboardPlaceholderView r1, int r2) {
            this.b = r1;
            this.a = r2;
        }
    }

    public void setNeedRecordVisible(boolean r1) {
    }

    public final void a() {
        tt5.a.b(this.a, "ariseIfKeyboardNotShow");
        if (pcb.a.a.b((Activity) getContext()).isKeyboardShowing() == false) goto L5;
        return;
    L5:
        int r0 = getHolderHeight2();
        if (this.b == null) goto L8;
        return;
    L8:
        if (getLayoutParams().height == r0) goto L13;
        c(r0);
        return;
    }

    private int getHolderHeight() {
        return pcb.a.a.b((Activity) getContext()).getVisibleKeyboardHeight();
    }

    private int getHolderHeight2() {
        return pcb.a.a.b((Activity) getContext()).keyBoardRawHeight();
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        tt5.a.b(this.a, "onAttachedToWindow");
        pcb.a.a.b((Activity) getContext()).c(this);
        c(getHolderHeight());
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        tt5.a.b(this.a, "onDetachedFromWindow");
        pcb.a.a.b((Activity) getContext()).a(this);
    }

    public KeyboardPlaceholderView(Context r2) {
        super(r2);
        this.a = "KeyboardPlaceholder#" + Integer.toHexString(hashCode());
    }

    public final void b(int r7) {
        tt5.a.b(this.a, "handleAnimatorWithKeyboardStatus");
        if (pcb.a.a.b((Activity) getContext()).isKeyboardShowing() == false) goto L5;
        return;
    L5:
        int r0 = getHolderHeight2();
        if (r7 != 1) goto L11;
        ValueAnimator r4 = this.b;
        ValueAnimator r5 = this.c;
        if (r5 == null) goto L10;
        r5.cancel();
        this.c = null;
    L10:
        int r1 = 0;
    L15:
        if (r4 == null) goto L17;
        return;
    L17:
        if (getLayoutParams().height == r0) goto L22;
        ValueAnimator r2 = ValueAnimator.ofInt(new int[]{r1, r0}).setDuration(getResources().getInteger(2131427363));
        r2.addUpdateListener(new r45.a(this));
        r2.addListener(new a(this, r7));
        r2.start();
        return;
    L22:
        return;
    L11:
        r4 = this.c;
        ValueAnimator r6 = this.b;
        if (r6 == null) goto L14;
        r6.cancel();
        this.b = null;
    L14:
        r1 = r0;
        r0 = 0;
        goto L15
    }

    public final void c(int r4) {
        tt5.a.b(this.a, "updateHeight:" + r4);
        ViewGroup.LayoutParams r0 = getLayoutParams();
        if (r0.height == r4) goto L5;
        r0.height = r4;
        requestLayout();
    L5:
        if (r4 <= 0) goto L7;
        int r5 = 0;
    L9:
        if (getVisibility() == r5) goto L12;
        setVisibility(r5);
        return;
    L12:
        return;
    L7:
        r5 = 8;
        goto L9
    }

    @Override // android.view.View
    public void setLayoutParams(ViewGroup.LayoutParams r2) {
        r2.height = getHolderHeight();
        super.setLayoutParams(r2);
    }

    public KeyboardPlaceholderView(Context r1, AttributeSet r2) {
        super(r1, r2);
        this.a = "KeyboardPlaceholder#" + Integer.toHexString(hashCode());
    }

    public KeyboardPlaceholderView(Context r1, AttributeSet r2, int r3) {
        super(r1, r2, r3);
        this.a = "KeyboardPlaceholder#" + Integer.toHexString(hashCode());
    }

    public final void onKeyboardHeightChanged(pcb.a r2, int r3, int r4) {
        tt5.a.b(this.a, "onKeyboardHeightChanged:" + r3);
        if (this.d == true) goto L12;
        ValueAnimator r5 = this.b;
        if (r5 == null) goto L7;
        r5.cancel();
        this.b = null;
    L7:
        ValueAnimator r6 = this.c;
        if (r6 == null) goto L10;
        r6.cancel();
        this.c = null;
    L10:
        c(getHolderHeight());
        return;
    }
}
