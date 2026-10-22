package com.bytedance.ee.bear.wikiv2.wikitreev2.create;

import android.content.Context;
import com.bytedance.ee.bear.contract.k0;
import com.bytedance.ee.bear.facade.common.widget.Toast;
import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.WikiAction;
import io.reactivex.functions.Consumer;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class j<T> implements Consumer {
    public final /* synthetic */ WikiCreateToFragment a;
    public final /* synthetic */ int b;

    public j(WikiCreateToFragment r1, int r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void accept(Object r5) {
        Throwable r6 = (Throwable) r5;
        if (k0.c(r6) == false) goto L6;
        return;
    L6:
        if (((com.bytedance.ee.bear.quoto.t) org.koin.java.a.c(com.bytedance.ee.bear.quoto.t.class, null, null, 6)).a(r6, this.a.getContext()) == false) goto L9;
        return;
    L9:
        if (((com.bytedance.ee.bear.quoto.t) org.koin.java.a.c(com.bytedance.ee.bear.quoto.t.class, null, null, 6)).p(r6, this.a.getContext(), false) == true) goto L15;
        jw4.a.h("create", r6, Integer.valueOf(this.b));
        Context r0 = this.a.getContext();
        Map<String, Integer> r1 = com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.q.a;
        Toast.showFailureText(r0, com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.q.d(WikiAction.ADD, r6));
        return;
    }
}
