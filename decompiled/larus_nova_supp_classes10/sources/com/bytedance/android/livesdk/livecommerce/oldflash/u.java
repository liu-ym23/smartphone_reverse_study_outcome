package com.bytedance.android.livesdk.livecommerce.oldflash;

import android.content.Context;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class u implements n {
    public final /* synthetic */ LiveFlashNewFragment a;

    public u(LiveFlashNewFragment r1) {
        this.a = r1;
    }

    @Override // com.bytedance.android.livesdk.livecommerce.oldflash.n
    public final String a(String r3, int r4) {
        Intrinsics.checkNotNullParameter(r3, "label");
        Context r5 = this.a.getContext();
        if (r5 == null) goto L5;
        si2.i r0 = s.s;
        String r6 = th.a.h(r5, 2131896583, new Object[]{Integer.valueOf(s.d.d()), Integer.valueOf(s.d.c())});
    L6:
        if (r6 != null) goto L9;
        return "";
    L9:
        return r6;
    L5:
        r6 = null;
        goto L6
    }
}
