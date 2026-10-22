package com.bytedance.ee.bear.document.chatdraftdoc;

import com.bytedance.ee.bear.contract.Result;
import com.bytedance.ee.bear.document.chatdraftdoc.bean.CreateResponse;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class j<T> implements Consumer {
    public final /* synthetic */ k05.a a;

    public j(b r1) {
        this.a = r1;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void accept(Object r3) {
        Result r4 = (Result) r3;
        if (r4.code != 0) goto L5;
        this.a.a((CreateResponse) r4.data);
        return;
    L5:
        tt5.a.d("CreateChatDraftDocNetExecutor", "createChatDraftDoc error, code = " + r4.code + ", msg = " + r4.msg);
        this.a.a(null);
    }
}
