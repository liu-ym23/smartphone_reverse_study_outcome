package com.bytedance.ee.bear.demo;

import com.bytedance.ee.bear.contract.net.SimpleRequestResult;
import com.bytedance.ee.bear.document.tips.TipCallBackData;
import com.ss.android.lark.log.Log;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class o implements nc5.a<SimpleRequestResult> {
    public final /* synthetic */ CCMFolderDemoActivity a;

    public o(CCMFolderDemoActivity r1) {
        this.a = r1;
    }

    public final void onFailure(Throwable r4) {
        Intrinsics.checkNotNullParameter(r4, "throwable");
        this.a.C1("file rename failure: " + r4.getLocalizedMessage() + '\n');
        Log.e("CCMFolderDemo", "file rename failure", r4);
    }

    public final void onSuccess(Object r4) {
        SimpleRequestResult r5 = (SimpleRequestResult) r4;
        Intrinsics.checkNotNullParameter(r5, TipCallBackData.RESULT);
        this.a.C1("file rename success: code=" + r5.code + ", msg=" + r5.msg + '\n');
    }
}
