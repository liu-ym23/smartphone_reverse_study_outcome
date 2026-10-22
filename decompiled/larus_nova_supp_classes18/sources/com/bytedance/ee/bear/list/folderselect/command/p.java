package com.bytedance.ee.bear.list.folderselect.command;

import com.bytedance.ee.bear.quoto.SingleFileQuotaConfig;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class p<T> implements Consumer {
    public final /* synthetic */ n a;

    public p(n r1) {
        this.a = r1;
    }

    public final void accept(Object r5) {
        tt5.a.d("SpaceMakeCopyToSpaceCommand", "showFailedToast pullFileSize fail: " + ((Throwable) r5));
        ((com.bytedance.ee.bear.quoto.t) org.koin.java.a.c(com.bytedance.ee.bear.quoto.t.class, null, null, 6)).f(this.a.getContext(), SingleFileQuotaConfig.DUPLICATE, 0L);
    }
}
