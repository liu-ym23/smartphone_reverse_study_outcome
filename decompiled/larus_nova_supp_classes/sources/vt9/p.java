package vt9;

import com.larus.common.apphost.AppHost;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes.dex */
public final class p {
    public p() {
    }

    public static o a() {
        if (AppHost.a.isOversea() == false) goto L5;
        Boolean r2 = Boolean.FALSE;
        return new o(r2, r2, r2, 524280);
    L5:
        Boolean r3 = Boolean.TRUE;
        return new o(r3, Boolean.FALSE, r3, 524280);
    }
}
