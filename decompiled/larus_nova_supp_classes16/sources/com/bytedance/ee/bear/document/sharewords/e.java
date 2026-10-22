package com.bytedance.ee.bear.document.sharewords;

import com.bytedance.ee.bear.contract.Result;
import com.bytedance.ee.bear.document.sharewords.bean.ShareWordsThumbnailResponse;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class e<T> implements Consumer {
    public final /* synthetic */ d.c a;

    public e(g.a.C0105a r1) {
        this.a = r1;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void accept(Object r4) {
        Result r5 = (Result) r4;
        if (r5.code != 0) goto L5;
        tt5.a.h("ShareWordsNetExecutor", "requestShareWordsThumbnailUrl success");
        this.a.a((ShareWordsThumbnailResponse) r5.data);
        return;
    L5:
        tt5.a.h("ShareWordsNetExecutor", "requestShareWordsThumbnailUrl failed " + r5.code);
        this.a.a(null);
    }
}
