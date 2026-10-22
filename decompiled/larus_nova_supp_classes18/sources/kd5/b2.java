package kd5;

import android.os.Bundle;
import com.bytedance.ee.bear.list.dto.Document;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class b2 implements com.bytedance.ee.bear.contract.c0.c {
    public final /* synthetic */ com.bytedance.ee.bear.contract.j0 a;
    public final /* synthetic */ c2.a b;

    public final void a(Document r6) {
        tt5.a.h("OfflineCacheManager", "onConfirmDownload()...");
        com.bytedance.ee.bear.contract.j0 r0 = this.a;
        r0.e = r6;
        c2 r7 = this.b.c;
        boolean r2 = c2.w;
        r7.getClass();
        Document r3 = r0.e;
        if (r3 != null) goto L5;
        tt5.a.k("OfflineCacheManager", "download()...module = " + r0.c + ", document = null");
        return;
    L5:
        pw4.d r1 = new pw4.d();
        r1.a = r3.d;
        r1.b = r3.p;
        Bundle r4 = new Bundle();
        r1.c = r4;
        r4.putString("module", r0.c);
        ((com.bytedance.ee.bear.h) org.koin.java.a.a(com.bytedance.ee.bear.h.class)).j3(false, r1, new d2(r7, r0));
    }

    public final void b(Document r8) {
        tt5.a.h("OfflineCacheManager", "onWaitingWifi()...");
        r8.k0 = true;
        c2 r1 = this.b.c;
        com.bytedance.ee.bear.contract.j0 r0 = this.a;
        boolean r3 = r0.b;
        boolean r4 = r0.d;
        String r5 = r0.c;
        boolean r2 = c2.w;
        r1.h(r8, r3, r4, r5, false);
    }

    public b2(c2.a r1, com.bytedance.ee.bear.contract.j0 r2) {
        this.b = r1;
        this.a = r2;
    }
}
