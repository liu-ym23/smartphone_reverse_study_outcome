package com.ss.android.cert.manager.web.jsb;

import android.app.Activity;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes34.dex */
public interface IBridgeContext {
    Activity getActivity();

    void onError(String r100, JSONObject r101);

    void onSuccess(JSONObject r100);
}
