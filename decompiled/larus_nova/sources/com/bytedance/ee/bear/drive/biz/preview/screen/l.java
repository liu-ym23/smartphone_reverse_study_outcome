package com.bytedance.ee.bear.drive.biz.preview.screen;

import android.view.ViewTreeObserver;

/* JADX INFO: loaded from: classes16.dex */
public final class l implements ViewTreeObserver.OnPreDrawListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ k f223756a;

    @Override // android.view.ViewTreeObserver.OnPreDrawListener
    public final boolean onPreDraw() {
        ViewTreeObserver r100 = this.f223756a.f223733d.getViewTreeObserver();
        if (r100.isAlive() == false) goto L5;
        r100.removeOnPreDrawListener(this);
    L5:
        tt5.a.h("DriveFullScreenManager", "exit preview presentation layout stable, run callback");
        c r101 = this.f223756a.f223748s;
        Runnable r102 = r101.f223716a;
        r101.f223716a = null;
        if (r102 == null) goto L10;
        r102.run();
        return true;
    L10:
        return true;
    }

    public l(k r100) {
        this.f223756a = r100;
    }
}
