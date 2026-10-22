package com.ss.android.bytedcert.callback;

import android.content.Context;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes34.dex */
public interface IWebEventCallbackV2 extends IWebEventCallback {

    public interface IWebEventCompleteCallback {
        void onEventComplete(boolean r100, JSONObject r101);
    }

    void onWebEventV2(Context r100, String r101, JSONObject r102, IWebEventCompleteCallback r103);
}
