package com.bytedance.ee.bear.list;

import com.bytedance.ee.bear.contract.offline.OfflineDoc;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;

/* JADX INFO: loaded from: classes18.dex */
public final class r4 implements bx4.a {
    public r4() {
    }

    public static OfflineDoc a(w3 r100) {
        OfflineDoc r101 = new OfflineDoc();
        r101.setEdit_time(r100.f229830a);
        r101.setFakeToken(r100.f229831b);
        r101.setType(CastIntegerProtector.parseInt(r100.getType()));     // Catch: Exception -> L5
    L7:
        r101.setFilepath(r100.f229836g);
        r101.setName(r100.f229833d);
        r101.setObj_token(r100.f229834e);
        r101.setToken(r100.f229837h);
        r101.setOwner_type(r100.f229838i);
        r101.setSyncState(r100.f229835f ? 1 : 0);
        r101.setUrl(r100.f229839j);
        r101.setIsWiki(r100.f229840k);
        return r101;
    L5:
        e = move-exception;
        tt5.a.f("OfflineOperationWrapper", e, false);
        goto L7
    }
}
