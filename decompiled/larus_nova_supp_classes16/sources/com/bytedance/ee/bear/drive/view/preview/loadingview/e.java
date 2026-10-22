package com.bytedance.ee.bear.drive.view.preview.loadingview;

import io.reactivex.functions.Action;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class e implements Action {
    public final /* synthetic */ LoadingAnimView a;

    public final void run() throws Exception {
        this.a.setVisibility(0);
        this.a.c.playAnimation();
    }

    public e(LoadingAnimView r1) {
        this.a = r1;
    }
}
