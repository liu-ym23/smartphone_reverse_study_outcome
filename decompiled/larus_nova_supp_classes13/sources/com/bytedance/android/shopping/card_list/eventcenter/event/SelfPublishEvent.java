package com.bytedance.android.shopping.card_list.eventcenter.event;

import com.bytedance.android.shopping.card_list.container.init.CardListObjectContainer;
import com.bytedance.android.shopping.card_list.monitor.error.CardListRunCatchExtKt;
import com.bytedance.android.shopping.card_list.params.CardPassThroughData;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class SelfPublishEvent extends com.bytedance.kmp.ec.yata.event.common.a {
    public final String a;
    public final Lazy b;

    public static final class a {
    }

    static {
    }

    public SelfPublishEvent(CardListObjectContainer r2) {
        Intrinsics.checkNotNullParameter(r2, "objectContainer");
        CardPassThroughData r3 = r2.e.a;
        if (r3 == null) goto L5;
        String r4 = r3.getMonitorId();
    L6:
        this.a = r4;
        this.b = LazyKt.lazy(new SelfPublishEvent$monitorManager$2(this));
        return;
    L5:
        r4 = null;
        goto L6
    }

    public final void c(final com.bytedance.kmp.ec.yata.event.core.a r7, final Function1 r8) {
        Intrinsics.checkNotNullParameter(r7, "input");
        Intrinsics.checkNotNullParameter(r8, "chainNextCallback");
        Object r0 = r7.p(Reflection.getOrCreateKotlinClass(String.class), "event_name");
        if ((r0 instanceof String) == true) goto L5;
        r0 = null;
    L5:
        final String r1 = (String) r0;
        if (r1 != null) goto L9;
        r1 = "";
    L9:
        if (r1.length() != 0) goto L11;
        boolean r2 = true;
    L12:
        if (r2 == false) goto L15;
        int r9 = com.bytedance.kmp.ec.yata.chain.event.b.h;
        r8.invoke(com.bytedance.kmp.ec.yata.chain.event.b.a.a(false, false, "schema is null", null, null, 57));
        return;
    L15:
        CardListRunCatchExtKt.a(this.a, "error transforming fields to json", new SelfPublishEvent$onExecuteAsync$1(r7, r1, r8));
        return;
    L11:
        r2 = false;
        goto L12
    }
}
