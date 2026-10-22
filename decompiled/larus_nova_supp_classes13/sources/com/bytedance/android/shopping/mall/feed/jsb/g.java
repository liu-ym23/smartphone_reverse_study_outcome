package com.bytedance.android.shopping.mall.feed.jsb;

import com.bytedance.android.shopping.mall.feed.ECMallFeed;
import com.bytedance.sdk.xbridge.cn.registry.core.IBDXBridgeContext;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class g extends qf3.e {
    public final String d;

    public static final class a {
    }

    static {
    }

    public final String getName() {
        return this.d;
    }

    public g(qf3.d r2) {
        Intrinsics.checkNotNullParameter(r2, "mallJsbContext");
        super(r2);
        this.d = "ec.mallCommonImpression";
    }

    @Override // qf3.e
    public final Pair<Boolean, String> e(qf3.d r2, IBDXBridgeContext r3, Map<String, ? extends Object> r4, Map<String, Object> r5) {
        Intrinsics.checkNotNullParameter(r2, "mallJsbContext");
        Intrinsics.checkNotNullParameter(r3, "bridgeContext");
        Intrinsics.checkNotNullParameter(r4, "params");
        Intrinsics.checkNotNullParameter(r5, "result");
        Object r6 = r4.get("impressionArray");
        if ((r6 instanceof List) == true) goto L5;
        r6 = null;
    L5:
        List r7 = (List) r6;
        ECMallFeed r8 = r2.b;
        if (r7 == null) goto L12;
        Iterator r9 = r7.iterator();
    L9:
        if (r9.hasNext() == false) goto L12;
        r8.i((Map) r9.next());
    L12:
        return qf3.e.f(this);
    }
}
