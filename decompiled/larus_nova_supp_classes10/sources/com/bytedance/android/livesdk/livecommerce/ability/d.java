package com.bytedance.android.livesdk.livecommerce.ability;

import android.content.Context;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public abstract class d<T> implements h {
    public d() {
    }

    public abstract void a(Context r1, T r2, Object r3, il2.a r4, e r5);

    /* JADX WARN: Multi-variable type inference failed */
    public final void b(e r3, String r4) {
        Intrinsics.checkNotNullParameter(r4, "msg");
        if (r3 == null) goto L5;
        e.a.a(r3, 0, r4, 1);
    L5:
        ((tg2.b) this).logE(r4);
    }
}
