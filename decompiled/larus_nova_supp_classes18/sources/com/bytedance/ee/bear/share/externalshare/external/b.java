package com.bytedance.ee.bear.share.externalshare.external;

import com.bytedance.ee.bear.middleground.permission.share.info.ShareDocInfo;
import com.bytedance.ee.bear.middleground_permission_export.model.doc.IDocPublicPermission;
import com.bytedance.ee.bear.share.externalshare.external.handler.m;
import io.reactivex.functions.Consumer;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class b<T> implements Consumer {
    public final /* synthetic */ DocShareExternalPresenter a;

    public b(DocShareExternalPresenter r1) {
        this.a = r1;
    }

    public final void accept(Object r3) {
        IDocPublicPermission r4 = (IDocPublicPermission) r3;
        ShareDocInfo r0 = this.a.k;
        Intrinsics.checkNotNull(r4);
        r0.getClass();
        Intrinsics.checkNotNullParameter(r4, "<set-?>");
        r0.g = r4;
        DocShareExternalPresenter r5 = this.a;
        ShareDocInfo r1 = r5.k;
        r1.h = true;
        r5.i(r1);
        DocShareExternalPresenter r6 = this.a;
        if (r6.r == false) goto L8;
        r6.r = false;
        m r7 = r6.p;
        if (r7 == null) goto L9;
        r7.a(true);
        return;
    L9:
        return;
    }
}
