package com.bytedance.sdk.open.douyin.impl;

import com.bytedance.sdk.open.aweme.core.OpenSdkTicketService;
import com.bytedance.sdk.open.aweme.core.OpenServiceManager;
import com.bytedance.sdk.open.aweme.init.DouYinOpenSDKConfig;
import com.bytedance.sdk.open.aweme.utils.LogUtils;
import com.bytedance.sdk.open.douyin.settings.OpenSettings;
import com.bytedance.sdk.open.douyin.settings.OpenSettingsManager;

/* JADX INFO: loaded from: classes22.dex */
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f269655a = "DouYinOpenSDKInit";

    public c() {
    }

    public static void a(DouYinOpenSDKConfig r100) {
        b.a(r100);
        OpenSettings.get().updateSettings(true, "initConfig");
        if (OpenSettingsManager.inst().getSDKConfig().initTicketSDK != 1) goto L10;
        LogUtils.i(f269655a, new Object[]{"initTicketSDK"});
        OpenSdkTicketService r101 = (OpenSdkTicketService) OpenServiceManager.getInst().getService(OpenSdkTicketService.class);
        if (r101 != null) goto L8;
        LogUtils.e(f269655a, new Object[]{"please implement OpenTicketService"});
        return;
    L8:
        r101.initTicketGuard(r100.getContext());
    L10:
        if (r100.getEnableDefaultTicketGuard().booleanValue() == false) goto L13;
        LogUtils.i(f269655a, new Object[]{"getEnableDefaultTicketGuard"});
        b.a();
        return;
    }
}
