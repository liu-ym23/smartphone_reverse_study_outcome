package com.bytedance.android.shopping.mall.feed.jsb;

import com.bytedance.android.ec.opt.session.ECPerfSessionManager;
import com.bytedance.sdk.xbridge.cn.registry.core.IBDXBridgeContext;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class d0 extends qf3.e {
    public final String getName() {
        return "ec.readPerfSession";
    }

    public d0(qf3.d r2) {
        Intrinsics.checkNotNullParameter(r2, "mallJsbContext");
        super(r2);
    }

    @Override // qf3.e
    public final Pair<Boolean, String> e(qf3.d r4, IBDXBridgeContext r5, Map<String, ? extends Object> r6, Map<String, Object> r7) {
        Intrinsics.checkNotNullParameter(r4, "mallJsbContext");
        Intrinsics.checkNotNullParameter(r5, "bridgeContext");
        Intrinsics.checkNotNullParameter(r6, "params");
        Intrinsics.checkNotNullParameter(r7, "result");
        Object r8 = r6.get("session_id");
        if ((r8 instanceof String) == true) goto L5;
        r8 = null;
    L5:
        String r9 = (String) r8;
        Object r10 = r6.get("stage");
        if ((r10 instanceof String) == true) goto L8;
        r10 = null;
    L8:
        String r11 = (String) r10;
        boolean r12 = true;
        if (r9 != null) goto L11;
    L14:
        boolean r2 = true;
    L15:
        if (r2 == true) goto L17;
        if (r11 != null) goto L20;
    L23:
        if (r12 == false) goto L25;
        bm.a r13 = ECPerfSessionManager.d.b(r9);
    L26:
        if (r13 == null) goto L35;
        LinkedHashMap r14 = new LinkedHashMap();
        LinkedHashMap r15 = new LinkedHashMap();
        r15.putAll(r13.a);
        Unit r1 = Unit.INSTANCE;
        r14.put("common", r15);
        LinkedList r16 = new LinkedList();
        Iterator r17 = r13.c.entrySet().iterator();
    L30:
        if (r17.hasNext() == false) goto L32;
        r16.add(((bm.b) ((Map.Entry) r17.next()).getValue()).b());
        goto L30
    L32:
        Unit r18 = Unit.INSTANCE;
        r14.put("stages", r16);
        r7.putAll(r14);
        return TuplesKt.to(Boolean.TRUE, null);
    L35:
        return TuplesKt.to(Boolean.FALSE, "no session info");
    L25:
        r13 = ECPerfSessionManager.d.c(r9, r11);
        goto L26
    L20:
        if (StringsKt.isBlank(r11) == true) goto L23;
        r12 = false;
        goto L23
    L17:
        return TuplesKt.to(Boolean.FALSE, "invalid session id");
    L11:
        if (StringsKt.isBlank(r9) == true) goto L14;
        r2 = false;
        goto L15
    }
}
