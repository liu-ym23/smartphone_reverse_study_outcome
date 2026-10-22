package com.bytedance.ee.bear.basesdk.apisupport;

import com.larksuite.framework.callback.IGetDataCallback;

/* JADX INFO: loaded from: classes15.dex */
public final class d implements pn4.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final n f206547a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final pn4.d f206548b;

    @Override // pn4.d
    public final void loadThumbnail(ec5.a r100) {
        tt5.a.h("Apisupport", "api call: loadThumbnail");
        ((w) this.f206547a).d();
        this.f206548b.loadThumbnail(r100);
    }

    public d(n r100, pn4.d r101) {
        this.f206547a = r100;
        this.f206548b = r101;
    }

    @Override // pn4.d
    public final void syncThumbnail(String r100, IGetDataCallback<String> r101) {
        tt5.a.h("Apisupport", "api call: syncThumbnail");
        ((w) this.f206547a).d();
        this.f206548b.syncThumbnail(r100, r101);
    }
}
