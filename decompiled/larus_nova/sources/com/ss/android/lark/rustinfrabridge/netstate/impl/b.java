package com.ss.android.lark.rustinfrabridge.netstate.impl;

import com.bytedance.lark.pb.basic.v1.GetWebSocketStatusResponse;
import com.ss.android.lark.log.Log;

/* JADX INFO: loaded from: classes38.dex */
public final class b implements com.ss.android.lark.sdk.g.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ d f439710a;

    public b(d r100) {
        this.f439710a = r100;
    }

    @Override // com.ss.android.lark.sdk.g.b
    public final void a(byte[] r100) {
        this.f439710a.getClass();
        GetWebSocketStatusResponse.Status r101 = GetWebSocketStatusResponse.ADAPTER.decode(r100).status;     // Catch: Exception -> L14
        d.f439714c.execute(new c(r101));     // Catch: Exception -> L14
        int r102 = d.a.f439715a[r101.ordinal()];     // Catch: Exception -> L14
        if (r102 != 1) goto L6;
        Log.d("WschannelService", "long connection close");     // Catch: Exception -> L14
    L17:
        return;
    L6:
        if (r102 != 2) goto L8;
        Log.d("WschannelService", "long connection opening");     // Catch: Exception -> L14
        goto L17
    L8:
        if (r102 != 3) goto L17;
        Log.d("WschannelService", "long connection success");     // Catch: Exception -> L14
    L14:
        e = move-exception;
        Log.e("WschannelService", e.getMessage());
    }
}
