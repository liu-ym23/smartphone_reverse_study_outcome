package com.bytedance.ee.bear.share.externalshare.external.handler;

import com.bytedance.ee.bear.facade.common.widget.Toast;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class l<T> implements Consumer {
    public final /* synthetic */ h a;

    public l(h r1) {
        this.a = r1;
    }

    public final void accept(Object r4) {
        tt5.a.e("OpenFolderPasswordLinkHandler", "[perm-password-support] updateFolderAnyoneRead() failed", (Throwable) r4, false);
        Toast.showFailureText(this.a.a, 2131888342);
    }
}
