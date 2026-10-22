package com.ss.android.lark.inline.ai.ui;

import android.animation.ValueAnimator;
import android.view.View;
import com.ss.android.lark.log.Log;

/* JADX INFO: loaded from: classes36.dex */
public final class k implements View.OnLayoutChangeListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ InlineAIDragView f427561a;

    public k(InlineAIDragView r100) {
        this.f427561a = r100;
    }

    @Override // android.view.View.OnLayoutChangeListener
    public final void onLayoutChange(View r100, int r101, int r102, int r103, int r104, int r105, int r106, int r107, int r108) {
        if (r101 != r105) goto L6;
        if (r102 != r106) goto L6;
        if (r103 != r107) goto L6;
        if (r104 != r108) goto L6;
        return;
    L6:
        Log.i("InlineAIDragView", "panelRootView layout change");
        this.f427561a.f();
        ValueAnimator r109 = this.f427561a.f427368o;
        if (r109 != null) goto L9;
    L11:
        boolean r110 = false;
    L12:
        if (r110 == false) goto L17;
        ValueAnimator r111 = this.f427561a.f427368o;
        if (r111 == null) goto L16;
        r111.cancel();
    L16:
        this.f427561a.n(false, true, InlineAIDragView.AdjustTopSource.CONTAINER_CHANGE);
        return;
    L17:
        this.f427561a.n(false, false, InlineAIDragView.AdjustTopSource.CONTAINER_CHANGE);
        return;
    L9:
        if (r109.isRunning() != true) goto L11;
        r110 = true;
        goto L12
    }
}
