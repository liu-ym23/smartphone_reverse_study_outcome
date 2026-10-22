package com.bytedance.ee.bear.document.device;

import android.content.Context;
import android.os.Build;
import com.bytedance.ee.bear.contract.b0;
import com.bytedance.ee.bear.jsbridge.BridgeHandlerV2$CC;
import com.bytedance.ee.bear.jsbridge.auth.BridgeAuthType;
import tb5.i;
import tb5.m;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class a implements i {
    public final Context a;

    @Override // tb5.i, tb5.o
    public final /* bridge */ /* synthetic */ BridgeAuthType authType() {
        return BridgeHandlerV2$CC.$default$authType(this);
    }

    public a(Context r1) {
        this.a = r1;
    }

    @Override // tb5.i, tb5.o
    public final void handle(Object r5, m r6) {
        DeviceInfo r0 = new DeviceInfo(Build.BRAND, Build.MODEL, ((b0) org.koin.java.a.a(b0.class)).getDeviceId(), ku5.c.k(this.a));
        tt5.a.h("DeviceInfoHandler", "handle(): device = " + r0);
        r6.a(r0);
    }
}
