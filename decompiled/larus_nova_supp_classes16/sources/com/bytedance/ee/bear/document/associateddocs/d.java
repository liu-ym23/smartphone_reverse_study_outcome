package com.bytedance.ee.bear.document.associateddocs;

import com.bytedance.ee.bear.contract.Result;
import com.bytedance.ee.bear.document.associateddocs.bean.AssociatedPluginsInfo;
import com.bytedance.ee.bear.document.associateddocs.bean.AssociatedUrlInfo;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class d<T> implements Consumer {
    public final /* synthetic */ a.b a;

    public d(AssociatedDocViewModel.b r1) {
        this.a = r1;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void accept(Object r2) {
        a.b r0 = this.a;
        AssociatedUrlInfo r3 = (AssociatedUrlInfo) ((Result) r2).data;
        if (r3 == null) goto L5;
        AssociatedPluginsInfo r4 = r3.getPluginsInfo();
    L6:
        r0.a(r4);
        return;
    L5:
        r4 = null;
        goto L6
    }
}
