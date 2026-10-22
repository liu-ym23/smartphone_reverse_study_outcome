package com.bytedance.ee.bear.document.associateddocs;

import com.bytedance.ee.bear.document.associateddocs.plugin.AssociatedAppUrlPlugin;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class i<T> implements Consumer {
    public final /* synthetic */ a.e a;

    public i(AssociatedAppUrlPlugin.d r1) {
        this.a = r1;
    }

    public final void accept(Object r3) {
        tt5.a.d("AssociatedDocNetExecutor", "disassociateExitingDoc error, " + ((Throwable) r3).getMessage());
        this.a.a(-1, "");
    }
}
