package com.bytedance.sdk.open.douyin;

import android.app.Activity;
import android.text.TextUtils;
import com.bytedance.sdk.open.aweme.init.DouYinOpenSDKConfig;
import com.bytedance.sdk.open.aweme.init.DouYinSdkContext;
import com.bytedance.sdk.open.aweme.utils.LogUtils;
import com.bytedance.sdk.open.douyin.api.DouYinOpenApi;

/* JADX INFO: loaded from: classes3.dex */
public abstract class a {
    private static DouYinOpenConfig sConfig;

    public a() {
    }

    public static DouYinOpenApi create(Activity r100) {
        if (sConfig == null) goto L7;
        if (r100 == null) goto L9;
        DouYinSdkContext.inst().setContext(r100);
        return new com.bytedance.sdk.open.douyin.impl.a(r100, sConfig.clientKey);
    L9:
        return null;
    L7:
        return null;
    }

    public static DouYinOpenApi create(Activity r100, DouYinOpenConfig r101) {
        if (r101 == null) goto L9;
        if (r100 != null) goto L5;
        return null;
    L5:
        if (TextUtils.isEmpty(r101.clientKey) == true) goto L7;
        DouYinSdkContext.inst().setClientKey(r101.clientKey);
    L7:
        DouYinSdkContext.inst().setContext(r100);
        return new com.bytedance.sdk.open.douyin.impl.a(r100, r101.clientKey);
    L9:
        return null;
    }

    public static DouYinOpenConfig getConfig() {
        return sConfig;
    }

    public static boolean init(DouYinOpenConfig r100) {
        if (r100 != null) goto L4;
        return false;
    L4:
        if (TextUtils.isEmpty(r100.clientKey) == true) goto L9;
        sConfig = r100;
        DouYinSdkContext.inst().setClientKey(r100.clientKey);
        return true;
    L9:
        return false;
    }

    public static void initConfig(DouYinOpenSDKConfig r100) {
        com.bytedance.sdk.open.douyin.impl.c.a(r100);
    }

    public static boolean isBoe() {
        return DouYinSdkContext.inst().isBoe();
    }

    public static boolean isPpe() {
        return DouYinSdkContext.inst().isPpe();
    }

    public static void setBoe(boolean r100) {
        DouYinSdkContext.inst().setBoe(r100);
    }

    public static void setBoeProd(String r100) {
        DouYinSdkContext.inst().setBoeProd(r100);
    }

    public static void setDebuggable(boolean r100) {
        LogUtils.sDebuggable = r100;
    }

    public static void setPpe(boolean r100) {
        DouYinSdkContext.inst().setPpe(r100);
    }

    public static void setPpeProd(String r100) {
        DouYinSdkContext.inst().setPpeProd(r100);
    }
}
