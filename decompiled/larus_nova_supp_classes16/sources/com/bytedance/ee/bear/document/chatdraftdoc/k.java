package com.bytedance.ee.bear.document.chatdraftdoc;

import com.bytedance.ee.bear.document.chatdraftdoc.bean.CreateResponse;
import com.bytedance.ee.bear.quoto.t;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class k<T> implements Consumer {
    public final /* synthetic */ k05.a a;

    public k(b r1) {
        this.a = r1;
    }

    public final void accept(Object r7) {
        Throwable r8 = (Throwable) r7;
        boolean r0 = ((t) org.koin.java.a.c(t.class, null, null, 6)).a(r8, null);
        boolean r3 = false;
        boolean r2 = ((t) org.koin.java.a.c(t.class, null, null, 6)).p(r8, null, false);
        tt5.a.d("CreateChatDraftDocNetExecutor", "createChatDraftDoc error, " + r8.getMessage());
        k05.a r9 = this.a;
        if (r0 == true) goto L5;
        if (r2 == true) goto L5;
    L6:
        r9.a(new CreateResponse(null, r3));
        return;
    L5:
        r3 = true;
        goto L6
    }
}
