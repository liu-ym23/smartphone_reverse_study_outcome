package com.bytedance.ee.bear.drive.view.preview.wps;

import android.text.TextUtils;
import com.bytedance.ee.bear.drive.loader.download.platform.api.BasePuller;
import com.google.gson.Gson;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public class WpsHeadIframeUriPuller$Params extends BasePuller.Params {
    public String iframeUrl;

    public String toString() {
        return "Params{iframeUrl='" + du5.b.f(this.iframeUrl) + "'}";
    }

    public WpsHeadIframeUriPuller$Params() {
    }

    public static WpsHeadIframeUriPuller$Params fromJson(String r3) {
        if (TextUtils.isEmpty(r3) == false) goto L10;
        return null;
    L10:
        return (WpsHeadIframeUriPuller$Params) new Gson().fromJson(r3, WpsHeadIframeUriPuller$Params.class);
    L7:
        e = move-exception;
        tt5.a.d("WpsHeadIframeUriPuller", "Params fromJson fail: " + e);
        return null;
    }
}
