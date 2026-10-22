package com.bytedance.sdk.xbridge.cn.websocket.utils;

import com.bytedance.frameworks.baselib.network.http.cronet.websocket.IWsClient;

/* JADX INFO: loaded from: classes22.dex */
public final class b implements BdpWsClient {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final IWsClient f270275a;

    public b(IWsClient r100) {
        this.f270275a = r100;
    }

    public final boolean a(byte[] r100, int r101) {
        IWsClient r102 = this.f270275a;     // Catch: Exception -> L10
        int r103 = 1;
        if (r101 == 1) goto L8;
        r103 = 2;
        if (r101 == 2) goto L8;
        r103 = 0;
    L8:
        return r102.sendMessage(r100, r103);
    L10:
        e = move-exception;
        String r104 = e.getMessage();
        if (r104 != null) goto L15;
        r104 = "";
    L15:
        id7.c.a(r104);
        return false;
    }
}
