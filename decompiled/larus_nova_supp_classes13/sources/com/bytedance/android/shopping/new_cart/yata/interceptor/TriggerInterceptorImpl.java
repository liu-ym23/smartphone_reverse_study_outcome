package com.bytedance.android.shopping.new_cart.yata.interceptor;

import com.bytedance.android.shopping.new_cart.container.CartObjectContainer;
import com.bytedance.android.shopping.new_cart.viewmodel.CartViewModel;
import com.bytedance.kmp.ec.yata.event.common.EventTriggerInfo;
import com.bytedance.kmp.ec.yata.event.common.h;
import com.bytedance.kmp.ec.yata.event.common.i;
import com.bytedance.kmp.ec.yata.store.node.c;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class TriggerInterceptorImpl implements i {
    public final AtomicBoolean a;
    public long b;
    public final AtomicBoolean c;
    public final Lazy d;
    public final CartObjectContainer e;

    public TriggerInterceptorImpl(CartObjectContainer r2) {
        Intrinsics.checkNotNullParameter(r2, "objectContainer");
        this.e = r2;
        this.a = new AtomicBoolean(false);
        this.c = new AtomicBoolean(false);
        this.d = LazyKt.lazy(new TriggerInterceptorImpl$cartVM$2(this));
    }

    public final h e(EventTriggerInfo r12) {
        Intrinsics.checkNotNullParameter(r12, "eventTriggerInfo");
        if (this.e.e.l.a == false) goto L17;
        Pair[] r0 = new Pair[2];
        r0[0] = TuplesKt.to("triggerType", String.valueOf(r12.b()));
        c r1 = r12.a();
        if (r1 == null) goto L7;
        String r2 = r1.getNodeName();
    L8:
        r0[1] = TuplesKt.to("renderNodeName", String.valueOf(r2));
        Map r6 = MapsKt.mapOf(r0);
        CartViewModel.doEventAction$default((CartViewModel) this.d.getValue(), "cart_trigger_intercept", r6, null, 4, null);
        if (this.a.compareAndSet(false, true) == false) goto L12;
        this.b = System.currentTimeMillis();
    L12:
        if (Intrinsics.areEqual(r12.b(), "asyncFetch") == false) goto L15;
        return new h(false);
    L15:
        return new h(true);
    L7:
        r2 = null;
        goto L8
    L17:
        if (this.a.get() == true) goto L19;
    L21:
        Intrinsics.checkNotNullParameter(r12, "eventTriggerInfo");
        return new h(false);
    L19:
        if (this.c.compareAndSet(false, true) == false) goto L21;
        long r3 = System.currentTimeMillis() - this.b;
        CartViewModel.doEventAction$default((CartViewModel) this.d.getValue(), "cart_trigger_intercept", MapsKt.mapOf(TuplesKt.to("duration", String.valueOf(r3))), null, 4, null);
        goto L21
    }
}
