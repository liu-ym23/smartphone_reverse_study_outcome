package com.bytedance.fresco.cloudcontrol;

import android.content.Context;

/* JADX INFO: loaded from: classes19.dex */
public final class InitConfig {
    public static final int BOE = 4;
    public static final int CHINA = 1;
    public static final int SINGAPORE = 2;
    public static final int US_EAST = 3;
    final String aid;
    final String appName;
    final String channel;
    final Context context;
    final String deviceId;
    private boolean enableAddRequestHeader;
    final int uriConfig;
    final String versionCode;
    final String versionName;

    public String getAid() {
        return this.aid;
    }

    public String getAppName() {
        return this.appName;
    }

    public String getChannel() {
        return this.channel;
    }

    public Context getContext() {
        return this.context;
    }

    public String getDeviceId() {
        return this.deviceId;
    }

    public int getUriConfig() {
        return this.uriConfig;
    }

    public String getVersionCode() {
        return this.versionCode;
    }

    public String getVersionName() {
        return this.versionName;
    }

    public boolean isEnableAddRequestHeader() {
        return this.enableAddRequestHeader;
    }

    public InitConfig(Context r110, String r111, String r112, String r113, String r114, String r115, String r116, int r117) {
        this(r110, r111, r112, r113, r114, r115, r116, r117, false);
    }

    public InitConfig(Context r100, String r101, String r102, String r103, String r104, String r105, String r106, int r107, boolean r108) {
        this.context = r100;
        this.aid = r101;
        this.appName = r102;
        this.channel = r103;
        this.versionName = r104;
        this.versionCode = r105;
        this.deviceId = r106;
        this.uriConfig = r107;
        this.enableAddRequestHeader = r108;
    }
}
