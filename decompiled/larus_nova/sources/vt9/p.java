package vt9;

import com.larus.common.apphost.AppHost;

/* JADX INFO: loaded from: classes.dex */
public final class p {
    public p() {
    }

    public static o a() {
        if (AppHost.f326268a.isOversea() == false) goto L5;
        Boolean r100 = Boolean.FALSE;
        return new o(r100, r100, r100, 524280);
    L5:
        Boolean r101 = Boolean.TRUE;
        return new o(r101, Boolean.FALSE, r101, 524280);
    }
}
