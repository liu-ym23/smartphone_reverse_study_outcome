package com.bytedance.android.shopping.mall.homepage.jsb;

import com.bytedance.sdk.xbridge.cn.registry.core.IBDXBridgeContext;
import com.bytedance.sdk.xbridge.cn.registry.core.IDLXBridgeMethod;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class ECMallReportALogListJsb extends qf3.b {
    public final Lazy c;

    public final String getName() {
        return "ec.mallReportAlogList";
    }

    public ECMallReportALogListJsb() {
        this.c = LazyKt.lazy(ECMallReportALogListJsb$logService$2.INSTANCE);
    }

    @Override // qf3.b
    public final void c(IBDXBridgeContext r6, Map<String, ? extends Object> r7, IDLXBridgeMethod.a r8) {
        Intrinsics.checkNotNullParameter(r6, "bridgeContext");
        Intrinsics.checkNotNullParameter(r7, "params");
        Intrinsics.checkNotNullParameter(r8, "callback");
        Object r9 = r7.get("logList");
        if ((r9 instanceof ArrayList) == true) goto L5;
        r9 = null;
    L5:
        ArrayList r10 = (ArrayList) r9;
        if (r10 == null) goto L26;
        Iterator r11 = r10.iterator();
    L9:
        if (r11.hasNext() == false) goto L26;
        Map r0 = (Map) r11.next();
        if (r0 == null) goto L12;
        String r1 = (String) r0.get("level");
        String r2 = (String) r0.get("tag");
        String r3 = (String) r0.get("message");
        if (r1 == null) goto L23;
        int r4 = r1.hashCode();
        if (r4 != 3641990) goto L19;
        r1.equals("warn");
        goto L23
    L19:
        if (r4 != 96784904) goto L23;
        r1.equals("error");
    L23:
        yj.h r5 = (yj.h) this.c.getValue();
        if (r5 == null) goto L9;
        r5.log(r2, r3);
        goto L9
    L12:
        return;
    L26:
        LinkedHashMap r12 = new LinkedHashMap();
        Intrinsics.checkNotNullParameter(r8, "callback");
        Intrinsics.checkNotNullParameter(r12, "result");
        r8.invoke(MapsKt.mapOf(new Pair[]{TuplesKt.to("code", 1), TuplesKt.to("data", r12)}));
    }
}
