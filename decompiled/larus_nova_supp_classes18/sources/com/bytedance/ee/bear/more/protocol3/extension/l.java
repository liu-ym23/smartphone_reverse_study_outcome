package com.bytedance.ee.bear.more.protocol3.extension;

import com.bytedance.ee.bear.DocObjInfo;
import io.reactivex.functions.Consumer;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class l<T> implements Consumer {
    public final /* synthetic */ a a;

    public l(a r1) {
        this.a = r1;
    }

    public final void accept(Object r3) {
        DocObjInfo r4 = (DocObjInfo) r3;
        tt5.a.h("DefMoreInfoBehavior", "objInfoFlow ok. ");
        oj5.a r0 = this.a.c();
        if (r0 == null) goto L5;
        Intrinsics.checkNotNull(r4);
        Intrinsics.checkNotNullParameter(r4, "docObjInfo");
        r0.h = r4;
    L5:
        a r5 = this.a;
        r5.e(r5.c());
    }
}
