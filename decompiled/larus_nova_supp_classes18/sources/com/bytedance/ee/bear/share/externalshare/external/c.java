package com.bytedance.ee.bear.share.externalshare.external;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class c<T> implements Consumer {
    public final /* synthetic */ DocShareExternalPresenter a;

    public c(DocShareExternalPresenter r1) {
        this.a = r1;
    }

    public final void accept(Object r4) {
        this.a.r = false;
        tt5.a.e("DocShareExternalPresenter", "refreshPublicPermission failed", (Throwable) r4, false);
    }
}
