package com.bytedance.android.shopping.store.tabkit.ssr;

import java.security.MessageDigest;
import kotlin.Result;
import kotlin.ResultKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class a {
    static {
    }

    public static String a(byte[] r7) {
        Object r0 = null;
        if (r7 != null) goto L21;
        return null;
    L21:
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L13
        byte[] r8 = MessageDigest.getInstance("SHA-256").digest(r7);     // Catch: Throwable -> L13
        StringBuilder r2 = new StringBuilder();     // Catch: Throwable -> L13
        int r3 = r8.length;     // Catch: Throwable -> L13
        int r4 = 0;
    L6:
        if (r4 >= r3) goto L11;
        String r5 = Integer.toHexString(r8[r4] & 255);     // Catch: Throwable -> L13
        if (r5.length() != 1) goto L10;
        r2.append('0');     // Catch: Throwable -> L13
    L10:
        r2.append(r5);     // Catch: Throwable -> L13
        r4 = r4 + 1;     // Catch: Throwable -> L13
        goto L6
    L11:
        Object r9 = Result.constructor-impl(r2.toString());     // Catch: Throwable -> L13
    L16:
        if (Result.isFailure-impl(r9) == true) goto L20;
        r0 = r9;
    L20:
        return (String) r0;
    L13:
        th = move-exception;
        Result.Companion r6 = Result.Companion;
        r9 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L16
    }
}
