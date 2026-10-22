package com.bytedance.ee.bear.document.sharewords;

import com.bytedance.ee.bear.contract.Result;
import com.bytedance.ee.bear.document.sharewords.bean.ShareWordsThumbnailResponse;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes16.dex */
public final class e<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ d.c f221795a;

    public e(g.a.C3161a r100) {
        this.f221795a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        Result r101 = (Result) r100;
        if (r101.code != 0) goto L5;
        tt5.a.h("ShareWordsNetExecutor", "requestShareWordsThumbnailUrl success");
        this.f221795a.a((ShareWordsThumbnailResponse) r101.data);
        return;
    L5:
        tt5.a.h("ShareWordsNetExecutor", "requestShareWordsThumbnailUrl failed " + r101.code);
        this.f221795a.a(null);
    }
}
