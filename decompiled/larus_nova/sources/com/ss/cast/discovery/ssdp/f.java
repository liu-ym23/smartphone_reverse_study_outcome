package com.ss.cast.discovery.ssdp;

import com.byted.cast.common.ContextManager;
import com.byted.cast.linkcommon.cybergarage.http.HTTPResponse;

/* JADX INFO: loaded from: classes40.dex */
public class f extends HTTPResponse {
    @Override // com.byted.cast.linkcommon.cybergarage.http.HTTPResponse
    public final String getHeader() {
        StringBuffer r100 = new StringBuffer();
        r100.append(getStatusLineString());
        r100.append(getHeaderString());
        r100.append("\r\n");
        return r100.toString();
    }

    public f(ContextManager.CastContext r100) {
        super(r100);
        setVersion("1.1");
    }
}
