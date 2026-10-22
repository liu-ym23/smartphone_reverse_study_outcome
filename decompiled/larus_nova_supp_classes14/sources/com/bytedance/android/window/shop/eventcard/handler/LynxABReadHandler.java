package com.bytedance.android.window.shop.eventcard.handler;

import com.bytedance.android.ec.core.monitor.ECExceptionMonitor;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class LynxABReadHandler implements a {
    public static final LynxABReadHandler a = null;

    public LynxABReadHandler() {
    }

    @Override // com.bytedance.android.window.shop.eventcard.handler.a
    public final void release() {
    }

    static {
        a = new LynxABReadHandler();
    }

    @Override // com.bytedance.android.window.shop.eventcard.handler.a
    public final Map<String, Object> a(int r5, Map<String, ? extends Object> r6) {
        Intrinsics.checkNotNullParameter(r6, "params");
        Object r7 = r6.get("ab_type");
        if ((r7 instanceof String) == true) goto L5;
        r7 = null;
    L5:
        String r8 = (String) r7;
        if (r8 == null) goto L8;
        Object r9 = r6.get("ab_keys");
        if (r9 == null) goto L47;
        List r10 = (List) r9;
        if (r10.isEmpty() == true) goto L45;
        List r11 = r10;
        boolean r1 = false;
        if ((r11 instanceof Collection) == true) goto L16;
    L18:
        Iterator r0 = r11.iterator();
    L20:
        if (r0.hasNext() == false) goto L24;
        if ((!(r0.next() instanceof String)) == false) goto L20;
        r1 = true;
    L24:
        if (r1 == true) goto L45;
        int r2 = r8.hashCode();
        if (r2 == (-344460952)) goto L35;
        if (r2 == 3208616) goto L32;
    L42:
        ECExceptionMonitor.e(new Exception("abType " + r8 + " not expected"));
        return MapsKt.emptyMap();
    L32:
        if (r8.equals("host") == false) goto L42;
        Function1 r12 = new LynxABReadHandler$handleEvent$reader$1(dp3.a.a);
    L37:
        LinkedHashMap r3 = new LinkedHashMap();
        Iterator r13 = r11.iterator();
    L39:
        if (r13.hasNext() == false) goto L41;
        String r4 = (String) r13.next();
        r3.put(r4, r12.invoke(r4));
        goto L39
    L41:
        return r3;
    L35:
        if (r8.equals("shopping") == false) goto L42;
        r12 = new LynxABReadHandler$handleEvent$reader$2(dp3.a.a);
        goto L37
    L16:
        if (r11.isEmpty() == false) goto L18;
    L45:
        return MapsKt.emptyMap();
    L47:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.collections.List<*>");
    L8:
        return MapsKt.emptyMap();
    }
}
