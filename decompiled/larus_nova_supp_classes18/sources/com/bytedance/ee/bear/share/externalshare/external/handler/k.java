package com.bytedance.ee.bear.share.externalshare.external.handler;

import com.bytedance.ee.bear.contract.net.SimpleRequestResult;
import com.bytedance.ee.bear.middleground.permission.share.info.ShareFolderInfo;
import io.reactivex.functions.Consumer;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class k<T> implements Consumer {
    public final /* synthetic */ h a;
    public final /* synthetic */ ShareFolderInfo b;

    public k(h r1, ShareFolderInfo r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void accept(Object r2) {
        SimpleRequestResult r3 = (SimpleRequestResult) r2;
        tt5.a.h("OpenFolderPasswordLinkHandler", "[perm-password-support] updateFolderAnyoneRead()...success, open password link page");
        Function0<Unit> r4 = this.a.f;
        if (r4 == null) goto L5;
        r4.invoke();
    L5:
        this.a.b(this.b);
    }
}
