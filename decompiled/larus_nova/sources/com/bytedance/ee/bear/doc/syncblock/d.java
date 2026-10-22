package com.bytedance.ee.bear.doc.syncblock;

import android.view.View;
import com.bytedance.ee.bear.document.loading.LoadingLayout;

/* JADX INFO: loaded from: classes16.dex */
public final class d implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ SyncBlockLoadingLayout f218288a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f218289b;

    public d(SyncBlockLoadingLayout r100, int r101) {
        this.f218288a = r100;
        this.f218289b = r101;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        LoadingLayout.c r101 = this.f218288a.f218283a;
        if (r101 == null) goto L5;
        r101.onFailedRetry(this.f218289b);
    L5:
        this.f218288a.setOnClickListener(null);
    }
}
