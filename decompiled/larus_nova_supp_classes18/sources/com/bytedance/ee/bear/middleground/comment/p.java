package com.bytedance.ee.bear.middleground.comment;

import com.bytedance.ee.bear.contract.AccountService;
import com.bytedance.ee.bear.contract.b0;
import com.bytedance.ee.bear.contract.h0;
import com.bytedance.ee.bear.contract.i0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class p {
    public static String a() {
        AccountService.Account r0 = ((h0) org.koin.java.a.a(h0.class)).G2();
        if (r0 != null) goto L5;
        return "";
    L5:
        return r0.uid;
    }

    public static String b() {
        AccountService.Account r0 = ((h0) org.koin.java.a.a(h0.class)).G2();
        if (r0 != null) goto L5;
        return "";
    L5:
        return r0.localizedName(((i0) org.koin.java.a.a(i0.class)).c());
    }

    public static boolean c() {
        return ((b0) org.koin.java.a.a(b0.class)).b();
    }

    public p() {
    }
}
