package com.larus.im.internal.tracking.network;

/* JADX INFO: loaded from: classes30.dex */
public final class t {
    public static final Long a(Long r100) {
        if (r100 != null) goto L4;
    L9:
        return null;
    L4:
        if (r100.longValue() < 0) goto L6;
        boolean r101 = true;
    L7:
        if (r101 == false) goto L9;
        return r100;
    L6:
        r101 = false;
        goto L7
    }
}
