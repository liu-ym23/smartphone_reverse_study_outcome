package com.bytedance.android.shopping.feed.utils;

import com.bytedance.android.ec.core.utils.s0;
import com.bytedance.android.shopping.feed.event.j1;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class r {
    public static long a;
    public static final a b = null;

    public static final class a implements ti.j {
        public a() {
        }

        public final void a(JSONObject r6) {
            Intrinsics.checkNotNullParameter(r6, "params");
            String r7 = r6.optString("status");
            if (Intrinsics.areEqual(r7, "success") == true) goto L5;
        L7:
            dm.a.a("marketing_card").i("on receive js event, status = " + r7);
            return;
        L5:
            if ((System.currentTimeMillis() - r.a) <= 5000) goto L7;
            s0.a(new j1());
            r.a = System.currentTimeMillis();
            goto L7
        }
    }

    static {
        b = new a();
    }
}
