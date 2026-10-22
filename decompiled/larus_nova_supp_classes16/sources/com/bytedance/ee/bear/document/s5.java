package com.bytedance.ee.bear.document;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class s5 implements com.bytedance.ee.bear.document.template.a {
    public final /* synthetic */ jdb.g a;
    public final /* synthetic */ t45.c b;

    @Override // com.bytedance.ee.bear.document.template.a
    public final String y0() {
        if (this.a.isCurrentEnable("ccm.mobile.ark_domain") == false) goto L7;
        String r0 = this.b.f9();
        if (r0 != null) goto L9;
        return "";
    L9:
        return r0;
    L7:
        String r1 = s45.p.t;
        Intrinsics.checkNotNull(r1);
        return r1;
    }

    public s5(jdb.g r1, t45.c r2) {
        this.a = r1;
        this.b = r2;
    }
}
