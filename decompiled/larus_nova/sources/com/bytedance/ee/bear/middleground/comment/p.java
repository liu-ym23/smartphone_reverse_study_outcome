package com.bytedance.ee.bear.middleground.comment;

import com.bytedance.ee.bear.contract.AccountService$Account;
import com.bytedance.ee.bear.contract.b0;
import com.bytedance.ee.bear.contract.h0;
import com.bytedance.ee.bear.contract.i0;

/* JADX INFO: loaded from: classes18.dex */
public final class p {
    public static String a() {
        AccountService$Account r100 = ((h0) org.koin.java.a.a(h0.class)).G2();
        if (r100 != null) goto L5;
        return "";
    L5:
        return r100.uid;
    }

    public static String b() {
        AccountService$Account r100 = ((h0) org.koin.java.a.a(h0.class)).G2();
        if (r100 != null) goto L5;
        return "";
    L5:
        return r100.localizedName(((i0) org.koin.java.a.a(i0.class)).c());
    }

    public static boolean c() {
        return ((b0) org.koin.java.a.a(b0.class)).b();
    }

    public p() {
    }
}
