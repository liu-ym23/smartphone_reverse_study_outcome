package com.bytedance.ee.bear.document.ssr;

import com.bytedance.ee.bear.contract.AccountService$Account;
import java.util.Map;
import k25.e0;
import k25.m0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class c {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static String a(AccountService$Account r1, String r2, String r3, Map r4) {
        Intrinsics.checkNotNullParameter(r2, "token");
        Intrinsics.checkNotNullParameter(r3, "type");
        Intrinsics.checkNotNullParameter(r4, "queries");
        m0 r5 = e0.m().o(r1, r2, r3, r4);
        if (r5 != null) goto L7;
        return null;
    L7:
        return r5.c;
    }

    public static String b(AccountService$Account r2, String r3, String r4, Map r5) {
        Intrinsics.checkNotNullParameter(r3, "token");
        Intrinsics.checkNotNullParameter(r4, "type");
        Intrinsics.checkNotNullParameter(r5, "queries");
        Intrinsics.checkNotNullParameter(r4, "type");
        Intrinsics.checkNotNullParameter(r5, "queries");
        String r6 = n35.a.b(r2, r4, r5);
        return e0.m().n(r6, r3).c;
    }
}
