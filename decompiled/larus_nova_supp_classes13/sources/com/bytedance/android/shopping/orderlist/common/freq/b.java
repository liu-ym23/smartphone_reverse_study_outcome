package com.bytedance.android.shopping.orderlist.common.freq;

import com.bytedance.android.ec.core.utils.u0;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class b {
    public static final List<FreqStrategy> a(List<? extends Map<String, ? extends Object>> r15) {
        ArrayList r0 = new ArrayList();
        Iterator<T> r16 = r15.iterator();
    L4:
        if (r16.hasNext() == false) goto L29;
        Map r1 = (Map) r16.next();
        Long r2 = StringsKt.toLongOrNull(String.valueOf(r1.get("freezing_period")));
        Long r3 = StringsKt.toLongOrNull(String.valueOf(r1.get("lookback_period")));
        String r4 = String.valueOf(r1.get("target_status"));
        Intrinsics.checkNotNullParameter(r4, "$this$toFreqStatus");
        FreqStatus.Companion.getClass();
        Intrinsics.checkNotNullParameter(r4, "value");
        FreqStatus[] r5 = FreqStatus.values();
        int r6 = r5.length;
        int r7 = 0;
    L6:
        if (r7 >= r6) goto L11;
        FreqStatus r8 = r5[r7];
        if (Intrinsics.areEqual(r8.getStatus(), r4) == true) goto L12;
        r7 = r7 + 1;
    L12:
        Map r9 = (Map) u0.b(String.valueOf(r1.get("actions")), Map.class);
        FreqActionType r10 = new FreqActionType(null, null, null, 7, null);
        if (r9 == null) goto L28;
        Set r11 = r9.keySet();
        if (r11 == null) goto L28;
        Iterator r12 = r11.iterator();
    L18:
        if (r12.hasNext() == false) goto L28;
        Object r13 = r12.next();
        if (Intrinsics.areEqual(r13, FreqActions.ACTION_VIEW) == true) goto L21;
        if (Intrinsics.areEqual(r13, "click") == true) goto L24;
        if (Intrinsics.areEqual(r13, FreqActions.ACTION_CLOSE) == false) goto L18;
        String r14 = String.valueOf(r9.get(r13));
        Intrinsics.checkNotNullParameter(r14, "$this$toFreqParam");
        r10.setClose((FreqParam) u0.b(r14, FreqParam.class));
        goto L18
    L24:
        String r17 = String.valueOf(r9.get(r13));
        Intrinsics.checkNotNullParameter(r17, "$this$toFreqParam");
        r10.setClick((FreqParam) u0.b(r17, FreqParam.class));
        goto L18
    L21:
        String r18 = String.valueOf(r9.get(r13));
        Intrinsics.checkNotNullParameter(r18, "$this$toFreqParam");
        r10.setView((FreqParam) u0.b(r18, FreqParam.class));
    L28:
        r0.add(new FreqStrategy(r10, r8, r2, r3));
        goto L4
    L11:
        r8 = null;
        goto L12
    L29:
        return r0;
    }
}
