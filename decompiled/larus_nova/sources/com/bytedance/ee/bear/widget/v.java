package com.bytedance.ee.bear.widget;

import io.reactivex.functions.Action;

/* JADX INFO: loaded from: classes18.dex */
public final class v implements Action {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ AtFinderView.c f239958a;

    @Override // io.reactivex.functions.Action
    public final void run() throws Exception {
        tt5.a.h(this.f239958a.f239873a, "run(): hideSearchLoading");
        this.f239958a.f239881i.setVisibility(8);
        this.f239958a.f239883k.cancelAnimation();
    }

    public v(AtFinderView.c r100) {
        this.f239958a = r100;
    }
}
