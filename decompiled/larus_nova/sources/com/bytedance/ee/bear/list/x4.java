package com.bytedance.ee.bear.list;

import com.bytedance.ee.bear.contract.AccountService$Account;

/* JADX INFO: loaded from: classes18.dex */
public final class x4 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f229847a = 0;

    static {
    }

    public static boolean a(AccountService$Account r100) {
        if (r100 != null) goto L4;
    L6:
        return false;
    L4:
        if (r100.isConsumer() == true) goto L6;
        return true;
    }
}
