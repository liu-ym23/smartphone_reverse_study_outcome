package com.dtf.face.network.model;

import android.text.TextUtils;

/* JADX INFO: loaded from: classes22.dex */
public class ZimResponse {
    public ZimResponse() {
    }

    public String fixParam(String r100, String r101) {
        if (TextUtils.isEmpty(r100) == true) goto L5;
    L7:
        return r100;
    L5:
        if (TextUtils.isEmpty(r101) == true) goto L7;
        return r101;
    }
}
