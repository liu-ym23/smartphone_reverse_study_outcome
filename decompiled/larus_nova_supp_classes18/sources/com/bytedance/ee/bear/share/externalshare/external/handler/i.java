package com.bytedance.ee.bear.share.externalshare.external.handler;

import android.content.DialogInterface;
import com.alibaba.fastjson.JSONObject;
import com.bytedance.ee.bear.contract.net.SimpleRequestResult;
import com.bytedance.ee.bear.middleground.permission.share.info.ShareFolderInfo;
import com.bytedance.ee.docsdk.impl.document.plugins.offline.storage.ResourceData;
import io.reactivex.Flowable;
import io.reactivex.disposables.Disposable;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class i implements DialogInterface.OnClickListener {
    public final /* synthetic */ h a;
    public final /* synthetic */ ShareFolderInfo b;

    public i(h r1, ShareFolderInfo r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface r4, int r5) {
        h r6 = this.a;
        ShareFolderInfo r7 = this.b;
        r6.getClass();
        tt5.a.h("OpenFolderPasswordLinkHandler", "[perm-password-support] updateFolderAnyoneRead()...start isSingleContainer=" + r7.i());
        if (r7.i() == false) goto L5;
        JSONObject r0 = new JSONObject();
        r0.put(ResourceData.KEY_TOKEN, r7.c);
        r0.put(ResourceData.KEY_TYPE, Integer.valueOf(r7.getType()));
        r0.put("external_access_entity", 1);
        r0.put("link_share_entity", 4);
        Flowable<SimpleRequestResult> r1 = xh5.h.a.b(r0);
    L6:
        Disposable r8 = r1.observeOn(fo5.d.d()).subscribe(new k(r6, r7), new l(r6));
        Function1<Disposable, Unit> r9 = r6.e;
        if (r9 == null) goto L10;
        Intrinsics.checkNotNull(r8);
        r9.invoke(r8);
        return;
    L10:
        return;
    L5:
        int r2 = xh5.f.a;
        r1 = xh5.g.a.a(r7.j(), r7.getType());
        goto L6
    }
}
