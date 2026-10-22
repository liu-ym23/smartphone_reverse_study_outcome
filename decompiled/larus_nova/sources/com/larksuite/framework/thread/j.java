package com.larksuite.framework.thread;

import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes24.dex */
public final class j extends g {
    public j(String r100, n r101) {
        super(r100, 1, r101);
        setKeepAliveTime(10, TimeUnit.SECONDS);
        allowCoreThreadTimeOut(true);
        this.f285752b = 5000;
    }
}
