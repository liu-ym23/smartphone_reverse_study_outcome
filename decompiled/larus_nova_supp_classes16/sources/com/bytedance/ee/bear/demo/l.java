package com.bytedance.ee.bear.demo;

import com.bytedance.ee.bear.contract.NetService;
import com.ss.android.lark.log.Log;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class l implements nc5.a<Boolean> {
    public final /* synthetic */ CCMFolderDemoActivity a;

    public l(CCMFolderDemoActivity r1) {
        this.a = r1;
    }

    public final void onFailure(Throwable r6) {
        Intrinsics.checkNotNullParameter(r6, "throwable");
        if ((r6 instanceof NetService.ServerErrorException) == false) goto L5;
        NetService.ServerErrorException r0 = (NetService.ServerErrorException) r6;
    L7:
        if (r0 == null) goto L9;
        this.a.C1("moveUnified failure: code=" + r0.getCode() + ", msg=" + r0.getMessage() + '\n');
    L10:
        Log.e("CCMFolderDemo", "moveUnified failure", r6);
        return;
    L9:
        this.a.C1("moveUnified failure: " + r6.getLocalizedMessage() + '\n');
        goto L10
    L5:
        r0 = null;
        goto L7
    }

    public final void onSuccess(Object r4) {
        boolean r5 = ((Boolean) r4).booleanValue();
        this.a.C1("moveUnified success: " + r5 + '\n');
    }
}
