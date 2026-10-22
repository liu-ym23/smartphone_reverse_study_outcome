package com.bytedance.common.push.interfaze;

/* JADX INFO: loaded from: classes15.dex */
public interface RequestResultCallback {
    void onRequestResult(boolean r100, String r101);

    void onUserAgree(boolean r100);

    void onUserReject();
}
