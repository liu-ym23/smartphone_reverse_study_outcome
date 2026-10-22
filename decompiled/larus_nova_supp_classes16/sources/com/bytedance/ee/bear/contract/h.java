package com.bytedance.ee.bear.contract;

import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class h implements g {
    public static g.a a;

    public h() {
    }

    @Override // com.bytedance.ee.bear.contract.g
    public final void remove(String r3) {
        tt5.a.h("BadgeServiceImp", "remove doc feed: ");
        g.a r0 = a;
        if (r0 == null) goto L6;
        r0.remove(r3);
        return;
    }

    @Override // com.bytedance.ee.bear.contract.g
    public final void a(String r3, int r4, List<String> r5) {
        if (r5 == null) goto L4;
        tt5.a.h("BadgeServiceImp", "read badge:" + r5.toString());
    L4:
        g.a r0 = a;
        if (r0 == null) goto L8;
        r0.a(r3, r4, r5);
        return;
    }

    @Override // com.bytedance.ee.bear.contract.g
    public final void b(String r9, long r10, long r12) {
        tt5.a.h("BadgeServiceImp", "update badge: " + r10 + ", version= " + r12);
        g.a r2 = a;
        if (r2 == null) goto L6;
        r2.b(r9, r10, r12);
        return;
    }
}
