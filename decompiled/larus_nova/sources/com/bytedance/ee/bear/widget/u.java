package com.bytedance.ee.bear.widget;

import com.bytedance.ee.bear.facade.common.widget.BearLottieView;
import io.reactivex.functions.Action;

/* JADX INFO: loaded from: classes18.dex */
public final class u implements Action {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ AtFinderView.c f239957a;

    @Override // io.reactivex.functions.Action
    public final void run() throws Exception {
        BearLottieView r100 = this.f239957a.f239883k;
        if (r100 != null) goto L5;
    L7:
        tt5.a.k(this.f239957a.f239873a, "showSearchLoading: loading view is null");
        return;
    L5:
        if (r100.getWindowToken() == null) goto L7;
        tt5.a.h(this.f239957a.f239873a, "run(): showSearchLoading");
        AtFinderView.c r101 = this.f239957a;
        r101.f239874b = System.currentTimeMillis();
        this.f239957a.f239881i.setVisibility(0);
        this.f239957a.a();
        this.f239957a.f239883k.playAnimation();
    }

    public u(AtFinderView.c r100) {
        this.f239957a = r100;
    }
}
