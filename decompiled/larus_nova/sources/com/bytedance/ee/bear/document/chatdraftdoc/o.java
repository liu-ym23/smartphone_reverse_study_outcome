package com.bytedance.ee.bear.document.chatdraftdoc;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes16.dex */
public final class o<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ k05.c f219220a;

    public o(a r100) {
        this.f219220a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        this.f219220a.a(null);
        tt5.a.d("QueryChatDraftDocNetExecutor", "queryChatDraftDoc error, " + ((Throwable) r100).getMessage());
    }
}
