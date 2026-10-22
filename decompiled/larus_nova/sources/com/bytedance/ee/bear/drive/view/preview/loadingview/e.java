package com.bytedance.ee.bear.drive.view.preview.loadingview;

import io.reactivex.functions.Action;

/* JADX INFO: loaded from: classes16.dex */
public final class e implements Action {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ LoadingAnimView f225064a;

    @Override // io.reactivex.functions.Action
    public final void run() throws Exception {
        this.f225064a.setVisibility(0);
        this.f225064a.f225050c.playAnimation();
    }

    public e(LoadingAnimView r100) {
        this.f225064a = r100;
    }
}
