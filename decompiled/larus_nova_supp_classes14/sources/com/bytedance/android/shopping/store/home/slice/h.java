package com.bytedance.android.shopping.store.home.slice;

import com.bytedance.android.shopping.store.home.a0;
import com.bytedance.android.shopping.store.home.b0;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class h {
    public static final void a(Map<String, Object> r3, a0 r4, String r5) {
        Intrinsics.checkNotNullParameter(r3, "sliceItemStates");
        Intrinsics.checkNotNullParameter(r4, "followConfig");
        Intrinsics.checkNotNullParameter(r5, "logTag");
        int r2 = b0.a;
        Intrinsics.checkNotNullParameter(r4, "followConfig");
        Integer r6 = null;
        if (r4.b == false) goto L9;
        if (r4.e == false) goto L7;
        String r1 = "follow";
    L15:
        String r7 = r4.h;
        if (r7 == null) goto L18;
        r6 = StringsKt.toIntOrNull(r7);
    L18:
        Intrinsics.checkNotNullParameter(r3, "sliceItemStates");
        if (r1 == null) goto L21;
        r3.put("shop_follow_state", r1);
    L21:
        if (r6 == null) goto L23;
        r3.put("shop_fans_level", Integer.valueOf(r6.intValue()));
    L23:
        dm.a.a(r5).a("updateFollowStateFromFollowConfig, sliceItemStates: " + r3);
        return;
    L7:
        r1 = "unfollow";
        goto L15
    L9:
        if (r4.c == true) goto L11;
        r1 = null;
        goto L15
    L11:
        if (r4.i == false) goto L13;
        r1 = "fans_level";
        goto L15
    L13:
        r1 = "join_fans";
        goto L15
    }
}
