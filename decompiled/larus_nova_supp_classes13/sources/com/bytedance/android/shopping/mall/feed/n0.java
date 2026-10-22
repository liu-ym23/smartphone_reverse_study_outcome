package com.bytedance.android.shopping.mall.feed;

import com.bytedance.android.ec.hybrid.list.view.ECHybridRecyclerView;
import com.bytedance.android.ec.vlayout.VirtualLayoutManager;
import com.bytedance.common.utility.UIUtils;
import com.larus.apm.impl.protector.RunnableProtector;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class n0 implements Runnable {
    public final /* synthetic */ ECHybridRecyclerView a;
    public final /* synthetic */ ECMallFeed b;

    public n0(ECHybridRecyclerView r1, ECMallFeed r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void a() {
        VirtualLayoutManager r0 = this.a.getLayoutManager();
        if (r0 == null) goto L8;
        int r1 = r0.x();
        ECMallFeed r2 = this.b;
        r2.Q = -r1;
        Function2<? super Integer, ? super Boolean, Unit> r3 = r2.J0;
        if (r3 == null) goto L9;
        Unit r4 = (Unit) r3.invoke(Integer.valueOf(UIUtils.px2dip(this.a.getContext(), this.b.Q)), Boolean.TRUE);
        return;
    L9:
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
