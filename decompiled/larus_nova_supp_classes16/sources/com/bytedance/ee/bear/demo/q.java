package com.bytedance.ee.bear.demo;

import com.ss.android.lark.log.Log;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class q implements ut5.a<Boolean> {
    public final /* synthetic */ CCMFolderDemoActivity a;

    public q(CCMFolderDemoActivity r1) {
        this.a = r1;
    }

    public final void onResult(Object r4) {
        this.a.C1("requestPasswordCheck success: result=" + ((Boolean) r4) + '\n');
    }

    public final void onError(int r4, Throwable r5) {
        CCMFolderDemoActivity r0 = this.a;
        StringBuilder r1 = new StringBuilder("requestPasswordCheck error: code=");
        r1.append(r4);
        r1.append(", msg=");
        if (r5 == null) goto L5;
        String r6 = r5.getMessage();
    L6:
        r1.append(r6);
        r1.append('\n');
        r0.C1(r1.toString());
        Log.e("CCMFolderDemo", "requestPasswordCheck error", r5);
        return;
    L5:
        r6 = null;
        goto L6
    }
}
