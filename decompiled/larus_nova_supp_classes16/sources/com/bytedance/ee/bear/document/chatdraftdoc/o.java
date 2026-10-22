package com.bytedance.ee.bear.document.chatdraftdoc;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class o<T> implements Consumer {
    public final /* synthetic */ k05.c a;

    public o(a r1) {
        this.a = r1;
    }

    public final void accept(Object r3) {
        this.a.a(null);
        tt5.a.d("QueryChatDraftDocNetExecutor", "queryChatDraftDoc error, " + ((Throwable) r3).getMessage());
    }
}
