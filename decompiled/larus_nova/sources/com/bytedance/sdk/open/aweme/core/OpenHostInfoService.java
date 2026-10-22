package com.bytedance.sdk.open.aweme.core;

import android.util.SparseArray;

/* JADX INFO: loaded from: classes22.dex */
public interface OpenHostInfoService extends IOpenService {
    SparseArray<String> extraInfo();

    String getAppId();

    String getAppName();

    String getChannel();

    String getDeviceId();

    String getInstallId();

    String getUpdateVersionCode();

    String getVersionCode();

    String getVersionName();
}
