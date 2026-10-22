package com.bytedance.ee.bear.bitable.homepage.chart.home.fullscreen;

import android.provider.Settings;
import android.view.OrientationEventListener;
import com.bytedance.android.shopping.store.hybrid.jsbcheck.ECStoreJsbErrorCode;

/* JADX INFO: loaded from: classes15.dex */
public final class k extends OrientationEventListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ j f212576a;

    @Override // android.view.OrientationEventListener
    public final void onOrientationChanged(int r100) {
        if (r100 >= 0) goto L4;
        return;
    L4:
        if (r100 >= 360) goto L38;
        this.f212576a.getClass();
        boolean r101 = false;
        int r102 = 9;
        if (r100 > 9) goto L9;
    L21:
        r102 = 1;
    L22:
        j r103 = this.f212576a;
        if (r103.f212574c != r102) goto L25;
        return;
    L25:
        if (r102 == (-1)) goto L37;
        r103.f212574c = r102;
        tt5.a.b("ChartScreenOrientationHelper", "onOrientationChanged:" + r102);
        j r104 = this.f212576a;
        j.b r105 = r104.f212573b;
        r104.getClass();
        if (Settings.System.getInt(r104.f212572a.getContentResolver(), "accelerometer_rotation", 0) != 1) goto L32;
        r101 = true;
    L32:
        r105.a(r102, r101);
        return;
    L30:
        e = move-exception;
        tt5.a.f("ChartScreenOrientationHelper", e, false);
        goto L32
    L37:
        return;
    L9:
        if ((360 - r100) <= 9) goto L21;
        if (Math.abs(r100 - 90) > 9) goto L15;
        r102 = 8;
        goto L22
    L15:
        if (Math.abs(r100 - 180) <= 9) goto L22;
        if (Math.abs(r100 + ECStoreJsbErrorCode.PATTERN_EXCEPTION) > 9) goto L20;
        r102 = 0;
        goto L22
    L20:
        r102 = -1;
        goto L22
    }

    public k(j r100, BitableChartFullscreenActivity r101) {
        this.f212576a = r100;
        super(r101);
    }
}
