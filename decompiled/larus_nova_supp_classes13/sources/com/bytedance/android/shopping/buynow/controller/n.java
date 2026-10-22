package com.bytedance.android.shopping.buynow.controller;

import com.bytedance.android.shopping.base.event.EventActionImpl;
import io.reactivex.functions.Action;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class n implements Action {
    public static final n a = null;

    static {
        a = new n();
    }

    public n() {
    }

    public final void run() {
        EventActionImpl r0 = new EventActionImpl();
        Pair[] r1 = new Pair[4];
        r1[0] = TuplesKt.to("business", "buynow");
        r1[1] = TuplesKt.to("location", "buy");
        nl.c r2 = o.a;
        Object r3 = null;
        if (r2 == null) goto L12;
        Map r4 = r2.b();
        if (r4 == null) goto L12;
        Map r5 = MapsKt.toMutableMap(r4);
        if (r5 == null) goto L12;
        nl.c r6 = o.a;
        if (r6 == null) goto L11;
        r3 = r6.a();
    L11:
        r5.put("mega_object", r3);
        Unit r7 = Unit.INSTANCE;
        r3 = r5;
    L12:
        r1[2] = TuplesKt.to("in_schema", r3);
        r1[3] = TuplesKt.to("log_id", o.b);
        r0.doEventAction("schema_report", MapsKt.mapOf(r1));
    }
}
