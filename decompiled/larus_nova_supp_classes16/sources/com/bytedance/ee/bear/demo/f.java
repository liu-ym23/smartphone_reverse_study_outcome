package com.bytedance.ee.bear.demo;

import com.ss.android.lark.log.Log;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class f implements nc5.a<Boolean> {
    public final /* synthetic */ CCMFolderDemoActivity a;

    public f(CCMFolderDemoActivity r1) {
        this.a = r1;
    }

    public final void onFailure(Throwable r4) {
        Intrinsics.checkNotNullParameter(r4, "throwable");
        this.a.C1("deleteOne failure: " + r4.getLocalizedMessage() + '\n');
        Log.e("CCMFolderDemo", "deleteOne failure", r4);
    }

    public final void onSuccess(Object r4) {
        boolean r5 = ((Boolean) r4).booleanValue();
        this.a.C1("deleteOne success: result:" + r5 + " \n");
    }
}
