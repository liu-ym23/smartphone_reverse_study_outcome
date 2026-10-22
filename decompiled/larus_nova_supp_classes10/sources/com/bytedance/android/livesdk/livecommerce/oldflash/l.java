package com.bytedance.android.livesdk.livecommerce.oldflash;

import android.content.Context;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class l extends c implements m {
    public String c;
    public String d;
    public m e;

    @Override // com.bytedance.android.livesdk.livecommerce.oldflash.m
    public final boolean a() {
        m r0 = this.e;
        if (r0 != null) goto L7;
        return true;
    L7:
        return r0.a();
    }

    public l(String r2) {
        Intrinsics.checkNotNullParameter(r2, "label");
        super(r2);
    }

    @Override // com.bytedance.android.livesdk.livecommerce.oldflash.m
    public final String b(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        m r0 = this.e;
        if (r0 == null) goto L6;
        String r3 = r0.b(r2);
        if (r3 == null) goto L6;
        return r3;
    L6:
        return "";
    }
}
