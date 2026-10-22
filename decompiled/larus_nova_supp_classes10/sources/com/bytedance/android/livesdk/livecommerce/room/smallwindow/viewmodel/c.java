package com.bytedance.android.livesdk.livecommerce.room.smallwindow.viewmodel;

import com.bytedance.android.livesdk.livecommerce.room.controller.CoreRequests;
import com.bytedance.android.livesdk.livecommerce.room.controller.l;
import com.bytedance.android.livesdk.livecommerce.room.controller.m;
import com.larus.apm.impl.protector.RunnableProtector;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import vi2.h;
import vi2.p;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class c implements Runnable {
    public final /* synthetic */ a a;

    public c(a r1) {
        this.a = r1;
    }

    public final void a() {
        a r0 = this.a;
        r0.getClass();
        CompositeDisposable r1 = CoreRequests.a;
        String r2 = r0.e;
        String r3 = r0.f;
        b r4 = new b(r0);
        r0.d = h.e(null, null, "https://ecom.snssdk.com/live/ecom/small_window/", new p(r2, r3)).observeOn(AndroidSchedulers.mainThread()).subscribe(new l(r4), new m(r4));
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
