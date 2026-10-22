package com.bytedance.ee.bear.document;

import android.text.TextUtils;
import com.bytedance.ee.bear.contract.config.DocDynamicConfig;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class o {
    public static void a() {
        tt5.a.h("BearCookieManager", "checkCookie()...");
        String r1 = ((com.bytedance.ee.bear.contract.b0) org.koin.java.a.a(com.bytedance.ee.bear.contract.b0.class)).t();
        DocDynamicConfig r2 = ((com.bytedance.ee.bear.contract.b0) org.koin.java.a.a(com.bytedance.ee.bear.contract.b0.class)).g();
        if (r2 == null) goto L6;
        ((com.bytedance.ee.bear.contract.h0) org.koin.java.a.a(com.bytedance.ee.bear.contract.h0.class)).j9(r2.f);
    L6:
        if (TextUtils.isEmpty(r1) == false) goto L9;
        tt5.a.d("BearCookieManager", "checkCookie()... in lark token is empty");
        return;
    L9:
        ((com.bytedance.ee.bear.contract.h0) org.koin.java.a.a(com.bytedance.ee.bear.contract.h0.class)).Be(r1).subscribe(new h(), new i());
    }
}
