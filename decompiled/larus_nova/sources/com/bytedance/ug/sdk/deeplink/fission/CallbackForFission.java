package com.bytedance.ug.sdk.deeplink.fission;

import java.util.List;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes22.dex */
public interface CallbackForFission {
    String getAccessToken();

    List<String> getDefaultTokenRegex();

    String getRequestBaseUrlForFission();

    void onResultForCheckFission(boolean r100, String r101, String r102);

    void onResultForInvitationCode(boolean r100, String r101, String r102);

    boolean processCustomParameter(JSONObject r100);
}
