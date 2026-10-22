package com.bytedance.ee.bear.middleground.comment.input;

import androidx.lifecycle.LiveData;
import com.bytedance.ee.bear.contract.ConnectionService;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class n0 implements Runnable {
    public final /* synthetic */ InputComment a;

    public n0(InputComment r1) {
        this.a = r1;
    }

    @Override // java.lang.Runnable
    public final void run() {
        InputComment r0 = this.a;     // Catch: Throwable -> L6
        LiveData<ConnectionService.NetworkState> r1 = r0.j0;     // Catch: Throwable -> L6
        if (r1 == null) goto L9;
        r1.observe(r0.a.getActivity(), this.a.k0);     // Catch: Throwable -> L6
        return;
    L9:
        return;
    L6:
        th = move-exception;
        if (RunnableProtector.intercept(th) == true) goto L13;
        throw th;
    }
}
