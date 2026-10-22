package ui5;

import com.bytedance.ee.bear.contract.AccountService;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class c {
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

    public static boolean b(AccountService.Account r0) {
        if (r0 != null) goto L4;
    L7:
        return true;
    L4:
        if (r0.isConsumer() == true) goto L7;
        return false;
    }
}
