package com.bytedance.ee.bear.lark.dependency;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import com.ss.android.lark.integrator.ccm.dependency.di.c2;
import com.ss.android.lark.integrator.ccm.dependency.di.u0;
import com.ss.android.lark.maincore.TabType;
import com.ss.android.lark.watermark.dto.WatermarkInfo;

/* JADX INFO: loaded from: classes16.dex */
public interface g {
    void A0();

    void B0();

    boolean C0();

    void D0();

    void E0();

    void F0();

    void G0();

    void H0();

    void I0();

    void J0(Context r100, int[] r101, p0 r102);

    void K0();

    void L0();

    void M0();

    boolean N0();

    String O0();

    void P0();

    void Q0();

    void R0();

    void S0();

    void T0();

    void U0(c2 r100);

    void V0();

    void W0();

    void a();

    void d();

    String decodeQRCode(String r100);

    Bitmap e(String r100, int r101, int r102);

    void getLarkHttpClient();

    void getNtpTime();

    u0 getSearchLifecycleObserver();

    TabType getTabType();

    Activity getTopActivity();

    void openUrl(Context r100, String r101);

    WatermarkInfo z0(Context r100);
}
