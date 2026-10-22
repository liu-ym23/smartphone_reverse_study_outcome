package com.bytedance.ee.bear.drive.view.preview.wps;

import com.bytedance.ee.bear.drive.loader.download.platform.api.BasePuller;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public class WpsHeadIframeUriPuller$Result extends BasePuller.Result {
    public transient int code;
    public transient String msg;

    public String toString() {
        return "Result{code=" + this.code + ", msg='" + this.msg + "'}";
    }

    public WpsHeadIframeUriPuller$Result() {
        this.code = 0;
        this.msg = "";
    }
}
