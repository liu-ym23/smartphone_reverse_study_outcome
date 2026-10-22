package com.bytedance.ee.bear.list;

import com.bytedance.ee.bear.contract.NetService;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class u3 {
    public static void a(NetService.f r6) {
        ((HashMap) ((NetService.e) r6).e).remove("obj_type");
        int r4 = 0;
        sbb.e[] r2 = {sbb.e.g, sbb.e.o, sbb.e.h, sbb.e.m, sbb.e.i, sbb.e.k, sbb.e.l};
        ArrayList r3 = new ArrayList();
    L3:
        if (r4 >= 7) goto L5;
        r3.add(String.valueOf(r2[r4].b));
        r4 = r4 + 1;
        goto L3
    L5:
        b(r3);
        r6.a("obj_type", r3);
    }

    public static void b(List r2) {
        if (idb.f.a().isEnable("apaas.miaoda.migrate_to_ccm") == false) goto L6;
        ArrayList r3 = (ArrayList) r2;
        r3.add(String.valueOf(113));
        r3.add(String.valueOf(114));
        return;
    }
}
