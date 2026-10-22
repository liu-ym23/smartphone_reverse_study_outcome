package com.larus.dora.impl.core;

import com.bytedance.dora.device.DoraDevice;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Job;

/* JADX INFO: loaded from: classes27.dex */
public final class v0 extends com.larus.dora.impl.util.t0 {
    public v0() {
    }

    @Override // com.larus.dora.impl.util.t0, com.bytedance.dora.link.IDoraLinkCallback
    public final void onDoraLinkStateChanged(DoraDevice r100, int r101, int r102) {
        g49.d.d("DoraSyncManager", "onDoraLinkStateChanged: " + ThreadMethodProxy.currentThread());
        if (r100 != null) goto L5;
        return;
    L5:
        String r103 = "";
        if (r102 == 0) goto L14;
        if (r102 != 2) goto L24;
        CoroutineScope r104 = DoraSyncManager.f332165a;
        String r105 = r100.getSerialNumber();
        if (r105 == null) goto L13;
        r103 = r105;
    L13:
        DoraSyncManager.b(r103, 1, "5");
        DoraSyncManager.a();
        return;
    L24:
        return;
    L14:
        Job r106 = DoraSyncManager.f332166b;
        if (r106 == null) goto L17;
        Job.DefaultImpls.cancel$default(r106, null, 1, null);
    L17:
        DoraSyncManager.f332166b = null;
        DoraSyncManager.f332168d.set(false);
        String r107 = r100.getSerialNumber();
        if (r107 == null) goto L21;
        r103 = r107;
    L21:
        DoraSyncManager.b(r103, 2, "6");
    }
}
