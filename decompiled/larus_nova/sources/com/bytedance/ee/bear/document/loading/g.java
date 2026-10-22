package com.bytedance.ee.bear.document.loading;

import android.view.View;

/* JADX INFO: loaded from: classes16.dex */
public final class g implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f220218a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ LoadingLayout f220219b;

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        LoadingLayout.c r101 = this.f220219b.f220201a;
        if (r101 == null) goto L6;
        r101.onFailedRetry(this.f220218a);
        this.f220219b.setOnClickListener(null);
        return;
    }

    public g(LoadingLayout r100, int r101) {
        this.f220219b = r100;
        this.f220218a = r101;
    }
}
