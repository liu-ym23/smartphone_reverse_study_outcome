package com.ss.mediakit.net;

import android.os.Handler;

/* JADX INFO: loaded from: classes40.dex */
public class DefaultConstructor implements CreateConstructor {
    public DefaultConstructor() {
    }

    @Override // com.ss.mediakit.net.CreateConstructor
    public BaseDNS createDns(String r100, AVMDLNetClient r101, int r110, Handler r111, int r112) {
        return new HTTPDNS(r100, r101, r110, r111, r112);
    L4:
        e = move-exception;
        e.printStackTrace();
        return null;
    }
}
