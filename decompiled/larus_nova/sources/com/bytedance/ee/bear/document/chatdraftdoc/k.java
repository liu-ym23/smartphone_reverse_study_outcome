package com.bytedance.ee.bear.document.chatdraftdoc;

import com.bytedance.ee.bear.document.chatdraftdoc.bean.CreateResponse;
import com.bytedance.ee.bear.quoto.t;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes16.dex */
public final class k<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ k05.a f219214a;

    public k(b r100) {
        this.f219214a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        Throwable r101 = (Throwable) r100;
        boolean r102 = ((t) org.koin.java.a.c(t.class, null, null, 6)).a(r101, null);
        boolean r103 = false;
        boolean r104 = ((t) org.koin.java.a.c(t.class, null, null, 6)).p(r101, null, false);
        tt5.a.d("CreateChatDraftDocNetExecutor", "createChatDraftDoc error, " + r101.getMessage());
        k05.a r105 = this.f219214a;
        if (r102 == true) goto L5;
        if (r104 == true) goto L5;
    L6:
        r105.a(new CreateResponse(null, r103));
        return;
    L5:
        r103 = true;
        goto L6
    }
}
