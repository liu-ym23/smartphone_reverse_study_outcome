package com.bytedance.ee.bear.list.folderselect.command;

import com.bytedance.ee.bear.quoto.SingleFileQuotaConfig;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes18.dex */
public final class p<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ n f228200a;

    public p(n r100) {
        this.f228200a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        tt5.a.d("SpaceMakeCopyToSpaceCommand", "showFailedToast pullFileSize fail: " + ((Throwable) r100));
        ((com.bytedance.ee.bear.quoto.t) org.koin.java.a.c(com.bytedance.ee.bear.quoto.t.class, null, null, 6)).f(this.f228200a.getContext(), SingleFileQuotaConfig.DUPLICATE, 0L);
    }
}
