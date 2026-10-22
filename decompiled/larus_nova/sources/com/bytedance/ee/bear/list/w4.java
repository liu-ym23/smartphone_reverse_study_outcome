package com.bytedance.ee.bear.list;

import java.util.HashSet;
import java.util.Set;

/* JADX INFO: loaded from: classes18.dex */
public final class w4 {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static volatile w4 f229841b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Set<Integer> f229842a;

    public static w4 a() {
        if (f229841b != null) goto L15;
        monitor-enter(w4.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f229841b != null) goto L9;
        f229841b = new w4();     // Catch: Throwable -> L11
    L9:
        monitor-exit(w4.class);     // Catch: Throwable -> L11
    L15:
        return f229841b;
    }

    public w4() {
        HashSet r100 = new HashSet();
        this.f229842a = r100;
        r100.add(4);
        ((HashSet) this.f229842a).add(6);
        ((HashSet) this.f229842a).add(Integer.valueOf(sbb.e.f541295f.f541317b));
        ((HashSet) this.f229842a).add(Integer.valueOf(sbb.e.f541296g.f541317b));
        ((HashSet) this.f229842a).add(Integer.valueOf(sbb.e.f541297h.f541317b));
        ((HashSet) this.f229842a).add(Integer.valueOf(sbb.e.f541301l.f541317b));
        ((HashSet) this.f229842a).add(Integer.valueOf(sbb.e.f541304o.f541317b));
        ((HashSet) this.f229842a).add(Integer.valueOf(sbb.e.f541303n.f541317b));
        ((HashSet) this.f229842a).add(Integer.valueOf(sbb.e.f541302m.f541317b));
        com.bytedance.ee.bear.appsetting.c r101 = com.bytedance.ee.bear.appsetting.c.a.f206237a;
        if (r101.h("apaas.miaoda.migrate_to_ccm") == false) goto L5;
        ((HashSet) this.f229842a).add(Integer.valueOf(sbb.e.f541309t.f541317b));
        ((HashSet) this.f229842a).add(Integer.valueOf(sbb.e.f541310u.f541317b));
    L5:
        boolean r102 = true;
        if (((com.bytedance.ee.bear.lark.dependency.k) org.koin.java.a.a(com.bytedance.ee.bear.lark.dependency.k.class)).d() == true) goto L8;
    L9:
        ((HashSet) this.f229842a).add(Integer.valueOf(sbb.e.f541298i.f541317b));
    L11:
        if ((!((com.bytedance.ee.bear.lark.dependency.b) org.koin.java.a.a(com.bytedance.ee.bear.lark.dependency.b.class)).isFeishuBrand()) == false) goto L13;
        r102 = r101.i("mindnote_enabled", false);
    L13:
        if (r102 == false) goto L15;
        ((HashSet) this.f229842a).add(Integer.valueOf(sbb.e.f541300k.f541317b));
    L15:
        tt5.a.h("SpaceWhiteList", "init()...mWhiteList = " + this.f229842a);
        return;
    L8:
        if (r101.i("ccm.spacekit.bitable.enable", true) == false) goto L11;
        goto L9
    }
}
