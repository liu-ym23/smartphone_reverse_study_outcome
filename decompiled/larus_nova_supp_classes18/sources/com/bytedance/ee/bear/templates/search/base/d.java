package com.bytedance.ee.bear.templates.search.base;

import cqa.h;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class d implements gqa.b {
    public final /* synthetic */ BaseView a;

    public d(BaseView r1) {
        this.a = r1;
    }

    public final void O0(h r2) {
        Intrinsics.checkNotNullParameter(r2, "it");
        f.a r3 = this.a.e;
        if (r3 == null) goto L6;
        r3.a();
        return;
    }
}
