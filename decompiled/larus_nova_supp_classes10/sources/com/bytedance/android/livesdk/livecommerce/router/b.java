package com.bytedance.android.livesdk.livecommerce.router;

import android.content.Context;
import android.net.Uri;
import el2.j;
import kotlin.jvm.internal.Intrinsics;
import sg2.s;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class b implements bf.c {
    public b() {
    }

    public final void a() {
    }

    public final String b() {
        return "shopping/playback";
    }

    public final boolean c(Context r3, Uri r4, boolean r5) {
        Intrinsics.checkNotNullParameter(r3, "context");
        Intrinsics.checkNotNullParameter(r4, "uri");
        s r0 = s.d;
        Boolean r6 = Boolean.valueOf(r5);
        if (r0.a != null) goto L5;
        r0.l();
    L5:
        j r1 = r0.a;
        if (r1 == null) goto L10;
        r6.booleanValue();
        r1.a(r3, r4);
        return true;
    L10:
        return true;
    }
}
