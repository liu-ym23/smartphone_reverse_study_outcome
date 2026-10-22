package com.bytedance.android.shopping.orderlist.common.widgets.linkedlist;

import android.content.Context;
import android.view.VelocityTracker;
import android.widget.Scroller;
import com.bytedance.android.shopping.orderlist.common.utils.OrderCommonLog;
import kotlin.Lazy;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class LinkedScrollFlingHelper {
    public final Scroller a;
    public final VelocityTracker b;
    public int c;
    public final BaseLinkedScrollView d;
    public final Function1<Integer, Unit> e;
    public final Function0<Unit> f;

    public final void a() {
        Lazy r0 = OrderCommonLog.a;
        OrderCommonLog.a("LinkedScrollFlingHelper", LinkedScrollFlingHelper$stopFling$1.INSTANCE);
        this.a.forceFinished(true);
        this.f.invoke();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public LinkedScrollFlingHelper(Context r2, BaseLinkedScrollView r3, Function1<? super Integer, Unit> r4, Function0<Unit> r5) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "container");
        Intrinsics.checkNotNullParameter(r4, "scrollYDispatcher");
        Intrinsics.checkNotNullParameter(r5, "stopScrollCallback");
        this.d = r3;
        this.e = r4;
        this.f = r5;
        this.a = new Scroller(r2);
        this.b = VelocityTracker.obtain();
    }
}
