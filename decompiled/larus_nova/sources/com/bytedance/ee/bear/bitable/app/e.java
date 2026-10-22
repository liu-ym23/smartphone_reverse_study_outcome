package com.bytedance.ee.bear.bitable.app;

import android.view.View;

/* JADX INFO: loaded from: classes15.dex */
public final class e implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ BitableAppDrawerManager f206928a;

    public e(BitableAppDrawerManager r100) {
        this.f206928a = r100;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        if (this.f206928a.f206808g == false) goto L6;
        tt5.a.h("BitableAppDrawerManager", "Overlay clicked, closing drawer");
        this.f206928a.y();
        return;
    }
}
