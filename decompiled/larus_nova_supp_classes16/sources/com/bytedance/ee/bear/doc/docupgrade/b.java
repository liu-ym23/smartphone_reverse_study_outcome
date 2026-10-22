package com.bytedance.ee.bear.doc.docupgrade;

import com.bytedance.ee.bear.contract.c0;
import com.bytedance.ee.bear.list.dto.Document;
import kd5.b2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class b implements c0.b {
    public final /* synthetic */ Document a;

    @Override // com.bytedance.ee.bear.contract.c0.b
    public final void a(boolean r1) {
    }

    public b(Document r1) {
        this.a = r1;
    }

    @Override // com.bytedance.ee.bear.contract.c0.b
    public final void b(Document r1, long r2, b2 r4) {
        Intrinsics.checkNotNullParameter(r4, "callback");
        r4.b(this.a);
    }
}
