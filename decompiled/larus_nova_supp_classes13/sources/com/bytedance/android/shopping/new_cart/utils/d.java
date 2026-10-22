package com.bytedance.android.shopping.new_cart.utils;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class d extends Handler {
    public d(Looper r2) {
        Intrinsics.checkNotNullParameter(r2, "looper");
        super(r2);
    }

    @Override // android.os.Handler
    public final void handleMessage(Message r5) {
        Intrinsics.checkNotNullParameter(r5, "msg");
        super.handleMessage(r5);     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        bg3.a r0 = a.a;
        StringBuilder r1 = new StringBuilder();
        r1.append(String.valueOf(e.getMessage()));
        r1.append(", ");
        Throwable r2 = e.getCause();
        if (r2 == null) goto L9;
        String r3 = r2.getMessage();
    L10:
        r1.append(r3);
        r1.append(", ");
        r1.append(e.getClass().getName());
        a.j("CartHandler error", r1.toString(), null, 12);
        return;
    L9:
        r3 = null;
        goto L10
    }
}
