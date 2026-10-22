package com.bytedance.ee.bear.widget;

import io.reactivex.functions.Action;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class v implements Action {
    public final /* synthetic */ AtFinderView.c a;

    public final void run() throws Exception {
        tt5.a.h(this.a.a, "run(): hideSearchLoading");
        this.a.i.setVisibility(8);
        this.a.k.cancelAnimation();
    }

    public v(AtFinderView.c r1) {
        this.a = r1;
    }
}
