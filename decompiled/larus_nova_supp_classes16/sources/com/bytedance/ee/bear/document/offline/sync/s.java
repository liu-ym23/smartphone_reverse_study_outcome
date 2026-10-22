package com.bytedance.ee.bear.document.offline.sync;

import android.text.TextUtils;
import com.alibaba.fastjson.JSONObject;
import com.bytedance.ee.bear.contract.AccountService$Account;
import com.bytedance.ee.bear.contract.offline.OfflineDoc;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class s extends g {
    @Override // com.bytedance.ee.bear.document.offline.sync.f
    public final void o(String r1, String r2) {
    }

    public s() {
        this.a = "MindnotePreloadStrategy";
    }

    @Override // com.bytedance.ee.bear.document.offline.sync.g, com.bytedance.ee.bear.document.offline.sync.q
    public final void f(AccountService$Account r3) {
        super.f(r3);
        this.f = r3.tenantId + OfflineDoc.DASH_DELIMITER + r3.uid + "_MINDNOTE_CLIENT_VARS";
        this.g = PreloadConfigModel.VERSION_CHECK_TYPE_MINDNOTE;
        this.j = new v25.d();
    }

    @Override // com.bytedance.ee.bear.document.offline.sync.f, com.bytedance.ee.bear.document.offline.sync.q
    public final k25.m0 g(String r4, Map<String, String> r5) {
        if (TextUtils.isEmpty(this.f) == true) goto L5;
        k25.m0 r6 = k25.e0.m().s(this.f, r4);
        if (r6 == null) goto L11;
        p r0 = this.n;
        if (r0 == null) goto L11;
        r25.e.a r1 = (r25.e.a) r0;
        r1.a(r4, r6.e.longValue());
    L11:
        return r6;
    L5:
        return new k25.m0();
    }

    @Override // com.bytedance.ee.bear.document.offline.sync.f
    public final JSONObject l(String r1, Map<String, String> r2, boolean r3) {
        return r(new k0(PreloadConfigModel.VERSION_CHECK_TYPE_MINDNOTE, new r(this.l, r1)));
    }
}
