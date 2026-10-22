package com.ss.cast.discovery.ssdp;

import com.byted.cast.common.ContextManager;
import com.byted.cast.linkcommon.cybergarage.http.HTTP;

/* JADX INFO: loaded from: classes40.dex */
public final class c extends e {
    public c(ContextManager.CastContext r100) {
        super(r100);
        setMethod(HTTP.NOTIFY);
        setURI("*");
    }
}
