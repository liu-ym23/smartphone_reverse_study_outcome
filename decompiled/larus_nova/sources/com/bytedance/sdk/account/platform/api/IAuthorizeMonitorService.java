package com.bytedance.sdk.account.platform.api;

import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public interface IAuthorizeMonitorService extends IAuthorizeService {
    void onEvent(String r100, JSONObject r101);
}
