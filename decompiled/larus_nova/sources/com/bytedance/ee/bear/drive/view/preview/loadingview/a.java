package com.bytedance.ee.bear.drive.view.preview.loadingview;

import io.reactivex.functions.Action;

/* JADX INFO: loaded from: classes16.dex */
public final class a implements Action {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ BlockLoadingView f225060a;

    @Override // io.reactivex.functions.Action
    public final void run() throws Exception {
        this.f225060a.setVisibility(0);
    }

    public a(BlockLoadingView r100) {
        this.f225060a = r100;
    }
}
