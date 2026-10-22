package com.bytedance.ee.bear.share.externalshare.external.handler;

import com.bytedance.ee.bear.facade.common.widget.Toast;
import com.larus.nova.R;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes18.dex */
public final class l<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ h f237104a;

    public l(h r100) {
        this.f237104a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        tt5.a.e("OpenFolderPasswordLinkHandler", "[perm-password-support] updateFolderAnyoneRead() failed", (Throwable) r100, false);
        Toast.showFailureText(this.f237104a.f237093a, R.string.Doc_Wiki_SeverError);
    }
}
