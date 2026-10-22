package com.bytedance.awemeopen.apps.framework.player;

import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;

/* JADX INFO: loaded from: classes14.dex */
public final class b implements ViewTreeObserver.OnPreDrawListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ FullVideoView f197271a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ c64.b f197272b;

    @Override // android.view.ViewTreeObserver.OnPreDrawListener
    public final boolean onPreDraw() {
        this.f197271a.getVideoViewWrapper().getViewTreeObserver().removeOnPreDrawListener(this);
        ViewParent r100 = this.f197271a.getVideoViewWrapper().getParent();
        if ((r100 instanceof ViewGroup) == false) goto L5;
        ViewGroup r101 = (ViewGroup) r100;
    L6:
        if (r101 == null) goto L8;
        int r102 = r101.getHeight();
    L9:
        int r103 = (r102 - this.f197272b.f22588a.getHeight()) / 2;
        double r104 = this.f197271a.getVideoViewWrapperRL().getHeight();
        boolean r105 = com.bytedance.awemeopen.apps.framework.landscape.f.f197129a;
        int r106 = r103 - ((int) (r104 * com.bytedance.awemeopen.apps.framework.landscape.f.f197133e));
        FrameLayout.LayoutParams r107 = new FrameLayout.LayoutParams(this.f197271a.getVideoView().getLayoutParams().width, this.f197271a.getVideoView().getLayoutParams().height);
        r107.gravity = 48;
        r107.topMargin = r106;
        this.f197271a.getForegroundImageView().setLayoutParams(r107);
        this.f197271a.getForegroundImageView().setScaleType(this.f197272b.f22589b);
        RelativeLayout.LayoutParams r108 = new RelativeLayout.LayoutParams(-2, -2);
        r108.addRule(10, -1);
        r108.topMargin = r106;
        this.f197271a.getVideoViewWrapper().setLayoutParams(r108);
        return true;
    L8:
        r102 = 0;
        goto L9
    L5:
        r101 = null;
        goto L6
    }

    public b(FullVideoView r100, c64.b r101) {
        this.f197271a = r100;
        this.f197272b = r101;
    }
}
