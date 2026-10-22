package com.bytedance.ee.larkwebview.util;

import android.webkit.RenderProcessGoneDetail;

/* JADX INFO: loaded from: classes19.dex */
public final class d extends RenderProcessGoneDetail {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f242969a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f242970b;

    @Override // android.webkit.RenderProcessGoneDetail
    public final boolean didCrash() {
        return this.f242969a;
    }

    @Override // android.webkit.RenderProcessGoneDetail
    public final int rendererPriorityAtExit() {
        return this.f242970b;
    }

    public d(boolean r100, int r101) {
        this.f242969a = r100;
        this.f242970b = r101;
    }
}
