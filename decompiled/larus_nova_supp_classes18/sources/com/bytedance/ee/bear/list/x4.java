package com.bytedance.ee.bear.list;

import com.bytedance.ee.bear.contract.AccountService;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class x4 {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static boolean a(AccountService.Account r0) {
        if (r0 != null) goto L4;
    L6:
        return false;
    L4:
        if (r0.isConsumer() == true) goto L6;
        return true;
    }
}
