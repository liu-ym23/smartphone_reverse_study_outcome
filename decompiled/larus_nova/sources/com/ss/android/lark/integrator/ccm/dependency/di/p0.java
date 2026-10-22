package com.ss.android.lark.integrator.ccm.dependency.di;

import com.ss.android.lark.rustinfrabridge.netstate.api.NetworkLevelListener;
import com.ss.android.lark.rustinfrabridge.netstate.impl.LarkNetworkLevelManager;
import java.util.List;

/* JADX INFO: loaded from: classes36.dex */
public final class p0 implements com.bytedance.ee.bear.lark.dependency.w {
    public p0() {
    }

    @Override // com.bytedance.ee.bear.lark.dependency.w
    public final void a(final com.bytedance.ee.bear.middleground.drive.rustsdk.d r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        List<h3c.a> r101 = com.ss.android.lark.rustinfrabridge.netstate.impl.d.f439712a;
        com.ss.android.lark.rustinfrabridge.netstate.impl.d r102 = com.ss.android.lark.rustinfrabridge.netstate.impl.d.b.f439716a;
        NetworkLevelListener r103 = new o0(r100);
        r102.getClass();
        Object r104 = LarkNetworkLevelManager.f439693d;
        LarkNetworkLevelManager.a.a().w0(r103);
    }
}
