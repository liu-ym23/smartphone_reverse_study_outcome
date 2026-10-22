package com.bytedance.android.shopping.card_list.yata.interceptor;

import com.bytedance.android.shopping.card_list.components.CardListTrackerComponent;
import com.bytedance.android.shopping.card_list.container.init.CardListObjectContainer;
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
    public final CardListObjectContainer e;

    public TriggerInterceptorImpl(CardListObjectContainer r2) {
        Intrinsics.checkNotNullParameter(r2, "objectContainer");
        this.e = r2;
        this.a = new AtomicBoolean(false);
        this.c = new AtomicBoolean(false);
        this.d = LazyKt.lazy(new TriggerInterceptorImpl$trackerComponent$2(this));
    }

    public final h e(EventTriggerInfo r11) {
        Intrinsics.checkNotNullParameter(r11, "eventTriggerInfo");
        if (this.e.e.h.a == false) goto L20;
        Pair[] r0 = new Pair[2];
        r0[0] = TuplesKt.to("triggerType", String.valueOf(r11.b()));
        c r1 = r11.a();
        if (r1 == null) goto L7;
        String r2 = r1.getNodeName();
    L8:
        r0[1] = TuplesKt.to("renderNodeName", String.valueOf(r2));
        Map r3 = MapsKt.mapOf(r0);
        CardListTrackerComponent r4 = (CardListTrackerComponent) this.d.getValue();
        if (r4 == null) goto L12;
        CardListTrackerComponent.h(r4, "card_list_trigger_intercept", r3, 4);
    L12:
        if (this.a.compareAndSet(false, true) == false) goto L15;
        this.b = System.currentTimeMillis();
    L15:
        if (Intrinsics.areEqual(r11.b(), "asyncFetch") == false) goto L18;
        return new h(false);
    L18:
        return new h(true);
    L7:
        r2 = null;
        goto L8
    L20:
        if (this.a.get() == true) goto L22;
    L26:
        Intrinsics.checkNotNullParameter(r11, "eventTriggerInfo");
        return new h(false);
    L22:
        if (this.c.compareAndSet(false, true) == false) goto L26;
        long r6 = System.currentTimeMillis() - this.b;
        CardListTrackerComponent r5 = (CardListTrackerComponent) this.d.getValue();
        if (r5 == null) goto L26;
        CardListTrackerComponent.h(r5, "card_list_trigger_intercept", MapsKt.mapOf(TuplesKt.to("duration", String.valueOf(r6))), 4);
        goto L26
    }
}
