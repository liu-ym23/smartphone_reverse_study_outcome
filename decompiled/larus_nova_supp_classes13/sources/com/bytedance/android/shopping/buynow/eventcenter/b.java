package com.bytedance.android.shopping.buynow.eventcenter;

import com.bytedance.android.shopping.anchorv4.event.c;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
import ti.j;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class b implements j {
    public final /* synthetic */ c a;

    public b(c r1) {
        this.a = r1;
    }

    public final void a(JSONObject r2) {
        Intrinsics.checkNotNullParameter(r2, "params");
        Function1 r0 = this.a.b;
        if (r0 == null) goto L6;
        Unit r3 = (Unit) r0.invoke(r2);
        return;
    }
}
