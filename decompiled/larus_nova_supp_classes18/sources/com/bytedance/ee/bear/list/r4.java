package com.bytedance.ee.bear.list;

import com.bytedance.ee.bear.contract.offline.OfflineDoc;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class r4 implements bx4.a {
    public r4() {
    }

    public static OfflineDoc a(w3 r4) {
        OfflineDoc r0 = new OfflineDoc();
        r0.setEdit_time(r4.a);
        r0.setFakeToken(r4.b);
        r0.setType(CastIntegerProtector.parseInt(r4.getType()));     // Catch: Exception -> L5
    L7:
        r0.setFilepath(r4.g);
        r0.setName(r4.d);
        r0.setObj_token(r4.e);
        r0.setToken(r4.h);
        r0.setOwner_type(r4.i);
        r0.setSyncState(r4.f ? 1 : 0);
        r0.setUrl(r4.j);
        r0.setIsWiki(r4.k);
        return r0;
    L5:
        e = move-exception;
        tt5.a.f("OfflineOperationWrapper", e, false);
        goto L7
    }
}
