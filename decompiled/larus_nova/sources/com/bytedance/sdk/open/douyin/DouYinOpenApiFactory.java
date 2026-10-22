package com.bytedance.sdk.open.douyin;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import com.bytedance.sdk.open.aweme.core.OpenEventService;
import com.bytedance.sdk.open.aweme.core.OpenHostInfoService;
import com.bytedance.sdk.open.aweme.core.OpenImageService;
import com.bytedance.sdk.open.aweme.core.OpenNetworkService;
import com.bytedance.sdk.open.aweme.core.OpenSdkTicketService;
import com.bytedance.sdk.open.aweme.core.OpenServiceManager;
import com.bytedance.sdk.open.aweme.init.DouYinSdkContext;
import com.bytedance.sdk.open.aweme.utils.LogUtils;
import com.bytedance.sdk.open.douyin.api.DouYinOpenApi;
import com.bytedance.sdk.open.douyin.api.IOpenConfig;
import com.bytedance.sdk.open.douyin.impl.f;
import com.bytedance.sdk.open.douyin.settings.OpenSettings;
import com.bytedance.sdk.open.douyin.settings.OpenSettingsManager;

/* JADX INFO: loaded from: classes22.dex */
public class DouYinOpenApiFactory extends a {
    private static final String TAG = "DouYinOpenApiFactory";
    private static IOpenConfig sOpenConfig;

    public DouYinOpenApiFactory() {
    }

    public static DouYinOpenApi createDouYinLite(Activity r100, DouYinOpenConfig r101) {
        if (r100 == null) goto L8;
        if (r101 != null) goto L5;
        return null;
    L5:
        if (TextUtils.isEmpty(r101.clientKey) == true) goto L11;
        DouYinSdkContext.inst().setClientKey(r101.clientKey);
        DouYinSdkContext.inst().setContext(r100);
        return new f(r100, r101.clientKey);
    L11:
        return null;
    L8:
        return null;
    }

    public static void enableDefaultTicketGuard() {
        com.bytedance.sdk.open.douyin.impl.b.a();
    }

    public static void initConfig(Context r100, IOpenConfig r101) {
        if (r101 == null) goto L27;
        if (r100 == null) goto L29;
        sOpenConfig = r101;
        DouYinSdkContext.inst().setContext(r100.getApplicationContext());
        if (sOpenConfig.getHostInfo() == null) goto L26;
        OpenServiceManager.getInst().registerService(OpenHostInfoService.class, sOpenConfig.getHostInfo());
        if (sOpenConfig.getNetWork() == null) goto L24;
        OpenServiceManager.getInst().registerService(OpenNetworkService.class, sOpenConfig.getNetWork());
        if (sOpenConfig.getEventService() == null) goto L13;
        OpenServiceManager.getInst().registerService(OpenEventService.class, sOpenConfig.getEventService());
    L13:
        if (sOpenConfig.getImageService() == null) goto L15;
        OpenServiceManager.getInst().registerService(OpenImageService.class, sOpenConfig.getImageService());
    L15:
        OpenSettings.get().updateSettings(true, "initConfig");
        if (OpenSettingsManager.inst().getSDKConfig().initTicketSDK != 1) goto L28;
        LogUtils.i(TAG, new Object[]{"initTicketSDK"});
        com.bytedance.sdk.open.douyin.impl.b.b();
        OpenSdkTicketService r102 = (OpenSdkTicketService) OpenServiceManager.getInst().getService(OpenSdkTicketService.class);
        if (r102 != null) goto L21;
        LogUtils.e(TAG, new Object[]{"please implement OpenTicketService"});
        return;
    L21:
        r102.initTicketGuard(r100);
        return;
    L28:
        return;
    L24:
        throw new RuntimeException("please implement OpenNetworkService interface");
    L26:
        throw new RuntimeException("please implement OpenHostInfoService interface");
    L29:
        return;
    }
}
