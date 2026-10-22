package com.bytedance.ee.bear.bitable.load.workimpl;

import com.bytedance.ee.bear.bitable.load.BitableSceneType;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
public final class l extends com.bytedance.ee.bear.bitable.load.workimpl.a {

    public static final class a {
    }

    static {
    }

    @Override // com.bytedance.ee.bear.bitable.load.AbsLoadWork
    public final void d() {
        m();
        this.f214441b.m();
    }

    public l(com.bytedance.ee.bear.bitable.load.e r100, com.bytedance.ee.bear.bitable.load.f r101) {
        Intrinsics.checkNotNullParameter(r100, "loadContext");
        Intrinsics.checkNotNullParameter(r101, "loadControl");
        super(r100, r101);
        BitableSceneType r102 = r100.o();
        if (com.bytedance.ee.bear.bitable.c.t() == false) goto L7;
        if (r102 != BitableSceneType.ShareRecord) goto L7;
    L10:
        boolean r103 = true;
    L12:
        n(new zt4.g(r100, r101), r103);
        n(new zt4.j(r100, r101), r103);
        Iterator r104 = ((ArrayList) this.f214563f).iterator();
    L14:
        if (r104.hasNext() == false) goto L24;
        zt4.a r105 = r100.e((Class) r104.next());
        if (r105 == null) goto L14;
        if (r105.e() == true) goto L14;
        boolean r106 = r105.g();
        r105.f573584d = r106;
        if (r106 == false) goto L14;
        r105.f573583c.countDown();
        goto L14
    L24:
        o(r100);
        return;
    L7:
        if (com.bytedance.ee.bear.bitable.c.q() == true) goto L9;
    L11:
        r103 = false;
        goto L12
    L9:
        if (r102 != BitableSceneType.AddRecord) goto L11;
        goto L10
    }
}
