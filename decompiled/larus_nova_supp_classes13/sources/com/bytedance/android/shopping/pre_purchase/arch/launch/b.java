package com.bytedance.android.shopping.pre_purchase.arch.launch;

import java.util.Iterator;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class b implements h {
    public final /* synthetic */ c a;
    public final /* synthetic */ g b;

    @Override // com.bytedance.android.shopping.pre_purchase.arch.launch.h
    public final void d() {
        this.a.a().d();
        if (this.b.d == null) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == true) goto L14;
        c r1 = this.a;
        Iterator<d> r2 = r1.a.iterator();
    L9:
        if (r2.hasNext() == false) goto L11;
        r2.next().c();
        goto L9
    L11:
        r1.a().c();
        return;
    L14:
        return;
    L5:
        r0 = false;
        goto L6
    }

    @Override // com.bytedance.android.shopping.pre_purchase.arch.launch.h
    public final void h(Throwable r2) {
        this.a.a().h(r2);
        this.a.b(r2);
    }

    public b(c r1, g r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // com.bytedance.android.shopping.pre_purchase.arch.launch.h
    public final void e(StageName r2, Map<String, String> r3) {
        Intrinsics.checkNotNullParameter(r2, "name");
        this.a.a().e(r2, r3);
    }
}
