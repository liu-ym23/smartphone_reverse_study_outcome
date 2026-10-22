package com.bytedance.android.livesdk.livecommerce.room.controller.related;

import java.util.Iterator;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class b {
    public static final void a(JSONObject r3, JSONObject r4, boolean r5) {
        Intrinsics.checkNotNullParameter(r3, "$this$merge");
        if (r4 == null) goto L11;
        Iterator<String> r0 = r4.keys();
    L6:
        if (r0.hasNext() == false) goto L18;
        String r1 = r0.next();
        if (r3.has(r1) == false) goto L10;
        if (r5 == false) goto L6;
    L10:
        r3.put(r1, r4.get(r1));
        goto L6
    L18:
        return;
    }
}
