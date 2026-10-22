package com.larus.live.impl.ttlivesdk;

import com.bytedance.android.live.saas.middleware.IAppInfo;
import com.larus.applog.api.IApplog;
import com.larus.common.apphost.AppHost;
import com.larus.network.http.HttpExtKt;

/* JADX INFO: loaded from: classes30.dex */
public final class o implements IAppInfo {
    public o() {
    }

    @Override // com.bytedance.android.live.saas.middleware.IAppInfo
    public final String apiHost() {
        return "webcast-open.douyin.com";
    }

    @Override // com.bytedance.android.live.saas.middleware.IAppInfo
    public final int appIcon() {
        return 0;
    }

    @Override // com.bytedance.android.live.saas.middleware.IAppInfo
    public final int appId() {
        return 482431;
    }

    @Override // com.bytedance.android.live.saas.middleware.IAppInfo
    public final String clientKey() {
        return "aw730v27vx2bu2qw";
    }

    @Override // com.bytedance.android.live.saas.middleware.IAppInfo
    public final int sdkVersion() {
        return 0;
    }

    @Override // com.bytedance.android.live.saas.middleware.IAppInfo
    public final String appName() {
        return AppHost.f326268a.getAppName();
    }

    @Override // com.bytedance.android.live.saas.middleware.IAppInfo
    public final String channel() {
        return AppHost.f326268a.getBuildChannel();
    }

    @Override // com.bytedance.android.live.saas.middleware.IAppInfo
    public final String devicesId() {
        return IApplog.f287053a.getDeviceId();
    }

    @Override // com.bytedance.android.live.saas.middleware.IAppInfo
    public final String hostAppId() {
        return String.valueOf(AppHost.f326268a.getAppId());
    }

    @Override // com.bytedance.android.live.saas.middleware.IAppInfo
    public final boolean isDebug() {
        return AppHost.f326268a.isDebug();
    }

    @Override // com.bytedance.android.live.saas.middleware.IAppInfo
    public final int updateVersionCode() {
        return AppHost.f326268a.getUpdateVersionCode();
    }

    @Override // com.bytedance.android.live.saas.middleware.IAppInfo
    public final int versionCode() {
        return AppHost.f326268a.getVersionCode();
    }

    @Override // com.bytedance.android.live.saas.middleware.IAppInfo
    public final String versionName() {
        return AppHost.f326268a.getVersionName();
    }

    @Override // com.bytedance.android.live.saas.middleware.IAppInfo
    public final String boeLane() {
        return HttpExtKt.e().f360167b;
    }

    @Override // com.bytedance.android.live.saas.middleware.IAppInfo
    public final boolean isBoe() {
        return HttpExtKt.e().f360166a;
    }

    @Override // com.bytedance.android.live.saas.middleware.IAppInfo
    public final boolean isPPE() {
        return HttpExtKt.e().f360168c;
    }

    @Override // com.bytedance.android.live.saas.middleware.IAppInfo
    public final String ppeLane() {
        return HttpExtKt.e().f360169d;
    }
}
