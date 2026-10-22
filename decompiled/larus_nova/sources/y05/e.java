package y05;

import com.bytedance.ee.bear.contract.m;
import vv4.k;

/* JADX INFO: loaded from: classes16.dex */
public final class e extends vv4.a {
    public e() {
    }

    @Override // vv4.a
    public final void onAttachToWeb(k r100) {
        super.onAttachToWeb(r100);
        bindBridgeHandlerAutoUnbind("biz.util.fetchDomainConfig", new d((s45.c) org.koin.java.a.a(s45.c.class), (m) org.koin.java.a.a(m.class)));
    }
}
