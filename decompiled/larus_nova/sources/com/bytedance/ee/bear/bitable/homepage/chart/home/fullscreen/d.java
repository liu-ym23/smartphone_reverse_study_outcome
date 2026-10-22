package com.bytedance.ee.bear.bitable.homepage.chart.home.fullscreen;

import android.view.View;

/* JADX INFO: loaded from: classes15.dex */
public final class d implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ BitableChartFullscreenActivity f212567a;

    public d(BitableChartFullscreenActivity r100) {
        this.f212567a = r100;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        BitableChartFullscreenActivity r101 = this.f212567a;
        int r102 = r101.C;
        if (r102 == (-1)) goto L6;
        r101.setRequestedOrientation(r102);
        return;
    }
}
