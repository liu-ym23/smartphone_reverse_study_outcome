package ib5;

import com.bytedance.ee.bear.contract.NetService;
import com.bytedance.ee.bear.contract.a0;
import com.bytedance.ee.bear.contract.b0;
import com.bytedance.ee.bear.contract.config.DocDynamicConfig;
import com.bytedance.ee.bear.doc.resupdate.g;
import com.bytedance.ee.bear.drive.sdk.service.f;
import com.bytedance.ee.bear.h;
import s45.p;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final /* synthetic */ class c implements a0.a {
    public /* synthetic */ c() {
    }

    @Override // com.bytedance.ee.bear.contract.a0.a
    public final void a(DocDynamicConfig r4) {
        b0 r0 = (b0) org.koin.java.a.a(b0.class);
        r0.j(r4);
        ((NetService) org.koin.java.a.a(NetService.class)).b();
        p.a().O7(r0.o(), r0.g().b.c, r0.p());
        ((f) org.koin.java.a.a(f.class)).d0().b();
        ((g) org.koin.java.a.a(g.class)).i();
        ((h) org.koin.java.a.a(h.class)).b();
    }
}
