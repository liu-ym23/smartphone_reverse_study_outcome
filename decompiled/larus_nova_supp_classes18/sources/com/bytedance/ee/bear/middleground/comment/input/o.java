package com.bytedance.ee.bear.middleground.comment.input;

import androidx.lifecycle.LiveData;
import com.bytedance.ee.bear.contract.ConnectionService;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class o implements Runnable {
    public final /* synthetic */ BaseInputComment a;

    public o(BaseInputComment r1) {
        this.a = r1;
    }

    public final void a() {
        BaseInputComment r0 = this.a;
        LiveData<ConnectionService.NetworkState> r1 = r0.Y;
        if (r1 == null) goto L5;
        r1.removeObserver(r0.Z);
    L5:
        BaseInputComment r2 = this.a;
        r2.Y = com.bytedance.ee.bear.contract.j.a.a.a();
        BaseInputComment r3 = this.a;
        LiveData<ConnectionService.NetworkState> r4 = r3.Y;
        if (r4 == null) goto L9;
        r4.observe(r3.a.getActivity(), this.a.Z);
        return;
    }

    @Override // java.lang.Runnable
    public final void run() {
        a();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
