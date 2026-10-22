package com.bytedance.badger.z;

import com.bytedance.badger.data.IBadgerData;
import com.bytedance.badger.module.BadgerModuleBase;

/* JADX INFO: loaded from: classes47.dex */
public abstract class u0 extends BadgerModuleBase {
    public u0() {
    }

    public static boolean b(Long r100, IBadgerData r101, long r102) {
        if (r100 == null) goto L6;
        int r103 = com.bytedance.badger.t.a.f199193a;
        j r104 = new j(r100, r102);
        com.bytedance.badger.t.c r105 = new com.bytedance.badger.t.c(598148581);
        r104.invoke(r105);
        com.bytedance.badger.t.d r106 = r105.a(r101);
        if (r106.e() == false) goto L6;
        return com.bytedance.badger.t.d.f(r106);
    L6:
        return false;
    }
}
