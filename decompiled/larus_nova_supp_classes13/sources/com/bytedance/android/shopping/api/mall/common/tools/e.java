package com.bytedance.android.shopping.api.mall.common.tools;

import com.bytedance.services.apm.api.EnsureManager;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class e {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static String a(String r7) {
        int r1 = 1;
        if (r7 != null) goto L30;
    L10:
        boolean r3 = true;
    L11:
        if (r3 == false) goto L13;
        return r7;
    L13:
        boolean r4 = StringsKt.startsWith$default(r7, "#", false, 2, null);     // Catch: Exception -> L8
        if (r4 == false) goto L18;
        if (r7.length() > 7) goto L18;
    L19:
        return r7;
    L18:
        if (r7.length() <= 6) goto L19;
        if (r4 == true) goto L23;
        r1 = 0;
    L23:
        int r5 = r1 + 8;     // Catch: Exception -> L8
        if (r7.length() == r5) goto L26;
        return r7;
    L26:
        int r6 = r1 + 2;     // Catch: Exception -> L8
        String r2 = r7.substring(r1 + 0, r6);     // Catch: Exception -> L8
        int r8 = r1 + 4;     // Catch: Exception -> L8
        String r9 = r7.substring(r6, r8);     // Catch: Exception -> L8
        int r10 = r1 + 6;     // Catch: Exception -> L8
        String r11 = r7.substring(r8, r10);     // Catch: Exception -> L8
        return "#" + r7.substring(r10, r5) + r2 + r9 + r11;
    L8:
        e = move-exception;
        EnsureManager.ensureNotReachHere(e);
        return r7;
    L30:
        if (r7.length() == 0) goto L10;
        r3 = false;
        goto L11
    }
}
