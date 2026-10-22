package com.bytedance.ee.bear.drive.biz.preview.screen;

import android.view.ViewTreeObserver;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class l implements ViewTreeObserver.OnPreDrawListener {
    public final /* synthetic */ k a;

    @Override // android.view.ViewTreeObserver.OnPreDrawListener
    public final boolean onPreDraw() {
        ViewTreeObserver r0 = this.a.d.getViewTreeObserver();
        if (r0.isAlive() == false) goto L5;
        r0.removeOnPreDrawListener(this);
    L5:
        tt5.a.h("DriveFullScreenManager", "exit preview presentation layout stable, run callback");
        c r1 = this.a.s;
        Runnable r2 = r1.a;
        r1.a = null;
        if (r2 == null) goto L10;
        r2.run();
        return true;
    L10:
        return true;
    }

    public l(k r1) {
        this.a = r1;
    }
}
