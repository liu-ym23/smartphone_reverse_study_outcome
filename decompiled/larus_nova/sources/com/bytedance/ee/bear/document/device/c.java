package com.bytedance.ee.bear.document.device;

import android.content.Context;
import android.os.Build;
import com.bytedance.ee.bear.contract.b0;
import com.bytedance.ee.bear.jsbridge.BridgeHandlerV2$CC;
import com.bytedance.ee.bear.jsbridge.auth.BridgeAuthType;
import tb5.i;
import tb5.m;

/* JADX INFO: loaded from: classes16.dex */
public final class c implements i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f219513a;

    @Override // tb5.i, tb5.o
    public final /* bridge */ /* synthetic */ BridgeAuthType authType() {
        return BridgeHandlerV2$CC.$default$authType(this);
    }

    public c(Context r100) {
        this.f219513a = r100;
    }

    @Override // tb5.i, tb5.o
    public final void handle(Object r100, m r101) {
        DeviceInfo r102 = new DeviceInfo(Build.BRAND, Build.MODEL, ((b0) org.koin.java.a.a(b0.class)).getDeviceId(), ku5.c.k(this.f219513a));
        tt5.a.h("DeviceInfoHandler", "handle(): device = " + r102);
        r101.a(r102);
    }
}
