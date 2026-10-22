package com.bytedance.android.shopping.mall.homepage.card.headercard.components;

import com.bytedance.android.ec.hybrid.ECHybridExtensionsKt;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class LegouToolAreaComponent$refreshSubscriber$1 implements com.bytedance.android.ec.hybrid.card.event.e {
    public final /* synthetic */ LegouToolAreaComponent a;

    public LegouToolAreaComponent$refreshSubscriber$1(LegouToolAreaComponent r1) {
        this.a = r1;
    }

    public final void a(com.bytedance.android.ec.hybrid.card.event.d r4) {
        Intrinsics.checkNotNullParameter(r4, "jsEvent");
        final Ref.ObjectRef r0 = new Ref.ObjectRef();
        r0.element = "";
        Map r5 = r4.b;
        if (r5 == null) goto L5;
        final Object r6 = r5.get("tool_list");
    L6:
        final Ref.ObjectRef r2 = new Ref.ObjectRef();
        r2.element = null;
        kk.d.c(new LegouToolAreaComponent$refreshSubscriber$1$onReceiveJsEvent$1(r6, r0, r2));
        ECHybridExtensionsKt.f(new LegouToolAreaComponent$refreshSubscriber$1$onReceiveJsEvent$2(this, r2));
        return;
    L5:
        r6 = null;
        goto L6
    }
}
