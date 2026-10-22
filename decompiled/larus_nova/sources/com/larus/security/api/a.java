package com.larus.security.api;

import com.larus.home.impl.sdk.o2;
import com.larus.platform.IFlowSdkDepend;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;

/* JADX INFO: loaded from: classes4.dex */
public final /* synthetic */ class a implements dpa.h {
    public /* synthetic */ a() {
    }

    public final dpa.c a() {
        IFlowSdkDepend r100 = (IFlowSdkDepend) ServiceManager.get().getService(IFlowSdkDepend.class);
        if (r100 == null) goto L7;
        o2 r101 = r100.x0();
        if (r101 == null) goto L7;
        hr9.g r102 = r101.d4();
    L8:
        if (r102 == null) goto L30;
        dpa.c r103 = dpa.c.a();
        hr9.e r104 = r102.b();
        if (r104 == null) goto L13;
        dpa.b r105 = r103.azerothGlobalSettings;
        r105.global_function_switch = r104.a();
    L13:
        hr9.f r106 = r102.f();
        if (r106 == null) goto L16;
        dpa.i r107 = r103.testConf;
        r107.msg = r106.a();
        dpa.i r108 = r103.testConf;
        r108.version = r106.b();
    L16:
        hr9.d r109 = r102.e();
        if (r109 == null) goto L19;
        dpa.g r110 = r103.envReportSetting;
        r110.enabled = r109.e();
        dpa.g r111 = r103.envReportSetting;
        r111.version = r109.h();
        dpa.g r112 = r103.envReportSetting;
        r112.report_interval = r109.g();
        dpa.g r113 = r103.envReportSetting;
        r113.min_report_interval = r109.f();
        dpa.g r114 = r103.envReportSetting;
        r114.collect_android_id = r109.a();
        dpa.g r115 = r103.envReportSetting;
        r115.collect_iccid = r109.b();
        dpa.g r116 = r103.envReportSetting;
        r116.collect_mac = r109.d();
        dpa.g r117 = r103.envReportSetting;
        r117.collect_imei = r109.c();
    L19:
        hr9.c r118 = r102.d();
        if (r118 == null) goto L22;
        dpa.f r119 = r103.dailyReportSetting;
        r119.enabled = r118.a();
    L22:
        hr9.b r120 = r102.c();
        if (r120 == null) goto L25;
        dpa.e r121 = r103.cryptoSetting;
        r121.enabled = r120.c();
        dpa.e r122 = r103.cryptoSetting;
        r122.version = r120.d();
        dpa.e r123 = r103.cryptoSetting;
        r123.disable_android_key_store = r120.a();
        dpa.e r124 = r103.cryptoSetting;
        r124.disable_crypto = r120.b();
    L25:
        hr9.a r125 = r102.a();
        if (r125 == null) goto L29;
        dpa.a r126 = r103.aKexgSetting;
        r126.downgrade = r125.a();
    L29:
        return r103;
    L30:
        return new dpa.c();
    L7:
        r102 = null;
        goto L8
    }
}
