package com.bytedance.ee.bear.document.chatdraftdoc;

import com.bytedance.ee.bear.contract.Result;
import com.bytedance.ee.bear.document.chatdraftdoc.bean.CreateResponse;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes16.dex */
public final class j<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ k05.a f219213a;

    public j(b r100) {
        this.f219213a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        Result r101 = (Result) r100;
        if (r101.code != 0) goto L5;
        this.f219213a.a((CreateResponse) r101.data);
        return;
    L5:
        tt5.a.d("CreateChatDraftDocNetExecutor", "createChatDraftDoc error, code = " + r101.code + ", msg = " + r101.msg);
        this.f219213a.a(null);
    }
}
