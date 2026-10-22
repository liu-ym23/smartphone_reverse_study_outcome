package com.bytedance.android.shopping.mall.feed.jsb;

import com.bytedance.android.ec.hybrid.list.ECHybridListEngine;
import com.bytedance.android.ec.hybrid.list.view.ECHybridRecyclerView;
import com.bytedance.sdk.xbridge.cn.registry.core.IBDXBridgeContext;
import java.util.Map;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class h extends qf3.e {
    public final String d;

    public static final class a {
    }

    static {
    }

    public final String getName() {
        return this.d;
    }

    public h(qf3.d r2) {
        Intrinsics.checkNotNullParameter(r2, "mallJsbContext");
        super(r2);
        this.d = "ec.controlMediaPlay";
    }

    @Override // qf3.e
    public final Pair<Boolean, String> e(qf3.d r2, IBDXBridgeContext r3, Map<String, ? extends Object> r4, Map<String, Object> r5) {
        Intrinsics.checkNotNullParameter(r2, "mallJsbContext");
        Intrinsics.checkNotNullParameter(r3, "bridgeContext");
        Intrinsics.checkNotNullParameter(r4, "params");
        Intrinsics.checkNotNullParameter(r5, "result");
        Object r6 = r4.get("control");
        if ((r6 instanceof String) == true) goto L5;
        r6 = null;
    L5:
        String r7 = (String) r6;
        if (r7 == null) goto L27;
        int r8 = r7.hashCode();
        if (r8 == 3443508) goto L20;
        if (r8 != 3540994) goto L27;
        if (r7.equals("stop") == false) goto L27;
        ECHybridListEngine r9 = r2.b.J;
        if (r9 == null) goto L27;
        ECHybridRecyclerView r10 = r9.b;
        if (r10 == null) goto L27;
        r10.i0();
        goto L27
    L20:
        if (r7.equals("play") == false) goto L27;
        ECHybridListEngine r11 = r2.b.J;
        if (r11 == null) goto L27;
        ECHybridRecyclerView r12 = r11.b;
        if (r12 == null) goto L27;
        r12.W();
    L27:
        return qf3.e.f(this);
    }
}
