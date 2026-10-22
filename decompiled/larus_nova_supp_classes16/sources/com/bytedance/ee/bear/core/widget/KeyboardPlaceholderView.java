package com.bytedance.ee.bear.core.widget;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import ocb.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public class KeyboardPlaceholderView extends FrameLayout implements a {
    public final String a;
    public boolean b;

    public void setNeedRecordVisible(boolean r1) {
    }

    public final void a() {
        tt5.a.b(this.a, "ariseIfKeyboardNotShow");
        if (pcb.a.a.b((Activity) getContext()).isKeyboardShowing() == false) goto L5;
        return;
    L5:
        int r0 = getHolderHeight2();
        if (getLayoutParams().height != r0) goto L8;
        return;
    L8:
        b(r0);
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
        b(getHolderHeight());
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

    public final void b(int r4) {
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
        if (this.b == true) goto L6;
        b(getHolderHeight());
        return;
    }
}
