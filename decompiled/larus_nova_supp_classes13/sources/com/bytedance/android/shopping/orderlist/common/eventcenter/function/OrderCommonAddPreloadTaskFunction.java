package com.bytedance.android.shopping.orderlist.common.eventcenter.function;

import android.os.Looper;
import android.os.MessageQueue;
import com.bytedance.android.ec.core.abtest.ECSettingKeys;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class OrderCommonAddPreloadTaskFunction extends com.bytedance.kmp.ec.yata.event.common.b {
    public final List<WeakReference<MessageQueue.IdleHandler>> a;
    public final List<Runnable> b;
    public final com.bytedance.android.shopping.orderlist.common.eventcenter.core.a c;

    public final void onDestroy() {
        Iterator<T> r0 = this.a.iterator();
    L4:
        if (r0.hasNext() == false) goto L8;
        MessageQueue.IdleHandler r1 = (MessageQueue.IdleHandler) ((WeakReference) r0.next()).get();
        if (r1 == null) goto L4;
        Looper.myQueue().removeIdleHandler(r1);
        goto L4
    L8:
        ((ArrayList) this.a).clear();
    }

    public OrderCommonAddPreloadTaskFunction(com.bytedance.android.shopping.orderlist.common.eventcenter.core.a r2) {
        Intrinsics.checkNotNullParameter(r2, "ability");
        this.c = r2;
        this.a = new ArrayList();
        this.b = new ArrayList();
        r2.J0(new AnonymousClass1(this));
    }

    public final com.bytedance.kmp.ec.yata.chain.event.b c(com.bytedance.kmp.ec.yata.event.core.a r7) {
        Intrinsics.checkNotNullParameter(r7, "input");
        ig3.a r1 = this.c.S0();
        if (r1 == null) goto L5;
        hg3.b r2 = r1.d;
    L6:
        com.bytedance.android.shopping.orderlist.common.controller.h r0 = new com.bytedance.android.shopping.orderlist.common.controller.h(r7.q(), new com.bytedance.android.shopping.orderlist.common.controller.g(r2, r7), this.a);
        if (ECSettingKeys.J() == false) goto L12;
        boolean r3 = this.c.G0();
        if (r3 == false) goto L11;
        ((ArrayList) this.b).add(new a(r0));
    L13:
        ig3.a r4 = this.c.S0();
        if (r4 == null) goto L21;
        hg3.d r5 = r4.g;
        if (r5 == null) goto L21;
        String r8 = r7.d.c;
        if (r8 != null) goto L20;
        r8 = "";
    L20:
        r5.b("selfAddPreloadTask", "", r8, Boolean.valueOf(r3));
    L21:
        int r9 = com.bytedance.kmp.ec.yata.chain.event.b.h;
        return com.bytedance.kmp.ec.yata.chain.event.b.a.c(false, null, null, 7);
    L11:
        r0.b();
        goto L13
    L12:
        r0.b();
        r3 = false;
        goto L13
    L5:
        r2 = null;
        goto L6
    }
}
