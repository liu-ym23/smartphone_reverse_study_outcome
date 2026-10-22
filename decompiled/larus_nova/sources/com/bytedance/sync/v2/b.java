package com.bytedance.sync.v2;

import com.bytedance.common.wschannel.model.WsChannelMsg;
import hg7.j;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public final class b implements hg7.f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<j> f270391a;

    public b() {
        this.f270391a = new ArrayList();
    }

    @Override // hg7.f
    public final void a0(WsChannelMsg r100) {
        Iterator r101 = ((ArrayList) this.f270391a).iterator();
    L4:
        if (r101.hasNext() == false) goto L8;
        j r102 = (j) r101.next();
        if (r102 == null) goto L4;
        r102.z0();
        goto L4
    }

    @Override // hg7.f
    public final void c0(j r100) {
        if (r100 == null) goto L5;
        ((ArrayList) this.f270391a).add(r100);
        return;
    }
}
