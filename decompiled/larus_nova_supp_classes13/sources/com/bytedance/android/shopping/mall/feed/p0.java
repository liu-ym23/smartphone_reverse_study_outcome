package com.bytedance.android.shopping.mall.feed;

import com.bytedance.android.ec.hybrid.list.ECHybridListEngine;
import com.bytedance.common.utility.UIUtils;
import com.larus.apm.impl.protector.RunnableProtector;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class p0 implements Runnable {
    public final /* synthetic */ ECMallFeed a;
    public final /* synthetic */ ECHybridListEngine b;

    public p0(ECMallFeed r1, ECHybridListEngine r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void a() {
        this.a.p0(this.b.b, 0);
        Function2<? super Integer, ? super Boolean, Unit> r0 = this.a.J0;
        if (r0 == null) goto L6;
        Unit r1 = (Unit) r0.invoke(Integer.valueOf(UIUtils.px2dip(this.b.b.getContext(), this.a.Q)), Boolean.TRUE);
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
