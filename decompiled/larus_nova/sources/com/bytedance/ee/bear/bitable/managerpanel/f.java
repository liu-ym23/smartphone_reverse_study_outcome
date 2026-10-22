package com.bytedance.ee.bear.bitable.managerpanel;

import android.view.View;

/* JADX INFO: loaded from: classes15.dex */
public final class f implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ BitableManagerPanelFragment f214668a;

    public f(BitableManagerPanelFragment r100) {
        this.f214668a = r100;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        BitableManagerPanelFragment r101 = this.f214668a;
        int r102 = BitableManagerPanelFragment.O;
        r101.ya0().getOperationCallBack();
    }
}
