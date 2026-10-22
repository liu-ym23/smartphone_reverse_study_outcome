package com.bytedance.ee.bear.widget;

import com.bytedance.ee.bear.facade.common.widget.BearLottieView;
import io.reactivex.functions.Action;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class u implements Action {
    public final /* synthetic */ AtFinderView.c a;

    public final void run() throws Exception {
        BearLottieView r0 = this.a.k;
        if (r0 != null) goto L5;
    L7:
        tt5.a.k(this.a.a, "showSearchLoading: loading view is null");
        return;
    L5:
        if (r0.getWindowToken() == null) goto L7;
        tt5.a.h(this.a.a, "run(): showSearchLoading");
        AtFinderView.c r1 = this.a;
        r1.b = System.currentTimeMillis();
        this.a.i.setVisibility(0);
        this.a.a();
        this.a.k.playAnimation();
    }

    public u(AtFinderView.c r1) {
        this.a = r1;
    }
}
