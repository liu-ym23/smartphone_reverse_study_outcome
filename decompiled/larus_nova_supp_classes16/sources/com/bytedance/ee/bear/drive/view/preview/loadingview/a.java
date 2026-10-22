package com.bytedance.ee.bear.drive.view.preview.loadingview;

import io.reactivex.functions.Action;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class a implements Action {
    public final /* synthetic */ BlockLoadingView a;

    public final void run() throws Exception {
        this.a.setVisibility(0);
    }

    public a(BlockLoadingView r1) {
        this.a = r1;
    }
}
