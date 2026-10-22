package com.ss.cast.discovery.ssdp;

import com.byted.cast.common.ContextManager;
import com.byted.cast.linkcommon.cybergarage.http.HTTP;

/* JADX INFO: loaded from: classes40.dex */
public final class g extends e {
    public g(ContextManager.CastContext r100) {
        super(r100);
        setMethod(HTTP.M_SEARCH);
        setURI("*");
        setHeader(HTTP.MAN, "\"ssdp:discover\"");
    }
}
