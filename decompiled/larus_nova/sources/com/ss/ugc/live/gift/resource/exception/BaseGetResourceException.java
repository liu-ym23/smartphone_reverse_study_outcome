package com.ss.ugc.live.gift.resource.exception;

import qlc.a;

/* JADX INFO: loaded from: classes36.dex */
public class BaseGetResourceException extends RuntimeException {
    private a mRequest;

    public a getResourceRequest() {
        return null;
    }

    @Override // java.lang.Throwable
    public String getMessage() {
        throw null;
    }

    @Override // java.lang.Throwable
    public String toString() {
        String r100 = super.toString();
        Throwable r101 = getCause();
        if (r101 == null) goto L7;
        if (r101 != this) goto L6;
        return r100;
    L6:
        return r100 + "\n" + r101.toString();
    L7:
        return r100;
    }

    public long getId() {
        throw null;
    }

    public BaseGetResourceException(a r100) {
    }

    public BaseGetResourceException(String r100, a r101) {
        super(r100);
    }

    public BaseGetResourceException(String r100, Throwable r101, a r102) {
        super(r100, r101);
    }
}
