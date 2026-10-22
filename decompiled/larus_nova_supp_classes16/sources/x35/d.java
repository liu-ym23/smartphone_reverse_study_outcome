package x35;

import vv4.k;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class d extends vv4.a {
    public d() {
    }

    @Override // vv4.a
    public final void onAttachToWeb(k r2) {
        super.onAttachToWeb(r2);
        bindBridgeHandlerAutoUnbind("biz.statistics.reportEvent", new c((com.bytedance.ee.bear.contract.d) org.koin.java.a.a(com.bytedance.ee.bear.contract.d.class)));
    }
}
