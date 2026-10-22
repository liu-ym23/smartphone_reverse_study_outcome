package com.bytedance.ee.bear.core.widget;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import ocb.a;

/* JADX INFO: loaded from: classes16.dex */
public class KeyboardPlaceholderView extends FrameLayout implements a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f217261a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f217262b;

    public void setNeedRecordVisible(boolean r100) {
    }

    public final void a() {
        tt5.a.b(this.f217261a, "ariseIfKeyboardNotShow");
        if (pcb.a.AbstractC7181a.b((Activity) getContext()).isKeyboardShowing() == false) goto L5;
        return;
    L5:
        int r100 = getHolderHeight2();
        if (getLayoutParams().height != r100) goto L8;
        return;
    L8:
        b(r100);
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
        tt5.a.b(this.f217261a, "onAttachedToWindow");
        pcb.a.AbstractC7181a.b((Activity) getContext()).c(this);
        b(getHolderHeight());
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        tt5.a.b(this.f217261a, "onDetachedFromWindow");
        pcb.a.AbstractC7181a.b((Activity) getContext()).a(this);
    }

    public KeyboardPlaceholderView(Context r100) {
        super(r100);
        this.f217261a = "KeyboardPlaceholder#" + Integer.toHexString(hashCode());
    }

    public final void b(int r100) {
        tt5.a.b(this.f217261a, "updateHeight:" + r100);
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
        this.f217261a = "KeyboardPlaceholder#" + Integer.toHexString(hashCode());
    }

    public KeyboardPlaceholderView(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
        this.f217261a = "KeyboardPlaceholder#" + Integer.toHexString(hashCode());
    }

    @Override // ocb.a
    public final void onKeyboardHeightChanged(pcb.a r100, int r101, int r102) {
        tt5.a.b(this.f217261a, "onKeyboardHeightChanged:" + r101);
        if (this.f217262b == true) goto L6;
        b(getHolderHeight());
        return;
    }
}
