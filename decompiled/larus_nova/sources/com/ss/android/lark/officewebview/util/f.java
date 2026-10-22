package com.ss.android.lark.officewebview.util;

import android.webkit.RenderProcessGoneDetail;

/* JADX INFO: loaded from: classes37.dex */
public final class f extends RenderProcessGoneDetail {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f437543a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f437544b;

    @Override // android.webkit.RenderProcessGoneDetail
    public final boolean didCrash() {
        return this.f437543a;
    }

    @Override // android.webkit.RenderProcessGoneDetail
    public final int rendererPriorityAtExit() {
        return this.f437544b;
    }

    public f(boolean r100, int r101) {
        this.f437543a = r100;
        this.f437544b = r101;
    }
}
