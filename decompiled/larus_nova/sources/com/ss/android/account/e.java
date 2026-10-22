package com.ss.android.account;

/* JADX INFO: loaded from: classes5.dex */
public final class e {
    public static xqa.b a() {
        com.larus.account.saas.core.internal.init.d r100 = k.d().b();
        if (r100 == null) goto L7;
        k.d().getApplicationContext();
        return r100;
    L7:
        throw new RuntimeException("please provide IBdTruing implementation");
    }
}
