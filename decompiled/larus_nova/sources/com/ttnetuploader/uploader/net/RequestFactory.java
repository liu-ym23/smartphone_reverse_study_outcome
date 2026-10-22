package com.ttnetuploader.uploader.net;

import android.content.Context;
import com.ttnetuploader.uploader.net.okhttp.OkhttpRequest;
import com.ttnetuploader.uploader.net.ttnet.TTNetRequest;

/* JADX INFO: loaded from: classes41.dex */
public class RequestFactory {
    public RequestFactory() {
    }

    public static INetRequest getRequest(int r100, Context r101) {
        if (r100 != 1) goto L7;
        return new OkhttpRequest(r101);
    L7:
        return new TTNetRequest();
    }
}
