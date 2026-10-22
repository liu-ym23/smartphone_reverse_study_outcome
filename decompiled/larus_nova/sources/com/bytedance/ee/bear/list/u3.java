package com.bytedance.ee.bear.list;

import com.bytedance.ee.bear.contract.NetService;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/* JADX INFO: loaded from: classes18.dex */
public final class u3 {
    public static void a(NetService.f r100) {
        ((HashMap) r100.f216908e).remove("obj_type");
        int r101 = 0;
        sbb.e[] r102 = {sbb.e.f541296g, sbb.e.f541304o, sbb.e.f541297h, sbb.e.f541302m, sbb.e.f541298i, sbb.e.f541300k, sbb.e.f541301l};
        ArrayList r103 = new ArrayList();
    L3:
        if (r101 >= 7) goto L5;
        r103.add(String.valueOf(r102[r101].f541317b));
        r101 = r101 + 1;
        goto L3
    L5:
        b(r103);
        r100.a("obj_type", r103);
    }

    public static void b(List r100) {
        if (idb.f.a().isEnable("apaas.miaoda.migrate_to_ccm") == false) goto L6;
        ArrayList r101 = (ArrayList) r100;
        r101.add(String.valueOf(113));
        r101.add(String.valueOf(114));
        return;
    }
}
