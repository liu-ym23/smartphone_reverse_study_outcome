package com.bytedance.ee.bear.document.render.init;

import com.bytedance.ee.bear.contract.m0;
import com.bytedance.ee.bear.document.DocViewModel;
import com.bytedance.ee.bear.document.fail.DocException;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class e implements m0 {
    public final /* synthetic */ a a;

    @Override // com.bytedance.ee.bear.contract.m0
    public final void a() {
    }

    @Override // com.bytedance.ee.bear.contract.m0
    public final void b() {
    }

    @Override // com.bytedance.ee.bear.contract.m0
    public final void c() {
    }

    @Override // com.bytedance.ee.bear.contract.m0
    public final void d() {
    }

    @Override // com.bytedance.ee.bear.contract.m0
    public final void e() {
    }

    @Override // com.bytedance.ee.bear.contract.m0
    public final void f() {
    }

    @Override // com.bytedance.ee.bear.contract.m0
    public final void g() {
    }

    @Override // com.bytedance.ee.bear.contract.m0
    public final void h() {
    }

    @Override // com.bytedance.ee.bear.contract.m0
    public final void i(DocException r1, Map r2) {
    }

    @Override // com.bytedance.ee.bear.contract.m0
    public final void j() {
    }

    public e(a r1) {
        this.a = r1;
    }

    @Override // com.bytedance.ee.bear.contract.m0
    public final void m(Map<String, String> r2) {
        DocViewModel r3 = this.a.b;
        if (r3 == null) goto L9;
        if (r3 == null) goto L6;
        String r0 = r3.getUrl();
    L7:
        r3.requestDocumentInfo(r0);
        return;
    L6:
        r0 = null;
        goto L7
    }
}
