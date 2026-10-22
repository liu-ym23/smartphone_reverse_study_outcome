package com.bytedance.android.livesdk.livecommerce.promotion.card.utils;

import com.bytedance.android.ec.core.opt.asyncInflate.ShoppingAsyncInflater;
import com.bytedance.android.ec.opt.asyncInflate.AsyncInflaterImpl;
import java.util.LinkedList;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class g {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static boolean a(ShoppingAsyncInflater r3, com.bytedance.android.ec.opt.asyncInflate.d r4, int r5, int r6) {
        AsyncInflaterImpl r7 = r3.a;
        if (r7 == null) goto L14;
        LinkedList r8 = (LinkedList) r7.a.get(Integer.valueOf(r5));
        if (r8 == null) goto L13;
        monitor-enter(r8);
        int r2 = r8.size();     // Catch: Throwable -> L10
        monitor-exit(r8);
    L15:
        if (r2 >= r6) goto L18;
        r4.a(r5, r6 - r2);
        return true;
    L18:
        return false;
    L10:
        th = move-exception;
        throw th;
    L13:
        r2 = 0;
        goto L15
    L14:
        r2 = 1;
        goto L15
    }
}
