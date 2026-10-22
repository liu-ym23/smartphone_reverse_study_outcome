package kd5;

import com.bytedance.ee.bear.list.dto.Document;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class f2 implements com.bytedance.ee.bear.contract.n.b {
    public final /* synthetic */ boolean a;
    public final /* synthetic */ com.bytedance.ee.bear.contract.j0 b;
    public final /* synthetic */ Document c;
    public final /* synthetic */ c2 d;

    public final void d(String r3) {
        tt5.a.h("OfflineCacheManager", "docs, preload success");
        if (this.a == false) goto L6;
        return;
    L6:
        if (this.c.k0 == false) goto L8;
        mc5.m.a(this).V9(r3);
    L8:
        c2 r4 = this.d;
        String r0 = this.c.d;
        r4.getClass();
        c2.j(r0, 7);
        this.d.s(this.c, 7);
    }

    public final void onPreloadFail(String r3) {
        tt5.a.h("OfflineCacheManager", "docs, preload failed");
        if (this.a == false) goto L5;
        return;
    L5:
        c2 r4 = this.d;
        String r0 = this.c.d;
        r4.getClass();
        c2.j(r0, 8);
        this.d.s(this.c, 8);
    }

    public final void onPreloadStart(String r8) {
        tt5.a.h("OfflineCacheManager", "docs, preload start");
        if (this.a == false) goto L5;
        return;
    L5:
        final com.bytedance.ee.bear.contract.j0 r9 = this.b;
        if (r9.f == null) goto L8;
        com.bytedance.ee.util.ui.m.a(new e2(r9));
    L8:
        c2 r1 = this.d;
        Document r2 = this.c;
        com.bytedance.ee.bear.contract.j0 r10 = this.b;
        r1.h(r2, r10.b, r10.d, r10.c, false);
        c2 r11 = this.d;
        String r0 = this.c.d;
        r11.getClass();
        c2.j(r0, 6);
        this.d.s(this.c, 6);
    }

    public f2(c2 r1, boolean r2, com.bytedance.ee.bear.contract.j0 r3, Document r4) {
        this.d = r1;
        this.a = r2;
        this.b = r3;
        this.c = r4;
    }
}
