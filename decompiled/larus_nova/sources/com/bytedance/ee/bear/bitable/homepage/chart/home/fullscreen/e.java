package com.bytedance.ee.bear.bitable.homepage.chart.home.fullscreen;

import android.view.View;

/* JADX INFO: loaded from: classes15.dex */
public final class e implements View.OnLayoutChangeListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ BitableChartFullscreenActivity f212568a;

    public e(BitableChartFullscreenActivity r100) {
        this.f212568a = r100;
    }

    @Override // android.view.View.OnLayoutChangeListener
    public final void onLayoutChange(View r100, int r101, int r102, int r103, int r104, int r105, int r106, int r107, int r108) {
        if ((r104 - r102) == (r108 - r106)) goto L5;
    L7:
        BitableChartFullscreenActivity r109 = this.f212568a;
        int r110 = BitableChartFullscreenActivity.I;
        r109.O1();
        return;
    L5:
        if ((r103 - r101) != (r107 - r105)) goto L7;
    }
}
