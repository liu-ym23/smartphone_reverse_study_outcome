package com.bytedance.ee.bear.share.externalshare.external.handler;

import com.bytedance.ee.bear.contract.net.SimpleRequestResult;
import com.bytedance.ee.bear.middleground.permission.share.info.ShareFolderInfo;
import io.reactivex.functions.Consumer;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: classes18.dex */
public final class k<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ h f237102a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ ShareFolderInfo f237103b;

    public k(h r100, ShareFolderInfo r101) {
        this.f237102a = r100;
        this.f237103b = r101;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        SimpleRequestResult r101 = (SimpleRequestResult) r100;
        tt5.a.h("OpenFolderPasswordLinkHandler", "[perm-password-support] updateFolderAnyoneRead()...success, open password link page");
        Function0<Unit> r102 = this.f237102a.f237098f;
        if (r102 == null) goto L5;
        r102.invoke();
    L5:
        this.f237102a.b(this.f237103b);
    }
}
