package com.bytedance.android.livesdk.livecommerce.iron.ui;

import com.bytedance.android.btm.api.BtmSDK;
import com.bytedance.android.btm.api.model.PageFinder;
import com.bytedance.android.ec.model.live.t;
import com.bytedance.android.livesdk.livecommerce.event.j0;
import com.larus.apm.impl.protector.RunnableProtector;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class c implements Runnable {
    public final /* synthetic */ com.bytedance.android.ec.model.live.e a;
    public final /* synthetic */ ECCustomizedElementView b;
    public final /* synthetic */ ECCustomizedElementView c;

    public c(com.bytedance.android.ec.model.live.e r1, ECCustomizedElementView r2, ECCustomizedElementView r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    public final void a() {
        if (Intrinsics.areEqual(this.b.getParent(), this.c) == true) goto L5;
        return;
    L5:
        if (this.b.getAlpha() > 0.0f) goto L7;
        return;
    L7:
        if (this.b.getWidth() <= 0) goto L17;
        this.c.getClass();
        t r0 = this.a.i();
        if (r0 != null) goto L11;
        return;
    L11:
        if (r0.b() == null) goto L19;
        j0 r1 = new j0(r0.b());
        r1.g(r0.c());
        r1.l(this.a.c(), BtmSDK.INSTANCE.getPageId(PageFinder.via(this.c)));
        return;
    L19:
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
