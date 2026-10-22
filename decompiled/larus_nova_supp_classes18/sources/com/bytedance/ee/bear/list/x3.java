package com.bytedance.ee.bear.list;

import com.bytedance.ee.bear.contract.offline.OfflineDoc;
import io.reactivex.Flowable;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class x3 {
    public static volatile x3 b;
    public final bx4.a a;

    public static x3 c() {
        if (b != null) goto L15;
        monitor-enter(x3.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (b != null) goto L9;
        b = new x3(new r4());     // Catch: Throwable -> L11
    L9:
        monitor-exit(x3.class);     // Catch: Throwable -> L11
    L15:
        return b;
    }

    public x3(r4 r1) {
        this.a = r1;
    }

    public final Flowable<OfflineDoc> a(final String r10, final int r11, final boolean r12) {
        tt5.a.h("OfflineOperationProxy", "ListDataServiceImpl.createDoc: 56 parentToken=" + yu5.c.j(r10));
        bx4.a r0 = this.a;
        if (r0 == null) goto L6;
        final r4 r3 = (r4) r0;
        r3.getClass();
        tt5.a.b("OfflineOperationWrapper", "OfflineOperationWrapper.createOfflineDoc: enter parentToken=");
        mc5.b r1 = new mc5.b();
        final long r4 = System.currentTimeMillis();
        return Flowable.just(r1).observeOn(fo5.d.b()).map(new y3(r3, r4, r12, r11, r10)).observeOn(fo5.d.d());
    L6:
        tt5.a.d("OfflineOperationProxy", "ListDataServiceImpl.createDoc: 60 mOfflineOperator is null");
        return Flowable.empty();
    }

    public final Flowable<OfflineDoc> b(final String r10, final int r11, final boolean r12) {
        tt5.a.h("OfflineOperationProxy", "ListDataServiceImpl.createWikiDoc: 56 parentToken=" + yu5.c.j(r10));
        bx4.a r0 = this.a;
        if (r0 == null) goto L6;
        final r4 r3 = (r4) r0;
        r3.getClass();
        tt5.a.b("OfflineOperationWrapper", "OfflineOperationWrapper.createOfflineWikiDoc: enter parentToken=");
        mc5.b r1 = new mc5.b();
        final long r4 = System.currentTimeMillis();
        return Flowable.just(r1).observeOn(fo5.d.b()).map(new i4(r3, r4, r12, r11, r10)).observeOn(fo5.d.d());
    L6:
        tt5.a.d("OfflineOperationProxy", "ListDataServiceImpl.createWikiDoc: 60 mOfflineOperator is null");
        return Flowable.empty();
    }
}
