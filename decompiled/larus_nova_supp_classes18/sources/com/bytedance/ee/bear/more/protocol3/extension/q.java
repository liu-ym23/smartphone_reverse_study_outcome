package com.bytedance.ee.bear.more.protocol3.extension;

import com.bytedance.ee.bear.middleground_permission_export.model.doc.DocPermission;
import io.reactivex.functions.Consumer;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class q<T> implements Consumer {
    public final /* synthetic */ a a;

    public q(a r1) {
        this.a = r1;
    }

    public final void accept(Object r3) {
        DocPermission r4 = (DocPermission) r3;
        tt5.a.h("DefMoreInfoBehavior", "permFlow ok. ");
        oj5.a r0 = this.a.c();
        if (r0 == null) goto L5;
        Intrinsics.checkNotNull(r4);
        Intrinsics.checkNotNullParameter(r4, "docPermission");
        r0.i = r4;
    L5:
        a r5 = this.a;
        r5.e(r5.c());
    }
}
