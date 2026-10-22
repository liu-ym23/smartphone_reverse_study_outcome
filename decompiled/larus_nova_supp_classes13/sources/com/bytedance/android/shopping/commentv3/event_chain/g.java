package com.bytedance.android.shopping.commentv3.event_chain;

import com.bytedance.kmp.ec.yata.chain.event.EventContext;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class g {
    public static final Map<?, ?> a(EventContext r2) {
        Intrinsics.checkNotNullParameter(r2, "$this$getIncomingData");
        Map r3 = r2.k;
        Object r0 = null;
        if (r3 == null) goto L5;
        Object r4 = r3.get("incoming_data");
    L7:
        if ((r4 instanceof Map) == false) goto L11;
        r0 = r4;
    L11:
        return (Map) r0;
    L5:
        r4 = null;
        goto L7
    }

    public static final String b(EventContext r2) {
        Intrinsics.checkNotNullParameter(r2, "$this$getSliceId");
        Map r3 = r2.k;
        if (r3 == null) goto L7;
        Object r4 = r3.get("slice_id");
        if (r4 == null) goto L7;
        String r5 = r4.toString();
    L8:
        if (r5 != null) goto L10;
    L13:
        boolean r1 = true;
    L14:
        if (r1 == false) goto L17;
        return null;
    L17:
        return r5;
    L10:
        if (r5.length() == 0) goto L13;
        r1 = false;
    L7:
        r5 = null;
        goto L8
    }
}
