package com.bytedance.ee.bear.doc.syncblock;

import com.bytedance.ee.bear.domain.BearUrl;
import io.reactivex.functions.Consumer;
import sbb.e;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class a<T> implements Consumer {
    public final /* synthetic */ SyncBlockFragment a;
    public final /* synthetic */ BearUrl b;

    public a(SyncBlockFragment r1, BearUrl r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void accept(Object r4) {
        String r5 = (String) r4;
        if (r5 != null) goto L5;
    L8:
        boolean r0 = true;
    L9:
        if (r0 == false) goto L13;
        SyncBlockFragment r6 = this.a;
        int r1 = SyncBlockFragment.q;
        r6.stopLoading();
        SyncBlockLoadingLayout r7 = this.a.h;
        if (r7 == null) goto L15;
        r7.a(-1);
        return;
    L15:
        return;
    L13:
        tt5.a.h("SyncBlockFragment", "fetchSourceToken success");
        SyncBlockFragment r2 = this.a;
        BearUrl r3 = this.b;
        int r8 = SyncBlockFragment.q;
        r2.getClass();
        r3.b = r5;
        r3.a = e.o.getType();
        r3.r = "601";
        r2.V90(r3);
        return;
    L5:
        if (r5.length() == 0) goto L8;
        r0 = false;
        goto L9
    }
}
