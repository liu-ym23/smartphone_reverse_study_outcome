package com.bytedance.android.livesdk.livecommerce.intro.manager;

import android.util.SparseArray;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class j implements ti.j {
    public final /* synthetic */ i a;

    public j(i r1) {
        this.a = r1;
    }

    public final void a(JSONObject r5) {
        Intrinsics.checkNotNullParameter(r5, "params");
        SparseArray<com.bytedance.android.livesdk.livecommerce.intro.controller.b> r0 = this.a.d;
        int r1 = r0.size();
        int r2 = 0;
    L3:
        if (r2 >= r1) goto L5;
        r0.keyAt(r2);
        r0.valueAt(r2).a(r5);
        r2 = r2 + 1;
        goto L3
    }
}
