package com.ss.android.lark.integrator.im.chat.core.dependency;

import com.ss.android.lark.rustinfrabridge.netstate.api.WSConnState$ConnState;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: classes36.dex */
public final class y implements h3c.a {
    public y() {
    }

    @Override // h3c.a
    public final void a(WSConnState$ConnState r100) {
        Iterator r101 = ((CopyOnWriteArrayList) z.f427929a).iterator();
    L4:
        if (r101.hasNext() == false) goto L12;
        aqb.d r102 = (aqb.d) r101.next();
        if (r100 != null) goto L8;
    L10:
        boolean r103 = false;
    L11:
        r102.a(r103);
        goto L4
    L8:
        if (r100 != WSConnState$ConnState.Connected) goto L10;
        r103 = true;
        goto L11
    }
}
