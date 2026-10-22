package com.bytedance.ee.bear.bitable.homepage.chart.home.fullscreen;

import android.view.View;

/* JADX INFO: loaded from: classes15.dex */
public final class f implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ BitableChartFullscreenActivity f212569a;

    public f(BitableChartFullscreenActivity r100) {
        this.f212569a = r100;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        this.f212569a.finish();
    }
}
