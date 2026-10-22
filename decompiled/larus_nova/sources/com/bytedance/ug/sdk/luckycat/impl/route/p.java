package com.bytedance.ug.sdk.luckycat.impl.route;

import hn7.a;

/* JADX INFO: loaded from: classes22.dex */
public final class p<T extends hn7.a> implements hn7.b<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ k f271465a;

    public p(k r100) {
        this.f271465a = r100;
    }

    @Override // hn7.b
    public final void a(hn7.a r100) {
        if (((zl7.i) r100) == null) goto L6;
        SchemaProxyPendingManager r101 = SchemaProxyPendingManager.f271436f;
        SchemaProxyPendingManager.f271434d.removeMessages(1);
        SchemaProxyPendingManager.a(r101, this.f271465a, SchemaProxyPendingReason.SDK_INIT);
        return;
    }
}
