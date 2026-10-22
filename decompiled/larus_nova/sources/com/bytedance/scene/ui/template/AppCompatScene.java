package com.bytedance.scene.ui.template;

import com.bytedance.scene.view.SlidePercentFrameLayout;
import pa7.a;

/* JADX INFO: loaded from: classes19.dex */
public abstract class AppCompatScene extends a {
    public AppCompatScene() {
        if (this.f268837w == false) goto L10;
        this.f268837w = false;
        SlidePercentFrameLayout r100 = this.f268836v;
        if (r100 == null) goto L9;
        r100.setSwipeEnabled(false);
        return;
    L9:
        return;
    }
}
