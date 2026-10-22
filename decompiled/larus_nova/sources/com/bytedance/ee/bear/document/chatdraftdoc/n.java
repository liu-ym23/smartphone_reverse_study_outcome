package com.bytedance.ee.bear.document.chatdraftdoc;

import com.bytedance.ee.bear.contract.Result;
import com.bytedance.ee.bear.document.chatdraftdoc.bean.QueryResponse;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes16.dex */
public final class n<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ k05.c f219219a;

    public n(a r100) {
        this.f219219a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        Result r101 = (Result) r100;
        if (r101.code != 0) goto L5;
        this.f219219a.a((QueryResponse) r101.data);
        return;
    L5:
        tt5.a.d("QueryChatDraftDocNetExecutor", "queryChatDraftDoc error, code = " + r101.code + ", msg = " + r101.msg);
        this.f219219a.a(null);
    }
}
