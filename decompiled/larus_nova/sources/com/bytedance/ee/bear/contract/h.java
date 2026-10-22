package com.bytedance.ee.bear.contract;

import java.util.List;

/* JADX INFO: loaded from: classes16.dex */
public final class h implements g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static g.a f217064a;

    public h() {
    }

    @Override // com.bytedance.ee.bear.contract.g
    public final void remove(String r100) {
        tt5.a.h("BadgeServiceImp", "remove doc feed: ");
        g.a r101 = f217064a;
        if (r101 == null) goto L6;
        r101.remove(r100);
        return;
    }

    @Override // com.bytedance.ee.bear.contract.g
    public final void a(String r100, int r101, List<String> r102) {
        if (r102 == null) goto L4;
        tt5.a.h("BadgeServiceImp", "read badge:" + r102.toString());
    L4:
        g.a r103 = f217064a;
        if (r103 == null) goto L8;
        r103.a(r100, r101, r102);
        return;
    }

    @Override // com.bytedance.ee.bear.contract.g
    public final void b(String r100, long r110, long r111) {
        tt5.a.h("BadgeServiceImp", "update badge: " + r110 + ", version= " + r111);
        g.a r101 = f217064a;
        if (r101 == null) goto L6;
        r101.b(r100, r110, r111);
        return;
    }
}
