package com.bytedance.android.livesdk.livecommerce.oldflash;

import android.content.Context;
import com.bytedance.bdlocation.exception.BDLocationException;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class i extends k {
    public i(String r3) {
        Intrinsics.checkNotNullParameter(r3, "label");
        Intrinsics.checkNotNullParameter(BDLocationException.ERROR_TIMEOUT, "hint");
        super(r3, BDLocationException.ERROR_TIMEOUT, true);
    }

    @Override // com.bytedance.android.livesdk.livecommerce.oldflash.k
    public final String c(Context r4) {
        if (r4 == null) goto L4;
        String r5 = th.a.h(r4, 2131896611, new Object[]{Integer.valueOf(this.i)});
    L5:
        if (r5 != null) goto L8;
        return "";
    L8:
        return r5;
    L4:
        r5 = null;
        goto L5
    }
}
