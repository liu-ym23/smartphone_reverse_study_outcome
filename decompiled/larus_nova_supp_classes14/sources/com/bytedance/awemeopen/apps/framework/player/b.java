package com.bytedance.awemeopen.apps.framework.player;

import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class b implements ViewTreeObserver.OnPreDrawListener {
    public final /* synthetic */ FullVideoView a;
    public final /* synthetic */ c64.b b;

    @Override // android.view.ViewTreeObserver.OnPreDrawListener
    public final boolean onPreDraw() {
        this.a.getVideoViewWrapper().getViewTreeObserver().removeOnPreDrawListener(this);
        ViewParent r0 = this.a.getVideoViewWrapper().getParent();
        if ((r0 instanceof ViewGroup) == false) goto L5;
        ViewGroup r1 = (ViewGroup) r0;
    L6:
        if (r1 == null) goto L8;
        int r2 = r1.getHeight();
    L9:
        int r3 = (r2 - this.b.a.getHeight()) / 2;
        double r4 = this.a.getVideoViewWrapperRL().getHeight();
        boolean r5 = com.bytedance.awemeopen.apps.framework.landscape.f.a;
        int r6 = r3 - ((int) (r4 * com.bytedance.awemeopen.apps.framework.landscape.f.e));
        FrameLayout.LayoutParams r7 = new FrameLayout.LayoutParams(this.a.getVideoView().getLayoutParams().width, this.a.getVideoView().getLayoutParams().height);
        r7.gravity = 48;
        r7.topMargin = r6;
        this.a.getForegroundImageView().setLayoutParams(r7);
        this.a.getForegroundImageView().setScaleType(this.b.b);
        RelativeLayout.LayoutParams r8 = new RelativeLayout.LayoutParams(-2, -2);
        r8.addRule(10, -1);
        r8.topMargin = r6;
        this.a.getVideoViewWrapper().setLayoutParams(r8);
        return true;
    L8:
        r2 = 0;
        goto L9
    L5:
        r1 = null;
        goto L6
    }

    public b(FullVideoView r1, c64.b r2) {
        this.a = r1;
        this.b = r2;
    }
}
