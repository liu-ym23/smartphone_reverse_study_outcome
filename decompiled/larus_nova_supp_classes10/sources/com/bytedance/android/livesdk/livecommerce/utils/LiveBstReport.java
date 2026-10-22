package com.bytedance.android.livesdk.livecommerce.utils;

import com.bytedance.android.ec.core.utils.b2;
import com.bytedance.android.livesdk.livecommerce.ab.ECLiveABUtils;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class LiveBstReport implements com.bytedance.android.bst.api.g {
    public final Function0<Map<String, String>> a;
    public final Function2<String, Map<String, String>, Unit> b;

    /* JADX WARN: Multi-variable type inference failed */
    public LiveBstReport(Function0<? extends Map<String, String>> r2, Function2<? super String, ? super Map<String, String>, Unit> r3) {
        Intrinsics.checkNotNullParameter(r2, "originParams");
        this.a = r2;
        this.b = r3;
    }

    public final void a(final String r2, final Map<Object, ? extends Object> r3) {
        Intrinsics.checkNotNullParameter(r2, "eventName");
        Intrinsics.checkNotNullParameter(r3, "params");
        if (ECLiveABUtils.INSTANCE.getLIST_FPS_OPT_CONFIG().getEnableOpt() == false) goto L5;
        b2.b(new LiveBstReport$report$1(this, r2, r3));
        return;
    L5:
        b(r2, r3);
    }

    public final void b(String r4, Map<Object, ? extends Object> r5) {
        LinkedHashMap r0 = new LinkedHashMap();
        r0.putAll((Map) this.a.invoke());
        r0.put("bst_group_type", "live");
        Iterator<Map.Entry<Object, ? extends Object>> r6 = r5.entrySet().iterator();
    L4:
        if (r6.hasNext() == false) goto L8;
        Map.Entry<Object, ? extends Object> r1 = r6.next();
        Object r2 = r1.getKey();
        Object r3 = r1.getValue();
        if (r3 == null) goto L4;
        r0.put(r2.toString(), r3.toString());
        goto L4
    L8:
        Function2<String, Map<String, String>, Unit> r7 = this.b;
        if (r7 != null) goto L11;
    L12:
        com.bytedance.android.livesdk.livecommerce.room.f.d(r4, r0);
        Unit r8 = Unit.INSTANCE;
        return;
    L11:
        if (((Unit) r7.invoke(r4, r0)) == null) goto L12;
    }
}
