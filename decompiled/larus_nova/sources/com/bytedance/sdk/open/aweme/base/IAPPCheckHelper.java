package com.bytedance.sdk.open.aweme.base;

/* JADX INFO: loaded from: classes22.dex */
public interface IAPPCheckHelper {
    String buildComponentClassName(String r100, String r101);

    String getPackageName();

    String getRemoteAuthEntryActivity();

    boolean isAppInstalled();

    boolean isAppSupportAuthorization();

    boolean isAppSupportShare();
}
