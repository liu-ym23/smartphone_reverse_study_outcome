package com.bytedance.android.livesdk.livecommerce.livereplay.adapter.module;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class c implements com.bytedance.android.livesdk.livecommerce.promotion.card.e {
    public final /* synthetic */ f a;

    public c(f r1) {
        this.a = r1;
    }

    @Override // com.bytedance.android.livesdk.livecommerce.promotion.card.e
    public final boolean a(String r6, Map<String, String> r7, String r8, ql.a r9, Function3<? super String, ? super Map<String, String>, ? super String, Unit> r10) {
        Intrinsics.checkNotNullParameter(r6, "eventName");
        Intrinsics.checkNotNullParameter(r7, "eventParams");
        Intrinsics.checkNotNullParameter(r10, "save");
        if (Intrinsics.areEqual(r6, "livesdk_show_product") == false) goto L23;
        Map r11 = this.a.n.i.e();
        if (r11 != null) goto L7;
        r11 = MapsKt.emptyMap();
    L7:
        LinkedHashMap r1 = new LinkedHashMap();
        Iterator r12 = r11.entrySet().iterator();
    L8:
        boolean r3 = true;
        if (r12.hasNext() == false) goto L16;
        Map.Entry r2 = (Map.Entry) r12.next();
        if (((CharSequence) r2.getValue()).length() > 0) goto L14;
        r3 = false;
    L14:
        if (r3 == false) goto L8;
        r1.put(r2.getKey(), r2.getValue());
        goto L8
    L16:
        Map r13 = MapsKt.toMutableMap(r1);
        r13.putAll(r7);
        Unit r14 = Unit.INSTANCE;
        r10.invoke(r6, r13, r8);
        return true;
    L23:
        return false;
    }
}
