package com.huawei.hms.framework.network.grs;

import android.content.Context;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes23.dex */
public class GrsClient {
    private static final String EMPTY_STRING = "";
    private final c grsClientGlobal;
    private int queryTimeout;

    public GrsClient(Context r100, GrsBaseInfo r101) {
        if (r100 == null) goto L8;
        if (r101 == null) goto L8;
        this.grsClientGlobal = d.a(r101, r100);
        this.queryTimeout = r101.getQueryTimeout();
        return;
    L8:
        throw new NullPointerException("invalid init params for context is null or GrsBaseInfo instance is null Object.");
    }

    public void ayncGetGrsUrl(String r100, String r101, IQueryUrlCallBack r102) {
        c r103 = this.grsClientGlobal;
        if (r103 != null) goto L6;
        r102.onCallBackFail(-8);
        return;
    L6:
        r103.a(r100, r101, r102, this.queryTimeout);
    }

    public void ayncGetGrsUrls(String r100, IQueryUrlsCallBack r101) {
        c r102 = this.grsClientGlobal;
        if (r102 != null) goto L6;
        r101.onCallBackFail(-8);
        return;
    L6:
        r102.a(r100, r101, this.queryTimeout);
    }

    public void clearSp() {
        c r100 = this.grsClientGlobal;
        if (r100 != null) goto L5;
        return;
    L5:
        r100.a();
    }

    public boolean forceExpire() {
        c r100 = this.grsClientGlobal;
        if (r100 != null) goto L7;
        return false;
    L7:
        return r100.b();
    }

    public String synGetGrsUrl(String r100, String r101) {
        c r102 = this.grsClientGlobal;
        if (r102 != null) goto L7;
        return "";
    L7:
        return r102.a(r100, r101, this.queryTimeout);
    }

    public Map<String, String> synGetGrsUrls(String r100) {
        c r101 = this.grsClientGlobal;
        if (r101 != null) goto L7;
        return new HashMap();
    L7:
        return r101.a(r100, this.queryTimeout);
    }
}
