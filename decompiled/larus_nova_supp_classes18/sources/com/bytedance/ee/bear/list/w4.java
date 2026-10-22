package com.bytedance.ee.bear.list;

import java.util.HashSet;
import java.util.Set;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class w4 {
    public static volatile w4 b;
    public Set<Integer> a;

    public static w4 a() {
        if (b != null) goto L15;
        monitor-enter(w4.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (b != null) goto L9;
        b = new w4();     // Catch: Throwable -> L11
    L9:
        monitor-exit(w4.class);     // Catch: Throwable -> L11
    L15:
        return b;
    }

    public w4() {
        HashSet r0 = new HashSet();
        this.a = r0;
        r0.add(4);
        ((HashSet) this.a).add(6);
        ((HashSet) this.a).add(Integer.valueOf(sbb.e.f.b));
        ((HashSet) this.a).add(Integer.valueOf(sbb.e.g.b));
        ((HashSet) this.a).add(Integer.valueOf(sbb.e.h.b));
        ((HashSet) this.a).add(Integer.valueOf(sbb.e.l.b));
        ((HashSet) this.a).add(Integer.valueOf(sbb.e.o.b));
        ((HashSet) this.a).add(Integer.valueOf(sbb.e.n.b));
        ((HashSet) this.a).add(Integer.valueOf(sbb.e.m.b));
        com.bytedance.ee.bear.appsetting.c r1 = com.bytedance.ee.bear.appsetting.c.a.a;
        if (r1.h("apaas.miaoda.migrate_to_ccm") == false) goto L5;
        ((HashSet) this.a).add(Integer.valueOf(sbb.e.t.b));
        ((HashSet) this.a).add(Integer.valueOf(sbb.e.u.b));
    L5:
        boolean r2 = true;
        if (((com.bytedance.ee.bear.lark.dependency.k) org.koin.java.a.a(com.bytedance.ee.bear.lark.dependency.k.class)).d() == true) goto L8;
    L9:
        ((HashSet) this.a).add(Integer.valueOf(sbb.e.i.b));
    L11:
        if ((!((com.bytedance.ee.bear.lark.dependency.b) org.koin.java.a.a(com.bytedance.ee.bear.lark.dependency.b.class)).isFeishuBrand()) == false) goto L13;
        r2 = r1.i("mindnote_enabled", false);
    L13:
        if (r2 == false) goto L15;
        ((HashSet) this.a).add(Integer.valueOf(sbb.e.k.b));
    L15:
        tt5.a.h("SpaceWhiteList", "init()...mWhiteList = " + this.a);
        return;
    L8:
        if (r1.i("ccm.spacekit.bitable.enable", true) == false) goto L11;
        goto L9
    }
}
