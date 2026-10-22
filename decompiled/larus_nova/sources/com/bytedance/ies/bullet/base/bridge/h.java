package com.bytedance.ies.bullet.base.bridge;

import com.bytedance.ies.xbridge.IDLXBridgeMethod;

/* JADX INFO: loaded from: classes19.dex */
public final class h extends q implements com.bytedance.sdk.xbridge.cn.protocol.h {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ IDLXBridgeMethod f246287b;

    @Override // com.bytedance.sdk.xbridge.cn.protocol.h
    public final void release() {
        if (com.bytedance.ies.bullet.service.base.h.D() == false) goto L13;
        this.f246287b.release();
        IDLXBridgeMethod r100 = this.f246287b;
        if ((r100 instanceof v56.c) == false) goto L7;
        v56.c r101 = (v56.c) r100;
    L8:
        if (r101 == null) goto L12;
        g66.c r102 = r101.f553273a;
        if (r102 == null) goto L12;
        r102.g();
    L12:
        this.f246287b.setProviderFactory(null);
        return;
    L7:
        r101 = null;
        goto L8
    L13:
        IDLXBridgeMethod r103 = this.f246287b;
        if ((r103 instanceof v56.c) == false) goto L16;
        v56.c r104 = (v56.c) r103;
    L17:
        if (r104 == null) goto L21;
        g66.c r105 = r104.f553273a;
        if (r105 == null) goto L21;
        r105.g();
    L21:
        this.f246287b.setProviderFactory(null);
        this.f246287b.release();
        return;
    L16:
        r104 = null;
        goto L17
    }

    public h(IDLXBridgeMethod r100) {
        this.f246287b = r100;
        super(r100);
    }
}
