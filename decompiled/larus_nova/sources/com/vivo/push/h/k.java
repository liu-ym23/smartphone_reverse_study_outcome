package com.vivo.push.h;

/* JADX INFO: loaded from: classes41.dex */
final class k extends ab {
    public k(com.vivo.push.v r100) {
        super(r100);
    }

    @Override // com.vivo.push.s
    public final void a(com.vivo.push.v r100) {
        com.vivo.push.util.t.d("OnClearCacheTask", "delete push info " + this.f462510a.getPackageName());
        com.vivo.push.util.af.b(this.f462510a).a();
    }
}
